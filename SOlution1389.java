class Node{
    Node next; 
    int val;

    public Node(int val){
        this.val = val;
    }
}

class CustomList{
    Node head; 

    public void insertVal(int val, int index){
        // if the index is index is 0 or the head is null
        Node temp = new Node(val);
        if(index == 0){
            if(head == null){
                head = temp;
            }else{
                temp.next = head;
                head = temp;
            }
        }else{
            // when the undex is anython else than 0
            Node prev = null;
            Node cur  = head;
            for(int i = 0; i < index; i++){
                if(i == index - 1){
                    prev = cur;
                } 
                cur = cur.next;
            }
        }
    }

    // to convert to an array in java
    public  int[] toArray(int length){
        int[] target = new int[length];
        Node curr=head;
        int i=0;
        while(curr!=null){
            target[i]=curr.val;
            curr=curr.next;
            i++;
        }
        return target;
    }
    
}

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
    
    }
}