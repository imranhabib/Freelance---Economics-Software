package test;

import project.allocation;
import project.incomeRequired;
import project.parameters;
import project.sliderInterface;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Imran on 2014-11-22.
 */
public class testClass {

    static parameters params;
    static incomeRequired income;
    static allocation allocation;
    static sliderInterface slider;
    static int current;


  public testClass(){
     current = getCurrent();

  }



  public testClass(int current){
    this.current = current;

  }




  public void incrementCurrent(){
    current = current++;
  }

  public int getCurrent(){
    return current;
  }





   public static void main (String[] args) throws Exception {
       params = new parameters();

     EventQueue.invokeLater(new Runnable() {
           public void run() {
             int current = 1;
               testClass test = new testClass(current);
               test.incrementCurrent();
               sliderInterface frame = new sliderInterface(params.getSecurityList());
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
           }

       });








   }
   }








