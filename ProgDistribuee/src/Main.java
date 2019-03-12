import java.util.concurrent.Semaphore;

class decremente implements Runnable {
    int i;
    decremente(int i) {
        this.i = i;
    }
    public void run() {
        while(1==1) {
            int j = i;
            try {
                Thread.sleep(1000);
                j--;
                // Displaying the thread that is running
                System.out.println(" Decremente " +
                        Thread.currentThread().getId() +
                        " is running \n");
                System.out.println("i a pour valeur " +
                        i +
                        " !!");
            } catch (Exception e) {
                // Throwing an exception
                System.out.println("Exception is caught");
            }
            i = j;
        }

    }

}

class incremente implements Runnable {
    int i;
    incremente(int i) {
        this.i = i;
    }
    public void run() {
        while(1==1) {
            int j = i;
            try {
                Thread.sleep(1000);
                j++;
                // Displaying the thread that is running
                System.out.println(" Incremente  " +
                        Thread.currentThread().getId() +
                        " is running \n");
                System.out.println("i a pour valeur " +
                       i +
                        " !!");
            } catch (Exception e) {
                // Throwing an exception
                System.out.println("Exception is caught");
            }
            i = j;
        }

    }
}






public class Main {

    static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
// TODO code application logic here

        int i=65;

        Thread thread1 = new Thread(new decremente(i), "thread1");
        Thread thread2 = new Thread(new incremente(i), "thread2");
        thread1.start();
        thread2.start();

    }
}
