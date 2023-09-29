package Uebungsblatt04;

import java.util.LinkedList;
import java.util.Scanner;

public class Player {
    private Boolean _exit = false;
    private String _name;
    private Room _position;
    LinkedList<Item> _inventar = new LinkedList<>();

    public Player (String name, Room position){
        _name = name;
        _position = position;
    }

    public String get_name(){
        return _name;
    }

    public Room get_position(){
        return _position;
    }

    public void set_position(Room position) {
        _position = position;
    }

    public LinkedList<Item> get_inventar(){
        return _inventar;
    }

    public void scan(Playground playground){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello " + _name + " do you want to enter the game? If yes, type: 'yes'. " +
                "If no, type: 'no'\n");
        String string = scanner.next();
        while (! (string.equals("yes") || string.equals("no"))){
            System.out.println("Please enter either: 'yes' or: 'no'...");
            string = scanner.next();
        }
        if(string.equals("yes")){
            _position.enter(this, null);
        }
        else if(string.equals("no")){
            playground.exit(this);
            return;
        }

        while(_exit != true){
            whatNow(playground);
        }

    }

    private void whatNow(Playground playground){
        System.out.println("\nWhat do you want to do now?");
        System.out.println("If you want to see your surrounding, type 'S'");
        System.out.println("If you want to see a list of Items, type 'I'.");
        System.out.println("If you want to look in your Inventar type 'X'.");
        System.out.println("If you want to move, type 'M'.");
        System.out.println("If you want to see the other players in your room, type 'P'.");
        System.out.println("If you want to exit, type 'E'.");

        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        while(!(string.equals("S") || string.equals("I") || string.equals("M") || string.equals("P") || string.equals("E") || string.equals("X"))){
            System.out.println("Please enter either 'S', 'I', 'M', 'P', or 'E'");
            string = scanner.next();
        }
        if(string.equals("S")){
            _position.surrounding(this);
        }
        else if(string.equals("I")){
            playground.printItems(_position);
            System.out.println("Do you want to pick up an Item?");
            System.out.println("If yes, type: 'yes'. If no, type: 'no'");
            string = scanner.next();
            if(string.equals("yes")){
                _position.pickUpItem(playground, this);
            }
        }
        else if(string.equals("M")){
            System.out.println("\nIn which direction do you want to move?");
            System.out.println("Type 'N' for North, 'E' for East, 'S' for South or 'W' for West.");
            string = scanner.next();
            while (! (string.equals("N") || string.equals("E") || string.equals("S") || string.equals("W"))){
                System.out.println("please enter either: 'N', 'E', 'S' or 'W' ...");
                string = scanner.next();
            }
            move(string);
        }
        else if(string.equals("P")){
            playground.printOtherPlayers(_position);
        }
        else if(string.equals("X")){
            printInventar();
        }
        else{
            playground.exit(this);
            _exit = true;
        }
    }

    private void move(String direction){

        if(direction.equals("N")){
            Direction d = Direction.north;
            _position.get_north().enter(this, d);
        }
        else if(direction.equals("E")){
            Direction d = Direction.east;
            _position.get_east().enter(this, d);
        }
        else if(direction.equals("S")){
            Direction d = Direction.south;
            _position.get_south().enter(this, d);
        }
        else if(direction.equals("W")){
            Direction d = Direction.west;
            _position.get_west().enter(this, d);
        }
    }

    private void printInventar(){
        System.out.println("Your Inventar:");
        for(int i = 0; i < _inventar.size(); i++){
            System.out.println(i + " :" + _inventar.get(i).get_name());
        }
    }

}
