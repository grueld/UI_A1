package display;

import javax.swing.*;
import java.awt.*;
//import java.util.*;

public class SecondWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private int nbrOfColors ;
	private AddPanel a ;
	// private List<ColorPanel> colorList= new ArrayList<ColorPanel> () ; not needed for remove feature
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondWindow frame = new SecondWindow(3);
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
	public SecondWindow(int n) {
		nbrOfColors = n ;
		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		setTitle("Your " + nbrOfColors + "colors");
		setSize(120 * nbrOfColors, 100);              	         
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		initComponents();
	}

	public void initComponents() {
		for (int i = 0; i < nbrOfColors ; i++) {
			contentPane.add(new ColorPanel(this));
			//ColorPanel pan = new ColorPanel(this.contentPane) ;
			// colorList.add(pan) ;   not needed for remove feature
		}
		a = new AddPanel(this) ;
		contentPane.add(a) ;
		// for (Object p : colorList) contentPane.add((JPanel) p) ; not needed for remove feature
	}
	
	public void removePanel (Component comp) {
		this.remove(comp) ;
		nbrOfColors-- ;
		setTitle("Your " + nbrOfColors + " colors");
		if (nbrOfColors == 2) {
			ColorPanel c = (ColorPanel) getContentPane().getComponent(0) ;
			c.deleteButton.setEnabled(false) ;
			c = (ColorPanel) getContentPane().getComponent(1) ;
			c.deleteButton.setEnabled(false) ;
		}
		pack() ;
	}
	
	public void addColorPanel() {
		nbrOfColors++ ;
		setTitle("Your " + nbrOfColors + "colors");
		super.remove(a);
		contentPane.add(new ColorPanel(this)) ;
		add(a) ;
		pack() ;
	}

}
