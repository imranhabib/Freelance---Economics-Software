package project;

/**
 * Created by Imran on 2014-11-25.
 */
public class Share {

    public int price;
    public Double incomeShare;
    public int securityNumber;


    public Share(int price,int securityNumber){
        this.price = price;
        this.securityNumber = securityNumber;
    }


    public Share(int price, Double incomeShare, int securityNumber){
        this.price = price;
        this.incomeShare = incomeShare;
        this.securityNumber = securityNumber;
    }

    public int getPrice(){
        return price;
    }

    public Double getIncomeShare(){
        return incomeShare;
    }

    public int getSecurityNumber () {
        return securityNumber;


    }



}
