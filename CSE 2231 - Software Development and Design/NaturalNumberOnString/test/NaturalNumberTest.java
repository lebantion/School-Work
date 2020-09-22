import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;

/**
 * JUnit test fixture for {@code NaturalNumber}'s constructors and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class NaturalNumberTest {

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new number
     * @ensures constructorTest = 0
     */
    protected abstract NaturalNumber constructorTest();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorTest = i
     */
    protected abstract NaturalNumber constructorTest(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorTest)
     */
    protected abstract NaturalNumber constructorTest(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorTest = n
     */
    protected abstract NaturalNumber constructorTest(NaturalNumber n);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @return the new number
     * @ensures constructorRef = 0
     */
    protected abstract NaturalNumber constructorRef();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorRef = i
     */
    protected abstract NaturalNumber constructorRef(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorRef)
     */
    protected abstract NaturalNumber constructorRef(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorRef = n
     */
    protected abstract NaturalNumber constructorRef(NaturalNumber n);
    
    @Test
    public void constructorTestWithEmpty() {
    	NaturalNumber testNN = constructorTest();
    	NaturalNumber refNN = constructorRef();
    	
    	assertEquals(refNN, testNN);
    }
    
    @Test
    public void constructorTestWithInteger() {
    	NaturalNumber testNN = constructorTest(12);
    	NaturalNumber refNN = constructorRef(12);
    	
    	assertEquals(refNN, testNN);
    }
    
    @Test
    public void constructorTestWithIntegerZero() {
    	NaturalNumber testNN = constructorTest(0);
    	NaturalNumber refNN = constructorRef(0);
    	
    	assertEquals(refNN, testNN);
    }
    
    @Test
    public void constructorTestWithMaxInteger() {
    	NaturalNumber testNN = constructorTest(Integer.MAX_VALUE);
    	NaturalNumber refNN = constructorRef(Integer.MAX_VALUE);
    	
    	assertEquals(refNN, testNN);
    }
    
    @Test
    public void constructorTestWithString() {
    	NaturalNumber testNN = constructorTest("123");
    	NaturalNumber refNN = constructorRef("123");
    	
    	assertEquals(refNN, testNN);
    }
    
    @Test
    public void constructorTestWithStringWithIntegerMaxValue() {
     	NaturalNumber testNN = constructorTest("" + Integer.MAX_VALUE + 1);
    	NaturalNumber refNN = constructorRef("" + Integer.MAX_VALUE + 1);
    	
    	assertEquals(refNN, testNN); 	
    }
    
    @Test
    public void constructorTestWithNaturalNumber() {
    	NaturalNumber testNN = constructorTest(new NaturalNumber1L(1234));
    	NaturalNumber refNN = constructorRef(new NaturalNumber1L(1234));
    	
    	assertEquals(refNN, testNN);
    }

    @Test
    public void constructorTestWithNaturalNumberWithIntegerMaxValue() {
    	NaturalNumber testNN = constructorTest(new NaturalNumber1L("" + Integer.MAX_VALUE + 1));
    	NaturalNumber refNN = constructorRef(new NaturalNumber1L("" + Integer.MAX_VALUE + 1));
    	
    	assertEquals(refNN, testNN);
    }
    
    @Test
    public void isZeroTestWithIntegerZero(){
    	NaturalNumber testNN = constructorTest(0);
    	
    	assertTrue(testNN.isZero());
    
    }
    
    @Test
    public void isZeroTestWithEmpty(){
    	NaturalNumber testNN = constructorTest();
    	
    	assertTrue(testNN.isZero());
    }
    
    @Test
    public void isZeroTestWithStringZero(){
    	NaturalNumber testNN = constructorTest("0");
    
    	assertTrue(testNN.isZero());
    }
    
    @Test
    public void isZeroTestWithNNZero(){
    	NaturalNumber testNN = constructorTest(new NaturalNumber1L());
    
    	assertTrue(testNN.isZero());
    }
    

    @Test
    public void divideBy10TestWithGeneral(){
    	
    	NaturalNumber testNN = constructorTest(121);
    	NaturalNumber refNN = constructorRef(12);
    	
    	int remainder = testNN.divideBy10();
    	
    	assertEquals(testNN, refNN);
    	assertEquals(remainder, 1);
    	
    }
    
    @Test
    public void divideBy10Test2(){
    	
    	NaturalNumber testNN = constructorTest("121");
    	NaturalNumber refNN = constructorRef(12);
    	
    	int remainder = testNN.divideBy10();
    	
    	assertEquals(testNN, refNN);
    	assertEquals(remainder, 1);
    	
    }
    
    @Test
    public void divideBy10Test3(){
    	
    	NaturalNumber testNN = constructorTest(new NaturalNumber1L(121));
    	NaturalNumber refNN = constructorRef(12);
    	
    	int remainder = testNN.divideBy10();
    	
    	assertEquals(testNN, refNN);
    	assertEquals(remainder, 1);
    	
    }
    
    @Test
    public void divideBy10Test4(){
    	
    	NaturalNumber testNN = constructorTest(new NaturalNumber1L("121"));
    	NaturalNumber refNN = constructorRef(12);
    	
    	int remainder = testNN.divideBy10();
    	
    	assertEquals(testNN, refNN);
    	assertEquals(remainder, 1);
    	
    }
    
    @Test
    public void divideBy10Test5(){
    	
    	NaturalNumber testNN = constructorTest(1213453);
    	NaturalNumber refNN = constructorRef(121345);
    	
    	int remainder = testNN.divideBy10();
    	
    	assertEquals(testNN, refNN);
    	assertEquals(remainder, 3);
    	
    }
    
    @Test
    public void divideBy10BigNumberTest(){
    	
    	NaturalNumber testNN = constructorTest("1234123412341234");
    	NaturalNumber refNN = constructorRef("123412341234123");
    	
    	int remainder = testNN.divideBy10();
    	
    	assertEquals(testNN, refNN);
    	assertEquals(remainder, 4);
    	
    }
    
    @Test
    public void divideBy10MaxIntegerTest() {
    	
    	NaturalNumber testNN = constructorTest(Integer.MAX_VALUE);
    	NaturalNumber refNN = constructorRef(Integer.MAX_VALUE);
    	
    	int testRemainder = testNN.divideBy10();
    	int refRemainder = refNN.divideBy10();
    	
    	assertEquals(refRemainder, testRemainder);
    	
    }
    
    @Test
    public void divideBy10SmallNum(){
    	
    	NaturalNumber testNN = constructorTest("1");
    	NaturalNumber refNN = constructorRef();
    	
    	int remainer = testNN.divideBy10();
    	
    	assertEquals(testNN, refNN);
    	assertEquals(remainer, 1);
    	
    }
    
    @Test
    public void divideBy10Zero() {
    	NaturalNumber testNN = constructorTest();
    	NaturalNumber refNN = constructorRef();
    	
    	int remainer = testNN.divideBy10();
    	
    	assertEquals(testNN, refNN);
    	assertEquals(remainer, 0);
    }
    @Test
    public void multiplyBy10TestFor0() {
    	NaturalNumber testNN = constructorTest(0);
    	NaturalNumber refNN = constructorRef(1);
    	
    	testNN.multiplyBy10(1);
    	
    	assertEquals(refNN, testNN);
    }
    
    @Test
    public void multiplyBy10TestForGeneral() {
    	NaturalNumber testNN = constructorTest(121);
    	NaturalNumber refNN = constructorRef(1212);
    	
    	testNN.multiplyBy10(2);
    	
    	assertEquals(refNN, testNN);
    }
    
    @Test
    public void multiplyBy10TestBigNumber() {
    	NaturalNumber testNN = constructorTest("123987123");
    	NaturalNumber refNN = constructorRef("1239871234");
    	
    	testNN.multiplyBy10(4);
    	
    	assertEquals(refNN, testNN);
    }
    
    @Test
    public void multiplyBy10TestWithEmpty() {
    	NaturalNumber testNN = constructorTest();
    	NaturalNumber refNN = constructorTest(4);
    	
    	testNN.multiplyBy10(4);
    	
    	assertEquals(refNN, testNN);
    }

}
