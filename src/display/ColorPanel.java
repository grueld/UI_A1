package display;

import javax.swing.*;
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
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0};
		gbl_panel.rowHeights = new int[] {0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0, 0};
		setLayout(gbl_panel);
		
		chooserButton = new JButton("Choose Color");
		GridBagConstraints gbc_btnChooseColor = new GridBagConstraints();
		gbc_btnChooseColor.fill = GridBagConstraints.HORIZONTAL;
//		gbc_btnChooseColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnChooseColor.gridwidth = 2;
		gbc_btnChooseColor.gridx = 0;
		gbc_btnChooseColor.gridy = 0;
		chooserButton.addActionListener(this);
		add(chooserButton, gbc_btnChooseColor);
		
		JLabel lblChosenColor = new JLabel("Chosen Color:");
		GridBagConstraints gbc_lblChosenColor = new GridBagConstraints();
		gbc_lblChosenColor.fill = GridBagConstraints.VERTICAL;
		gbc_lblChosenColor.anchor = GridBagConstraints.BASELINE;
		gbc_lblChosenColor.gridx = 0;
		gbc_lblChosenColor.gridy = 1;
		add(lblChosenColor, gbc_lblChosenColor);
		
		colorPanel = new JPanel();
		colorPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		colorPanel.setPreferredSize(new Dimension(50, 50));
		add(colorPanel, gbc_panel_1);
		
		JLabel lblChosenColorGrey = new JLabel("Chosen Color in greyscale: ");
		GridBagConstraints gbc_lblChosenColorIn = new GridBagConstraints();
		gbc_lblChosenColorIn.anchor = GridBagConstraints.BASELINE;
//		gbc_lblChosenColorIn.insets = new Insets(0, 0, 0, 5);
		gbc_lblChosenColorIn.gridx = 0;
		gbc_lblChosenColorIn.gridy = 2;
		add(lblChosenColorGrey, gbc_lblChosenColorIn);
		
		greyPanel = new JPanel();
		greyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 2;
		greyPanel.setPreferredSize(new Dimension(50, 50));
		add(greyPanel, gbc_panel_2);
		
		deleteButton = new JButton("Delete Color");
		GridBagConstraints gbc_btnDeleteColor = new GridBagConstraints();
		gbc_btnDeleteColor.fill = GridBagConstraints.HORIZONTAL;
		//gbc_btnDeleteColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeleteColor.gridwidth = 2;
		gbc_btnDeleteColor.gridx = 0;
		gbc_btnDeleteColor.gridy = 3;
		deleteButton.addActionListener(this);
		add(deleteButton, gbc_btnDeleteColor);
	}
	
	public int GetAvailableGreyScale(double GreyComponent)
	{
		double SubdivisionLength = 255.0/19;
		int IndexGreyScaleInTable = (int) (GreyComponent/SubdivisionLength);
		if (((SecondWindow)parent).TableGreyScale[IndexGreyScaleInTable] == false) 
		{
			((SecondWindow)parent).TableGreyScale[IndexGreyScaleInTable] = true;
			return (int) (IndexGreyScaleInTable*SubdivisionLength);
		}
		else 
		{
			int i=0;
			while (((SecondWindow)parent).TableGreyScale[i] == true)
			{
				i++;
			}
			((SecondWindow)parent).TableGreyScale[i] = true;
			return (int) (i*SubdivisionLength);
		}
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == chooserButton)
		{
		   Color tmp = JColorChooser.showDialog(this,"Choose color",this.getBackground());
		   if (tmp != null)
		   {
			   Color chosenColor = tmp;
			   colorPanel.setBackground(chosenColor);
			   //Greyscale (luminosity method)
			   double GreyComponent = 0.21*tmp.getRed() + 0.71*tmp.getGreen() + 0.07*tmp.getBlue();
			   int GreyComponentAvailable = GetAvailableGreyScale(GreyComponent);
			   Color chosenColorGrey = new Color (GreyComponentAvailable, GreyComponentAvailable, GreyComponentAvailable);
			   greyPanel.setBackground(chosenColorGrey);
		   }
		 }else if (ae.getSource() == deleteButton)
		 {
			 this.parent.remove(this);
			 this.parent.pack();
		 }
	}
	
}
