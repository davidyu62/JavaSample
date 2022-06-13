package org.example.util;


import com.google.gson.Gson;
import com.sun.deploy.security.ruleset.Rule;
import org.example.dto.JsonDto;

import java.io.*;
import java.util.List;

public class FileUtil {

    public void readJsonFile(){
//        People people = gson.fromJson(jsonStr, People.class);
        String fileTxt = ".\\test.json";
        File file = new File(fileTxt);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";
            String jsonStr = "";
            while((line = br.readLine()) != null){
                jsonStr += line;
            }
            System.out.println(jsonStr);
            Gson gson = new Gson();
            JsonDto jsonDto = gson.fromJson(jsonStr, JsonDto.class)  ;
            System.out.println(jsonDto.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
