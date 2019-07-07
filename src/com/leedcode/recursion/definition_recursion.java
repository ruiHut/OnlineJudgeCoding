import com.sun.jndi.url.rmi.rmiURLContext;
import com.sun.org.apache.xpath.internal.functions.Function;

/**
 * func recursion(level, param1, param2, ...) {
 *      // recursion terminator
 *      if level > MAX_LEVEL {
 *          print_result
 *          return     
 *      }
 *  
 *      // process logic in current level
 *      process_data(level, data...)
 *      
 *      // drill down
 *      recursion(level + 1, p1...)
 * 
 *      // reverse the current level status if needed
 *      reverse_state(level)
 * }
 */

 // simple example: 1*2*3*4*..*n
 class solution {
    public int  nFactorial(int n) {
        if n <= 1 
            return 1;
        return n * nFactorial(n - 1);
    }
 }