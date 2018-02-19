package recursion;
public class RecursiveFibonacci
{


    /**
     * basic - The simple version of fibonacci.
     * 
     * @param  n   A positive integer. 
     * @return     The nth fibonacci number.
     */
    public long basic(long n)
    {
        long result = 1;
        
        if( n <= 0)
            result = 0;
        else if (n == 1)
            result = 1;
        else
            result = basic(n-1) + basic(n-2);
        
        return result;
    }
    
    
    /**
     * better - A better version of fibonacci. (Height Limited Double Recursion)
     * 
     * @param  n   A positive integer.
     * @return     The nth fibonacci number.
     */
    public long better(long n)
    {
        long result = 0;
        // IMPLEMENT THIS RECURSIVE METHOD
//>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>    
        if (n < 2)
            // base case
            result = n;
        else
        {
            long  last, secondLast;
    
            last = better(n/2);
            secondLast = better(n/2 - 1);
    
            if (n % 2 == 0)
            {
                // apply even formula
                result = last * last + 2 * last * secondLast;
            }
            else
            {
                // apply odd formula
                result = 2 * last * last + 2 * last * secondLast + secondLast * secondLast;
            }
        }
	
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<        
        return result;
    }


    /**
     * tailRecursive - A tail recursive version of fibonacci. 
     *              (Height limited, Two problems per level)
     * 
     * @param  n   A positive integer. 
     * @return     The nth fibonacci number.
     */
    public long tailRecursive(long n)
    {
        // IMPLEMENT THIS METHOD USING A RECURSIVE HELPER FUNCTION
        // AND RETURN AN APPROPRIATE VALUE
//>>>>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>        
        if (n <= 2)
        {
            // base case
            return n;
        }
        
        return helper(n, 1, 0);
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<        
    } 
    
     
    /**
     * helper - The tail recursive helper function.
     * 
     * @param  n   A positive integer. 
     * @param  fi  The partial result f(i).
     * @param  fi1   The partial result f(i-1).
     * @return      The nth fibonacci number.
     */

    public long helper(long n, long fi, long fi1)
    {  
        long result = 0;
        long last;
        long secondLast;
//>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>           

     if (n <= 1)
     {
         // base case
         return fi;
     }   
     
     if (secondMSB(n))
     {  // Apply odd formula
         last = 2 * fi * fi + 2 * fi * fi1 + fi1 * fi1;
         secondLast = fi * fi + 2 * fi * fi1;  
     }
     else
     {
         // Apply even formula
         last = fi * fi + 2 * fi * fi1;
         secondLast = fi * fi + fi1 * fi1;         
     }
     
    n = reduceBy2ndMSB(n);
     
    return helper(n, last, secondLast);
     
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<        
     // return helper(fi, n + fi, fi1);
    }
       

    /**
     * secondMSB - Determine the value of the second most significant bit.
     * 
     * @param  n   A positive integer 
     * @return     True if the second most significant bit is 1, false otherwise.
     */    
    public boolean secondMSB(long n)
    {
        // IMPLEMENT THIS METHOD AND RETURN AN APPROPRIATE VALUE
//>>>>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  
        // convert long n to bit pattern
        String  bits = Long.toString(n, 2);
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 
        return (bits.substring(1,2).equals("1"));
    }


    /**
     * reduceBy2ndMSB - Reduce the number by removing the second most significant bit
     * from the representation.
     * 
     * @param  n   A positive integer > 1
     * @return     The integer value equivalent to removing the 2nd most significant bit
     *              from n.
     */    
    public long reduceBy2ndMSB(long n)
    {
        long result = 1;
        // IMPLEMENT THIS METHOD
//>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>    
        // convert integer n to bit pattern
        String  bits = Long.toString(n, 2);
        
        bits = bits.substring(0,1) + bits.substring(2);
        
        // Convert bit pattern back to long n
        result = Long.valueOf(bits, 2);
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        
        return result;
    }
    
    
}
