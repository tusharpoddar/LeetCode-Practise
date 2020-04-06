class Solution {
    // make the nultiple numeber of arrays for all the possible numbers that lead you to the 
    // end of the array. Then return the minimum numebr of values in the 
    public int minJumps(int[] arr) {
        // case when there is just one element in the array 
        if(arr.length == 1){
            return 1;
        }

    }
}


// this the sample solution with bfs 
public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[arr.length];
        for( int i =0; i < arr.length; i++ ) {
            if( !map.containsKey( arr[i])) {
                map.put( arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        
        // bfs solution
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        int result =0;
        while(!q.isEmpty()) {
            int size = q.size();
            while( size > 0 ) {
                Integer curr = q.poll();
                if( curr == arr.length -1 ) return result;
                if( curr + 1 < arr.length && !visited[curr+1]) {
                    q.add(curr+1);
                    visited[curr+1] = true;
                }
                if( curr - 1 >= 0 && !visited[curr-1] ) {
                    q.add(curr-1);
                    visited[curr-1] = true;
                }
                List<Integer> list = map.get(arr[curr]);
                for( int a : list ) {
                    if( a == curr ) {
                        continue;
                    }
                    if( !visited[a] ) {
                        q.add(a);
                        visited[a] = true;
                    }
                }
                list.clear(); // avoid later lookup.. already visited
                size--;
            }
            result++;
        }
        return -1;
    }