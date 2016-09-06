package seedu.addressbook.common;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class UtilsTest {

	@Test
	public void isAnyNull_noNull() {
		Object[] testObjects = new Object[] {new String("sdf"), new Integer(123)};
		boolean result = Utils.isAnyNull(testObjects);
		assertEquals(result, false);
	}
	
	@Test
	public void isAnyNull_hasNull() {
		Object[] testObjects = new Object[] {null, new Integer(123)};
		boolean result = Utils.isAnyNull(testObjects);
		assertEquals(result, true);
	}
	
	@Test
	public void elementAreUnique_isUnique() {
		ArrayList<Object> testObjects = new ArrayList<Object>();
		testObjects.add(new String("12313"));
		testObjects.add(new Integer(12313));
		testObjects.add(new Double(123.13));
		boolean result = Utils.elementsAreUnique(testObjects);
		assertEquals(result, true);
	}
	
	@Test
	public void elementAreUnique_isNotUnique() {
		ArrayList<Object> testObjects = new ArrayList<Object>();
		testObjects.add(new String("12313"));
		testObjects.add(new String("12313"));
		testObjects.add(new Integer(12313));
		testObjects.add(new Double(123.13));
		boolean result = Utils.elementsAreUnique(testObjects);
		assertEquals(result, false);
	}
}
