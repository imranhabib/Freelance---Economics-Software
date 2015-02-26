package project;

import java.util.List;


/**
 * Created by Imran on 2014-11-16.
 */
public class allocation {

  static parameters params;
  static incomeRequired income;

  public allocation(parameters parameter, incomeRequired incomerequired) {
    income = incomerequired;
    params = parameter;
  }

  public Double allocationForShare(int shareNumber, double r, List<Share> shares, int x, String priceSet) {
    int m = params.getAllocation();
    Double mXBar = income.getMbar(params.getMeanPriceAmount(priceSet), shares.size());
    if (m < mXBar) {
      return allocationMethodOne(shares, priceSet);
    }
    double nR = params.getArgMaxFormula(r, shares);
    if (shareNumber <= nR) {
      return allocationMethodTwo(r, shares, x, priceSet);
    } else
      return allocationMethodThree(shareNumber, shares, x, priceSet);
  }

  public Double allocationMethodOne(List<Share> shares, String priceSet) {
    int m = params.getAllocation();
    Double p = params.getMeanPriceAmount(priceSet);
    int n = shares.size();

    return m / (n * p);
  }


  public Double allocationMethodTwo(double r, List<Share> shares, int x, String priceSet) {
    int m = params.getAllocation();
    double mXBar = income.getMbar(params.getMeanPriceAmount(priceSet), shares.size());
    double aR = params.getAR(r, shares);
    double pR = params.getPR(r, shares);

    return x + ((aR * (m - mXBar)) / pR);
  }

  public Double allocationMethodThree(int shareNumber, List<Share> shares, int x, String priceSet) {
    System.out.println("shareNumber = " + shareNumber);
    int m = params.getAllocation();
    Double mXBar = income.getMbar(params.getMeanPriceAmount(priceSet), shares.size());
    Double aI = (shares.get(shareNumber - 1).getIncomeShare()) / 100;
    double pI = (shares.get(shareNumber - 1).getPrice())/10;
    System.out.println("here is pI "  + pI);




    return x + ((aI * (m - mXBar)) / pI);


  }


}
