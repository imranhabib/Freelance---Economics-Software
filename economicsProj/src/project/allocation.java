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

    public float allocationForShare(int shareNumber) {
        int m = params.getAllocation();
        int mXBar = income.getMbar(params.getMeanPriceAmount(), params.getSecurityList().size());
        if (m < mXBar) {
            return allocationMethodOne();
        }
        int nR = params.getArgMaxFormula(params.getReservationRatio(), params.getSecurityList());
        if (shareNumber <= nR) {
            return allocationMethodTwo();
        } else
            return allocationMethodThree(shareNumber);
    }

    public int allocationMethodOne() {
        int m = params.getAllocation();
        int p = params.getMeanPriceAmount();
        int n = params.getSecurityList().size();
        return m / (n * p);
    }

    public float allocationMethodTwo() {
        int xBar = income.x;
        int m = params.getAllocation();
        int mXBar = income.getMbar(params.getMeanPriceAmount(), params.getSecurityList().size());
        float aR = params.getAR();
        float pR = params.getPR();

        return xBar + ((aR * (m - mXBar)) / pR);
    }

    public float allocationMethodThree(int shareNumber) {
        int xBar = income.x;
        int m = params.getAllocation();
        int mXBar = income.getMbar(params.getMeanPriceAmount(), params.getSecurityList().size());
        float aI = params.getSecurityList().get(shareNumber - 1).getIncomeShare();
        int pI = params.getSecurityList().get(shareNumber - 1).getPrice();

        return xBar + ((aI * (m - mXBar)) / pI);
    }


}