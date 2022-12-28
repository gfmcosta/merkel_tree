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
    /**
    * Write in a file an object content
    *
    * @param obj    the object to write
    * @param fileName the fileName where will be writed the objectd
    * @throws FileNotFoundException
    */ 
    public static void writeObject(Serializable obj,String fileName) throws FileNotFoundException{
        try{
            FileOutputStream fs= new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fs);
            out.writeObject(obj);
            out.close();
            fs.close();
        }catch(IOException e){
        }
    }
    
    /**
    * Read from a file an object content
    *
    * @param fileName the fileName who will be read
    * @return obj Return the object content
    */
    public static Object readObject(String fileName){
        try{
            FileInputStream fs = new FileInputStream(fileName);
            Object obj;
            try (ObjectInputStream in = new ObjectInputStream(fs)) {
                obj = in.readObject();
            }
            return obj;
        }catch(IOException | ClassNotFoundException ex){
            return null;
        }
    }
}
