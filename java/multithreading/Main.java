package multithreading;

public class Main {

    static SecondThread mSecondThread;

    public static void main(String[] args) {
     /*   //Создание потока
        Thread myThready = new Thread(new Runnable() {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                System.out.println("Привет из побочного потока!");
            }
        });
        myThready.start();    //Запуск потока

        System.out.println("Главный поток завершён...");*/

        mSecondThread = new SecondThread();    //Создание потока
        mSecondThread.start();                    //Запуск потока

        System.out.println("Главный поток завершён...");

    }
}