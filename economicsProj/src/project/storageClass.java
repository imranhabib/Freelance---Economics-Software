package project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imran on 2014-12-14.
 */
public class storageClass {

    static List<Share> listOfAllocations1;
    static List<Share> listOfAllocations2;
    static List<Share> listOfAllocations3;
    static List<Share> listOfAllocations4;
    static List<Share> listOfAllocations5;



    public storageClass(){
        listOfAllocations1 = new ArrayList<Share>();
        listOfAllocations2 = new ArrayList<Share>();
        listOfAllocations3 = new ArrayList<Share>();
        listOfAllocations4 = new ArrayList<Share>();
        listOfAllocations5 = new ArrayList<Share>();

    }



    public List<Share> getSharesListers1 (){
        return listOfAllocations1;
    }
    public List<Share> getSharesListers2 (){
        return listOfAllocations2;
    }
    public List<Share> getSharesListers3 (){
        return listOfAllocations3;
    }
    public List<Share> getSharesListers4 (){
        return listOfAllocations4;
    }
    public List<Share> getSharesListers5 (){
        return listOfAllocations5;
    }


    public void setListers (List<Share> shares){


        listOfAllocations1 = shares;
    }

    public void setListers2 (List<Share> shares){



        listOfAllocations2 = shares;
    }

    public void setListers3 (List<Share> shares){



        listOfAllocations3 = shares;
    }

    public void setListers4 (List<Share> shares){

        listOfAllocations4 = shares;
    }

    public void setListers5 (List<Share> shares){

        listOfAllocations5 = shares;
    }














}
