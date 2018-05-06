package fact;

public class Recursive {
    public long Fact(int n){
        if(n==1)
            return 1;
        else if (n==0)
            return 1;
        else return n*Fact(n-1);
    }


    public static void main(String[] args){
        Recursive fact=new Recursive();
        long result = fact.Fact(20);
        System.out.print(result);
    }
}
