package multithreading;

class Incremenator extends Thread {
    /*
    значение переменной, объявленной без volatile, может кэшироваться отдельно для каждого потока,
     и значение из этого кэша может различаться для каждого из них.
     Объявление переменной с ключевым словом volatile отключает для неё такое кэширование
     и все запросы к переменной будут направляться непосредственно в память.
     */
    private volatile boolean mIsIncrement = true;

    public void changeAction()    //Меняет действие на противоположное
    {
        mIsIncrement = !mIsIncrement;
    }

    @Override
    public void run() {
        do {
            if (!Thread.interrupted())    //Проверка прерывания
            {
                if (mIsIncrement) IncremenatorsProblem.mValue++;
                else IncremenatorsProblem.mValue--;
                //Вывод текущего значения переменной
                System.out.print(IncremenatorsProblem.mValue + " ");
            } else
                return;        //Завершение потока

            try {
                Thread.sleep(1000);        //Приостановка потока на 1 сек.
            } catch (InterruptedException e) {
                return;    //Завершение потока после прерывания
            }
        }
        while (true);
    }
}

public class IncremenatorsProblem {
    //Переменая, которой оперирует инкременатор
    public static int mValue = 0;

    static Incremenator mInc;    //Объект побочного потока

    public static void main(String[] args) {
        mInc = new Incremenator();    //Создание потока

        System.out.print("Значение = ");

        mInc.start();    //Запуск потока

        //Троекратное изменение действия инкременатора
        //с интервалом в i*2 секунд
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(i * 2 * 1000); //Ожидание в течении i*2 сек.
            } catch (InterruptedException e) {
            }

            mInc.changeAction();    //Переключение действия
        }

        mInc.interrupt();    //Прерывание побочного потока
    }
}