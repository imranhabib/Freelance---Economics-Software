package project;

/**
 * Created by Imran on 2014-11-25.
 */
public class Share {

    public int price;
    public Double incomeShare;
    public int incomeShare2;
    public int securityNumber;
    double allocation;


    public Share(int price,int securityNumber){
        this.price = price;
        this.securityNumber = securityNumber;
    }

    public Share(int price,int securityNumber, double allocation){
        this.price = price;
        this.securityNumber = securityNumber;
        this.allocation = allocation;
    }


    public Share(int price, Double incomeShare, int securityNumber){
        this.price = price;
        this.incomeShare = incomeShare;
        this.securityNumber = securityNumber;
    }

    public Share(int price, int incomeShare2, int securityNumber){
        this.price = price;
        this.incomeShare2 = incomeShare2;
        this.securityNumber = securityNumber;
    }


    public Share(int price, Double incomeShare, int securityNumber, double allocation){
        this.price = price;
        this.incomeShare = incomeShare;
        this.securityNumber = securityNumber;
        this.allocation = allocation;
    }


    public Share(int price, int incomeShare2, int securityNumber, double allocation){
        this.price = price;
        this.incomeShare2 = incomeShare2;
        this.securityNumber = securityNumber;
        this.allocation = allocation;
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

    public double getAllocation() {
        return allocation;
    }


}
