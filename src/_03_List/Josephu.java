package _03_List;

public class Josephu {

    public static void main(String[] args) {

        CircleSingleLinkedList list = new CircleSingleLinkedList();

        list.show();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
        list.multiAdd(9);
        list.show();

        list.countBoy(3,2,9);
    }
}

class CircleSingleLinkedList {
    private Boy first = null;
    private Boy curBoy = null;

    public void add(int no){
        Boy temp = new Boy(no);

        if (first == null) {
            first = temp;
            first.setNext(temp);
            curBoy = temp;
            return;
        } else {
            curBoy.setNext(temp);
            temp.setNext(first);
            curBoy = temp;
        }
    }

    public void multiAdd(int nums) {
        for (int i = 0; i < nums; i++) {
            Boy boy = new Boy(i + 1);

            if (i == 0) {
                first = boy;
                first.setNext(boy);
                curBoy = boy;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void show() {
        if (first == null) {
            System.out.println("该链表为空！");
            return;
        }
        Boy current = first;
        while (true) {
            System.out.print(current.getNo()+" -> ");
            current = current.getNext();

            if (current == first) {
                break;
            }
        }
        System.out.println();
    }

    public int size() {
        int size = 0;
        if (first == null) {
            return 0;
        } else {
            Boy curBoy = first;
            while (true) {
                size++;
                curBoy = curBoy.getNext();
                if (curBoy == first) {
                    break;
                }
            }
        }
        return size;
    }

    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || countNum > nums) {
            System.out.println("输入测参数有误！");
            return;
        }

        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
        }
        Boy helper = first.getNext();
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        while (true) {
            if (helper == first) {
                break;
            }

            for (int i = 0; i < countNum - 1; i++) {
                helper = helper.getNext();
                first = first.getNext();
            }

            System.out.printf("小孩%d出圈\n", first.getNo());

            first = first.getNext();
            helper.setNext(first);
        }

        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }

}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public Boy(int no, Boy next) {
        this.no = no;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
