package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class AddressUnit {
	
	private String value;
	
	public AddressUnit(String unit){
        this.value = unit.trim();      
    }
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
}