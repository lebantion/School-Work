import java.io.PrintStream;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class QuestionTree.
 *
 * @author jtryon
 * @version 1.0
 * 
 * Represents the class fields for the binary tree
 */
public class QuestionTree1
{
	
	/** The overall root. */
	private QuestionNode overallRoot;
	
	/** The ui. */
	private UserInterface ui;
	
	/** The num games. */
	private int numGames;
	
	/** The games won. */
	private int gamesWon;


	/**
	 * Instantiates a new question tree.
	 *
	 * @param ui the ui
	 */
	public void QuestionTree(UserInterface ui)
	{
		this.ui = ui;
		overallRoot = new QuestionNode("computer");
		this.numGames = 0;
		this.gamesWon = 0;
	}

	/**
	 * Calls a private helper method play to start playing the game 
	 */
	public void play() 
	{
		numGames++;
		overallRoot = play(overallRoot);
	}

	/**
	 * Starts a game with the user asking yes/no questions until
	 * reaching an answer object.  The game continues until the computer
	 * wins the game or if the computer is unable to guess the answer,
	 * the tree asks the user  what the object was and a question
	 * to distinguish the object from the player's guess and a
	 * yes/no answer for that question
	 * @param root the root
	 * @return the question node
	 */
	private QuestionNode play(QuestionNode root) 
	{
      
		String response;

		if (root.left != null && root.right != null)
		{
			ui.println(root.data); 

			//ask User
			response = ui.nextLine();
			if (response.equals("yes") || response.equals("y"))	
			{
				root.left = play(root.left);
			}
			else if (response.equals("no") || response.equals("n"))
			{
				root.right = play(root.right);				
			}
		}
		else
		{
			ui.println("Would your object happen to be "+ root.data.substring(2) + "?");
			response = ui.nextLine();

			if (response.equals("yes") || response.equals("y"))
			{
				ui.println("I win!");
				gamesWon++;
			}
			else if (response.equals("no") || response.equals("n"))
			{
				ui.println("I lose.  What is your object?");
				String newObjectText = ui.nextLine();

				ui.println("Type a yes/no question to distinguish your item "
						+ "from " + root.data.substring(2) + ":");
				String questionText = ui.nextLine();				
				ui.println("And what is the answer for your object?");
				boolean answerText = ui.nextBoolean();

				QuestionNode newQuestion = new QuestionNode(questionText);
				QuestionNode newAnswer = new QuestionNode(newObjectText);

				QuestionNode oldRoot = root;

				// yes response
				if (answerText)
				{
					newQuestion.left = newAnswer;
					newQuestion.right = oldRoot;
				}

				// no response
				else 
				{
					newQuestion.left = oldRoot;
					newQuestion.right = newAnswer;		
				}

				root = newQuestion;
			}
		}
		return root;
	}


	
	private void save(PrintStream output, QuestionNode root)
	{
		if (root != null)
		{
			if (root.left != null && root.right != null)
			{
				ui.println("Q:" + root.data);
				
				output.println("Q:" + root.data);
				save(output, root.left);
				save(output, root.right);	
			}
			else 
			{
				ui.println("A:" + root.data);
				output.println("A:" + root.data);
			}	
		}
	}
	

	private QuestionNode load(Scanner input, QuestionNode current)
	{
		if (input.hasNextLine())
		{
			String line = input.nextLine();
			
			current = new QuestionNode(line);
			
			// check for a Q or A 
			char responseType = line.charAt(0);
			
			if (current != null)
			{
				if (responseType == 'Q')
				{
					line = line.substring(2, line.length());
					current.left = load(input, current);
					current.right = load(input, current);
				}
			}
		}
		return current;
	}
	
	/**
	 * Returns the total number of games played
	 *
	 * @return the int
	 */
	public int totalGames()
	{
		return numGames;
	}

	/**
	 * Returns the total number of games won
	 *
	 * @return the int
	 */
	public int gamesWon()
	{
		return gamesWon;
	}
}