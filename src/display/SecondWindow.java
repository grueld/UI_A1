package display;

import javax.swing.*;
import java.awt.*;
//import java.util.*;

public class SecondWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	// private List<ColorPanel> colorList= new ArrayList<ColorPanel> () ; not needed for remove feature
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondWindow frame = new SecondWindow(4);
					frame.setLocation (200,200) ;
					frame.pack();
					frame.setVisible(true);
					frame.setResizable(false) ;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecondWindow(int nbrOfColors) {
		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		setTitle("Your colors");
		setSize(120 * nbrOfColors, 100);              	         
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		initComponents(nbrOfColors);
	}

	public void initComponents(int nbrOfColors) {
		for (int i = 0; i < nbrOfColors ; i++) {
			contentPane.add(new ColorPanel(this));
			//ColorPanel pan = new ColorPanel(this.contentPane) ;
			// colorList.add(pan) ;   not needed for remove feature
		}
		// for (Object p : colorList) contentPane.add((JPanel) p) ; not needed for remove feature
	}
	
	// no need to use this method since the remove feature is implemented in the 
	// action listener of class ColorPanel
	/*public void deleteColorPanel (int id) {
		colorList.remove(id) ;
//		List<ColorPanel> newList
		this.dispose() ;
		
	}*/
}
