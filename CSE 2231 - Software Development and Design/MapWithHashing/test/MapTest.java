
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;


import components.map.Map;

/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Uijong Kim
 * @author Seongrok Ha
 * @version 020620
 *
 */
public abstract class MapTest {

	/**
	 * Invokes the appropriate {@code Map} constructor for the implementation
	 * under test and returns the result.
	 *
	 * @return the new map
	 * @ensures constructorTest = {}
	 */
	protected abstract Map<String, String> constructorTest();

	/**
	 * Invokes the appropriate {@code Map} constructor for the reference
	 * implementation and returns the result.
	 *
	 * @return the new map
	 * @ensures constructorRef = {}
	 */
	protected abstract Map<String, String> constructorRef();

	/**
	 *
	 * Creates and returns a {@code Map<String, String>} of the implementation
	 * under test type with the given entries.
	 *
	 * @param args
	 *            the (key, value) pairs for the map
	 * @return the constructed map
	 * @requires <pre>
	 * [args.length is even]  and
	 * [the 'key' entries in args are unique]
	 * </pre>
	 * @ensures createFromArgsTest = [pairs in args]
	 */
	private Map<String, String> createFromArgsTest(String... args) {
		assert args.length % 2 == 0 : "Violation of: args.length is even";
		Map<String, String> map = this.constructorTest();
		for (int i = 0; i < args.length; i += 2) {
			assert !map.hasKey(args[i]) : ""
					+ "Violation of: the 'key' entries in args are unique";
			map.add(args[i], args[i + 1]);
		}
		return map;
	}

	/**
	 *
	 * Creates and returns a {@code Map<String, String>} of the reference
	 * implementation type with the given entries.
	 *
	 * @param args
	 *            the (key, value) pairs for the map
	 * @return the constructed map
	 * @requires <pre>
	 * [args.length is even]  and
	 * [the 'key' entries in args are unique]
	 * </pre>
	 * @ensures createFromArgsRef = [pairs in args]
	 */
	private Map<String, String> createFromArgsRef(String... args) {
		assert args.length % 2 == 0 : "Violation of: args.length is even";
		Map<String, String> map = this.constructorRef();
		for (int i = 0; i < args.length; i += 2) {
			assert !map.hasKey(args[i]) : ""
					+ "Violation of: the 'key' entries in args are unique";
			map.add(args[i], args[i + 1]);
		}
		return map;
	}

	// TODO - add test cases for constructor, add, remove, removeAny, value,
	// hasKey, and size

	@Test   
	public void removeTest() {
		Map<String, String> m1 = constructorTest();
		Map<String, String> m2 = constructorRef();

		m1 = createFromArgsTest("2", "4", "3", "5");
		m2 = createFromArgsRef("2", "4");

		m1.remove("3");

		assertEquals(m1, m2);
	}

	@Test
	public void removeAllofItTest()	{
		
		Map<String, String> m1 = constructorTest();
		Map<String, String> m2 = constructorRef();

		m1 = createFromArgsTest("2", "4", "3", "5", "4", "7");
		m2 = createFromArgsRef("2", "4");
		
		m1.remove("3");
		m1.remove("4");
		
		assertEquals(m1, m2);
	}
	
	@Test
	public void removeMakeEmpty()
	{
		
		Map<String, String> m1 = constructorTest();
		Map<String, String> m2 = constructorRef();

		m1 = createFromArgsTest("2", "4", "3", "5");
		m2 = createFromArgsRef();
		
		m1.remove("2");
		m1.remove("3");
		
		assertEquals(m1, m2);

	}
	
	@Test
	public void removeFrontKey()
	{
		
		Map<String, String> m1 = constructorTest();
		Map<String, String> m2 = constructorRef();

		m1 = createFromArgsTest("2", "4", "3", "5");
		m2 = createFromArgsRef("3", "5");
		
		m1.remove("2");
		
		assertEquals(m1, m2);

	}
	
	@Test
	public void valueTest()
	{
		Map<String, String> m1 = constructorTest();
		
		m1 = createFromArgsTest("2", "4", "3", "5");
		
		assertEquals(m1.value("2"),"4");
		
	}
	
	@Test
	public void valueTest2()
	{
		Map<String, String> m1 = constructorTest();
		
		m1 = createFromArgsTest("10", "12");
		
		assertEquals(m1.value("10"), "12");
		
	}
	
	@Test
	public void valueTest3()
	{
		Map<String, String> m1 = constructorTest();
		
		m1 = createFromArgsTest("3", "5");
		
		assertEquals(m1.value("3"),"5");
		
	}
	
	@Test
	public void valueTest4()
	{
		Map<String, String> m1 = constructorTest();
		
		m1 = createFromArgsTest("Apple", "Juice");
		
		assertEquals(m1.value("Apple"), "Juice");
		
	}
	
	@Test
	public void hasKeyTest()
	{
		Map<String, String> m1 = constructorTest();
		
		m1 = createFromArgsTest("Apple", "Juice");
		
		assertTrue(m1.hasKey("Apple"));
	}
	
	@Test
	public void hasKeyTest2()
	{
		Map<String, String> m1 = constructorTest();
		
		m1 = createFromArgsTest("1", "2");
		
		assertTrue(m1.hasKey("1"));
	}
	
	@Test
	public void hasKeyTestFalse()
	{
		Map<String, String> m1 = constructorTest();
		
		m1 = createFromArgsTest("1", "2");
		
		assertFalse(m1.hasKey("2"));
	}
	
	@Test
	public void hasKeyTestFalse2()
	{
		Map<String, String> m1 = constructorTest();
		
		m1 = createFromArgsTest("1", "2");
		
		assertFalse(m1.hasKey("Apple"));
	}
	
	@Test
	public void sizeTest()
	{
		Map<String, String> m1 = constructorTest();
		
		m1 = createFromArgsTest("1", "2", "Apple", "Juice", "Pizza", "Coke");
		
		assertEquals(m1.size(), 3);
	}
	
	@Test
	public void sizeTestwithAdd()
	{
		Map<String, String> m1 = constructorTest();
		
		m1 = createFromArgsTest("1", "2", "Apple", "Juice", "Pizza", "Coke");
		
		m1.add("Chicken", "Beer");
		
		assertEquals(m1.size(), 4);
	}
	
	@Test
	public void sizeTestwithRemove()
	{
		Map<String, String> m1 = constructorTest();
		
		m1 = createFromArgsTest("1", "2", "Apple", "Juice", "Pizza", "Coke");
		
		m1.remove("1");
		
		assertEquals(m1.size(), 2);
	}
	
	@Test
	public void sizeTest2()
	{
		Map<String, String> m1 = constructorTest();
		
		m1 = createFromArgsTest("1", "2", "Apple", "Juice", "Pizza", "Coke", "Chicken", "Beer", "DduckBokki", "Tempura");
		
		assertEquals(m1.size(), 5);
	}

    
    @Test
    public final void testConstructorWithEmpty() {
    	Map<String, String> mapTest = this.createFromArgsTest();
    	Map<String, String> mapRef = this.createFromArgsRef();
    	
    	assertEquals(mapRef, mapTest);
    }
    
    @Test
    public final void testConstructorWithEmptyString() {
    	Map<String, String> mapTest = this.createFromArgsTest("", "");
    	Map<String, String> mapRef = this.createFromArgsRef("", "");
    	
    	assertEquals(mapRef, mapTest);    	
    }
    
    @Test
    public final void testConstructorWithGeneralString() {
    	Map<String, String> mapTest = this.createFromArgsTest("Apple", "Fruit");
    	Map<String, String> mapRef = this.createFromArgsRef("Apple", "Fruit");
    	
    	assertEquals(mapRef, mapTest);
    }
    
    @Test
    public final void testConstructorWithSeveralString() {
    	Map<String, String> mapTest = this.createFromArgsTest("Apple", "Fruit", "Banana", "Fruit", "iPhone", "Device");
    	Map<String, String> mapRef = this.createFromArgsRef("Apple", "Fruit", "Banana", "Fruit", "iPhone", "Device");
    	
    	assertEquals(mapRef, mapTest);
    }
    
    @Test
    public final void testAddWithEmptyString() {
    	Map<String, String> mapTest = this.createFromArgsTest();
    	Map<String, String> mapRef = this.createFromArgsRef();
    	
    	mapTest.add("", "");
    	mapRef.add("", "");
    }
    
    @Test
    public final void testAddWithGeneralString() {
    	Map<String, String> mapTest = this.createFromArgsTest();
    	Map<String, String> mapRef = this.createFromArgsRef();
    	
    	mapTest.add("Apple", "Fruit");
    	mapRef.add("Apple", "Fruit");
    	
    	assertEquals(mapRef, mapTest);
    }
    
    @Test
    public final void testAddWithIntegerString() {
    	Map<String, String> mapTest = this.createFromArgsTest();
    	Map<String, String> mapRef = this.createFromArgsRef();
    	
    	mapTest.add("122", "132");
    	mapRef.add("122", "132");
    	
    	assertEquals(mapRef, mapTest);
    }
    
    @Test
    public final void testAddWithForLoop() {
    	Map<String, String> mapTest = this.createFromArgsTest();
    	Map<String, String> mapRef = this.createFromArgsRef();
    	
    	for (int i = 0; i < 10; i++) {
    		mapTest.add(i + 1 + "", i + "");
    		mapRef.add(i + 1 + "", i + "");
    	}
    	
    	assertEquals(mapRef.size(), mapTest.size());
    	assertEquals(mapRef, mapTest);
    }
    
    @Test
    public final void testRemoveAnyWithEmptyStringMap() {
    	Map<String, String> mapTest = this.createFromArgsTest("", "");
    	Map<String, String> mapRef = this.createFromArgsRef("", "");
    	
    	mapTest.removeAny();
    	mapRef.removeAny();
    	
    	assertEquals(mapRef, mapTest);
    }
    
    @Test
    public final void testRemoveAnyWithGeneralMap() {
    	Map<String, String> mapTest = this.createFromArgsTest("Apple", "Fruit", "Banana", "Fruit", "iPhone", "Device");
    	Map<String, String> mapRef = this.createFromArgsRef("Apple", "Fruit", "Banana", "Fruit", "iPhone", "Device");
    	
    	
    	mapTest.removeAny();
    	mapRef.removeAny();
    	
    	assertEquals(mapRef.size(), mapTest.size());
    }
    
    @Test
    public final void testRemoveAnyWithIntegerAndSpecialChar() {
    	Map<String, String> mapTest = this.createFromArgsTest("1", "2", "3", "4", "5", "6", "7", "&", "*", "!", "@", "$");
    	Map<String, String> mapRef = this.createFromArgsRef("1", "2", "3", "4", "5", "6", "7", "&", "*", "!", "@", "$");
    	
    	mapTest.removeAny();
    	mapRef.removeAny();
    	
    	assertEquals(mapRef.size(), mapTest.size());
    	
    	
    }
    
}
