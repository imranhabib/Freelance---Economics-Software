package test;

import project.incomeRequired;
import project.parameters;
import project.allocation;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by Imran on 2014-11-22.
 */
public class testClass {

    static parameters params;
    static incomeRequired income;
    static allocation allocation;

   public static void main (String[] args) throws Exception{
       params = new parameters();
       int price = params.getMeanPriceAmount();
       int amount = params.getNumberOfSecurities();
       income = new incomeRequired(2);
       int mbar = income.getMbar(price,amount);
       System.out.println(mbar);
       int argMax = params.getArgMaxFormula(params.getReservationRatio(), params.getSecurityList());
       System.out.println(argMax);
       float hi = params.getAR();
       System.out.println(hi);
       System.out.println(params.getPR());
       allocation = new allocation(params, income);
       System.out.println(allocation.allocationForShare(3));
   }





}
