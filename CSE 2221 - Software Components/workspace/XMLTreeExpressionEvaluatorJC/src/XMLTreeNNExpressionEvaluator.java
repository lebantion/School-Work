import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        // TODO - fill in body
        NaturalNumber count = new NaturalNumber1L(0);
        if (exp.label().equals("number")) {
            count = new NaturalNumber1L(exp.attributeValue("value"));
        } else if (exp.child(0).label().equals("number")
                && exp.child(1).label().equals("number")) {
            if (exp.label().equals("plus")) {
                count = new NaturalNumber1L(
                        exp.child(0).attributeValue("value"));
                count.add(new NaturalNumber1L(
                        exp.child(1).attributeValue("value")));
            } else if (exp.label().equals("divide")) {
                if (new NaturalNumber1L(0).compareTo(new NaturalNumber1L(
                        exp.child(1).attributeValue("value"))) == 0) {
                    Reporter.fatalErrorToConsole("Denominator cannot be zero");
                }
                count = new NaturalNumber1L(
                        exp.child(0).attributeValue("value"));
                count.divide(new NaturalNumber1L(
                        exp.child(1).attributeValue("value")));
            } else if (exp.label().equals("times")) {
                count = new NaturalNumber1L(
                        exp.child(0).attributeValue("value"));
                count.multiply(new NaturalNumber1L(
                        exp.child(1).attributeValue("value")));
            } else {
                count = new NaturalNumber1L(
                        exp.child(0).attributeValue("value"));
                count.subtract(new NaturalNumber1L(
                        exp.child(1).attributeValue("value")));
            }

        } else {

            if (exp.label().equals("plus")) {
                count = new NaturalNumber1L(evaluate(exp.child(1)));
                count.add(evaluate(exp.child(0)));

            } else if (exp.label().equals("divide")) {
                if (new NaturalNumber1L(0)
                        .compareTo(evaluate(exp.child(1))) == 0) {
                    Reporter.fatalErrorToConsole("Denominator cannot be zero");
                }
                count = new NaturalNumber1L(evaluate(exp.child(0)));
                count.divide(evaluate(exp.child(1)));

            } else if (exp.label().equals("times")) {
                count = new NaturalNumber1L(evaluate(exp.child(0)));
                count.multiply(evaluate(exp.child(1)));

            } else {
                count = new NaturalNumber1L(evaluate(exp.child(0)));
                count.subtract(evaluate(exp.child(1)));
            }

        }
        if (new NaturalNumber1L(0).compareTo(count) > 0) {
            Reporter.fatalErrorToConsole("Natural Number cannot be negative");
        }

        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */
        return count;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}