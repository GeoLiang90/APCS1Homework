//George Liang
//AP CS PD08
//2017-12-10
//HW#50-Dat Bubbly Tho
/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 ******************************/

import java.util.ArrayList;

public class BubbleSort {

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
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
      //index holds the current index thats being tested 
      int index = data.size() - 1;
      //pass keeps track of the amount of current pass and starts at pass 0 
      int pass = 0;
  
      while (pass != data.size()){
	  while(index != 0){
	      Comparable x = data.get(index);
	      Comparable y = data.get(index - 1);
	      if(x.compareTo(y) < 0){
		  Comparable temp = y;
	      data.set(index - 1,x);
	      data.set(index,temp);
	      }
	      //System.out.println(data);
	  index -=1;
	  }
	  index = data.size() - 1;
	  pass +=1;
      }	  
  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
      /*Create a temporary ArrayList that sorting changes are made on while
	keeping the input unchanged*/
      ArrayList<Comparable> temp = new ArrayList<Comparable>();
      //for each loop used to add input's values into temp
      for (Comparable x: input){
	  temp.add(x);
      }
      bubbleSortV(temp);
      return temp;
      
  }


  public static void main( String [] args )
  {

      //===============for VOID methods=============
      /*
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
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
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );

      System.out.println("shuffling coco for a retest");
      shuffle(coco);
      System.out.println( coco ); 
      cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
   
      

    
     

  }//end main

}//end class BubbleSort
