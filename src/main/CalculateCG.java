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
public class CalculateCG {
    double grade, credit;
    
    void add(double grd, double crd){
        if(grd > 0){
            credit += crd;
            grade += grd*crd;
        }
    }
    void reset(){
        credit = 0;
        grade = 0;
    }
    double getResult(){
        double result;
        result = grade/credit;
        
        return result;
    }
    double getCredit(){
        return credit;
    }
}
