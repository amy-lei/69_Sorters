/**
  Implement an insertion sort, in the Sorters structure
 */
import java.util.ArrayList;

public class SelectionSorter extends Sorter{

    /**
      Construct an instance to process the user's data
     */
    public SelectionSorter(  ArrayList< String> usersData) {
        super(usersData);
    }
    

    /**
      pre-condition: must be invoked on an Array of Strings
      
      While iterating through the list from index 0 to n-2, mySort will select the reigning dweeb and swap it with the first element of the unsorted region. 
      
      post-condition: the Array mySort() is invoked on will be sorted in monotonic increasing order.
     */
    public void mySort() {
        //iterate through list
        for( int index = 0
            ;index < elements.size() - 1
            ;index++
            ){
        // find smallest and set it at cur index
                int smallest = champIndex(index);
                elements.set( smallest
                            , elements.set( index
                                           ,elements.get(smallest)
                                           )
                            );
                //for debugging
                System.out.println( "after inserting element "
                                    + elements.get(smallest)
                                    + " elements: "
                                    + elements
                                    );
            }
    }
    
    /**
      pre-condition: the startingIndex must be the first element of the unsorted region in a list
      
      Iterate through the list from the startingIndex to n-1 and update the reigning dweeb
      
      post-condition: champIndex will guarantee the the return value is the smallest value from the unsorted region.
     */
    private int champIndex(int startingIndex){
        int champ = startingIndex;
        //iterate through
        for(  startingIndex++
            ; startingIndex < elements.size()
            ; startingIndex++
            ){
        //if smaller, set as new champIndex
                if( elements.get(champ).compareTo(elements.get(startingIndex)) > 0)
                    champ = startingIndex;
            }
        
        
        //return results
        return champ;
        
    }
}
