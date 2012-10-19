package display;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ColorPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JButton chooserButton;
	private JPanel colorPanel;
	private JPanel greyPanel;
	protected JButton deleteButton;
	private JFrame parent;
	
	public ColorPanel(JFrame frame) 
	{
		super();
		this.parent = frame;
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		chooserButton = new JButton("Choose Color");
		chooserButton.setPreferredSize(new Dimension((int) this.getSize().getWidth(), 50));
		chooserButton.addActionListener(this);
		add(chooserButton);
		
		JLabel lblChosenColor = new JLabel("Chosen Color:");
		lblChosenColor.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		add(lblChosenColor);
		
		colorPanel = new JPanel();
		colorPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		colorPanel.setPreferredSize(new Dimension(50, 50));
		add(colorPanel);
		
		JLabel lblChosenColorGrey = new JLabel("Chosen Color in greyscale: ");
		lblChosenColorGrey.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		add(lblChosenColorGrey);
		
		greyPanel = new JPanel();
		greyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		greyPanel.setPreferredSize(new Dimension(50, 50));
		add(greyPanel);
		
		deleteButton = new JButton("Delete Color");
		deleteButton.addActionListener(this);
		add(deleteButton);
	}
	
	
	public int GetAvailableGreyScale(Color tmp)
	{
		double GreyComponent = 0.2125*tmp.getRed() + 0.7154*tmp.getGreen() + 0.0721*tmp.getBlue();
		double SubdivisionLength = 255.0/9;
		int IndexGreyScaleInTable = (int) (GreyComponent/SubdivisionLength);
		if (((SecondWindow)parent).TableGreyScale[IndexGreyScaleInTable] == false) 
		{
			((SecondWindow)parent).TableGreyScale[IndexGreyScaleInTable] = true;
			((SecondWindow)parent).TableColour[IndexGreyScaleInTable][0] = tmp.getRed();
			((SecondWindow)parent).TableColour[IndexGreyScaleInTable][1] = tmp.getGreen();
			((SecondWindow)parent).TableColour[IndexGreyScaleInTable][2] = tmp.getBlue();
			return (int) (IndexGreyScaleInTable*SubdivisionLength);
		}
		else 
		{
			int i=0;
			while (((SecondWindow)parent).TableGreyScale[i] == true && i<40)
			{
				i++;
			}
			((SecondWindow)parent).TableGreyScale[i] = true;
			((SecondWindow)parent).TableColour[i][0] = tmp.getRed();
			((SecondWindow)parent).TableColour[i][1] = tmp.getGreen();
			((SecondWindow)parent).TableColour[i][2] = tmp.getBlue();
			return (int) (i*SubdivisionLength);
		}
	}
	
	
	public int IndexOfColor(Color tmp)
	{
		boolean IndexFound = false;
		int i=0;
		while(IndexFound == false && i<10)
		{
			if(((SecondWindow)parent).TableColour[i][0] == tmp.getRed())
			{
				if(((SecondWindow)parent).TableColour[i][1] == tmp.getGreen())
				{
					if(((SecondWindow)parent).TableColour[i][2] == tmp.getBlue())
					{
						IndexFound = true;
					}
				}
			}
			i++;
		}
		if (IndexFound == true)
		{
			return (i-1);
		}
		else
		{
			return -1;
		}
	}
	
	
	public void RemoveColorInTables(Color tmp)
	{
		int IndexOfTmp = IndexOfColor(tmp);
		if (IndexOfTmp != -1)
		{
			((SecondWindow)parent).TableGreyScale[IndexOfTmp] = false;
			((SecondWindow)parent).TableColour[IndexOfTmp][0] = -1;
			((SecondWindow)parent).TableColour[IndexOfTmp][1] = -1;
			((SecondWindow)parent).TableColour[IndexOfTmp][2] = -1;	
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == chooserButton)
		{
		   Color tmp = JColorChooser.showDialog(this,"Choose color",this.getBackground());
		   System.out.println(tmp);
		   if (tmp != null)
		   {
			   int IndexOfTmp = IndexOfColor(tmp);
			   if(IndexOfTmp == -1)
			   {
				   Color chosenColor = tmp;
				   colorPanel.setBackground(chosenColor);
				   //Greyscale (luminosity method)
				   int GreyComponentAvailable = GetAvailableGreyScale(tmp);
				   Color chosenColorGrey = new Color (GreyComponentAvailable, GreyComponentAvailable, GreyComponentAvailable);
				   greyPanel.setBackground(chosenColorGrey);
			   }
			   else
			   {
				   JOptionPane j1 = new JOptionPane();
				   j1.showMessageDialog(null, "You have aleady chosen this color !", "Error", JOptionPane.ERROR_MESSAGE);
			   }
		   }
		 }else if (ae.getSource() == deleteButton)
		 {
			 Color tmp = this.colorPanel.getBackground();
			 if (tmp != null)
			 {
				 RemoveColorInTables(tmp);
			 }
			 this.parent.remove(this);
			 this.parent.pack();
		 }
	}
}
