package display;

import javax.swing.*;
import java.awt.*;
//import java.util.*;

public class SecondWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private int nbrOfColors ;
	private AddPanel a;
	// private List<ColorPanel> colorList= new ArrayList<ColorPanel> () ; not needed for remove feature
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondWindow frame = new SecondWindow(12);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public SecondWindow(int n) {
		nbrOfColors = n ;
		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout()) ;
		setContentPane(contentPane) ;
		setTitle("Your " + nbrOfColors + "colors");
		setSize(120 * nbrOfColors, 5666660) ;              	         
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		initComponents();
		pack();
	}

	public void initComponents() {
		for (int i = 0; i < nbrOfColors ; i++) {
			contentPane.add(new ColorPanel(this));
			//ColorPanel pan = new ColorPanel(this.contentPane) ;
			// colorList.add(pan) ;   not needed for remove feature
		}
		// for (Object p : colorList) contentPane.add((JPanel) p) ; not needed for remove feature
	}
	
	@Override
	public void remove (Component comp) {
		super.remove(comp);
		nbrOfColors-- ;
		setTitle("Your " + nbrOfColors + " colors");
		if (nbrOfColors == 2) {
			ColorPanel c = (ColorPanel) getContentPane().getComponent(0) ;
			c.deleteButton.setEnabled(false) ;
			c = (ColorPanel) getContentPane().getComponent(1) ;
			c.deleteButton.setEnabled(false) ;
		}
		else if (nbrOfColors == 9) {
			a.addButton.setEnabled(true) ;
		}
		pack() ;
	}
	
	public void addColorPanel() {
		nbrOfColors++ ;
		setTitle("Your " + nbrOfColors + "colors") ;
		super.remove(a) ;
		contentPane.add(new ColorPanel(this)) ;
		add(a) ;
		if (nbrOfColors == 3) {
			ColorPanel c = (ColorPanel) getContentPane().getComponent(0) ;
			c.deleteButton.setEnabled(true) ;
			c = (ColorPanel) getContentPane().getComponent(1) ;
			c.deleteButton.setEnabled(true) ;
		}
		else if (nbrOfColors == 10) {
			a.addButton.setEnabled(false) ;
		}
		pack() ;
	}

}
