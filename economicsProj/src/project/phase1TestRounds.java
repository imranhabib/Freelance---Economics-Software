package project;

import test.testClass;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/**
 * Created by ihabib on 2/3/2015.
 */
public class phase1TestRounds extends JFrame {

  static JSlider slider;
  static JPanel panel;
  static JPanel panel2;
  static JTextField valueAdjust;
  static JPanel panel3;
  static JPanel panel4;
  static JButton textFieldUsedtobePanel5;
  static JTextField textFieldUsedtobePanel6;
  static JLabel label7;
  static JLabel label8;
  static JButton button1;
  static JTextField remainingAlloc;
  static JButton button3;

  static JPanel buttonPanel;

  static JFormattedTextField sliderNumba;

  private static int valueOfSlider;

  static testClass test;
  static parameters params;

  private static java.util.List<JSlider> sliders;

  private static JTextField textField;
  private static JTextField textField2;
  private static JTextField textField3;
  private static JTextField textField4;
  private static JTextField textField5;

  private static JTextField textField6;
  private static JTextField textField7;
  private static JLabel LabelThatUsedtobeTextField8;



  static JLabel empty1;
  static JLabel empty2;
  static JLabel empty3;


  private static ChangeListener changelistener;
  private static ChangeListener changelistener2;
  private static ChangeListener changelistener3;
  private static ChangeListener changeListener5;
  private static ActionListener Actionlistener4;
  private static ActionListener actionListener5;
  private static ActionListener action;
  private static ChangeListener forConfirm;



  private static boolean check;
  private static boolean check2;
  private static boolean check3;
  private static boolean check4;
  private static boolean check5;
  private static boolean check6;
  private static boolean check7;

  static boolean redirect;



  //new stuff
  private int m1;
  private int m2;
  private int m3;
  private int m4;
  private int m5;


  private double d1;
  private double d2;
  private double d3;
  private double d4;
  private double d5;


  private int v1;
  private int v2;
  private int v3;
  private int v4;
  private int v5;

  static int curSysProp;

  static int total;

  static int allocation = 0;

  static JSlider s1;
  static int s1Price;
  static JSlider s2;
  static int s2Price;
  static JSlider s3;
  static int s3Price;
  static JSlider s4;
  static int s4Price;
  static JSlider s5;
  static int s5Price;

  static Border raisedBorder;
  static Border loweredBorder;

  static java.util.List<Share> anotherShareList;

  static int remainingMoney;

  //file stuffz


  //Note: everything called filename is stored in directory, everything else is stored in adminDirectory

  boolean resetPressed;


  //backend stuffz


  allocation alloc;
  parameters param;
  incomeRequired income;

  static Integer value;
  static Double value2;
  static Double pBar;
  static Double mBar;
  static Double r;
  static Double nOfr;
  static int minimumShare;


  static boolean checkNew;

  private static int n;


  static List<Share> shareList;







  public phase1TestRounds(final List<Share> shares, int cur){
    curSysProp = cur;
    test = new testClass();
    setLayout(new BorderLayout());
    setTitle("Stage 1" + ": Test Round " + test.getCurrent() );
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(0, 0, screenSize.width, screenSize.height - 40);

    //setUndecorated(true);

//    // setUndecorated(true);
//    // getRootPane().setWindowDecorationStyle(JRootPane.NONE);
//    this.addWindowListener(new java.awt.event.WindowAdapter() {
//      @Override
//      public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//        int result = JOptionPane.showConfirmDialog(null,
//            "You clicked close by mistake! Please press 'No' and return", "Close Button",
//            JOptionPane.YES_NO_OPTION);
//        if(result == 0){
//
//        }
//        int result3 = JOptionPane.showConfirmDialog(null,
//            "You clicked close by mistake! Please press 'No' and return", "Close Button",
//            JOptionPane.YES_NO_OPTION);
//
//        if(result3 == 0){
//          int result4 = JOptionPane.showConfirmDialog(null,
//              "You clicked close by mistake! Please press 'No' and return", "Close Button",
//              JOptionPane.YES_NO_OPTION);
//        }
//
//      }
//    });





    resetPressed = false;

    raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
    loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);


    checkNew = false;
    redirect = false;

    shareList = shares;


    total = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHaveTest" + test.getCurrent()));
    n = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("securityAmount" + test.getCurrent()));

    int size = shares.size();
    panel2 = new JPanel();

    allocation = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHaveTest" + test.getCurrent())) * 10;
    remainingMoney = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHaveTest" + test.getCurrent())) * 10;

    panel2.setLayout(new BorderLayout(5, 10));

    panel = new JPanel();
    panel.setLayout(new GridLayout(0, shares.size()));
    panel.setPreferredSize(new Dimension(500, 500));
    panel.setBorder(new TitledBorder("Unit Allocations"));

    panel3 = new JPanel();

    panel3.setLayout(new GridLayout(0, shares.size()));
    //panel3.setPreferredSize(new Dimension(50, 100));
    panel3.setBorder(new TitledBorder("Total"));

    textField = new JTextField();
    textField2 = new JTextField();
    textField3 = new JTextField();
    textField4 = new JTextField();
    textField5 = new JTextField();
    textField6 = new JTextField();

    textField.setEditable(false);
    textField2.setEditable(false);
    textField3.setEditable(false);
    textField4.setEditable(false);
    textField5.setEditable(false);
    textField6.setEditable(false);



    //backend stuffz


    param = new parameters();
    alloc = new allocation(param, new incomeRequired(2));

    shareList = param.getSecurityListWithEmptyIncomeSharesStage1TestRoundPrices();



    //param.getArgMaxFormula(2, shareList);



    button3 = new JButton("Reset Allocations");


    Actionlistener4 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        panel.removeAll();
        for (int i = 0; i < shareList.size(); i++) {
          JSlider jSlider = formatSlider2(shareList.get(i).getPrice(), shareList.get(i).getSecurityNumber());
          System.out.println("Security list after reset " + "Price = " + shareList.get(i).getPrice() + " number = " +  shareList.get(i).getSecurityNumber());
          BoundedRangeModel model = jSlider.getModel();
          if (i == 0){
            model.setRangeProperties(v1,0,0,1000,false);
          }
          if (i == 1){
            model.setRangeProperties(v2,0,0,1000,false);
          }
          if (i == 2){
            model.setRangeProperties(v3,0,0,1000,false);
          }
          if (i == 3){
            model.setRangeProperties(v4,0,0,1000,false);
          }
          if (i == 4){
            model.setRangeProperties(v5,0,0,1000,false);
          }

          addShare(jSlider, shareList.get(i).getPrice());
          if(i !=  0){
            jSlider.setEnabled(false);
          }
        }
        m1 =v1;
        m2 =v2;
        m3 =v3;
        m4 =v4;
        m5 =v5;
        v1= 0;
        v2=0;
        v3=0;
        v4=0;
        v5=0;
        resetPressed = true;
        check7 = false;
        textField.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        remainingMoney = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent())) * 10;
        textField7.setText(Integer.toString(allocation / 10));
        remainingAlloc.setText("");
        valueAdjust.setText("Value = ");
        panel.revalidate();
        panel.repaint();
      }
    };


    button3.addActionListener(Actionlistener4);
    button3.setBorder(new TitledBorder("Reset"));

    NumberFormat format = NumberFormat.getInstance();
    format.setMaximumIntegerDigits(1);
    sliderNumba = new JFormattedTextField(format);

    remainingAlloc = new JTextField();
    remainingAlloc.setEditable(false);
    remainingAlloc.setBorder(new TitledBorder(raisedBorder, "Cost of the currently selected security"));
    remainingAlloc.setFont(new Font("Calibri", Font.BOLD, 15));


    LabelThatUsedtobeTextField8 = new JLabel("Remaining Money");
    LabelThatUsedtobeTextField8.setBorder(raisedBorder);
    LabelThatUsedtobeTextField8.setFont(new Font("Calibri", Font.BOLD, 15));

    valueAdjust = new JTextField();
    valueAdjust.setBorder(raisedBorder);
    valueAdjust.setFont(new Font("Calibri", Font.BOLD, 15));
    valueAdjust.setText("Value = ");
    valueAdjust.setEditable(false);


    textField7 = new JTextField();
    textField7.setPreferredSize(new Dimension(30, 25));
    textField7.setText(Integer.toString(allocation / 10));
    textField7.setEditable(false);
    textField7.setBorder(new TitledBorder(loweredBorder, "Remaining Money"));
    textField7.setFont(new Font("Calibri", Font.BOLD, 15));

    label7 = new JLabel("Currently Allocated");
    label7.setBorder(raisedBorder);
    label7.setFont(new Font("Calibri", Font.BOLD, 15));




    textFieldUsedtobePanel6 = new JTextField();
    textFieldUsedtobePanel6.setText(Integer.toString(allocation / 10));
    textFieldUsedtobePanel6.setBorder(new TitledBorder(loweredBorder, "Total Money"));
    textFieldUsedtobePanel6.setFont(new Font("Calibri", Font.BOLD, 15));
    textFieldUsedtobePanel6.setEditable(false);

    label8 = new JLabel("Total Money");
    label8.setBorder(raisedBorder);
    label8.setFont(new Font("Calibri", Font.BOLD, 15));

    empty1 = new JLabel();
    empty2 = new JLabel("You must allocate units in order, from left to rightmost security.");
    empty3 = new JLabel();



    button1 = new JButton("Submit");
    button1.setToolTipText("Click to submit input selection");
    button1.setBorder(new TitledBorder("Move on"));


    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1,1, 5, 5));
    buttonPanel.add(button3);
    buttonPanel.add(button1);

    textFieldUsedtobePanel5 = new JButton("Equal Shares");
    textFieldUsedtobePanel5.setVisible(true);
    textFieldUsedtobePanel5.setBorder(new TitledBorder(raisedBorder, "Click to buy equal number of shares of each security"));
    textFieldUsedtobePanel5.setFont(new Font("Calibri", Font.BOLD, 15));


    panel4 = new JPanel(new GridLayout(2,2,5,5));

    panel4.setBorder(new TitledBorder(raisedBorder, "Allocation"));
    //add 3 things


    panel4.add(valueAdjust);
    panel4.add(empty2);
    panel4.add(textFieldUsedtobePanel5);
    panel4.add(textFieldUsedtobePanel6);
    panel4.add(remainingAlloc);
    panel4.add(textField7);




    if (size >= 1) {
      panel3.add(textField);

    }
    if (size >= 2) {
      panel3.add(textField2);
    }
    if (size >= 3) {
      panel3.add(textField3);
    }
    if (size >= 4) {
      panel3.add(textField4);

    }
    if (size >= 5) {
      panel3.add(textField5);
    }


    JSplitPane splitPane = new JSplitPane(
        JSplitPane.VERTICAL_SPLIT
    );

    splitPane.setTopComponent(panel);
    splitPane.setBottomComponent(panel4);
    splitPane.setResizeWeight(1);


    sliders = new ArrayList<JSlider>();


    //you can change the first SOUTH -> NORTH && the first CENTER -> SOUTH to get a different spacing/sizing

    panel2.add(splitPane, BorderLayout.CENTER);
    panel2.add(panel3, BorderLayout.NORTH);
    panel2.add(buttonPanel, BorderLayout.SOUTH);
    add(panel2, BorderLayout.CENTER);


    check = false;
    check2 = false;
    check3 = false;
    check4 = false;
    check5 = false;
    check6 = false;
    check7 = false;



    actionListener5 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == textFieldUsedtobePanel5) {
          panel.removeAll();
          int totalMoney = allocation / 10;

          //CHANGE HERE WHEN CHANGING SECURS
          int numberOfAssets = 5;
          int[] prices = new int[numberOfAssets];
          for (int i = 0; i < shareList.size(); i++) {
            prices[i] = shareList.get(i).getPrice();

          }
          double result = equalAlgo(numberOfAssets, totalMoney, prices);


          boolean checker = false;
          boolean checker2 = false;
          int result3 = 0;
          String data = Double.toString(result);

          String splitter = data.substring(data.indexOf("."));



          if (splitter.length() > 2) {
            splitter = splitter.substring(0, 3);
            checker = true;
          }

          data = data.substring(0, data.indexOf(".")) + splitter;

          //case where 2 digit front and decimal back
          String temp = data.substring(0, 4);
          String cut = temp.substring(0, temp.indexOf("."));



          if(cut.length() == 2){
            double tempResult = Double.parseDouble(data);
            tempResult = tempResult * 10;
            String temp2 = Double.toString(tempResult);
            temp2 = temp2.substring(0, 3);
            result3 = Integer.parseInt(temp2);
            checker2 = true;
          }






          double newResult = Double.parseDouble(data);
          double oldResult = newResult;
          String forTextField = Double.toString(oldResult);
          newResult = newResult * 10;
          String data2 = Double.toString(newResult);


          if(checker) {
            data2 = data2.substring(0, 2);
          }
          else {
            data2 = data2.substring(0, 3);
          }


          int result2 = Integer.parseInt(data2);



          for (int i = 0; i < shareList.size(); i++) {

            JSlider jSlider = formatSlider(shareList.get(i).getPrice(), shareList.get(i).getSecurityNumber());
            jSlider.setEnabled(false);
            if (i == 0) {
              jSlider.setEnabled(true);
            }

            BoundedRangeModel model = jSlider.getModel();

            if(checker2){
              model.setRangeProperties(result3, 0, 0, 1000, false);
            } else {
              model.setRangeProperties(result2, 0, 0, 1000, false);
            }
            addShare(jSlider, shareList.get(i).getPrice());
            panel.repaint();
            panel.revalidate();

          }

          double totalCost = 0;
          for(int i = 0; i < shareList.size(); i ++){
            if(checker2){
              totalCost = totalCost + (shareList.get(i).getPrice() * newResult);
            } else {
              totalCost = totalCost + (shareList.get(i).getPrice() * newResult);
            }
          }

          double finalCost = totalCost/10;
          if(totalMoney - finalCost <= 0.5){
            remainingMoney = 0;
          }




          String bata = (Double.toString(totalMoney - finalCost));
          String bplitter = bata.substring(bata.indexOf("."));
          if(bplitter.length() > 2){
            bplitter = bplitter.substring(0, 2);
          }
          bata = bata.substring(0, bata.indexOf(".")) + bplitter;

          if(bata.equals("0.1")){
            bata = "0.0";
          }
          textField7.setText(bata);


          if(checker2){
            v1 = result3;
            v2 = result3;
            v3 = result3;
            v4 = result3;
            v5 = result3;


            d1 = Double.parseDouble(forTextField);
            d2 = Double.parseDouble(forTextField);
            d3 = Double.parseDouble(forTextField);
            d4 = Double.parseDouble(forTextField);
            d5 = Double.parseDouble(forTextField);




          } else {
            v1 = result2;
            v2 = result2;
            v3 = result2;
            v4 = result2;
            v5 = result2;

            d1 = Double.parseDouble(forTextField);
            d2 = Double.parseDouble(forTextField);
            d3 = Double.parseDouble(forTextField);
            d4 = Double.parseDouble(forTextField);
            d5 = Double.parseDouble(forTextField);


          }


          textField.setText("Units of security #"  + 1 + " = " + forTextField);
          textField2.setText("Units of security #" + 2 + " = " + forTextField);
          textField3.setText("Units of security #" + 3 + " = " + forTextField);
          textField4.setText("Units of security #" + 4 + " = " + forTextField);
          textField5.setText("Units of security #" + 5 + " = " + forTextField);


          check = true;
          check2 = true;
          check3 = true;
          check4 = true;
          check5 = true;
          check6 = true;
          check7 = true;


        }
      }

    };


    textFieldUsedtobePanel5.addActionListener(actionListener5);




    changelistener = new ChangeListener() {
      public void stateChanged(ChangeEvent event) {
        JSlider source = (JSlider) event.getSource();
        int allocation2 = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent())) *10;
        if (!source.getValueIsAdjusting()) {
          int value = source.getValue();
          int cost = 0;
          int price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

          Double valueD = Double.parseDouble(Integer.toString(source.getValue()));
          String name = source.getName();

          if (name.equals("1")) {
            setSliders(source);
            v1 = value;
            double equal = (double) source.getValue() / 10;
            textField.setText("Units of security #" + source.getName() + " = " + Double.toString(equal));

            cost = v1 * price;  //remaining money bug is here
            remainingMoney = remainingMoney - cost;

            Share share1 = new Share(shareList.get(Integer.parseInt(source.getName()) -1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
            shareList.remove(0);
            shareList.add(0, share1);
            int temp = shareList.get(Integer.parseInt(name)).getPrice();
            int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
            JSlider s = formatSlider2(temp, temp2);
            BoundedRangeModel model = s.getModel();


            if (remainingMoney < temp) {
              //value, extent (max-numinput),min, max
              model.setRangeProperties(0, allocation2, 0, 1000, false);
            } else if ((remainingMoney / temp) > v1) {
              model.setRangeProperties(v1,allocation2-(v1), 0, 1000, false);

            } else {
              model.setRangeProperties(remainingMoney/temp, allocation2 - (remainingMoney / temp), 0, 1000, false);

            }

            int tempForTextField = allocation2 - cost;
            //look here

            //     textFieldUsedtobePanel5.setText(Double.toString(equal * (cost/100)));
            int tempForRemainingMoneyTextField = tempForTextField;
            //         textField7.setText(Integer.toString(tempForRemainingMoneyTextField));

            remainingAlloc.setText("Security #" + name + " = " + "");


            panel.removeAll();
            addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
            addShare(s, temp);
            if(resetPressed){
              recreate2((Integer.parseInt(name)), 1000 - v1);

            }
            else {
              recreate((Integer.parseInt(name)), 1000 - v1);

            }

            panel.revalidate();
            panel.repaint();
            s1 = source;
            s1Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();
            check = true;
            check6 = true;


            source.setEnabled(false);

          }
          if (name.equals("2")) {
            v2 = value;
            double equal = (double) source.getValue() / 10;
            textField2.setText("Units of security #" + source.getName() + " = " + Double.toString(equal));
            cost = v2 * price;

            remainingMoney = remainingMoney -cost;

            Share share2 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
            shareList.remove(1);
            shareList.add(1, share2);
            setSliders(source);

            int temp = shareList.get(Integer.parseInt(name)).getPrice();
            int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
            JSlider s = formatSlider2(temp, temp2);
            BoundedRangeModel model = s.getModel();
            if(remainingMoney < temp){
              //value, extent (max-numinput),min, max
              model.setRangeProperties(0,allocation2,0, 1000, false);
            }
            else if(remainingMoney/temp > v2){
              model.setRangeProperties(v2, allocation2 - v2, 0, 1000, false);
            }
            else{
              model.setRangeProperties(remainingMoney/temp, allocation2 - (remainingMoney / temp), 0, 1000, false);

            }

            double tempForTextField = Double.parseDouble(textField7.getText()) - cost;
            //  double tempV = Double.parseDouble(textFieldUsedtobePanel5.getText()) + (equal * (cost/100));


            // textFieldUsedtobePanel5.setText(Double.toString(tempV));
            double tempForRemainingMoneyTextField = tempForTextField;
            //                    textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
            remainingAlloc.setText("Security #" + name + " = " + "");

            panel.removeAll();
            addShare(s1, s1Price);
            addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
            addShare(s,temp);
            if(resetPressed){
              recreate2((Integer.parseInt(name)), 100 - v1 - v2);
            }
            else {
              recreate((Integer.parseInt(name)), 100 - v1 - v2);
            }

            panel.revalidate();
            panel.repaint();
            s2 =source;
            s2Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

            check2 = true;
            source.setEnabled(false);
          }
          if (name.equals("3")) {
            v3 = value;
            double equal = (double) source.getValue() / 10;
            cost = cost + v3 * price;
            remainingMoney = remainingMoney -cost;
            textField3.setText("Units of security #" + source.getName() + " = " + Double.toString(equal));
            Share share3 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
            shareList.remove(2);
            shareList.add(2, share3);
            setSliders(source);

            int temp = shareList.get(Integer.parseInt(name)).getPrice();
            int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
            JSlider s = formatSlider2(temp, temp2);
            BoundedRangeModel model = s.getModel();

            if(remainingMoney < temp){
              //value, extent (max-numinput),min, max
              model.setRangeProperties(0,allocation2,0, 1000, false);
            }
            else if(remainingMoney/temp > v3){
              model.setRangeProperties(v3, allocation2 - v3, 0, 1000, false);
            }
            else{
              model.setRangeProperties(remainingMoney/temp, (allocation2 - remainingMoney/temp), 0, 1000, false);

            }


            double tempForTextField = Double.parseDouble(textField7.getText()) - cost;
            //    double tempV = Double.parseDouble(textFieldUsedtobePanel5.getText()) + (equal * (cost/100));


            //   textFieldUsedtobePanel5.setText(Double.toString(tempV));
            double tempForRemainingMoneyTextField = tempForTextField;
            //                    textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
            remainingAlloc.setText("Security #" + name + " = " + "");
            panel.removeAll();
            addShare(s1, s1Price);
            addShare(s2, s2Price);
            addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
            addShare(s,temp);
            if(resetPressed){
              recreate2((Integer.parseInt(name)), 100 - v1 - v2 - v3);
            }
            else {
              recreate((Integer.parseInt(name)), 100 - v1 - v2 - v3);
            }

            panel.revalidate();
            panel.repaint();
            s3 =source;
            s3Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

            check3 = true;
            source.setEnabled(false);
          }
          if (name.equals("4")) {
            v4 = value;
            double equal = (double) source.getValue() / 10;
            cost = cost + v4 * price;
            remainingMoney = remainingMoney -cost;
            textField4.setText("Units of security #" + source.getName() + " = " + Double.toString(equal));
            Share share4 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
            shareList.remove(3);
            shareList.add(3, share4);
            setSliders(source);

            int temp = shareList.get(Integer.parseInt(name)).getPrice();
            int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
            JSlider s = formatSlider2(temp, temp2);
            BoundedRangeModel model = s.getModel();

            if(remainingMoney < temp){
              //value, extent (max-numinput),min, max
              model.setRangeProperties(0,allocation2,0, 1000, false);
            }
            else if(remainingMoney/temp > v4){
              model.setRangeProperties(v4, allocation2 - v4, 0, 1000, false);
            }
            else{
              model.setRangeProperties(remainingMoney/temp, (allocation2 - remainingMoney/temp), 0, 1000, false);

            }

            double tempForTextField = Double.parseDouble(textField7.getText()) - cost;
            //       double tempV = Double.parseDouble(textFieldUsedtobePanel5.getText()) + (equal *(cost/100));



            //    textFieldUsedtobePanel5.setText(Double.toString(tempV));
            double tempForRemainingMoneyTextField = tempForTextField;
            //                     textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
            remainingAlloc.setText("Security #" + name + " = " + "");

            panel.removeAll();
            addShare(s1, s1Price);
            addShare(s2, s2Price);
            addShare(s3, s3Price);
            addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
            addShare(s,temp);
            if(resetPressed){
              recreate2((Integer.parseInt(name)), 100 - v1 - v2 - v3 - v4);
            }
            else {
              recreate((Integer.parseInt(name)), 100 - v1 - v2 - v3 - v4);
            }

            panel.revalidate();
            panel.repaint();
            s4 =source;
            s4Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

            check4 = true;
            source.setEnabled(false);
          }
          if (name.equals("5")) {
            v5 = value;
            double equal = (double) source.getValue() / 10;
            cost = cost + v5 * price;
            remainingMoney = remainingMoney -cost;
            textField5.setText("Units of security #" + source.getName() + " = " + Double.toString(equal));
            Share share5 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
            shareList.remove(4);
            shareList.add(4, share5);
            setSliders(source);

            double tempForTextField = Double.parseDouble(textField7.getText()) - cost;
            //      double tempV = Double.parseDouble(textFieldUsedtobePanel5.getText()) + (equal * (cost/100));

            //     textFieldUsedtobePanel5.setText(Double.toString(tempV));
            double tempForRemainingMoneyTextField = tempForTextField;
            //                       textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
            remainingAlloc.setText("Security #" + name + " = " + "");
            check5 = true;
            source.setEnabled(false);

            panel.revalidate();
            panel.repaint();
          }
        }

      }
    };

    changelistener2 = new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (source.getValueIsAdjusting()){


          double equal = (double) source.getValue() / 10;

          valueAdjust.setText("Value = " + Double.toString(equal));
          double temp2 = (equal  *   shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
//          if(temp2 > allocation / 10) {
//            textFieldUsedtobePanel5.setText("WARNING: You cannot afford this allocation");
//          } else{
//            textFieldUsedtobePanel5.setText("");
//          }

          double temp3 = (remainingMoney/10) - temp2;


          if(temp3 < 0){
            temp3 = 0;
          }
          String data = Double.toString(temp3);
          String splitter = data.substring(data.indexOf("."));

          if(splitter.length() > 2){
            splitter = splitter.substring(0, 2);
          }

          data = data.substring(0, data.indexOf(".")) + splitter;



          String data2 = Double.toString(temp2);
          String splitter2 = data2.substring(data2.indexOf("."));

          if(splitter2.length() > 2){
            splitter2 = splitter2.substring(0, 3);
          }


          data2 = data2.substring(0, data2.indexOf(".")) + splitter2;
          textField7.setText(data);
          remainingAlloc.setText("Security #" + source.getName() + " = " + data2);
        }

      }
    };





    //File stuffz




    action = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        if (redirect) {
          remainingMoney = 0;
          check6 = true;
        }
        //check if check allocations button is cleared, if it isnt cleared throw an error
        if (!check6) {
          JOptionPane.showMessageDialog(null, "Please correct allocations", "Error", JOptionPane.ERROR_MESSAGE);
          return;
        }

        if (remainingMoney > 9) {
          System.out.println("remains " + remainingMoney);
          JOptionPane.showMessageDialog(null, "You did not use all your money. Please correct allocations", "Error", JOptionPane.ERROR_MESSAGE);

          return;
        }

        int result = JOptionPane.showConfirmDialog(null,
            "Confirm Choices?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (result != 0) {
          return;
        }


        anotherShareList = new ArrayList<Share>(shareList.size());

        if (check7) {
          if (shareList.size() == 1) {
            Share share = new Share(shareList.get(0).getPrice(), 1, d1);
            anotherShareList.add(share);


          } }else {

          if (shareList.size() == 1) {
            Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1 / 10)));
            anotherShareList.add(share);

          }
        }



        if (check7) {
          if (shareList.size() == 2) {
            Share share = new Share(shareList.get(0).getPrice(), 1, d1);
            anotherShareList.add(share);
            Share share2 = new Share(shareList.get(1).getPrice(), 2, d2);
            anotherShareList.add(share2);


          }} else {

          if (shareList.size() == 2) {
            Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1 / 10)));
            anotherShareList.add(share);
            Share share2 = new Share(shareList.get(1).getPrice(), 2, Double.parseDouble(Integer.toString(v2 / 10)));
            anotherShareList.add(share2);


          }
        }



        if (check7) {
          if (shareList.size() == 3) {
            Share share = new Share(shareList.get(0).getPrice(), 1, d1);
            anotherShareList.add(share);
            Share share2 = new Share(shareList.get(1).getPrice(), 2, d2);
            anotherShareList.add(share2);
            Share share3 = new Share(shareList.get(2).getPrice(), 3, d3);
            anotherShareList.add(share3);


          }
        } else {

          if (shareList.size() == 3) {
            Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1 / 10)));
            anotherShareList.add(share);
            Share share2 = new Share(shareList.get(1).getPrice(), 2, Double.parseDouble(Integer.toString(v2 / 10)));
            anotherShareList.add(share2);
            Share share3 = new Share(shareList.get(2).getPrice(), 3, Double.parseDouble(Integer.toString(v3 / 10)));
            anotherShareList.add(share3);

          }
        }



        if (check7) {
          if (shareList.size() == 4) {
            Share share = new Share(shareList.get(0).getPrice(), 1, d1);
            anotherShareList.add(share);
            Share share2 = new Share(shareList.get(1).getPrice(), 2,d2);
            anotherShareList.add(share2);
            Share share3 = new Share(shareList.get(2).getPrice(), 3, d3);
            anotherShareList.add(share3);
            Share share4 = new Share(shareList.get(3).getPrice(), 4, d4);
            anotherShareList.add(share4);


          }
        } else {
          if (shareList.size() == 4) {
            Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1 / 10)));
            anotherShareList.add(share);
            Share share2 = new Share(shareList.get(1).getPrice(), 2, Double.parseDouble(Integer.toString(v2 / 10)));
            anotherShareList.add(share2);
            Share share3 = new Share(shareList.get(2).getPrice(), 3, Double.parseDouble(Integer.toString(v3 / 10)));
            anotherShareList.add(share3);
            Share share4 = new Share(shareList.get(3).getPrice(), 4, Double.parseDouble(Integer.toString(v4 / 10)));
            anotherShareList.add(share4);


          }
        }

        if(check7) {
          if (shareList.size() == 5) {
            Share share = new Share(shareList.get(0).getPrice(), 1, d1);
            anotherShareList.add(share);
            Share share2 = new Share(shareList.get(1).getPrice(), 2, d2);
            anotherShareList.add(share2);
            Share share3 = new Share(shareList.get(2).getPrice(), 3, d3);
            anotherShareList.add(share3);
            Share share4 = new Share(shareList.get(3).getPrice(), 4, d4);
            anotherShareList.add(share4);
            Share share5 = new Share(shareList.get(4).getPrice(), 5, d5);
            anotherShareList.add(share5);


          }
        } else {



          if (shareList.size() == 5) {
            Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1 / 10)));
            anotherShareList.add(share);
            Share share2 = new Share(shareList.get(1).getPrice(), 2, Double.parseDouble(Integer.toString(v2 / 10)));
            anotherShareList.add(share2);
            Share share3 = new Share(shareList.get(2).getPrice(), 3, Double.parseDouble(Integer.toString(v3 / 10)));
            anotherShareList.add(share3);
            Share share4 = new Share(shareList.get(3).getPrice(), 4, Double.parseDouble(Integer.toString(v4 / 10)));
            anotherShareList.add(share4);
            Share share5 = new Share(shareList.get(4).getPrice(), 5, Double.parseDouble(Integer.toString(v5 / 10)));
            anotherShareList.add(share5);


          }
        }

          phase1TestRounds.this.setVisible(false);
          phase1TestRounds.this.dispose();
          test = new testClass(curSysProp+1);

          if(test.getCurrent() == 5) {

            JOptionPane.showMessageDialog(null, "That concludes the test rounds. The next window represents the first round of the experiment, good luck!");

            params = new parameters();
            testClass test = new testClass(1);
            //uncomment slider to run from stage2 and uncomment phase1 to run from phase1
            // sliderInterface frame = new sliderInterface(params.getSecurityList(), test.getCurrent(), false, false, false, false, 0, 0.0);
            phase1 frame = new phase1(params.getSecurityList(), test.getCurrent());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);

          }
          else {


            phase1TestRounds phases = new phase1TestRounds(anotherShareList, test.getCurrent());

            phases.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            phases.setVisible(true);

          }

        }


    };


    button1.addActionListener(action);


    for (int i = 0; i < shareList.size(); i++) {
      int priceofsecurity = shareList.get(i).getPrice();
      JSlider jSlider = formatSlider(shareList.get(i).getPrice(), shareList.get(i).getSecurityNumber());

      jSlider.setEnabled(false);
      if(i == 0){
        jSlider.setEnabled(true);
      }

      BoundedRangeModel model = jSlider.getModel();
      model.setRangeProperties(0,0,0,1000,false);
      addShare(jSlider, shareList.get(i).getPrice());
    }

    if(test.getCurrent() == 1) {
      JOptionPane.showMessageDialog(null, "The next four rounds are test rounds. The allocations submitted will not be saved. Feel free to practice using the interface, you will be notified before the real rounds begin");
    }


  }




  public void recreate(int num, int limit){
    int t = shareList.size();
    for (int i = num + 1; i < t ; i++) {
      JSlider sl = formatSlider2(shareList.get(i).getPrice(), i + 1);
      sl.setEnabled(false);
      BoundedRangeModel model = sl.getModel();
      //value, extent, min max
      model.setRangeProperties(0,limit,0,1000,false);
      addShare(sl, shareList.get(i - 1).getPrice());
    }
  }

  public void recreate2(int num, int limit){
    int t = shareList.size();
    for (int i = num+1; i < t; i++) {

      JSlider sl = formatSlider2(shareList.get(i).getPrice(), i + 1);
      sl.setEnabled(false);
      BoundedRangeModel model = sl.getModel();
      //value, extent, min max
      if(i==2){
        model.setRangeProperties(m3,limit,0,1000,false);
      }
      if(i==3){
        model.setRangeProperties(m4,limit,0,1000,false);
      }
      if(i==4){
        model.setRangeProperties(m5,limit,0,1000,false);
      }
      addShare(sl, shareList.get(i -1).getPrice());
    }
  }




  public double equalAlgo(int numberOfAssets, int totalMoney, int[] prices){
    double sum = 0;
    for(int price: prices){
      sum = sum + price;

    }
    double averagePrice = sum / numberOfAssets;
    double itemTotal = totalMoney / averagePrice;
    double result = itemTotal / numberOfAssets;

    return result;
  }



  public void addShare(JSlider slider, int price) {
    slider.addChangeListener(changelistener);
    slider.addChangeListener(changelistener2);
    slider.addChangeListener(changeListener5);
    JPanel pan = new JPanel();
    pan.setLayout(new GridLayout(1,1,5,5));
    pan.add(slider);


    panel.add(pan);

  }

  public JSlider formatSlider(int price, int number) {
    JSlider slider = new JSlider(JSlider.VERTICAL);
    BoundedRangeModel model = slider.getModel();
    model.setRangeProperties(0,1,0,1000,false);
    slider.setName(Integer.toString(number));
    slider.setPaintTicks(true);
    slider.setMajorTickSpacing(10);
    slider.setMinorTickSpacing(2);
    slider.setPreferredSize(new Dimension(100, 350));
    slider.setBorder(new TitledBorder("Security " + Integer.toString(number) + " | Price = " + price));
    slider.setPaintLabels(true);
    java.util.Hashtable<Integer, JLabel> labelTable = new java.util.Hashtable<Integer, JLabel>();
    labelTable.put(new Integer(1000), new JLabel("100"));
    labelTable.put(new Integer(800), new JLabel("80"));
    labelTable.put(new Integer(600), new JLabel("60"));
    labelTable.put(new Integer(400), new JLabel("40"));
    labelTable.put(new Integer(200), new JLabel("20"));
    labelTable.put(new Integer(0), new JLabel("0"));
    slider.setLabelTable(labelTable);

    // slider.add(new JLabel(Integer.toString(price)));
    return slider;

  }


  public JSlider formatSlider2(int price, int number) {
    JSlider slider = new JSlider(JSlider.VERTICAL);
    BoundedRangeModel model = slider.getModel();
    model.setRangeProperties(0,1,0,1000,false);
    slider.setName(Integer.toString(number));
    slider.setPaintTicks(true);
    slider.setMajorTickSpacing(10);
    slider.setMinorTickSpacing(2);
    slider.setPreferredSize(new Dimension(100, 350));
    slider.setBorder(new TitledBorder("Security " + Integer.toString(number) + " | Price = " + price));
    slider.setPaintLabels(true);
    java.util.Hashtable<Integer, JLabel> labelTable = new java.util.Hashtable<Integer, JLabel>();
    labelTable.put(new Integer(1000), new JLabel("100"));
    labelTable.put(new Integer(800), new JLabel("80"));
    labelTable.put(new Integer(600), new JLabel("60"));
    labelTable.put(new Integer(400), new JLabel("40"));
    labelTable.put(new Integer(200), new JLabel("20"));
    labelTable.put(new Integer(0), new JLabel("0"));
    slider.setLabelTable(labelTable);

    // slider.add(new JLabel(Integer.toString(price)));
    return slider;

  }


  public int remainingIncome(int allocation, int value, int price) {
    float v = (float) value / 100;
    setTotal(allocation - v * price);
    return allocation - value * price;
  }


  public void setTotal(float remains) {
    float temp = Math.round(remains);
    int r = (int) temp;
    total = r;
  }

  public int getTotal() {
    return total;
  }


  public void error(ActionEvent e) {
    JOptionPane.showMessageDialog(null, "Please complete allocations", "Error", JOptionPane.ERROR_MESSAGE);
  }


  public void setSliders(JSlider slid) {
    if(sliders.isEmpty()){
      sliders.add(slid);
      return;
    }
    if(sliders.contains(slid)){
      for(int i = 0; i < sliders.size(); i++){
        if((sliders.get(i).getName()) == slid.getName()){
          sliders.remove(sliders.get(i));
          sliders.add(i, slid);
          return;
        }
      }
    }
    else{
      sliders.add(slid);
      for(int i = sliders.size()-1; i > 0; i--){
        if((Integer.parseInt(sliders.get(i).getName())) < (Integer.parseInt(sliders.get(i-1).getName()))){
          swapSliders(i, i-1);
        }
      }
    }

  }

  public void swapSliders(int pos1, int pos2){
    JSlider tempSlid;
    JSlider tempSlid2;
    tempSlid = sliders.get(pos1);
    tempSlid2 = sliders.get(pos2);
    sliders.remove(sliders.get(pos1));
    sliders.add(pos1, tempSlid2);
    sliders.remove(sliders.get(pos2));
    sliders.add(pos2, tempSlid);
  }

  public java.util.List<JSlider> getSliders() {
    return sliders;
  }






  public static void main(String[] args) throws Exception {
    params = new parameters();

    EventQueue.invokeLater(new Runnable() {
      public void run() {
        // openingPage open = new openingPage();
        //open.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // open.setVisible(true);


        testClass test = new testClass(1);
        //uncomment slider to run from stage2 and uncomment phase1 to run from phase1
        // sliderInterface frame = new sliderInterface(params.getSecurityList(), test.getCurrent(), false, false, false, false, 0, 0.0);
        phase1TestRounds frame = new phase1TestRounds(params.getSecurityList(), test.getCurrent());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

      }

    });
  }
















}
























