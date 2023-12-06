package OOP.Generics;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//The static fields of a class cannot be of the generic type
//Generics -> ensures type safety
// ->Enables reusability of  code.So we dont need to write code for every data-type
//we cannot simply instantiate the generic type
public class Test<T extends Number>{//bounded type param,Only Number and subclasses of Integer can be used
//    private static T age = 10; Not OK
    void add(T n1,T n2){
        System.out.println(n1+" "+n2);
    }




//    void hello(List<String> list){ //Not Ok,since they both have the same  Object Type after type erasure, because in case of generics,the generic type will
//                                     be re
                                    //-placed by the closest bounded type else the object if unbounded.COMPILE TIME ERROR
//
//    }
//    void hello(List<Integer> list){
//
//    }

    public static void main(String[] args) {
//        Num<Integer> n1 = new Num<>(5);
//        Num<Double> n2 = new Num<>(6.0);
//            Animal animal = new Animal();
//            LivingThing livingThing = new LivingThing();
//            Demot<LivingThing> livingThingDemot = new Demot<LivingThing>();
//            Demot<Animal> animalDemot = new Demot<>();
//            livingThingDemot = animalDemot;

    }
}
/*
public void someMethod(Number n) { ... }
         someMethod(new Integer(10));   // OK since both of them extends the Number class
        someMethod(new Double(10.1));   // OK

public void boxTest(Box<Number> n)
What type of argument does it accept? By looking at its signature, you can see that it accepts a single argument whose type is Box<Number>.
 But what does that mean? Are you allowed to pass in Box<Integer> or Box<Double>, as you might expect?
The answer is "no", because Box<Integer> and Box<Double> are not subtypes of Box<Number> but Object.
*/
class Digit{
//    static public int addTwo(Num<? extends Number> num ){
//        System.out.println(num.toString());
//        return 1;
//    }
}

class Num<T>{
//    private final T value;
//    Num(T n){
//        this.value = n;
//    }
//    public T getValue(){
//        return value;
//    }
//    @Override
//    public String toString(){
//        return value.toString();
//    }
}
class LivingThing{
}
class Animal extends LivingThing{}
class Demot<T extends LivingThing>{
    List<Integer> list = new ArrayList<>();
}
