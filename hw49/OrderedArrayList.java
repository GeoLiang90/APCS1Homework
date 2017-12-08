//George Liang
//AP CS PD 08
//2017-12-07
//HW49 - Halving the Halves
/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
  // instance of class ArrayList, holding objects of type Comparable 
  // (ie, instances of a class that implements interface Comparable)
  private ArrayList<Comparable> _data;


  // default constructor initializes instance variable _data
  public OrderedArrayList()
  {
    _data = new ArrayList<Comparable>();    
  }


  public String toString()
  {
    return _data.toString(); 
  }


  public Comparable remove( int index )
  {	
    return _data.remove(index); 
  }


  public int size()
  { 
    return _data.size();
  }

    
  public Comparable get( int index )
  { 
    return _data.get(index); 
  }


  /***
   * add takes as input any comparable object 
   * (i.e., any object of a class implementing interface Comparable)
   * inserts newVal at the appropriate index
   * maintains ascending order of elements
   * uses a linear search to find appropriate index
   ***/
  public void add( Comparable newVal )
  { 
    for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
        //newVal < oal[p]
        _data.add( p, newVal );
        return; //Q:why not break?
	    }
    }
    _data.add( newVal ); //newVal > every item in oal, so add to end 
  }

    // addBin() employs a binary search to locate the point of insertion for a new element.
    public void addBin( Comparable newVal )
    {
	int maxI = _data.size() - 1; // max value's index
	int minI = 0;// min value's index
	int avgI = (int)((maxI + minI)/2);// index of halfway value in OrderedArrayList
	
	// If the center value is equivalent to the newVal, insert the newVal in center value's place
	if (newVal.compareTo(_data.get(avgI)) == 0){
	    _data.add(avgI,newVal);
	    return;
	}
	while (avgI != maxI){
	    if (newVal.compareTo(_data.get(avgI)) > 0){
		minI = avgI + 1;
		avgI = (int)((maxI + minI)/2);
	    }

	    if (newVal.compareTo(_data.get(avgI)) < 0){
		maxI = avgI - 1;
		avgI = (int)((maxI + minI)/2);
	    }
	}
	_data.add(avgI + 1,newVal);
       
	
    }


  // main method solely for testing purposes
  public static void main( String[] args )
  {
    OrderedArrayList Franz = new OrderedArrayList();
    OrderedArrayList George = new OrderedArrayList(); 
    OrderedArrayList Avocado = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.add( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    //check for sorted-ness
    //if msg does not appear, list was sorted
    for( int i=0; i<Franz.size()-1; i++ ) {
      System.out.println("at i: " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }

    //testing binary search 
     for (int i = 0; i < 11; i++)
	Avocado.add( (int) (100 * Math.random() ) );
    System.out.println( Avocado );
    
    Avocado.addBin(40);
    System.out.println( Avocado );

    Avocado.addBin(105);
    System.out.println(Avocado);

   
    
    //simple test for binary search
    George.add(0);
    George.add(5);
    George.add(6);
    System.out.println( George);
    George.addBin(8);

    System.out.println( George );
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class OrderedArrayList
