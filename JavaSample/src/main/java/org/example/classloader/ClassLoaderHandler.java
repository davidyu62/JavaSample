package org.example.classloader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.util.ArrayList;
import java.util.List;

public class ClassLoaderHandler {
    public void start(){
        loadClass();
    }

    public void loadClass(){
        URL myurl[] = new URL[1];
        try {
            myurl[0] = new URL("file:///C:\\workspace\\JavaSample\\JavaSample\\classes\\");
            URLClassLoader x = new URLClassLoader(myurl);
            Class c = x.loadClass("TestMain");

            Object ob = c.newInstance();
            Class arg2[] = {};
            Method m2 = c.getMethod("printValue", String.class);
            m2.invoke(ob, "Hi");

            Object ob2 = c.newInstance();
            Class arg3[] = {};
            Method m3 = c.getMethod("getList");
            List<Integer> list = (List<Integer>) m3.invoke(ob2);
            System.out.println(list.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }

}

/*
*
* */
