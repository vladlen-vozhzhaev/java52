public class ThreadingTest {
    public static void main(String[] args) {
        /*MyThread thread1 = new MyThread("task#1");
        MyThread thread2 = new MyThread("task#2");
        MyThread thread3 = new MyThread("task#3");
        thread1.start();
        thread2.start();
        thread3.start();*/
        /*Thread thread1 = new Thread(new MyRunnableClass("task#1"));
        Thread thread2 = new Thread(new MyRunnableClass("task#2"));
        Thread thread3 = new Thread(new MyRunnableClass("task#3"));
        thread1.start();
        thread2.start();
        thread3.start();*/

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    System.out.println("task#1 - "+i+"%");
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    System.out.println("task#2 - "+i+"%");
                }
            }
        });
        Thread thread3 = new Thread(()->{
            for (int i = 0; i <= 100; i++) {
                System.out.println("task#3 - "+i+"%");
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class MyRunnableClass implements Runnable{
    private String task;
    public MyRunnableClass(String task) {
        this.task = task;
    }

    @Override
    public void run(){
        for (int i = 0; i <= 100; i++) {
            System.out.println(task+" - "+i+"%");
        }
    }
}

class MyThread extends Thread{
    private String task;
    public MyThread(String task) {
        this.task = task;
    }
    @Override
    public void run(){
        for (int i = 0; i <= 100; i++) {
            System.out.println(task+" - "+i+"%");
        }
    }
}