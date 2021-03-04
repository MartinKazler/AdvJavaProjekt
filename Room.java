package Projekt2;

import Projekt.Person;

public class Room  {
    private String name;
    private String description;
    private Inventory inventory;
    private Person[] person;

    public Room(String roomName, String roomDescription){
        this.person = new Person[5];
        this.name = roomName;
        this.description= roomDescription;
        this.inventory = new Inventory(4);
    }
    public boolean addNpc(Person person){
        int i = getFirstEmptyIndex();
         if  (i == -1){
             return false;
         }
         this.person[i] = person;
         return true;
     }
    private int getFirstEmptyIndex(){

        for (int i = 0; i<this.person.length;i++){
             if (this.person[i] == null){
                 return i;
             }
         }
         return -1;
     }
    
    
    
    
    public Person getPersons(){
        return this.person[0];
    }
    public void addObject(GameObject go){
        this.inventory.addObject(go);
        getInventory();
    }
        //remove 
        public void removeObject(GameObject go) {
             this.inventory.removeObject(go);
             getInventory();

        }
        public String toString(){
            return name+" : "+description +"\n" +inventory;
        }
        public Inventory getInventory(){
            return this.inventory;
        }
		public void addNpc(Projekt2.Person simon) {
			// TODO Auto-generated method stub
			
		}

}
