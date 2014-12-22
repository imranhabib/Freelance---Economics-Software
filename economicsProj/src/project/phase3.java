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

  static JButton previewButton;

  static JPanel buttonPanel;
  static JPanel buttonPanel2;
  static JPanel mainButtonsPanel;
  static JPanel topTitlePanel;



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


  String directory = System.getProperty("user.home") + "/Desktop/output";


  String filename1 = directory + "/Phase1priceSet1.csv";
  String filename2 = directory + "/Phase1priceSet2.csv";
  String filename3 = directory + "/Phase1priceSet3.csv";
  String filename4 = directory + "/Phase1priceSet4.csv";
  String filename5 = directory + "/Phase1priceSet5.csv";
  String filename6 = directory + "/Phase1priceSet6.csv";
  String filename7 = directory + "/Phase1priceSet7.csv";
  String filename8 = directory + "/Phase1priceSet8.csv";
  String filename9 = directory + "/Phase1priceSet9.csv";
  String filename10 = directory + "/Phase1priceSet10.csv";

  String filename = "output.csv";

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

  String [] stage1Prices;

  public phase3 (final List<List<Share>> stage2ShareList, final int m, final double r, final double[] incomeShares) {


    setLayout(new BorderLayout());
    setTitle("Stage 3");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(0, 0, screenSize.width, screenSize.height - 45);


    R = r;
    M = m;



    stage1AllocationForStage4 = new ArrayList<List<Share>>();

    maintain = false;
    apply = false;

    raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
    loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

    buttonFirst = new JButton("Select to view allocations");
    buttonSecond  = new JButton("Select to view allocations");
    buttonThird = new JButton("Select to view allocations");
    button4 = new JButton("Select to view allocations");
    button5 = new JButton("Select to view allocations");
    button6 = new JButton("Select to view allocations");
    button7 = new JButton("Select to view allocations");
    button8 = new JButton("Select to view allocations");
    button9 = new JButton("Select to view allocations");
    button10 = new JButton("Select to view allocations");
    button11 = new JButton("Select to view prices");
    button12 = new JButton("Maintain Stage 2 Allocations");
    button13 = new JButton("Apply choice rule to stage 1 prices");
    button14 = new JButton("Continue");
    button15 = new JButton("View potential allocations if you choose to switch");



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





    buttonFirst.setBorder(new TitledBorder("Stage 1: Price Set 1 vs. Stage 2: Price Set 1"));
    buttonSecond.setBorder(new TitledBorder("Stage 1: Price Set 2 vs. Stage 2: Price Set 2"));
    buttonThird.setBorder(new TitledBorder("Stage 1: Price Set 3 vs. Stage 2: Price Set 3"));
    button4.setBorder(new TitledBorder("Stage 1: Price Set 4 vs. Stage 2: Price Set 4"));
    button5.setBorder(new TitledBorder("Stage 1: Price Set 5 vs. Stage 2: Price Set 5"));
    button6.setBorder(new TitledBorder("Stage 1: Price Set 6 vs. Stage 2: Price Set 6"));
    button7.setBorder(new TitledBorder("Stage 1: Price Set 7 vs. Stage 2: Price Set 7"));
    button8.setBorder(new TitledBorder("Stage 1: Price Set 8 vs. Stage 2: Price Set 8"));
    button9.setBorder(new TitledBorder("Stage 1: Price Set 9 vs. Stage 2: Price Set 9"));
    button10.setBorder(new TitledBorder("Stage 1: Price Set 10 vs. Stage 2: Price Set 10"));
    button11.setBorder(new TitledBorder("Prices used in Stage 1 & Stage 2"));
    button15.setBorder(new TitledBorder("Stage 2 choice rule with Stage 1 prices"));



    button13.setEnabled(false);
    button14.setEnabled(false);

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


    topTitlePanel = new JPanel(new GridLayout(1, 1));
    label1 = new JLabel("Stage 3 | Price Allocations");
    label1.setFont(new Font("Calibri", Font.BOLD, 20));
    topTitlePanel.add(label1);

    add(topTitlePanel, BorderLayout.NORTH);
    add(mainButtonsPanel, BorderLayout.CENTER);
    add(button14, BorderLayout.SOUTH);


    setVisible(true);

    file = new File(directory, filename);


    actionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if(source == buttonFirst){
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

          closeFile(reader1);
          allocationPage(shareList, stage2ShareList.get(0), R, M);
        }
        else if(source == buttonSecond){
          char[] arr = new char[1000];
          reader2 = createReader(filename2);
          arr = readFile(arr, reader2);
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
            //       String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
            String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList.add(shr);
          }

          closeFile(reader2);
          allocationPage(shareList,stage2ShareList.get(1), R, M);
        }
        else if(source == buttonThird){
          char[] arr = new char[1000];
          reader3 = createReader(filename3);
          arr = readFile(arr, reader3);
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
            //       String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
            String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList.add(shr);
          }

          closeFile(reader3);
          allocationPage(shareList,stage2ShareList.get(2), R, M);
        }
        else if(source == button4){
          char[] arr = new char[1000];
          reader4 = createReader(filename4);
          arr = readFile(arr, reader4);
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
            String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList.add(shr);
          }

          closeFile(reader4);
          allocationPage(shareList, stage2ShareList.get(3),R, M);
        }



        else if(source == button5){
          char[] arr = new char[1000];
          reader5 = createReader(filename5);
          arr = readFile(arr, reader5);
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
            //        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
            String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList.add(shr);
          }


          closeFile(reader5);
          allocationPage(shareList,stage2ShareList.get(4), R, M);
        }
        else if(source == button6){
          char[] arr = new char[1000];
          reader6 = createReader(filename6);
          arr = readFile(arr, reader6);
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
            //          String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
            String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList.add(shr);
          }


          closeFile(reader6);
          allocationPage(shareList, stage2ShareList.get(5),R, M);
        }
        else if(source == button7){
          char[] arr = new char[1000];
          reader7 = createReader(filename7);
          arr = readFile(arr, reader7);
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
            //          String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
            String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList.add(shr);
          }


          closeFile(reader7);
          allocationPage(shareList, stage2ShareList.get(6),R, M);
        }
        else if(source == button8){
          char[] arr = new char[1000];
          reader8 = createReader(filename8);
          arr = readFile(arr, reader8);
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
            //          String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
            String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList.add(shr);
          }


          closeFile(reader8);
          allocationPage(shareList,stage2ShareList.get(7), R, M);
        }
        else if(source == button9){
          char[] arr = new char[1000];
          reader9 = createReader(filename9);
          arr = readFile(arr, reader9);
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
            String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList.add(shr);
          }


          closeFile(reader9);
          allocationPage(shareList, stage2ShareList.get(8),R, M);
        }
        else if(source == button10){
          char[] arr = new char[1000];
          reader10 = createReader(filename10);
          arr = readFile(arr, reader10);
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
            String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList.add(shr);
          }

          closeFile(reader10);
          allocationPage(shareList,stage2ShareList.get(9), R, M);
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






    switchOver = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        List<List<Share>> listOfAllocs = new ArrayList<List<Share>>();
        for(int i = 1; i < stage2ShareList.size() + 1; i++) {
          String maxMoney = (ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(i)));
          String pric = (ResourceBundle.getBundle("resources/systemdata").getString("securityPriceList" + Integer.toString(i)));
          String[] prices = pric.split(",");
          ArrayList<Share> shares = convertPriceSets(prices, R, M, incomeShares, Integer.parseInt(maxMoney));
          listOfAllocs.add(shares);

        }




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






        phase3Switch phase = new phase3Switch(stage2ShareList, listOfAllocs, M, R, incomeShares);
        phase.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        phase.setVisible(true);
        button13.setEnabled(true);

      }
    };


    button15.addActionListener(switchOver);





    applyChoiceButton = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null,
            "Are you sure you want to apply choice to rule to stage 1 prices?", "Confirmation", JOptionPane.YES_NO_OPTION);

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
            "Are you sure you want to maintain current allocations?", "Confirmation", JOptionPane.YES_NO_OPTION);

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




          phase4 phasez = new phase4(stage2ShareList, M, R);
          phasez.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
          phasez.setVisible(true);

        }

        if(apply){
          phase4 phasez = new phase4(stage2ShareList, M, R);
          phasez.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
          phasez.setVisible(true);


        }

      }
    };


    button14.addActionListener(continueButton);











  }




  public void allocationPage(final List<Share> stage1, final List<Share> stage2, final double r, final int m){

    final JFrame frame2 = new JFrame("Allocations");
    frame2.setLayout(new BorderLayout());


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame2.setBounds(0, 0, screenSize.width, screenSize.height - 45);


    final JButton buttonUno = new JButton("View data as a chart");
    buttonUno.setLayout(new GridLayout(0, 3));
    buttonUno.setBorder(new TitledBorder("Chart"));

    final JButton buttonThree = new JButton("View data as a chart");
    buttonThree.setLayout(new GridLayout(0, 3));
    buttonThree.setBorder(new TitledBorder("Chart"));

    final JButton buttonTwo = new JButton("Close");
    buttonTwo.setLayout(new GridLayout(0, 3));
    buttonTwo.setBorder(new TitledBorder("Back to data page"));


    JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));

    JSplitPane mainSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JPanel leftPanel = new JPanel(new GridLayout(stage1.size(), 1, 5, 5));
    JPanel rightPanel = new JPanel(new GridLayout(stage2.size(), 1, 5, 5));
    mainSplit.setBorder(new TitledBorder(raisedBorder, "Data Points"));
    leftPanel.setBorder(new TitledBorder(raisedBorder, "Stage 1 Allocations"));
    rightPanel.setBorder(new TitledBorder(raisedBorder, "Stage 2 Allocations"));


    for(int i = 0; i <stage1.size(); i++){
      JTextField jText = new JTextField(Double.toString(stage1.get(i).getAllocation()));
      jText.setEditable(false);
      jText.setBorder(new TitledBorder("Exact Amount"));
      jText.setSize(100, 50);

      JProgressBar progress = new JProgressBar();
      progress.setBorder(new TitledBorder("Investment"));
      progress.setValue(Math.round(Float.parseFloat(Double.toString(stage1.get(i).getAllocation()))));
      progress.setStringPainted(true);
      progress.setForeground(Color.BLACK);
      progress.setString(Integer.toString(Math.round(Float.parseFloat(Double.toString(stage1.get(i).getAllocation())))));

      JPanel panels = new JPanel();
      panels.setLayout(new GridLayout(0, 2));
      panels.add(progress);
      panels.add(jText);
      panels.setBorder(new TitledBorder("Security " + stage1.get(i).getSecurityNumber()));

      leftPanel.add(panels);
    }


    for(int i = 0; i <stage2.size(); i++){
      JTextField jText = new JTextField(Double.toString(stage2.get(i).getAllocation()));
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
      }
    };

    buttonUno.addActionListener(actionChart);
    buttonTwo.addActionListener(actionChart);

    ActionListener action2 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        chartView(stage2);
      }
    };

    buttonPanel.add(buttonUno);
    buttonPanel.add(buttonTwo);
    buttonPanel.add(buttonThree);

    buttonUno.addActionListener(actionChart);
    buttonThree.addActionListener(action2);

    mainSplit.setLeftComponent(leftPanel);
    mainSplit.setRightComponent(rightPanel);
    mainSplit.setResizeWeight(0.50);

    frame2.add(mainSplit, BorderLayout.CENTER);
    frame2.add(buttonPanel, BorderLayout.SOUTH);
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
      filer.write("\n"+ "Reservation Ratio = " + R + " Minimum Share = " + M + " Security number = " + share.getSecurityNumber() + " Security price = " + share.getPrice() + " Security Income Share = " + share.getIncomeShare() +
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
