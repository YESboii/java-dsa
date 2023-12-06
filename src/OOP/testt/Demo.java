package OOP.testt;

import java.util.List;

public class Demo {
//    public void test(List<? extends Number> list) {
//        for (Number n : list) {
//            System.out.println(n);
//        }
//    }

    public void test(List<? super Integer> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}

