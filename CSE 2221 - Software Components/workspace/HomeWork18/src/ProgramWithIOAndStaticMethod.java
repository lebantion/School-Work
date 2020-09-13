import java.util.Comparator;

import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ProgramWithIOAndStaticMethod {

    private static String removeMin(Queue<String> q, Comparator<String> order) {

        int size = q.length();
        String min = "";
        String temp = "";
        for (int i = 0; i < size; i++) {
            temp = q.front();

            if (order.compare(temp, min) < 0) {
                min = temp;
            }

            q.rotate(1);
        }

        int count = 0;
        boolean tracker = true;
        while (count > size && tracker) {
            temp = q.front();

            if (order.compare(temp, min) == 0) {
                q.dequeue();
                tracker = false;
            }

            count++;
        }

        return min;
    }

    public static void sort(Queue<String> q, Comparator<String> order) {
        Queue<String> temp = new Queue1L<String>();

        while (q.length() != 0) {
            temp.enqueue(removeMin(q, order));
        }

        while (temp.length() != 0) {
            q.enqueue(temp.dequeue());
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        Queue<String> test = new Queue1L<String>();

        test.enqueue("book");
        test.enqueue("banana");
        test.enqueue("apple");

        Comparator<String> sT = new ComparatorSt();

        String result = removeMin(test, sT);

        out.println(result);

    }

}
