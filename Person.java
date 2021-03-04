package Projekt2;


public class Person extends Npc implements Runnable{

    private int position;
    public Person(String name, int startRoom, Gui m) {
        super(name, m);
        this.position = startRoom;
    }
    public synchronized void move(){
        int slump = (int) (Math.random() * 4) + 1;
        this.position = slump;
        System.out.println("Moving " + this.name + " to Room " + (this.position) );
    }
    
    
    public int getPosition() {
        return position;
    }
   
    @Override
   public void run(){
        move();
   }
}
