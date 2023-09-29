package Klasse;

import java.util.LinkedList;
import java.util.List;

public class Verteilzentrum {

    private List<List<Feld>> _feld;

    public Verteilzentrum(int X, int Y){
        int x = Math.max(1, X);
        int y = Math.max(1, Y);

        _feld = new LinkedList<>();

        for (int i = 0; i < x; i++) {
            List<Feld> fields = new LinkedList<>();

            for (int j = 0; j < y; j++) {
                fields.add(new Feld(i, j));
            }

            _feld.add(fields);
        }
    }

    public Feld getFeld(int X, int Y){
        return _feld.get(X).get(Y);
    }

}
