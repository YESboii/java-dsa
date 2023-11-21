package Stack;

public class DynamicStack extends CustomStack {
    public DynamicStack(){
        super();
    }
    public DynamicStack(int size){
        super(size);
    }
    //only problem we face is in push since we have the overflow so just override the push

    public boolean push(int item){
        if(this.full()){
            int []temp = new int[this.stack.length*2];
            for(int i=0;i<this.stack.length;i++){
                temp[i] = this.stack[i];
            }
            this.stack = temp;
        }
        return super.push(item);
    }
}
