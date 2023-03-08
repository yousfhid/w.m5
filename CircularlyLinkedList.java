public class CircularlyLinkedList<E> {
    public class Node<E>
    {
        private E element;
        private Node<E> next;

        public Node(E e, Node n)
        {
            element = e;
            next = n;
        }
        public E getElement( ) { return element; }
        public Node<E> getNext( ) { return next; }
        public void setNext(Node<E> n) { next = n; }
    }

    public Node<E> tail = null;
    public int size = 0;

    //Method
    public boolean isEmpty()
    { return size == 0;}

    // Q1
    public void addFirst(E e)
    {
        if(isEmpty()){
            tail = new Node<>(e, null);
            tail.setNext(tail);
        }
        else
            tail.next = new Node<>(e, tail.getNext());
        size++;
    }
    public void addLast(E e)
    {
        addFirst(e);
        tail = tail.getNext();
    }
    // Q2
    public int size()
    {
        if(tail == null)
            return 0;
        if(tail.getNext() == tail)
            return 1;
        Node<E> check = tail.getNext();
        int i = 1;
        while(check != tail)
        {
            check = check.next;
            i++;
        }
        return i;
    }
    // Q3
    public boolean equals(CircularlyLinkedList c)
    {
        Node<E> one = tail.next;
        Node<E> two = c.tail.next;
        boolean check = false;
        while(one != tail && two != c.tail){
            if(one.element != two.element)
                return false;
            one = one.next;
            two = two.next;
        }
        if(one == tail && two == c.tail)
            return true;
        return false;
    }

    // Q4
    public boolean Sequence(CircularlyLinkedList a)
    {
        Node<E> o1= tail.next;
        Node<E> o2 = a.tail.next;
        while(o2 != a.tail){
            if(o1.element == o2.element)
                break;
            o2 = o2.next;
        }
        while(o1.element == o2.element && o2 != a.tail){
            o1 = o1.next;
            o2 = o2.next;
        }
        if(o1.element != o2.element)
            return false;

        return true;
    }

    // Q5
    public void half(CircularlyLinkedList l1,CircularlyLinkedList l2)

    {
        if(!isEmpty())
            if(size % 2 == 0){
                int count = 1;
                while(count <= size/2){
                    tail = tail.next;
                    l1.addLast(tail.element);
                    count++;
                }
                while(count <= size){
                    tail = tail.next;
                    l2.addLast(tail.element);
                    count++;
                }
            }
    }

    public void clone(CircularlyLinkedList z)
    {
        if(!isEmpty())
        {
            Node<E> n = tail;
            while(n.next != tail)
            {

                n = n.next;
                z.addLast(n.element);
            }
            z.addLast(tail.element);
        }
    }
}
