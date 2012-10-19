package display;

import javax.swing.*;
import java.awt.*;

public class SecondWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private int nbrOfColors ;
	private AddPanel a ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondWindow frame = new SecondWindow(2);
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

	public SecondWindow(int n) {
		nbrOfColors = n ;
		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout()) ;
		setContentPane(contentPane) ;
		title() ;
		setSize(120 * nbrOfColors, 5666660) ;              	         
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		initComponents();
	}

	public void initComponents() {
		for (int i = 0; i < nbrOfColors ; i++) {
			contentPane.add(new ColorPanel(this));
		}
		a = new AddPanel(this) ;
		contentPane.add(a) ;
		if (nbrOfColors == 2) {
			ColorPanel c = (ColorPanel) getContentPane().getComponent(0) ;
			c.deleteButton.setEnabled(false) ;
			c = (ColorPanel) getContentPane().getComponent(1) ;
			c.deleteButton.setEnabled(false) ;
		}
		else if (nbrOfColors == 10) {
			a.addButton.setEnabled(false) ;
		}
	}
	
	public void removePanel (Component comp) {
		this.remove(comp) ;
		nbrOfColors-- ;
		title() ;
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
		title() ;
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
 
	private void title () {
		setTitle("Your " + nbrOfColors + " colors") ;
	}
}