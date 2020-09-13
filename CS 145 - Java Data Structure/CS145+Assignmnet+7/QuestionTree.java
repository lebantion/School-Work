/* This Program helps to run 20-Questions game which is the game of computer try to guess user's objects.
 * 
 * @param total_game counting total number of game
 * @param num_win counting total win of game(computer)
 * @param Game_root when there is no data for the game it would start from this Node
 * @Param my interface to use fuction in UserInterface.
 *
 * @author SeongRok Ha(844926202)
 * @version December 3rd 2018
 *
*/


import java.util.*;
import java.io.*;

public class QuestionTree
{

 public class QuestionNode // this is inner class to make Leaf Node and Branch Node
 {
	   public String data;
      public QuestionNode left; //Yes
      public QuestionNode right; //No
                
      // leaf Node
      public QuestionNode(String data) 
      {
         this(data, null, null);
      }
                        
      // branch Node
      // left subtree
      // right subtree
      public QuestionNode(String data, QuestionNode left,QuestionNode right) 
      {
         this.data = data;
         this.left = left;
         this.right = right;
      }
  }
  
  UserInterface my;
  
  public int total_game;
  
  public int num_win;
  
  private QuestionNode Game_root;
  
   public QuestionTree(UserInterface ui)
   {
		my = ui;
		Game_root = new QuestionNode("computer");
		total_game = 0;
      num_win = 0;
   }
  
  public void play()
  {
    my.println("Play Game here");
   
    total_game++;
   
    Game_root = play(Game_root);
   
  }
  
  // to use recursion make new play function.
  
  public QuestionNode play(QuestionNode x)
  {
   
   String User_input;

	if (x.left != null && x.right != null) // if there is more question to guess object, ask to user.
	{
		my.println(x.data); 

		// question
		User_input = my.nextLine();
      
      User_input.toLowerCase();
      
		if (User_input.equals("yes") || User_input.equals("y")) // if the answer is yes, go left question
		{
			x.left = play(x.left);
		}
		else if (User_input.equals("no") || User_input.equals("n")) // if the answer is no, go right question
		{
			x.right = play(x.right);				
		}
	}
	else // else guess the answer
	{
		my.println("Would your object happen to be "+ x.data.substring(2) + "?");
		
      User_input = my.nextLine();
		
      User_input.toLowerCase();
      
      if (User_input.equals("yes") || User_input.equals("y")) // if guessing is correct, count number of win
		{
			my.println("I win!");
			num_win++;
		}
      
		else if (User_input.equals("no") || User_input.equals("n")) // if it is not, add object and question to guess it.
		{
			my.println("I lose.  What is your object?");
			String newObjectText = my.nextLine(); // add object
			
         my.println("Type a yes/no question to distinguish your item " + "from " + x.data.substring(2) + " : ");
			String questionText = my.nextLine(); // add question to guess new object			
			
         my.println("And what is the answer for your object?");
			boolean answer = my.nextBoolean(); // add answer of question to guess new object
			
         QuestionNode new_Q = new QuestionNode("  " + questionText);
         
			QuestionNode new_A = new QuestionNode("  " + newObjectText);
         
			QuestionNode oldRoot = x;

			// yes response
			if (answer) // if it is ture, put new answer on new question's left ( which is yes)
			{
				new_Q.left = new_A; 
				new_Q.right = oldRoot; 
			}

			// no response
			else // if it is not, put new answer on new question's right ( which is no )
			{
				new_Q.left = oldRoot; 
				new_Q.right = new_A;		
			}
			x = new_Q; // set Node with new question
      }
   }    
      return x; //return x to put information to Node
 }
  public void save(PrintStream output) // save Questions
  {
      save(output, Game_root);
  }
  
  // to use recursion make new save function.
  
  public void save(PrintStream output, QuestionNode x)
  {
    my.println("Save the current tree here");
    
    if (x != null) // if the node is not null
		{
			if (x.left != null && x.right != null) // if the node's left data and right data is not null call question.
			{
				my.println("Q:" + x.data.substring(2));
				
				output.println("Q:" + x.data.substring(2));
            
				save(output, x.left); // use recursion to save output on (answer Yes)
				save(output, x.right);	// use recursion to save output on (answer right
			} 
			else // if it is not, give answer data
			{
				my.println("A:" + x.data.substring(2));
				output.println("A:" + x.data.substring(2));
			}	
		}
  }
  
  public void load(Scanner input) // load previous game data
  {
   Game_root = load(input, Game_root);
  }
  
  // to use recursion make new load function.
  
  public QuestionNode load(Scanner input, QuestionNode current)
  {
    if (input.hasNextLine()) // scan for get question or answer
		{
			String temp = input.nextLine();
			
			current = new QuestionNode(temp); // make leaf node
			
			// check for a Q or A 
			char responseType = temp.charAt(0);
			
			if (current != null) // if current Node is not null and the type is Question, use recursion to load current tree.
			{
				if (responseType == 'Q')
				{
					temp = temp.substring(2, temp.length());
					current.left = load(input, current);
					current.right = load(input, current);
				}
			}
		}
      return current;
  }
  
  public int totalGames() // output total game user played
  {
    return total_game;
  }
  
  public int gamesWon() // output total number of win computer won 
  {
    return num_win;
  }
  
}