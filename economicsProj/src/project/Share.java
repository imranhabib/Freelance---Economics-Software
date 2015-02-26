package project;

/**
 * Created by Imran on 2014-11-25.
 */
public class Share {

  public int price;
  public double prices;
  public Double incomeShare;
  public int incomeShare2;
  public double incomeShare3;
  public double incomeShare4;
  public int securityNumber;
  double allocation;
  boolean f;


  public Share(int price,int securityNumber){
    this.price = price;
    this.securityNumber = securityNumber;
  }

  public Share(int price,int securityNumber, double allocation){
    this.price = price;
    this.securityNumber = securityNumber;
    this.allocation = allocation;
  }



  public Share(int price, int incomeShare2, int securityNumber){
    this.price = price;
    this.incomeShare2 = incomeShare2;
    this.securityNumber = securityNumber;
  }

  public Share(int price, double incomeShare4, int securityNumber){
    this.price = price;
    this.incomeShare4 = incomeShare4;
    this.securityNumber = securityNumber;
  }

  public Share(double prices, double incomeShare3, int securityNumber, boolean f){
    this.prices = prices;
    this.incomeShare3 = incomeShare3;
    this.securityNumber = securityNumber;
    this.f = f;
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


  public void setPrice(int p){
  price = p;
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
