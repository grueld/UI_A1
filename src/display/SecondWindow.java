package display;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SecondWindow extends JFrame {

	private JPanel contentPane;
	private List<ColorPanel> cPList= new ArrayList<ColorPanel> () ;
	
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
			ColorPanel pan = new ColorPanel() ;
			cPList.add(pan) ;
		}
		for (Object p : cPList) contentPane.add((JPanel) p) ;
	}
	
	public void deleteColorPanel (int id) {
		cPList.remove(id) ;
		this.dispose() ;
	}
}
