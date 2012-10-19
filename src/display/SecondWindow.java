package display;

import javax.swing.*;
import java.awt.*;

public class SecondWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	protected boolean [] TableGreyScale = new boolean [40];
	protected int [][] TableColour = new int [10][3];
	
	private JPanel contentPane;
	private int nbrOfColors ;
	private AddPanel a;

	public SecondWindow(int n) {
		nbrOfColors = n ;
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0,4)) ;
		setContentPane(contentPane) ;
		title() ;
		setSize(120 * nbrOfColors, 5666660) ;              	         
		setLocation (200,200) ;
		pack();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		initComponents();
		pack();
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
		
		//initialization of the tables
		for (int i=0; i<40; i++)
		{
			TableGreyScale[i]=false;
		}
		for (int i=0; i<10;i++)
		{
			for(int j=0; j<3; j++)
			{
				TableColour[i][j]=-1;
			}
		}
	}
	
	@Override
	public void remove (Component comp) {
		super.remove(comp);
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
