package com.simplyalec;

import java.security.SecureRandom;

/**
 * Created by Alec Dusheck on 5/1/2017.
 */
public class ImgurScan {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom rnd = new SecureRandom();

    public static void main(String[] args) {
        while (true) {
            try {

                String ran = randomString();

                String title = titleGet.getPageTitle("http://imgur.com/a/" + ran);

                if(title != "imgur: the simple 404 page" && realCheck.check("http://imgur.com/a/" + ran)){
                    System.out.println("Found! " + ran);
                }

            }catch (Exception e){
                //Nothing
            }
        }
    }

    public static String randomString() {

        int len = 5;

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();

    }
}

