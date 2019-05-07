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
      sort the user's data, implementing insertion sort
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
      helper function for mySort()
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
