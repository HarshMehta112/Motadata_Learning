import java.util.LinkedList;

public class HashMapCode {

    static class HashMap<k, v> {
        private class Node {
            k key;
            v value;

            public Node(k key, v value)
            {
                this.key = key;

                this.value = value;
            }

        }

        private int n; // no of nodes
        private int N;// no of buckets

        private LinkedList<Node> buckets[];

        public HashMap()
        {
            this.N = 4;

            this.buckets = new LinkedList[4];

            for (int iterator = 0; iterator < 4; iterator++)
            {
                this.buckets[iterator] = new LinkedList<>();
            }

        }

        private int hasFunction(k key)
        {
            int bucketIndex = key.hashCode();

            return Math.abs(bucketIndex)%N;

        }



        private int searchInLL(k key, int bucktIndex)
        {
            LinkedList<Node> list = buckets[bucktIndex];

            for(int iterator=0; iterator<list.size(); iterator++)
            {
                if(list.get(iterator).key == key)
                {
                    return iterator;
                }
            }

            return -1;

        }

        public void put(k key, v value)
        {

            int bukcetIndex = hasFunction(key);

            int dataIndex = searchInLL(key,bukcetIndex);

            if(dataIndex == -1)
            {
                buckets[bukcetIndex].add(new Node(key,value));

                n++;

            }
            else
            {
                Node newNode = buckets[bukcetIndex].get(dataIndex);

                newNode.value = value;

            }

        }

        public v get(k key)
        {
            int bukcetIndex = hasFunction(key);

            int dataIndex = searchInLL(key,bukcetIndex);

            if(dataIndex == -1)
            {
                return null;
            }
            else
            {
                Node newNode = buckets[bukcetIndex].get(dataIndex);

                return newNode.value;

            }
        }

        public  v remove(k key)
        {
            int bukcetIndex = hasFunction(key);

            int dataIndex = searchInLL(key,bukcetIndex);

            if(dataIndex == -1)
            {
                return null;
            }
            else
            {
                Node newNode = buckets[bukcetIndex].remove(dataIndex);

                return newNode.value;

            }

        }

    }

}

