public class byArray {
    
    public static void main(String[] args) {
        cicularQueue queue = new cicularQueue(5);
        System.out.println(queue.isEmpty());
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        // System.out.println(queue.remove());
        while(!queue.isEmpty()) {
            System.out.print(queue.remove()+" ");
        }
        System.out.println(queue.isEmpty());
    }
}
class cicularQueue{
    int first;
    int last;
    int size;
    int[] arr;
    cicularQueue(int data) {
        arr = new int[data];
        last = -1;
        first = 0;
        size = data;
    }
    public boolean isEmpty() {
        return last == -1;
    }
    public void add(int data) {
        if(last == -1) {
            arr[first] = data;
            last = 0;
            return;
        }
        if(first == (last+1)%size) 
        {
            System.out.println("Queue full!");
            return;
        }
        last = (last+1)%size;
        arr[last] = data;
    }
    public int remove() {
        if(isEmpty()) return -1;
        int data = arr[first];
        if(first == last) {
            first = 0;
            last = -1;
            return data;
        }
        first = first+1%size;
        return data;
        // while(first != last-1%size) {
        //     int next = first+1%size;
        //     arr[first] = arr[next];
        //     first = next;
        // }
    }
    public int peek() {
        if(isEmpty()) return -1;
        return arr[first];
    }
}
class QueueByArray{
        int first;
        int last;
        int arraySize;
        int[] arr;
        QueueByArray(int data) {
            arr = new int[data];
            last = -1;
            first = 0;
            arraySize = data;
        }
        public boolean isEmpty() {
            return last == -1;
        }
        public int size() {
            return last+1;
        }
        public void add(int data) {
            if(last+1 == arraySize) {
                System.out.println("No space left "+data+" not added!");
                return;
            }
           
            arr[last+=1] = data;
        }
        public int remove() {
            if(isEmpty()) return -1;
            int data = arr[first];
            if(first == last) {
                first = 0;
                last = -1;
                return data;
            }
            while(first != last) {
                arr[first] = arr[first+1];
                first++;
            }
            first = 0;
            last = last-1;
            return data;
        }
        public int peek() {
            if(isEmpty()) return -1;
            return arr[first];
        }
    }