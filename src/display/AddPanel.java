package display;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddPanel extends JPanel implements ActionListener {

	protected JButton addButton ;
	private JFrame parent;

	public AddPanel(JFrame frame) {
		parent = frame ;
		addButton = new JButton("add") ;
		addButton.addActionListener(this) ;
		add(addButton) ;
		setLayout(new FlowLayout()) ;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			((SecondWindow) parent).addColorPanel() ;
		}
	}

}