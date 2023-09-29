package programming.ue.UE7;

import java.util.Random;

public class Client extends Thread {
    private Office room;

    public Client(Office room) {
        this.room = room;
        start();
    }

    public void run() {
        Random random = new Random();

        int rand = 0;
        while (true){
            rand = random.nextInt(3);
            if(rand !=0) break;
        }

        int number = room.register(rand);
        System.out.println("Client gets the number " + number);


        // if the client is well awaken and ready to go takes between 10 and 20 sec
        if(rand == 0){

            room.enter(number);
            System.out.println("Client " + number + ": enters Office");

            try {
                Thread.sleep(10000 + (int) (Math.random() * 11000));
            } catch (InterruptedException e) {
            }
        }else if (rand == 1) {
            //if the client is tired
            System.out.println("Client fell asleep");
            try {

                Thread.sleep(10000 + (int) (Math.random() * 11000));
            } catch (InterruptedException e) {
            }

            room.enter(number);
            System.out.println("Client " + number + ": enters Office");

            try {
                Thread.sleep(10000 + (int) (Math.random() * 11000));
            } catch (InterruptedException e) {
            }

        }else {
            //if the client is in a important call
            System.out.println("Client is in a important call at the moment");

            try {

                Thread.sleep(13000 + (int) (Math.random() * 11000));
            } catch (InterruptedException e) {
            }

            room.enter(number);
            System.out.println("Client " + number + ": enters Office");

            try {
                Thread.sleep(10000 + (int) (Math.random() * 11000));
            } catch (InterruptedException e) {
            }
        }


        System.out.println("Client " + number + ": leaves Office");
        room.leave();
    }
}