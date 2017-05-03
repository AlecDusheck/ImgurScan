package com.simplyalec;

import java.util.Random;

public class ImgurScan {

    static private final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static private Random rnd = new Random();

    public static void main(String[] args) {
        while (true) {
            try {
                String ran = randomString();
                String title = titleGet.getPageTitle("http://imgur.com/a/" + ran);
                if(title != "imgur: the simple 404 page" && realCheck.check("http://imgur.com/a/" + ran))
                    System.out.println("Found! http://imgur.com/a/" + ran);
            }catch (Exception e){
                System.out.println("An error occured. " + e.toString());
                break;
            }
        }
    }

    private static String randomString() {
        StringBuilder sb = new StringBuilder(5);
        for (int i = 0; i < 5; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}

