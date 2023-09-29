import Klasse.Produkt;
import Klasse.Trolley;
import Klasse.Verteilzentrum;
/*
import org.junit.Assert;
import org.junit.Test;
 */

public class TestTrolley {
   //test

    public void test() {

        //befüllen
        Verteilzentrum verteilzentrum = new Verteilzentrum(4, 4);

        Produkt p1 = new Produkt("p1", 4);
        p1.setZiel(verteilzentrum.getFeld(0, 0));
        verteilzentrum.getFeld(1, 3).addProdukt(p1);

        Produkt p2 = new Produkt("p2", 1);
        p2.setZiel(verteilzentrum.getFeld(1, 1));
        verteilzentrum.getFeld(1, 3).addProdukt(p2);

        Produkt p3 = new Produkt("p3", 7);
        p3.setZiel(verteilzentrum.getFeld(2, 2));
        verteilzentrum.getFeld(1, 3).addProdukt(p3);

        Produkt p4 = new Produkt("p4", 3);
        p4.setZiel(verteilzentrum.getFeld(3, 3));
        verteilzentrum.getFeld(1, 1).addProdukt(p4);

        Produkt p5 = new Produkt("p5", 2);
        p5.setZiel(verteilzentrum.getFeld(0, 0));
        verteilzentrum.getFeld(1, 3).addProdukt(p5);

        Trolley trolley = new Trolley(100);
        trolley.setFeldakt(verteilzentrum.getFeld(1, 3));

        trolley.LadeProduktAktFeld();
        trolley.abladenAF();


        Assert.assertArrayEquals(new Produkt[]{p1, p5}, verteilzentrum.getFeld(0, 0).getProdukte().toArray());
    }


}
