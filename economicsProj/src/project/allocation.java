package project;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Imran on 2014-11-16.
 */
public class allocation {

    static parameters params;
    static incomeRequired income;

    public int allocationForShare(int shareNumber){
        int m = params.getAllocation();
        int mXBar = income.getMbar(params.getMeanPriceAmount(), params.getSecurityList().size());
        if(m < mXBar){
            return allocationMethodOne();
        }
        int nR = params.getArgMaxFormula(params.getReservationRatio(), params.getSecurityList());
        if (shareNumber <= nR){
            return allocationMethodTwo();
        }
        else
            return allocationMethodThree();
    }

    public int allocationMethodOne(){
        int m = params.getAllocation();
        int p = params.getMeanPriceAmount();
        int n = params.getSecurityList().size();
        return m/(n*p);
    }

    public int allocationMethodTwo(){
        int xBar = income.x;
        int m = params.getAllocation();
        int mXBar = income.getMbar(params.getMeanPriceAmount(), params.getSecurityList().size());
        int aR = 1;
        int pR = 1;

        return xBar + ((aR * (m - mXBar))/pR);
    }

    public int allocationMethodThree(){
        int xBar = income.x;
        int m = params.getAllocation();
        int mXBar = income.getMbar(params.getMeanPriceAmount(), params.getSecurityList().size());
        int aI = 1;
        int pI = 1;

        return xBar + ((aI * (m - mXBar))/pI);
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
