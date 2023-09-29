package Uebungsblatt04;

public class Main {
    public static void main(String[] args) {

        Room livingroom = new Room("Livingroom", "Just a normal livingroom.");

        Room bathroom = new Room("Bathroom", "The bathroom. Not really interesting.");

        Room kitchen = new Room("Kitchen", "the kitchen");

        Room hallway = new Room("Hallway", "The one and only hallway.");

        Room bedroom = new Room("Bedroom", "This is your bedroom");

        Door door1 = new Door(false);
        Door door2 = new Door(true);
        Door door3 = new Door(false);
        Door door4 = new Door(true);

        Wall wall1 = new Wall();
        Wall wall2 = new Wall();
        Wall wall3 = new Wall();
        Wall wall4 = new Wall();
        Wall wall5 = new Wall();
        Wall wall6 = new Wall();
        Wall wall7 = new Wall();


        livingroom.setSide(Direction.north, door2);
        livingroom.setSide(Direction.east, door1);
        livingroom.setSide(Direction.south, wall1);
        livingroom.setSide(Direction.west, wall2);

        bathroom.setSide(Direction.north, door4);
        bathroom.setSide(Direction.east, null);
        bathroom.setSide(Direction.south, null);
        bathroom.setSide(Direction.west, door1);

        bedroom.setSide(Direction.north, wall4);
        bedroom.setSide(Direction.east, door3);
        bedroom.setSide(Direction.south, wall3);
        bedroom.setSide(Direction.west, null);

        kitchen.setSide(Direction.north, wall5);
        kitchen.setSide(Direction.east, hallway);
        kitchen.setSide(Direction.south, door2);
        kitchen.setSide(Direction.west, door3);

        hallway.setSide(Direction.north, wall6);
        hallway.setSide(Direction.east, null);
        hallway.setSide(Direction.south, door4);
        hallway.setSide(Direction.west, kitchen);

        door1.setSide(Direction.frontside, bathroom);
        door1.setSide(Direction.backside, livingroom);

        door2.setSide(Direction.frontside, kitchen);
        door2.setSide(Direction.backside, livingroom);

        door3.setSide(Direction.frontside, kitchen);
        door3.setSide(Direction.backside, bedroom);

        door4.setSide(Direction.frontside, hallway);
        door4.setSide(Direction.backside, bathroom);

        Player nina = new Player("Nina", livingroom);
        Player clara = new Player("Dennis", bathroom);
        Player dennis = new Player("Clara", hallway);

        Item sofa = new Item("Sofa", livingroom);
        Item book = new Item("Book", livingroom);
        Item soap = new Item ("Soap", bathroom);
        Item towel = new Item("Towel", bathroom);
        Item fork = new Item("Fork", kitchen);

        Playground playground = new Playground();
        playground.addField(livingroom);
        playground.addField(bathroom);
        playground.addField(kitchen);
        playground.addField(hallway);
        playground.addField(door1);
        playground.addField(door2);
        playground.addField(door3);
        playground.addField(door4);
        playground.addField(wall1);
        playground.addField(wall2);
        playground.addField(wall3);
        playground.addField(wall4);
        playground.addField(wall5);
        playground.addField(wall6);

        playground.addPlayer(nina);
        playground.addPlayer(dennis);
        playground.addPlayer(clara);

        playground.addItem(sofa);
        playground.addItem(book);
        playground.addItem(soap);
        playground.addItem(towel);
        playground.addItem(fork);

        nina.scan(playground);
    }
}
