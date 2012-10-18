package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorPanel extends JPanel implements ActionListener 
{
	private JButton chooserButton;
	private Color chosenColor;
	private Color chosenColorGrey;
	private JPanel colorPanel;
	private JPanel greyPanel;
	
	public ColorPanel()
	{
		super();
		chooserButton = new JButton("Choose Color");
		colorPanel = new JPanel();
		greyPanel = new JPanel();
		chooserButton.addActionListener(this);
		setLayout(new GridLayout(3, 1));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		add(chooserButton);
		add(colorPanel);
		add(greyPanel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	   if (ae.getSource() == chooserButton)
	   {
		   Color tmp = JColorChooser.showDialog(this,"Choose color",this.getBackground());
		   if (tmp != null)
		   {
			   chosenColor = tmp;
			   colorPanel.setBackground(chosenColor);
			   //Greyscale (luminosity method)
			   int GreyComponent = (int) (0.21*tmp.getRed() + 0.71*tmp.getGreen() + 0.07*tmp.getBlue());
			   chosenColorGrey = new Color (GreyComponent, GreyComponent, GreyComponent);
			   greyPanel.setBackground(chosenColorGrey);
		   }
	   }
	}
}