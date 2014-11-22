package project;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Imran on 2014-11-16.
 */
public class allocation {


    private static int security1 = 1;

    private static int security2 = 1;
    private static int security3 = 1;
    private static int security4 = 1;
    private static int security5 = 1;

    private static int securityPrice1 = 1;
    private static int securityPrice2 = 2;
    private static int securityPrice3 = 3;
    private static int securityPrice4 = 4;
    private static int securityPrice5 = 5;


    public static int portfolioAllocation (int m, int choice) {
        int allocation = m;
        int numberOfSecuritiesEach = choice;
        int totalAssets = 0;
        if (!canYouAfford (allocation, numberOfSecuritiesEach)){
            System.out.println("you cant afford this shit");
            return -1;
        }
        List<Integer> numberOfSecurities = new ArrayList<Integer>();
        List<Integer> assets = new ArrayList<Integer>();
        numberOfSecurities.add(security1);
        numberOfSecurities.add(security2);
        numberOfSecurities.add(security3);
        numberOfSecurities.add(security4);
        numberOfSecurities.add(security5);

        List<Integer> prices = new ArrayList<Integer>();
        prices.add(securityPrice1);
        prices.add(securityPrice2);
        prices.add(securityPrice3);
        prices.add(securityPrice4);
        prices.add(securityPrice5);



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
        priceOfSecurities.add(securityPrice1);
        priceOfSecurities.add(securityPrice2);
        priceOfSecurities.add(securityPrice3);
        priceOfSecurities.add(securityPrice4);
        priceOfSecurities.add(securityPrice5);

        for(int i = 0; i < priceOfSecurities.size(); i++){
            sum = sum + (priceOfSecurities.get(i) * choice);

        }
        if(sum > allocation){
            return false;
        }

        return true;

    }


    public static void main(String[] args) throws Exception{
        System.out.println(portfolioAllocation(100, 1));

    }

}
