import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 
 * This program generate HTML file from input file and show top number of words from input file.
 * 
 * @author SeongRok Ha
 * @author Uijong Kim
 * @version April 23rd, 2020
 */

public final class TagCloudGeneratorJava {

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
	public static void wordCounter(Map<String, Integer> m, Scanner in)	{
		while (in.hasNextLine()) {
			String[] wordArray = in.nextLine().split("[ `\t\n\r,-.!?';:/()\\[\\]_*\"]+");
			for (String word : wordArray) {
				if (!word.isEmpty()) {
					if (m.containsKey(word.toLowerCase())) {
						m.replace(word.toLowerCase(), m.get(word.toLowerCase()) + 1);
					} else {
						m.put(word.toLowerCase(), 1);
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
	public static void sortWord(Map<String, Integer> m, Map<Integer, Queue<String>> mq, List<Integer> sort, Comparator<Integer> ci) {
		for (String p : m.keySet()) {
			if (mq.containsKey(m.get(p))) {
				mq.get(m.get(p)).add(p);;
			} else {
				Queue<String> queue = new LinkedList<>();
				queue.add(p);
				mq.put(m.get(p), queue);
				sort.add(m.get(p));
			}
		}

		Collections.sort(sort, ci);		
	}

	/**
	 * This method is for sorting queue by String
	 * 
	 * @param queue word set from map
	 * @param sm sorting machine for string sort
	 */
	public static void sortByCount (Queue<String> q, List<String> sortedList) {
		for (String s : q) {
			sortedList.add(s);
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
	public static void createHeader(PrintWriter out, String inputFile, int number)	{
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
	public static void createFooter(PrintWriter out) {
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
	public static void generateCloud(String s, PrintWriter out, Map<String, Integer> m, int max) {

		out.println("\t\t\t\t<span style=\"cursor:default\" class=\"f" + Math.round(((double) m.get(s)/max * MAXIMUM_FONT)) + " title=\"count:" + m.get(s) + "\">" + s + "</span>" );  

	}

	/**
	 * This is main method for program
	 * 
	 * @param args comment line arguments
	 */
	public static void main(String[] args)	{

		Scanner in = new Scanner(System.in);

		System.out.print("What's the input file's name ? : ");
		String inputFileName = in.nextLine();

		System.out.print("What's the output file's name ? : ");
		String outputFileName = in.nextLine();
		PrintWriter opOnFile = null;

		try {
			File outputFile = new File(outputFileName);
			while (!outputFile.createNewFile()) {
				System.out.println("File already exists.");
				System.out.print("What's the output file's name ? : ");
				outputFileName = in.nextLine();
				outputFile = new File(outputFileName);
			}

			opOnFile = new PrintWriter(outputFileName);

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			System.exit(1);
		}

		System.out.print("How many words do you want to print out ? : ");
		int numberOfWord = in.nextInt();

		Scanner inputScanner = null;

		try {

			File inFile = new File(inputFileName); 
			inputScanner = new Scanner(inFile);

		} catch (FileNotFoundException e) {

			System.out.println("File does not exist");
			System.exit(1);

		}

		Map<String, Integer> sortingMap = new HashMap<>();
		wordCounter(sortingMap, inputScanner);

		Comparator<Integer> ci = new SortingINT();
		List<Integer> sortedIntList = new ArrayList<>();

		Map<Integer, Queue<String>> numQueueMap = new HashMap<>();
		Comparator<String> ci2 = new SortingSTR();

		List<String> sortedStrList = new ArrayList<>();

		sortWord(sortingMap,numQueueMap, sortedIntList, ci);
		
		int maximumVal = 0;
		if (numberOfWord > sortedIntList.size()) {
			numberOfWord = sortedIntList.size();
		}
		
		createHeader(opOnFile, inputFileName, numberOfWord);

		
		for ( int i = 0 ; i < numberOfWord ; i++)
		{
			int value = sortedIntList.remove(0);

			if (sortedStrList.size() < numberOfWord )
			{
				sortByCount(numQueueMap.get(value), sortedStrList);
			}

			if ( maximumVal < value)
			{
				maximumVal = value;
			}
		}

		Collections.sort(sortedStrList, ci2);

		while (sortedStrList.size() != 0) {
			generateCloud(sortedStrList.remove(0), opOnFile, sortingMap, maximumVal);
		}

		createFooter(opOnFile);

		inputScanner.close();
		in.close();
		opOnFile.close();
	}

}