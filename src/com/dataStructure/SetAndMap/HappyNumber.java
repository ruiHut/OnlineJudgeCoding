import java.util.HashSet;

/**
 * q 202 happy number
 * 1. set 
 */
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1) {
            int res = 0;
            while(n != 0) {
                res += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (set.contains(res)) return false;
            set.add(res);
            n = res;
        }
        return true;
    }
}

class Solution {
    public boolean isHappy(int n) {
        if(n<10) {
            if(n==1||n==7) return true;
            else return false;
         }
        int b;int sum=0;
        while(n>0) {
              b=n%10;
              sum=sum+b*b; 
              n=n/10;
          } 
         return isHappy(sum);
      }
}