package org.example.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListHandler {
    public void start(){
//        listAcend();
        doubleList();
    }

    public void listAcend(){
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(2);
        list.add(10);
        list.add(3);
        Collections.sort(list);
        System.out.println(list);

        // To sort decent, first make them acend and then reverse.
        Collections.reverse(list);
        System.out.println(list);

    }

    public void doubleList(){
        Integer[][] intArr = new Integer[][] {{3,4,2,5},{6,3,1,7},{8,5,4,3},{1,9,0,4}};
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<intArr.length; i++){
            List tmpList = Arrays.asList(intArr[i]);
            list.add(tmpList);
            System.out.println(tmpList);
        }

        Integer[][] compArr = new Integer[][] {{3,4,2,5},{6,2,1,7},{8,5,4,1},{1,9,0,4}};
        List<List<Integer>> compList = new ArrayList<>();
        for(int i=0; i<compArr.length; i++){
            List tmpList = Arrays.asList(compArr[i]);
            compList.add(tmpList);
            System.out.println(tmpList);
        }

        List<List<Integer>> resultList = new ArrayList<>();
        System.out.println("Result");
        // list 두개비교
        for(int i=0; i<list.size(); i++){
            if(list.get(i).containsAll(compList.get(i))){
                resultList.add(list.get(i));
                System.out.println(list.get(i));
            }
        }

    }
}
