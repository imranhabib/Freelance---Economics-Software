package test;

import project.parameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imran on 2014-11-22.
 */
public class testClass {

    static parameters params;

   public static void main (String[] args) throws Exception{
       params = new parameters();
       List<Integer> prices = new ArrayList<Integer>();
       prices = params.getSecurityPriceList();
       System.out.println(prices);




   }





}
