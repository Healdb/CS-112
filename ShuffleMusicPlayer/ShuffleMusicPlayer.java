
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ShuffleMusicPlayer extends JPanel implements ActionListener{

    /**
     * Constant for the number of character on the display. 
     * 
     */
    public static final int DISPLAY_WIDTH = 40;

    //Graphical interface components (buttons and text fields)
    JRadioButton random, continuous;
    
    //Graphical interface components (buttons and text fields)
    protected JButton begin, end, next, previous;
    protected JTextField display;

    //the play list object
    protected ShufflePlaylist music;
    
    /**
     * Creates a new <code>ShuffleMusicPlayer</code> instance.
     *  Builds the user interface
     */
    public ShuffleMusicPlayer(){
	//create the play list
	music = new ShufflePlaylist();

	//create user interface components
	begin = new JButton("|<");
	end = new JButton(">|");
	next = new JButton(">>");
	previous = new JButton("<<");
	random = new JRadioButton("Random");
	continuous = new JRadioButton("Continuous");
	display = new JTextField(DISPLAY_WIDTH);

	// set up the radio buttons
	continuous.setSelected(true);
	ButtonGroup group = new ButtonGroup();
	group.add(continuous);
	group.add(random);

	//set up the display text field
	display.setEditable(false);

	//get the initial data to display
	String title = music.first();
	int track = music.getCurrentTrackNumber();
	display.setText(track + ": " + title);

	//make the display pretty
	display.setHorizontalAlignment(JTextField.CENTER);
	display.setBackground(Color.BLACK);
	display.setForeground(Color.GREEN);
	display.setFont(new Font("Courier", Font.BOLD, 18));

	//make all of the buttons call the actionPerformed method when clicked
	begin.addActionListener(this);
	end.addActionListener(this);
	next.addActionListener(this);
	previous.addActionListener(this);
	random.addActionListener(this);
	continuous.addActionListener(this);

	//layout the display
	setLayout(new BorderLayout());

	//create a random mode subpanel
	JPanel modePanel = new JPanel();
	modePanel.add(continuous);
	modePanel.add(random);

	//create a button subpanel
	JPanel buttonPanel = new JPanel();
	buttonPanel.add(begin);
	buttonPanel.add(previous);
	buttonPanel.add(next);
	buttonPanel.add(end);

	//add the panels and the display
	add(modePanel, BorderLayout.SOUTH);
	add(buttonPanel, BorderLayout.CENTER);
	add(display, BorderLayout.NORTH);
	
       
    }


    /**
     * actionPerformed is called when the user clicks a button
     *
     * @param e an <code>ActionEvent</code> value
     */
    public void actionPerformed(ActionEvent e){
	if(e.getSource() == begin){
	    //the user hit the begin button |<
	    String title = music.first();
	    int track = music.getCurrentTrackNumber();
	    display.setText(track + ": " + title);
	}
	else if(e.getSource() == end){
	    //the user hit the end button >|
	    String title = music.last();
	    int track = music.getCurrentTrackNumber();
	    display.setText(track + ": " + title);
	} 
	else if(e.getSource() == next){
	    //the user hit next >>
	    String title = music.getNext();
	    int track = music.getCurrentTrackNumber();
	    display.setText(track + ": " + title);
	} 
	else if(e.getSource() == previous){
	    //the user hit previous <<
	    String title = music.getPrevious();
	    int track = music.getCurrentTrackNumber();
	    display.setText(track + ": " + title);
	} 
	else if(e.getSource() == random){
	    //the user turned on random mode
	    music.turnOnRandom();
	} 
	else if(e.getSource() == continuous){
	    //the user turned off random mode
	    music.turnOffRandom();
	} 
	else {
	}
    }

    public static void main(String[] args){
	//create the JFrame
	JFrame f = new JFrame("Music Player");

	//add a MusicPlayer panel
	f.add(new ShuffleMusicPlayer());

	//make sure the x button works
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//make it resize itself
	f.pack();

	//display it
	f.setVisible(true);
    }

}
