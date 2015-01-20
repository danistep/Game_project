import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Room 
{
    private String description;
    private String exitString;
    private HashMap<String, Room> exits;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exitString = "";
        exits = new HashMap();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
    */
    public void setExit(String direction, Room room) 
    {
        exits.put(direction, room);
        exitString = exitString + " " + direction;
        
    }
    
    /**
     * getting the room objext given by exit String
     * @param: direction where to go to...
     * @return: Room exit behind parameter String
     */
    public Room getExit(String direction)
    {
        return (Room) exits.get(direction);
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getExitString()
    {
        return exitString;
    }
    
    /**
     * @return The description of the room.
     */
    public String getExitDescription()
    {
        Room currentRoom = this;
        String result = "";
        System.out.print("Exits: ");
        for(String exit : exits.keySet())
        {
            result = result + exit;
            result = result + " ";
        }
        return result;
    }
}
        

