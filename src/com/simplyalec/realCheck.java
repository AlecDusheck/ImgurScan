package com.simplyalec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Alec Dusheck on 5/2/2017.
 */
public class realCheck {
    public static Boolean check(String url) throws IOException{
        URL yahoo = new URL(url);
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);
        in.close();

        if(a.toString().contains("contentURL")){
            return true;
        }else{
            return false;
        }
    }
}
