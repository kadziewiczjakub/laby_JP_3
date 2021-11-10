package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

public class DB {
    private static HashMap<String,String> hashMap=new HashMap<String,String>();
    public static boolean checkCredentials(String uid,String password){
        if(!hashMap.containsKey(uid))return false;
        if(!hashMap.get(uid).equals(password)) return false;
        return true;
    }

    public static void loadFromFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader("data.csv"))){
            String line = reader.readLine();
            while(line!=null){
                String[] data=line.split(",");
                if(!hashMap.containsKey(data[0]))hashMap.put(data[0],data[1]);
                line=reader.readLine();
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
