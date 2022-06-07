package org.example.web;

import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WebController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        String uri = req.getRequestURI(); // uri contains get parameter

        String result = null;
        try {
            res.getWriter().write(result);  // return result to response
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        /* get parameter from body */
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream;
        Gson gson = new Gson();
        String body = null;
        try {
            // body 추출
            inputStream = req.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
            body = stringBuilder.toString();
            RequestBody requestBody = gson.fromJson(body, RequestBody.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* response code */
        resp.setStatus(200);        // defualt 200, it sames with no this line.
    }
}
