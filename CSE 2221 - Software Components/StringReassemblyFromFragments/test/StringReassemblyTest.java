import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

    @Test
    public void testLineSeperater() {
        SimpleWriter out = new SimpleWriter1L();
        String str1 = "Line Seperator~completed";

        out.println("------- expected output ----------");

        out.println("Line Seperator\ncompleted");

        out.println("------- result output ----------");

        StringReassembly.printWithLineSeparators(str1, out);
    }

    @Test
    public void testLineSeperater2() {
        SimpleWriter out = new SimpleWriter1L();
        String str1 = "Line Seperator completed";

        out.println("------- expected output ----------");

        out.println("Line Seperator completed");

        out.println("------- result output ----------");

        StringReassembly.printWithLineSeparators(str1, out);

    }

    @Test
    public void testLinesfromInput() {
        SimpleReader input = new SimpleReader1L("data/testdata.txt");
        SimpleWriter out = new SimpleWriter1L();

        Set<String> expData = new Set1L<String>();
        Set<String> resData = new Set1L<String>();

        resData = StringReassembly.linesFromInput(input);

        expData.add("data");
        expData.add("for");
        expData.add("test");

        boolean result = true;

        for (String x : resData) {
            if (!expData.contains(x)) {
                result = false;
            }
        }

        assertFalse(result);
    }

    @Test
    public void testCombintation() {
        String str1 = "abcde";
        String str2 = "cdefg";
        String expect = "abcdefg";
        String result = StringReassembly.combination(str1, str2, 3);

        assertEquals(expect, result);

    }

    @Test
    public void avoidingSubStrTest() {
        SimpleReader input = new SimpleReader1L("data/testdata.txt");
        SimpleWriter out = new SimpleWriter1L();

        Set<String> temp = new Set1L<String>();

        temp.add("data");

        StringReassembly.addToSetAvoidingSubstrings(temp, "dat");

        boolean result = true;

        if (temp.contains("dat")) {
            result = false;
        }

        assertFalse(result);
    }

    @Test
    public void avoidingSubStrTest2() {
        SimpleReader input = new SimpleReader1L("data/testdata.txt");
        SimpleWriter out = new SimpleWriter1L();

        Set<String> temp = new Set1L<String>();

        temp.add("dat");

        StringReassembly.addToSetAvoidingSubstrings(temp, "data");

        boolean result = true;

        if (temp.contains("dat")) {
            result = false;
        }

        assertTrue(result);
    }
}
