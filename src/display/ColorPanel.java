package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorPanel extends JPanel implements ActionListener 
{
	private JButton chooserButton;
	private Color chosenColor;
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
    	  }
      }
   }

}