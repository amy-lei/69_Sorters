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
      sort the user's data, implementing selection sort
     */
    public void mySort() {
        //iterate through list
        for( int index = 0
            ;index < elements.size()
            ;index++
            ){
        // find smallest and set it at cur index
                String smallest = elements.get(champIndex(index));
                elements.set( index
                            , smallest
                            );
                //for debugging
                System.out.println( "after inserting element "
                                    + smallest
                                    + " elements: "
                                    + elements
                                    );
            }
    }
    
    /**
      helper function for mySort
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
