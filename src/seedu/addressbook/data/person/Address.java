package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must follow the example format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    
    private static AddressBlock block;
    private static AddressStreet street;
    private static AddressUnit unit;
    private static AddressPostalCode postalCode;
    
    private static final int BLOCK_INDEX = 0;
    private static final int STREET_INDEX = 1;
    private static final int UNIT_INDEX = 2;
    private static final int POSTALCODE_INDEX = 3;
    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] separateAddress= decodeAddress(trimmedAddress);
        setAddress(separateAddress);
        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    
    private String[] decodeAddress (String address){
    	return address.split(",");
    }
    
    private void setAddress(String[] address){
    	this.setBlock(new AddressBlock(address[BLOCK_INDEX]));
        this.setStreet(new AddressStreet(address[STREET_INDEX]));
        this.setUnit(new AddressUnit(address[UNIT_INDEX]));
        this.setPostalCode(new AddressPostalCode(address[POSTALCODE_INDEX]));
		
	}
    	
    
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
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
    
    public static AddressBlock getBlock() {
		return block;
	}

	public void setBlock(AddressBlock block) {
		Address.block = block;
	}

	public static AddressStreet getStreet() {
		return street;
	}

	public void setStreet(AddressStreet street) {
		Address.street = street;
	}

	public static AddressUnit getUnit() {
		return unit;
	}

	public void setUnit(AddressUnit unit) {
		Address.unit = unit;
	}

	public static AddressPostalCode getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(AddressPostalCode postalCode) {
		Address.postalCode = postalCode;
	}
    }
