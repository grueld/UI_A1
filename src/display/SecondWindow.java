package display;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SecondWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondWindow frame = new SecondWindow(6);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecondWindow(int nbrOfColor) {
		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout()) ;
		
		setTitle ("Your colors") ;
		setSize(120 * nbrOfColor, 100) ;
		setLocation (300,100) ;              	         
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ; 
		initComposants(nbrOfColor) ;
		setContentPane(contentPane);
		setResizable (false) ;
		setVisible(true) ;
	}

	public void initComposants(int nbrOfColor) {
		for (int i = 0; i < nbrOfColor ; i++) {
			JPanel pan = new JPanel() ;
			pan.setSize(100, 100) ;
			pan.add(new JButton("num pan" + i)) ;
			contentPane.add(pan) ;
		}
	}
}
