/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package merkeltree;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author gonca
 */
public class MerkelTree {
    public ArrayList<String> elements;
    public ArrayList<ArrayList<String>> tree;
    /**
     * Constructor
     */
    public MerkelTree(){
        elements = new ArrayList<>();
        tree=new ArrayList<>();
        tree.add(new ArrayList<>());
    }
   /**
    * Replace an element in a specific index
    *
    * @param index  the index of the element
    * @param car    the new caracter
    */ 
    public void replace(int index,String car){
        elements.set(index, car);
        String x= hash(car);
        tree.get(0).set(index, x);
        for (int i = 0; i < tree.size(); i++){
            reorganiza();
        }
    }
    
    /**
    * Remove an element in a specific index
    *
    * @param index  the index of the element
    */ 
    public void remove(int index){
        elements.remove(index);
        tree.get(0).remove(index);
        for (int i = 0; i < tree.size(); i++){
            reorganiza();
        }
    }
    
    /**
    * Add an element to tree
    *
    * @param e   the caracter to add
    */ 
    public void add(String e){
        elements.add(e);
        e = hash(e);
        //adiciona um numero novo
        tree.get(0).add(e);
        
        for (int i = 0; i < tree.size(); i++){
            reorganiza();
        }
    }
    
    /**
    * Re-order the tree
    */ 
    public void reorganiza(){
        ArrayList<ArrayList<String>> tree3= new ArrayList<>();
        tree3.add(tree.get(0));
            for(ArrayList a:tree)
                if(a.size()>=2){
                    tree3.add(new ArrayList<>());
                    for (int i=0; i<a.size();i=i+2){
                        int size=0;
                        try{
                            if(tree3.size()-2<0)
                            {
                                size=0;
                            }else{
                                size=tree3.size();
                            }
                            
                            tree3.get(size-1).add(hash(tree.get(size-2).get(i)+tree.get(size-2).get(i+1)));
                        }catch(java.lang.IndexOutOfBoundsException ex){
                            tree3.get(size-1).add(hash(tree.get(size-2).get(i)));
                        }
                    }
                }
        this.tree=tree3;
    }
    
    /**
    * Return the hash of a determnate String
    *
    * @param e    the string to hash
    * @return     String hashed
    */ 
    public String hash(String e){
        int hashInt = e.hashCode();
        String hashFinal = Integer.toHexString(hashInt);
        return hashFinal;
    }
    
    /**
    * Return the Tree in Text
    * @return     tree in String
    */ 
    public String show(){
        Collections.reverse(tree);
        String retorno="";
        for(ArrayList a:tree){
            for (Object b:a){
                retorno+=b+" ";
            }
            retorno+="\n";
        }
        for (Object a:elements)
            retorno+=a+"  ";
        Collections.reverse(tree);
        return retorno;
    }
}
