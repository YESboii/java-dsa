package OOP.Generics;

import javax.print.attribute.standard.NumberUp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demoo {
    public  void test(List<? super Number>list){
        Number number = new Double(12.0);
        list.add(number);
        //We can add Number or subclasses of number since we know the lower bound that the provided list will be the type of Number in the worst case
        //because the object provided at runtime?

    }
//    public  void test(List<? extends Number>list){
//        list.add(14.5);
//        //we cannot add in the list since we dont know what instance will we receive at run time? it could be an Integer, or BigInteger
//
//    }

    public static void main(String[] args) {

    }
}

