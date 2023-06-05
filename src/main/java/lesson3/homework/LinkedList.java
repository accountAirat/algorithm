package lesson3.homework;

public class LinkedList {
    private Node head;
    private Node tail;

    class Node {
        private int value;
        private Node next;
        private Node prev;

        @Override
        public String toString() {
            return value + " ";
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * Метод добавления новых элементов в начало списка
     * @param value = Значение int
     */
    public void insert(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
            head.prev = node;
        } else {
            tail = node;
        }
        this.head = node;
    }

    public void insert(Node node) {
        if (head != null) {
            node.next = head;
            head.prev = node;
        } else {
            tail = node;
        }
        this.head = node;
    }

    /**
     * Метод удаление первого элемента
     * @return Значение удалённого элемента
     */
    public Integer remove() {
        if (head != null) {
            int temp = head.value;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return temp;
        }
        return null;
    }

    public Boolean search(int value) {
        if (head != null) {
            Node node = head;
            if (node.value == value) {
                return true;
            }
            while (node.next != null) {
                node = node.next;
                if (node.value == value) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Метод добавления новых элементов в конец списка
     * @param value = Значение int
     */
    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.prev = tail;
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
    }

    /**
     * Метод добавления элементов в конец списка
     * @param value
     */
    public void add(Node value) {
        if (head != null) {
            value.prev = tail;
            tail.next = value;
        } else {
            head = value;
        }
        tail = value;
    }

    public Integer pop() {
        if (tail != null) {
            int temp = tail.getValue();
            tail = tail.getPrev();
            if (tail != null) {
                tail.next = null;
            }
            return temp;
        }
        return null;
    }

    public Node popNode() {
        if (tail != null) {
            Node temp = tail;
            tail = tail.getPrev();
            if (tail != null) {
                tail.next = null;
            }
            return temp;
        }
        return null;
    }

    /**
     * Метод разворота связного списка
     */
    public void revert() {
        if (head != null && head.getNext() != null) {
            Node node1 = head;
            Node node2 = tail;
            Node temp;
            int len = this.length()/2;
            for (int i = 0; i < len; i++) {
                swap(node1,node2);
                temp = node1;
                node1 = node2.getNext();
                node2 = temp.getPrev();
            }
        }
    }

//    public Integer index(int x) {
//        if (tail == null) {
//            return null;
//        }
//        Node node = tail;
//        for (int i = 1; i < x; i++) {
//            if (node.getPrev() == null) return null;
//            node = node.getPrev();
//        }
//        return node.getValue();
//    }

    public Integer index(int x) {
        if (head == null) {
            return null;
        }
        int i = 0;
        Node temp = head;
        Node node = head;
        while (node.getNext() != null){
            node = node.getNext();
            if (i>=x) {
                temp = temp.getNext();
            }
            i++;
        }
        return temp.getValue();
    }

    /**
     * Метод сортировки пузырьком, с заменой значений элементов
     */
    public void bubleSort() {
        int len = length();
        for (int i = 0; i < len - 1; i++) {
            Node node = head;
            while (node.next != null) {
                if (node.value > node.next.value) {
                    Node temp = new Node();
                    temp.setValue(node.value);
                    node.setValue(node.next.getValue());
                    node.next.setValue(temp.getValue());
                }
                node = node.next;
            }
        }
    }

    /**
     * Метод сортировки пузырьком, с заменой элементов
     */
    public void bubleSortSwap() {
        int len = length();
        if (head == null || head.getNext() == null) {
            return;
        }
        for (int i = 0; i < len - 1; i++) {
            Node node = head;
            while (node.next != null) {
                if (node.value > node.next.value) {
                    swap(node, node.next);
                }
                node = node.next;
            }
        }
    }

    /**
     * Метод определения длины списка
     * @return = Длина списка
     */
    public int length() {
        if (this.head == null) {
            return 0;
        }
        int len = 1;
        Node i = head;
        while (i.next != null) {
            len++;
            i = i.next;
        }
        return len;
    }

    /**
     * Метод обмена элементов
     * @param node1 Первый элемент
     * @param node2 Второй элемент
     */
    private void swap(Node node1, Node node2) {
        Node temp = new Node();

        temp.setPrev(node2.getPrev());
        node2.setPrev(node1.getPrev());
        if (temp.getPrev() == node1) {
            node1.setPrev(node2);
        } else {
            node1.setPrev(temp.getPrev());
        }

        temp.setNext(node2.getNext());
        if (node1.getNext() == node2) {
            node2.setNext(node1);
        } else {
            node2.setNext(node1.getNext());
        }
        node1.setNext(temp.getNext());

        if (node2.getPrev() != null) {
            node2.getPrev().setNext(node2);
        } else {
            head = node2;
        }
        node2.getNext().setPrev(node2);

        if (node1.getNext() != null) {
            node1.getNext().setPrev(node1);
        } else {
            tail = node1;
        }
        node1.getPrev().setNext(node1);
    }

    @Override
    public String toString() {
        String result = "LinkedList{ ";
        if (head == null) {
            return result + "}";
        }
        Node node = head;
        result += node;
        while (node.next != null) {
            node = node.next;
            result += node + " ";
        }
        return result + "}";
    }
}
