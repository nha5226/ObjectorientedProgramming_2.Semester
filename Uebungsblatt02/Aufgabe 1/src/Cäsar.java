//Nina Hartmann

public class Cäsar {


        public static void main(String[] args) {
            String Eingabe = "Ich fahre nach Lichtenstein!";
            int shift = 3;

            String vertext = encode(Eingabe, shift);
            String text = decode(vertext, shift);

            System.out.println("Unverschlüsselter Text: " + text);
            System.out.println("Verschlüsselter Text: " + vertext);
        }


        public static String encode(String text, int key){
            String vertext = "";
            for(int i=0; i<text.length(); i++){
                char next = text.charAt(i);
                vertext = vertext + shift(next, key);
            }
            return vertext;
        }

        public static char shift(char letter, int shift){
            if(letter>='a' && letter <='z'){
                letter += shift;
                while(letter > 'z'){
                    letter -= 26;
                }
            }
            if(letter>='A' && letter <='Z'){
                letter += shift;
                while(letter > 'Z'){
                    letter -= 26;
                }
            }
            return letter;
        }

        public static String decode(String vertext, int shift){
            String decoded = "";
            for(int i=0; i<vertext.length(); i++){
                char next = vertext.charAt(i);
                decoded = decoded + shift(next, 26-shift);
            }
            return decoded;
        }

}
