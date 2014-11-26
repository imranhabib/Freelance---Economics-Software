package project;

/**
 * Created by Imran on 2014-11-25.
 */
public class Share {

    public int price;
    public float incomeShare;
    public int securityNumber;

     public Share(int price, float incomeShare, int securityNumber){
        this.price = price;
        this.incomeShare = incomeShare;
        this.securityNumber = securityNumber;
    }

    public int getPrice(){
        return price;
    }

    public float getIncomeShare(){
        return incomeShare;
    }

    public int getSecurityNumber () {
        return securityNumber;


    }



}
