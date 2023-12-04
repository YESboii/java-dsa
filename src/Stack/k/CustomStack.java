package Stack.k;

public class CustomStack {
    private int[] data;
    private int top;
    private static final int DEFAULT_SIZE = 8;
    CustomStack(int size){
        this.data = new int[size];
        top = -1;
    }
    CustomStack(){
        this(DEFAULT_SIZE);
    }
    public boolean isEmpty(){
        return top<=-1;
    }
    public boolean isFull(){
        return top>=data.length-1;
    }
    public void push(int value){
        if(isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        data[++top] = value;
    }
    public int pop(){
        if (isEmpty()) throw new RuntimeException("Stack UnderFlow");
        return data[top--];
    }
    public void printStack(){
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        for (int i =top;i>=0;i--){
            System.out.print(data[i]+"|");
        }
        System.out.println();
    }
    public int peek(){
        if (isEmpty()) throw new RuntimeException("Stack UnderFlow");
        return data[top];
    }

}
class test{
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(5);
        System.out.println(customStack.isEmpty());
        customStack.push(5);
        customStack.push(4);
        customStack.push(3);
        customStack.push(2);
        customStack.push(1);
        System.out.println(customStack.isFull());
        customStack.printStack();
//        customStack.push(0
        System.out.println(customStack.pop());
        customStack.printStack();
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        customStack.printStack();
//        customStack.pop();
        customStack.push(1);
//        customStack.peek();
        System.out.println(customStack.peek());
    }

}
