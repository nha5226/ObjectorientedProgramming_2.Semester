package Klasse;

public class Produkt{

        private final String _name;
        private final double _weight;
        private Feld Ziel;

        public Produkt(String name, double weight) {
            _name = name;
            _weight = weight;
        }

        public String getName() {
            return _name;
        }

        public double getWeight() {
            return _weight;
        }

        public Feld getZiel() {
            return Ziel;
        }

        public void setZiel(Feld ziel) {
            Ziel = ziel;
    }

}