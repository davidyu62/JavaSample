package org.example.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListHandler {
    public void start(){
        listAcend();
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
}
