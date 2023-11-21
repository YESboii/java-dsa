package Stack;

//LIFO or FILO
//All operations are O(1)
//except in dynamic array implementation where push in case of overflow condition takes O(n).
public class CustomStack {
    protected int []stack;
    private static final int default_Size = 10;
    private int top=-1;
    public CustomStack(){
        this(default_Size);
    }
    public CustomStack(int size){
        this.stack = new int[size];
    }
    public boolean push(int item){
//        if(full()){
//            System.out.println("The stack is full");
//            return false;
//        }
        if(top==stack.length-1){
            System.out.println("The stack is full");
            return false;
        }
        stack[++top] = item;
        return true;

    }
    public int pop(){
        if(empty()){
            System.out.println("The stack is empty");
            return Integer.MIN_VALUE;
        }
        return stack[top--];
    }
    public int peek(){
        if(!empty()){
            return stack[top];
        }
        else{
            return Integer.MIN_VALUE;
        }
    }
    public boolean full(){
        return top == stack.length-1;
    }
    public boolean empty(){
        return top==-1;
    }

}
