package Uebungsblatt06;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        // Without try-with-resources -> close must be handled in finally block
        FileInputStream fin = null;
            try (BufferedReader in = new BufferedReader(new CaesarReader(new FileReader("poem.txt")))) {
                String line = in.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = in.readLine();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
        }
    }
}
