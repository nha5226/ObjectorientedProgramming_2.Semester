package Uebungsblatt04;

import java.util.HashMap;
import java.util.LinkedList;

public class Playground {

    HashMap <String, Field> _fields = new HashMap<>(); //<Key, Value> = <name, field>
    LinkedList <Player> _players = new LinkedList<>();
    LinkedList <Item> _items = new LinkedList<>();

    public LinkedList<Item> get_items(){
        return _items;
    }

    public void addField(Field field){
        if(_fields.containsValue(field)){
            throw new RuntimeException("This field already exists!");
        }
        else{
            _fields.put(field.get_name(), field);
        }
    }

    public void addPlayer(Player player){
        if(_players.contains(player)){
            throw new RuntimeException("This player already exists!");
        }
        else{
            _players.add(player);
        }
    }

    public void addItem(Item item){
        if(_items.contains(item)){
            throw new RuntimeException("This item already exists!");
        }
        else{
            _items.add(item);
        }
    }

    public void printOtherPlayers(Room room){
        System.out.println("Players in this room:");
        for (int i = 0; i < _players.size(); i++){
            if(_players.get(i).get_position() == room){
                System.out.println(_players.get(i).get_name());
            }
        }
    }

    public void printItems(Room room){
        int number = 0;
        System.out.println("These Items are in this room:");
        for(int i = 0; i < _items.size(); i++){
            if (_items.get(i).get_position() == room){
                System.out.println(number + ": " + _items.get(i).get_name());
                number++;
            }
        }
    }

    public void exit(Player player){
        System.out.println("Player " + player.get_name() + " just left the game.");
        _players.remove(player);
    }
}
