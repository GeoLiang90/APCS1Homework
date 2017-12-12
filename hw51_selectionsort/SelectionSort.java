//George Liang
//APCS PD 08
//2017-12-12
//HW#51 - Selection 
/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/

import java.util.ArrayList;

public class SelectionSort 
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data ) 
  {
      //smallest keeps track of the smallest index and starts at 0
      int smallest = 0;
      //pass keeps track of the amount of current pass and starts at pass 0 
      int pass = 1;
      while (pass != data.size() - 1){
	  for(int i = 0;i < data.size() - 1; i++){
	      smallest = i;
	      /* Make multiple comparisons where i + 1 is smaller than i, 
		 ensure i + 1 is smaller than everything else in the array */
	      if(data.get(i).compareTo(data.get(i + 1)) > 0){
		  smallest = i + 1;
		  for (int x = smallest + 1;x < data.size() - 1; x++){
			  if(data.get(smallest).compareTo(data.get(x)) > 0){
			  smallest = x;
			  }
		      }
	      }
	      data.set(i, data.set(smallest,data.get(i)) );
	  }
	  pass ++;
      }
		  
  }//end selectionSortV


  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable>
    selectionSort( ArrayList<Comparable> input ) 
  {
      /*Create a temporary ArrayList that sorting changes are made on while
	keeping the input unchanged*/
      ArrayList<Comparable> temp = new ArrayList<Comparable>();
      //for each loop used to add input's values into temp
      for (Comparable x: input){
	  temp.add(x);
      }
      selectionSortV(temp);
      return temp;
  }//end selectionSort 


  public static void main( String [] args ) 
  {
    /*
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    selectionSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );
    */

    //===============for VOID methods=============
      /*
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      selectionSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      */
    

      //==========for AL-returning methods==========
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = selectionSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = selectionSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );


  }//end main

}//end class SelectionSort
