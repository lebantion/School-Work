import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * CSE2231 Project 1.
 * Word Count Project.
 *
 * @author SeongRok Ha(ha.241)
 * @version September 3rd 2020
 */
public final class WordHTML {

	/**
	 * This is comparator for sorting Queue.
	 *
	 * @author SeongRok Ha(ha.241)
	 * @version September 3rd 2020
	 */
	public static class SortingStr implements Comparator<String> {

		@Override
		public int compare(String a, String b) {
			return a.toLowerCase().compareTo(b.toLowerCase());
		}
	}

	/**
	 * This method generate HTML's header.
	 *
	 * @param out to output in the file.
	 */
	private static void headerHTML(SimpleWriter out) {
		out.println("   <head>");
		out.println("       <title> words counter </title>");
		out.println("   </head>");
	}

	/**
	 * This method make HTML's body about word counts alphabetical order.
	 *
	 * @param out output in file
	 * @param in Scanner for input File
	 * @requires in must not empty
	 */
	private static void bodyHTML(SimpleWriter out, SimpleReader in) {
		Queue<String> wordKeyQ = new Queue1L<String>();
		Map<String, Integer> wordMap = new Map1L<String, Integer>();

		generateCounts(in, wordKeyQ, wordMap);

		Comparator<String> sorting = new SortingStr();

		wordKeyQ.sort(sorting);

		out.println("   <body>");
		out.println("       <h2> word counter </h2>");
		out.println("       <hr>");
		out.println("      <table border = \"1\">");
		out.println("           <tbody>");
		out.println("               <tr>");
		out.println("                   <th>Words</th>");
		out.println("                   <th>Counts</th>");
		out.println("               </tr>");

		wordTable(wordMap, wordKeyQ, out);

		out.println("           </tbody>");
		out.println("       </table>");
		out.println("   </body>");
	}

	/**
	 * This method generates table for words
	 *
	 * @param wordmap the map which contains word and word's counts.
	 * @param keyset the queue for keys
	 * @param out output variable on file.
	 * @updates keyset
	 */
	private static void wordTable(Map<String, Integer> wordmap, Queue<String> keyset, SimpleWriter out) {
		while (keyset.length() != 0) {
			String key = keyset.dequeue();

			if (wordmap.hasKey(key)) {
				out.println("               <tr>");
				out.println("                   <th>" + key + "</th>");
				out.println("                   <th>" + wordmap.value(key)
				+ "</th>");
				out.println("               </tr>");
			}
		}
	}

	/**
	 * This method generate Map and Queue for counting words
	 *
	 * @param in inputfile to scan
	 * @param q Queue for keyset in Map
	 * @param wordMap word counts in input file
	 * @updates q
	 * @updates wordMap 
	 */
	public static void generateCounts(SimpleReader in, Queue<String> q,
			Map<String, Integer> wordMap) {
		while (!in.atEOS()) {
			String line = in.nextLine();

			if (!line.isBlank()) {

				int lengthCount = 0;

				line = line.trim();

				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == ' ' || line.charAt(i) == ',' || line.charAt(i) == '-' || line.charAt(i) == '.' || ( lengthCount != i && i == line.length()) ) {

						String word = line.substring(lengthCount, i);

						lengthCount = i;

						while ( word.startsWith(" ") || word.startsWith(",") || word.startsWith("-") || word.startsWith("."))
						{
							word = word.substring(1, word.length()); 
						}

						if (!word.isBlank())
						{
							if (!wordMap.hasKey(word)) {
								wordMap.add(word, 1);
								q.enqueue(word);
							} else {
								wordMap.replaceValue(word,  wordMap.value(word) + 1);
							}
						}
					}

				}

				if ( lengthCount != line.length())
				{
					String word = line.substring(lengthCount, line.length());

					while ( word.startsWith(" ") || word.startsWith(",") || word.startsWith("-") || word.startsWith("."))
					{
						word = word.substring(1, word.length()); 
					}

					while( word.endsWith(" ") || word.endsWith(".") || word.endsWith("-") || word.endsWith(",") )
					{
						word = word.substring(0, word.length() - 1);
					}

					if (!word.isBlank())
					{
						if (!wordMap.hasKey(word)) {
							wordMap.add(word, 1);
							q.enqueue(word);
						} else {
							wordMap.replaceValue(word,  wordMap.value(word) + 1);
						}
					}
				}
			}
		}
	}

	/**
	 * This method make whole HTML file by use headerHTML and bodyHTML method (combine).
	 *
	 * @param in inputfile scanner
	 * @param out output writter in file
	 */
	public static void generateHTML(SimpleReader in, SimpleWriter out) {

		out.println("<html>");

		headerHTML(out);
		
		bodyHTML(out, in);

		out.println("</html>");
	}

	/**
	 * User has to give a inputfile name to scan word and outputfile name to generate outputfile.
	 *
	 * @param args not using
	 */
	public static void main(String[] args)
	{

		SimpleWriter out = new SimpleWriter1L();
		SimpleReader in = new SimpleReader1L();

		out.print("FileName to Scan: ");
		String fileName = in.nextLine();

		SimpleReader inputFile = new SimpleReader1L(fileName);

		out.print("New FileName to Output? : ");
		String newFilename = in.nextLine();

		SimpleWriter newFile = new SimpleWriter1L(newFilename);

		generateHTML(inputFile, newFile);

		out.close();
		in.close();
		newFile.close();
		inputFile.close();

	}

}
