//George Liang
//AP CS PD 08
//2017 - 12 - 07
//HW48 - Keep Guessing
/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target,_holdHi,_holdLo;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
	_guessCtr = 0;
	_target = (int)(Math.random() * b) + a; 
	_lo = a;
	_hi = b;
	_holdHi = _hi;
	_holdLo = _lo;
	
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() 
    {
	int input; // variable for user input 
	System.out.println("Guess a number from " + _holdLo + "-" + _holdHi);
	input = Keyboard.readInt();
	if (input == _target){ // determines if the user has won
	    _guessCtr += 1;
	    System.out.println("Winner Winner Chicken Dinner! It took " + _guessCtr + " guesses.");
	}
	else{
	    _guessCtr += 1;
	    if (input < _target){// input too high
		_holdHi = _holdHi - (int)((_holdHi - _target)/2);
		_holdLo = _holdLo + (int)((_target - _holdLo)/2);
		System.out.println("Too low, try again...");
		playRec();
	    }
	    else{// input too low
		_holdHi = _holdHi - (int)((_holdHi - _target)/2);
		_holdLo = _holdLo + (int)((_target - _holdLo)/2);
		System.out.println("Too high, try again...");
		playRec();
	    }
	}	
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
	int input; // variable for user input
	boolean win = false; // determines if there is a win
	int low = _lo;
	int high = _hi;
	while(!win){
	    System.out.println("Guess a number from " + low + "-" + high);
	    input = Keyboard.readInt();
	    _guessCtr += 1;
	    if (input == _target){
		win = true;
		System.out.println("Winner Winner Chicken Dinner! It took " + _guessCtr + " guesses.");
	    }
	    else if (input < _target){
		high = high - (int)((high - _target)/2);
		low = low + (int)((_target - low)/2);
		System.out.println("Too low, try again...");
	    }
	    else{
		high = high - (int)((high - _target)/2);
		low = low + (int)((_target - low)/2);
		System.out.println("Too high, try again...");
	    }
	}
    }
    

    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 
	playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {

	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();

    }//end main

}//end class
