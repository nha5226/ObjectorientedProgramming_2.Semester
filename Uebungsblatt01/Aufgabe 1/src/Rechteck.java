public class Rechteck {

    private Punkt linksoben;
    private Punkt rechtsunten;
    private int länge;
    private int höhe;
    public int fläche;
    public int vierhoehe;
    public int vierlaenge;

    public Rechteck(Punkt linksoben, Punkt rechtsunten) {
        this.linksoben = linksoben;
        this.rechtsunten = rechtsunten;

        länge = linksoben.x - rechtsunten.x;
        höhe = linksoben.y - rechtsunten.y;

        if (länge < 0) {
            länge = länge * -1;
        }
        if (höhe < 0) {
            höhe = höhe * -1;
        }

    }

    public int Fläche(){
        fläche = länge * höhe;
        return fläche;
    }

    public boolean Quadratisch(){
        if (länge == höhe){
            return true;
        } else
            return false;
    }

    public void Zoom(int faktor){
        this.länge = länge * faktor;
        this.höhe = höhe * faktor;
    }

    public int Umkreis() {
        int d = länge * (int) Math.sqrt(2)/2;
        return d;
    }

    public Rechteck(int vierhoehe, int vierlaenge) {
        this.vierhoehe = vierhoehe;
        this.vierlaenge = vierlaenge;
    }

    public int neuelänge(){
        int neuelänge = länge / 2;
        return neuelänge;
    }
    public int neuehöhe(){
        int neuehöhe = höhe / 2;
        return neuehöhe;
    }

    public int getLänge() {
        return länge;
    }

    public int getHöhe() {
        return höhe;
    }
}

