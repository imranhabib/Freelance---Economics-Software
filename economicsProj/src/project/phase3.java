package project;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by ihabib on 12/17/2014.
 */
public class phase3 extends JFrame{

    static JFrame frameForPrices;


    static JButton buttonFirst;
    static JButton buttonSecond;
    static JButton buttonThird;
    static JButton button4;
    static JButton button5;
    static JButton button6;
    static JButton button7;
    static JButton button8;
    static JButton button9;
    static JButton button10;
    static JButton button11;
    static JButton button12;
    static JButton button13;
    static JButton button14;
    static JButton button15;
    static JButton button16;

    static JButton previewButton;

    static JPanel buttonPanel;
    static JPanel buttonPanel2;
    static JPanel mainButtonsPanel;
    static JPanel topTitlePanel;
    static JPanel lowerButtonPanel;

    static ActionListener inputButton; static ActionListener inputButton2;

    static JLabel empty1;
    static JLabel empty2;

    static JLabel label1;
    static JLabel label2;
    static JLabel label3;


    static JTextField jtext;

    static ActionListener actionListener;
    static ActionListener switchOver;
    static ActionListener applyChoiceButton;
    static ActionListener maintainButton;
    static ActionListener continueButton;


    static Border raisedBorder;
    static Border loweredBorder;


    static boolean maintain;
    static boolean apply;



    FileReader reader1;
    FileReader reader2;
    FileReader reader3;
    FileReader reader4;
    FileReader reader5;
    FileReader reader6;
    FileReader reader7;
    FileReader reader8;
    FileReader reader9;
    FileReader reader10;

    static String prices;
    static int count;




    String directory;
    String adminDirectory;

    private String newline = "\n";
    String filename1;
    String filename2;
    String filename3;
    String filename4;
    String filename5;
    String filename6;
    String filename7;
    String filename8;
    String filename9;
    String filename10;

    static JTextArea text;

    String filename = "heuristic-output.csv";

    File file;
    FileWriter filer1;
    FileWriter filer2;
    FileWriter filer3;
    FileWriter filer4;
    FileWriter filer5;
    FileWriter filer6;
    FileWriter filer7;
    FileWriter filer8;
    FileWriter filer9;
    FileWriter filer10;
    FileWriter filer11;
    FileWriter filer12;


    static double R;
    static int M;



    List<List<Share>> stage1AllocationForStage4;
    List<List<Share>> listOfAllocs;

    String [] stage1Prices;

    public phase3 (final List<List<Share>> stage2ShareList, final int m, final double r, final double[] incomeShares) {

        setLayout(new BorderLayout());
        setTitle("Stage 3");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height - 45);
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);


        R = r;
        M = m;


        directoryStore dirStore = new directoryStore();
        directory = dirStore.getDirectory();
        adminDirectory = dirStore.getAdminDirectory();


        //for testing
//
//    final String directory = System.getProperty("user.home") + "/Desktop";
//    final String adminDirectory = System.getProperty("user.home")+ "/Desktop";




        filename1 =adminDirectory+ "/Phase1priceSet1.csv";
        filename2 = adminDirectory + "/Phase1priceSet2.csv";
        filename3 = adminDirectory+ "/Phase1priceSet3.csv";
        filename4 = adminDirectory + "/Phase1priceSet4.csv";
        filename5 =adminDirectory + "/Phase1priceSet5.csv";
        filename6 = adminDirectory + "/Phase1priceSet6.csv";
        filename7 = adminDirectory + "/Phase1priceSet7.csv";
        filename8 = adminDirectory + "/Phase1priceSet8.csv";
        filename9 = adminDirectory + "/Phase1priceSet9.csv";
        filename10 =  adminDirectory+ "/Phase1priceSet10.csv";

        stage1AllocationForStage4 = new ArrayList<List<Share>>();

        maintain = false;
        apply = false;

        raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
        loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

        buttonFirst = new JButton("Select to view allocations (Price Set 1)");
        buttonSecond  = new JButton("Select to view allocations (Price Set 2)");
        buttonThird = new JButton("Select to view allocations (Price Set 3)");
        button4 = new JButton("Select to view allocations (Price Set 4)");
        button5 = new JButton("Select to view allocations (Price Set 5)");
        button6 = new JButton("Select to view allocations (Price Set 6)");
        button7 = new JButton("Select to view allocations (Price Set 7)");
        button8 = new JButton("Select to view allocations (Price Set 8)");
        button9 = new JButton("Select to view allocations (Price Set 9)");
        button10 = new JButton("Select to view allocations (Price Set 10)");
        button11 = new JButton("Select to view choice rule");
        button12 = new JButton("Maintain Stage 1 Allocations");
        button13 = new JButton("Apply Choice Rule");
        button14 = new JButton("Continue");
        button15 = new JButton("Click to view income vectors");
        button16 = new JButton("Click to view inputs for stage 1 and stage 2");



        buttonFirst.setFont(new Font("Calibri",  Font.ROMAN_BASELINE, 15));
        buttonSecond.setFont(new Font("Calibri",  Font.ROMAN_BASELINE, 15));
        buttonThird.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));
        button4.setFont(new Font("Calibri", Font.ROMAN_BASELINE,15));
        button5.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button6.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button7.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button8.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button9.setFont(new Font("Calibri",Font.ROMAN_BASELINE,15));
        button10.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button11.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button12.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button13.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button14.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button15.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button16.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));





        buttonFirst.setBorder(new TitledBorder("Stage 1 Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        buttonSecond.setBorder(new TitledBorder("Stage 1 Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        buttonThird.setBorder(new TitledBorder("Stage 1 Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button4.setBorder(new TitledBorder("Stage 1 Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button5.setBorder(new TitledBorder("Stage 1 Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button6.setBorder(new TitledBorder("Stage 1 Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button7.setBorder(new TitledBorder("Stage 1 Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button8.setBorder(new TitledBorder("Stage 1 Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button9.setBorder(new TitledBorder("Stage 1 Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button10.setBorder(new TitledBorder("Stage 1 Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button11.setBorder(new TitledBorder("Choice Rule"));
        button15.setBorder(new TitledBorder("Income Vectors"));




        button13.setEnabled(true);
        button14.setEnabled(false);

        lowerButtonPanel = new JPanel(new GridLayout(1,2));
        mainButtonsPanel = new JPanel(new GridLayout(12, 1, 5, 5));
        mainButtonsPanel.setBorder(new TitledBorder(raisedBorder, "Data Sets"));

        buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(button12);
        buttonPanel.add(button13);

        buttonPanel2 = new JPanel(new GridLayout(1,2, 5, 5));
        buttonPanel2.add(button11);
        buttonPanel2.add(button15);


        mainButtonsPanel.add(buttonFirst);
        mainButtonsPanel.add(buttonSecond);
        mainButtonsPanel.add(buttonThird);
        mainButtonsPanel.add(button4);
        mainButtonsPanel.add(button5);
        mainButtonsPanel.add(button6);
        mainButtonsPanel.add(button7);
        mainButtonsPanel.add(button8);
        mainButtonsPanel.add(button9);
        mainButtonsPanel.add(button10);
        mainButtonsPanel.add(buttonPanel2);
        mainButtonsPanel.add(buttonPanel);

        lowerButtonPanel.add(button14);
        lowerButtonPanel.add(button16);

        topTitlePanel = new JPanel(new GridLayout(1, 1));
        label1 = new JLabel("Stage 3 | Price Allocations");
        label1.setFont(new Font("Calibri", Font.BOLD, 20));
        topTitlePanel.add(label1);

        add(topTitlePanel, BorderLayout.NORTH);
        add(mainButtonsPanel, BorderLayout.CENTER);
        add(button14, BorderLayout.SOUTH);

//new code

        char[] arr = new char[1000];
        reader1 = createReader(filename1);
        arr = readFile(arr, reader1);
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
        stage1AllocationForStage4.add(shareList);
        closeFile(reader1);



        char[] arr2 = new char[1000];
        reader2 = createReader(filename2);
        arr2 = readFile(arr2, reader2);
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
        stage1AllocationForStage4.add(shareList2);
        closeFile(reader2);


        char[] arr3 = new char[1000];
        reader3 = createReader(filename3);
        arr3 = readFile(arr3, reader3);
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
        stage1AllocationForStage4.add(shareList3);
        closeFile(reader3);



        char[] arr4 = new char[1000];
        reader4 = createReader(filename4);
        arr4 = readFile(arr4, reader4);
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
        stage1AllocationForStage4.add(shareList4);
        closeFile(reader4);






        char[] arr5 = new char[1000];
        reader5 = createReader(filename5);
        arr5 = readFile(arr5, reader5);
        String line5 = "";
        for(char c: arr5) {
            line5 = line5 + c;
        }
        String[] secondLine5 = line5.split("@");

        List<Share> shareList5 = new ArrayList<Share>();
        //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
        for(int i = 1; i < secondLine5.length; i ++){
            String number = secondLine5[i].substring(secondLine5[i].indexOf("%") + 1, secondLine5[i].lastIndexOf("%"));
            String price = secondLine5[i].substring(secondLine5[i].indexOf("$") + 1, secondLine5[i].lastIndexOf("$"));
            String allocation = secondLine5[i].substring(secondLine5[i].indexOf("#") + 1, secondLine5[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList5.add(shr);
        }

        stage1AllocationForStage4.add(shareList5);
        closeFile(reader5);



        char[] arr6 = new char[1000];
        reader6 = createReader(filename6);
        arr6 = readFile(arr6, reader6);
        String line6 = "";
        for(char c: arr6) {
            line6 = line6 + c;
        }
        String[] secondLine6 = line6.split("@");

        List<Share> shareList6 = new ArrayList<Share>();
        //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
        for(int i = 1; i < secondLine6.length; i ++){
            String number = secondLine6[i].substring(secondLine6[i].indexOf("%") + 1, secondLine6[i].lastIndexOf("%"));
            String price = secondLine6[i].substring(secondLine6[i].indexOf("$") + 1, secondLine6[i].lastIndexOf("$"));
            //          String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
            String allocation = secondLine6[i].substring(secondLine6[i].indexOf("#") + 1, secondLine6[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList6.add(shr);
        }

        stage1AllocationForStage4.add(shareList6);
        closeFile(reader6);



        char[] arr7 = new char[1000];
        reader7 = createReader(filename7);
        arr7 = readFile(arr7, reader7);
        String line7 = "";
        for(char c: arr7) {
            line7 = line7 + c;
        }
        String[] secondLine7 = line7.split("@");

        List<Share> shareList7 = new ArrayList<Share>();
        //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
        for(int i = 1; i < secondLine7.length; i ++){
            String number = secondLine7[i].substring(secondLine7[i].indexOf("%") + 1, secondLine7[i].lastIndexOf("%"));
            String price = secondLine7[i].substring(secondLine7[i].indexOf("$") + 1, secondLine7[i].lastIndexOf("$"));
            //          String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
            String allocation = secondLine7[i].substring(secondLine7[i].indexOf("#") + 1, secondLine7[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList7.add(shr);
        }

        stage1AllocationForStage4.add(shareList7);
        closeFile(reader7);



        char[] arr8 = new char[1000];
        reader8 = createReader(filename8);
        arr8 = readFile(arr8, reader8);
        String line8 = "";
        for(char c: arr8) {
            line8 = line8 + c;
        }
        String[] secondLine8 = line8.split("@");

        List<Share> shareList8 = new ArrayList<Share>();
        //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
        for(int i = 1; i < secondLine8.length; i ++){
            String number = secondLine8[i].substring(secondLine8[i].indexOf("%") + 1, secondLine8[i].lastIndexOf("%"));
            String price = secondLine8[i].substring(secondLine8[i].indexOf("$") + 1, secondLine8[i].lastIndexOf("$"));
            //          String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
            String allocation = secondLine8[i].substring(secondLine8[i].indexOf("#") + 1, secondLine8[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList8.add(shr);
        }

        stage1AllocationForStage4.add(shareList8);
        closeFile(reader8);



        char[] arr9 = new char[1000];
        reader9 = createReader(filename9);
        arr9 = readFile(arr9, reader9);
        String line9 = "";
        for(char c: arr9) {
            line9 = line9 + c;
        }
        String[] secondLine9 = line9.split("@");

        List<Share> shareList9 = new ArrayList<Share>();
        //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
        for(int i = 1; i < secondLine9.length; i ++){
            String number = secondLine9[i].substring(secondLine9[i].indexOf("%") + 1, secondLine9[i].lastIndexOf("%"));
            String price = secondLine9[i].substring(secondLine9[i].indexOf("$") + 1, secondLine9[i].lastIndexOf("$"));
            String allocation = secondLine9[i].substring(secondLine9[i].indexOf("#") + 1, secondLine9[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList9.add(shr);
        }

        stage1AllocationForStage4.add(shareList9);
        closeFile(reader9);



        char[] arr10 = new char[1000];
        reader10 = createReader(filename10);
        arr10 = readFile(arr10, reader10);
        String line10 = "";
        for(char c: arr10) {
            line10 = line10 + c;
        }
        String[] secondLine10 = line.split("@");

        List<Share> shareList10 = new ArrayList<Share>();
        //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
        for(int i = 1; i < secondLine10.length; i ++){
            String number = secondLine10[i].substring(secondLine10[i].indexOf("%") + 1, secondLine10[i].lastIndexOf("%"));
            String price = secondLine10[i].substring(secondLine10[i].indexOf("$") + 1, secondLine10[i].lastIndexOf("$"));
            String allocation = secondLine10[i].substring(secondLine10[i].indexOf("#") + 1, secondLine10[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList10.add(shr);
        }
        stage1AllocationForStage4.add(shareList10);
        closeFile(reader10);




        listOfAllocs = new ArrayList<List<Share>>();

        for(int i = 1; i < stage2ShareList.size() + 1; i++) {
            String maxMoney = (ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(i)));
            String pric = (ResourceBundle.getBundle("resources/systemdata").getString("securityPriceList" + Integer.toString(i)));
            String[] prices = pric.split(",");
            ArrayList<Share> shares = convertPriceSets(prices, R, M, incomeShares, Integer.parseInt(maxMoney));
            listOfAllocs.add(shares);

        }

        file = new File(directory, filename);

        if (!file.exists()) {
            file = new File(directory, filename);
            fileCreator(file);
        }

        filer1 = createFileWriter(file);
        formatFile(filer1, 1);
        for (Share shr : listOfAllocs.get(0)) {
            writeToFile(filer1, shr);

        }
        closeFile2(filer1);



        if (!file.exists()) {
            file = new File(directory, filename);
            fileCreator(file);
        }

        filer2 = createFileWriter(file);
        formatFile(filer2, 2);
        for (Share shr : listOfAllocs.get(1)) {
            writeToFile(filer2, shr);

        }
        closeFile2(filer2);



        if (!file.exists()) {
            file = new File(directory, filename);
            fileCreator(file);
        }

        filer3 = createFileWriter(file);
        formatFile(filer3, 3);
        for (Share shr : listOfAllocs.get(2)) {
            writeToFile(filer3, shr);

        }
        closeFile2(filer3);

        if (!file.exists()) {
            file = new File(directory, filename);
            fileCreator(file);
        }

        filer4 = createFileWriter(file);
        formatFile(filer4, 4);
        for (Share shr : listOfAllocs.get(3)) {
            writeToFile(filer4, shr);

        }
        closeFile2(filer4);



        if (!file.exists()) {
            file = new File(directory, filename);
            fileCreator(file);
        }

        filer5 = createFileWriter(file);
        formatFile(filer5, 5);
        for (Share shr : listOfAllocs.get(4)) {
            writeToFile(filer5, shr);

        }
        closeFile2(filer5);

        if (!file.exists()) {
            file = new File(directory, filename);
            fileCreator(file);
        }

        filer6 = createFileWriter(file);
        formatFile(filer6, 6);
        for (Share shr : listOfAllocs.get(5)) {
            writeToFile(filer6, shr);

        }
        closeFile2(filer6);

        if (!file.exists()) {
            file = new File(directory, filename);
            fileCreator(file);
        }

        filer7 = createFileWriter(file);
        formatFile(filer7, 7);
        for (Share shr : listOfAllocs.get(6)) {
            writeToFile(filer7, shr);

        }
        closeFile2(filer7);

        if (!file.exists()) {
            file = new File(directory, filename);
            fileCreator(file);
        }

        filer8 = createFileWriter(file);
        formatFile(filer8, 8);
        for (Share shr : listOfAllocs.get(7)) {
            writeToFile(filer8, shr);

        }
        closeFile2(filer8);

        if (!file.exists()) {
            file = new File(directory, filename);
            fileCreator(file);
        }

        filer9 = createFileWriter(file);
        formatFile(filer9, 9);
        for (Share shr : listOfAllocs.get(8)) {
            writeToFile(filer9, shr);

        }
        closeFile2(filer9);

        if (!file.exists()) {
            file = new File(directory, filename);
            fileCreator(file);
        }

        filer10 = createFileWriter(file);
        formatFile(filer10, 10);
        for (Share shr : listOfAllocs.get(9)) {
            writeToFile(filer10, shr);

        }
        closeFile2(filer10);







        //new code









        setVisible(true);



        inputButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Heuristic inputs and prices");
                frame.setBounds(0, 0, 500, 500);
                frame.setLocationRelativeTo(null);

                JLabel minshare = new JLabel("Minimum investment in each security: " + Integer.toString(m));
                JLabel ratio = new JLabel("R-ratio: " + Double.toString(r));
                String iS = "";
                for(int i=0; i<incomeShares.length; i++){
                    iS = iS + " " + Double.toString(incomeShares[i]);
                }
                JLabel incomeShares = new JLabel("Income share selection: " + iS);


                // Panels do have "FlowLayout"
                JPanel panel = new JPanel(new GridLayout(3, 1));
                panel.add(minshare);
                panel.add(ratio);
                panel.add(incomeShares);


                frame.add( panel );
                frame.pack();
                frame.setVisible(true);


            }
        };


        inputButton2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Income Vectors");
                frame.setBounds(0, 0, 500, 500);
                frame.setLocationRelativeTo(null);


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


                text = new JTextArea(prices);
                text.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
                text.setLineWrap(true);
                text.setEditable(false);
                text.setWrapStyleWord(true);



                frame.add(text,BorderLayout.CENTER);

                frame.setVisible(true);


            }
        };


        button15.addActionListener(inputButton2);
        button11.addActionListener(inputButton);

        count = 0;


//one side is going to be stage2shareList.get(x) This will be the left side, right side is going to be stage2ShareListWithSwitch
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();


                if(source == buttonFirst){
                    count = 1;
                    allocationPage(stage1AllocationForStage4, stage1AllocationForStage4.get(0), listOfAllocs, listOfAllocs.get(0), R, M, count);
                }
                else if(source == buttonSecond){
                    count = 2;
                    allocationPage(stage1AllocationForStage4, stage1AllocationForStage4.get(1), listOfAllocs, listOfAllocs.get(1), R, M, count);
                }
                else if(source == buttonThird){
                    count = 3;
                    allocationPage(stage1AllocationForStage4,stage1AllocationForStage4.get(2), listOfAllocs,listOfAllocs.get(2), R, M, count);
                }
                else if(source == button4){
                    count = 4;
                    allocationPage(stage1AllocationForStage4,stage1AllocationForStage4.get(3),listOfAllocs, listOfAllocs.get(3), R, M, count);
                }
                else if(source == button5){
                    count = 5;
                    allocationPage(stage1AllocationForStage4,stage1AllocationForStage4.get(4),listOfAllocs, listOfAllocs.get(4), R, M, count);
                }
                else if(source == button6){
                    count = 6;
                    allocationPage(stage1AllocationForStage4,stage1AllocationForStage4.get(5), listOfAllocs,listOfAllocs.get(5), R, M, count);
                }
                else if(source == button7){
                    count = 7;
                    allocationPage(stage1AllocationForStage4,stage1AllocationForStage4.get(6), listOfAllocs,listOfAllocs.get(6), R, M, count);
                }
                else if(source == button8){
                    count = 8;
                    allocationPage(stage1AllocationForStage4,stage1AllocationForStage4.get(7),listOfAllocs, listOfAllocs.get(7), R, M, count);
                }
                else if(source == button9){
                    count = 9;
                    allocationPage(stage1AllocationForStage4,stage1AllocationForStage4.get(8),listOfAllocs, listOfAllocs.get(8), R, M, count);
                }
                else if(source == button10){
                    count = 10;
                    allocationPage(stage1AllocationForStage4,stage1AllocationForStage4.get(9), listOfAllocs,listOfAllocs.get(9), R, M, count);
                }

            }
        };

        buttonFirst.addActionListener(actionListener);
        buttonSecond.addActionListener(actionListener);
        buttonThird.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
        button7.addActionListener(actionListener);
        button8.addActionListener(actionListener);
        button9.addActionListener(actionListener);
        button10.addActionListener(actionListener);




        applyChoiceButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to stage 1 prices to choice rule? This will cost you one token!", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (result != 0) {
                    return;
                }



                if (!file.exists()) {
                    file = new File(directory, filename);
                    fileCreator(file);
                }
                filer11 = createFileWriter(file);
                formatFileYes(filer11);
                closeFile2(filer11);


                buttonFirst.setEnabled(false);
                buttonSecond.setEnabled(false);
                buttonThird.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button13.setEnabled(false);
                button15.setEnabled(false);
                button14.setEnabled(true);
                apply = true;

            }
        };

        button13.addActionListener(applyChoiceButton);


        maintainButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to maintain Stage 1 allocations?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (result != 0) {
                    return;
                }


                if (!file.exists()) {
                    file = new File(directory, filename);
                    fileCreator(file);
                }
                filer12 = createFileWriter(file);
                formatFileNo(filer12);
                closeFile2(filer12);



                buttonFirst.setEnabled(false);
                buttonSecond.setEnabled(false);
                buttonThird.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button13.setEnabled(false);
                button15.setEnabled(false);
                button14.setEnabled(true);
                maintain = true;


            }
        };


        button12.addActionListener(maintainButton);

        continueButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(maintain){


                    List<List<Share>> phase1;
                    phase1 = new ArrayList<List<Share>>();


                    phase1.add(stage1AllocationForStage4.get(0));
                    phase1.add(stage1AllocationForStage4.get(1));
                    phase1.add(stage1AllocationForStage4.get(2));
                    phase1.add(stage1AllocationForStage4.get(3));
                    phase1.add(stage1AllocationForStage4.get(4));
                    phase1.add(stage1AllocationForStage4.get(5));
                    phase1.add(stage1AllocationForStage4.get(6));
                    phase1.add(stage1AllocationForStage4.get(7));
                    phase1.add(stage1AllocationForStage4.get(8));
                    phase1.add(stage1AllocationForStage4.get(9));



                    phase4 phasez = new phase4(stage2ShareList, M, R, phase1, false);
                    phasez.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    phasez.setVisible(true);

                    setVisible(false);
                    dispose();

                }

                if(apply){

                    List<List<Share>> listOfAllocs = new ArrayList<List<Share>>();
                    for(int i = 1; i < stage2ShareList.size() + 1; i++) {
                        String maxMoney = (ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(i)));
                        String pric = (ResourceBundle.getBundle("resources/systemdata").getString("securityPriceList" + Integer.toString(i)));
                        String[] prices = pric.split(",");
                        ArrayList<Share> shares = convertPriceSets(prices, R, M, incomeShares, Integer.parseInt(maxMoney));
                        listOfAllocs.add(shares);

                    }



                    phase4 phasez = new phase4(stage2ShareList, M, R, listOfAllocs, true);
                    phasez.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    phasez.setVisible(true);

                    setVisible(false);
                    dispose();

                }

            }
        };


        button14.addActionListener(continueButton);




    }




    public void allocationPage(final List<List<Share>> stage1whole, final List<Share> stage1, final List<List<Share>> stage2whole, final List<Share> stage2, final double r, final int m, final int count){

        final JFrame frame2 = new JFrame("Allocations for Round: " + count);
        frame2.setLayout(new BorderLayout());


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame2.setBounds(0, 0, screenSize.width, screenSize.height - 45);


        final JButton buttonUno = new JButton("View investments allocation as a chart");
        buttonUno.setLayout(new GridLayout(0, 3));
        buttonUno.setBorder(new TitledBorder("Chart"));

        final JButton buttonThree = new JButton("View investments allocation as a chart");
        buttonThree.setLayout(new GridLayout(0, 3));
        buttonThree.setBorder(new TitledBorder("Chart"));

        final JButton buttonTwo = new JButton("Close");
        buttonTwo.setLayout(new GridLayout(0, 3));
        buttonTwo.setBorder(new TitledBorder("Back to data page"));

        final JButton button3 = new JButton("Click to go to the next investment problem");
        button3.setLayout(new GridLayout(0, 3));
        button3.setBorder(new TitledBorder("Next Investment Problem"));


        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));

        JSplitPane mainSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel leftPanel = new JPanel(new GridLayout(stage1.size(), 1, 5, 5));
        JPanel rightPanel = new JPanel(new GridLayout(stage2.size(), 2, 5, 5));
        mainSplit.setBorder(new TitledBorder(raisedBorder, "Data Points"));
        leftPanel.setBorder(new TitledBorder(raisedBorder, "Stage 1 Allocations"));
        rightPanel.setBorder(new TitledBorder(raisedBorder, "Stage 2 Allocations (Choice Rule) WITH Stage 1 prices"));


        for (int i = 0; i < stage1.size(); i++) {
            String data = Double.toString(stage1.get(i).getAllocation());
            String splitter = data.substring(data.indexOf("."));
            if(splitter.length() > 2){
                splitter = splitter.substring(0, 3);
            }
            data = data.substring(0, data.indexOf(".")) + splitter;

            JTextField jText = new JTextField(data);
            jText.setEditable(false);
            jText.setBorder(new TitledBorder("Exact Amount"));
            jText.setSize(100, 50);

            JTextField jPrices = new JTextField(Integer.toString(stage1.get(i).getPrice()));
            jPrices.setEditable(false);
            jPrices.setBorder(new TitledBorder("Price"));
            jPrices.setSize(25, 25);

            JProgressBar progress = new JProgressBar();
            progress.setBorder(new TitledBorder("Investment"));
            progress.setValue(Math.round(Float.parseFloat(Double.toString(stage1.get(i).getAllocation()))));
            progress.setStringPainted(false);
            progress.setForeground(Color.BLACK);
            progress.setString(Integer.toString(Math.round(Float.parseFloat(Double.toString(stage1.get(i).getAllocation())))));

            JPanel panels = new JPanel();
            panels.setLayout(new GridLayout(0, 3));
            panels.add(progress);
            panels.add(jText);
            panels.add(jPrices);

            panels.setBorder(new TitledBorder("Security " + stage1.get(i).getSecurityNumber()));

            leftPanel.add(panels);
        }


        for(int i = 0; i <stage2.size(); i++){
            String data = Double.toString(stage2.get(i).getAllocation());
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
            progress.setValue(Math.round(Float.parseFloat(Double.toString(stage2.get(i).getAllocation()))));
            progress.setStringPainted(false);
            progress.setForeground(Color.BLACK);
            progress.setString(Integer.toString(Math.round(Float.parseFloat(Double.toString(stage2.get(i).getAllocation())))));

            JPanel panels = new JPanel();
            panels.setLayout(new GridLayout(0, 2));
            panels.add(progress);
            panels.add(jText);
            panels.setBorder(new TitledBorder("Security " + stage2.get(i).getSecurityNumber()));





            rightPanel.add(panels);
        }


        ActionListener actionChart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == buttonUno) {
                    chartView(stage1);
                }
                if(source == buttonTwo) {
                    frame2.dispose();
                }


                if(source == button3){
                    //CHANGE HERE IF YOUR CHANGING SECURS, OR ROUND VALUES
                    if(count == 10){
                        frame2.setVisible(false);
                        frame2.dispose();
                    }
                    int counter = count;
                    allocationPage(stage1whole, stage1whole.get(counter),stage2whole, stage2whole.get(counter), r, m, counter + 1);
                    frame2.dispose();
                }






            }
//        if(source == buttonfour){
//          //CHANGE HERE IF YOUR CHANGING SECURS, OR ROUND VALUES
//          if(count == 10){
//            frame2.setVisible(false);
//            frame2.dispose();
//          }
//          int counter = count;
//          allocationPage(stage1, stage2, r, m, counter + 1);
//          frame2.dispose();
//        }


        };



        buttonUno.addActionListener(actionChart);
        buttonTwo.addActionListener(actionChart);
        button3.addActionListener(actionChart);

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chartView(stage2);
            }
        };


        buttonPanel.add(buttonUno);
        buttonPanel.add(buttonTwo);
        buttonPanel.add(buttonThree);
        buttonPanel.add(button3);


        buttonUno.addActionListener(actionChart);
        buttonThree.addActionListener(action2);

        mainSplit.setLeftComponent(leftPanel);
        mainSplit.setRightComponent(rightPanel);
        mainSplit.setResizeWeight(0.50);


        frame2.add(mainSplit, BorderLayout.CENTER);
        frame2.add(buttonPanel, BorderLayout.SOUTH);
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


    public void fileCreator(File file) {
        try {
            if (file.createNewFile()) {
                System.out.println("check your desktop thats where dat file be");
            } else {
                System.out.println("you already have this file playa");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public FileWriter createFileWriter(File file) {
        try {
            FileWriter fileWrite = new FileWriter(file, true);
            //    System.out.println("here so this is good");
            return fileWrite;
        } catch (IOException e) {
            // System.out.println("here so were screwed");
            return null;
        }


    }



    public void formatFile(FileWriter filer, int count) {

        try {
            filer.write("\n\n" + "Stage 3 Allocations with Stage 1 Prices" + "\n\n" + "Round " + count);
        } catch (IOException e) {
            System.out.println("new file code failed");
        }


    }


    public void formatFileYes(FileWriter filer) {

        try {
            filer.write("\n\n" + "Stage 3 " + "\n" + "Decision: Yes (Switched Allocations) ");
        } catch (IOException e) {
            System.out.println("new file code failed");
        }


    }


    public void formatFileNo(FileWriter filer) {

        try {
            filer.write("\n\n" + "Stage 3" + "\n" + "Decision: No (Did not switch allocations ");
        } catch (IOException e) {
            System.out.println("new file code failed");
        }


    }



    public void writeToFile(FileWriter filer, Share share) {
        try {
            filer.write("\n"+ "Reservation Ratio = " + R + " Minimum investment in each security = " + M + " Security number = " + share.getSecurityNumber() + " Security price = " + share.getPrice() + " Security Income Share = " + share.getIncomeShare() +
                    " Security Allocation = " + share.getAllocation());

        } catch (IOException e) {
            System.out.println("failed hurr");
        }

    }






    public void closeFile2(FileWriter filer){
        try {
            filer.flush();
            filer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public FileReader createReader (String filename){
        try {
            FileReader readMe = new FileReader(filename);
            return readMe;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Here for some reason");
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
        System.out.println("Here for some other reaspn");
        return null;

    }


    public ArrayList<Share> convertPriceSets(String[] prices, double r, int minShare, double[] incomes, int max){
        int maxMoney = max;
        ArrayList<Share> shareLister = new ArrayList<Share>();
        for(int i=0; i< prices.length; i++){
            int temp = Integer.parseInt(prices[i]);
            shareLister.add(new Share(temp,incomes[i],i+1));
        }

        if (shareLister.size() == 1) {
            for (int i = 0; i < shareLister.size(); i++) {
                double allocationVal = allocForShare(i + 1, r, shareLister, minShare, maxMoney);
                Share share = new Share(shareLister.get(i).getPrice(), shareLister.get(i).getIncomeShare(), shareLister.get(i).getSecurityNumber(), allocationVal);
                shareLister.remove(i);
                shareLister.add(i, share);

            }

        }


        if (shareLister.size() == 2) {
            for (int i = 0; i < shareLister.size(); i++) {
                double allocationVal = allocForShare(i + 1, r, shareLister, minShare, maxMoney);
                Share share = new Share(shareLister.get(i).getPrice(), shareLister.get(i).getIncomeShare(), shareLister.get(i).getSecurityNumber(), allocationVal);
                shareLister.remove(i);
                shareLister.add(i, share);

            }

        }

        if (shareLister.size() == 3) {
            for (int i = 0; i < shareLister.size(); i++) {
                double allocationVal = allocForShare(i + 1, r, shareLister, minShare, maxMoney);
                Share share = new Share(shareLister.get(i).getPrice(), shareLister.get(i).getIncomeShare(), shareLister.get(i).getSecurityNumber(), allocationVal);
                shareLister.remove(i);
                shareLister.add(i, share);
            }

        }

        if (shareLister.size() == 4) {
            for (int i = 0; i < shareLister.size(); i++) {
                double allocationVal = allocForShare(i + 1, r, shareLister, minShare, maxMoney);
                Share share = new Share(shareLister.get(i).getPrice(), shareLister.get(i).getIncomeShare(), shareLister.get(i).getSecurityNumber(), allocationVal);
                shareLister.remove(i);
                shareLister.add(i, share);
            }

        }

        if (shareLister.size() == 5) {
            for (int i = 0; i < shareLister.size(); i++) {
                double allocationVal = allocForShare(i + 1, r, shareLister, minShare, maxMoney);
                Share share = new Share(shareLister.get(i).getPrice(), shareLister.get(i).getIncomeShare(), shareLister.get(i).getSecurityNumber(), allocationVal);
                shareLister.remove(i);
                shareLister.add(i, share);
            }

        }
        return shareLister;
    }






    public Double allocForShare(int shareNumber, double r, List<Share> shares, int x, int max) {
        int m = max;
        double meanPrice = 0;
        for(int i=0; i< shares.size(); i++){
            meanPrice = meanPrice + shares.get(i).getPrice();
        }
        meanPrice = meanPrice/shares.size();

        Double mXBar = getMbar(meanPrice, shares.size(), x);
        if (m < mXBar) {
            return allocationMethodOne(shares, m, meanPrice);
        }
        double nR = getArgMax(r, shares);
        if (shareNumber <= nR) {
            return allocationMethodTwo(r, shares, x, m, meanPrice, mXBar);
        } else
            return allocationMethodThree(shareNumber, shares, x, m, meanPrice, mXBar);
    }

    public Double getArgMax(double r, List<Share> securities){
        double argMax = 0;
        int p1 = securities.get(0).getPrice();
        double pi = 0;
        double ratio = 0;
        for(int i = 0; i < securities.size(); i++){
            pi = securities.get(i).getPrice();
            ratio = pi/p1;
            if(ratio > r){
                break;
            }
            argMax = (securities.get(i).getSecurityNumber());
        }
        return argMax;
    }

    public Double allocationMethodOne(List<Share> shares, int maxMoney, double meanPrice) {
        int m = maxMoney;
        Double p = meanPrice;
        int n = shares.size();
        System.out.println("allocationmethod one = " + m/ (n*p));
        return m / (n * p);
    }


    public Double allocationMethodTwo(double r, List<Share> shares, int x, int maxMoney, double meanPrice, double mbar) {
        int m = maxMoney;
        double p = meanPrice;
        double mXBar = mbar;
        double aR = getA(r, shares);
        double pR = getP(r, shares);
        System.out.println("allocationmethod two = " + "x Bar = " + "aR = " + aR + "m = " + m + "mxBar = " + mXBar+ "pR = "  +  pR);
        System.out.println("allocationmethod two = " + ((aR * (m - mXBar)) / pR));
        return x + ((aR * (m - mXBar)) / pR);
    }

    public Double allocationMethodThree(int shareNumber, List<Share> shares, int x, int maxMoney, double meanPrice, double mbar) {
        System.out.println("shareNumber = " + shareNumber);
        int m = maxMoney;
        double p = meanPrice;
        Double mXBar = mbar;
        Double aI = (shares.get(shareNumber - 1).getIncomeShare()) / 100;
        int pI = shares.get(shareNumber - 1).getPrice();

        System.out.println(x + ((aI * (m - mXBar)) / pI));


        return x + ((aI * (m - mXBar)) / pI);


    }
    public Double getA(double r, List<Share> shares){
        double nR = getArgMax(r, shares);
        double sum = 0;
        for(int i=1; i < nR+1; i++){
            sum = sum + shares.get(i - 1).getIncomeShare();
        }
        double mult = (1/nR);
        return (mult * sum) / 100;
    }

    //this calculates p(r)
    public Double getP(double r, List<Share> shares){
        double nR = getArgMax(r, shares);
        double sum = 0;
        for(int i=1; i < nR+1; i++){
            sum = sum + shares.get(i-1).getPrice();
        }
        return ((1/nR)* sum);
    }


    public Double getMbar (double pBar, int n, int x){
        return ((n*pBar)*x);

    }








































































}
