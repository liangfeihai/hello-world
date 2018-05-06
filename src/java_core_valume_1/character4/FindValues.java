package java_core_valume_1.character4;

import java.util.ArrayList;
import java.util.List;

public class FindValues {
    public static void main(String[] args) {
        List<Values> source=new ArrayList<>();
        List<Values> addTemp=new ArrayList<>();
        List<Values> mulTemp=new ArrayList<>();
        List<Values> result=new ArrayList<>();

        for (int i=2;i<100;i++){
            for (int j=i+1;j<100;j++){
                Values vTemp=new Values(i,j);
                source.add(vTemp);
            }
        }

        for (int i=0;i<source.size();i++){
            for (int j=0;j<source.size();j++){
                if (source.get(i).getAdd()==source.get(j).getAdd()){
                    addTemp.add(source.get(i));
                    break;
                }
            }
        }

        for (int i=0;i<source.size();i++){
            for (int j=0;j<source.size();j++){
                if (source.get(i).getMul()==source.get(j).getMul()){
                    mulTemp.add(source.get(i));
                    break;
                }
            }
        }

        for (int i=0;i<mulTemp.size();i++){
            if (addTemp.contains(mulTemp.get(i))){
                result.add(mulTemp.get(i));
                System.out.printf("i:%d,x:%d,y:%d,x+y:%d,x*y:%d \n",i,mulTemp.get(i).getX(),mulTemp.get(i).getY()
                ,mulTemp.get(i).getAdd(),mulTemp.get(i).getMul());
            }
        }

    }
}
