/**
  Implement an insertion sort, in the Sorters structure
 */
import java.util.ArrayList;

public class SubSortThenMerge_Sorter extends Sorter{
    
    ArrayList<String> localCopy;
    
    /**
      Construct an instance to process the user's data
     */
    public SubSortThenMerge_Sorter(ArrayList<String> userData){
        super(userData);
    }

    /**
      pre-condition: must be invoked on an Array of Strings
      
      While iterating through the list from index 0 to n-2, mySort will select the reigning dweeb and swap it with the first element of the unsorted region. 
      
      post-condition: the Array mySort() is invoked on will be sorted in monotonic increasing order.
     */
    public void mySort(){
        mySortRecursive(0, elements.size());
        
    }
    
    private void mySortRecursive(int startIndex, int endIndex){
        if( endIndex - startIndex == 1) return ;
        else{
            mySortRecursive(startIndex, (endIndex+startIndex)/2  );
            mySortRecursive((endIndex+startIndex)/2    , endIndex);
            merge( startIndex, (endIndex+startIndex)/2, endIndex);
            
        }

        
        
        
    }
                                                
    
    
    /**
      Merge the sorted sub-lists.
     */
    private void merge(
      // indexes of sub-list boundaries in elements; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int end1    // index past end of list1
      ) {
        /* copy the user's data, so that its two lists
         can be merged into elements */
        localCopy = new ArrayList<String>( end1 - start0);
        for( int iUserData = start0; iUserData < end1; iUserData++)
            localCopy.add( elements.get( iUserData));
        // temp for debugging
        System.out.println( "localCopy: " + localCopy);

        /* Invoke one of the two styles of programming the merge
           Since a real solution would contain only one of these,
           violate NTTSTT in computing the arguments.
         */

        mergeRange_whileStyle( start0
                             , 0, start1 - start0
                             , start1 - start0, end1 - start0);

        // mergeRange_recursive( start0
                            // , 0, start1 - start0
                            // , start1 - start0, end1 - start0);
    }


    /**
      problem: Merge the user data from the given range in localCopy
        into the elements.
     recursive abstraction: When I am asked to {problem statement},
       the recursive abstraction can merge the results of a range
       that is one item smaller.
     */
    private void mergeRange_whileStyle(
        int target // destination in elements. Probably redundant.

        // boundaries of lists in localCopy, NOT elements!
      , int localStart0  // index of first item in list0
      , int localEnd0    // just past end of list0
      , int localStart1  // index of first item in list1
      , int localEnd1    // just past end of list0
      ) {

        while( // item(s) remain in both lists
                  localStart0 < localEnd0
               && localStart1 < localEnd1 )
            // copy the smaller item
            if( localCopy.get( localStart0).compareTo(
                localCopy.get( localStart1)) < 0)
                elements.set( target++, localCopy.get( localStart0++));
            else
                elements.set( target++, localCopy.get( localStart1++));
        /* At this point, one of the lists is exhausted, maybe both.
           So copy the remaining data.
           Which copy operation goes first is immaterial, since
           (at least) one copy operation is trivial.
         */

        // Copy the (possibly null) remainder of list0
        while( localStart0 < localEnd0)
            elements.set( target++, localCopy.get( localStart0++));

        // Similarly for list1: copy the (possibly null) remainder
        while( localStart1 < localEnd1)
            elements.set( target++, localCopy.get( localStart1++));
      }


}