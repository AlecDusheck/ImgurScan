package com.simplyalec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Random;

public class ImgurScan {

    static private final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static private Random rnd = new Random();
    static public final JTextArea textArea = new JTextArea(10, 20);
    static public JFrame window = new JFrame("ImgurScan");
    static public JButton startBtn = new JButton("Start ImgurScan");
    static public JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    public static void main(String[] args) {

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    window.add(startBtn);
    window.setSize(500, 500);
    window.setVisible(true);
    startBtn.addActionListener(new Action());
    }
    static class Action implements ActionListener{
        public void actionPerformed(ActionEvent e){

            window.add(scroll);
            window.remove(startBtn);
            window.revalidate();
            window.repaint();
            textArea.setText("----Imgur Scan----");
            textArea.setEditable(false);

            Thread t1 = new Thread(new Runnable() {
                public void run()
                {
                    addToDisplay();
                }});
            t1.start();

        }
    }

    public static void addToDisplay(){
        String addedText = getRnd();
        if(addedText != null){
            textArea.setText(textArea.getText() + System.lineSeparator() + addedText);
        }
        addToDisplay();
    }

    public static String getRnd() {
            try {
                String ran = randomString();
                String title = titleGet.getPageTitle("http://imgur.com/a/" + ran);
                if (title != "imgur: the simple 404 page" && realCheck.check("http://imgur.com/a/" + ran)) {
                    System.out.println("Found! http://imgur.com/a/" + ran);
                    return "http://imgur.com/a/" + ran;
                }
                else {
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
    }

    private static String randomString() {
        StringBuilder sb = new StringBuilder(5);
        for (int i = 0; i < 5; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}

