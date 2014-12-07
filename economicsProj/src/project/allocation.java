package project;

import java.util.ArrayList;
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

    public Double allocationForShare(int shareNumber, double r, List<Share> shares, int x) {
        int m = params.getAllocation();
        Double mXBar = income.getMbar(params.getMeanPriceAmount(), shares.size());
        if (m < mXBar) {
            return allocationMethodOne(shares);
        }
        double nR = params.getArgMaxFormula(r, shares);
        if (shareNumber <= nR) {
            return allocationMethodTwo(r, shares, x);
        } else
            return allocationMethodThree(shareNumber, shares, x);
    }

    public Double allocationMethodOne(List<Share> shares) {
        int m = params.getAllocation();
        Double p = params.getMeanPriceAmount();
        int n = shares.size();
        System.out.println("allocationmethod one = " + m/ (n*p));
        return m / (n * p);
    }


    public Double allocationMethodTwo(double r, List<Share> shares, int x) {
        int m = params.getAllocation();
        double mXBar = income.getMbar(params.getMeanPriceAmount(), shares.size());
        double aR = params.getAR(r, shares);
        double pR = params.getPR(r, shares);
        System.out.println("allocationmethod two = " + "x Bar = " + "aR = " + aR + "m = " + m + "mxBar = " + mXBar+ "pR = "  +  pR);
        System.out.println("allocationmethod two = " + ((aR * (m - mXBar)) / pR));
        return x + ((aR * (m - mXBar)) / pR);
    }

    public Double allocationMethodThree(int shareNumber, List<Share> shares, int x) {
        System.out.println("shareNumber = " + shareNumber);
        int m = params.getAllocation();
        Double mXBar = income.getMbar(params.getMeanPriceAmount(), shares.size());
        Double aI = (shares.get(shareNumber - 1).getIncomeShare()) / 100;
        int pI = shares.get(shareNumber - 1).getPrice();

        System.out.println(x + ((aI * (m - mXBar)) / pI));


        return x + ((aI * (m - mXBar)) / pI);


    }


}
