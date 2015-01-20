//new
public enum ValidAction//refactored from class CommandWords
{
        GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("unknown"); //LOOK, USE, EAT, DRINK, READ, 
        //TAKE, CARRY, 
        
        private String action;
                
        ValidAction(String value){
             this.action = value;
        }
        
        public String getActionString()
        {
            return this.action;
        }
        
        public static ValidAction getValidAction(String firstWord)
        {
            ValidAction result = UNKNOWN;
            if(firstWord != null){
                switch(firstWord){
                    case "go" :
                    result = ValidAction.GO; 
                    break;
                    case "help" : result = ValidAction.HELP; break;
                    case "quit" : result = ValidAction.QUIT; break;
                }
                
            }
            return result;
        }
        
        public static String getValidCommandWords(){
            String result = "";
            for (ValidAction cw : ValidAction.values()){
                 result += cw.toString();
                 result += " ";
            }
            return result.trim().toLowerCase();// "go quit help ";
        }
        
}