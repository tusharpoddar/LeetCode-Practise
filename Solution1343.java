// the following solution is correct but we need tomake this code run in less time
// in this uproach I am making a new array everyime and then calculating the sum of the 
// array and then calculating its average
class Solution1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int flag  = 0;
        int length = arr.length;
        int[] temp = new int[k];
        for(int n = 0; n < length - k + 1; n++){
            
            // making a subarray of the given size
            int sum = 0;
            for (int i = 0; i < k; i++){
                temp[i] = arr[n + i];
                sum += arr[n+i];
            }
            System.out.println(sum);
            System.out.println(temp.toString());
            if(sum / k >= threshold){
                flag++;
            }
        }
        return flag;  
    }
}

// in the better sultion there is no need to make a new array as we only need to take into the 
// account the sum and we dont care about the array itself. So making a new one everytime does 
// not make sense
// this is a better solution - very less space is used
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int flag  = 0;
        int length = arr.length;
        int prevsum = 0;
        int sum = 0;
        int prevnum = arr[0];

        for(int n = 0; n < length - k + 1; n++){
            // calculating the sum for the first time 
            if(n == 0){
                for (int i = 0; i < k; i++){
                    sum += arr[n+i];
                }
                prevsum = sum;
            } else {
                sum = prevsum - prevnum + arr[n + k - 1];
                prevsum = sum;
            }
            prevnum = arr[n];
            
            System.out.println();

            if(sum / k >= threshold){
                flag++;
            }
        }
        return flag;  
    }
}
