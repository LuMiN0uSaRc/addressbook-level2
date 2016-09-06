package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    @Test
    public void isSimilar_exactName_returnsTrue() throws IllegalValueException {
        Name name1 = new Name("John");
        Name name2 = new Name("John");

        assertEquals(true, name1.isSimilar(name2));
    }

    @Test
    public void isSimilar_otherNameIsNull_returnsFalse() throws IllegalValueException {
        Name name1 = new Name("John");

        assertEquals(false, name1.isSimilar(null));
    }

    @Test
    public void isSimilar_1exactNameDifferentCase_returnsTrue() throws IllegalValueException {
        Name name1 = new Name("John");
        Name name2 = new Name("john");

        assertEquals(true, name1.isSimilar(name2));
    }

    @Test
    public void isSimilar_2exactNameDifferentCase_returnsTrue() throws IllegalValueException {
        Name name1 = new Name("John sMith");
        Name name2 = new Name("john Smith");

        assertEquals(true, name1.isSimilar(name2));
    }

    @Test
    public void isSimilar_differentName_returnsFalse() throws IllegalValueException {
        Name name1 = new Name("John sMith");
        Name name2 = new Name("Mary");

        assertEquals(false, name1.isSimilar(name2));
    }

    @Test
    public void isSimilar_name1SubsetOfName2_returnsTrue() throws IllegalValueException {
        Name name1 = new Name("John");
        Name name2 = new Name("John sMith");

        assertEquals(true, name1.isSimilar(name2));
    }

    @Test
    public void isSimilar_name2SubsetOfName1_returnsTrue() throws IllegalValueException {
        Name name1 = new Name("John sMith");
        Name name2 = new Name("John");

        assertEquals(true, name1.isSimilar(name2));
    }

    @Test
    public void isSimilar_sameFirstNameDifferentLastName_returnsFalse()
            throws IllegalValueException {
        Name name1 = new Name("John Jacob");
        Name name2 = new Name("John sMith");

        assertEquals(false, name1.isSimilar(name2));
    }

    @Test
    public void isSimilar_name1SupersetOfName2_returnsTrue() throws IllegalValueException {
        Name name1 = new Name("John Smith");
        Name name2 = new Name("John K Smith");

        assertEquals(true, name1.isSimilar(name2));
    }

    @Test
    public void isSimilar_name2SupersetOfName1_returnsTrue() throws IllegalValueException {
        Name name1 = new Name("John K Smith");
        Name name2 = new Name("John Smith");

        assertEquals(true, name1.isSimilar(name2));
    }
}