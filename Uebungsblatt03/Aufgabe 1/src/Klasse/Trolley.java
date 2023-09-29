package Klasse;

import java.util.LinkedList;
import java.util.List;

public class Trolley{

    private List<Produkt> _products;
    private double _maxWeight;
    private int _top;
    private Feld _Feldakt;

    public Trolley(double maxWeight) {
        _maxWeight = maxWeight;
        if (_maxWeight < 0) {
            _maxWeight = 0;
        }
        _products = new LinkedList<>();
        _top = 0;
    }

    public double getCurrentLoadWeight() {
        double weight = 0;
        for (int i = 0; i < _top; i++) {
            Produkt p = _products.get(i);
            weight = weight + p.getWeight();
        }
        return weight;
    }

    public void LadeProduktAktFeld(){
        List<Produkt> produkteakt = _Feldakt.getProdukte();

        for (Produkt produkt: produkteakt) {
            if(_products.isEmpty()){
                load(produkt);
            } else {
                if(_products.get(0).getZiel().equals(produkt.getZiel())){
                    load(produkt);
                }
            }
        }
    }

    public boolean load(Produkt p) {
        double currentWeight = getCurrentLoadWeight();
        if (currentWeight + p.getWeight() <= _maxWeight) {
            _products.add(p);
            _top++;

            _Feldakt.rmProdukt(p);

            return true;
        }
        return false;
    }

    public List<Produkt> allesabladen() {
        List<Produkt> produkts = listAlleProdukte();

        _products.clear();

        return produkts;
    }

    public List<Produkt> listAlleProdukte() {
        return new LinkedList<>(_products);
    }

    public Produkt[] listLoadedProducts() {
        Produkt[] products = copyLoadedProducts();
        return products;
    }

    private Produkt[] copyLoadedProducts() {
        Produkt[] products = new Produkt[_top];
        for (int i = 0; i < _top; i++) {
            products[i] = _products.get(i);
        }
        return products;
    }

    public void abladenAF(){
        _Feldakt = _products.get(0).getZiel();

        for (Produkt produkt: _products) {
            System.out.println(produkt);
        }

        _Feldakt.addProdukt(allesabladen());
    }

    public void setFeldakt(Feld feldakt) {
        _Feldakt = feldakt;
    }

    public Feld getFeldakt() {
        return _Feldakt;
    }

}
