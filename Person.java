package Projekt2;

import java.util.*;


public class Person extends Npc implements Runnable{

    private int position;
    public Person(String name, int startRoom, Gui m) {
        super(name, m);
        this.position = startRoom;
    }
    public synchronized void move(){
        int slump = new Random().nextInt(4);
        this.position = slump;
        System.out.println("Moving " + this.name + " to Room " + (this.position + 1) );
    }
    public int getPosition() {
        return position;
    }
    
    @Override
   public void run(){
        move();
   }
}