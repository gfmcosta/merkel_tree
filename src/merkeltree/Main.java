/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package merkeltree;

/**
 *
 * @author gonca
 */
public class Main {

    public static void main(String[] args) {
        MerkelTree mt = new MerkelTree();
        mt.add("a");
        mt.add("d");
        mt.add("v");
        mt.add("v");
        mt.add("v");
        
        System.out.print(mt.show());
    }
}
