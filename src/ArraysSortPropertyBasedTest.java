import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;
/**
 * Deliverable 4 - JUnit-based property-based tests
 * This test program generates 100 random arrays of random size an subjects each to a 
 * set of three property-based test.
 * @author RichardKotermanski
 *
 */
public class ArraysSortPropertyBasedTest {
	static int maxArraySize = 100000;
	
	@Test
	public void sortTest() {
		Random r = new Random();

		for (int i = 0; i < 100; i++) {
			int length = Math.abs(r.nextInt(maxArraySize+1));
			int[] testArray;
			int[] testArrayPurity;
			
			// Create two identical arrays of random size between 0 and 100,000,
			// and populate them with the same random integers between Integer.MIN_VALUE and Integer.MAX_VALUE.
			testArray = new int[length];
			testArrayPurity = new int[length];
			for (int vals = 0; vals < length; vals++) {
				int value = r.nextInt();
				testArray[vals] = value;
				testArrayPurity[vals] = value;
			}

			int originalArrayLength = testArray.length;
			Arrays.sort(testArray);

			// Test if each consecutive number greater than or equal to the
			// previous, and test if the first index greater than or equal to the smallest
			// integer value.
			int prevVal = Integer.MIN_VALUE;
			for (int curVal : testArray) {
				if (curVal < prevVal)
					fail("The values " + curVal + " and " + prevVal + " are not in the correct, sorted order.");
				prevVal = curVal;
			}

			// Test if the array after sorting (testArray) has the same length as 
			// it did prior to sorting (originalArrayLength).
			assertEquals(originalArrayLength, testArray.length);

			// Test the pure propert by seeing if running the Arrays.sort() function on the same input a second
			// time produces an array with the same values at the same index as the original.
			Arrays.sort(testArrayPurity);
			assertArrayEquals(testArray, testArrayPurity);
		}

	}

}
