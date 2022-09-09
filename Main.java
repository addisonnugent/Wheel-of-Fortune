package hwx;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
    	
    	WheelOfFortune wfortune = new WheelOfFortune();  	
        wfortune.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        wfortune.pack();
        wfortune.setVisible(true);
    }

}