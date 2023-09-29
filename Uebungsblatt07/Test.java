package programming.ue.UE7;

public class Test {
    public static void main(String[] args) {
        Office room = new Office();

        for (int i = 1; i <= 6; i++) {
            new Client(room);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
        }
    }
}