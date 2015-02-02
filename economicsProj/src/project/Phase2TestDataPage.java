package project;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Imran on 2014-12-14.
 */
public class phase2TestDataPage extends JFrame {



    static JButton button1;
    static JButton button2;
    static JButton button3;
    static JButton button4;
    static JButton button5;
    static JButton button6;

    static JButton button1b;
    static JButton button2b;
    static JButton button3b;
    static JButton button4b;

    static JButton button1c;
    static JButton button2c;
    static JButton button3c;
    static JButton button4c;

    static JButton button1d;
    static JButton button2d;
    static JButton button3d;
    static JButton button4d;

    //new ish
    static JButton selectionButtonRound1;
    static JButton selectionButtonRound2;
    static JButton selectionButtonRound3;
    static JButton selectionButtonRound4;
    //these buttons will determine which round is selected before the final round is advanced through

    static JButton round2;
    static JButton round3;
    static JButton round4;

    static JTextField inputButton;

    static JTextField empty1;
    static JTextField empty2;
    static JTextField empty3;


    static JButton title2;
    static JButton title3;
    static JButton title4;
    static JButton title5;


    static JPanel topPanel;
    static JPanel bottomPanel;
    static JPanel buttonPanel;
    static JPanel leftPanel;

    static JLabel title;

    static JLabel title6;
    static JLabel title7;

    String directory;


    String filenameer1;
    String filenameer2;
    String filenameer3;
    String filenameer4;



    String filenameRewind1;
    String filenameRewind2;
    String filenameRewind3;
    String filenameRewind4;



    String secondfilenameRewind1;
    String secondfilenameRewind2;
    String secondfilenameRewind3;
    String secondfilenameRewind4;

    String thirdfilenameRewind1;
    String thirdfilenameRewind2;
    String thirdfilenameRewind3;
    String thirdfilenameRewind4;

    String forthfilenameRewind1;
    String forthfilenameRewind2;
    String forthfilenameRewind3;
    String forthfilenameRewind4;

    FileReader Stage2reader;
    FileReader Stage2reader2;
    FileReader Stage2reader3;
    FileReader Stage2reader4;


    FileReader readerRewind;
    FileReader readerRewind2;
    FileReader readerRewind3;
    FileReader readerRewind4;

    FileReader secondreaderRewind;
    FileReader secondreaderRewind2;
    FileReader secondreaderRewind3;
    FileReader secondreaderRewind4;


    FileReader thirdreaderRewind;
    FileReader thirdreaderRewind2;
    FileReader thirdreaderRewind3;
    FileReader thirdreaderRewind4;

    FileReader forthreaderRewind;
    FileReader forthreaderRewind2;
    FileReader forthreaderRewind3;
    FileReader forthreaderRewind4;




    static ActionListener changes;
    static ActionListener changes2;
    static ActionListener changes3;
    static ActionListener changes4;
    // static ActionListener changes5;
    static ActionListener secondRew;
    static ActionListener thirdRew;
    static ActionListener forthRew;

    //new ish
    static ActionListener selectionButtons;



    static JSplitPane split;
    static JSplitPane split2;
    static JTextArea text;
    static JTextArea text2;


    static Border raisedBorder;
    static Border loweredBorder;

    static storageClass store;

    static String prices;
    static String choices;
    private String newline = "\n";
    private String newtab = "\t\t\t\t";

    static List<List<Share>> allocationsReal;

    static double R;
    static int M;

    //new ish
    //these are going hold the value set for the selectionButtons as the rewind calls are made

    static double R2;
    static int M2;

    static double R3;
    static int M3;

    static double R4;
    static int M4;

    static double R5;
    static int M5;

    static double[] arr2;
    static double[] arr3;
    static double[] arr4;
    static double[] arr5;



    boolean rewind2;
    boolean rewind3;
    boolean rewind4;



    public phase2TestDataPage(final List<Share> shares, final int m, final double r, final boolean rewind, final boolean rewind2, final boolean rewind3, final boolean rewind4){


        directoryStore dirStore = new directoryStore();
        directory = dirStore.getAdminDirectory();
        filenameer1 = directory + "/priceSet1.csv";
        filenameer2 = directory + "/priceSet2.csv";
        filenameer3 = directory + "/priceSet3.csv";
        filenameer4 = directory + "/priceSet4.csv";



        filenameRewind1 = directory + "/priceSetRewind1.csv";
        filenameRewind2 = directory + "/priceSetRewind2.csv";
        filenameRewind3 = directory + "/priceSetRewind3.csv";
        filenameRewind4 = directory + "/priceSetRewind4.csv";



        secondfilenameRewind1 = directory + "/secondpriceSetRewind1.csv";
        secondfilenameRewind2 = directory + "/secondpriceSetRewind2.csv";
        secondfilenameRewind3 = directory + "/secondpriceSetRewind3.csv";
        secondfilenameRewind4 = directory + "/secondpriceSetRewind4.csv";

        thirdfilenameRewind1 = directory + "/thirdpriceSetRewind1.csv";
        thirdfilenameRewind2 = directory + "/thirdpriceSetRewind2.csv";
        thirdfilenameRewind3 = directory + "/thirdpriceSetRewind3.csv";
        thirdfilenameRewind4 = directory + "/thirdpriceSetRewind4.csv";

        forthfilenameRewind1 = directory + "/forthpriceSetRewind1.csv";
        forthfilenameRewind2 = directory + "/forthpriceSetRewind2.csv";
        forthfilenameRewind3 = directory + "/forthpriceSetRewind3.csv";
        forthfilenameRewind4 = directory + "/forthpriceSetRewind4.csv";



        prices = "Total income for portfolio 1 allocation: " + (ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(1))) + newline
                +  "Total income for portfolio 2 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(2))) + newline
                +  "Total income for portfolio 3 allocation: "  +(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(3))) + newline
                +  "Total income for portfolio 4 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(4))) + newline
                + "Total income for portfolio 5 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(5))) + newline
                +"Total income for portfolio 6 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(6))) + newline
                + "Total income for portfolio 7 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(7))) + newline
                + "Total income for portfolio 8 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(8)))+ newline
                +"Total income for portfolio 9 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(9))) + newline +
                "Total income for portfolio 10 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(10))) + newline ;
        choices = "If you are satisfied with your choice rule, select the button under the corresponding set of allocations. " + newline + newline + "In the next round, Your choice rule will be applied to a set of price vectors, and the income totals listed to the right, automatically."+ newline+
                "Each portfolio will have 5 securities."
                + newline + newline + "If you want to make a change to your choice rule, " + newline + "select the adjust choice rule option. But be careful! You can only go back and adjust your choice rule 3 times. After 3 adjustments, the 4th adjustment (labelled as 'final chance') will be applied. ";





        R = r;
        M = m;

        if(rewind && !rewind2 && !rewind3 && !rewind4){
            R2 = r;
            M2 = m;
            arr2 = new double[shares.size()];
            for(int i = 0; i < shares.size(); i ++){
                arr2[i] = shares.get(i).getIncomeShare();
            }
        }
        if(rewind && rewind2 && !rewind3 && !rewind4){
            R3 = r;
            M3 = m;
            arr3 = new double[shares.size()];
            for(int i = 0; i < shares.size(); i ++){
                arr3[i] = shares.get(i).getIncomeShare();
            }
        }

        if(rewind && rewind2 && rewind3 && !rewind4){
            R4 = r;
            M4 = m;
            arr4 = new double[shares.size()];
            for(int i = 0; i < shares.size(); i ++){
                arr4[i] = shares.get(i).getIncomeShare();
            }
        }

        if(rewind && rewind2 && rewind3 && rewind4){
            R5 = r;
            M5 = m;
            arr5 = new double[shares.size()];
            for(int i = 0; i < shares.size(); i ++){
                arr5[i] = shares.get(i).getIncomeShare();
            }
        }



        setTitle("Stage 2 Test Round Data");
        setLayout(new BorderLayout());
        Dimension screenSize = new Dimension(600, 800);
        setBounds(0, 0, 1250, 600);
        setLocationRelativeTo(null);


        raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
        loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);



        split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        split.setResizeWeight(.80);
        topPanel = new JPanel(new GridLayout(5, 5, 10 , 10));


        button1 = new JButton("Allocations: Price Set 1");
        button2 = new JButton("Allocations: Price Set 2");
        button3 = new JButton("Allocations: Price Set 3");
        button4 = new JButton("Allocations: Price Set 4");
        button1b = new JButton();
        button2b = new JButton();
        button3b = new JButton();
        button4b = new JButton();
        button1c = new JButton();
        button2c = new JButton();
        button3c = new JButton();
        button4c = new JButton();
        button1d = new JButton();
        button2d = new JButton();
        button3d = new JButton();
        button4d = new JButton();

        //new ish
        selectionButtonRound1 = new JButton();
        selectionButtonRound2 = new JButton();
        selectionButtonRound3 = new JButton();
        selectionButtonRound4 = new JButton();




        String iS = "";
        for(int i=0; i<shares.size(); i++){
            if(i == 0) {
                iS = Double.toString(shares.get(i).getIncomeShare());
            }
            else {
                iS = iS + ", " + Double.toString(shares.get(i).getIncomeShare());
            }
        }

        empty1 = new JTextField("R-ratio: " + Double.toString(r));
        empty1.setEditable(false);
        empty2 = new JTextField("Income shares: " + iS);
        empty2.setEditable(false);
        empty3 = new JTextField("Current choice rule:");
        empty3.setEditable(false);

        inputButton = new JTextField("Minimum share: " + Integer.toString(m));
        inputButton.setEditable(false);

        inputButton.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));
        empty1.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        empty2.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        empty3.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));

        button1.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button2.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));
        button3.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button4.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));



        button1b.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button2b.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button3b.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));
        button4b.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));

        button1c.setFont(new Font("Calibri", Font.ROMAN_BASELINE,15));
        button2c.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button3c.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button4c.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));

        button1d.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button2d.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button3d.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button4d.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));


        button5 = new JButton();
        button5.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button5.setEnabled(false);


        selectionButtonRound1.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        selectionButtonRound2.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        selectionButtonRound3.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        selectionButtonRound4.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));




        title2 = new JButton();
        title3 = new JButton();
        title4 = new JButton();
        title5 = new JButton();

        title2.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        title3.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));
        title4.setFont(new Font("Calibri", Font.ROMAN_BASELINE,15));
        title5.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        selectionButtonRound1.setText("Click to select this choice rule");

        if(rewind){
            title2.setText("Allocations: Price Set 1");
            title3.setText("Allocations: Price Set 2");
            title4.setText("Allocations: Price Set 3");
            title5.setText("Allocations: Price Set 4");
            selectionButtonRound2.setText("Click to select this choice rule");
        }

        if(rewind && rewind2){
            button1b.setText("Allocations: Price Set 1");
            button2b.setText("Allocations: Price Set 2");
            button3b.setText("Allocations: Price Set 3");
            button4b.setText("Allocations: Price Set 4");
            selectionButtonRound3.setText("Click to select this choice rule");
        }
        if(rewind && rewind2 && rewind3){
            button1c.setText("Allocations: Price Set 1");
            button2c.setText("Allocations: Price Set 2");
            button3c.setText("Allocations: Price Set 3");
            button4c.setText("Allocations: Price Set 4");
            selectionButtonRound4.setText("Click to select this choice rule");
        }
        if(rewind && rewind2 && rewind3 && rewind4){
            button1d.setText("Allocations: Price Set 1");
            button2d.setText("Allocations: Price Set 2");
            button3d.setText("Allocations: Price Set 3");
            button4d.setText("Allocations: Price Set 4");
            button5.setText("Proceed to Stage 2");

            //new ish: these sets of buttons disable everything except for the final column

            title2.setEnabled(false);
            title3.setEnabled(false);
            title4.setEnabled(false);
            title5.setEnabled(false);
            selectionButtonRound2.setEnabled(false);

            button1b.setEnabled(false);
            button2b.setEnabled(false);
            button3b.setEnabled(false);
            button4b.setEnabled(false);
            selectionButtonRound3.setEnabled(false);

            button1c.setEnabled(false);
            button2c.setEnabled(false);
            button3c.setEnabled(false);
            button4c.setEnabled(false);
            selectionButtonRound4.setEnabled(false);

            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            selectionButtonRound1.setEnabled(false);



        }


        topPanel.add(button1);
        topPanel.add(title2);
        topPanel.add(button1b);
        topPanel.add(button1c);
        topPanel.add(button1d);
        topPanel.add(button2);
        topPanel.add(title3);
        topPanel.add(button2b);
        topPanel.add(button2c);
        topPanel.add(button2d);
        topPanel.add(button3);
        topPanel.add(title4);
        topPanel.add(button3b);
        topPanel.add(button3c);
        topPanel.add(button3d);
        topPanel.add(button4);
        topPanel.add(title5);
        topPanel.add(button4b);
        topPanel.add(button4c);
        topPanel.add(button4d);
        //new ish
        topPanel.add(selectionButtonRound1);
        topPanel.add(selectionButtonRound2);
        topPanel.add(selectionButtonRound3);
        topPanel.add(selectionButtonRound4);
        topPanel.add(button5);

        title = new JLabel("Data Page for Test Round Allocations");
        title.setFont(new Font("Calibri", Font.BOLD, 20));

        add(title, BorderLayout.NORTH);
        split.setTopComponent(topPanel);

        split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        split2.setResizeWeight(.50);

        bottomPanel = new JPanel(new BorderLayout());
        leftPanel = new JPanel(new BorderLayout());

        title7 = new JLabel("Instructions");
        leftPanel.add(title7, BorderLayout.NORTH);


        title6 = new JLabel("Income vectors to be used in Stage 2");
        bottomPanel.add(title6, BorderLayout.NORTH);

        text = new JTextArea(prices);
        text.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        text.setLineWrap(true);
        text.setEditable(false);
        text.setWrapStyleWord(true);

        text2 = new JTextArea(choices);
        text2.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        text2.setEditable(false);
        text2.setLineWrap(true);
        text2.setWrapStyleWord(true);

        bottomPanel.add(text, BorderLayout.CENTER);
        leftPanel.add(text2, BorderLayout.CENTER);


        button6 = new JButton("Adjust Choice Rule Chance 1");
        round2= new JButton("Adjust Choice Rule Chance 2");
        round3= new JButton("Adjust Choice Rule Chance 3");
        round4= new JButton("Final Choice Rule Selection");

        if(!rewind){
            round2.setEnabled(false);
            round3.setEnabled(false);
            round4.setEnabled(false);

        }

        if(rewind && !rewind2 && !rewind3 && !rewind4){
            button6.setEnabled(false);
            round2.setEnabled(true);
            round3.setEnabled(false);
            round4.setEnabled(false);
        }

        if(rewind && rewind2 && !rewind3 && !rewind4){
            button6.setEnabled(false);
            round2.setEnabled(false);
            round3.setEnabled(true);
            round4.setEnabled(false);
        }

        if(rewind && rewind2 && rewind3 && !rewind4){
            button6.setEnabled(false);
            round2.setEnabled(false);
            round3.setEnabled(false);
            round4.setEnabled(true);
        }

        if(rewind && rewind2 && rewind3 && rewind4){
            button6.setEnabled(false);
            round2.setEnabled(false);
            round3.setEnabled(false);
            round4.setEnabled(false);
            button5.setEnabled(true);
        }



        buttonPanel = new JPanel(new GridLayout(1, 0, 5, 5));
        buttonPanel.add(button6);
        buttonPanel.add(round2);
        buttonPanel.add(round3);
        buttonPanel.add(round4);



        changes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == button1){
                    char[] arr = new char[1000];
                    Stage2reader = createReader(filenameer1);
                    arr = readFile(arr, Stage2reader);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }

                    closeFile(Stage2reader);
                    allocationPage(shareList, R, M);
                }
                else if(source == button2){
                    char[] arr = new char[1000];
                    Stage2reader2 = createReader(filenameer2);
                    arr = readFile(arr, Stage2reader2);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }

                    closeFile(Stage2reader2);
                    allocationPage(shareList, R, M);
                }
                else if(source == button3){
                    char[] arr = new char[1000];
                    Stage2reader3 = createReader(filenameer3);
                    arr = readFile(arr, Stage2reader3);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }

                    closeFile(Stage2reader3);
                    allocationPage(shareList, R, M);
                }
                else if(source == button4){
                    char[] arr = new char[1000];
                    Stage2reader4 = createReader(filenameer4);
                    arr = readFile(arr, Stage2reader4);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }


                    closeFile(Stage2reader4);
                    allocationPage(shareList, R, M);
                }

            }
        };




        changes3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == title2){
                    char[] arr = new char[1000];
                    readerRewind = createReader(filenameRewind1);
                    arr = readFile(arr, readerRewind);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }

                    closeFile(readerRewind);
                    allocationPage(shareList, R, M);
                }
                else if(source == title3){
                    char[] arr = new char[1000];
                    readerRewind2 = createReader(filenameRewind2);
                    arr = readFile(arr, readerRewind2);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }


                    closeFile(readerRewind2);
                    allocationPage(shareList, R, M);
                }
                else if(source == title4){
                    char[] arr = new char[1000];
                    readerRewind3 = createReader(filenameRewind3);
                    arr = readFile(arr, readerRewind3);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }

                    closeFile(readerRewind3);
                    allocationPage(shareList, R, M);
                }
                else if(source == title5){
                    char[] arr = new char[1000];
                    readerRewind4 = createReader(filenameRewind4);
                    arr = readFile(arr, readerRewind4);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }


                    closeFile(readerRewind4);

                    allocationPage(shareList, R, M);
                }

            }
        };



        secondRew = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == button1b){
                    char[] arr = new char[1000];
                    secondreaderRewind = createReader(secondfilenameRewind1);
                    arr = readFile(arr, secondreaderRewind);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }

                    closeFile(secondreaderRewind);
                    allocationPage(shareList, R, M);
                }
                else if(source == button2b){
                    char[] arr = new char[1000];
                    secondreaderRewind2 = createReader(secondfilenameRewind2);
                    arr = readFile(arr, secondreaderRewind2);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }


                    closeFile(secondreaderRewind2);
                    allocationPage(shareList, R, M);
                }
                else if(source == button3b){
                    char[] arr = new char[1000];
                    secondreaderRewind3 = createReader(secondfilenameRewind3);
                    arr = readFile(arr, secondreaderRewind3);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }

                    closeFile(secondreaderRewind3);
                    allocationPage(shareList, R, M);
                }
                else if(source == button4b){
                    char[] arr = new char[1000];
                    secondreaderRewind4 = createReader(secondfilenameRewind4);
                    arr = readFile(arr, secondreaderRewind4);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }


                    closeFile(secondreaderRewind4);

                    allocationPage(shareList, R, M);
                }

            }
        };






        thirdRew = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == button1c){
                    char[] arr = new char[1000];
                    thirdreaderRewind = createReader(thirdfilenameRewind1);
                    arr = readFile(arr, thirdreaderRewind);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }

                    closeFile(thirdreaderRewind);
                    allocationPage(shareList, R, M);
                }
                else if(source == button2c){
                    char[] arr = new char[1000];
                    thirdreaderRewind2 = createReader(thirdfilenameRewind2);
                    arr = readFile(arr, thirdreaderRewind2);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }


                    closeFile(thirdreaderRewind2);
                    allocationPage(shareList, R, M);
                }
                else if(source == button3c){
                    char[] arr = new char[1000];
                    thirdreaderRewind3 = createReader(thirdfilenameRewind3);
                    arr = readFile(arr, thirdreaderRewind3);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }

                    closeFile(thirdreaderRewind3);
                    allocationPage(shareList, R, M);
                }
                else if(source == button4c){
                    char[] arr = new char[1000];
                    thirdreaderRewind4 = createReader(thirdfilenameRewind4);
                    arr = readFile(arr, thirdreaderRewind4);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }


                    closeFile(thirdreaderRewind4);

                    allocationPage(shareList, R, M);
                }

            }
        };

        forthRew = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == button1d){
                    char[] arr = new char[1000];
                    forthreaderRewind = createReader(forthfilenameRewind1);
                    arr = readFile(arr, forthreaderRewind);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }

                    closeFile(forthreaderRewind);
                    allocationPage(shareList, R, M);
                }
                else if(source == button2d){
                    char[] arr = new char[1000];
                    forthreaderRewind2 = createReader(forthfilenameRewind2);
                    arr = readFile(arr, forthreaderRewind2);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }


                    closeFile(forthreaderRewind2);
                    allocationPage(shareList, R, M);
                }
                else if(source == button3d){
                    char[] arr = new char[1000];
                    forthreaderRewind3 = createReader(forthfilenameRewind3);
                    arr = readFile(arr, forthreaderRewind3);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }

                    closeFile(forthreaderRewind3);
                    allocationPage(shareList, R, M);
                }
                else if(source == button4d){
                    char[] arr = new char[1000];
                    forthreaderRewind4 = createReader(forthfilenameRewind4);
                    arr = readFile(arr, forthreaderRewind4);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }


                    closeFile(forthreaderRewind4);

                    allocationPage(shareList, R, M);
                }

            }
        };



        changes4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(null,
                        "In the next window, you'll be able to view the results from your custom choice rule. Click to continue!", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (result != 0) {
                    return;
                }

                phase2Real phaseReal = new phase2Real(arr5, R5, M5);
                phaseReal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                phaseReal.setVisible(true);

                setVisible(false);
                dispose();

            }
        };


        button5.addActionListener(changes4);
//        inputButton.addActionListener(changes5);
//
//
//        changes5 = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                JLabel minshare = new JLabel("Minimum share: " + Integer.toString(m));
//                JLabel ratio = new JLabel("R-ratio: " + Double.toString(r));
//                String iS = "";
//                for(int i=0; i<shares.size(); i++){
//                    if(i == 0) {
//                        iS = iS + Double.toString(shares.get(i).getIncomeShare());
//                    }
//                    iS = iS + ", " + Double.toString(shares.get(i).getIncomeShare());
//                }
//                JLabel incomeShares = new JLabel("Income share selection: " + iS);
//                JLabel st1Prices = new JLabel("Prices for Stage1: ");
//                JLabel st2Prices = new JLabel("Prices for Stage2: ");
//
//                // Panels do have "FlowLayout"
//                JPanel panel = new JPanel(new GridLayout(3, 1));
//                panel.add(minshare);
//                panel.add(ratio);
//                panel.add(incomeShares);
//
//
//                frame.add( panel );
//                frame.pack();
//                frame.setVisible(true);
//            }
//        };

        changes2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == button6){
                    parameters params = new parameters();
//The m's and r's might be an issue here since the boolean is set here
                    sliderInterface2 slide = new sliderInterface2(params.getSecurityListFromStart(), 1, true, false, false, false,  M, R);
                    slide.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    slide.setVisible(true);

                    setVisible(false);
                    dispose();


                }

                if(source == round2){
                    parameters params = new parameters();

                    sliderInterface2 slide = new sliderInterface2(params.getSecurityListFromStart(), 1, true, true, false, false, M, R);
                    slide.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    slide.setVisible(true);
                    setVisible(false);
                    dispose();
                }

                if(source == round3){
                    parameters params = new parameters();

                    sliderInterface2 slide = new sliderInterface2(params.getSecurityListFromStart(), 1, true, true, true, false, M, R);
                    slide.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    slide.setVisible(true);
                    setVisible(false);
                    dispose();

                }

                if(source == round4){

                    int result = JOptionPane.showConfirmDialog(null,
                            "This is your final chance! The choice rule after this round is final! Continue?", "Confirmation", JOptionPane.YES_NO_OPTION);

                    if (result != 0) {
                        return;
                    }
                    parameters params = new parameters();

                    sliderInterface2 slide = new sliderInterface2(params.getSecurityListFromStart(), 1, true,true, true, true, M, R);
                    slide.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    slide.setVisible(true);
                    setVisible(false);
                    dispose();
                }




            }
        };

        //new ish
        //here, setting each select button into a submit button with the info from the test round its applied to

        selectionButtons = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if (source == selectionButtonRound1){

                    final double finalRatio = R;
                    final int finalM = M;
                    final double[] arr = new double[shares.size()];
                    for(int i = 0; i < shares.size(); i ++){
                        arr[i] = shares.get(i).getIncomeShare();
                    }

                    final JFrame frame = new JFrame("Heuristic inputs and prices");
                    frame.setLayout(new BorderLayout());
                    frame.setBounds(0, 0, 800, 600);
                    frame.setLocationRelativeTo(null);
                    JLabel minshare = new JLabel("Minimum share: " + Integer.toString(M));



                    String datum = Double.toString(R);
                    String splitum = datum.substring(datum.indexOf("."));
                    if(splitum.length() > 2){
                        splitum = splitum.substring(0, 3);
                    }
                    datum = datum.substring(0, datum.indexOf(".")) + splitum;
                    JLabel ratio = new JLabel("R-ratio: " + datum);

                    String iS = "";
                    for(int i=0; i<arr.length; i++){
                        iS = iS + " " + Double.toString(arr[i]);
                    }
                    JLabel incomeShares = new JLabel("Income share selection: " + iS);
                    final JButton buts = new JButton("Click to confirm choice rule");
                    final JButton buts2 = new JButton ("Go Back");

                    ActionListener butsAction = new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton source = (JButton) e.getSource();
                            if(source == buts){
                                int result = JOptionPane.showConfirmDialog(null,
                                        "Submit this choice rule?", "Confirmation", JOptionPane.YES_NO_OPTION);

                                if (result != 0) {
                                    return;
                                }
                                phase2Real phaseReal = new phase2Real(arr, finalRatio, finalM);
                                phaseReal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                phaseReal.setVisible(true);

                                frame.setVisible(false);
                                frame.dispose();

                                setVisible(false);
                                dispose();

                            }


                            if(source == buts2){
                                frame.setVisible(false);
                                frame.dispose();
                            }

                        }

                    };

                    buts.addActionListener(butsAction);
                    buts2.addActionListener(butsAction);
                    JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
                    buttonPanel.add(buts2);
                    buttonPanel.add(buts);
                    JPanel panel = new JPanel(new GridLayout(3, 1));
                    panel.add(minshare);
                    panel.add(ratio);
                    panel.add(incomeShares);

                    frame.add(panel, BorderLayout.CENTER);
                    frame.add(buttonPanel, BorderLayout.SOUTH);

                    frame.add( panel );
                    frame.pack();
                    frame.setVisible(true);


                }


                if (source == selectionButtonRound2){


                    final JFrame frame = new JFrame("Heuristic inputs and prices");
                    frame.setLayout(new BorderLayout());
                    frame.setBounds(0, 0, 800, 600);
                    frame.setLocationRelativeTo(null);
                    JLabel minshare = new JLabel("Minimum share: " + Integer.toString(M2));



                    String datum = Double.toString(R2);
                    String splitum = datum.substring(datum.indexOf("."));
                    if(splitum.length() > 2){
                        splitum = splitum.substring(0, 3);
                    }
                    datum = datum.substring(0, datum.indexOf(".")) + splitum;
                    JLabel ratio = new JLabel("R-ratio: " + datum);

                    String iS = "";
                    for(int i=0; i<arr2.length; i++){
                        iS = iS + " " + Double.toString(arr2[i]);
                    }
                    JLabel incomeShares = new JLabel("Income share selection: " + iS);
                    final JButton buts = new JButton("Click to confirm choice rule");
                    final JButton buts2 = new JButton ("Go Back");

                    ActionListener butsAction = new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton source = (JButton) e.getSource();
                            if(source == buts){
                                int result = JOptionPane.showConfirmDialog(null,
                                        "Submit this choice rule?", "Confirmation", JOptionPane.YES_NO_OPTION);

                                if (result != 0) {
                                    return;
                                }
                                phase2Real phaseReal = new phase2Real(arr2, R2, M2);
                                phaseReal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                phaseReal.setVisible(true);

                                frame.setVisible(false);
                                frame.dispose();

                                setVisible(false);
                                dispose();

                            }


                            if(source == buts2){
                                frame.setVisible(false);
                                frame.dispose();
                            }

                        }

                    };

                    buts.addActionListener(butsAction);
                    buts2.addActionListener(butsAction);
                    JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
                    buttonPanel.add(buts2);
                    buttonPanel.add(buts);
                    JPanel panel = new JPanel(new GridLayout(3, 1));
                    panel.add(minshare);
                    panel.add(ratio);
                    panel.add(incomeShares);

                    frame.add(panel, BorderLayout.CENTER);
                    frame.add(buttonPanel, BorderLayout.SOUTH);

                    frame.add( panel );
                    frame.pack();
                    frame.setVisible(true);



                }



                if (source == selectionButtonRound3){

                    final JFrame frame = new JFrame("Heuristic inputs and prices");
                    frame.setLayout(new BorderLayout());
                    frame.setBounds(0, 0, 800, 600);
                    frame.setLocationRelativeTo(null);
                    JLabel minshare = new JLabel("Minimum share: " + Integer.toString(M3));



                    String datum = Double.toString(R3);
                    String splitum = datum.substring(datum.indexOf("."));
                    if(splitum.length() > 2){
                        splitum = splitum.substring(0, 3);
                    }
                    datum = datum.substring(0, datum.indexOf(".")) + splitum;
                    JLabel ratio = new JLabel("R-ratio: " + datum);

                    String iS = "";
                    for(int i=0; i<arr3.length; i++){
                        iS = iS + " " + Double.toString(arr3[i]);
                    }
                    JLabel incomeShares = new JLabel("Income share selection: " + iS);
                    final JButton buts = new JButton("Click to confirm choice rule");
                    final JButton buts2 = new JButton ("Go Back");

                    ActionListener butsAction = new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton source = (JButton) e.getSource();
                            if(source == buts){
                                int result = JOptionPane.showConfirmDialog(null,
                                        "Submit this choice rule?", "Confirmation", JOptionPane.YES_NO_OPTION);

                                if (result != 0) {
                                    return;
                                }
                                phase2Real phaseReal = new phase2Real(arr3, R3, M3);
                                phaseReal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                phaseReal.setVisible(true);

                                frame.setVisible(false);
                                frame.dispose();

                                setVisible(false);
                                dispose();

                            }


                            if(source == buts2){
                                frame.setVisible(false);
                                frame.dispose();
                            }

                        }

                    };

                    buts.addActionListener(butsAction);
                    buts2.addActionListener(butsAction);
                    JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
                    buttonPanel.add(buts2);
                    buttonPanel.add(buts);
                    JPanel panel = new JPanel(new GridLayout(3, 1));
                    panel.add(minshare);
                    panel.add(ratio);
                    panel.add(incomeShares);

                    frame.add(panel, BorderLayout.CENTER);
                    frame.add(buttonPanel, BorderLayout.SOUTH);

                    frame.add( panel );
                    frame.pack();
                    frame.setVisible(true);
                }



                if (source == selectionButtonRound4){

                    final JFrame frame = new JFrame("Heuristic inputs and prices");
                    frame.setLayout(new BorderLayout());
                    frame.setBounds(0, 0, 800, 600);
                    frame.setLocationRelativeTo(null);
                    JLabel minshare = new JLabel("Minimum share: " + Integer.toString(M4));



                    String datum = Double.toString(R4);
                    String splitum = datum.substring(datum.indexOf("."));
                    if(splitum.length() > 2){
                        splitum = splitum.substring(0, 3);
                    }
                    datum = datum.substring(0, datum.indexOf(".")) + splitum;
                    JLabel ratio = new JLabel("R-ratio: " + datum);

                    String iS = "";
                    for(int i=0; i<arr4.length; i++){
                        iS = iS + " " + Double.toString(arr4[i]);
                    }
                    JLabel incomeShares = new JLabel("Income share selection: " + iS);
                    final JButton buts = new JButton("Click to confirm choice rule");
                    final JButton buts2 = new JButton ("Go Back");

                    ActionListener butsAction = new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton source = (JButton) e.getSource();
                            if(source == buts){
                                int result = JOptionPane.showConfirmDialog(null,
                                        "Submit this choice rule?", "Confirmation", JOptionPane.YES_NO_OPTION);

                                if (result != 0) {
                                    return;
                                }
                                phase2Real phaseReal = new phase2Real(arr4, R4, M4);
                                phaseReal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                phaseReal.setVisible(true);

                                frame.setVisible(false);
                                frame.dispose();

                                setVisible(false);
                                dispose();

                            }


                            if(source == buts2){
                                frame.setVisible(false);
                                frame.dispose();
                            }

                        }

                    };

                    buts.addActionListener(butsAction);
                    buts2.addActionListener(butsAction);
                    JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
                    buttonPanel.add(buts2);
                    buttonPanel.add(buts);
                    JPanel panel = new JPanel(new GridLayout(3, 1));
                    panel.add(minshare);
                    panel.add(ratio);
                    panel.add(incomeShares);

                    frame.add(panel, BorderLayout.CENTER);
                    frame.add(buttonPanel, BorderLayout.SOUTH);

                    frame.add( panel );
                    frame.pack();
                    frame.setVisible(true);

                }
            }
        };




        if(rewind) {
            title2.addActionListener(changes3);
            title3.addActionListener(changes3);
            title4.addActionListener(changes3);
            title5.addActionListener(changes3);
        }

        button1b.addActionListener(secondRew);
        button2b.addActionListener(secondRew);
        button3b.addActionListener(secondRew);
        button4b.addActionListener(secondRew);
        button1c.addActionListener(thirdRew);
        button2c.addActionListener(thirdRew);
        button3c.addActionListener(thirdRew);
        button4c.addActionListener(thirdRew);
        button1d.addActionListener(forthRew);
        button2d.addActionListener(forthRew);
        button3d.addActionListener(forthRew);
        button4d.addActionListener(forthRew);

        button1.addActionListener(changes);
        button2.addActionListener(changes);
        button3.addActionListener(changes);
        button4.addActionListener(changes);
        button6.addActionListener(changes2);

        round2.addActionListener(changes2);
        round3.addActionListener(changes2);
        round4.addActionListener(changes2);


        //new ish
        selectionButtonRound1.addActionListener(selectionButtons);
        selectionButtonRound2.addActionListener(selectionButtons);
        selectionButtonRound3.addActionListener(selectionButtons);
        selectionButtonRound4.addActionListener(selectionButtons);



        split2.setRightComponent(bottomPanel);
        split2.setLeftComponent(leftPanel);
        split.setBottomComponent(split2);

        add(buttonPanel, BorderLayout.SOUTH);
        add(split);
        setVisible(true);



    }


    public void allocationPage(final List<Share> shareList, final double r, final int m){

        final JFrame frame2 = new JFrame("Allocations");
        frame2.setLayout(new BorderLayout());


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame2.setBounds(0, 0, screenSize.width, screenSize.height - 45);
        frame2.setLayout(new BorderLayout());


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));


        final JButton button1 = new JButton("View data as a chart");
        button1.setLayout(new GridLayout(0, 3));
        button1.setBorder(new TitledBorder("Chart"));

        final  JButton button2 = new JButton("Close");
        button2.setLayout(new GridLayout(0, 3));
        button2.setBorder(new TitledBorder("Back to data page"));


        final JButton button3 = new JButton("View Prices");
        button3.setBorder(new TitledBorder("Prices for Round"));

        buttonPanel.add(button1);
        buttonPanel.add(button3);

        JPanel panelNew = new JPanel();
        panelNew.setLayout(new GridLayout(shareList.size(), 2));
        panelNew.setBorder(new TitledBorder("Data"));

        for(int i = 0; i <shareList.size(); i++){
            String data = Double.toString(shareList.get(i).getAllocation());
            String splitter = data.substring(data.indexOf("."));
            if(splitter.length() > 2){
                splitter = splitter.substring(0, 3);
            }
            data = data.substring(0, data.indexOf(".")) + splitter;
            JTextField jText = new JTextField(data);
            jText.setEditable(false);
            jText.setBorder(new TitledBorder("Exact Amount"));
            jText.setSize(100, 50);

            JProgressBar progress = new JProgressBar();
            progress.setBorder(new TitledBorder("Investment"));
            progress.setValue(Math.round(Float.parseFloat(Double.toString(shareList.get(i).getAllocation()))));
            progress.setStringPainted(false);
            progress.setForeground(Color.BLACK);
            progress.setString(Integer.toString(Math.round(Float.parseFloat(Double.toString(shareList.get(i).getAllocation())))));

            JPanel panels = new JPanel();
            panels.setLayout(new GridLayout(0, 2));
            panels.add(progress);
            panels.add(jText);
            panels.setBorder(new TitledBorder("Security " + shareList.get(i).getSecurityNumber()));

            panelNew.add(panels);
        }


        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == button1) {
                    chartView(shareList);
                }
                if(source == button2) {
                    frame2.dispose();

                }
            }
        };

        ActionListener prices = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == button3){


                    JFrame frame = new JFrame("Prices for Round");
                    frame.setBounds(0, 0, 500, 500);
                    frame.setLocationRelativeTo(null);

                    JPanel mainPan = new JPanel(new GridLayout(shareList.size(), 1, 5, 5));

                    for(int i=0; i<shareList.size(); i++){
                        JLabel labels = new JLabel("Price of Security # " + (i+1) + " = " + Integer.toString(shareList.get(i).getPrice()));
                        mainPan.add(labels);
                    }


                    frame.add(mainPan);
                    frame.setVisible(true);
                }


            }
        };

        button3.addActionListener(prices);

        button1.addActionListener(action);
        button2.addActionListener(action);


        JSplitPane splitPanel1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPanel1.setTopComponent(panelNew);
        splitPanel1.setBottomComponent(buttonPanel);
        splitPanel1.setResizeWeight(0.75);

        frame2.add(splitPanel1, BorderLayout.CENTER);
        frame2.add(button2, BorderLayout.SOUTH);
        frame2.setVisible(true);
        JOptionPane.showMessageDialog(frame2.getComponent(0), "This is your allocation based on your inputs");


    }


    public void chartView (List<Share> shareList){

        pieChart pie = new pieChart(shareList);
        JFreeChart pieCharter = pie.getChart();

        ChartFrame frame = new ChartFrame("Data", pieCharter);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0, 0, screenSize.width, screenSize.height);
        frame.setLayout(new BorderLayout());


        frame.pack();
        frame.setVisible(true);



    }

    public FileReader createReader (String filename){
        try {
            FileReader readMe = new FileReader(filename);
            return readMe;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }


    public void closeFile(FileReader filer){
        try {
            filer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public char[] readFile(char [] arr, FileReader reader){
        char [] details = new char[arr.length];
        try {
            reader.read(details);
            return details;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;

    }



























































































}
