/**
 * Write a description of class RoomCreator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

/**
 * this class creates all rooms and exits.
 * @author Pascal Thurley
 * @version 17.01.2015
 */
public class RoomCreator
{
   

    /**
     * Constructor for objects of class RoomCreator
     */
    public RoomCreator()
    {
       
    }

    /**
     * method builds the whole level vconstruct and returns the starting room instance
     * 
     * @return     the starting room of the game
     */
    public static Room buildCurrentRooms()
    {
       Room fieldCentre, fieldWest, fieldEast, fieldNorth, fieldSouth,//outside
       //cathedral
       cathedralEnterance, cathedralSouthWest, cathedralCenterWest, cathedralCenterCenter,
       cathedralNorthWest, cathedralCenterNorth, cathedralNorthEast, cathedralSouthEast,
       cathedralSouthEastEast,
       //cathedral Basement
       cathedralBasementEnterance, cathedralBasementSouth, cathedralBasementSouthEast, cathedralBasementEast,
       cathedralBasementWest, cathedralBasementNorthWest,
       //graveyard
       graveyardEntrance, graveyardSouthWest, graveyardWest, 
       graveyardNorthWest, graveyardCenterNorth,
       //crematory
       crematoryEntrance, crematorySouthWest, crematorySouthEast, cramatoryNorthEast,
       //crematory Basement
       crematoryBasementEntrance, crematoryBasementWest, crematoryBasementNorthWest, crematoryBasementNorthNorthWest,
       //village
       villageEntrance, villageEastFirst, villageEastFirstSouth, villageEastSecond, villageEastThird, villageEastFourth,
       villageWest,
       //pub-basement-Area
       pubEntrance, pubEastFirst, pubEastSecond, pubEastSecondNorth, pubEastSecondNorthEast,
       pubEastFirstNorth, pubEastFirstNorthNorth;
       
       // create the Areas and Rooms
       // field-Area
       fieldCentre = new Room("You are on a green field with some Trees.");
       fieldWest = new Room("You now have entered the Sanctuary.It is you last stop before the true journey!");
       fieldEast = new Room("You are on a green field with some Horses.");
       fieldNorth = new Room("You are on a green field and you can see some stairs.");
       fieldSouth = new Room("You are on a green field and you can see a road.");
                     
       // cathedral-Area
       cathedralEnterance = new Room("You have entered the cathedral 'Holy Angle'.");
       cathedralSouthWest = new Room("You are in a library.");
       cathedralCenterWest = new Room("You are in a restroom.");
       cathedralCenterCenter = new Room("You are in a tower.");//planetarium
       cathedralNorthWest = new Room("You are in a office.");
       cathedralCenterNorth = new Room("You are in a storeroom.");
       cathedralNorthEast = new Room("You are in an empty room.");
       cathedralSouthEast = new Room("You are in a church.");
       cathedralSouthEastEast = new Room("You are in a confessional room.");
              
       // cathedral-basement-Area
       cathedralBasementEnterance = new Room("You have entered a dark room. There is weak light.");
       cathedralBasementSouth = new Room("You are in a torture room.");
       cathedralBasementSouthEast = new Room("You are in an oubliette.");//kerker
       cathedralBasementEast = new Room("You are in a lounge.");
       cathedralBasementWest = new Room("You are in a chamber.");
       cathedralBasementNorthWest = new Room("You are in a fortune chamber.");
       
              
       // graveyard-Area
       graveyardEntrance = new Room("You are infront of a graveyard and there is a lot of fog.");
       graveyardSouthWest = new Room("You have entered the graveyard.");
       graveyardWest = new Room("You are on a graveyard between many tombstones.");
       graveyardNorthWest = new Room("You are between a longe range of tombstones.");
       graveyardCenterNorth = new Room("You are infront of a crematory.");
              
       //crematory
       crematoryEntrance = new Room("You have entered the crematory.");
       crematorySouthWest = new Room("You are in an embalmment hall.");//einbalsamierung
       crematorySouthEast = new Room("You are in a storeroom.");
       cramatoryNorthEast = new Room("You are in a room with rubbish chutes.");
              
       // crematory-basement-Area
       crematoryBasementEntrance = new Room("You entered a dark room and it smells horrible.");
       crematoryBasementWest = new Room("You are in a room full of rubbish and you can´t see a lot");
       crematoryBasementNorthWest = new Room("You are in a room with buckets.");
       crematoryBasementNorthNorthWest = new Room("You entered a room with some torches hanging on the walls.");
                     
       //village-Area
       villageEntrance = new Room("You have entered the village 'Old Stump'");
       villageEastFirst = new Room("You are on the road of the Village.");
       villageEastFirstSouth = new Room("You are in a small house.");
       villageEastSecond = new Room("You are on the road of the Village.");
       villageEastThird = new Room("You are on the road of the Village.");
       villageEastFourth = new Room("You have reached the end of the road. You can´t go further because the village gate is locked.");
       villageWest = new Room("You have entered a pub.");
                     
       //pub-basement-Area
       pubEntrance = new Room("You have entered a supply room with many barrels.");
       pubEastFirst = new Room("You are in a room full of meat.");
       pubEastSecond = new Room("You are in a room with some puddles. It smells disgusting.");//pfützen
       pubEastSecondNorth = new Room("You are in a dark room.");
       pubEastSecondNorthEast = new Room("You are in a room with some treasure boxes.");
       pubEastFirstNorth = new Room("You are in an empty room.");
       pubEastFirstNorthNorth = new Room("You are in a room and there is a skeleton at the wall.");
              
       //directions
       fieldCentre.setExit("north", fieldNorth);
       fieldCentre.setExit("east", fieldEast);
       fieldCentre.setExit("south", fieldSouth);
       fieldCentre.setExit("west", fieldWest);
       fieldWest.setExit("east", fieldCentre);
       fieldEast.setExit("west", fieldCentre);
       fieldNorth.setExit("north", cathedralEnterance);
       fieldNorth.setExit("south", fieldCentre);
       fieldSouth.setExit("north", fieldCentre);
       fieldSouth.setExit("east", graveyardEntrance);
       fieldSouth.setExit("south", villageEntrance);
       
       cathedralEnterance.setExit("east", cathedralSouthEast);
       cathedralEnterance.setExit("south", fieldNorth);
       cathedralEnterance.setExit("west", cathedralSouthWest);
       cathedralSouthWest.setExit("north", cathedralCenterWest);
       cathedralSouthWest.setExit("east", cathedralEnterance);
       cathedralSouthWest.setExit("down", cathedralBasementEnterance);//DOWN !!!
       cathedralCenterWest.setExit("north", cathedralNorthWest);
       cathedralCenterWest.setExit("east", cathedralCenterCenter);
       cathedralCenterWest.setExit("south", cathedralSouthWest);
       cathedralCenterCenter.setExit("west", cathedralCenterWest);
       cathedralNorthWest.setExit("south", cathedralCenterWest);
       cathedralCenterNorth.setExit("east", cathedralNorthEast);
       cathedralNorthEast.setExit("south", cathedralSouthEast);
       cathedralNorthEast.setExit("west", cathedralCenterNorth);
       cathedralSouthEast.setExit("north", cathedralNorthEast);
       cathedralSouthEast.setExit("east", cathedralSouthEastEast);
       cathedralSouthEast.setExit("west", cathedralEnterance);
       cathedralSouthEastEast.setExit("west", cathedralSouthEast);
       
       cathedralBasementEnterance.setExit("east", cathedralBasementEast);
       cathedralBasementEnterance.setExit("south", cathedralBasementSouth);
       cathedralBasementEnterance.setExit("west", cathedralBasementWest);
       cathedralBasementEnterance.setExit("up", cathedralSouthWest);//UP!!!
       cathedralBasementSouth.setExit("north", cathedralBasementEnterance);
       cathedralBasementSouth.setExit("west", cathedralBasementSouthEast);
       cathedralBasementSouthEast.setExit("west", cathedralBasementSouth);
       cathedralBasementEast.setExit("west", cathedralBasementEnterance);
       cathedralBasementWest.setExit("north", cathedralBasementNorthWest);
       cathedralBasementWest.setExit("east", cathedralBasementEnterance);
       cathedralBasementNorthWest.setExit("south", cathedralBasementWest);
       
       graveyardEntrance.setExit("east", graveyardSouthWest);
       graveyardEntrance.setExit("west", fieldSouth);
       graveyardSouthWest.setExit("north", graveyardWest);
       graveyardSouthWest.setExit("west", graveyardEntrance);
       graveyardWest.setExit("north", graveyardNorthWest);
       graveyardWest.setExit("south", graveyardSouthWest);
       graveyardNorthWest.setExit("east", graveyardCenterNorth);
       graveyardNorthWest.setExit("south", graveyardWest);
       graveyardCenterNorth.setExit("south", crematoryEntrance);
       graveyardCenterNorth.setExit("west", graveyardNorthWest);
       
       crematoryEntrance.setExit("north", graveyardCenterNorth);
       crematoryEntrance.setExit("south", crematorySouthWest);
       crematoryEntrance.setExit("east", cramatoryNorthEast);
       crematorySouthWest.setExit("north", crematoryEntrance);
       crematorySouthWest.setExit("east", crematorySouthEast);
       crematorySouthEast.setExit("north", cramatoryNorthEast);
       crematorySouthEast.setExit("west", crematorySouthWest);
       cramatoryNorthEast.setExit("down", crematoryBasementEntrance);
       cramatoryNorthEast.setExit("south", crematorySouthEast);
       cramatoryNorthEast.setExit("west", crematoryEntrance);
       
       crematoryBasementEntrance.setExit("up", cramatoryNorthEast);
       crematoryBasementEntrance.setExit("west", crematoryBasementWest);
       crematoryBasementWest.setExit("north", crematoryBasementNorthWest);
       crematoryBasementWest.setExit("east", crematoryBasementEntrance);
       crematoryBasementNorthWest.setExit("north", crematoryBasementNorthNorthWest);
       crematoryBasementNorthWest.setExit("south", crematoryBasementWest);
       crematoryBasementNorthNorthWest.setExit("south", crematoryBasementNorthWest);
       
       villageEntrance.setExit("north", fieldSouth);
       villageEntrance.setExit("east", villageEastFirst);
       villageEntrance.setExit("west", villageWest);
       villageEastFirst.setExit("east", villageEastSecond);
       villageEastFirst.setExit("south", villageEastFirstSouth);
       villageEastFirst.setExit("west", villageEntrance);
       villageEastFirstSouth.setExit("north", villageEastFirst);
       villageEastSecond.setExit("east", villageEastThird);
       villageEastSecond.setExit("west", villageEastFirst);
       villageEastThird.setExit("east", villageEastFourth);
       villageEastThird.setExit("west", villageEastSecond);
       villageEastFourth.setExit("west", villageEastThird);
       villageWest.setExit("down", pubEntrance);//down
       villageWest.setExit("east", villageEntrance);
       
       pubEntrance.setExit("up", villageWest);
       pubEntrance.setExit("east", pubEastFirst);
       pubEastFirst.setExit("north", pubEastFirstNorth);
       pubEastFirst.setExit("east", pubEastSecond);
       pubEastFirst.setExit("west", pubEntrance);
       pubEastSecond.setExit("north", pubEastSecondNorth);
       pubEastSecond.setExit("west", pubEastFirst);
       pubEastSecondNorth.setExit("east", pubEastSecondNorthEast);
       pubEastSecondNorth.setExit("south", pubEastSecond);
       pubEastSecondNorthEast.setExit("west", pubEastSecondNorth);
       pubEastFirstNorth.setExit("south", pubEastFirst);
       pubEastFirstNorth.setExit("north", pubEastFirstNorthNorth);
       pubEastFirstNorthNorth.setExit("south", pubEastFirstNorth);       
              
       ArrayList<Room> allRooms = new ArrayList<Room>();
       
       allRooms.add(fieldCentre);
       allRooms.add(fieldWest);
       allRooms.add(fieldEast);
       allRooms.add(fieldNorth);
       allRooms.add(fieldSouth);
       
       allRooms.add(cathedralEnterance);
       allRooms.add(cathedralSouthWest);
       allRooms.add(cathedralCenterWest);
       allRooms.add(cathedralCenterCenter);
       allRooms.add(cathedralNorthWest);
       allRooms.add(cathedralCenterNorth);
       allRooms.add(cathedralNorthEast);
       allRooms.add(cathedralSouthEast);
       allRooms.add(cathedralSouthEastEast);
       
       allRooms.add(cathedralBasementEnterance);
       allRooms.add(cathedralBasementSouth);
       allRooms.add(cathedralBasementSouthEast);
       allRooms.add(cathedralBasementEast);
       allRooms.add(cathedralBasementWest);
       allRooms.add(cathedralBasementNorthWest);
       
       allRooms.add(graveyardEntrance);
       allRooms.add(graveyardSouthWest);
       allRooms.add(graveyardWest);
       allRooms.add(graveyardNorthWest);
       allRooms.add(graveyardCenterNorth);
       
       allRooms.add(crematoryEntrance);
       allRooms.add(crematorySouthWest);
       allRooms.add(crematorySouthEast);
       allRooms.add(cramatoryNorthEast);
       
       allRooms.add(crematoryBasementEntrance);
       allRooms.add(crematoryBasementWest);
       allRooms.add(crematoryBasementNorthWest);
       allRooms.add(crematoryBasementNorthNorthWest);
       
       allRooms.add(villageEntrance);
       allRooms.add(villageEastFirst);
       allRooms.add(villageEastFirstSouth);
       allRooms.add(villageEastSecond);
       allRooms.add(villageEastThird);
       allRooms.add(villageEastFourth);
       allRooms.add(villageWest);
       
       allRooms.add(pubEntrance);
       allRooms.add(pubEastFirst);
       allRooms.add(pubEastSecond);
       allRooms.add(pubEastSecondNorth);
       allRooms.add(pubEastSecondNorthEast);
       allRooms.add(pubEastFirstNorth);
       allRooms.add(pubEastFirstNorthNorth);      
       
       // ArrayList<Item> allItems = createItems();
      
       // putItems(allItems, allRooms);
        
       // put your code here
       return fieldCentre;
    }
    
    private void putItems( ArrayList<Room> allItems, ArrayList<Room> allRooms){
        // generation all items -> List<Item>
        // zufälliges Zuordnen der Items zu den jew. Räumen
        // random room
    }
    
        /*
        private ArrayList<Item> createItems(){
            
             ArrayList<Item> allItems = new ArrayList<Item>();
             
            Item one = new Item("Food");
            etcetcetc...
            
            allItem.add(one);
            
            
            etcetc
            
            return allItems;
        } */
}
