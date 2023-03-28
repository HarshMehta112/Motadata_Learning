public class DoublyLinkedList {

    static class Node
    {
        private int data;

        Node next;

        Node head;
        Node prev;

        Node(int data)
        {
            this.data = data;
        }

        Node(int data, Node next, Node prev)
        {
            this.data = data;

            this.next = next;

            this.prev = prev;
        }

        public void insertFirst(int data)
        {
            Node toIsert = new Node(data);

            toIsert.next = head;

            toIsert.prev = null;

            if(head!=null)
            {
                head.prev = toIsert;
            }

            head = toIsert;

        }

        public void insertLast(int data)
        {
            Node toInsert = new Node(data);

            Node temp = head;

            while(temp.next!=null)
            {
                temp=temp.next;
            }

            temp.next = toInsert;

            toInsert.prev =temp;

            toInsert.next = null;

        }

        public void display()
        {
            Node temp = head;

            while(temp!=null)
            {
                System.out.print(temp.data + "-> ");

                temp = temp.next;
            }

            System.out.println("null");

        }

    }

}

class DoublyLinkedListImplement
{
    public static void main(String[] args) {

        DoublyLinkedList.Node obj = new DoublyLinkedList.Node(4);

        obj.insertFirst(5);

        obj.insertFirst(345);

        obj.insertLast(32432);

        obj.display();


    }
}