package org.example.datastructure.queue;

import java.util.*;

public class QueueHandler {

    HashMap<String, Queue<String>> queueHashMap;

    public void init(){
        queueHashMap = new HashMap<>();
    }

    public void start(){
        init();
        createQueue("firstQueue","1");
        createQueue("secondQueue","2");
        print();
    }

    public void print(){
        for(Map.Entry<String,Queue<String>> entrySet : queueHashMap.entrySet()){
            System.out.println("queName:"+entrySet.getKey()+"\t"+"Queue:"+entrySet.getValue().toString());
        }
    }

    public void createQueue(String queueName, String queueValue){
        Queue<String> queue = new LinkedList<>();
        queue.add(queueValue);
        queueHashMap.put(queueName,queue);
    }
}
