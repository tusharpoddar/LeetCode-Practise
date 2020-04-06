// this is a question of dynamic progression
// try to use a matrix in questions of a dp

// in this class we define the sorting method for an a
class Solution {
	public int getKth(int lo, int hi, int k) {
		int[][] number=new int[hi-lo+1][2];
		int index=0;
    
		for(int i=lo; i<=hi; i++) {
			int temp=i;
			int count=0;
			while(temp!=1){
				if((temp&1)==1) temp=(temp<<1)+temp+1;
				else temp>>=1;
				++count;    
			}
			number[index][0]=i;
			number[index][1]=count;
			++index;
		}

        // so here we are defining the comparator class to compare the array on the 
        // basis of a used defined rules, in this we define the compare to method that takes in the 
        // row of the matrix and sorts it based on the second number 
		Arrays.sort(number, new Comparator<int[]>(){
		   public int compare(int[] a, int[] b){
			   if(a[1]==b[1])
				   return a[0]-b[0];
			   return a[1]-b[1];
		   } 
		});
    
		return number[k-1][0];
	}
}