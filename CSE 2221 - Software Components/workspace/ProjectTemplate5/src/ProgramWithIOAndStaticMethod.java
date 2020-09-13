import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.stack.Stack;
import components.stack.Stack1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ProgramWithIOAndStaticMethod {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    public void flip() {
        Stack<Integer> temp = new Stack1L<Integer>();

        temp.push(1);
        temp.push(2);
        temp.push(3);
        temp.push(4);

        Stack<Integer> temp2 = new Stack1L<Integer>();

        while (temp.length() == 0) {
            temp2.push(temp.pop());
        }

        temp.transferFrom(temp2);
    }

    public void sequenceFlip() {
        Sequence<Integer> temp = new Sequence1L<Integer>();

        for (int i = 0; i < 5; i++) {
            temp.add(i, i);
        }

        Sequence<Integer> temp2 = new Sequence1L<Integer>();

        for (int x = temp.length(); x > 0; x++) {
            temp2.replaceEntry(x, temp.entry(x));
        }

    }

    public void sequenceFlip2() {
        Sequence<Integer> temp = new Sequence1L<Integer>();

        for (int i = 0; i < 5; i++) {
            temp.add(i, i);
        }

        Sequence<Integer> temp2 = new Sequence1L<Integer>();

        int tempNum = 0;

        for (int x = 0; x < (temp.length() / 2); x++) {
            tempNum = temp.entry(x);

            temp.replaceEntry(x, temp.entry(temp.length() - x));
        }

    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        myMethod();
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
