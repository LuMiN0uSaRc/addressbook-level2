package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String ADDRESS_PARTS_DELIMITER = ",";
    public static final String EXAMPLE = 
          Block.EXAMPLE + ADDRESS_PARTS_DELIMITER + " " 
            + Street.EXAMPLE + ADDRESS_PARTS_DELIMITER + " "
                  + Unit.EXAMPLE + ADDRESS_PARTS_DELIMITER + " " 
                    + PostalCode.EXAMPLE;
           
     public static final String MESSAGE_ADDRESS_CONSTRAINTS = "A person's address must be in format: BLOCK, STREET, UNIT, POSTAL_CODE";
     
     public static final String ADDRESS_VALIDATION_REGEX = "([.]|[^,])*,([.]|[^,])*,([.]|[^,])*,([.]|[^,])*";

     private static final int ADDRESS_PARTS_COUNT = 4;
     private static final int ADDRESS_PARTS_INDEX_BLOCK = 0;
     private static final int ADDRESS_PARTS_INDEX_STREET = 1;
     private static final int ADDRESS_PARTS_INDEX_UNIT = 2;
     private static final int ADDRESS_PARTS_INDEX_POSTALCODE = 3;
     
     private Block _block; 
     private Street _street;
     private Unit _unit;
     private PostalCode _postalCode;

    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        final String[] splitAddressComponents = address.trim().split(",");
         
       this.block = new Block(splitAddressComponents[0].trim());
       this.street = new Street(splitAddressComponents[1].trim());
       this.unit = new Unit(splitAddressComponents[2].trim());
       this.postalCode = new PostalCode(splitAddressComponents[3].trim());
       this.value = address;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
         if(!test.matches(ADDRESS_VALIDATION_REGEX))
           return false;
         
         final String[] splitAddressComponents = test.trim().split(",");
         if(!isValidAddress(splitAddressComponents))
           return false;
         
         return true;
    }

   public static boolean isValidAddress(String[] addressComponents){
       return isBlockValid(addressComponents[ADDRESS_INDEX_BLOCK])
               && isStreetValid(addressComponents[ADDRESS_INDEX_STREET])
               && isUnitValid(addressComponents[ADDRESS_INDEX_UNIT])
               && isPostalCodeValid(addressComponents[ADDRESS_INDEX_POSTAL_CODE]);
    }

     private static boolean isBlockValid(String block){
       return block.trim().matches(ADDRESS_BLOCK_VALIDATION_REGEX);
     }
     
     private static boolean isStreetValid(String street){
       return street.trim().matches(ADDRESS_STREET_VALIDATION_REGEX);
     }
     
     private static boolean isUnitValid(String unit){
       return unit.trim().matches(ADDRESS_UNIT_VALIDATION_REGEX);
     }
     
     private static boolean isPostalCodeValid(String postalCode){
       return postalCode.trim().matches(ADDRESS_POSTAL_CODE_VALIDATION_REGEX);
      }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

