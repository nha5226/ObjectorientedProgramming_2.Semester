package Uebungsblatt04;

public class Wall extends Field {

    public Wall() {
        super("Wall");
    }

    public void enter(Player player, Direction direction){
        System.out.println("Ouch, you ran into a wall. Try another direction!");
    }
}
