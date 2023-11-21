package RecursionPrac;

class Print {
    public static void main(String[] args) {
//        print(5);
//        print1(5);
//        System.out.println(fact(5));
//        System.out.println(sum(0));
//        System.out.println(countZeros(202120330,0));
        System.out.println(fibo(7));
    }

    static int fibo(int n){
        if(n<=1){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }

    static void print(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        print(n-1);
        System.out.println(n);
    }
    static int fact(int i){
        if(i<2){
            return 1;
        }
        return i*fact(i-1);
    }
    static int sum(int n){
        if(n<=9){
            return n;
        }
        return (n%10)+sum(n/10);
    }
    static int helper(int n,int digits){
        if(n%10==n){
            return n;
        }
        int rem = n %10;
        return rem*(int)Math.pow(10,digits-1) + helper(n/10,digits-1);
    }
    static int reverse(int n){
        int digits = (int)Math.log10(n)+1;
        return helper(n,digits);
    }
    static int reverse1(int n){
        return helper1(n,0);
    }
    static int helper1(int n,int sum){
        if(n<=9){
            return (sum*10)+n;
        }
        return helper1(n/10,(sum*10)+(n%10));
    }

//     static void print(int i) {
//        if(i==0){
//
//            return;
//        }
//        System.out.println(i);
//        print(i-1);
//    }
//    static void print1(int n){
//        if(n==0){
//            return;
//        }
//        print1(n-1);
//        System.out.println(n);
//    }
//    static int factorial(int n){
//        if(n==1 || n==0){
//            return 1;
//        }
//        return n*factorial(n-1);
//    }
//    static int sumOfDig(int n){
//        if(n<=9){
//            return n;
//        }
//        return (n%10)+(sumOfDig(n/10));
//    }
//    static int countZeros(int n,int count){
//        if(n<=9){
//            return n==0 ? ++count : count;
//        }
//        return n%10==0 ? countZeros(n/10,++count) : countZeros(n/10,count);
//    }
}
