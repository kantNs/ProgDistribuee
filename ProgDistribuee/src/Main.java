import java.util.concurrent.*;

class memoryShared
{   
	private int i;
    
    //constructeur
    private memoryShared()
    {
    	i = 65;
    }
    
    //getter
    public int getI(){
    	return i;
    }
    //setter
    public void setI(int i){
    	this.i = i;
    }
    
    private static memoryShared Inst = null;
     
    //Unique instance
    public static synchronized memoryShared getInstance()
    {           
        if (Inst == null)
        {   Inst = new memoryShared(); 
        }
        return Inst;
    }
}


class decremente implements Runnable {

    private memoryShared i;	
	
    public decremente(memoryShared i) {
        this.i = i;
    }
    public void run() {
            try {
                int ivalue = i.getI();
                Thread.sleep(1000);
                ivalue--;
                // Displaying the thread that is running
                System.out.println(" Decremente " +
                        Thread.currentThread().getId() +
                        " is running \n");
                System.out.println("i a pour valeur " +
                        i +
                        " !!");
                i.setI(ivalue);
                
            } catch (Exception e) {
                // Throwing an exception
                System.out.println("Exception is caught");
            }
        }

    }



class incremente implements Runnable {

    private memoryShared i;	
	
    public incremente(memoryShared i) {
        this.i = i;
    }
    public void run() {
            try {
                int ivalue = i.getI();
                Thread.sleep(1000);
                ivalue++;
                // Displaying the thread that is running
                System.out.println(" Incremente " +
                        Thread.currentThread().getId() +
                        " is running \n");
                System.out.println("i a pour valeur " +
                        i +
                        " !!");
                i.setI(ivalue);
                
            } catch (Exception e) {
                // Throwing an exception
                System.out.println("Exception is caught");
            }
        }

    }







public class Main {

    private static Thread thread1 = null;
    private static Thread thread2 = null;


    public static void main(String[] args) {
// TODO code application logic here
        memoryShared i= memoryShared.getInstance();
        thread1 = new Thread(new decremente(i), "thread1");
        thread2 = new Thread(new incremente(i), "thread2");
        System.out.println("Valeur de i : "+ i.getI());
        
        thread1.start();
        thread2.start();
        try {
            thread1.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Valeur de i : "+ i.getI());
        
        System.exit(0);

    }
}
