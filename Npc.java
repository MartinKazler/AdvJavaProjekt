package Projekt2;


public abstract class Npc {
    String name;
    Inventory inventory;
    Gui gui;
    public Npc(String name,Gui k){
        this.gui = k;
        this.name = name;
        this.inventory = new Inventory(1);
    }

    public Inventory getInventory(){
        return this.inventory;
    }
    public String toString (){
        return this.name + " is carrying " +this.inventory;
    }
}