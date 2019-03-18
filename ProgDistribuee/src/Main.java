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
                i--;
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
                i++;
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
    private int i;
    private static Thread thread1 = null;
    private static Thread thread2 = null;

    public static void Main(){
         i=65;
         thread1 = new Thread(new decremente(i), "thread1");
         thread2 = new Thread(new incremente(i), "thread2");
    }

    public static void main(String[] args) {
// TODO code application logic here
       
        Main();
        
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        
        System.out.println("Valeur de i : "+ i);
        
        System.exit(0);

    }
}
