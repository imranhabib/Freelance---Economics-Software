package project;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Imran on 2014-11-16.
 */
public class allocation {

    parameters params;

    public allocation() {
        params = new parameters();

    }

    public static int getPortfolioAllocation (int m, int choice) {
        int allocation = m;
        int numberOfSecuritiesEach = choice;
        int totalAssets = 0;
        if (!canYouAfford (allocation, numberOfSecuritiesEach)){
            System.out.println("you cant afford this shit");
            return -1;
        }
        List<Integer> numberOfSecurities = new ArrayList<Integer>();
        List<Integer> assets = new ArrayList<Integer>();

        List<Integer> prices = new ArrayList<Integer>();




        for (int i = 0; i < numberOfSecurities.size(); i++) {
            assets.add(numberOfSecurities.get(i) * choice);
            allocation = allocation - (numberOfSecurities.get(i) * prices.get(i));
            System.out.println("this is the allocation = " + allocation);
            System.out.println("this is the current price = " + i);
            totalAssets = totalAssets + numberOfSecurities.get(i);
            System.out.println("this is the assets = " + totalAssets);

        }

        return allocation;

    }


    public static boolean canYouAfford(int m, int choice){
        int allocation = m;
        int sum = 0;
        List<Integer> priceOfSecurities = new ArrayList<Integer>();


        for(int i = 0; i < priceOfSecurities.size(); i++){
            sum = sum + (priceOfSecurities.get(i) * choice);

        }
        if(sum > allocation){
            return false;
        }

        return true;

    }



}
