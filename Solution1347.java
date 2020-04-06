// toCHarArray is an important function used to convert a string into a 
// array of chars 
class Solution {

    public int minSteps(String s, String t) {
        if (s == null || t == null || s.isEmpty() || s.equals(t))
            return 0;
        
        int[] store = new int[256];
        int res = 0;
        
        for (char c : s.toCharArray())
            store[(int)c]++; // increment all characters from the s str
        
        for (char c : t.toCharArray())
            store[(int)c]--; //  dicrement all characters from the s str
        
        for (int i : store)
            if (i < 0) // if there are chars with negative value, there aren`t exist in the `s` string
                res+= Math.abs(i);
        
        return res;
    }
}