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

public class FirstWindow extends JFrame {

	private JPanel container = new JPanel() ;

	String[] tab_string_control  = {"Let's Rock!", "Stop", "Accelerate", "Graph"} ;
	JButton[] tab_button_control   = new JButton[tab_string_control.length ] ;  // ensemble des boutons de control
	int N = 10000 ;   //NOMBRE DE BATAILLES

	private Dimension dim = new Dimension(180, 40);   // pour les boutons de controle
	Font font ; // format par defaut du texte

	private Thread t;
	boolean fonctionne = false ;  // un thread a deja ete cree sans etre termine
	public boolean lent = true ;  // ralentir l'affichage ou non

	public FirstWindow() {
		setTitle ("Simulation Papier-Caillou-Ciseaux") ;
		setSize (1000, 700) ;                               
		setLocation (500,0) ;              	         
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ; 
		setResizable (false) ;
		initComposants() ;
		setContentPane(container) ;
		setVisible(true);			
	}

	private void initComposants() {

		JPanel Boutons = new JPanel() ;
		JPanel affichage = new JPanel() ;

		JLabel label1 = new JLabel("Joueur 1:") ;
		label1.setFont (new Font("Courier", Font.BOLD, 18));
		//			Strategy1.add (label1) ;

		// INITIALISATION DES BOUTONS
		// les boutons de control
		for ( int i = 0 ; i < tab_string_control.length ; i++ ) {
			tab_button_control[i] = new JButton(tab_string_control[i]);
			tab_button_control[i].setPreferredSize(dim);
			tab_button_control[i].addActionListener (new BoutonListener()) ;
			tab_button_control[i].setEnabled (false) ;
			Boutons.add (tab_button_control[i]) ;
		}
		font = tab_button_control[0].getFont() ;

		// LE CONTENEUR
		container.setLayout(new BorderLayout());
		container.setBackground(Color.WHITE);
		Boutons.setBackground(Color.white) ;

		// POSITIONNEMENT ET AJOUT DES BOUTONS
		container.add(Boutons, BorderLayout.SOUTH) ;
	}

	/**
	 * Affiche les images corresponda	nt au choix de chaque joueur
	 * @param choix1 : pour le joueur 1
	 * @param choix2 : pour le joueur 2
	 * score: correspond au score du joueur 1 (on en déduit le score du joueur deux
	 * car le jeu est a smme nulle) 
	 */
	public void affichageBataille (int choix1, int choix2, int score) {
//		p1.repaint() ;
//		p2.repaint();
	}

	public void enableButtons() {
		for (JButton bouton: tab_button_control) {
			bouton.setEnabled(true) ;
			bouton.setFont(font) ;
		}
//		for (JButton bouton: tab_button_strategy1) {
//			bouton.setEnabled(true) ;
//			bouton.setFont(font) ;
//		}
//		for (JButton bouton: tab_button_strategy2) {
//			bouton.setEnabled(true) ;
//			bouton.setFont(font) ;
//		}

	}

	/**
	 * Ecoute les boutons de demarrage et d'arret de la simulation
	 */
	class BoutonListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == tab_button_control[0]) {     // debut/reprise
				tab_button_control[0].setEnabled(false) ;
				tab_button_control[1].setEnabled(true) ;
				tab_button_control[2].setEnabled(true) ;
				if (fonctionne == false) {
					fonctionne = true ;
					t = new Thread (new PlaySimulation()) ;
					t.start() ;
				}
				else {
					t.resume() ;
				}
			}
			else if (arg0.getSource() == tab_button_control[1]) {   // stop
				tab_button_control[0].setEnabled(true) ;
				tab_button_control[1].setEnabled(false) ;
				lent = true ;
				t.suspend() ;
			}
			else if (arg0.getSource() == tab_button_control[2]) {    // accelerate
				lent = false ;
			}
			else if (arg0.getSource() == tab_button_control[3]) {    // graph
				double [] tab = new double[3] ;
				tab_button_control[3].setEnabled(false) ;
				GraphingData graph = new GraphingData( tab ) ;
				container.add(graph, BorderLayout.CENTER) ;
				lent = true ;
				enableButtons() ;
				for (JButton bouton: tab_button_control) { bouton.setEnabled(false) ;}
			}
		}
	}

	/**
	 * Ecoute les boutons de choix des strategies
	 */
	class StrategyListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			tab_button_control[0].setEnabled(true) ;
			Font font1 = new Font("Courier", Font.BOLD, 16);
			Font font2 = new Font("Courier", Font.BOLD, 10);

			// POUR LES QUATRES PREMIERES STRAGTEGIES: JOUEUR 1
			//				if (arg0.getSource() == tab_button_strategy1[0]) {
			//					strategy1 = new Optimale() ;
			//					for (int i = 0; i < tab_string_strategy.length; i++) {
			//						tab_button_strategy1[i].setFont (font2) ;
			//						tab_button_strategy1[i].setEnabled(false) ;
			//					}
			//				}
			//				else if (arg0.getSource() == tab_button_strategy1[1]) {     
			//					strategy1 = new BufferVariable( 20 ) ;
			//					for (int i = 0; i < tab_string_strategy.length; i++) {
			//						tab_button_strategy1[i].setFont (font2) ;
			//						tab_button_strategy1[i].setEnabled(false) ;
			//					}
			//					tab_button_strategy1[1].setFont (font1) ;
			//					p1.setStrategy("buffer20") ;
			//				}
		}
	}

	/**
	 * Classe implementant Runnable pour pouvoir créer un thread contenant la simulation,
	 * elle peut ainsi etre stoppée puis remise en route
	 */
	class PlaySimulation implements Runnable {

		public void run() {
			setName ("Thread d'affichage") ;
			// l'activité principale du thread
			//	PCC.partie (N, strategy1, strategy2, FenetreSimulation.this) ;
			fonctionne = false ;
			tab_button_control[1].setEnabled(false) ;
			lent = true ;
		}

	}
}


