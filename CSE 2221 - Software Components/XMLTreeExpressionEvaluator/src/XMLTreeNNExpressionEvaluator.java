import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
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

        NaturalNumber result = new NaturalNumber2();

        NaturalNumber value1 = new NaturalNumber2();
        NaturalNumber value2 = new NaturalNumber2();

        if (exp.label().equals("number")) {
            result = new NaturalNumber2(exp.attributeValue("value"));
        } else {

            if (exp.label().equals("divide")) {
                value1 = new NaturalNumber2(evaluate(exp.child(0)));
                value2 = new NaturalNumber2(evaluate(exp.child(1)));

                if (value2.compareTo(new NaturalNumber2(0)) == 0) {
                    Reporter.fatalErrorToConsole("Denomenator is 0");
                }

                value1.divide(value2);

                result = new NaturalNumber2(value1);

            } else if (exp.label().equals("minus")) {
                value1 = new NaturalNumber2(evaluate(exp.child(0)));
                value2 = new NaturalNumber2(evaluate(exp.child(1)));

                value1.subtract(value2);

                result = new NaturalNumber2(value1);
            } else if (exp.label().equals("times")) {

                value1 = new NaturalNumber2(evaluate(exp.child(0)));
                value2 = new NaturalNumber2(evaluate(exp.child(1)));

                if (value2.compareTo(new NaturalNumber2(0)) <= 0) {
                    Reporter.fatalErrorToConsole("Denomenator is 0");
                }

                value1.multiply(value2);

                result = new NaturalNumber2(value1);

            } else if (exp.label().equals("plus")) {
                value1 = new NaturalNumber2(evaluate(exp.child(0)));
                value2 = new NaturalNumber2(evaluate(exp.child(1)));

                value1.add(value2);

                result = new NaturalNumber2(value1);
            }
        }

        if (result.compareTo(new NaturalNumber2(0)) < 0) {
            Reporter.fatalErrorToConsole("There is negative value");
        }

        return result;
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