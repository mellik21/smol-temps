package Multithreading;

public class SecondThread extends Thread {
    @Override
    public void run()    //Этот метод будет выполнен в побочном потоке
    {
        System.out.println("Привет из побочного потока!");
    }
}

