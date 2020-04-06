// code to convert [1,2,3,4] to [2,4,4,4]
class Solution {
    public int[] decompressRLElist(int[] nums) {
        int length = nums.length;
        // calculating the length of the final array 
        int final_length = 0;
        for(int i = 0; i < length; i+=2){
            final_length+= nums[i];
        }
        
        int index = 0;
        int[] ans = new int[final_length];
        for(int i = 0; i < final_length; i+=2){
            if(i < length){
                for(int n = 0; n < nums[i]; n++){
                    ans[index] = nums[i + 1];
                    index++;
                }    
            }
        }
        return ans;
    }
}