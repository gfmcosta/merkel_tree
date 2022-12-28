/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package merkeltree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author gonca
 */
public class ObjectIO {
    public static void writeObject(Serializable obj,String fileName) throws FileNotFoundException{
        try{
            FileOutputStream fs= new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fs);
            out.writeObject(obj);
            out.close();
            fs.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    public static Object readObject(String fileName){
        try{
            FileInputStream fs = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fs);
            Object obj = in.readObject();
            in.close();
            return obj;
            
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
