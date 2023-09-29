package Uebungsblatt04;

public class Item {
    private String _name;
    private Room _position;

    public Item (String name, Room position){
        _name = name;
        _position = position;
    }

    public Room get_position() {
        return _position;
    }

    public String get_name(){
        return _name;
    }
}
