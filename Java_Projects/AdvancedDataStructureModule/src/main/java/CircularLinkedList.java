public class CircularLinkedList
{
    public static class Node
    {
        private Node next;

        private Node head;

        private int data ;


        Node()
        {
            this.next = next;

            this.data = data;
        }

        Node(int data)
        {
            this.data = data;

            this.next = this;
        }


        void insertFirst(int data)
        {
            Node toInsert = new Node(data);

            if(head==null)
            {
                head = toInsert;
                head.next = head;

                return;
            }

            if (head.next == head) {
                toInsert.next = head;
                head = toInsert;
//                System.out.println(head.data);
                return;
            }

            //toInsert = head;

            Node temp = head.next;


            while(temp.next!=head)
            {
                temp = temp.next;
            }

            temp.next = toInsert;
            toInsert.next = head;
            head = toInsert;

            System.out.println(head.data);
        }

        public void display()
        {
            Node temp = head;

//            System.out.println(temp.next.data);

            while(temp.next!=head)
            {
                System.out.print(temp.data + "-> ");

                temp = temp.next;
            }

        }



    }
}


class CircularImplement
{
    public static void main(String[] args) {

        CircularLinkedList.Node obj =new CircularLinkedList.Node();

        obj.insertFirst(32);

        obj.insertFirst(33);

        obj.insertFirst(34);

        obj.insertFirst(35);

        obj.insertFirst(36);


        obj.display();





    }
}