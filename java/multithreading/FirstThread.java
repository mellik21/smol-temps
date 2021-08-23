package multithreading;

//Нечто, реализующее интерфейс Runnable //(содержащее метод run())
public class FirstThread implements Runnable {
    public void run()        //Этот метод будет выполняться в побочном потоке
    {
        System.out.println("Привет из побочного потока!");
    }
}

