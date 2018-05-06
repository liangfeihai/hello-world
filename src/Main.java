import javaio.Calculator;

public class Main {

    public static void main(String[] args) {

        Calculator calculator=new Calculator();
        System.out.println("Hello World!  "+ System.getProperty("java.class.path"));
        Calculator.cal("1+2");
        System.out.println("Hello World!  "+ System.getProperty("java.class.path"));

    }
}
