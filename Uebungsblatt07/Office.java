package programming.ue.UE7;

public class Office {
    private int waitingNumber = 1;
    private int givenNumber = 1;
    private boolean occupied;
    private final Object lock = new Object();

    public int register(int condition) {
        synchronized (lock) {

            try {
                Thread.sleep(5000 + (int) (Math.random() * 7000));
            } catch (InterruptedException e) {
            }
            //Time to register around 5 and 10 sek
            return waitingNumber++;
        }
    }

    public synchronized void enter(int number) {
        while (number != givenNumber || occupied) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        occupied = true;
        givenNumber++;
    }

    public synchronized void leave() {
        occupied = false;
        notifyAll(); //
    }
}