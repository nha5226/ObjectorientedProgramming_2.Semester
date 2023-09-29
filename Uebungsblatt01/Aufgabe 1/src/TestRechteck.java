public class TestRechteck {

    public static void main(String[] args) {
        Punkt p1 = new Punkt(1,5);
        Punkt p2 = new Punkt(6,1);

        Rechteck r1 = new Rechteck(p1,p2);


        p1.verschieben(10);
        p2.verschieben(10);

        r1.Zoom(1);

        System.out.println("Die Fläche ist: " + r1.getLänge() + " * " + r1.getHöhe() + " = " + r1.Fläche());
        System.out.println("Umkreis: " + r1.Umkreis());
        System.out.println("Quadrat: " + r1.Quadratisch());
        System.out.println("neue Koordinaten vom 1. Punkt:" + " x = " + p1.getX() + ", y = " + p1.getY());
        System.out.println("neue Koordinaten vom 2. Punkt:" + " x = " + p2.getX() + ", y = " + p2.getY());

        System.out.println("Die Länge jedes gleichgroßen Viereckes beträgt: " + r1.neuelänge());
        System.out.println("Die Höhe jedes gleichgroßen Viereckes beträgt: " + r1.neuehöhe());





    }

}
