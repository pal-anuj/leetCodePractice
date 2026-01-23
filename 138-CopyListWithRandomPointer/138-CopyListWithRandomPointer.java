// Last updated: 24/01/2026, 00:10:14
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head==null) return null;
        Node next,res;
        for(Node curr=head; curr!=null;){
            next= curr.next;
            curr.next= new Node(curr.val);
            curr.next.next= next;
            curr=next;
        }

        for(Node curr=head; curr!=null;curr= curr.next.next){
            curr.next.random= (curr.random!=null)? curr.random.next: null;
        }

        Node original= head; Node copy= head.next;
        res= copy;
        while(original!=null && copy!=null){

            original.next= 
                original.next!=null? original.next.next: original.next;
            
            copy.next= 
                copy.next!=null? copy.next.next: copy.next;
            
            original= original.next;
            copy= copy.next;
        }

        return res;

        /*
        Node curr= head;
        Map<Node,Node> map= new HashMap<>();
        while(curr!=null){            
            map.put(curr, new Node(curr.val));
            curr= curr.next;
        }

        for(Node temp=head;temp!=null; temp=temp.next)
        {
            Node cloneCurr= map.get(temp);
            cloneCurr.next= map.get(temp.next);
            cloneCurr.random= map.get(temp.random);
        }

        Node newHead= map.get(head);
        return newHead;
        */
    }
}