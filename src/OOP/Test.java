package OOP;
class Student{
    String name;
    Student(String name){
        this.name = name;
    }
    public String toString(){

        return this.name;
    }
}
public class Test {

    public static void main(String[] args) {
        final Student s1 = new Student("Harshit");
        s1.name = "meow";//Our s1 stores some sort of memory address.It is valid since our reference variable s1 is final. So we cannot re-assign
        //it to point to some other object..It will throw error;But here we are not re-assigning it to other object..
//        final Integer a = 9;
//        a = 10; // It will throw an error since we are re-assigning it to point to some other object..from 9 to 10;
        System.out.println(s1);
    }
}
