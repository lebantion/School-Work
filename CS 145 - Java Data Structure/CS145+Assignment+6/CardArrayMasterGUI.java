import java.awt.*; // for Dimension
import java.awt.event.*;
import javax.swing.*; // for GUI components 
import java.io.File;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/** CS145
 * Class CardArrayMasterGUI is the driver program for the List program.  It reads a
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
 
public class CardArrayMasterGUI implements ActionListener  
{
   private boolean DEBUGMODE = false;
   private static final int STAGECOUNT = 13;
   private CardArrayList masterList1 = new CardArrayList();
   private PrintStream SO = System.out;  // Lazy mode  enabled;
    // GUI ELEMENTS
   private JFrame frame;
   private JButton button1;
   private JLabel[] text;
   private JTextArea[] textData;
   private JScrollPane[] textBox;
   private JComboBox<String> levelSelector;    
   private JCheckBox debugMode;
    
     /**  Main Program.
     *
     * @param args The OS parameters
     */
   public static void main(String[] args)  {
      CardArrayMasterGUI gui = new CardArrayMasterGUI();
   }
    
    /** CardArrayMasterGUI Constructor
     *  <p> This sets up the form and makes it visible
     *
     */
   public CardArrayMasterGUI()
   {
    
        // Call private method to set up the form.
      formSetup();
   
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
      resetAnswers();
      int x = levelSelector.getSelectedIndex() + 1; 
      if (event.getActionCommand().equals("debugMode"))
      {
         DEBUGMODE = debugMode.isSelected();
      }
      if (event.getActionCommand().equals("Start") || event.getActionCommand().equals("debugMode"))
      {
         stage0();
         masterList1 = new CardArrayList();
         stage1();
         if (x > 1) stage2();
         if (x > 2) stage3();
         if (x > 3) stage4();
         if (x > 4) stage5();
         if (x > 5) stage6();
         if (x > 6) stage7();
         if (x > 7) stage8();
         if (x > 8) stage9();
         if (x > 9) stage10();
         if (x > 10) stage11();
         if (x > 11) stage12();
         if (x > 12) stage13();
         
      }
   }
     
     /*
      * This method sets all the stage answers to a blank value
      */
     
   private void resetAnswers()
   { 
      for(int i = 0; i < STAGECOUNT; i++)
         textData[i].setText("NOTHING");
   }
     
     /*
      * set up the GUI form and all components.
      */
   private void formSetup()
   {
        // Window setup.      
      frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocation(new Point(100, 100));
      frame.setSize(new Dimension(800,800));
      frame.setTitle("Anagrams");
      frame.setLayout(new FlowLayout()); 
   
        // Start the process button
      button1 = new JButton();
      button1.setText("Start");
      button1.addActionListener(this );
      button1.setActionCommand("Start");
        
        // Setup the level checker
      String[] levels = new String[STAGECOUNT];
      for(int i = 0; i < STAGECOUNT; i++)
         levels[i] = "Stage " + (i+1);
      levelSelector = new JComboBox<String>(levels);
        
        // Output Text Fields
      text = new JLabel[STAGECOUNT];
      textData = new JTextArea[STAGECOUNT] ;
      textBox = new JScrollPane[STAGECOUNT] ;
      for(int i = 0; i < STAGECOUNT; i++)
      {
         text[i]     = new JLabel();
         text[i].setText("Stage " + (i+1) );
         textData[i] = new JTextArea();
         textData[i].setText("NOTHING");
         textBox[i]  = new JScrollPane(textData[i]);
      }
        
                
        // Debugging Radio Button
      debugMode = new JCheckBox();
      debugMode.setText("Debug Mode");
      debugMode.addActionListener(this );
      debugMode.setActionCommand("debugMode");    
      debugMode.setBounds(650, 10, 100,25);    
        
   
        
        // Add components to frame.
      frame.add(button1);
      frame.add(levelSelector);
      frame.add(debugMode);
      for(int i = 0; i < STAGECOUNT; i++)
      {
         frame.add(text[i]);
         frame.add(textBox[i]);
      }
        
        // Layout the frame.
        // null layout to demonstrate the idea.   
        // not using the default layouts to show the idea.
      frame.setLayout(null); 
      button1.setBounds(10,10,150,25);
        
      for(int i = 0; i < STAGECOUNT; i++)
      {
         text[i].setBounds(10, 50+(45*i), 100,25);
         textBox[i].setBounds(110, 50+(45*i), 600,40);
      }
        
      levelSelector.setBounds(400, 10, 100,25);
   }
     
     
//**********************************************************************************
//**                          STAGE TESTING                                     ****     
//**********************************************************************************

   //****  STAGE 0 TESTING  *******
   // This tests to see if the proper exceptions
   // are thrown.
     
   public void stage0()
   {
      if(!DEBUGMODE) 
         return;
      System.out.println("Testing Exceptions");
      try
      {
         Card xx = new Card(1001,1001);
         JOptionPane.showMessageDialog(null,"FAILED Exception Catching");
         System.exit(0);
      }
      catch (Exception e)
      {
         System.out.println("PASSED Stage 0");
      }
   }

     //****  STAGE 1 TESTING  *******
     //Can we add cards to the list?
     
   private void stage1()
   {
        
      masterList1.add(new Card());     
      masterList1.add(new Card(20));     
      masterList1.add(new Card(10,10));
      String x ="Initial list   : ";
      x += masterList1;
      textData[0].setText(x); 
        
      if(DEBUGMODE)
         if (masterList1.size() == 3 && masterList1.toString().contains("],[20/20],[10/10]")) 
           SO.println("PASSED STAGE 1"); 
         else SO.println("   FAILED STAGE 1");
   
   }

     //****  STAGE 2 TESTING  *******
     //Do premium cards work?
     
   private void stage2()
   {
      masterList1.add(new PremiumCard(100));     
      String x = "Premium Card   : "; 
      x += masterList1;
      textData[1].setText(x);
      if(DEBUGMODE)
         if (masterList1.toString().contains(",{{100/100}}")) 
            SO.println("PASSED STAGE 2"); 
         else SO.println("   FAILED STAGE 2");
   }

    //****  STAGE 3 TESTING  *******
    //Can we add cards in the middle??
    // .add(#, card)
     
   private void stage3()
   {
      masterList1.add(1, new Card(4,4));
      masterList1.add(1, new Card(5,5));
      String x = "Added internal : "; 
      x +=  masterList1;    
      textData[2].setText(x);
     
      if(DEBUGMODE)
         if (masterList1.toString().contains(",[5/5],[4/4],[20/20],")) 
            SO.println("PASSED STAGE 3"); 
         else SO.println("   FAILED STAGE 3");
   }     
     
    //****  STAGE 4 TESTING  *******
    //can we add more cards and make it expand 
    //past the initial array size?
    
   private void stage4()
   {
      masterList1.add(new Card(6));
      masterList1.add(new Card(7));
      masterList1.add(new Card(8));
      masterList1.add(new Card(9));
      masterList1.add(new Card(10));
      masterList1.add(new Card(11));
      masterList1.add(new Card(12));
      String x = "After Expand   : "; 
      x +=  masterList1 ;
      textData[3].setText(x);
   
      if(DEBUGMODE)
         if (masterList1.toString().endsWith(":13]")) 
            SO.println("PASSED STAGE 4"); 
         else SO.println("   FAILED STAGE 4");
   }

    //****  STAGE 5 TESTING  *******
    //Does remove work?  
    //does it remove the last element?

   private void stage5()
   {
      masterList1.remove();
      String x = "After Remove   : "; 
      x +=  masterList1 ;
      textData[4].setText(x);
      if(DEBUGMODE)
         if (masterList1.toString().endsWith(":12]")) 
            SO.println("PASSED STAGE 5"); 
         else SO.println("   FAILED STAGE 5");
   }

    //****  STAGE 6 TESTING  *******
    //Does remove RETURN the object removed?
    
   private void stage6()
   {
      String x = "Removed value  : "; 
      Card tmp = masterList1.remove() ;
      x +=  tmp ;
      x +=  " -- List afterward : "; 
      x +=  masterList1 ;
      textData[5].setText(x);
          
      if(DEBUGMODE)
         if (tmp.toString().equals("[11/11]")) 
            SO.println("PASSED STAGE 6"); 
         else SO.println("   FAILED STAGE 6");
   }
     
   //****  STAGE 7 TESTING  *******
   //Did it remove from the middle of the list?
   // And return the value removed?
          
   private void stage7()
   {
      Card tmp = masterList1.remove(2);
      if(DEBUGMODE)
         if (tmp.toString().equals("[4/4]"))  
            SO.println("PASSED STAGE 7A"); 
         else SO.println("   FAILED STAGE 7A");
   
      String x = "Removed value  : "; 
      x += tmp ;
      x += " -- List afterward : "; 
      x += masterList1;
      textData[6].setText(x);
   
      if(DEBUGMODE)
         if (masterList1.toString().contains(",[5/5],[20/20],")) 
            SO.println("PASSED STAGE 7B"); 
         else SO.println("   FAILED STAGE 7B");
   }
   
   //****  STAGE 8 TESTING  *******
   //Does the GET command work correctly?
   //Does weaken and boost work correctly?
   
   private void stage8()
   {
      String x = "Get Values     : "; 
      x += masterList1.get(2) + " : " + masterList1.get(4) ;
         
      if(DEBUGMODE)
         if (x.contains("[20/20] : {{100/100}}")) 
            SO.println("PASSED STAGE 8A"); 
         else SO.println("   FAILED STAGE 8a");
   
      masterList1.get(2).weaken();
      masterList1.get(4).boost();
      x += "  Altered Values : "; 
      String xx = masterList1.get(2) + " : " + masterList1.get(4) ; 
      x += xx;
      textData[7].setText(x);
         
      if(DEBUGMODE)
         if (xx.contains("[18/18] : {{110/110}}")) 
            SO.println("PASSED STAGE 8B"); 
         else SO.println("   FAILED STAGE 8b");
         
   }
   
   //****  STAGE 9 TESTING  *******
   //Does the indexOF command work correctly?
   //Does weaken and boost work correctly?
   
   private void stage9()
   {
      String x = "";
         
      x+="Card {{110,110}} Should be at (4)->";
      x+=masterList1.indexOf(new Card(110,110));
      x+="  ,  Card (9,9) Should be at (8)->";
      x+=masterList1.indexOf(new Card(9,9)); 
      x+="  ,  Card (600,600) Should be at (-1)->";
      x+=masterList1.indexOf(new Card(600,600));
      x+= " ";
      textData[8].setText(x);
         
      if(DEBUGMODE)
         if (masterList1.indexOf(new Card(110,110)) == 4 &&
           masterList1.indexOf(new Card(600,600)) == -1 &&
           masterList1.indexOf(new Card(9,9)) == 8)       
            SO.println("PASSED STAGE 9"); 
         else SO.println("   FAILED STAGE 9");
   
         
   }
   
   //****  STAGE 10 TESTING  *******
   //Does shuffle work correctly?
   //Note: this does not autograde.  Check it manually.
   
   private void stage10()
   {
      String x = "";
      x += "Before shuffle : ";
      x += masterList1;
      masterList1.shuffle();
      x += "    Post shuffle 1 : ";
      x += (masterList1);
      masterList1.shuffle();
      x += ("   Post shuffle 2 : ");
      x += masterList1 ; 
           
      textData[9].setText(x);
           
      if(DEBUGMODE)
         SO.println("STAGE 10 - Check manually"); 
          
   }
   
   //****  STAGE 11 TESTING  *******
   //Does clear work correctly?

   private void stage11()
   {
          // STAGE 11
          // Does Clear Work?
      String x = "";
      masterList1.clear();
      x += ("After Clear    : ");
      x += (masterList1);
      textData[10].setText(x);
          
      if(DEBUGMODE)
         if (masterList1.size() == 0 && masterList1.toString().equals("[0: :0]"))
            SO.println("PASSED STAGE 11"); 
         else SO.println("   FAILED STAGE 11");
   
   }

   //****  STAGE 12 TESTING  *******
   //Does sort work correctly.
   //Note this expects the sort to go from HIGH to LOW.
   //This tests the SORT and the CARD
   
   private void stage12()
   {
      // STAGE 12
      // Create a large list
      // And check that sort works.
     
      for (int i=0; i <100; i++)
      {
         masterList1.add(new Card());
      }
      for (int i=0; i <5; i++)
      {
         masterList1.add(new PremiumCard());
      }
      
      masterList1.sort();
      
      String x = "";
      x+="Success Sorted : ";
      x+=masterList1;
      textData[11].setText(x);
      
      if(DEBUGMODE)
      {
         boolean pass = true;
         String error = "";
         for (int j = 0; j <masterList1.size() - 1; j++)
         {
          //SO.print(masterList1.get(j).getCost());
          //SO.print("-");
            if (masterList1.get(j).getCost() < masterList1.get(j+1).getCost() )
            {
               pass = false;
            
               error += (" " + masterList1.get(j)+"("+masterList1.get(j).getCost()+")" +"::" 
                       + masterList1.get(j+1)+"("+masterList1.get(j+1).getCost()+")");
            }
         }
          //SO.println(masterList1.get(masterList1.size()-1).getCost());;
         if (pass) SO.println("PASSED STAGE 12"); 
         else 
         { 
            SO.println("   FAILED STAGE 12  -- ");
            SO.println(error);
         }
      }
      
   }
   
   //****  STAGE 13 TESTING  *******
   // Can we create a second list
   // and make a copy of all NON premium cards   
   //Note: this does not autograde.  Check it manually.
      
   private void stage13()
   {
      CardArrayList masterList2 = new CardArrayList(1);
      for (int j = 0; j <masterList1.size(); j++)
      {
         if (!(masterList1.get(j) instanceof PremiumCard))
         {
            masterList2.add(masterList1.get(j) );
         }
      }
      String x = ("Success Removed: ");
      x += (masterList2);
     
      textData[12].setText(x);
   
      if(DEBUGMODE)
         SO.println("STAGE 13 - Check manually"); 
   }
}