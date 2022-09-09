package hwx;

public class Player 
{
    private int pt;		// p id
    private int cashprize;	// cash prize money 

    
    // Player(int x) -> create player with x as ID
    public Player(int x) 	
    {
        pt = x;
        cashprize = 0;
    }
    

    // getid() -> gets player id
    public int getid() 	
    {
        return pt;
    }
    

    // resetP()	-> reset cash 
    public void resetP()
    {
        cashprize = 0;
    }
    
    
    // purchaseVowel() -> get vowel
    public void purchaseVowel() 
    { 
    	cashprize = cashprize - 200; 
    }	

    
    // getCash() -> return bank 
    public int getCash() 
    { 
    	return cashprize; 
    }	
      
     
    // plusp() -> increase bank of player by x amount
    public void plusp(int x) 
    { 
    	cashprize += x;
    }	

     
    // intp(x) -> set x as the id
    public void intp(int x) 
    { 
    	pt = x; 
    }	

    
    // total(x) -> set bank total
    public void total(int x) 
    { 
    	cashprize = x; 
    }	
}






