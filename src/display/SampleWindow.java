package display;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SampleWindow extends JFrame {

	private JPanel container = new JPanel() ;    // un JFrame contient un ou plusieurs JPanel

	String[] tab_string_control = {"Let's Rock!", "Stop"} ;
	JButton[] tab_button_control = new JButton[tab_string_control.length ] ;  
	int N = 100 ;  

	private Dimension dim = new Dimension(180, 40);   // on peut définir une variable contenant une dimension de boutons
	Font font = new Font("Courier", Font.BOLD, 18) ; // on peut aussi définir une variable contenant un format de texte

	public SampleWindow() {
		// ici on a le titre, la taille et quelques settings de la fenetre
		setTitle ("Sample window") ;
		setSize (500, 400) ;                               
		setLocation (500,0) ;              	         
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ; 
		setResizable (true) ;
		initComposants() ;
		setContentPane(container) ; //ici on ajoute le JPanel qui contient tout ce que l'on veut afficher
		setVisible(true);			
	}

	private void initComposants() {

		JPanel Boutons = new JPanel() ;
		JPanel affichage = new JPanel() ;

		/*
		JLabel label1 = new JLabel("Joueur 1:") ;             // on crée un label, c'est-à-dire une phrase que l'on veut afficher
		label1.setFont (new Font("Courier", Font.BOLD, 18));  //on choisi le format du text
		un_jpanel.add (label1) ;                              //ensuite on doit l'ajouter à un JPanel
		 */

		// INITIALISATION DES BOUTONS
		for ( int i = 0 ; i < tab_string_control.length ; i++ ) {
			tab_button_control[i] = new JButton(tab_string_control[i]);
			tab_button_control[i].setPreferredSize(dim) ;   //configure le choix de la dimension
			tab_button_control[i].addActionListener (new BoutonListener()) ;  // on ajoute un listener qui permet d'écouter le clic
			tab_button_control[i].setEnabled(true) ;     // permet de rendre utilisable ou non un bouton
			tab_button_control[i].setFont(font) ;        // configure un format pour le texte du bouton
			Boutons.add (tab_button_control[i]) ;  // on ajoute le bouton à un JPanel pour l'afficher
		}

		// LE CONTENEUR
		container.setLayout(new BorderLayout());  // on choisit le layout qui va oganiser le JPanel
		container.setBackground(Color.WHITE);

		Boutons.setBackground(Color.white) ;
		container.add(Boutons, BorderLayout.SOUTH) ;  //on place les boutons dans le JPanel suivant le layout
	}

	/**
	 * pour l'affichage il faut souvent utiliser repaint() mais je ne sais plus à quel moment
	 */
	public void affichageBataille (int choix1, int choix2, int score) {
		//p1.repaint() ;
		//p2.repaint();
	}

	/**
	 * Ecoute les clics sur les boutons
	 */
	class BoutonListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == tab_button_control[0]) {     // permet d'identitifier quel bouton
				tab_button_control[0].setEnabled(false) ;
				tab_button_control[1].setEnabled(true) ;
			}
			if (arg0.getSource() == tab_button_control[1]) {     // permet d'identitifier quel bouton
				double [] tab = new double[3] ;
				tab_button_control[0].setEnabled(true) ;
				tab_button_control[1].setEnabled(false) ;
			}
		}
	}
}