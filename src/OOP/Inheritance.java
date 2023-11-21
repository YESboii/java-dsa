package OOP;
//class Parent{
//    int height;
//    int weight;
//
//    Parent(int height,int weight){
//        this.height = height;
//        this.weight = weight;
//    }
//    Parent(Parent other){
//        this.height = other.height;
//        this.weight = other.weight;
//    }
//    void displayProperty(){
//        System.out.println(height+"ft."+" "+weight+"Kgs");
//    }
//}
//class Child extends Parent{
//    String nose;
//    Child(int height,int weight,String nose){
//        super(height,weight);
//        this.nose = nose;
//    }
//    //Copy Constructor
//    Child(Child other){
//        super(other);
//        this.nose = other.nose;
//    }
//}
//public class Inheritance {
//    public static void main(String[] args) {
//        Parent papa = new Parent(6,75);
//        papa.displayProperty();
//        Child child = new Child(6,70,"Like mom");
//        Child child1 = new Child(child);
//        System.out.println(child1.nose);
//        Parent papa1 = new Child(6,754,"ok");//This works bcuz child class is just the extended version of the Parent class.
//        papa1.displayProperty();
//        //What doesn't work is Child reference with Parent Object?
//        //Because the child class has extra members,so we cannot access those with our parent object.
////        Child child2 = new Parent(); Will throw Error
//    }
//}
class Box{
    static int a = 10;
    int l,w,h;
    Box(){
        this.l = 1;
        this.w = 1;
        this.h = 1;
    }
    Box(int l,int w,int h){
        this.l = l;
        this.w = w;
        this.h = h;
    }
    Box(Box other){
        this.l = other.l;
        this.w = other.w;
        this.h = other.h;
    }
    void display(){
        System.out.print(l+" "+w+" "+h);
    }
}
class ColouredBox extends Box{
//    static int a =15;
    String colour;
    ColouredBox(){
        super();
        this.colour = "white";
    }
    ColouredBox(int l,int w,int h,String colour){
        super(l,w,h);
        this.colour = colour;
    }
    ColouredBox(int l,int w,int h){
        super(l,w,h);

    }
    ColouredBox(ColouredBox other){
        super(other);
        this.colour = other.colour;
    }
    @Override
    void display(){
        super.display();
        System.out.println(" "+colour);
    }
}
class WeightBox extends ColouredBox{
    //    static int a =15;
    int weight;
    WeightBox(){
        super();
        this.weight = 1;
    }
    WeightBox(int l,int w,int h,String colour,int weight){
        super(l,w,h,colour);
        this.weight = weight;
    }

    WeightBox(WeightBox other){
        super(other);
        this.weight = other.weight;
    }
    @Override
    void display(){
        super.display();
        System.out.println(" "+weight);
    }
}
public class Inheritance {
    public static void main(String[] args) {
//        ColouredBox box1 = new ColouredBox(5,5,5,"grey");
//        Box box2 = new ColouredBox(5,6,7);
//        box2.display();//always the overridden method will be called
        ColouredBox wb = new WeightBox(10,10,12,"green",15);
        wb.display();
    }
}