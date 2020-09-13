// CS 145 ASSIGNMENT 5
// GUI INTERFACE

import java.awt.*; // for Dimension
import java.awt.event.*;
import javax.swing.*; // for GUI components 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/** CS145
 * Class AnagramMainGUI is the driver program for the Anagram program.  It reads a
 * dictionary of words to be used during the game and then asks the user to create a
 * data structure to sort through them.
 *
 * <p>This version uses a GUI to force students to not have access to the console.
 *
 * <p><B>
 * STUDENTS SHOULD NOT MODIFY THIS PROGRAM IN ANY WAY.
 * </B>
 * @author Michael A. Wood
 * @version 1.0
 */

public class AnagramMainGUI implements ActionListener  
{
   // Dictionary File name.
    public static final String DICTIONARY_FILE = "dictionary.txt";

    // GUI ELEMENTS
    private JFrame frame;
    private JButton button1;
    private JTextField edit1;
    private JLabel text1;
    private JLabel text2;
    private JTextArea text3;
    private JTextArea text4;    
    
    private JLabel sortW;
    private JLabel sortF;
    private JScrollPane scrollPane3;
    private JScrollPane scrollPane4;
    private JCheckBox debugMode;
    private List<String> dictionary;
    private List<String> dictionary2;
    private AnagramManager catalog;
	
    /**  Main Program.
     *
     * @param args The OS parameters
     */
	public static void main(String[] args)  {
       AnagramMainGUI gui = new AnagramMainGUI();
    }
    
    /** The constructor that preps the GUI and all its components
     *
     */
    public AnagramMainGUI()
    {
    
        // Call private method to set up the form.
        formSetup();
    
        // Open the file and read the words into the dictionary.
        // Lower case as going.
        try{
		   Scanner input = new Scanner(new File(DICTIONARY_FILE));
   		   dictionary = new ArrayList<String>();
		   while (input.hasNext()) {
			  dictionary.add(input.next().toLowerCase());
		   }
         }
         catch (FileNotFoundException e)
         {
           // Exit the program after outputing error to both console and Dialog box.
           System.out.println("File not found error :  " + e);
           JOptionPane.showMessageDialog(null,"File not found error :  " + e); 
           System.exit(0);
         }
      
		// set up the AnagramManager
        // Create an unmodifiable dictionary list to pass to the manager
        // the manager is called catalog.
		dictionary2 = Collections.unmodifiableList(dictionary);
		catalog = new AnagramManager(dictionary2);
        
        // Show the debugging data.
        // This is where the sorting is needed.
        catalog.sortByWord();
        text3.setText(catalog.toString());
        catalog.sortByForm();
        text4.setText(catalog.toString()); 
        
        // Open the frame.        
    	frame.setVisible(true);

     }  
     
     /**
      * This method responds to all events thrown by the various elements
      * of the GUI
      * @param event The action event thrown by the GUI
      */
     @Override 
     public void actionPerformed(ActionEvent event)
     {
       //  If button is pressed or enter is pressed while the edit box has focus.
       if (event.getActionCommand().equals("FindAnagram"))
       {
        // Get the text from the edit box.
         String x = edit1.getText();
         String y;
         // Use the AnagramManager HERE
         String result = catalog.getAnagram(x);
         // if the result is blank
         if (!result.equals("") )
            y = "One possible anagram of the word " + x + " is     ::  " + result;
         else
            y = "Your word was not found in the list";
         // Display the output.
         text1.setText(y);
         
         // Show the list of anagrams.
          String z = "In fact the list of anagrams for the word are    :: ";
          z+= catalog.getAnagrams(x);
          text2.setText(z);
       }      
       if (event.getActionCommand().equals("debugMode"))
       {
          // Display the neccessary debuging tools
          scrollPane3.setVisible(debugMode.isSelected());
          scrollPane4.setVisible(debugMode.isSelected()); 
          sortW.setVisible(debugMode.isSelected());
          sortF.setVisible(debugMode.isSelected()); 
          
          // Resize the window.
          if (debugMode.isSelected())
             frame.setSize(new Dimension(800, 300));
          else
              frame.setSize(new Dimension(800, 150));             
                   
       }
     }
     
     // Commands to set up the form.   
     // Note that the form must still be set to visible.
     // This does everything but that.
     private void formSetup()
     {
        // GUI SETUP
        // Window setup.      
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(new Point(100, 500));
        frame.setSize(new Dimension(800, 150));
        frame.setTitle("Anagrams");
        frame.setLayout(new FlowLayout()); 
        // Find Anagram button
        button1 = new JButton();
        button1.setText("Find Anagram");
        button1.addActionListener(this );
        button1.setActionCommand("FindAnagram");
        // User input Edit Field
        edit1 = new JTextField();
        edit1.setPreferredSize( new Dimension( 200, 24 ) );
        edit1.setActionCommand("FindAnagram");
        edit1.addActionListener(this );
        
        // Output Text Fields
        text1 = new JLabel();
        text1.setText("NOTHING");
        text2 = new JLabel();
        text2.setText("NOTHING");
        text3 = new JTextArea();
        text3.setText("NOTHING");
        text4 = new JTextArea();
        text4.setText("NOTHING");  

        // Debugging Tools        
        scrollPane3 = new JScrollPane(text3);
        scrollPane4 = new JScrollPane(text4);
        scrollPane3.setVisible(false);
        scrollPane4.setVisible(false);
        sortW = new JLabel();
        sortW.setText("Sorted by Word");  
        sortF = new JLabel();
        sortF.setText("Sorted by Form");  
        sortW.setVisible(false);        
        sortF.setVisible(false);        
        
        // Debugging Radio Button
        debugMode = new JCheckBox();
        debugMode.setText("Debug Mode");
        debugMode.addActionListener(this );
        debugMode.setActionCommand("debugMode");

        // Add components to frame.
        frame.add(button1);
        frame.add(edit1);
        frame.add(text1);
        frame.add(text2);
        frame.add(scrollPane3);
        frame.add(scrollPane4);
        frame.add(debugMode);
        frame.add(sortW);
        frame.add(sortF);
        
        // Layout the frame.
        // null layout to demonstrate the idea.   
        // not using the default layouts to show the idea.
        frame.setLayout(null); 
        edit1.setBounds (185, 10, 200, 25);
        button1.setBounds(10,10,150,25);
        text1.setBounds(10, 50, 750,25);
        text2.setBounds(10, 80, 750,25);
        sortW.setBounds(10, 110, 100,40);
        sortF.setBounds(10, 180, 1000,40);
        scrollPane3.setBounds(115, 110, 650,40);
        scrollPane4.setBounds(115, 180, 650,40);
        debugMode.setBounds(400, 10, 100,25);
        
         
        // Inline function to set focus on the edit box. 
        frame.addWindowFocusListener(new WindowAdapter() 
                                     { public void windowGainedFocus(WindowEvent e) 
                                       {edit1.requestFocusInWindow();}
                                     });
                                     

     }
}
