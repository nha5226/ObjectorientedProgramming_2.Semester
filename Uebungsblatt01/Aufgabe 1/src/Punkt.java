public class Punkt {

    int x;
    int y;

    public Punkt(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void verschieben(int faktor){
        x = x + faktor;
        y = y + faktor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
