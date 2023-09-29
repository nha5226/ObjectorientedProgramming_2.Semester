//Nina Hartmann

import java.util.Arrays;

public class Auswertung {

    private static final int DEFAULT_STACKSIZE = 9;
    private int[] _values;
    private int _sp;

    public Auswertung() {
        this(DEFAULT_STACKSIZE);
    }

    public Auswertung(int stacksize) {
        _values = new int[stacksize];
    }

    /**
     * Pushes the given value onto the stack.
     * NOTE: Throws an ArrayIndexOutOfBoundsException if the stack is full!
     * @param value
     */
    public void push(int value) {
        _values[_sp++] = value;
    }

    public int pop() {
        return _values[--_sp];
    }

    public int top() {
        return _values[_sp-1];
    }

    public void take(int nValue) {
        _values[_sp-1] = nValue;
    }

    public boolean isEmpty() {
        return (_sp <= 0);
    }

    public boolean isFull() {
        return (_sp >= _values.length);
    }


    @Override
    public String toString() {
        String s = "Stack: sp = " + _sp;
        for (int i = 0; i < _sp; i += 1) {
            s = s + _values[i] + ", ";
        }
        return "Stack [_values=" + Arrays.toString(_values) + ", _sp=" + _sp + "]";
    }

    public static void main(String[] args) {
        System.out.println("Auswertung von Postfix-Ausdrücken\n");
        Auswertung auswer = new Auswertung();


        String strEing = "234 435 56 + 26 25 - 22 44 12 + 10 2 / 30 5 * 99;";
        System.out.println("Arithmetische Ausdrücke: " + strEing);

        int len = strEing.length();
        char[] tempStrEingabe = new char[len];
        for (int i = 0; i < len; i++) {
            tempStrEingabe[i] =
                    strEing.charAt(i);
        }

        int input = 0;
        int input2 = 0;
        for (int i = 0; i < len; i+=1) {

            if(tempStrEingabe[i] != ' ' && tempStrEingabe[i] != ';') {

                int get=Character.getNumericValue(tempStrEingabe[i]);
                int a = get;
                input = (input*10) + a;

            }

            else if(tempStrEingabe[i] == ' ' && tempStrEingabe[i+1] != '+' && tempStrEingabe[i+1] != '-' && tempStrEingabe[i+1] != '/' && tempStrEingabe[i+1] != '*') {
                auswer.push(input);
                input2 = input;
                input = 0;

            }

            else if(tempStrEingabe[i] == ';') {

                auswer.push(input);
                input2 = input;
                input = 0;

            }

            else if(tempStrEingabe[i+1] == '+'){
                int add = 0;
                add = input + input2;
                auswer.take(add);

                i = i + 2;
                input = 0;
                input2 = 0;
            }

            else if(tempStrEingabe[i+1] == '-'){

                int sub = 0;
                sub = input2 - input;
                auswer.take(sub);

                i = i + 2;
                input = 0;
                input2 = 0;
            }

            else if(tempStrEingabe[i+1] == '/'){

                int div = 0;
                div = input2 / input;
                auswer.take(div);

                i = i + 2;
                input = 0;
                input2 = 0;
            }

            else if(tempStrEingabe[i+1] == '*'){

                int mult = 0;
                mult = input2 * input;
                auswer.take(mult);

                i = i + 2;
                input = 0;
                input2 = 0;
            }

        }

        System.out.println(auswer);
    }
}