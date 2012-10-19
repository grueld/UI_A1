package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondWindow extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	protected boolean [] TableGreyScale = new boolean [40];
	protected int [][] TableColour = new int [10][3];

	private JPanel contentPane;
	private int nbrOfColors ;
	private JToolBar tools ;
	private JButton add ;

	public SecondWindow(int n) {

		title() ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(120 * nbrOfColors, 5666660) ;              	         
		setLocation (200,200) ;
		setResizable(true) ;
		setVisible(true) ;

		nbrOfColors = n ;
		tools = new JToolBar() ;
		add = new JButton("Add") ;
		add.addActionListener(this) ;
		tools.add(add) ;
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0,4)) ;
		JPanel all = new JPanel() ;
		all.setLayout(new BorderLayout()) ;
		all.add(tools, BorderLayout.NORTH) ;
		all.add(contentPane, BorderLayout.CENTER) ;
		setContentPane(all) ;
		initComponents();
		pack();
	}

	public void initComponents() {
		for (int i = 0; i < nbrOfColors ; i++) {
			contentPane.add(new ColorPanel(this));
		}
		if (nbrOfColors == 2) {
			ColorPanel c = (ColorPanel) contentPane.getComponent(0) ;
			c.deleteButton.setEnabled(false) ;
			c = (ColorPanel) contentPane.getComponent(1) ;
			c.deleteButton.setEnabled(false) ;
		}
		else if (nbrOfColors == 10) {
			add.setEnabled(false) ;
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
		contentPane.remove(comp);
		nbrOfColors-- ;
		title() ;
		if (nbrOfColors == 2) {
			ColorPanel c = (ColorPanel) contentPane.getComponent(0) ;
			c.deleteButton.setEnabled(false) ;
			c = (ColorPanel) contentPane.getComponent(1) ;
			c.deleteButton.setEnabled(false) ;
		}
		else if (nbrOfColors == 9) {
			add.setEnabled(true) ;
		}
		pack() ;
	}

	public void addColorPanel() {
		nbrOfColors++ ;
		title() ;
		contentPane.add(new ColorPanel(this)) ;
		if (nbrOfColors == 3) {
			ColorPanel c = (ColorPanel) contentPane.getComponent(0) ;
			c.deleteButton.setEnabled(true) ;
			c = (ColorPanel) contentPane.getComponent(1) ;
			c.deleteButton.setEnabled(true) ;
		}
		else if (nbrOfColors == 10) {
			add.setEnabled(false) ;
		}
		pack() ;
	}

	private void title () {
		setTitle("Your " + nbrOfColors + " colors") ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			addColorPanel() ;
		}
	}
}
