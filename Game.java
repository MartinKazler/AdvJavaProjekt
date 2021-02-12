package Projekt2;

import java.awt.Color;

public class Game {
    private Gui gui;
    private Room room1, room2, room3, room4;
    private Room map[] ;

    public Game(){
        

        //Skapa rum!
        room1 = new Room("\nStarting Room"," \nLooks kinda dull, gray walls and just a chair on the right corner and a");
        room2 = new Room("\nBlue Room", "\nAs the rooms says everything is blue, there is some Smurf dummies spread across the room");
        room3 = new Room("\nYellow Room", "\nWell would you look at that everything is Yellow now, Hmmm why do i smell bananas in here?");
        room4 = new Room("\nPink Room", "\nHmm Pink, i hate that color, Looks really girly in here with all the cotton candy and ...is that ponnies? ");
        
        map = new Room[4];
        map[0] = room1;  map[1] = room2; map[2] = room3; map[3] = room4;

        //Gameobjects
        GameObject smurf = new GameObject("smurf",true);
        GameObject lampa = new GameObject("Taklampa", false);
        GameObject banana = new GameObject("banana",false);
        GameObject ponny = new GameObject("ponny",false);
       
        Container box = new Container("BLUE BOX", false, true);
       
        room1.addObject(null); room1.addObject(lampa); room1.addObject(box);
        room2.addObject(null); room2.addObject(smurf); room2.addObject(box);
        room3.addObject(null); room3.addObject(banana);room3.addObject(box);
        room4.addObject(null); room4.addObject(ponny); room4.addObject(box);


        Person newPlayer1 = new Person("You");        

        Inventory inventory = new Inventory(2);
        inventory.addObject(smurf);
        inventory.addObject(lampa);
        inventory.addObject(ponny);
        inventory.addObject(banana);

        this.gui = new Gui();

        boolean gameon=true;        
        int rumIndex=0;

        while (gameon) {

            String command = gui.getCommand();
            if (!command.equals("-1")) {

                if (command.equals("1")  ) {
                   if (rumIndex == 1 ){
                      rumIndex = 0;
                      gui.panel.setBackground(Color.GRAY);
                    }
                   
                    
                }

                if (command.equals("2")) {
                    if (rumIndex == 0 || rumIndex== 2){
                        rumIndex = 1;
                        gui.panel.setBackground(Color.BLUE);

                    }
                    
                }
                         if (command.equals("3")) {
                            if (rumIndex == 1 || rumIndex== 3){
                            rumIndex = 2;
                            gui.panel.setBackground(Color.YELLOW);
    
                        }
                       
                    }
                        if (command.equals("4")) {
                            if (rumIndex == 2){
                                rumIndex = 3;
                                gui.panel.setBackground(Color.PINK);
                                }
                            
                       
                         }

                
                //take 
                if (command.contains("Take")  ) {
                    
                       if (command.contains("banana")  ) {
                            map[rumIndex].removeObject(banana);
                            newPlayer1.getInventory().addObject(banana);
                         }
                         if (command.contains("smurf")  ) {
                            map[rumIndex].removeObject(smurf);
                            newPlayer1.getInventory().addObject(smurf);
                         }
                         if (command.contains("lampa")  ) {
                            map[rumIndex].removeObject( lampa);
                            newPlayer1.getInventory().addObject(lampa);
                         }
                         if (command.contains("ponny")  ) {
                            map[rumIndex].removeObject(ponny);
                            newPlayer1.getInventory().addObject(ponny);
                         }
                
                }             

        
                if (command.contains("Drop")  ) {

                    if (command.contains("banana")  ) {
                        map[rumIndex].addObject(banana);
                       newPlayer1.getInventory().removeObject(banana);
                    }
                    if (command.contains("ponny")  ) {
                        map[rumIndex].addObject(ponny);
                       newPlayer1.getInventory().removeObject(ponny);
                    }
                    if (command.contains("lampa")  ) {
                        map[rumIndex].addObject(lampa );
                       newPlayer1.getInventory().removeObject(lampa);
                    }
                    if (command.contains("smurf")  ) {
                        map[rumIndex].addObject(smurf);
                       newPlayer1.getInventory().removeObject(smurf);
                    }
                }
                
              
            } 
            
        

                gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );
                gui.setShowInventory(inventory);


                gui.setShowRoom1("\n "+map[0]);
                gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );


                gui.setShowRoom2("\n "+map[1]);
                gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );


                gui.setShowRoom3("\n "+map[2]);
                gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );


                gui.setShowRoom4("\n "+map[3]);
                gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );
        }

 
    }



}