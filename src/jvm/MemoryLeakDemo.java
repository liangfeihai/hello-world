package jvm;

import java.util.HashMap;
import java.util.Map;

public class MemoryLeakDemo {
    static class Key {
        Integer id;

        Key(Integer id){
            this.id=id;
        }

        @Override
        public int hashCode(){
            return id.hashCode();
        }
    }

    public static void main(String[] args){
        Map m=new HashMap();
        Runtime runtime=Runtime.getRuntime();
        int freeMemory=(int)(runtime.freeMemory()/1024/1024);
        int totalMemory=(int)(runtime.totalMemory()/1024/1024);
        System.out.println("freeMemory:"+freeMemory+ "M,totalMemory:"+totalMemory+"M");
        int i=0;
        try {
            while (true){
                m.put(new Key(i++),"Number:"+i);
            }
        }
        catch (Exception e){
            freeMemory=(int)(runtime.freeMemory()/1024/1024);
            totalMemory=(int)(runtime.totalMemory()/1024/1024);
            System.out.println(" catch---freeMemory:"+freeMemory+ "M,totalMemory:"+totalMemory+"M");
            e.printStackTrace();
        }finally {
            freeMemory=(int)(runtime.freeMemory()/1024/1024);
            totalMemory=(int)(runtime.totalMemory()/1024/1024);
            System.out.println("finaly catch---freeMemory:"+freeMemory+ "M,totalMemory:"+totalMemory+"M");
        }


    }
}
