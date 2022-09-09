package hwx;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Wheel extends JPanel{

	private int[] optw = {0, 100, 150, 250, 300, 450, 500, 550, 600, 750, 800, 900};
	private int p = 12;
	
    private JTextField br; private JTextField sevenH; private JTextField oneH;
    private JTextField twoH; private JTextField threeH; private JTextField fourH; 
    private JTextField fiveH; private JTextField sixH; private JTextField thisspin;
    private JTextField onefH; private JTextField fivefH; private JTextField eightH;  private JTextField nineH;
    
    
    public Wheel() 
    {
        setLayout(new GridBagLayout());
        // grid bag constraint for putting the wheel together
        GridBagConstraints wheelg = new GridBagConstraints();
        
        // SET UP WHEEL 
        setSize(200,200);
      
        // 100
        wheelg.insets = new Insets(0,0,0,0);
        wheelg.gridx = 5; wheelg.gridy = 2;
        oneH = new JTextField("100");
        oneH.setEditable(false);
        add(oneH, wheelg);
        
        // 150
        wheelg.insets = new Insets(0,0,0,0);
        wheelg.gridx = 8; wheelg.gridy = 1;
        onefH = new JTextField("150");
        onefH.setEditable(false);
        add(onefH, wheelg);
        
        // 250
        wheelg.insets = new Insets(0,0,0,0);
        wheelg.gridx = 9; wheelg.gridy = 2;
        twoH = new JTextField("250");
        twoH.setEditable(false);
        add(twoH, wheelg);
        
        // 300
        wheelg.insets = new Insets(0,0,0,0);
        wheelg.gridx = 5; wheelg.gridy = 3;
        threeH = new JTextField("300");
        threeH.setEditable(false);
        add(threeH, wheelg);
        
        // 450
        wheelg.insets = new Insets(0,0,0,0);
        wheelg.gridx = 9; wheelg.gridy = 3;
        fourH = new JTextField("450");
        fourH.setEditable(false);
        add(fourH, wheelg);
        
        // 500
        wheelg.insets = new Insets(0,0,0,0);
        wheelg.gridx = 7; wheelg.gridy = 1;
        fiveH = new JTextField("500");
        fiveH.setEditable(false);
        add(fiveH, wheelg);
        
        // 550
        wheelg.insets = new Insets(0,0,0,0);
        wheelg.gridx = 9; wheelg.gridy = 4;
        fivefH = new JTextField("550");
        fivefH.setEditable(false);
        add(fivefH, wheelg);
        
        // 600
        wheelg.insets = new Insets(0,0,0,0);
        wheelg.gridx = 6; wheelg.gridy = 5;
        sixH = new JTextField("600");
        sixH.setEditable(false);
        add(sixH, wheelg);
        
        // 750
        wheelg.insets = new Insets(0,0,0,0);
        wheelg.gridx = 6; wheelg.gridy = 1;
        sevenH = new JTextField("750");
        sevenH.setEditable(false);
        add(sevenH, wheelg);
        
        // 800
        wheelg.insets = new Insets(0,0,0,0);
        wheelg.gridx = 8; wheelg.gridy = 5;
        eightH = new JTextField("800");
        eightH.setEditable(false);
        add(eightH, wheelg);
        
        // 900
        wheelg.insets = new Insets(0,0,0,0);
        wheelg.gridx = 5; wheelg.gridy = 4;
        nineH = new JTextField("900");
        nineH.setEditable(false);
        add(nineH, wheelg);
        
        // BANKRUPT 
        wheelg.insets = new Insets(0,0,0,0);
        wheelg.gridx = 7; wheelg.gridy = 5;
        br = new JTextField("0");
        br.setEditable(false);
        add(br, wheelg);
    }
    
    public void around(int x) 
    {
        int rounds = 3; 
        int loops = 0; 
        int counter = 0;
        int c = 0; 
        int spot = 0;
        
        JTextField[] wheelchoices = {br, oneH, onefH, twoH, threeH, fourH, fiveH, fivefH, sixH, sevenH, eightH, nineH};
        
        while (spot < optw.length) 
        {
            if (x != optw[spot]) 
            { 
            	spot++;
            }
            else 
            {
            	counter = spot;
            	break;
            }     
        }
        
        while(loops < rounds+1)
        { 
            thisspin = wheelchoices[c % (p)]; 
            thisspin.setBackground(Color.YELLOW);
            this.setOpaque(true);
            
            if(loops != rounds)
            {
            	 thisspin.setBackground(new JTextField().getBackground());
                 this.setOpaque(true); c++;
                 if(c % p == counter)
                 {
                     loops ++;
                 }	
            }
            else {break;}
        }
    }
}