package _04_stack;

public class ListStackDemo {

    public static void main(String[] args) {
        ListStack listStack = new ListStack();

        System.out.println(listStack.isEmpty());

        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        listStack.push(4);
        listStack.push(5);

        System.out.println(listStack.isEmpty());

        System.out.println(listStack.pop());
        System.out.println(listStack.pop());

        listStack.list();
    }
}

class Node {
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class ListStack {
    private Node top;

    //栈满
    public boolean isFull() {
        return false;
    }
    //栈空
    public boolean isEmpty() {
        return top == null;
    }
    //入栈-push
    public void push(int value) {
        Node node = new Node(value);

        if (top == null) {
            top = node;
        } else {
            node.setNext(top);
            top = node;
        }

    }
    //出栈-pop, 将栈顶的数据返回
    public int pop() {
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }

        int value = top.getValue();
        top = top.getNext();
        return value;
    }
    //显示栈的情况[遍历栈]，遍历时，需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~~");
            return;
        }

        while (top != null) {
            int value = top.getValue();
            System.out.println(value);
            top = top.getNext();
        }
    }
}
