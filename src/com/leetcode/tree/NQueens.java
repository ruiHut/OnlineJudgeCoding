import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class solution {
    static List<String[]> res = new ArrayList<String[]>();
    static List<Integer> cols = new HashSet<Integer>();
    static Set<Integer> xyDif = new HashSet<Integer>();
    static Set<Integer> xySum = new HashSet<Integer>();

    public List<String[]> solveNQueens(int n) {
        if (n < 1) return null;
        DFS(n, 0, new String[n]);
        return res;
    }
    
    private void DFS(int n, int row, String[] curRes ) {
        // ending time 
        if (row >= n){
            res.add(curRes);
            return;
        }
        
        // range 
        for (int i = 0; i < n; i++) { // i = col 
            if (cols.contains(i) || xyDif.contains(row - i) || xySum.contains(row + i)) 
                // go die;
                continue;
            
            // update the unable set
            cols.add(i);
            xyDif.add(row - i);
            xySum.add(row + i);
            /**
             *  update curRes
             **/

            // continue recursion
            DFS(n, row + 1, curRes);
            
            // clear the curRes
            cols.remove(i);
            xyDif.remove(row - 1);
            xySum.remove(row + 1);
        }
    }
}