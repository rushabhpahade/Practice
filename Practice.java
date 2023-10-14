class Practice {

    Node head;
    class Node{
        Node next;
        int data;
        Node(int data){
            this.next =null;
            this.data=data;
        }
    }
    public void insert(int data){
        Node newNode = new Node(data);
        if(head==null){
            head =newNode;
        }else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next= newNode;
            newNode.next=null;
        }

    }
    public void printme(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
    }
    public int length(Node root)
    {
        Node temp = root;
        int length=0;
        while(temp!=null)
        {
            length++;
            temp = temp.next;
        }
        return length;
    }
    public void remove(Node root, int fromStart)
    {
        if(fromStart == 0)
        {
             head = head.next;
        }
        else{
            Node temp = root;
            for(int i=0;i<fromStart-1;i++)
            {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }
    public static void main(String [] args)
    {
            int k =5;
            Practice list = new Practice();
            list.insert(1);
            list.insert(2);
            list.insert(3);
            list.insert(4);
            list.insert(5);
            list.printme(list.head);
            int n = list.length(list.head);
            System.out.println(n);
            list.remove(list.head,n-k);
            list.remove(list.head,3);
            list.printme(list.head);
    }

}
