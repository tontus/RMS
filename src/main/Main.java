/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author mainu
 */
public class Main {
    static CalculateCG mainul = new CalculateCG();
    public static void main(String[] args) {
        new Home();
        mainul.add(3.5, 3);
        mainul.add(4, 5);
        mainul.add(0, 4);           
        System.out.println("CGPA  " + mainul.calculate());
    }
}
