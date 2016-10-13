import java.util.List;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
	   BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();

        Player player = new Player("Fred", 100);
        Game game = new Game(d1, d2, d3);
        List<DiceValue> cdv = game.getDiceValues();

        int totalWins = 0;
        int totalLosses = 0;

        while (true)
        {
            int winCount = 0;
            int loseCount = 0;
            
            for (int i = 0; i < 100; i++)
            {
            	String name = "Fred";
            	int balance = 100;
            	int limit = 0;
                player = new Player(name, balance);
                player.setLimit(limit);
                int bet = 5;

           
                	
                int turn = 0;
                
                while (player.balanceExceedsLimitBy(bet) && player.getBalance() < 200)
                {
              
                    turn++;                    
                	DiceValue pick = DiceValue.getRandom();
                   
                
                	
                	int winnings = game.playRound(player, pick, bet);
                    cdv = game.getDiceValues();
                    
               
                    
                    if (winnings > 0) {
	              
	                	winCount++; 
                    }
                    else {
	               
	                	loseCount++;
                    }
                    
                } //while

                System.out.print(String.format("%d turns later.\nEnd Game %d: ", turn, i));
                System.out.println(String.format("%s now has balance %d\n", player.getName(), player.getBalance()));
                
            } //for
            
         
            System.out.println(String.format("Win count = %d, Lose Count = %d, %.2f", winCount, loseCount, (float) winCount*108/(winCount+loseCount)/100));
            totalWins += winCount;
            totalLosses += loseCount;
            System.out.println(String.format("Overall win rate = %.1f%%", (float)(totalWins*100) / (totalWins + totalLosses)));
            String ans = console.readLine();
            if (ans.equals("q")) break;
        } //while true
        
       
	}

}
