package hwx;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


@SuppressWarnings("serial")
public class WheelOfFortune extends JFrame implements ActionListener{

	private String[] movienames = {"now you see me", "minions", "chicken little", "the godfather", "the dark knight rises", "pulp fiction", "forrest gump", "fight club"};
	private int[] wheelchoicess = {0, 100, 150, 250, 300, 450, 500, 550, 600, 750, 800, 900};
	
	private Wheel wheel;
	private Player p1 = new Player(1);    
	private Player p2 = new Player(2);
	
	@SuppressWarnings("unused")
	private Player winner;
	private int casher;
    private int wheeloptions = 3;
	private Player currentp;
	 
	 // JTEXTFEILD
    private JTextField moviepuzzle;
    private JTextField guessText1;
    private JTextField player1C;
    private JTextField player2C;
    private JTextField sT;
    
    // BUTTON
    private JButton solver;
    private JButton restart;
    private JButton spinButton;
    private JButton vbutton;

    
    // STRINGS 
    private int goption; 
    private StringBuffer spuz;
    private String secretmoviename;
    private String newg;
	  
	// LABELS
    private JLabel headerl;
    private JLabel mlabel;
    @SuppressWarnings("unused")
	private JLabel gamepuz;
    private JLabel currentP;
    private JLabel p1data;
    private JLabel p2data;
    private JLabel p1Cash;
    private JLabel p2Cash;
    private JLabel pW;
    private JLabel ng;
    
    
    // -----------------------------------------------------
    // WheelOfFortune() -> adds all components to the screen
    // -----------------------------------------------------
    
    public WheelOfFortune() 
    {
    	this.getContentPane().setBackground(Color.PINK);
    	secretmoviename = movienames[4];
    	currentp = p1;
        setTitle("Final Project Wheel Of Fortune");
        setLayout(new GridBagLayout());
        GridBagConstraints wofgrid = new GridBagConstraints();

        // title 
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 2; wofgrid.gridy = 0;
        wofgrid.gridwidth = 2;
        headerl = new JLabel("WHEEL OF FORTUNE (MOVIE EDITION)");
        headerl.setFont(new Font("Times New Roman", Font.BOLD, 40));
        headerl.setOpaque(true);
        add(headerl, wofgrid);
        
        // HIDDEN MOVIE NAME 
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 2; wofgrid.gridy = 2;
        moviepuzzle = new JTextField(30);
        moviepuzzle.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        moviepuzzle.setEditable(false);
        add(moviepuzzle, wofgrid);
        
        // TURN REMINDER FOR PLAYERS
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 2; wofgrid.gridy = 2;
        wofgrid.gridwidth = 2;
        currentP = new JLabel();
        add(currentP, wofgrid);
        
        // WHEEl
        wheel = new Wheel();
        wofgrid.gridx = 2; wofgrid.gridy = 4;
        add(wheel, wofgrid);
        
        // TAP TO SPIN BUTTON
        spinButton = new JButton("TAP TO SPIN");
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 2; wofgrid.gridy = 3;
        wofgrid.gridwidth = 2;
        add(spinButton, wofgrid);
        spinButton.setBackground(Color.YELLOW);
        spinButton.setOpaque(true); spinButton.setEnabled(true);
        spinButton.addActionListener(this);
        
        // Result of spin
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 2; wofgrid.gridy = 5;
        wofgrid.gridwidth = 2;
        sT = new JTextField(12); 
        sT.setEditable(false);
        sT.setVisible(false);
        add(sT, wofgrid);
        
        // Purchase a Vowel button 
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 0; wofgrid.gridy = 4;
        wofgrid.gridwidth = 2;
        vbutton = new JButton("Click to purchase Vowel");
        add(vbutton, wofgrid);
        vbutton.setEnabled(true);
        vbutton.addActionListener(this);
        
        // GUESS MOVIE BUTTON
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 4; wofgrid.gridy = 4;
        wofgrid.gridwidth = 2;
        solver = new JButton("Click to guess movie name");
        solver.setEnabled(true);
        add(solver, wofgrid);
        solver.addActionListener(this);

        // Label Instructions
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 2; wofgrid.gridy = 6;
        wofgrid.gridwidth = 2;
        mlabel = new JLabel("Guess letter, click to guess vowel($200), or click to guess movie:");
        add(mlabel, wofgrid);
        
        // MOVIE ENTRY BOX 
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 2;
        wofgrid.gridy = 7;
        wofgrid.gridwidth = 2;
        guessText1 = new JTextField(26);
        guessText1.setText("");
        guessText1.setEditable(false);
        add(guessText1, wofgrid);
        guessText1.addActionListener(this);


        // PLAYER 1 SETUP
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 0;
        wofgrid.gridy = 2;
        wofgrid.gridwidth = 2;
        p1data = new JLabel("PLAYER 1");
        p1data.setFont(new Font("Times New Roman", Font.BOLD, 17));
        add(p1data, wofgrid);

        // PLAYER 2 SETUP
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 4;
        wofgrid.gridy = 2;
        wofgrid.gridwidth = 2;
        p2data = new JLabel("PLAYER 2");
        p2data.setFont(new Font("Times New Roman", Font.BOLD, 17));
        add(p2data, wofgrid);

        // SET BANK
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 0;
        wofgrid.gridy = 3;
        wofgrid.gridwidth = 1;
        p1Cash = new JLabel("Bank:");
        add(p1Cash, wofgrid);
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 4;
        wofgrid.gridy = 3;
        wofgrid.gridwidth = 1;
        p2Cash = new JLabel("Bank:");
        add(p2Cash, wofgrid);

        // GET BANK
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 1;
        wofgrid.gridy = 3;
        wofgrid.gridwidth = 1;
        player1C = new JTextField(7);
        player1C.setEditable(false);
        player1C.setText("$ "+ p1.getCash());
        add(player1C, wofgrid);

        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 5;
        wofgrid.gridy = 3;
        wofgrid.gridwidth = 1;
        player2C = new JTextField(7);
        player2C.setEditable(false);
        player2C.setText("$ "+ p2.getCash());
        add(player2C, wofgrid);

        
        // WINNER LABEL
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 2;
        wofgrid.gridy = 10;
        wofgrid.gridwidth = 2;
        ng = new JLabel("WINNER:");
        add(ng, wofgrid);
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 2; wofgrid.gridy = 11;
        wofgrid.gridwidth = 2;
        pW = new JLabel(); add(pW, wofgrid);

        // Restart button
        wofgrid.insets = new Insets(10,10,10,10);
        wofgrid.gridx = 2; wofgrid.gridy = 12;
        wofgrid.gridwidth = 2;
        restart = new JButton("RESTART GAME");
        add(restart, wofgrid);
        restart.setEnabled (false); restart.addActionListener(this);
        highlightp();
        fillPuzzle();
        startpuzzle();
    }

    
    // ---------------------------------------------------------
    // spinner() -> spins wheel lands has 12 options to land on
    // ---------------------------------------------------------
    public int spinner() 
    {
        casher = wheelchoicess[new Random().nextInt(12)];
        wheel.around(casher);
        
        if(casher != 0)	// not zero
        {
              goaway(spinButton); 
              buttoncolor(vbutton); 
              buttoncolor(solver);
              return 1;
        }
       
        currentp.total(0);
        bankrefresh(); 
        nextp(); 
        startpuzzle();
        
        return -1;
    }


    // ---------------------------------------------------------
    // updategame(x) -> updates game and changes color
    // ---------------------------------------------------------  
    public void updategame(JTextField x)
    {
        x.setBackground(Color.YELLOW); 
        x.setOpaque(true);
        x.setEditable(true);
    }


    // --------------------------------------------------
    // playerUpdate(x) -> updates player
    // --------------------------------------------------   
    public void playerUpdate (JTextField x)
    {
        x.setBackground(new JTextField().getBackground());
        x.setOpaque(true); 
        x.setEditable(false);
    }

    
    // ------------------------------------------------------------------------------
    // fillPuzzle() -> fills in puzzle at beginning of game with ▢ for every letter
    // ------------------------------------------------------------------------------
    public void fillPuzzle() 
    {   	
        spuz = new StringBuffer();
        
        for(int spot = 0; spot < secretmoviename.length(); ++spot) 
        {
            if (!Character.isLetter(secretmoviename.charAt(spot))) 
            { 
            	spuz.append(" "); 
            } 
            else { spuz.append("▢"); }
        }
        
        moviepuzzle.setText(spuz.toString());
    }

    
    // ------------------------------------------------------------------------------
    // highlightp() -> highlights players name (yellow) when its their turn 
    // ------------------------------------------------------------------------------
    public void highlightp()
    {
        if (currentp == p1) // Player 1
        {
            p1data.setBackground(Color.YELLOW); p1data.setOpaque(true);
            currentP.setText("PLAYER 1's TURN");
            p2data.setBackground(new JLabel().getBackground());
            p2data.setOpaque(true);
            return;
        }
        
        // Player 2
        p2data.setBackground(Color.YELLOW); p2data.setOpaque(true);
        currentP.setText("PLAYER 2's TURN");
        p1data.setBackground(new JLabel().getBackground());
        p1data.setOpaque(true);
    }

    
    // ------------------------------------------------------------------------------
    // startpuzzle() -> start puzzle and sets all players bank to zero
    // ------------------------------------------------------------------------------
    public void startpuzzle()
    {
        buttoncolor(vbutton); 
        buttoncolor(solver);
        playerUpdate(guessText1); 
        
        buttoncolor(spinButton);
        goaway(restart);
    }
    
    
    // ------------------------------------------------------------
    // nextp() -> gets next player in turn rotation
    // ------------------------------------------------------------
    public void nextp()
    {
        if (currentp == p2) 
        {
            currentp = p1;
        } 
        else {
            currentp = p2;
        }
        
        highlightp();
    }
    
    
    // --------------------------------------------------------------------
    // notVowel(x) -> True if is NOT a vowel
    // --------------------------------------------------------------------
    private boolean notVowel(char letter) 
    {
    	letter = Character.toUpperCase(letter);
    	if (letter == 'A' || letter == 'E'|| letter == 'I'|| letter == 'O'|| letter == 'U')
        	return false;
    	
        return true;	// not a vowel
    }
  
    
    // --------------------------------------------------------------------
    // guessnonvowel(x) -> users picked non-vowel button 
    // --------------------------------------------------------------------
    public void guessnonvowel(String target) 
    {
        char cons = target.charAt(0);
        if (notVowel(cons)) 
        {	
            int num = letterCheck(cons, "letter");
            if(num == -1)
            {
            	return; 
            }
           
            currentp.plusp(casher);
            bankrefresh(); 
            updatepuzzle(cons);
            return;
        }
       
        nextp();
        startpuzzle();
        JOptionPane.showMessageDialog(this,"ERROR: Vowel Entered.");
    }
    
    
    // ----------------------------------------------------------------------------------
    // wordcolor(spot) -> changes button color to blue when they are able to be clicked
    // ----------------------------------------------------------------------------------
    // change color
    public void buttoncolor(JButton spot)
    {
    	spot.setOpaque(true); 
    	spot.setEnabled(true);
    	spot.setBackground(Color.BLUE);
    }

   
    // --------------------------------------------------------------------
    // bankrefresh() -> updates players money in bank 
    // --------------------------------------------------------------------
    public void bankrefresh()
    {
        player1C.setText("$ "+ p1.getCash()); 
        player2C.setText("$ "+ p2.getCash());
    }

    
    // --------------------------------------------------------------------
    // updatepuzzle(x) -> updates the puzzle with correct guessed letter 
    // --------------------------------------------------------------------
    public void updatepuzzle(char x) 
    {
        int spot = secretmoviename.indexOf(x);
        String temp = Character.toString(x);
        
        while (spot != -1) 
        {
            spuz.replace(spot, spot+1, temp);
            spot = secretmoviename.indexOf(x, spot+1);
        }
        
        moviepuzzle.setText(String.valueOf(spuz));
    }

    
    // ----------------------------------------------------------
    // goaway(x) -> makes button go away or disappear 
    // ----------------------------------------------------------
    public void goaway(JButton x)
    {
        x.setBackground(new JButton().getBackground());
        x.setOpaque(true); x.setEnabled(false);
    }


    // -------------------------------------------------------------------------
    // letterCheck(spot, letter) -> checks letter to see if previously guessed 
    // -------------------------------------------------------------------------
    public int letterCheck(char spot, String letter) 
    {
        int hold = 0;

        for (int x = 0; x < spuz.length(); ++x) 
        {
            if (spot == spuz.charAt(x)) 
            {
                JOptionPane.showMessageDialog(this, "Incorrect: previously guessed\n\nNext players turn.");
                nextp();  startpuzzle();
                return -1;
            }
            else if (spot == secretmoviename.charAt(x)) { 
            	hold++; 
            }
        }

        if (hold == 0) // incorrect guess
        {
            JOptionPane.showMessageDialog(this,"Incorret!\n\nNext players turn.");
            
            nextp();
            startpuzzle();
            return -1;
        }
        return hold;
    }

    
    // --------------------------------------------------------------------
    // guessvowel(x) -> when a vowel is guessed checks to see if correct 
    // --------------------------------------------------------------------
    public void guessvowel(String letter) 
    {
        currentp.purchaseVowel();
        bankrefresh();

        if(notVowel(letter.charAt(0))) // did NOT enter vowel 
        {
            nextp(); startpuzzle();
            JOptionPane.showMessageDialog(this,"Not vowel\nNEXT PLAYERS TURN");     
        } 
        else if (letterCheck(letter.charAt(0), "vowel") != -1) // entered vowel 
        {
        	 updatepuzzle(letter.charAt(0));
        }
    }


    // --------------------------------------------------------------------
    // actionPerformed(e) -> actions when buttons pressed
    // --------------------------------------------------------------------
    public void actionPerformed(ActionEvent e) 
    {
        System.out.println(e.getSource());
        
        if (e.getSource() == solver)	// Guess full name of movie
        {
            pW.setText("");  
            goption = 3;
            
            // hide buttons
            goaway(vbutton); 
            goaway(spinButton); 
            goaway(solver);
            updategame(guessText1);

        }
        else if (e.getSource() == vbutton)	// buy vowel
        {
            pW.setText("");
            if(currentp.getCash() > 199) 
            {
                goaway(vbutton); goaway(spinButton); goaway(solver);goption = 2;
                updategame(guessText1);
            }
            else
            {
                nextp();
                startpuzzle();
                JOptionPane.showMessageDialog(this,"Insufficent Funds");
            }
        }
        else if(e.getSource() == restart)	// restart
        {
            p1.resetP(); p2.resetP();
            bankrefresh();
            wheeloptions = 1;
            ng.setText("Game " + wheeloptions); 
            currentp = p1;
            highlightp(); secretmoviename = movienames[wheeloptions - 2];
            fillPuzzle(); startpuzzle();

        }
        else if(e.getSource() == spinButton)	// non-vowel
        {
            int mys = spinner();
            pW.setText("");

            if(mys == 1)
            {
                goaway(spinButton); goaway(vbutton); goaway(solver);
                updategame(guessText1);
                goption = 1;
            }
        }
        else if(e.getSource() == guessText1)
        {
            newg = guessText1.getText();
            if (goption <= 2)
            {
            	if(goption == 1)
                    guessnonvowel(newg);
            	else
            		guessvowel(newg);
                
            	buttoncolor(spinButton);      
            }
            else 
            {
                int status = solved(newg);
     
                if(status != 1)	// find winner
                {
                   if(p1.getCash() > p2.getCash())
                   {
                         winner = p1;
                         JOptionPane.showMessageDialog(this,"WINNER is PLAYER 1");
                   }
                   else
                   {
                       winner = p2;
                       JOptionPane.showMessageDialog(this,"WINNER is PLAYER 2");
                   }
                   playerUpdate(guessText1);
                   buttoncolor(restart); 
                }
                else
                {
                	secretmoviename = movienames[2];
                 	currentp = p1;
                    highlightp();
                    fillPuzzle(); 
                    startpuzzle();
                    
                    player1C.setText("$ ");
                    p1.total(0); 
                    p2.total(0);
                    player2C.setText("$ ");
                    
                    bankrefresh(); 
                    startpuzzle();
                }
            }                                                     
        }   
    }
        

    // --------------------------------------------------------------------
    // solved(e) -> checks guess to see if it matches the movie name
    // --------------------------------------------------------------------
    public int solved(String guess) 
    {
    	guess = guess.toLowerCase();
    	
		if (guess.equals(secretmoviename)) 
		{
            JOptionPane.showMessageDialog(this,"WINNER WINNER!!!\n"+"Player " + currentp.getid() ); 
            return 0;
        }
		else {
			JOptionPane.showMessageDialog(this,"Wrong answer!");
			return 1;
		}
    }
}