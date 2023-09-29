package Uebungsblatt04;

public abstract class Field {
    private String _name;
    private static int _max_nr;
    private int _fieldnr;

    public Field(String name){
        _name = name;
        _max_nr++;
        _fieldnr = _max_nr;
    }

    public String get_name() {
        return _name;
    }

    public int get_fieldnr(){
        return _fieldnr;
    }

    public abstract void enter(Player player, Direction direction);

}
