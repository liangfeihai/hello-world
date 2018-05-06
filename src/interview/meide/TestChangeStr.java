package interview.meide;

public class TestChangeStr {
    public static void changeStr(String str){
        str="Welcome to midea";
    }

    public static void main(String[] args) {
        String str="Welcome";
        changeStr(str);
        System.out.println(str);
    }
}
