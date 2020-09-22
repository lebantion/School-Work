import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Uijong Kim
 * @author SeongRok Ha
 * @version February 14th, 2020
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new set
     * @ensures constructorRef = {}
     */
    protected abstract Set<String> constructorRef();

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Set<String> createFromArgsTest(String... args) {
        Set<String> set = this.constructorTest();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Creates and returns a {@code Set<String>} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsRef = [entries in args]
     */
    private Set<String> createFromArgsRef(String... args) {
        Set<String> set = this.constructorRef();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    @Test
    public final void testSet3aConstructor() {
        Set<String> testSet = this.constructorTest();
        Set<String> refSet = this.constructorRef();

        assertEquals(refSet, testSet);
    }

    @Test
    public final void testSet3aAddOneValue() {
        Set<String> testSet = this.constructorTest();
        Set<String> refSet = this.constructorRef();

        testSet.add("0");
        refSet.add("0");

        assertEquals(refSet, testSet);
    }

    @Test
    public final void testSet3aAddTwoVlues() {
        Set<String> testSet = this.constructorTest();
        Set<String> refSet = this.constructorRef();

        testSet.add("0");
        refSet.add("0");
        testSet.add("1");
        refSet.add("1");
        
        assertEquals(refSet, testSet);

    }


    @Test
    public final void testSet3aAddElevenValuesInDifferentOrder() {
        Set<String> testSet = this.createFromArgsTest("0", "11","10", "12", "5", "3", "2", "1", "25", "7", "77");
        Set<String> refSet = this.createFromArgsRef("0", "77", "12", "11", "25", "1", "7", "3", "5", "2", "10");

        assertEquals(refSet, testSet);

    }

    @Test
    public final void testSet3aAddElevenValuesInOrder() {
        Set<String> testSet = this.createFromArgsTest("0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10");
        Set<String> refSet = this.createFromArgsRef("0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10");

        assertEquals(refSet, testSet);

    }

    @Test
    public final void testSet3aContainsGeneral() {
        Set<String> testSet = this.constructorTest();
        Set<String> refSet = this.constructorRef();
        
        testSet.add("0");
        refSet.add("0");
        testSet.add("1");
        refSet.add("1");

        boolean testSetCheck = testSet.contains("0");
        boolean refSetCheck = refSet.contains("0");

        assertEquals(refSetCheck, testSetCheck);
        assertEquals(refSet, testSet);
    }

    @Test
    public final void testSet3aContainsReturnFalseWithNotEmptySet() {
        Set<String> testSet = this.constructorTest();
        Set<String> refSet = this.constructorRef();

        testSet.add("12");
        refSet.add("12");
        testSet.add("23");
        refSet.add("23");
        
        boolean testSetCheck = testSet.contains("13");
        boolean refSetCheck = refSet.contains("13");

        assertEquals(refSetCheck, testSetCheck);
        assertEquals(refSet, testSet);
    }

    
    @Test
    public final void testSet3aContainsReturnFalseWithEmptySet() {
        Set<String> testSet = this.constructorTest();
        Set<String> refSet = this.constructorRef();

        boolean testSetCheck = testSet.contains("123");
        boolean refSetCheck = refSet.contains("123");

        assertEquals(refSetCheck, testSetCheck);
        assertEquals(refSet, testSet);
    }


    /**
     * Test Cases For remove
     */

    @Test
    public final void testSet3aRemoveOne() {
        Set<String> testSet = this.createFromArgsTest("1");
        Set<String> refSet = this.createFromArgsTest("1");


        String testStr = testSet.remove("1");
        String refStr = refSet.remove("1");

        assertEquals(refSet, testSet);
        assertEquals(refStr, testStr);
    }

    @Test
    public final void testSet3aRemoveTwice() {
        Set<String> test = this.createFromArgsTest("0", "10");
        Set<String> ref = this.createFromArgsRef("0", "10");

        String testStr1 = test.remove("0");
        String refStr1 = ref.remove("0");
        String testStr2 = test.remove("10");
        String refStr2 = ref.remove("10");

        assertEquals(ref, test);
        assertEquals(refStr1, testStr1);
        assertEquals(refStr2, testStr2);
    }

    @Test
    public final void testSet3aRemoveTwiceFromSetAddedTenValues() {
        Set<String> testSet = this.createFromArgsTest("0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9");
        Set<String> refSet = this.createFromArgsRef("0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9");

        String testStr1 = testSet.remove("9");
        String refStr1 = refSet.remove("9");
        String testStr2 = testSet.remove("8");
        String refStr2 = refSet.remove("8");

        assertEquals(refSet, testSet);
        assertEquals(refStr1, testStr1);
        assertEquals(refStr2, testStr2);
    }

    @Test
    public final void testSet3aRemoveTwiceFromSetAddedTenValueWithDifferentOrder() {
        Set<String> testSet = this.createFromArgsTest("44", "50", "22", "0", "64", "38",
                "12", "46", "79", "80");
        Set<String> refSet = this.createFromArgsRef("22", "50", "44", "64", "0", "80",
                "79", "46", "12", "38");

        String testStr1 = testSet.remove("0");
        String refStr1 = refSet.remove("0");
        String testStr2 = testSet.remove("44");
        String refStr2 = refSet.remove("44");

        assertEquals(refSet, testSet);
        assertEquals(refStr1, testStr1);
        assertEquals(refStr2, testStr2);
    }

    @Test
    public final void testSetOnBSTRemoveAnyWithOneSet() {
        Set<String> testSet = this.createFromArgsTest("0");
        Set<String> refSet = this.createFromArgsRef("0");

        String testStr = testSet.removeAny();
        String refStr = refSet.removeAny();
        assertEquals(refStr, testStr);
        assertEquals(refSet, testSet);
    }
    
    @Test
    public final void testSet3aRemoveAnyTwiceWithSetWithTwoValues() {
        Set<String> testSet = this.createFromArgsTest("0", "12");
        Set<String> refSet = this.createFromArgsRef("0", "12");

        String testStr1 = testSet.removeAny();
        String refStr1 = refSet.remove(testStr1);
        String testStr2 = testSet.removeAny();
        String refStr2 = refSet.remove(testStr2);
        
        assertEquals(refStr1, testStr1);
        assertEquals(refStr2, testStr2);
        assertEquals(refSet, testSet);
    }
    
    @Test
    public final void testSet3aRemoveAnyFromSetWtihTenValues() {
        Set<String> testSet = this.createFromArgsTest("0", "1", "2", "3", "4",
                "5", "6", "7", "8", "9");
        Set<String> refSet = this.createFromArgsRef("0", "1", "2", "3", "4",
                "5", "6", "7", "8", "9");

        String testStr = testSet.removeAny();
        String refStr = refSet.remove(testStr);
        assertEquals(refStr, testStr);
        assertEquals(refSet, testSet);
        
    }
    
    @Test
    public final void testSet3aRemoveAnyFromSetWtihTenValuesWithDifferentOrder() {
    	Set<String> testSet = this.createFromArgsTest("44", "50", "22", "0", "64", "38",
                "12", "46", "79", "80");
        Set<String> refSet = this.createFromArgsRef("22", "50", "44", "64", "0", "80",
                "79", "46", "12", "38");

        String testStr = testSet.removeAny();
        String refStr = refSet.remove(testStr);

        assertEquals(refStr, testStr);
        assertEquals(refSet, testSet);
    }



    @Test
    public final void testSet3aRemoveAnyTwiceFromSetWtihTenValuesWithDifferentOrder() {
    	Set<String> testSet = this.createFromArgsTest("44", "50", "22", "0", "64", "38",
                "12", "46", "79", "80");
        Set<String> refSet = this.createFromArgsRef("22", "50", "44", "64", "0", "80",
                "79", "46", "12", "38");
        
        String testStr1 = testSet.removeAny();
        String refStr1 = refSet.remove(testStr1);
        String testStr2 = testSet.removeAny();
        String refStr2 = refSet.remove(testStr2);
        assertEquals(refStr1, testStr1);
        assertEquals(refStr2, testStr2);
        assertEquals(refSet, testSet);
    }

    @Test
    public final void testSet3aSizeForEmptySet() {
        Set<String> testSet = this.constructorTest();
        Set<String> refSet = this.constructorRef();

        int testSetSize = testSet.size();
        int refSetSize = refSet.size();

        assertEquals(refSet, testSet);
        assertEquals(refSetSize, testSetSize);
    }

    @Test
    public final void testSet3aSizeForGeneralSet() {
    	Set<String> testSet = this.createFromArgsTest("0", "1", "2", "3", "4",
                "5", "6", "7", "8", "9");
        Set<String> refSet = this.createFromArgsRef("0", "1", "2", "3", "4",
                "5", "6", "7", "8", "9");

        int testSetSize = testSet.size();
        int refSetSize = refSet.size();

        assertEquals(refSet, testSet);
        assertEquals(refSetSize, testSetSize);
    }
    
    @Test
    public final void testSet3aSizeForGeneralSetWithDifferentOrder() {
    	Set<String> testSet = this.createFromArgsTest("44", "50", "22", "0", "64", "38",
                "12", "46", "79", "80");
        Set<String> refSet = this.createFromArgsRef("22", "50", "44", "64", "0", "80",
                "79", "46", "12", "38");
        

        int testSetSize = testSet.size();
        int refSetSize = refSet.size();

        assertEquals(refSet, testSet);
        assertEquals(refSetSize, testSetSize);
    }

}