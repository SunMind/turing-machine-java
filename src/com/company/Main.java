package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        JSONParser parser = new JSONParser();
        try {
            //reads data from JSON file
            Object obj = parser.parse(new FileReader("C:\\Users\\Viliu\\Desktop\\Java\\VGTU\\turing-machine-java\\src\\com\\company\\increment_bin.tmprog.json"));
            JSONObject jsonObject = (JSONObject)obj;
            String initialTapePosition = (String) jsonObject.get("initialTapePosition");

            String tape = (String) jsonObject.get("tape");
            char[] tapeChar = tape.toCharArray();
            System.out.println("State: " + initialTapePosition);
            System.out.println("Tape: " + tape);
            System.out.println("Tape as chars:");

            //prints array in one line
            System.out.println(Arrays.toString(tapeChar).replaceAll(", ", ""));


            char state = '0';
            int position = Integer.parseInt(initialTapePosition)-1;
            System.out.println(position);
            System.out.println(tapeChar.length);
            boolean ans = position<tapeChar.length;
            System.out.println(ans);

            while (position<tapeChar.length) {
                while (state == '0') {
                    if (tapeChar[position] == '0') {
                        tapeChar[position] = '0';
                        position++;
                     //  System.out.println(Arrays.toString(tapeChar).replaceAll(", ", ""));
                    } else if (tapeChar[position] == '1') {
                        tapeChar[position] = '1';
                        position++;
                    } else if (tapeChar[position] == '*') {
                        tapeChar[position] = '*';
                        position--;
                        state = '1';
                    }
                    System.out.println(Arrays.toString(tapeChar).replaceAll(", ", ""));
                }
                while (state == '1') {
                    if (tapeChar[position] == '0') {
                        tapeChar[position] = '1';
                        position++;
                        state = '0';
                    } else if (tapeChar[position] == '1') {
                        tapeChar[position] = '0';
                        position--;
                    }
                    System.out.println(Arrays.toString(tapeChar).replaceAll(", ", ""));
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
