package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstWindow extends JFrame {

	private JPanel container = new JPanel() ;    // un JFrame contient un ou plusieurs JPanel
	int colors ;
	JComboBox combo1 ;
	JButton but ;

	public FirstWindow() {
		// ici on a le titre, la taille et quelques settings de la fenetre
		setTitle ("chaud les marons chauds") ;
		setSize (200, 200) ;                               
		setLocation (300,0) ;              	         
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ; 
		setResizable (true) ;
		initComposants() ;
		setContentPane(container) ; //ici on ajoute le JPanel qui contient tout ce que l'on veut afficher
		setVisible(true);			
	}

	private void initComposants() {
		JLabel lab = new JLabel("how many for you?") ;
		lab.setFont (new Font("Courier", Font.BOLD, 18)) ;

		String[] tab = {"2", "3", "4", "5"} ;
		combo1 = new JComboBox(tab);
		combo1.addActionListener(new ButtonListener()) ;

		but = new JButton("chaud patate") ;  
		but.addActionListener (new ButtonListener()) ;


		/*
			JLabel label1 = new JLabel("Joueur 1:") ;             // on crée un label, c'est-à-dire une phrase que l'on veut afficher
			label1.setFont (new Font("Courier", Font.BOLD, 18));  //on choisi le format du text
			un_jpanel.add (label1) ;                              //ensuite on doit l'ajouter à un JPanel
		 */

		container.setLayout(new BorderLayout());  // on choisit le layout qui va oganiser le JPanel
		container.setBackground(Color.WHITE);

		container.add(but, BorderLayout.EAST) ;  
		container.add(combo1, BorderLayout.WEST) ;
		container.add(lab, BorderLayout.NORTH) ;
	}

	/**
	 * Ecoute les clics sur les boutons
	 */
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == combo1) colors = (Integer.valueOf (combo1.getSelectedItem().toString())) ;
			if (arg0.getSource() == but) new SampleWindow() ;
			//essayer de faire une pop-up

		}
	}
}