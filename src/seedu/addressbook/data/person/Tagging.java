package seedu.addressbook.data.person;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.Tag;

public class Tagging {
	private Person person;
	private Tag tag;
	private boolean isadded;
	
	public Tagging(Person person,Tag tag,boolean isadded){
		this.person=person;
		this.tag=tag;
		this.isadded=isadded;
		
	}
	
	@Override
	public String toString(){
	if(isadded)
		return "+"+" "+person.getName().toString()+" "+tag.toString();
	else
		return "-"+" "+person.getName().toString()+" "+tag.toString();
		
	}

}
