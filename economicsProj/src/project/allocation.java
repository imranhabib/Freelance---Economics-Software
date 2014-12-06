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

    public Double allocationForShare(int shareNumber) {
        int m = params.getAllocation();
        Double mXBar = income.getMbar(params.getMeanPriceAmount(), params.getSecurityList().size());
        if (m < mXBar) {
            return allocationMethodOne();
        }
        double nR = params.getArgMaxFormula(params.getReservationRatio(), params.getSecurityList());
        if (shareNumber <= nR) {
            return allocationMethodTwo();
        } else
            return allocationMethodThree(shareNumber);
    }

    public Double allocationMethodOne() {
        int m = params.getAllocation();
        Double p = params.getMeanPriceAmount();
        int n = params.getSecurityList().size();
        return m / (n * p);
    }

    public Double allocationMethodTwo() {
        int xBar = income.x;
        int m = params.getAllocation();
        double mXBar = income.getMbar(params.getMeanPriceAmount(), params.getSecurityList().size());
        double aR = params.getAR();
        double pR = params.getPR();

        return xBar + ((aR * (m - mXBar)) / pR);
    }

    public Double allocationMethodThree(int shareNumber) {
        int xBar = income.x;
        int m = params.getAllocation();
        Double mXBar = income.getMbar(params.getMeanPriceAmount(), params.getSecurityList().size());
        Double aI = params.getSecurityList().get(shareNumber - 1).getIncomeShare();
        int pI = params.getSecurityList().get(shareNumber - 1).getPrice();

        return xBar + ((aI * (m - mXBar)) / pI);
    }


}
