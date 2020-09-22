import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.sequence.Sequence;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.sortingmachine.SortingMachine;
import components.sortingmachine.SortingMachine1L;

/**
 * 
 * This program generate HTML file from input file and show top number of words from input file.
 * 
 * @author SeongRok Ha
 * @author Uijong Kim
 * @version April 16th, 2020
 */

public final class TagCloudGenerator {
	
	private static final int MAXIMUM_FONT = 48;	
	
	static class SortingINT implements Comparator<Integer>	{
		@Override
		public int compare(Integer o1, Integer o2) {		
			return o2.compareTo(o1);
		}
		
	}
	
	static class SortingSTR implements Comparator<String>	{
		@Override
		public int compare(String o1, String o2) {		
			return o1.toLowerCase().compareTo(o2.toLowerCase());
		}
		
	}
	
	/**
	 * This is method to store word and counts into the map without duplicates 
	 * 
	 * @param m Map to store word and word counts
	 * @param in input from File
	 * 
	 */
	public static void wordCounter(Map<String, Integer> m, SimpleReader in)	{
		while (!in.atEOS()) {
			String[] wordArray = in.nextLine().split("[ `\t\n\r,-.!?';:/()\\[\\]_*\"]+");
			for (String word : wordArray) {
				if (!word.isEmpty()) {
					if (m.hasKey(word.toLowerCase())) {
						m.replaceValue(word.toLowerCase(), m.value(word.toLowerCase()) + 1);
					} else {
						m.add(word.toLowerCase(), 1);
					}
				}
			}
			
		}
	}
	
	/**
	 * 
	 * This method is for sorting word by word counts to reduce to Top number
	 * 
	 * @param m Map which has word as a key and counts as a value
	 * @param mq Map which is sorted map by word counts
	 * @param sort sorting Machine for Map mq
	 * 
	 */
	public static void sortWord(Map<String, Integer> m, Map<Integer, Queue<String>> mq, SortingMachine<Integer> sort) {
		for (Map.Pair<String, Integer> p : m) {
			if (mq.hasKey(p.value())) {
				mq.value(p.value()).enqueue(p.key());;
			} else {
				Queue<String> queue = new Queue1L<>();
				queue.enqueue(p.key());
				mq.add(p.value(), queue);
				sort.add(p.value());
			}
		}
		sort.changeToExtractionMode();

		
		
	}
	
	/**
	 * This method is for sorting queue by String
	 * 
	 * @param queue word set from map
	 * @param sm sorting machine for string sort
	 */
	public static void sortByCount (Queue<String> queue, SortingMachine<String> sm) {
		for (String s : queue) {
			sm.add(s);
		}
		
		
		
	}
	
	/**
	 * 
	 * This is method for creating Header
	 * 
	 * @param out writer on output file
	 * @param inputFile String of input file name
	 * @param number number of word that user want to output
	 */
	public static void createHeader(SimpleWriter out, String inputFile, int number)	{
		out.println("<html>");
		out.println("\t<head>");
		out.println("\t\t<title> Top " + number + " words in " + inputFile + "</title>");
		out.println("\t\t<link href=\"http://web.cse.ohio-state.edu/software/2231/web-sw2/assignments/projects/tag-cloud-generator/data/tagcloud.css\" rel=\"stylesheet\" type=\"text/css\">");
		out.println("\t</head>");
		out.println("\t<body>");
		out.println("\t\t<h2>Top " + number + " words in " + inputFile + "</h2>");
		out.println("\t\t<hr>");
		out.println("\t\t<div class=\"cdiv\">");
		out.println("\t\t\t<p class=\"cbox\">");
		
		
	}
	
	/**
	 * This method is for creating Footer
	 * 
	 * @param out writer on output file
	 */
	public static void createFooter(SimpleWriter out) {
		out.println("\t\t\t</p>");
		out.println("\t\t</</div>");
		out.println("\t</body>");
		out.println("</html>");
	}
	
	/**
	 * This method generate cloud 
	 * 
	 * @param s word(key) to get value from map 
	 * @param out writer on output file
	 * @param m map which has key(word) and value(count) from input file
	 * @param max maximum value from sorted map
	 */
	public static void generateCloud(String s, SimpleWriter out, Map<String, Integer> m, int max) {
		
		out.println("\t\t\t\t<span style=\"cursor:default\" class=\"f" + m.value(s)/max * MAXIMUM_FONT + " title=\"count:" + m.value(s) + "\">" + s + "</span>" );  
        
	}

	/**
	 * This is main method for program
	 * 
	 * @param args comment line arguments
	 */
	public static void main(String[] args)	{
		SimpleWriter out = new SimpleWriter1L();
		SimpleReader in = new SimpleReader1L();
		
		out.print("What's the input file's name ? : ");
		String inputfileName = in.nextLine();
		
		out.print("What's the output file's name ? : ");
		String outputfileName = in.nextLine();
		
		out.print("How many words do you want to print out ? : ");
		int numberOfWord = in.nextInteger();
		
		
		SimpleWriter opOnFile = new SimpleWriter1L(outputfileName);
		SimpleReader ipFromFile = new SimpleReader1L(inputfileName);
		
		Map<String, Integer> sortingMap = new Map1L<>();
		
		wordCounter(sortingMap, ipFromFile);
		
		Comparator<Integer> ci = new SortingINT();
		SortingMachine<Integer> sm = new SortingMachine1L<>(ci);
		
		Map<Integer, Queue<String>> numQueueMap = new Map1L<>();
		Comparator<String> ci2 = new SortingSTR();
		SortingMachine<String> sm2 = new SortingMachine1L<>(ci2);
		
		
		sortWord(sortingMap,numQueueMap, sm);

		createHeader(opOnFile, inputfileName, numberOfWord);
		
		int maximumVal = 0;
		
		for ( int i = 0 ; i < numberOfWord ; i++)
		{
			int value = sm.removeFirst();
			
			if (sm2.size() < numberOfWord )
			{
				sortByCount(numQueueMap.value(value), sm2);
			}
			
			if ( maximumVal < value)
			{
				maximumVal = value;
			}
		}
		
		sm2.changeToExtractionMode();
		
		while (sm2.size() != 0) {
			generateCloud(sm2.removeFirst(), opOnFile, sortingMap, maximumVal);
		}
		
		createFooter(opOnFile);
	 	
		
		opOnFile.close();
		ipFromFile.close();
		out.close();
		in.close();
	}
}