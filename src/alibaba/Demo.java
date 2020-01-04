package alibaba;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
//        asListDemo();
//        listIteratorDemo();


        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        try {
            for (String s : list) {
                System.out.println(s);
                if (s.equals("2")) {
                    list.remove(s);
                }
            }
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
//                if ("2".equals(list.get(i))) {
//                    list.remove(list.get(i));
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(list);
    }

    private static void listIteratorDemo() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");

        System.out.println(list);
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
            if (s.equals("bbb")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    private static void asListDemo() {
        List<String> list = new ArrayList<>();

        list.add("aaaa");
        list.add("aaaa");
        list.add("aaaa");
        list.add("aaaa");
        list.add("aaaa");

        Object[] objects = list.toArray();
        System.out.println(objects[0]);
        System.out.println(objects[1]);
        System.out.println(objects[2]);
        System.out.println(objects.length);

        String[] strings = new String[list.size()];

        String[] strings1 = list.toArray(strings);

        System.out.println(strings[0]);
        System.out.println(strings[1]);
        System.out.println(strings[2]);

        System.out.println(strings1[0]);
        System.out.println(strings1[1]);
        System.out.println(strings1[2]);
    }
}
