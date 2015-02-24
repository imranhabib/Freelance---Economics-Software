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

    static double[] arr20;
    static double[] arr30;
    static double[] arr40;
    static double[] arr50;



    boolean rewind2;
    boolean rewind3;
    boolean rewind4;


    static int count;


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



        prices = "Total income for portfolio 1 allocation: " + (ResourceBundle.getBundle("resources/systemdata").getString("maxMoney" + Integer.toString(1))) + newline
                +  "Total income for portfolio 2 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney" + Integer.toString(2))) + newline
                +  "Total income for portfolio 3 allocation: "  +(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney" + Integer.toString(3))) + newline
                +  "Total income for portfolio 4 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney" + Integer.toString(4))) + newline
                + "Total income for portfolio 5 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney" + Integer.toString(5))) + newline
                +"Total income for portfolio 6 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney" + Integer.toString(6))) + newline
                + "Total income for portfolio 7 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney" + Integer.toString(7))) + newline
                + "Total income for portfolio 8 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney" + Integer.toString(8)))+ newline
                +"Total income for portfolio 9 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney" + Integer.toString(9))) + newline +
                "Total income for portfolio 10 allocation: " +(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney" + Integer.toString(10))) + newline ;
        choices = "If you are satisfied with your choice rule, select the button under the corresponding set of allocations. " + newline + newline + "In the next round, Your choice rule will be applied to a set of price vectors, and the income totals listed to the right, automatically."+ newline+
                "Each portfolio will have 5 securities."
                + newline + newline + "If you want to make a change to your choice rule, " + newline + "select the adjust choice rule option. But be careful! You can only go back and adjust your choice rule 3 times. After 3 adjustments, the 4th adjustment (labelled as 'final chance') will be applied. ";





        R = r;
        M = m;

        if(rewind && !rewind2 && !rewind3 && !rewind4){
            R2 = r;
            M2 = m;
            arr20 = new double[shares.size()];
            for(int i = 0; i < shares.size(); i ++){
                arr20[i] = shares.get(i).getIncomeShare();
            }
        }
        if(rewind && rewind2 && !rewind3 && !rewind4){
            R3 = r;
            M3 = m;
            arr30 = new double[shares.size()];
            for(int i = 0; i < shares.size(); i ++){
                arr30[i] = shares.get(i).getIncomeShare();
            }
        }

        if(rewind && rewind2 && rewind3 && !rewind4){
            R4 = r;
            M4 = m;
            arr40 = new double[shares.size()];
            for(int i = 0; i < shares.size(); i ++){
                arr40[i] = shares.get(i).getIncomeShare();
            }
        }

        if(rewind && rewind2 && rewind3 && rewind4){
            R5 = r;
            M5 = m;
            arr50 = new double[shares.size()];
            for(int i = 0; i < shares.size(); i ++){
                arr50[i] = shares.get(i).getIncomeShare();
            }
        }



        setTitle("Stage 2 Test Round Data");
        setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height - 40);
        setLocationRelativeTo(null);
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);



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

        inputButton = new JTextField("Minimum investment in each security: " + Integer.toString(m));
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


        final List<List<Share>> highLevelList;
        highLevelList = new ArrayList<List<Share>>();

        //put rewind breaks before these list items and before all the code below

        final List<List<Share>> highLevelList2;
        highLevelList2 = new ArrayList<List<Share>>();

        final List<List<Share>> highLevelList3;
        highLevelList3 = new ArrayList<List<Share>>();

        final List<List<Share>> highLevelList4;
        highLevelList4 = new ArrayList<List<Share>>();

        final List<List<Share>> highLevelList5;
        highLevelList5 = new ArrayList<List<Share>>();



        //Start of REGULAR first test rounds

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
            String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList.add(shr);
        }
        highLevelList.add(shareList);
        closeFile(Stage2reader);



        char[] arr2 = new char[1000];
        Stage2reader2 = createReader(filenameer2);
        arr2 = readFile(arr2, Stage2reader2);
        String line2 = "";
        for(char c: arr2) {
            line2 = line2 + c;
        }
        String[] secondLine2 = line2.split("@");

        List<Share> shareList2 = new ArrayList<Share>();
        //the loop has to be -5 b/c the csv file doubles up on errythang
        for(int i = 1; i < secondLine2.length; i ++){
            String number = secondLine2[i].substring(secondLine2[i].indexOf("%") + 1, secondLine2[i].lastIndexOf("%"));
            String price = secondLine2[i].substring(secondLine2[i].indexOf("$") + 1, secondLine2[i].lastIndexOf("$"));
            //       String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
            String allocation = secondLine2[i].substring(secondLine2[i].indexOf("#") + 1, secondLine2[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList2.add(shr);
        }
        highLevelList.add(shareList2);
        closeFile(Stage2reader2);


        char[] arr3 = new char[1000];
        Stage2reader3 = createReader(filenameer3);
        arr3 = readFile(arr3, Stage2reader3);
        String line3 = "";
        for(char c: arr3) {
            line3 = line3 + c;
        }
        String[] secondLine3 = line3.split("@");

        List<Share> shareList3 = new ArrayList<Share>();
        //the loop has to be -5 b/c the csv file doubles up on errythang
        for(int i = 1; i < secondLine3.length; i ++){
            String number = secondLine3[i].substring(secondLine3[i].indexOf("%") + 1, secondLine3[i].lastIndexOf("%"));
            String price = secondLine3[i].substring(secondLine3[i].indexOf("$") + 1, secondLine3[i].lastIndexOf("$"));
            //       String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
            String allocation = secondLine3[i].substring(secondLine3[i].indexOf("#") + 1, secondLine3[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList3.add(shr);
        }
        highLevelList.add(shareList3);
        closeFile(Stage2reader3);

        char[] arr4 = new char[1000];
        Stage2reader4 = createReader(filenameer4);
        arr4 = readFile(arr4, Stage2reader4);
        String line4 = "";
        for(char c: arr4) {
            line4 = line4 + c;
        }
        String[] secondLine4 = line4.split("@");
        List<Share> shareList4 = new ArrayList<Share>();
        //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
        for(int i = 1; i < secondLine4.length; i ++){
            String number = secondLine4[i].substring(secondLine4[i].indexOf("%") + 1, secondLine4[i].lastIndexOf("%"));
            String price = secondLine4[i].substring(secondLine4[i].indexOf("$") + 1, secondLine4[i].lastIndexOf("$"));
            String allocation = secondLine4[i].substring(secondLine4[i].indexOf("#") + 1, secondLine4[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList4.add(shr);
        }
        highLevelList.add(shareList4);
        closeFile(Stage2reader4);

        count = 0;

        changes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == button1){
                    count = 1;
                    allocationPage(highLevelList, highLevelList.get(0), R, M, count);
                }
                else if(source == button2){
                   count = 2;
                    allocationPage(highLevelList, highLevelList.get(1),R, M, count);
                }
                else if(source == button3){
                    count = 3;
                    allocationPage(highLevelList, highLevelList.get(2), R, M, count);
                }
                else if(source == button4){
                  count = 4;
                    allocationPage(highLevelList, highLevelList.get(3), R, M, count);
                }

            }
        };





//START of second round and FIRST Test button press

        if(rewind) {

            count = 0;


            char[] arr5 = new char[1000];
            readerRewind = createReader(filenameRewind1);
            arr5 = readFile(arr5, readerRewind);
            String line5 = "";
            for (char c : arr5) {
                line5 = line5 + c;
            }
            String[] secondLine5 = line5.split("@");

            List<Share> shareList5 = new ArrayList<Share>();
            //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
            for (int i = 1; i < secondLine5.length; i++) {
                String number = secondLine5[i].substring(secondLine5[i].indexOf("%") + 1, secondLine5[i].lastIndexOf("%"));
                String price = secondLine5[i].substring(secondLine5[i].indexOf("$") + 1, secondLine5[i].lastIndexOf("$"));
                String allocation = secondLine5[i].substring(secondLine5[i].indexOf("#") + 1, secondLine5[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList5.add(shr);
            }

            highLevelList2.add(shareList5);
            closeFile(readerRewind);


            char[] arr6 = new char[1000];
            readerRewind2 = createReader(filenameRewind2);
            arr6 = readFile(arr6, readerRewind2);
            String line6 = "";
            for (char c : arr6) {
                line6 = line6 + c;
            }
            String[] secondLine6 = line6.split("@");

            List<Share> shareList6 = new ArrayList<Share>();
            //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
            for (int i = 1; i < secondLine6.length; i++) {
                String number = secondLine6[i].substring(secondLine6[i].indexOf("%") + 1, secondLine6[i].lastIndexOf("%"));
                String price = secondLine6[i].substring(secondLine6[i].indexOf("$") + 1, secondLine6[i].lastIndexOf("$"));
                //          String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                String allocation = secondLine6[i].substring(secondLine6[i].indexOf("#") + 1, secondLine6[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList6.add(shr);
            }

            highLevelList2.add(shareList6);
            closeFile(readerRewind2);


            char[] arr7 = new char[1000];
            readerRewind3 = createReader(filenameRewind3);
            arr7 = readFile(arr7, readerRewind3);
            String line7 = "";
            for (char c : arr7) {
                line7 = line7 + c;
            }
            String[] secondLine7 = line7.split("@");

            List<Share> shareList7 = new ArrayList<Share>();
            //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
            for (int i = 1; i < secondLine7.length; i++) {
                String number = secondLine7[i].substring(secondLine7[i].indexOf("%") + 1, secondLine7[i].lastIndexOf("%"));
                String price = secondLine7[i].substring(secondLine7[i].indexOf("$") + 1, secondLine7[i].lastIndexOf("$"));
                //          String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                String allocation = secondLine7[i].substring(secondLine7[i].indexOf("#") + 1, secondLine7[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList7.add(shr);
            }

            highLevelList2.add(shareList7);
            closeFile(readerRewind3);


            char[] arr8 = new char[1000];
            readerRewind4 = createReader(filenameRewind4);
            arr8 = readFile(arr8, readerRewind4);
            String line8 = "";
            for (char c : arr8) {
                line8 = line8 + c;
            }
            String[] secondLine8 = line8.split("@");

            List<Share> shareList8 = new ArrayList<Share>();
            //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
            for (int i = 1; i < secondLine8.length; i++) {
                String number = secondLine8[i].substring(secondLine8[i].indexOf("%") + 1, secondLine8[i].lastIndexOf("%"));
                String price = secondLine8[i].substring(secondLine8[i].indexOf("$") + 1, secondLine8[i].lastIndexOf("$"));
                //          String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                String allocation = secondLine8[i].substring(secondLine8[i].indexOf("#") + 1, secondLine8[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList8.add(shr);
            }

            highLevelList2.add(shareList8);
            closeFile(readerRewind4);


        }


        changes3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == title2){
                    count = 1;
                    allocationPage(highLevelList2, highLevelList2.get(0), R, M, count);
                }
                else if(source == title3){
                    count = 2;
                    allocationPage(highLevelList2, highLevelList2.get(1), R, M , count);
                }
                else if(source == title4){
                                count = 3;
                    allocationPage(highLevelList2, highLevelList2.get(2),  R, M, count);
                }
                else if(source == title5){
                count = 4;
                    allocationPage(highLevelList2, highLevelList2.get(3), R, M, count);
                }

            }
        };




        //THird rounder and second rewind goes here

        if(rewind && rewind2) {
            count = 0;

            char[] arr9 = new char[1000];
            secondreaderRewind = createReader(secondfilenameRewind1);
            arr9 = readFile(arr9, secondreaderRewind);
            String line9 = "";
            for (char c : arr9) {
                line9 = line9 + c;
            }
            String[] secondLine9 = line9.split("@");

            List<Share> shareList9 = new ArrayList<Share>();
            //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
            for (int i = 1; i < secondLine9.length; i++) {
                String number = secondLine9[i].substring(secondLine9[i].indexOf("%") + 1, secondLine9[i].lastIndexOf("%"));
                String price = secondLine9[i].substring(secondLine9[i].indexOf("$") + 1, secondLine9[i].lastIndexOf("$"));
                String allocation = secondLine9[i].substring(secondLine9[i].indexOf("#") + 1, secondLine9[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList9.add(shr);
            }

            highLevelList3.add(shareList9);
            closeFile(secondreaderRewind);


            char[] arr10 = new char[1000];
            secondreaderRewind2 = createReader(secondfilenameRewind2);
            arr10 = readFile(arr10, secondreaderRewind2);
            String line10 = "";
            for (char c : arr10) {
                line10 = line10 + c;
            }
            String[] secondLine10 = line.split("@");

            List<Share> shareList10 = new ArrayList<Share>();
            //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
            for (int i = 1; i < secondLine10.length; i++) {
                String number = secondLine10[i].substring(secondLine10[i].indexOf("%") + 1, secondLine10[i].lastIndexOf("%"));
                String price = secondLine10[i].substring(secondLine10[i].indexOf("$") + 1, secondLine10[i].lastIndexOf("$"));
                String allocation = secondLine10[i].substring(secondLine10[i].indexOf("#") + 1, secondLine10[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList10.add(shr);
            }
            highLevelList3.add(shareList10);
            closeFile(secondreaderRewind2);


            char[] arr11 = new char[1000];
            secondreaderRewind3 = createReader(secondfilenameRewind3);
            arr11 = readFile(arr11, secondreaderRewind3);
            String line11 = "";
            for (char c : arr11) {
                line11 = line11 + c;
            }
            String[] secondLine11 = line11.split("@");

            List<Share> shareList11 = new ArrayList<Share>();
            //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
            for (int i = 1; i < secondLine11.length; i++) {
                String number = secondLine11[i].substring(secondLine11[i].indexOf("%") + 1, secondLine11[i].lastIndexOf("%"));
                String price = secondLine11[i].substring(secondLine11[i].indexOf("$") + 1, secondLine11[i].lastIndexOf("$"));
                String allocation = secondLine11[i].substring(secondLine11[i].indexOf("#") + 1, secondLine11[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList11.add(shr);
            }

            highLevelList3.add(shareList11);
            closeFile(secondreaderRewind3);


            char[] arr12 = new char[1000];
            secondreaderRewind4 = createReader(secondfilenameRewind4);
            arr12 = readFile(arr12, secondreaderRewind4);
            String line12 = "";
            for (char c : arr12) {
                line12 = line12 + c;
            }
            String[] secondLine12 = line12.split("@");

            List<Share> shareList12 = new ArrayList<Share>();
            //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
            for (int i = 1; i < secondLine12.length; i++) {
                String number = secondLine12[i].substring(secondLine12[i].indexOf("%") + 1, secondLine12[i].lastIndexOf("%"));
                String price = secondLine12[i].substring(secondLine12[i].indexOf("$") + 1, secondLine12[i].lastIndexOf("$"));
                String allocation = secondLine12[i].substring(secondLine12[i].indexOf("#") + 1, secondLine12[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList12.add(shr);
            }
            highLevelList3.add(shareList12);
            closeFile(secondreaderRewind4);

        }

        secondRew = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == button1b){
                        count = 1;
                    allocationPage(highLevelList3, highLevelList3.get(0), R, M, count);
                }
                else if(source == button2b){
                count = 2;
                    allocationPage(highLevelList3, highLevelList3.get(1), R, M, count);
                }
                else if(source == button3b){
                count = 3;
                    allocationPage(highLevelList3, highLevelList3.get(2), R, M, count);
                }
                else if(source == button4b){
                count = 4;
                    allocationPage(highLevelList3, highLevelList3.get(3), R, M, count);
                }

            }
        };



if(rewind && rewind2 && rewind3) {
    count = 0;


    char[] arr13 = new char[1000];
    thirdreaderRewind = createReader(thirdfilenameRewind1);
    arr13 = readFile(arr13, thirdreaderRewind);
    String line13 = "";
    for (char c : arr13) {
        line13 = line13 + c;
    }
    String[] secondLine13 = line13.split("@");

    List<Share> shareList13 = new ArrayList<Share>();
    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
    for (int i = 1; i < secondLine13.length; i++) {
        String number = secondLine13[i].substring(secondLine13[i].indexOf("%") + 1, secondLine13[i].lastIndexOf("%"));
        String price = secondLine13[i].substring(secondLine13[i].indexOf("$") + 1, secondLine13[i].lastIndexOf("$"));
        String allocation = secondLine13[i].substring(secondLine13[i].indexOf("#") + 1, secondLine13[i].lastIndexOf("#"));
        Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
        shareList13.add(shr);
    }

    highLevelList4.add(shareList13);
    closeFile(thirdreaderRewind);


    char[] arr14 = new char[1000];
    thirdreaderRewind2 = createReader(thirdfilenameRewind2);
    arr14 = readFile(arr14, thirdreaderRewind2);
    String line14 = "";
    for (char c : arr14) {
        line14 = line14 + c;
    }
    String[] secondLine14 = line14.split("@");

    List<Share> shareList14 = new ArrayList<Share>();
    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
    for (int i = 1; i < secondLine14.length; i++) {
        String number = secondLine14[i].substring(secondLine14[i].indexOf("%") + 1, secondLine14[i].lastIndexOf("%"));
        String price = secondLine14[i].substring(secondLine14[i].indexOf("$") + 1, secondLine14[i].lastIndexOf("$"));
        String allocation = secondLine14[i].substring(secondLine14[i].indexOf("#") + 1, secondLine14[i].lastIndexOf("#"));
        Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
        shareList14.add(shr);
    }
    highLevelList4.add(shareList14);
    closeFile(thirdreaderRewind2);


    char[] arr15 = new char[1000];
    thirdreaderRewind3 = createReader(thirdfilenameRewind3);
    arr15 = readFile(arr15, thirdreaderRewind3);
    String line15 = "";
    for (char c : arr15) {
        line15 = line15 + c;
    }
    String[] secondLine15 = line15.split("@");

    List<Share> shareList15 = new ArrayList<Share>();
    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
    for (int i = 1; i < secondLine15.length; i++) {
        String number = secondLine15[i].substring(secondLine15[i].indexOf("%") + 1, secondLine15[i].lastIndexOf("%"));
        String price = secondLine15[i].substring(secondLine15[i].indexOf("$") + 1, secondLine15[i].lastIndexOf("$"));
        String allocation = secondLine15[i].substring(secondLine15[i].indexOf("#") + 1, secondLine15[i].lastIndexOf("#"));
        Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
        shareList15.add(shr);
    }

    highLevelList4.add(shareList15);
    closeFile(thirdreaderRewind3);


    char[] arr16 = new char[1000];
    thirdreaderRewind4 = createReader(thirdfilenameRewind4);
    arr16 = readFile(arr16, thirdreaderRewind4);
    String line16 = "";
    for (char c : arr16) {
        line16 = line16 + c;
    }
    String[] secondLine16 = line16.split("@");

    List<Share> shareList16 = new ArrayList<Share>();
    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
    for (int i = 1; i < secondLine16.length; i++) {
        String number = secondLine16[i].substring(secondLine16[i].indexOf("%") + 1, secondLine16[i].lastIndexOf("%"));
        String price = secondLine16[i].substring(secondLine16[i].indexOf("$") + 1, secondLine16[i].lastIndexOf("$"));
        String allocation = secondLine16[i].substring(secondLine16[i].indexOf("#") + 1, secondLine16[i].lastIndexOf("#"));
        Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
        shareList16.add(shr);
    }
    highLevelList4.add(shareList16);
    closeFile(thirdreaderRewind4);


}



        thirdRew = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == button1c){
        count = 1;
                    allocationPage(highLevelList4, highLevelList4.get(0),  R, M, count);
                }
                else if(source == button2c){
            count = 2;
                    allocationPage(highLevelList4, highLevelList4.get(1), R, M, count);
                }
                else if(source == button3c){
            count = 3;
                    allocationPage(highLevelList4, highLevelList4.get(2), R, M, count);
                }
                else if(source == button4c){
        count = 4;

                    allocationPage(highLevelList4, highLevelList4.get(3),  R, M, count);
                }

            }
        };



        //4th rewind

        if(rewind && rewind2 && rewind3 && rewind4) {
            count = 0;

            char[] arr17 = new char[1000];
            forthreaderRewind = createReader(forthfilenameRewind1);
            arr17 = readFile(arr17, forthreaderRewind);
            String line17 = "";
            for (char c : arr17) {
                line17 = line17 + c;
            }
            String[] secondLine17 = line17.split("@");

            List<Share> shareList17 = new ArrayList<Share>();
            //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
            for (int i = 1; i < secondLine17.length; i++) {
                String number = secondLine17[i].substring(secondLine17[i].indexOf("%") + 1, secondLine17[i].lastIndexOf("%"));
                String price = secondLine17[i].substring(secondLine17[i].indexOf("$") + 1, secondLine17[i].lastIndexOf("$"));
                String allocation = secondLine17[i].substring(secondLine17[i].indexOf("#") + 1, secondLine17[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList17.add(shr);
            }

            highLevelList5.add(shareList17);
            closeFile(forthreaderRewind);


            char[] arr18 = new char[1000];
            forthreaderRewind2 = createReader(forthfilenameRewind2);
            arr18 = readFile(arr18, forthreaderRewind2);
            String line18 = "";
            for (char c : arr18) {
                line18 = line18 + c;
            }
            String[] secondLine18 = line18.split("@");

            List<Share> shareList18 = new ArrayList<Share>();
            //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
            for (int i = 1; i < secondLine18.length; i++) {
                String number = secondLine18[i].substring(secondLine18[i].indexOf("%") + 1, secondLine18[i].lastIndexOf("%"));
                String price = secondLine18[i].substring(secondLine18[i].indexOf("$") + 1, secondLine18[i].lastIndexOf("$"));
                String allocation = secondLine18[i].substring(secondLine18[i].indexOf("#") + 1, secondLine18[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList18.add(shr);
            }
            highLevelList5.add(shareList18);
            closeFile(forthreaderRewind2);


            char[] arr19 = new char[1000];
            forthreaderRewind3 = createReader(forthfilenameRewind3);
            arr19 = readFile(arr19, forthreaderRewind3);
            String line19 = "";
            for (char c : arr19) {
                line19 = line19 + c;
            }
            String[] secondLine19 = line19.split("@");

            List<Share> shareList19 = new ArrayList<Share>();
            //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
            for (int i = 1; i < secondLine19.length; i++) {
                String number = secondLine19[i].substring(secondLine19[i].indexOf("%") + 1, secondLine19[i].lastIndexOf("%"));
                String price = secondLine19[i].substring(secondLine19[i].indexOf("$") + 1, secondLine19[i].lastIndexOf("$"));
                String allocation = secondLine19[i].substring(secondLine19[i].indexOf("#") + 1, secondLine19[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList19.add(shr);
            }

            highLevelList5.add(shareList19);
            closeFile(forthreaderRewind3);


            char[] arr20 = new char[1000];
            forthreaderRewind4 = createReader(forthfilenameRewind4);
            arr20 = readFile(arr20, forthreaderRewind4);
            String line20 = "";
            for (char c : arr20) {
                line20 = line20 + c;
            }
            String[] secondLine20 = line20.split("@");

            List<Share> shareList20 = new ArrayList<Share>();
            //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
            for (int i = 1; i < secondLine20.length; i++) {
                String number = secondLine20[i].substring(secondLine20[i].indexOf("%") + 1, secondLine20[i].lastIndexOf("%"));
                String price = secondLine20[i].substring(secondLine20[i].indexOf("$") + 1, secondLine20[i].lastIndexOf("$"));
                String allocation = secondLine20[i].substring(secondLine20[i].indexOf("#") + 1, secondLine20[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList20.add(shr);
            }
            highLevelList5.add(shareList20);
            closeFile(forthreaderRewind4);


        }


        forthRew = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == button1d){
count =1;
                    allocationPage(highLevelList5, highLevelList5.get(0), R, M, count);
                }
                else if(source == button2d){
count = 2;
                    allocationPage(highLevelList5, highLevelList5.get(1), R, M, count);
                }
                else if(source == button3d){
count = 3;
                    allocationPage(highLevelList5, highLevelList5.get(2), R, M, count);
                }
                else if(source == button4d){
count = 4;

                    allocationPage(highLevelList5, highLevelList5.get(3), R, M, count);
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

                phase2Real phaseReal = new phase2Real(arr50, R5, M5);
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
                    JLabel minshare = new JLabel("Minimum investment in each security: " + Integer.toString(M));



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
                    JLabel minshare = new JLabel("Minimum investment in each security: " + Integer.toString(M2));



                    String datum = Double.toString(R2);
                    String splitum = datum.substring(datum.indexOf("."));
                    if(splitum.length() > 2){
                        splitum = splitum.substring(0, 3);
                    }
                    datum = datum.substring(0, datum.indexOf(".")) + splitum;
                    JLabel ratio = new JLabel("R-ratio: " + datum);

                    String iS = "";
                    for(int i=0; i<arr20.length; i++){
                        iS = iS + " " + Double.toString(arr20[i]);
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
                                phase2Real phaseReal = new phase2Real(arr20, R2, M2);
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
                    JLabel minshare = new JLabel("Minimum investment in each security: " + Integer.toString(M3));



                    String datum = Double.toString(R3);
                    String splitum = datum.substring(datum.indexOf("."));
                    if(splitum.length() > 2){
                        splitum = splitum.substring(0, 3);
                    }
                    datum = datum.substring(0, datum.indexOf(".")) + splitum;
                    JLabel ratio = new JLabel("R-ratio: " + datum);

                    String iS = "";
                    for(int i=0; i<arr30.length; i++){
                        iS = iS + " " + Double.toString(arr30[i]);
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
                                phase2Real phaseReal = new phase2Real(arr30, R3, M3);
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
                    JLabel minshare = new JLabel("Minimum investment in each security: " + Integer.toString(M4));



                    String datum = Double.toString(R4);
                    String splitum = datum.substring(datum.indexOf("."));
                    if(splitum.length() > 2){
                        splitum = splitum.substring(0, 3);
                    }
                    datum = datum.substring(0, datum.indexOf(".")) + splitum;
                    JLabel ratio = new JLabel("R-ratio: " + datum);

                    String iS = "";
                    for(int i=0; i<arr40.length; i++){
                        iS = iS + " " + Double.toString(arr40[i]);
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
                                phase2Real phaseReal = new phase2Real(arr40, R4, M4);
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


    public void allocationPage(final List<List<Share>> listofAllocs, final List<Share> shareList, final double r, final int m, final int count){

        final JFrame frame2 = new JFrame("Allocations");
        frame2.setLayout(new BorderLayout());


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame2.setBounds(0, 0, screenSize.width, screenSize.height - 45);
        frame2.setLayout(new BorderLayout());


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 1, 5, 5));


        final JButton button1 = new JButton("View investments allocation as a chart");
        button1.setLayout(new GridLayout(0, 3));
        button1.setBorder(new TitledBorder("Chart"));


        final JButton button2 = new JButton("Close");
        button2.setLayout(new GridLayout(0, 3));
        button2.setBorder(new TitledBorder("Back to data page"));


        final JButton button3 = new JButton("Click to go to the next investment problem");
        button3.setLayout(new GridLayout(0, 3));
        button3.setBorder(new TitledBorder("Next Investment Problem"));


        buttonPanel.add(button1);
        buttonPanel.add(button3);


        JPanel panelNew = new JPanel();
        panelNew.setLayout(new GridLayout(shareList.size(), 2));
        panelNew.setBorder(new TitledBorder("Data"));

        for (int i = 0; i < shareList.size(); i++) {
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

            JTextField jPrices = new JTextField(Integer.toString(shareList.get(i).getPrice()));
            jPrices.setEditable(false);
            jPrices.setBorder(new TitledBorder("Price"));
            jPrices.setSize(25, 25);

            JProgressBar progress = new JProgressBar();
            progress.setBorder(new TitledBorder("Investment"));
            progress.setValue(Math.round(Float.parseFloat(Double.toString(shareList.get(i).getAllocation()))));
            progress.setStringPainted(false);
            progress.setForeground(Color.BLACK);
            progress.setString(Integer.toString(Math.round(Float.parseFloat(Double.toString(shareList.get(i).getAllocation())))));

            JPanel panels = new JPanel();
            panels.setLayout(new GridLayout(0, 3));
            panels.add(progress);
            panels.add(jPrices);
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

                if(source == button3){
                    //CHANGE HERE IF YOUR CHANGING SECURS, OR ROUND VALUES
                    if(count == 4){
                        frame2.setVisible(false);
                        frame2.dispose();
                    }
                    int counter = count;
                    allocationPage(listofAllocs, listofAllocs.get(counter), r, m, counter + 1);
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


        button1.addActionListener(action);
        button2.addActionListener(action);
        button3.addActionListener(action);


        JSplitPane splitPanel1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPanel1.setTopComponent(panelNew);
        splitPanel1.setBottomComponent(buttonPanel);
        splitPanel1.setResizeWeight(0.75);

        frame2.add(splitPanel1, BorderLayout.CENTER);
        frame2.add(button2, BorderLayout.SOUTH);
        frame2.setVisible(true);


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
