import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author SeongRok Ha(ha.241)
 *
 */
public class CryptoUtilitiesTest {

    /**
     * Tests of reduceToGCD.
     */

    @Test
    public void testReduceToGCD00() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("0", n.toString());
        assertEquals("0", m.toString());
    }

    /**
     * Tests of reduceToGCD.
     */

    @Test
    public void testReduceToGCD3021() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber m = new NaturalNumber2(21);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("3", n.toString());
        assertEquals("3" + "", m.toString());
    }

    /**
     * Tests of reduceToGCD.
     */

    @Test
    public void testReduceToGCD1216() {
        NaturalNumber n = new NaturalNumber2(12);
        NaturalNumber m = new NaturalNumber2(16);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("4", n.toString());
        assertEquals("4" + "", m.toString());
    }

    /**
     * Tests of isEven.
     */

    @Test
    public void testIsEven0() {
        NaturalNumber n = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("0", n.toString());
        assertTrue(result);
    }

    /**
     * Tests of isEven.
     */

    @Test
    public void testIsEven1() {
        NaturalNumber n = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("1", n.toString());
        assertTrue(!result);
    }

    /**
     * Tests of isEven.
     */

    @Test
    public void testIsEven2() {
        NaturalNumber n = new NaturalNumber2(3);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("3", n.toString());
        assertTrue(!result);
    }

    /**
     * Tests of powerMod.
     */

    @Test
    public void testPowerMod322() {
        NaturalNumber n = new NaturalNumber2(3);
        NaturalNumber p = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("2", p.toString());
        assertEquals("2", m.toString());
    }

    /**
     * Tests of powerMod.
     */

    @Test
    public void testPowerMod235() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber p = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(5);

        CryptoUtilities.powerMod(n, p, m);
        assertEquals("3", n.toString());
        assertEquals("3", p.toString());
        assertEquals("5", m.toString());
    }

    /**
     * Tests of powerMod.
     */

    @Test

    public void testPowerMod002() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("0", p.toString());
        assertEquals("2", m.toString());
    }

    /**
     * Tests of witnessMethod.
     */

    @Test

    public void witnessTest1() {
        NaturalNumber w = new NaturalNumber2(17);
        NaturalNumber n = new NaturalNumber2(19);

        boolean result;

        result = CryptoUtilities.isWitnessToCompositeness(w, n);

        assertEquals(false, result);
    }

    /**
     * Tests of witnessMethod.
     */

    @Test

    public void witnessTest2() {
        NaturalNumber w = new NaturalNumber2(15);
        NaturalNumber n = new NaturalNumber2(18);

        boolean result;

        result = CryptoUtilities.isWitnessToCompositeness(w, n);

        assertEquals(true, result);
    }

    /**
     * Tests of witnessMethod.
     */

    @Test

    public void witnessTest3() {
        NaturalNumber w = new NaturalNumber2(3);
        NaturalNumber n = new NaturalNumber2(8);

        boolean result;

        result = CryptoUtilities.isWitnessToCompositeness(w, n);

        assertEquals(true, result);
    }

    /**
     * Tests of prime2.
     */

    @Test

    public void isPrime2Test1() {
        NaturalNumber w = new NaturalNumber2(40);

        boolean result;

        result = CryptoUtilities.isPrime2(w);

        assertEquals(false, result);
    }

    /**
     * Tests of prime2.
     */

    @Test

    public void isPrime2Test2() {
        NaturalNumber w = new NaturalNumber2(3);

        boolean result;

        result = CryptoUtilities.isPrime2(w);

        assertEquals(true, result);
    }

    /**
     * Tests of prime2.
     */

    @Test

    public void isPrime2Test3() {
        NaturalNumber w = new NaturalNumber2(23);

        boolean result;

        result = CryptoUtilities.isPrime2(w);

        assertEquals(true, result);
    }

    /**
     * Tests of likelyprimeMethod.
     */

    @Test

    public void nextLikelyPrimeTest1() {
        NaturalNumber w = new NaturalNumber2(24);

        CryptoUtilities.generateNextLikelyPrime(w);

        assertEquals(new NaturalNumber2(29), w);
    }

    /**
     * Tests of likelyprimeMethod.
     */

    @Test

    public void nextLikelyPrimeTest2() {
        NaturalNumber w = new NaturalNumber2(2);

        CryptoUtilities.generateNextLikelyPrime(w);

        assertEquals(new NaturalNumber2(2), w);
    }

    /**
     * Tests of likelyprimeMethod.
     */

    @Test

    public void nextLikelyPrimeTest3() {
        NaturalNumber w = new NaturalNumber2(15);

        CryptoUtilities.generateNextLikelyPrime(w);

        assertEquals(new NaturalNumber2(17), w);
    }

}