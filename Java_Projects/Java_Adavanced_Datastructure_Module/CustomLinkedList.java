
public class CustomLinkedList
{
    static class Node
    {
        int data;
        Node next;

        Node head;

        Node tail;

        Node(int data)
        {
            this.data = data;
            next = null;
        }


        void insertFirst(int data)
        {
            Node temp = new Node(data);

            temp.next = head;

            head = temp;

            if(tail==null)
            {
                tail = head;
            }

        }

        public void deleteFirst()
        {
            if(head!=null)
            {
                head = head.next;
            }
            else
            {
                return;
            }

        }

        public void deleteLast()
        {
            Node temp = head;

            if(head!=null)
            {
                while(temp.next.next!=null)
                {
                    temp = temp.next;
                }
                temp.next = null;
            }
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

        void insertLast(int data)
        {
            Node node = new Node(data);

            Node temp = head;

            while(temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = node;

            //node.next = null;

        }

        public void insert(int data, int index)
        {
            if(index==0)
            {
                insertFirst(data);

                return;
            }

            Node temp = head;

            for(int itr = 0; itr<index-1;itr++)
            {
                temp = temp.next;
            }

            Node nodeToInsert = new Node(data);

            nodeToInsert.next = temp.next.next;

            temp.next = nodeToInsert;


        }



    }



}


class LinkedListImplement
{
    public static void main(String[] args) {

        CustomLinkedList.Node obj = new CustomLinkedList.Node(1);

        obj.insertFirst(5);

        obj.insertFirst(3);

        obj.insertFirst(4);

        obj.insertFirst(5);

        obj.insertLast(90);

        obj.insert(33,3);

        obj.deleteFirst();

        obj.deleteLast();

        obj.display();





    }
}
