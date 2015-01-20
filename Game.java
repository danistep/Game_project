/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private ValidAction commandWord;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()//refactored
    {
        currentRoom = RoomCreator.buildCurrentRooms();//new
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play()
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            //System.out.println(command==null);
            String output = processCommand(command);
            finished = (null == output);
            if (!finished)
            { 
                System.out.println(output);
            }

        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()//refactored
    {
        System.out.println();
        waitTime(0.5);
        System.out.println("Let´s play a game...");
        waitTime(0.5);
        System.out.println("Welcome to the awesome Adventure Game 'Magic Quest'!");
        waitTime(0.5);
        System.out.println("If you want to become a mighty madican - you have to play.");
        waitTime(0.5);
        System.out.println("Type 'help' if you need help.");
        waitTime(0.5);
        System.out.println();
        waitTime(0.5);
        System.out.println(currentRoom.getDescription() + "\n");//new
        waitTime(0.5);
        System.out.println(currentRoom.getExitDescription() + "\n");//new
        waitTime(0.5);
        System.out.println();
    }

    /**
     * Given a command, process (thagetAction()at is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public String processCommand(Command command) //refactored
    {
        boolean wantToQuit = false;
        //System.out.println("hitter boolean");
        commandWord = command.getAction();//fehler
        //System.out.println(command);
        //System.out.println("enum == null" + (commandWord == null));
        String result = "";
        //System.out.println("heyho");
        //System.out.println(result);
        switch(commandWord){
            //case UNKNOWN: return "I don't know what you mean..."; break;
            
            case HELP: result += printHelp(); break;
            case GO: result += goRoom(command); break;
            case QUIT: return quit(command);//refactored from refactoring
            default: result += "I don't know what you mean...";
        }
        return result;
    }

    // implementations of user commands:
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private String printHelp()//refactored
    {   String result = "";
        result += "\n";
        result += "You are weak if you have to ask me\n";
        result += "Try not to die, while i´am mocking you.\n";
        result += "\n";
        result += "" + currentRoom.getDescription() + "\n"; //new
        result += "\nExits: " + currentRoom.getExitDescription() + "\n";//new
        result += "\nCommand words:\n";
        result += ValidAction.getValidCommandWords();
        result += "\n";
        
        return result;
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private String goRoom(Command command)//refactored
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            return "Go where?";
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);//new
        
        String result = "";
        if (nextRoom == null) {
            result += "There is no door!";
        }
        else {
            currentRoom = nextRoom;
            result += currentRoom.getDescription()+"\n";//refactored
           
            result += "Exits: " + currentRoom.getExitString()+"\n";//taken from class Room       
            
            return result;
        }
        result += "\n";

        return result;
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return null, if this command quits the game, something else to output otherwise.
     */
    private String quit(Command command) 
    {
        if(command.hasSecondWord()) {
            return "Quit what?";
        }
        else {
            return null;  // signal that we want to quit, refactored
        }
    }

    public static void main(String[] args){
        Game game = new Game();
        game.play();
    }
    
    private void waitTime(double seconds)//new for delay
    {
        long StartTime = System.currentTimeMillis();
        long StopTime = System.currentTimeMillis();
        long difference = 0;
        while(difference <= seconds * 1000)
        {
            StopTime = System.currentTimeMillis();
            difference = StopTime - StartTime;
        }
    }

}
