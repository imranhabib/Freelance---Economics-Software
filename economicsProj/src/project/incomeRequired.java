package project;

/**
 * Created by Imran on 2014-11-22.
 */


//this class will calculate the m(xbar) equation
//xBar is a user input @here we will determine xbar locally, but later we need to link it to an external input
//m is a system defined variable
//n is a system defined variable (securityAmount)
//p bar is a system defined variable (calculated in the parameters class)

// m(xbar) = n*pbar*xbar

public class incomeRequired {

    int x;

    public incomeRequired(int input) {
        x = input;
    }

    public int getInput(){
        return x;
    }

    public Double getMbar (double pBar, int n){
        return ((n*pBar)*x);

    }



}
