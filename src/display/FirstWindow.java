package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FirstWindow extends JFrame {

	private JPanel container = new JPanel() ;    // un JFrame contient un ou plusieurs JPanel
	int colors = 2 ;
	JComboBox combo1 ;
	JButton but ;

	public FirstWindow() {
		// ici on a le titre, la taille et quelques settings de la fenetre
		setTitle ("Choose number of colors") ;
		setSize (400, 100) ;                               
		setLocation (300,0) ;              	         
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ; 
		setResizable (false) ;
		initComposants() ;
		setContentPane(container) ; //ici on ajoute le JPanel qui contient tout ce que l'on veut afficher
		setVisible(true);
	}

	private void initComposants() {
		JLabel lab = new JLabel("How many colors do you want?") ;
		lab.setFont (new Font("Courier", Font.BOLD, 18)) ;
		lab.setBorder(new EmptyBorder(0,0,0,10));

		String[] tab = {"2", "3", "4", "5", "6", "7", "8", "9", "10"};
		combo1 = new JComboBox(tab);
		combo1.addActionListener(new ButtonListener()) ;

		but = new JButton("OK") ;  
		but.addActionListener (new ButtonListener()) ;

		container.setLayout(new FlowLayout());  // on choisit le layout qui va oganiser le JPanel
		container.setBackground(Color.WHITE);
		container.add(lab);
		container.add(combo1);
		container.add(but);  

	}

	/**
	 * Ecoute les clics sur les boutons
	 */
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == combo1) {
				colors = (Integer.valueOf (combo1.getSelectedItem().toString())) ;
			}
			else if (arg0.getSource() == but) {
				new SecondWindow(colors) ;
				FirstWindow.this.dispose() ;
			}
			//essayer de faire une pop-up
		}
	}
}