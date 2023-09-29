//Nina Hartmann

import java.util.HashSet;
import java.util.Random;

public class Password {

    public static void create(int _length, int _students) {

        HashSet<String> h = new HashSet<String>();

        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder password = new StringBuilder(_length);
        String ausgabe;

        for(int j = 0; j < _students; j++) {
            for (int i = 0; i < _length; i++) {
                int index = (int)(chars.length() * Math.random());
                password.append(chars.charAt(index));
            }

            ausgabe = password.toString();
            //h.add(code);

            System.out.println("Password: " + ausgabe);
            password.delete(0, _length);

			/*if(h.contains(code)) {
				System.out.println("Password: " + passwort.toString());
			}else
				h.add(code);*/
        }
    }


    public static void main(String args[]) {

        int _students = 3;
        int _length = 6;
        Password.create(_length, _students);
    }
}


