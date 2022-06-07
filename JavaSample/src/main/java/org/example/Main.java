package org.example;

import org.example.datastructure.queue.QueueHandler;
import org.example.gson.GsonHandler;
import org.example.math.RandomHandler;
import org.example.thread.ThreadHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {


    public void init(){
    }

    public void start(){
    }

    public void mathRandom(){
        RandomHandler randomHandler = new RandomHandler();
        randomHandler.start();
    }

    public void gson(){
        GsonHandler gsonHandler = new GsonHandler();
        gsonHandler.createJson();
    }

    public void queue(){
        QueueHandler queueHandler = new QueueHandler();
        queueHandler.start();
    }

    public void thread(){
        ThreadHandler threadHandler = new ThreadHandler();
//        threadHandler.start();
        threadHandler.executorServiceStart();
    }

    public static void main(String[] args) {
        new Main().thread();
    }
}