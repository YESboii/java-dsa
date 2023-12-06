import java.util.*;
import java.util.Queue;

class Base{
  public void print(){
    System.out.println("base");
  }
}
class Derived extends Base{
  @Override
  public void print() {
    System.out.println("Derived");
  }
}
class test12{
  public static void doSom(test12 t){
    t.xy();
  }
  public static void main(String[] args) {

  }
  public void xy(){

  }

}
  
