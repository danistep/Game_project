/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two strings: a command word and a second
 * word (for example, if the command was "take map", then the two strings
 * obviously are "take" and "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is <null>.
 *
 * If the command had only one word, then the second word is <null>.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Command//refactored
{
    private ValidAction commandWord;//new
    private String firstWord;
    private String secondWord;
         
    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     * @param firstWord The first word of the command. Null if the command
     *                  was not recognised.
     * @param secondWord The second word of the command.
     */
    public Command(String firstWord, String secondWord)//refactored
    {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
        //eine zeile fehlt die das unten macht - michele fragen
        //h�rt bei quit nicht auf
        commandWord = ValidAction.getValidAction(firstWord);
        
        
    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     * @return The command word.
     */
    public String getCommandWord()
    {
        return this.firstWord;
    }

    /**
     * @return The second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * @return true if this command was not understood.
     */
    public boolean isUnknown()//refactored
    {
        return (commandWord == ValidAction.UNKNOWN);
    }

    /**
     * @return true if the command has a second word.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
    
    public static boolean isCommand(String aString)//refactored
    {
         for(ValidAction c : ValidAction.values())
         {
             if(c.getActionString().equals(aString)){return true;}
                //getActionString() out of ValidActions
         }
         return false;
    }
        
    public ValidAction getAction()
    {
        //System.out.println("ich bin hier " + commandWord);
        return commandWord;
    }
}

