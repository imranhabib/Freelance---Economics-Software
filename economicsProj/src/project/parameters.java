package project;

import test.testClass;

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
    testClass testClass;

    public parameters(){
        bundle = ResourceBundle.getBundle("resources/systemdata");
    }

    public int getAllocation (){
        testClass test = new testClass();
        return Integer.parseInt(bundle.getString("incomeHave" + test.getCurrent()));
    }

    public int getNumberOfSecurities(){
        testClass test = new testClass();
        return Integer.parseInt(bundle.getString("securityAmount" + test.getCurrent()));
    }

    public ArrayList<Integer> getSecurityPriceList(){
        testClass test = new testClass();
        String price = bundle.getString("securityPriceList" + test.getCurrent());
        String[] priceList = price.split(",");
        ArrayList<Integer> prices = new ArrayList<Integer>();
        for(String str: priceList){
            prices.add(Integer.parseInt(str));
        }
        return prices;
    }




    public ArrayList<Integer> getSecurityPriceListStage2(){
        testClass test = new testClass();
        String price = bundle.getString("priceSet" + test.getCurrent());
        String[] priceList = price.split(",");
        ArrayList<Integer> prices = new ArrayList<Integer>();
        for(String str: priceList){
            prices.add(Integer.parseInt(str));
        }
        return prices;
    }


    public ArrayList<Integer> getSecurityPriceListFromStart(){
        testClass test = new testClass();
        String price = bundle.getString("securityPriceList" + 1);
        String[] priceList = price.split(",");
        ArrayList<Integer> prices = new ArrayList<Integer>();
        for(String str: priceList){
            prices.add(Integer.parseInt(str));
        }
        return prices;
    }




    public List<Share> getSecurityList(){
        testClass test = new testClass();
        ArrayList<Share> shares = new ArrayList<Share>();
        System.out.println("this is current = " + test.getCurrent());
        String security = bundle.getString("securityList" + test.getCurrent());
        String[] securityNumber = security.split(",");
        ArrayList<Integer> securityPrices = getSecurityPriceList();
        //get income share
        //   ArrayList<Float> incomeShareList = getIncomeShareList();
        for (int i=1; i < securityNumber.length+1; i++) {
            //    float is = incomeShareList.get(i-1);
            int sp = securityPrices.get(i-1);
            Share share = new Share(sp, i);
            shares.add(share);
        }
        return shares;

    }



    public List<Share> getSecurityListFromStart(){
        testClass test = new testClass();
        ArrayList<Share> shares = new ArrayList<Share>();

        String security = bundle.getString("securityList" + 1);
        String[] securityNumber = security.split(",");
        ArrayList<Integer> securityPrices = getSecurityPriceListFromStart();
        //get income share
        //   ArrayList<Float> incomeShareList = getIncomeShareList();
        for (int i=1; i < securityNumber.length+1; i++) {
            //    float is = incomeShareList.get(i-1);
            int sp = securityPrices.get(i-1);
            Share share = new Share(sp, i);
            shares.add(share);
        }
        return shares;

    }



    public List<Share> getSecurityListWithEmptyIncomeShares(){
        testClass test = new testClass();
        ArrayList<Share> shares = new ArrayList<Share>();
        String security = bundle.getString("securityList" + test.getCurrent());
        String[] securityNumber = security.split(",");
        ArrayList<Integer> securityPrices = getSecurityPriceList();
        //get income share
        //  ArrayList<Float> incomeShareList = getIncomeShareList();
        for (int i=1; i < securityNumber.length+1; i++) {
            Double is = 0.0;
            int sp = securityPrices.get(i-1);
            Share share = new Share(sp, is, i);
            shares.add(share);
        }
        return shares;

    }


    public List<Share> getSecurityListWithEmptyIncomeSharesStage2Prices(){
        testClass test = new testClass();
        ArrayList<Share> shares = new ArrayList<Share>();
        String security = bundle.getString("securityListTwo" + test.getCurrent());
        String[] securityNumber = security.split(",");
        ArrayList<Integer> securityPrices = getSecurityPriceList();
        //get income share
        //  ArrayList<Float> incomeShareList = getIncomeShareList();
        for (int i=1; i < securityNumber.length+1; i++) {
            Double is = 0.0;
            int sp = securityPrices.get(i-1);
            Share share = new Share(sp, is, i);
            shares.add(share);
        }
        return shares;

    }




    public List<Share> getSecurityListWithEmptyIncomeSharesFromStart(){
        testClass test = new testClass();
        ArrayList<Share> shares = new ArrayList<Share>();
        String security = bundle.getString("securityList" + 1);
        String[] securityNumber = security.split(",");
        ArrayList<Integer> securityPrices = getSecurityPriceListFromStart();
        //get income share
        //  ArrayList<Float> incomeShareList = getIncomeShareList();
        for (int i=1; i < securityNumber.length+1; i++) {
            Double is = 0.0;
            int sp = securityPrices.get(i-1);
            Share share = new Share(sp, is, i);
            shares.add(share);
        }
        return shares;

    }













    // this calculates p(bar)
    public double getMeanPriceAmount(){
        testClass test = new testClass();
        String price = bundle.getString("securityPriceList" + test.getCurrent());
        String[] priceList = price.split(",");
        List<Double> prices = new ArrayList<Double>();
        for(String str: priceList){
            prices.add(Double.parseDouble(str));
        }
        double sum = 0;
        int amount = prices.size();
        for(Double num: prices){
            sum = sum + num;
        }
        return sum/amount;


    }



    //n(r) arg max pi/p1 <= r
    public Double getArgMaxFormula(double r, List<Share> securities){
        double argMax = 0;
        int p1 = securities.get(0).getPrice();
        double pi = 0;
        double ratio = 0;
        for(int i = 0; i < securities.size(); i++){
            pi = securities.get(i).getPrice();
            ratio = pi/p1;
            if(ratio > r){
                break;
            }
            argMax = (securities.get(i).getSecurityNumber());
        }
        return argMax;
    }

    //this calculates a(r)
    public Double getAR(double r, List<Share> shares){
        double nR = getArgMaxFormula(r, shares);
        double sum = 0;
        for(int i=1; i < nR+1; i++){
            sum = sum + shares.get(i - 1).getIncomeShare();
        }
        double mult = (1/nR);
        return (mult * sum) / 100;
    }

    //this calculates p(r)
    public Double getPR(double r, List<Share> shares){
        double nR = getArgMaxFormula(r, shares);
        double sum = 0;
        for(int i=1; i < nR+1; i++){
            sum = sum + shares.get(i-1).getPrice();
        }
        return ((1/nR)* sum);
    }




}
