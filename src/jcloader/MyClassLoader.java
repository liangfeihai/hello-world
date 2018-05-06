package jcloader;

import java.io.*;
import java.util.Arrays;

public class MyClassLoader extends ClassLoader{
    private String byteCode_Path;
    private byte[] key;
    private byte[] enc;

    public MyClassLoader(String byteCode_Path,byte[] key,byte[] enc){
        this.byteCode_Path=byteCode_Path;
        this.key=key;
        this.enc=enc;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        byte value[] = null;
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(byteCode_Path+name + ".class"));
            value = new byte[in.available()];
            in.read(value);
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            if (null != in){
                try{
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        if(Arrays.equals(value,enc)){
            System.out.println("file is ok");
        }
//        value = Use3DES.decrypt(key,value);

        return defineClass(name,value,0,value.length);
    }

    public static void main(String[] args){
        BufferedInputStream in=null;

        try {
            in = new BufferedInputStream(new FileInputStream("E:/test/TestFoobar.class"));
            byte[] src= new byte[in.available()];
            in.read();
            in.close();

            byte[] key = "01234567899876543210abcd".getBytes();
            byte[] enc=Use3DES.encrypt(key,src);
            BufferedOutputStream out= new BufferedOutputStream(new FileOutputStream("E:/test/TestFoobar1.class"));
            out.write(enc);
            out.close();
            MyClassLoader classLoader = new MyClassLoader("E:/test/",key,enc);
            System.out.println(classLoader.loadClass("TestFoobar").getClassLoader().getClass().getName());
            Class classLooad=classLoader.loadClass("TestFoobar").getClassLoader().getClass();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
