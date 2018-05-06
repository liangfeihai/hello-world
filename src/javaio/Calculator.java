package javaio;

public class Calculator {
    public static String cal (String expression){
         char[] source;
         char spitFlag = 0;
         String result;

         source=expression.toCharArray();
         for (char tmp: source) {
             if (tmp=='+' || tmp=='-' || tmp=='*' || tmp=='/'){
                 spitFlag=tmp;
                 break;
             }
         }
         if (spitFlag == 0){
             result = "无法解析，souce:"+source;
             System.out.println(result);
             return  result;
         }
         String[] values=new String[20];
         values=expression.split("\\"+spitFlag);

         switch (spitFlag){
             case '+':
                 result=(Integer.parseInt(values[0])+Integer.parseInt(values[1]))+"";
                 break;
             case '-':
                 result=(Integer.parseInt(values[0])-Integer.parseInt(values[1]))+"";
                 break;
             case '*':
                 result=(Integer.parseInt(values[0])*Integer.parseInt(values[1]))+"";
                 break;
             case '/':
                 result=(Integer.parseInt(values[0])/Integer.parseInt(values[1]))+"";
                 break;
             default:
                 result="0";
         }
         return result;
    }

    public static void main(String[] args) {
        System.out.println(cal("1+2"));
    }
}
