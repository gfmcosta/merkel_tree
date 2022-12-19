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
        mt.add("b");
        mt.add("c");
        mt.add("d");
        mt.add("e");
        mt.add("f");
        mt.add("g");
        mt.add("h");
        mt.add("i");
        mt.replace(2, "p");
        mt.show();
    }

}
