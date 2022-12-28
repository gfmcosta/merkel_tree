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
        mt.add("A");
        mt.add("B");
        mt.add("C");
        mt.add("D");
        mt.add("E");
        mt.add("F");
        mt.add("G");
        mt.replace(1, "P");
        mt.remove(3);
        System.out.print(mt.show());
    }
}
