// Team Blah - Shamaul Dilmohamed, Shanjeed Ali
// APCS1 pd10
// HW42 -- Array of Titanium
// 2015-12-06

/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

public class SuperArray { // implements ListInt{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) 
    { 
 	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add(Comparable newVal) {
	if (_size == _data.length) {
	    expand();
	}
	set(_size, newVal ); 
	_size += 1;
	_lastPos += 1;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) {
	if (_size == _data.length) {
	    expand();
	}
	for (int ctr = _size; ctr > index; ctr--) {
	    _data[ctr] = _data[ctr-1];
	}
	_data[index] = newVal;
	_size += 1;
	_lastPos += 1;
    }

    //removes the item at index
    //shifts elements left to fill in newly-emptied slot
    public void remove( int index ) { 
	for (int ctr = _lastPos; ctr > index; ctr--) {
	    _data[ctr-1] = _data[ctr];
	}
	_size -= 1;
	_lastPos -= 1;
    }

    //return number of meaningful items in _data
    public int size() { 
	return _size;
    }

    public int linSearch(Comparable c) {
	int ans = -1;
	for (int ctr = 0; ctr < _size; ctr++) {
	    if (c.equals(_data[ctr])) {
		ans = ctr;
	    }
	}
	return ans;
    }

    public boolean isSorted() {
	boolean ans = false; 
	for (int ctr = 0; ctr < _lastPos; ctr++) {
	    if (_data[ctr].value() < _data[ctr+1].value()) {
		return ans;
	    }
	}
	return true;
    }

    //main method for testing
    public static void main( String[] args ) 
    {
	SuperArray curtis = new SuperArray();
	/*	ListInt happy = new SuperArray();

	System.out.println(happy);
	happy.add(30);
	happy.add(0,118);
	System.out.println(happy);
	happy.remove(0);
	System.out.println(happy);
	System.out.println(happy.size());
	System.out.println(happy.get(0));
	System.out.println(happy.set(4,17));
	*/
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);
	
	curtis.add(new Rational(1,3));
	curtis.add(new Binary(14));
	curtis.add(new Hexadecimal(40));
	curtis.add(new Rational(7,11));
	curtis.add(new Binary("1000"));

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	System.out.println("testing get()...");
	for( int i = 0; i < curtis._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}

	System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis);
	System.out.println(curtis.linSearch(new Rational(7,11)));
	System.out.println(curtis.isSorted());

	/*
	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	  mayfield.add(5);
	  mayfield.add(4);
	  mayfield.add(3);
	  mayfield.add(2);
	  mayfield.add(1);

	  System.out.println("Printing populated SuperArray mayfield...");
	  System.out.println(mayfield);

	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);
	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);

	  mayfield.add(3,99);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(2,88);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(1,77);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield); */
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	//*****INSERT ANY ADDITIONAL TEST CALLS HERE*****

    }//end main
		
}//end class
