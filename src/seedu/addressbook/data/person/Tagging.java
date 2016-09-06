package seedu.addressbook.data;

import java.util.ArrayList;

public class Tagging {
    
    private static ArrayList<String> listOfTaggings;
    
    private boolean isAdd;
    private String personName;
    private String tagName;
    
    public Tagging(boolean isAdd, String personName, String tagName){
        this.isAdd = isAdd;
        this.personName = personName;
        this.tagName = tagName;
        listOfTaggings.add(this.toString());
    }
    
    @Override
    public String toString(){
        return (this.isAdd)?"+":"-" + " " + this.personName + " [" + this.tagName + "]";
    }
    
    /**
     * Returns the ArrayList of taggings.
     */
    public static ArrayList<String> getListOfTags(){
        return listOfTaggings;
    }
    
}