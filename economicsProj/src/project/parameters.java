package project;

import sun.text.IntHashtable;

import java.security.Security;
import java.util.ArrayList;
import java.util.Collections;
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
        return Integer.parseInt(bundle.getString("incomeHave"));
    }

    public int getNumberOfSecurities(){
        return Integer.parseInt(bundle.getString("securityAmount"));
    }

    public ArrayList<Integer> getSecurityPriceList(){
        String price = bundle.getString("securityPriceList");
        String[] priceList = price.split(",");
        ArrayList<Integer> prices = new ArrayList<Integer>();
        for(String str: priceList){
            prices.add(Integer.parseInt(str));
        }
        return prices;
    }

    /*
    public ArrayList<Float> getIncomeShareList(){
        String price = bundle.getString("incomeShare");
        String[] priceList = price.split(",");
        ArrayList<Float> shares = new ArrayList<Float>();
        for(String str: priceList){
            shares.add(Float.parseFloat(str));
        }
        return shares;
    }


    */

    public List<Share> getSecurityList(){
        ArrayList<Share> shares = new ArrayList<Share>();
        String security = bundle.getString("securityList");
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



    public List<Share> getSecurityListWithEmptyIncomeShares(){
        ArrayList<Share> shares = new ArrayList<Share>();
        String security = bundle.getString("securityList");
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












    // this calculates p(bar)
    public double getMeanPriceAmount(){
        String price = bundle.getString("securityPriceList");
        String[] priceList = price.split(",");
        List<Double> prices = new ArrayList<Double>();
        for(String str: priceList){
            prices.add(Double.parseDouble(str));
        }
        Double sum = 0.0;
        int amount = prices.size();
        for(Double num: prices){
            sum = sum + num;
        }
        System.out.println(sum/amount);
        return sum/amount;


    }

    // this gets r
    public Double getReservationRatio(){
        String r = bundle.getString("reservationRatio");
        double ratio = Double.parseDouble(r);
        return ratio;
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
    public Double getAR(){
        Double nR = getArgMaxFormula(getReservationRatio(), getSecurityList());
        Double sum = 0.0;
        for(int i=1; i < nR+1; i++){
            sum = sum + getSecurityList().get(i-1).getIncomeShare();
        }
        Double mult = (1.0/nR);
        return mult * sum;
    }

    //this calculates p(r)
    public Double getPR(){
        double nR = getArgMaxFormula(getReservationRatio(), getSecurityList());
        double sum = 0.0;
        for(int i=1; i < nR+1; i++){
            sum = sum + getSecurityList().get(i-1).getPrice();
        }
        return ((1.0f/nR)* sum);
    }




}
