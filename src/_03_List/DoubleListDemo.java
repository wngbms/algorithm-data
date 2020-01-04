package _03_List;

public class DoubleListDemo {

    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.del(1);
        doubleLinkedList.del(4);
        doubleLinkedList.del(4);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();
    }

}

class DoubleLinkedList {

    // 先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    // 返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    public void list() {
        HeroNode2 temp = head;

        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        } else {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        heroNode2.pre = temp;
        temp.next = heroNode2;
    }

    public void addByOrder(HeroNode2 heroNode2) {
        HeroNode2 temp = head;

        if (temp.next == null) {
            temp.next = heroNode2;
            heroNode2.pre = temp;
            return;
        }

        while (temp.next != null) {
            if (temp.next.no >= heroNode2.no) {
                break;
            }
            temp = temp.next;
        }



    }

    public void update(HeroNode2 heroNode2) {
        HeroNode2 temp = head;

        if (temp.next != null) {
            temp = temp.next;
        }

        boolean flag = false;
        while (temp != null) {
            if (temp.no == heroNode2.no) {
                temp.name = heroNode2.name;
                temp.nickname = heroNode2.nickname;
                flag = true;
            }
            temp = temp.next;
        }

        if (!flag) {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", heroNode2.no);
        }
    }

    public void del(int no) {
        HeroNode2 temp = head;

        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        } else {
            temp = temp.next;
        }

        boolean flag = false;
        while (temp != null) {
            if (temp.no == no) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                flag = true;
            }
            temp = temp.next;
        }

        if (!flag) {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }
}

// 定义HeroNode2 ， 每个HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; // 指向下一个节点, 默认为null
    public HeroNode2 pre; // 指向前一个节点, 默认为null
    // 构造器

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}