package MiscQuestions;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(nextHappy(2));
    }
    static int nextHappy(int N){
        N++;
        while (!isHappy(N)) {
            N++;
        }
        return N;
    }
    static boolean isHappy(int n){
      int slow = n, fast = n;
      do{
          slow = ssd(slow);
          fast = ssd(ssd(fast));

          if(fast == 1) return true;
      } while(slow!=fast);

      return false;
    }
    static int ssd(int n){
        int sum = 0;
        while(n>0){
            int dig = n%10;
            sum+=dig*dig;
            n/=10;
        }
        return sum;
    }
}
