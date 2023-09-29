package Klasse;

import java.util.LinkedList;
import java.util.List;

public class Feld {

    private final int _x;
    private final int _y;
    private List<Produkt> _produkte;

     public Feld(int x, int y) {
        _x = x;
        _y = y;
        _produkte = new LinkedList<>();
     }

     public void addProdukt(Produkt produkt){
         _produkte.add(produkt);
     }

    public void addProdukt(List<Produkt> produkt){
        _produkte.addAll(produkt);
    }

    public List<Produkt> getProdukte() {
        return new LinkedList<>(_produkte);
    }

    public void rmProdukt(Produkt produkt){
         _produkte.remove(produkt);
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

}
