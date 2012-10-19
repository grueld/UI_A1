package display;

import javax.swing.JOptionPane;

public class Window {

	public static void main(String[] args) {
		String[] tab = {"2", "3", "4", "5", "6", "7", "8", "9", "10"};
		JOptionPane jop = new JOptionPane() ;
		// creation of the first pop_up
		String color = (String)jop.showInputDialog(null, 
				"How many colors do you want ?",
				"Choose number of colors",
				JOptionPane.QUESTION_MESSAGE,
				null,
				tab,
				tab[0]);

		// if the user doesn't cancel
		if (color != null) {
			System.out.println("allo" + color +"\n") ;
			new SecondWindow(Integer.valueOf (color)) ;
		}
	}

}
