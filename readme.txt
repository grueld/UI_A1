cse23089, 212433577, Gruel, Damien
cse23088, 212577425, Lavalette, Ludovic
cse83049, 209987066, Nahas, Serge

-------
Design:
-------

To enable the user to remove colors dynamically after having chosen an initial number of them,  
the class ColorPanel extends JPanel so that each instance can listen to its own delete button.
ColorPanel has a GridBagLayout so that each component has a different size.
The class JColorChooser is used to let the user pick colors in different ways (i.e. HSB, RGB ...).
The conversion from RGB to greyscale is done using the following formula:
	0.2125G + 0.7154G + 0.0721B
which is called the luminosity method to account for human perception
	Wikipedia: en.wikipedia.org/wiki/GreyScale
Taking into account the fact that the chosen colors have to look distinct, 
the result of the conversion is modified by dividing 255 into the maximum number of colors allowed (10), and approximating
the resulting conversion.
	 
--------------------
Additional Features: (optional)
--------------------

The user can add and remove colors dynamically by respectively pressing the 'add' button on the toolbar, and the 'delete' button for each 
ColorPanel. The 'add' button is in a toolbar so that the user can add several colorPanels by pressing on the same
button as many times as needed without having to move the mouse. 
The 'delete' buttons make it easier for the user to pick which color to delete.
When there are only 2 colors left, the 'delete' buttons on each colorPanel get disabled.
Similarly when there are 10 colorPanels, the 'add' button gets disabled.
The GUI will also alert the user when the same color is chosen twice.

---------------
Communications:
---------------
All members where present at each meeting

October 12, 2012; 4:00 - 8:00;
Setup of Git for source control.
First thoughts on designing the GUI.

October 15, 2012; 2:30 - 7:00;
Designed and coded main classes for GUI.
Discussed ways to convert the colors to greyscale.

October 18, 2012; 6:00 - 10:00;
Coded the conversion to greyscale and added features to add/remove number of colors.

October 19, 2012; 3:00 - 8:00;
Improved the GUI design and fixed last remaining bugs.
Finished readme.txt

-----------------
Responsibilities:
-----------------

Serge:
GUI layout and programming, add/remove feature programming

Damien:
GUI layout and programming, add/remove feature programming

Ludovic:
Conversion to greyscale programming, add/remove feature programming