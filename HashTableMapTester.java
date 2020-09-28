// --== CS400 File Header Information ==--
// Name: Pieran Robert
// Email: probert@wisc.edu
// Team: NE
// TA: Daniel Finer
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import java.util.NoSuchElementException;
public class HashTableMapTester {

	
	public static void main(String [] args) {
		System.out.println("test1: " + test1());
		System.out.println("test2: " + test2());
		System.out.println("test3: " + test3());
		System.out.println("test4: " + test4());
		System.out.println("test5: " + test5());
	}
	
	/**
	 * Tests .put and .get methods
	 * Creates new table, adds two KeyValuePairs
	 * Prints the list size and values
	 * Checks if get method return correct values
	 * 
	 */
	public static boolean test1() {
		HashTableMap table1 = new HashTableMap();
		table1.put(1, "one");
		System.out.println("size: " + table1.size());
		table1.put(2, "two");
		System.out.println("size: " + table1.size());
		System.out.println("1: " + table1.get(1));
		System.out.println("2: " + table1.get(2));
		if(table1.size() != 2 || !table1.get(2).equals("two"))
			return false;
		return true;
	}
	
	/**
	 * Checks to see if collisions are dealt with correctly
	 * creates a new table
	 * adds object in which two collide
	 * checks to see if correct values are returned
	 * 
	 */
	public static boolean test2() {
		HashTableMap table2 = new HashTableMap(10);
		int t1 = Math.abs(((Integer)13).hashCode()%10);
		int t2 = Math.abs(((Integer)12).hashCode()%10);
		int t3 = Math.abs(((Integer)23).hashCode()%10);
		System.out.println(t1 +", " + t2 + ", " + t3);
		table2.put(13, "Thirteen");
		table2.put(12, "tweleve");
		table2.put(23, "twenty3");
		System.out.println("13: " + table2.get(13));
		System.out.println("23: " + table2.get(23));
		if(!table2.get(13).equals("Thirteen") || !table2.get(23).equals("twenty3"))
			return false;
		return true;
	}
	
	/**
	 * Checks to see if table growth method works in the .put method
	 * creates new table
	 * adds just below 80% of objects in capacity
	 * Checks capacity
	 * adds another object
	 * checks grown capacity
	 */
	public static boolean test3() {
		HashTableMap table3 = new HashTableMap(6);
		System.out.println("capacity: " + table3.capacity());
		table3.put(6, "six");
		table3.put(12, "twelve");
		table3.put(18, "eighteen");
		table3.put(24, "twentyfour");
		if(table3.capacity() != 6)
			return false;
		table3.put(30, "thirty");
		if(table3.capacity() != 12 || table3.size() != 5)
			return false;
		return true;
	}

	/**
	 * Tests if the .get method with throw an exception
	 * if asked to return a value from a KeyValuePair that 
	 * does not exist
	 * 
	 */
	public static boolean test4() {	
		HashTableMap table4 = new HashTableMap();
		try {
		System.out.println("3: " + table4.get(3));}
		catch(NoSuchElementException E) {
			System.out.println("oof");
			return true;
		}
		return false;
	}
	
	/**
	 * Tests if .remove method effectively removes 
	 * an object, decreases size, and then will throw an exception
	 * if the .get method is run with the recently removed item
	 * @return
	 */
	public static boolean test5() {
		HashTableMap table5 = new HashTableMap();
		table5.put(1, "one");
		table5.put(2, "two");
		table5.put(3, "three");
		if(table5.size() != 3)
			return false;
		table5.remove(3);
		if(table5.size() != 2)
			return false;
		try {
		System.out.println("3: " + table5.get(3));}
		catch(NoSuchElementException E) {
			System.out.println("oof");
			return true;
		}
		return false;
	}
	
}
