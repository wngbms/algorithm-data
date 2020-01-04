package _03_List;

import java.awt.*;
import java.util.Stack;

public class SingleListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//
//        // 测试一下单链表的反转功能
//        System.out.println("原来链表的情况~~");
//        singleLinkedList.list();

        //加入按照编号的顺序
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero3);

        singleLinkedList.addByIndex(hero1, 1);
        singleLinkedList.addByIndex(hero2, 1);
        singleLinkedList.addByIndex(hero3, 1);
        singleLinkedList.addByIndex(hero4, 1);

//        System.out.println("链表长度：" + singleLinkedList.getLength());
//
//        //显示一把
//        System.out.println("顺序添加的情况~~");
//        singleLinkedList.list();
//        System.out.println("last3:" + singleLinkedList.findLastIndexNode(3));
//        System.out.println("last2:" + singleLinkedList.findLastIndexNode(2));
//        System.out.println("last1:" + singleLinkedList.findLastIndexNode(1));
//        System.out.println("last0:" + singleLinkedList.findLastIndexNode(0));
//
//        //测试修改节点的代码
//        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
//        singleLinkedList.update(newHeroNode);
//
//        System.out.println("修改后的链表情况~~");
//        singleLinkedList.list();
//
//        //删除一个节点
//        System.out.println("删除1："+singleLinkedList.delete(1));
//        System.out.println("删除4："+singleLinkedList.delete(4));
//        System.out.println("删除后的链表情况~~");
//        singleLinkedList.list();
//
//        System.out.println("链表长度：" + singleLinkedList.getLength());

//        System.out.println("del:" + singleLinkedList.deleteByIndex(2));
//        singleLinkedList.list();
//        System.out.println("del:" + singleLinkedList.deleteByIndex(2));
//        singleLinkedList.list();
//        System.out.println("del:" + singleLinkedList.deleteByIndex(2));
//        singleLinkedList.list();

        singleLinkedList.list();

        System.out.println("==========================");
//        singleLinkedList.reverseList();
//        singleLinkedList.list();

        singleLinkedList.reverseShow();
    }
}

class SingleLinkedList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByIndex(HeroNode heroNode, int index) {
        HeroNode temp = head;

        int length = getLength();
        if (index > length) {
            index = length;
        } else if (length <= 0) {
            index = 1;
        }

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        heroNode.next = temp.next;
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
                return;
            }
            temp = temp.next;
        }

        heroNode.next = temp.next;
        temp.next = heroNode;
    }

    public void update(HeroNode newHeroNode) {
        HeroNode temp = head;

        if (temp.next == null) {
            System.out.println("链表为空~");
            return;
        }

        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            } else if (temp.next.no == newHeroNode.no) {
                temp.next.name = newHeroNode.name;
                temp.next.nickname = newHeroNode.nickname;
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (!flag) {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    public HeroNode delete(int no) {
        HeroNode temp = head;
        HeroNode deleted = null;

        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.no == no) {
                deleted = temp.next;
                temp.next = temp.next.next;
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (!flag) {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

        return deleted;
    }

    public HeroNode deleteByIndex(int index) {
        HeroNode temp = head;
        HeroNode deleted = null;

        int length = getLength();
        if (index <= 0 || index > length) {
            return null;
        }

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        deleted = temp.next;
        temp.next = temp.next.next;

        return deleted;
    }

    public void list() {
        HeroNode temp = head;

        if (temp.next == null) {
            System.out.println("链表为空！");
            return;
        } else {
            temp = temp.next;
        }

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void reverseShow() {
        HeroNode temp = head;

        if (temp.next == null) {
            System.out.println("链表为空！");
            return;
        }

        Stack<HeroNode> stack = new Stack<>();
        while (temp.next != null) {
            stack.push(temp.next);
            temp = temp.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    public int getLength() {
        HeroNode temp = head;

        if (temp.next == null) {
            return 0;
        } else {
            temp = head.next;
        }

        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public HeroNode findLastIndexNode(int index) {
        HeroNode temp = head;

        int length = getLength();
        if (length == 0 || index <= 0 || index > length) {
            return null;
        }

        temp = temp.next;
        for (int i = 0; i < length - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void reverseList() {
        HeroNode reverseHead = null;

        int length = getLength();
        if (length == 0 || length == 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            HeroNode first = deleteByIndex(1);
            first.next = null;
            if (reverseHead != null) {
                first.next = reverseHead;
            }
            reverseHead = first;
        }

        this.head.next = reverseHead;
    }

}

//定义HeroNode ， 每个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}
