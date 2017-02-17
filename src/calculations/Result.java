/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculations;

/**
 *
 * @author mainu
 */
public class Result {
    public Result(){
        
    }
    public double getGP(int totalClass,int totTT1, int totTT2, int totSemFinal, int atdClass, int tt1, int tt2, int semFinal){
        int totalMarks = (tt1)+(tt1) + (semFinal) + getAttendenceMark(atdClass/totalClass * 100);
        
        if(totalMarks >= 80)
            return 4.0;
        if(totalMarks >= 75)
            return 3.75;
        if(totalMarks >= 70)
            return 3.5;
        if(totalMarks >= 65)
            return 3.25;
        if(totalMarks >= 60)
            return 3.0;
        if(totalMarks >= 55)
            return 2.75;
        if(totalMarks >= 50)
            return 2.5;
        if(totalMarks >= 45)
            return 2.25;
        if(totalMarks >= 40)
            return 2.0;
        return 0.0;
    }
    
    
    int getAttendenceMark(int atdPercent){
        
        if(atdPercent>=95)return 10;
        if(atdPercent>=90)return 9;
        if(atdPercent>=85)return 8;
        if(atdPercent>=80)return 7;
        if(atdPercent>=75)return 6;
        if(atdPercent>=70)return 5;
        if(atdPercent>=65)return 4;
        if(atdPercent>=60)return 3;
        return 0;
    }
}
