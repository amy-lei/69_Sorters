/**
  Implement an insertion sort, in the Sorters structure
 */
import java.util.ArrayList;

public class InsertionSorter extends Sorter {

    /**
      Construct an instance to process the user's data
     */
    public InsertionSorter(  ArrayList< String> usersData) {
        super(usersData);
    }
    

    /**
      pre-condition: must be invoked on an Array of Strings
      
      Iterate through the list and insert each element after index 0 in its proper place using the helper function, insert()
      
      post-condition: the Array mySort() is invoked on will be sorted in monotonic increasing order.
     */
    public void mySort() {
        // iterate through
        for( int indexToSort = 1
            ;indexToSort < elements.size()
            ;indexToSort++
            ){
                insert(indexToSort);
                //for debugging
                System.out.println( "after inserting element "
                                    + indexToSort
                                    + " elements: "
                                    + elements
                                    );
            }
    }
    
    /**
      pre-condition: there must be at least one element in the sorted region of the list
      
      Insert the element in its proper place, shifting larger elements as it goes, and thus, expanding the sorted region. 
      
      post-condition: the desired element and elements larger than it will be in their proper location in the sorted region
     */
    private void insert(int numSorted){
        String valueToInsert = elements.get(numSorted);
        //iterate through
        for( int indexToCompare = numSorted - 1
            ;
            ; indexToCompare--
            ){
                // if not the right spot, shift
                if( indexToCompare >= 0
                    &&
                    valueToInsert.compareTo( elements.get(indexToCompare)) < 0
                    )
                    elements.set(indexToCompare + 1, elements.get(indexToCompare));
                // otherwise drop
                else{ elements.set(indexToCompare + 1, valueToInsert);
                      return;
                }
            
            }
    }
}
