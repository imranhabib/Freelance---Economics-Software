package project;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Imran on 2014-11-22.
 */

//this class will access the systemDefined variables at the highest level
// Uses a resourceBundle and a properties file

public class parameters {

    ResourceBundle bundle;

  public parameters(){
      bundle = ResourceBundle.getBundle("resources/systemdata");

  }

    public int getAllocation (){
        return Integer.parseInt(bundle.getString("incomeRequired"));

    }

    public int getNumberOfSecurities(){
        return Integer.parseInt(bundle.getString("securityAmount"));


    }

    public List<Integer> getSecurityPriceList(){
        String price = bundle.getString("securityPriceList");
        String[] priceList = price.split(",");
        List<Integer> prices = new ArrayList<Integer>();
        for(String str: priceList){
            prices.add(Integer.parseInt(str));
        }

        return prices;

    }


    public int getMeanPriceAmount(){
        String price = bundle.getString("securityPriceList");
        String[] priceList = price.split(",");
        List<Integer> prices = new ArrayList<Integer>();
        for(String str: priceList){
            prices.add(Integer.parseInt(str));
        }
        int sum = 0;
        int amount = prices.size();
        for(int num: prices){
            sum = sum + num;
        }
        return sum/amount;


    }



}
