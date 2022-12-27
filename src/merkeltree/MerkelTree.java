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
    
    ArrayList<String> elements;
    ArrayList<ArrayList<String>> tree;
    int cont = 0;
   
    public MerkelTree(){
        elements = new ArrayList<>();
        tree=new ArrayList<>();
        tree.add(new ArrayList<>());
    }
    
    void replace(int index,String car){
        elements.set(index, car);
        String x= hash(car);
        tree.get(0).set(index, x);
        for (int i = 0; i < tree.size(); i++){
            reorganiza();
        }
    }
    
    void remove(int index){
        elements.remove(index);
        tree.get(0).remove(index);
        for (int i = 0; i < tree.size(); i++){
            reorganiza();
        }
    }
    void add(String e){
        ArrayList<ArrayList<String>> tree2= new ArrayList<>();
        elements.add(e);
        e = hash(e);
        //adiciona um numero novo
        tree.get(0).add(e);
        
        tree2.add(tree.get(0));
            for(ArrayList a:tree)
                if(a.size()>=2){
                    tree2.add(new ArrayList<>());
                    for (int i=0; i<a.size();i=i+2){
                        int size=0;
                        try{
                            if(tree2.size()-2<0)
                            {
                                size=0;
                            }else{
                                size=tree2.size();
                            }
                            
                            tree2.get(size-1).add(hash(tree.get(size-2).get(i)+tree.get(size-2).get(i+1)));
                        }catch(java.lang.IndexOutOfBoundsException ex){
                            tree2.get(size-1).add(hash(tree.get(size-2).get(i)));
                        }
                    }
                }
        
        this.tree=tree2;
        //rever com o prof
        for (int i = 0; i < tree.size(); i++){
            reorganiza();
        }
    }
    
    void reorganiza(){
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
    String hash(String e){
        int hashInt = e.hashCode();
        String hashFinal = Integer.toHexString(hashInt);
        return hashFinal;
    }
    void show(){
        Collections.reverse(tree);
        int cont=tree.size()+1;
        for(ArrayList a:tree){
            cont-=1;
            for (Object b:a){
                for (int i = 0; i <cont; i++) {
                    System.out.print("\t");
                }
                System.out.print(b);
            }   
            System.out.println("");
        }
            
        //System.out.println(elements);
        Collections.reverse(tree);
    }
}
