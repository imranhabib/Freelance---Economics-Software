

package project;

import test.testClass;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Imran on 2014-12-13.
 */
public class phase1 extends JFrame{

  static JSlider slider;
  static JPanel panel;
  static JPanel panel2;
  static JTextField valueAdjust;
  static JPanel panel3;
  static JPanel panel4;
  static JTextField textFieldUsedtobePanel5;
  static JTextField textFieldUsedtobePanel6;
  static JLabel label7;
  static JLabel label8;
  static JButton button1;
  static JTextField remainingAlloc;
  static JButton button3;
  static JButton button4;

  static JFormattedTextField sliderNumba;

  private static int valueOfSlider;

  static testClass test;

  private static List<JSlider> sliders;

  private static JTextField textField;
  private static JTextField textField2;
  private static JTextField textField3;
  private static JTextField textField4;
  private static JTextField textField5;

  private static JTextField textField6;
  private static JTextField textField7;
  private static JLabel LabelThatUsedtobeTextField8;
  private static JLabel leftoverMoney;



  static JLabel empty1;
  static JLabel empty2;
  static JLabel empty3;
  static JLabel empty4;

  private static ChangeListener changelistener;
  private static ChangeListener changelistener2;
  private static ChangeListener changelistener3;
  private static ActionListener Actionlistener4;
  private static ActionListener actionListener5;
  private static ActionListener action;



  private static boolean check;
  private static boolean check2;
  private static boolean check3;
  private static boolean check4;
  private static boolean check5;
  private static boolean check6;

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

  static List<Share> anotherShareList;

  static int remainingMoney;

  //file stuffz

  String filename = "output.csv";
  String filename1 = "Phase1priceSet1.csv";
  String filename2 = "Phase1priceSet2.csv";
  String filename3 = "Phase1priceSet3.csv";
  String filename4 = "Phase1priceSet4.csv";
  String filename6 = "Phase1priceSet6.csv";
  String filename7 = "Phase1priceSet7.csv";
  String filename8 = "Phase1priceSet8.csv";
  String filename9 = "Phase1priceSet9.csv";
  String filename10 = "Phase1priceSet10.csv";
  String filename5 = "Phase1priceSet5.csv";
  String directory = System.getProperty("user.home") + "/Desktop/output";

  File file;
  File file1;
  File file2;
  File file3;
  File file4;
  File file5;
  File file6;
  File file7;
  File file8;
  File file9;
  File file10;

  FileWriter filer;
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


  public phase1(final List<Share> shares, int cur) {
    curSysProp = cur;
    test = new testClass();
    setLayout(new BorderLayout());
    setTitle("Stage 1");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(0, 0, screenSize.width, screenSize.height - 45);

    raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
    loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);


    checkNew = false;

    shareList = shares;




    total = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent()));
    n = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("securityAmount" + test.getCurrent()));

    int size = shares.size();
    panel2 = new JPanel();

    allocation = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent()));

    panel2.setLayout(new BorderLayout(5, 10));

    panel = new JPanel();
    panel.setLayout(new GridLayout(0, shares.size()));
    panel.setPreferredSize(new Dimension(500, 500));
    panel.setBorder(new TitledBorder("Allocations"));

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

    shareList = param.getSecurityListWithEmptyIncomeShares();
    //param.getArgMaxFormula(2, shareList);



    button3 = new JButton("Reset Allocations");


    Actionlistener4 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        panel.removeAll();
        for (int i = 0; i < shares.size(); i++) {
          int priceofsecurity = shareList.get(i).getPrice();
          JSlider jSlider = formatSlider(shares.get(i).getPrice(), shares.get(i).getSecurityNumber());
          BoundedRangeModel model = jSlider.getModel();
          model.setRangeProperties(0,0,0,allocation/priceofsecurity,false);
          addShare(jSlider, shares.get(i).getPrice());
        }
        textField.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textFieldUsedtobePanel5.setText(Integer.toString(0));
        textField7.setText(Integer.toString(allocation));
        remainingAlloc.setText("");
        valueAdjust.setText("Value = ");
        panel.revalidate();
        panel.repaint();
      }
    };

    actionListener5 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(remainingMoney == 0){
          JOptionPane.showMessageDialog(null, "Task is impossible because there is no remaining money to be allocated",
              "Error", JOptionPane.ERROR_MESSAGE
          );
          button4.setEnabled(false);
          button4.setVisible(false);
          return;
        }
        else if(remainingMoney < shareList.get(0).getPrice()){
          JOptionPane.showMessageDialog(null, "There is not enough money to buy the least expensive security" + "\n" + "Click Reset Allocations and start all over",
              "Error", JOptionPane.ERROR_MESSAGE
          );
          button4.setEnabled(false);
          button4.setVisible(false);
          return;
        }
        int secnum=0;
        double rem=0;
        boolean canAllocate = false;
        for(int i=0; i<shareList.size(); i++){
          int temp = shareList.get(i).getPrice();
          if((remainingMoney%temp) == 0){
            rem = remainingMoney/temp;
            secnum = i;
            canAllocate = true;
            break;
          }
        }
        if(canAllocate){
          int price = shareList.get(secnum).getPrice();
          int nu = shareList.get(secnum).getSecurityNumber();
          double a = shareList.get(secnum).getAllocation() + rem;
          shareList.remove(secnum);
          shareList.add(new Share(price,nu,a));
          textFieldUsedtobePanel5.setText((ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent())));
          textField7.setText(Integer.toString(0));
          if(nu == 1){
            String temp = Double.toString(a);
            temp = temp.substring(0,temp.indexOf("."));
            v1= (Integer.parseInt(temp));
            textField.setText("Units of Security #1 = " + a);
          }
          if(nu == 2){
            String temp = Double.toString(a);
            temp = temp.substring(0,temp.indexOf("."));
            v2= (Integer.parseInt(temp));
            textField2.setText("Units of Security #2 = " + a);
          }
          if(nu == 3){
            String temp = Double.toString(a);
            temp = temp.substring(0,temp.indexOf("."));
            v3= (Integer.parseInt(temp));
            textField3.setText("Units of Security #3 = " + a);
          }
          if(nu == 4){
            String temp = Double.toString(a);
            temp = temp.substring(0,temp.indexOf("."));
            v4= (Integer.parseInt(temp));
            textField4.setText("Units of Security #4 = " + a);
          }
          if(nu == 5){
            String temp = Double.toString(a);
            temp = temp.substring(0,temp.indexOf("."));
            v5= (Integer.parseInt(temp));
            textField5.setText("Units of Security #5 = " + a);
          }
          button4.setEnabled(false);
          button4.setVisible(false);
        }
        else{
          JOptionPane.showMessageDialog(null, "Remaining money could not be allocated to one security entirely without remainders" + "\n" + "Click Reset Allocations and start all over",
              "Error", JOptionPane.ERROR_MESSAGE
          );
          button4.setEnabled(false);
          button4.setVisible(false);
        }

        //popup message
      }

      //allocated successfully to security n

    };


    button3.addActionListener(Actionlistener4);
    button4 = new JButton("Click to automatically allocate remaining money");
    button4.addActionListener(actionListener5);
    button4.setVisible(false);
    button4.setEnabled(false);
    NumberFormat format = NumberFormat.getInstance();
    format.setMaximumIntegerDigits(1);
    sliderNumba = new JFormattedTextField(format);

    remainingAlloc = new JTextField();
    remainingAlloc.setEditable(false);
    remainingAlloc.setBorder(new TitledBorder(raisedBorder, "Cost of the currently selected security"));
    remainingAlloc.setFont(new Font("Calibri", Font.BOLD, 15));

    leftoverMoney = new JLabel("Clicking the button will assign the remaining money to the least expensive security if possible");
    leftoverMoney.setBorder(raisedBorder);
    leftoverMoney.setEnabled(false);
    leftoverMoney.setVisible(false);
    LabelThatUsedtobeTextField8 = new JLabel("Remaining Money");
    LabelThatUsedtobeTextField8.setBorder(raisedBorder);
    LabelThatUsedtobeTextField8.setFont(new Font("Calibri", Font.BOLD, 15));

    valueAdjust = new JTextField();
    valueAdjust.setBorder(raisedBorder);
    valueAdjust.setFont(new Font("Calibri", Font.BOLD, 15));
    valueAdjust.setText("Value = ");


    textField7 = new JTextField();
    textField7.setPreferredSize(new Dimension(30, 25));
    textField7.setText(Integer.toString(allocation));
    textField7.setEditable(false);
    textField7.setBorder(loweredBorder);
    textField7.setFont(new Font("Calibri", Font.BOLD, 15));

    label7 = new JLabel("Currently Allocated");
    label7.setBorder(raisedBorder);
    label7.setFont(new Font("Calibri", Font.BOLD, 15));




    textFieldUsedtobePanel6 = new JTextField();
    textFieldUsedtobePanel6.setText(Integer.toString(allocation));
    textFieldUsedtobePanel6.setBorder(loweredBorder);
    textFieldUsedtobePanel6.setFont(new Font("Calibri", Font.BOLD, 15));
    textFieldUsedtobePanel6.setEditable(false);

    label8 = new JLabel("Total Money");
    label8.setBorder(raisedBorder);
    label8.setFont(new Font("Calibri", Font.BOLD, 15));

    empty1 = new JLabel();
    empty2 = new JLabel();
    empty3 = new JLabel();
    empty4 = new JLabel();



    textFieldUsedtobePanel5 = new JTextField();
    textFieldUsedtobePanel5.setText(Integer.toString(0));
    textFieldUsedtobePanel5.setBorder(loweredBorder);
    textFieldUsedtobePanel5.setFont(new Font("Calibri", Font.BOLD, 15));
    textFieldUsedtobePanel5.setEditable(false);

    panel4 = new JPanel();
    panel4.setLayout(new GridLayout(5,3,5,5));
    panel4.setBorder(new TitledBorder(raisedBorder, "Allocation"));
    //add 3 things
    panel4.add(leftoverMoney);
    panel4.add(button4);
    panel4.add(empty4);


    panel4.add(valueAdjust);
    panel4.add(button3);
    panel4.add(remainingAlloc);
    panel4.add(label8);
    panel4.add(textFieldUsedtobePanel6);
    panel4.add(empty1);
    panel4.add(label7);
    panel4.add(textFieldUsedtobePanel5);
    panel4.add(empty2);
    panel4.add(LabelThatUsedtobeTextField8);
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
    splitPane.setResizeWeight(.99);


    button1 = new JButton("Submit");
    button1.setToolTipText("Click to submit input selection");
    button1.setBorder(new TitledBorder("Move on"));


    sliders = new ArrayList<JSlider>();


    //you can change the first SOUTH -> NORTH && the first CENTER -> SOUTH to get a different spacing/sizing

    panel2.add(splitPane, BorderLayout.CENTER);
    panel2.add(panel3, BorderLayout.NORTH);
    panel2.add(button1, BorderLayout.SOUTH);
    add(panel2, BorderLayout.CENTER);


    check = false;
    check2 = false;
    check3 = false;
    check4 = false;
    check5 = false;
    check6 = false;



    changelistener = new ChangeListener() {
      public void stateChanged(ChangeEvent event) {
        JSlider source = (JSlider) event.getSource();
        int allocation2 = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent()));
        if (!source.getValueIsAdjusting()) {
          int value = source.getValue();
          int cost = 0;
          int price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

          Double valueD = Double.parseDouble(Integer.toString(source.getValue()));
          String name = source.getName();

          if (name.equals("1")) {
            setSliders(source);
            v1 = value;
            textField.setText("Units of security #" + source.getName() + " = " + value);

            cost = v1 * price;
            remainingMoney = allocation2-cost;

            Share share1 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
            shareList.remove(0);
            shareList.add(0, share1);
            int temp = shareList.get(Integer.parseInt(name)).getPrice();
            int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
            JSlider s = formatSlider(temp, temp2);
            BoundedRangeModel model = s.getModel();

            if((allocation2 - cost) < temp){
              model.setRangeProperties(0,allocation2/temp,0, allocation2/temp, false);
              textField2.setText("Units of security #" + s.getName() + " = " + v1);
            }
            else{
              model.setRangeProperties(0,((allocation2/temp) -(remainingIncome(allocation2,v1, price)/temp)), 0, allocation2/temp, false);
            }
            int tempForTextField = allocation2 - cost;
            textFieldUsedtobePanel5.setText(Integer.toString(cost));
            int tempForRemainingMoneyTextField = tempForTextField;
            textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
            remainingAlloc.setText("Security #" + name + " = " + cost);


            System.out.println((Integer.parseInt(name)));
            panel.removeAll();
            addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
            addShare(s,temp);
            recreate((Integer.parseInt(name)), 100-v1);
            panel.revalidate();
            panel.repaint();
            s1 =source;
            s1Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();
            check = true;
            check6 = true;
            source.setEnabled(false);
            //using getName to store the price of the security
          }
          if (name.equals("2")) {
            v2 = value;
            textField2.setText("Units of security #" + source.getName() + " = " + value);
            cost = v2 * price;
            remainingMoney = remainingMoney -cost;
            System.out.println("This is the cost = " + cost);
            System.out.println("This is the price = " + price);
            Share share2 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
            shareList.remove(1);
            shareList.add(1, share2);
            setSliders(source);

            int temp = shareList.get(Integer.parseInt(name)).getPrice();
            int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
            JSlider s = formatSlider(temp, temp2);
            BoundedRangeModel model = s.getModel();
            if(remainingMoney < temp){
              model.setRangeProperties(0,allocation2/temp,0, allocation2/temp, false);

            }
            else {
              model.setRangeProperties(0, ((allocation2/temp)-(remainingMoney/temp)), 0, allocation2/temp, false);
            }

            int tempForTextField = Integer.parseInt(textField7.getText()) - cost;
            int tempV = Integer.parseInt(textFieldUsedtobePanel5.getText()) + cost;

            textFieldUsedtobePanel5.setText(Integer.toString(tempV));
            int tempForRemainingMoneyTextField = tempForTextField;
            textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
            remainingAlloc.setText("Security #" + name + " = " + cost);



            System.out.println((Integer.parseInt(name)));
            panel.removeAll();
            addShare(s1, s1Price);
            addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
            addShare(s,temp);
            recreate((Integer.parseInt(name)), 100-v1-v2);
            panel.revalidate();
            panel.repaint();
            s2 =source;
            s2Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

            check2 = true;
            source.setEnabled(false);
          }
          if (name.equals("3")) {
            v3 = value;
            cost = cost + v3 * price;
            remainingMoney = remainingMoney -cost;
            System.out.println("This is the cost = " + cost);
            System.out.println("This is the price = " + price);
            textField3.setText("Units of security #" + source.getName() + " = " + value);
            Share share3 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
            shareList.remove(2);
            shareList.add(2, share3);
            setSliders(source);

            int temp = shareList.get(Integer.parseInt(name)).getPrice();
            int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
            JSlider s = formatSlider(temp, temp2);
            BoundedRangeModel model = s.getModel();

            if(remainingMoney < temp){
              model.setRangeProperties(0,allocation2/temp,0, allocation2/temp, false);

            }
            else {
              model.setRangeProperties(0, ((allocation2/temp)-(remainingMoney/temp)), 0, allocation2/temp, false);
            }


            int tempForTextField = Integer.parseInt(textField7.getText()) - cost;
            int tempV = Integer.parseInt(textFieldUsedtobePanel5.getText()) + cost;

            textFieldUsedtobePanel5.setText(Integer.toString(tempV));
            int tempForRemainingMoneyTextField = tempForTextField;
            textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
            remainingAlloc.setText("Security #" + name + " = " + cost);


            System.out.println((Integer.parseInt(name)));
            panel.removeAll();
            addShare(s1, s1Price);
            addShare(s2, s2Price);
            addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
            addShare(s,temp);
            recreate((Integer.parseInt(name)), 100-v1-v2-v3);
            panel.revalidate();
            panel.repaint();
            s3 =source;
            s3Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

            check3 = true;
            source.setEnabled(false);
          }
          if (name.equals("4")) {
            v4 = value;
            cost = cost + v4 * price;
            remainingMoney = remainingMoney -cost;
            System.out.println("This is the cost = " + cost);
            System.out.println("This is the price = " + price);
            textField4.setText("Units of security #" + source.getName() + " = " + value);
            Share share4 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
            shareList.remove(3);
            shareList.add(3, share4);
            setSliders(source);

            int temp = shareList.get(Integer.parseInt(name)).getPrice();
            int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
            JSlider s = formatSlider(temp, temp2);
            BoundedRangeModel model = s.getModel();

            if(remainingMoney < temp){
              model.setRangeProperties(0,allocation2/temp,0, allocation2/temp, false);
            }
            else {
              model.setRangeProperties(0, ((allocation2/temp)-(remainingMoney/temp)), 0, allocation2/temp, false);
            }

            int tempForTextField = Integer.parseInt(textField7.getText()) - cost;
            int tempV = Integer.parseInt(textFieldUsedtobePanel5.getText()) + cost;

            textFieldUsedtobePanel5.setText(Integer.toString(tempV));
            int tempForRemainingMoneyTextField = tempForTextField;
            textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
            remainingAlloc.setText("Security #" + name + " = " + cost);



            System.out.println((Integer.parseInt(name)));
            panel.removeAll();
            addShare(s1, s1Price);
            addShare(s2, s2Price);
            addShare(s3, s3Price);
            addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
            addShare(s,temp);

            recreate((Integer.parseInt(name)), 100-v1-v2-v3-v4);
            panel.revalidate();
            panel.repaint();
            s4 =source;
            s4Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

            check4 = true;
            source.setEnabled(false);
          }
          if (name.equals("5")) {
            v5 = value;
            cost = cost + v5 * price;
            remainingMoney = remainingMoney -cost;
            System.out.println("This is the cost = " + cost);
            System.out.println("This is the price = " + price);
            textField5.setText("Units of security #" + source.getName() + " = " + value);
            Share share5 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
            shareList.remove(4);
            shareList.add(4, share5);
            setSliders(source);

            int tempForTextField = Integer.parseInt(textField7.getText()) - cost;
            int tempV = Integer.parseInt(textFieldUsedtobePanel5.getText()) + cost;

            textFieldUsedtobePanel5.setText(Integer.toString(tempV));
            int tempForRemainingMoneyTextField = tempForTextField;
            textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
            remainingAlloc.setText("Security #" + name + " = " + cost);


            check5 = true;
            source.setEnabled(false);
            leftoverMoney.setEnabled(true);
            leftoverMoney.setVisible(true);
            button4.setEnabled(true);
            button4.setVisible(true);
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
          valueAdjust.setText("Value = " + Integer.toString(source.getValue()));
        }
      }
    };



    //File stuffz

    file = new File(directory, filename);


    action = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        //check if check allocations button is cleared, if it isnt cleared throw an error
        if (!check6) {
          JOptionPane.showMessageDialog(null, "Please correct allocations", "Error", JOptionPane.ERROR_MESSAGE);
          return;
        }

        int result = JOptionPane.showConfirmDialog(null,
            "Confirm Choices?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (result != 0) {
          return;
        }

        anotherShareList = new ArrayList<Share>(shareList.size());

        if (shareList.size() == 1) {
          Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1)));
          anotherShareList.add(share);

        }


        if (shareList.size() == 2) {
          Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1)));
          anotherShareList.add(share);
          Share share2 = new Share(shareList.get(1).getPrice(), 2, Double.parseDouble(Integer.toString(v2)));
          anotherShareList.add(share2);


        }

        if (shareList.size() == 3) {
          Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1)));
          anotherShareList.add(share);
          Share share2 = new Share(shareList.get(1).getPrice(), 2, Double.parseDouble(Integer.toString(v2)));
          anotherShareList.add(share2);
          Share share3 = new Share(shareList.get(2).getPrice(), 3, Double.parseDouble(Integer.toString(v3)));
          anotherShareList.add(share3);


        }

        if (shareList.size() == 4) {
          Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1)));
          anotherShareList.add(share);
          Share share2 = new Share(shareList.get(1).getPrice(), 2, Double.parseDouble(Integer.toString(v2)));
          anotherShareList.add(share2);
          Share share3 = new Share(shareList.get(2).getPrice(), 3, Double.parseDouble(Integer.toString(v3)));
          anotherShareList.add(share3);
          Share share4 = new Share(shareList.get(3).getPrice(), 4, Double.parseDouble(Integer.toString(v4)));
          anotherShareList.add(share4);


        }

        if (shareList.size() == 5) {
          Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1)));
          anotherShareList.add(share);
          Share share2 = new Share(shareList.get(1).getPrice(), 2, Double.parseDouble(Integer.toString(v2)));
          anotherShareList.add(share2);
          Share share3 = new Share(shareList.get(2).getPrice(), 3, Double.parseDouble(Integer.toString(v3)));
          anotherShareList.add(share3);
          Share share4 = new Share(shareList.get(3).getPrice(), 4, Double.parseDouble(Integer.toString(v4)));
          anotherShareList.add(share4);
          Share share5 = new Share(shareList.get(4).getPrice(), 5, Double.parseDouble(Integer.toString(v5)));
          anotherShareList.add(share5);

        }


        if (!file.exists()) {
          file = new File(directory, filename);
          fileCreator(file);
        }
        if (check) {
          filer = createFileWriter(file);
          formatFile(filer);
          for (Share share : anotherShareList) {
            writeToFile(filer, share);
          }
          closeFile(filer);


          if (test.getCurrent() == 1) {


            file1 = new File(directory, filename1);
            fileCreator(file1);

            if (!file1.exists()) {
              file1 = new File(directory, filename1);
              fileCreator(file1);
            }

            filer1 = createFileWriter(file1);

            for (Share share : anotherShareList) {
              writeToFile2(filer1, share);
            }
            closeFile(filer1);


          } else if (test.getCurrent() == 2) {

            file2 = new File(directory, filename2);
            fileCreator(file2);

            if (!file2.exists()) {
              file2 = new File(directory, filename2);
              fileCreator(file2);
            }

            filer2 = createFileWriter(file2);

            for (Share share : anotherShareList) {
              writeToFile2(filer2, share);
            }
            closeFile(filer2);


          } else if (test.getCurrent() == 3) {

            file3 = new File(directory, filename3);
            fileCreator(file3);

            if (!file3.exists()) {
              file3 = new File(directory, filename3);
              fileCreator(file3);
            }

            filer3 = createFileWriter(file3);

            for (Share share : anotherShareList) {
              writeToFile2(filer3, share);
            }
            closeFile(filer3);


          } else if (test.getCurrent() == 4) {




            file4 = new File(directory, filename4);
            fileCreator(file4);

            if (!file4.exists()) {
              file4 = new File(directory, filename4);
              fileCreator(file4);
            }

            filer4 = createFileWriter(file4);

            for (Share share : anotherShareList) {
              writeToFile2(filer4, share);
            }
            closeFile(filer4);

          } else if (test.getCurrent() == 5) {


            file5 = new File(directory, filename5);
            fileCreator(file5);

            if (!file5.exists()) {
              file5 = new File(directory, filename5);
              fileCreator(file5);
            }

            filer5 = createFileWriter(file5);

            for (Share share : anotherShareList) {
              writeToFile2(filer5, share);
            }
            closeFile(filer5);


          } else if (test.getCurrent() == 6) {

            file6 = new File(directory, filename6);
            fileCreator(file6);

            if (!file6.exists()) {
              file6 = new File(directory, filename6);
              fileCreator(file6);
            }

            filer6 = createFileWriter(file6);

            for (Share share : anotherShareList) {
              writeToFile2(filer6, share);
            }
            closeFile(filer6);


          } else if (test.getCurrent() == 7) {

            file7 = new File(directory, filename7);
            fileCreator(file7);

            if (!file7.exists()) {
              file7 = new File(directory, filename7);
              fileCreator(file7);
            }

            filer7 = createFileWriter(file7);

            for (Share share : anotherShareList) {
              writeToFile2(filer7, share);
            }
            closeFile(filer7);


          } else if (test.getCurrent() == 8) {




            file8 = new File(directory, filename8);
            fileCreator(file8);

            if (!file8.exists()) {
              file4 = new File(directory, filename8);
              fileCreator(file8);
            }

            filer8 = createFileWriter(file8);

            for (Share share : anotherShareList) {
              writeToFile2(filer8, share);
            }
            closeFile(filer8);

          } else if (test.getCurrent() == 9) {




            file9 = new File(directory, filename9);
            fileCreator(file9);

            if (!file9.exists()) {
              file9 = new File(directory, filename9);
              fileCreator(file9);
            }

            filer9 = createFileWriter(file9);

            for (Share share : anotherShareList) {
              writeToFile2(filer9, share);
            }
            closeFile(filer9);

          }
          else if (test.getCurrent() == 10) {

            file10 = new File(directory, filename10);
            fileCreator(file10);

            if (!file10.exists()) {
              file10 = new File(directory, filename10);
              fileCreator(file10);
            }

            filer10 = createFileWriter(file10);

            for (Share share : anotherShareList) {
              writeToFile2(filer10, share);
            }
            closeFile(filer10);

          }




          phase1.this.setVisible(false);
          phase1.this.dispose();
          test = new testClass(curSysProp+1);

          if(test.getCurrent() == 11) {
            sliderInterface phase2 = new sliderInterface(param.getSecurityListWithEmptyIncomeSharesFromStart(), 1, false, false, false, false,  0, 0.0);
            //  phases.setVisible(false);
            phase2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            phase2.setVisible(true);
          }


          phase1 phases = new phase1(anotherShareList, test.getCurrent());

          phases.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          phases.setVisible(true);



        } else {
          error(e);
        }

      }
    };


    button1.addActionListener(action);


    //create as many slider instances of the size of 'shares'
    //call the addSlider method with the correct param taken from the share object
    for (int i = 0; i < shares.size(); i++) {
      int priceofsecurity = shareList.get(i).getPrice();
      JSlider jSlider = formatSlider(shares.get(i).getPrice(), shares.get(i).getSecurityNumber());
      BoundedRangeModel model = jSlider.getModel();
      model.setRangeProperties(0,0,0,allocation/priceofsecurity,false);
      addShare(jSlider, shareList.get(i).getPrice());
    }


  }

  public void addShare(JSlider slider, int price) {
    slider.addChangeListener(changelistener);
    slider.addChangeListener(changelistener2);
    JPanel pan = new JPanel();
    pan.add(slider);

    pan.add(new JLabel("Price of security = " + price));

    panel.add(pan);

  }

  public JSlider formatSlider(int price, int number) {
    JSlider slider = new JSlider(JSlider.VERTICAL);
    BoundedRangeModel model = slider.getModel();
    model.setRangeProperties(0,0,0,100,false);
    slider.setName(Integer.toString(number));
    slider.setPaintTicks(true);
    slider.setMajorTickSpacing(10);
    slider.setMinorTickSpacing(2);
    slider.setPreferredSize(new Dimension(100, 350));
    slider.setBorder(new TitledBorder("Security " + Integer.toString(number)));
    slider.setPaintLabels(true);
    java.util.Hashtable<Integer, JLabel> labelTable = new java.util.Hashtable<Integer, JLabel>();
    labelTable.put(new Integer(100), new JLabel("100"));
    labelTable.put(new Integer(80), new JLabel("80"));
    labelTable.put(new Integer(60), new JLabel("60"));
    labelTable.put(new Integer(40), new JLabel("40"));
    labelTable.put(new Integer(20), new JLabel("20"));
    labelTable.put(new Integer(0), new JLabel("0"));
    slider.setLabelTable(labelTable);

    //slider.add(new JLabel(Integer.toString(price)));
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
          System.out.println("value of replaceed slider " + sliders.get(i).getValue());
          return;
        }
      }
    }
    else{
      sliders.add(slid);
      for(int i = sliders.size()-1; i > 0; i--){
        System.out.println("I'm outside if statement");
        if((Integer.parseInt(sliders.get(i).getName())) < (Integer.parseInt(sliders.get(i-1).getName()))){
          System.out.println("this is before change " + sliders.get(i).getName() + " " + sliders.get(i-1).getName());
          swapSliders(i, i-1);
          System.out.println("this is after change " + sliders.get(i).getName() + " " + sliders.get(i-1).getName());
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

  public List<JSlider> getSliders() {
    return sliders;
  }


  //make a file, make a directory to place the file
  //write the output to the file passed to it by the slider info

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


  public void formatFile(FileWriter filer) {
    test = new testClass(curSysProp);
    try {
      filer.write("\n" + "(Stage 1) Round " + test.getCurrent() + "\n");
    } catch (IOException e) {
      System.out.println("new file code failed");
    }


  }



  public void writeToFile(FileWriter filer, Share share) {
    try {
      filer.write("\n" + "Security number = " + share.getSecurityNumber() + " Security price = " + share.getPrice() +
          " Security Allocation = " + share.getAllocation() + "\n");

    } catch (IOException e) {
      System.out.println("failed hurr");
    }

  }



  public void writeToFile2(FileWriter filer, Share share) {
    try {
      filer.write("\n" + "@" + "%" + share.getSecurityNumber() + "%" + "$" + share.getPrice() + "$" + "^" + share.getIncomeShare() + "^" +
          "#" + share.getAllocation() + "#" + "*");

    } catch (IOException e) {
      System.out.println("failed hurr");
    }

  }


  public void closeFile(FileWriter filer){
    try {
      filer.flush();
      filer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }




  public void setMinVal(int x){
    minimumShare = x;
  }

  public int getMinVal(){
    return minimumShare;
  }




  public void recreate(int num, int limit){
    int t = shareList.size();
    for (int i = num+1; i < t; i++) {
      System.out.println("this is sharelist order " + shareList.get(i).getSecurityNumber());
      System.out.println("this is component " + i);
      JSlider sl = formatSlider(shareList.get(i).getPrice(), i + 1);
      int allocation2 = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent()));
      BoundedRangeModel model = sl.getModel();
      model.setRangeProperties(0,limit,0,allocation2/shareList.get(i).getPrice(),false);
      addShare(sl, shareList.get(i).getPrice());
    }
  }

















}
