package project;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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



    static JLabel empty1;
    static JLabel empty2;
    static JLabel empty3;

    private static ChangeListener changelistener;
    private static ChangeListener changelistener2;
    private static ChangeListener changelistener3;
    private static ActionListener Actionlistener4;
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




    //file stuffz

    String filename = "output.csv";
    String directory = System.getProperty("user.home") + "/Desktop";
    File file;
    FileWriter filer;


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

    private static int n;


    List<Share> shareList;


    public phase1(final List<Share> shares, int cur) {
        curSysProp = cur;
        test = new testClass();
        setLayout(new BorderLayout());
        setTitle("Stage 1");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height - 45);

        raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
        loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);


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
                    addShare(formatSlider(shares.get(i).getPrice(), shares.get(i).getSecurityNumber()), shares.get(i).getPrice());
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

        button3.addActionListener(Actionlistener4);

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



        textFieldUsedtobePanel5 = new JTextField();
        textFieldUsedtobePanel5.setText(Integer.toString(0));
        textFieldUsedtobePanel5.setBorder(loweredBorder);
        textFieldUsedtobePanel5.setFont(new Font("Calibri", Font.BOLD, 15));
        textFieldUsedtobePanel5.setEditable(false);

        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(4, 3, 5, 5));
        panel4.setBorder(new TitledBorder(raisedBorder, "Allocation"));
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


                        Share share1 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), valueD, shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber());
                        shareList.remove(0);
                        shareList.add(0, share1);
                        int temp = shareList.get(Integer.parseInt(name)).getPrice();
                        int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
                        JSlider s = formatSlider(temp, temp2);
                        BoundedRangeModel model = s.getModel();

                        if(v1 < (100-v1)){
                            model.setRangeProperties(v1, 100-v1, 0, 100, false);
                            textField2.setText("Units of security #" + s.getName() + " = " + v1);
                            v2 =v1;
                            s2 =source;
                            s2Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();
                            if(v1 < 25){
                                JOptionPane.showMessageDialog(null, "The sum of income shares will not be able to add up to 100." + "\n"
                                                + "Please press the reset allocations button and reallocate your income shares.",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else {
                            model.setRangeProperties(100-v1,v1,0,100,false);
                            textField2.setText("Units of security #" + s.getName() + " = " + (100-v1));
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
                        //using getName to store the price of the security
                    }
                    if (name.equals("2")) {
                        v2 = value;
                        textField2.setText("Units of security #" + source.getName() + " = " + value);
                        cost = v2 * price;
                        System.out.println("This is the cost = " + cost);
                        System.out.println("This is the price = " + price);
                        Share share2 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), valueD, shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber());
                        shareList.remove(1);
                        shareList.add(1, share2);
                        setSliders(source);

                        int temp = shareList.get(Integer.parseInt(name)).getPrice();
                        int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
                        JSlider s = formatSlider(temp, temp2);
                        BoundedRangeModel model = s.getModel();
                        if(v2 < (100-v1-v2)){
                            model.setRangeProperties(v2, 100-v1-v2, 0, 100, false);
                            textField3.setText("Units of security #" + s.getName() + " = " + v2);
                            v3=v2;
                            s3 =source;
                            s3Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();
                            if(((100-v1-v2)/3) > v2){
                                JOptionPane.showMessageDialog(null, "The sum of income shares will not be able to add up to 100." + "\n"
                                                + "Please press the reset allocations button and reallocate your income shares.",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                        else {
                            model.setRangeProperties(100-v1-v2, v1+v2,0,100,false);
                            textField3.setText("Units of security #" + s.getName() + " = " + (100-v1-v2));
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
                    }
                    if (name.equals("3")) {
                        v3 = value;
                        cost = cost + v3 * price;
                        System.out.println("This is the cost = " + cost);
                        System.out.println("This is the price = " + price);
                        textField3.setText("Units of security #" + source.getName() + " = " + value);
                        Share share3 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), valueD, shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber());
                        shareList.remove(2);
                        shareList.add(2, share3);
                        setSliders(source);

                        int temp = shareList.get(Integer.parseInt(name)).getPrice();
                        int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
                        JSlider s = formatSlider(temp, temp2);
                        BoundedRangeModel model = s.getModel();

                        if(v3 < (100-v1-v2-v3)){
                            model.setRangeProperties(v3, 100-v1-v2-v3, 0, 100, false);
                            textField4.setText("Units of security #" + s.getName() + " = " + v3);
                            v4=v3;
                            s4 =source;
                            s4Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();
                            if(((100-v1-v2-v3)/2) > v3){
                                JOptionPane.showMessageDialog(null, "The sum of income shares will not be able to add up to 100." + "\n"
                                                + "Please press the reset allocations button and reallocate your income shares.",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else {
                            model.setRangeProperties(100-v1-v2-v3, v1+v2+v3,0,100,false);
                            textField4.setText("Units of security #" + s.getName() + " = " + (100-v1-v2-v3));
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
                    }
                    if (name.equals("4")) {
                        v4 = value;
                        cost = cost + v4 * price;
                        System.out.println("This is the cost = " + cost);
                        System.out.println("This is the price = " + price);
                        textField4.setText("Units of security #" + source.getName() + " = " + value);
                        Share share4 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), valueD, shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber());
                        shareList.remove(3);
                        shareList.add(3, share4);
                        setSliders(source);

                        int temp = shareList.get(Integer.parseInt(name)).getPrice();
                        int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
                        JSlider s = formatSlider(temp, temp2);
                        BoundedRangeModel model = s.getModel();

                        if(v4 < (100-v1-v2-v3-v4)){
                            model.setRangeProperties(v4, 100-v1-v2-v3-v4, 0, 100, false);
                            textField5.setText("Units of security #" + s.getName() + " = " + v4);
                            JOptionPane.showMessageDialog(null, "The sum of income shares will not be able to add up to 100." + "\n"
                                            + "Please press the reset allocations button and reallocate your income shares.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            model.setRangeProperties(100-v1-v2-v3-v4, v1+v2+v3+v4,0,100,false);
                            textField5.setText("Units of security #" + s.getName() + " = " + (100-v1-v2-v3-v4));
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
                    }
                    if (name.equals("5")) {
                        v5 = value;
                        cost = cost + v5 * price;
                        System.out.println("This is the cost = " + cost);
                        System.out.println("This is the price = " + price);
                        textField5.setText("Units of security #" + source.getName() + " = " + value);
                        Share share5 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), valueD, shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber());
                        shareList.remove(4);
                        shareList.add(4, share5);
                        setSliders(source);

                        int tempForTextField = Integer.parseInt(textField7.getText()) - cost;
                        int tempV = Integer.parseInt(textFieldUsedtobePanel5.getText()) + cost;

                        textFieldUsedtobePanel5.setText(Integer.toString(tempV));
                        int tempForRemainingMoneyTextField = tempForTextField;
                        textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
                        remainingAlloc.setText("Security #" + name + " = " + cost);



                        if((v1+v2+v3+v4+v5) != 100){
                            JOptionPane.showMessageDialog(null, "The sum of income shares do not equal to 100." + "\n"
                                            + "Please press the reset allocations button and reallocate your income shares.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }


                        check5 = true;
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

                if (check && shareList.size() == 1) {
                    Share share = new Share(shareList.get(0).getPrice(), 1, v1);
                    anotherShareList.add(share);

                }



                if (check && check2 && shareList.size() == 2) {
                    Share share = new Share(shareList.get(0).getPrice(), 1, v1);
                    anotherShareList.add(share);
                    Share share2 = new Share(shareList.get(1).getPrice(), 2, v2);
                    anotherShareList.add(share2);




                }

                if (check && check2 && check3 &&  shareList.size() == 3) {
                    Share share = new Share(shareList.get(0).getPrice(), 1, v1);
                    anotherShareList.add(share);
                    Share share2 = new Share(shareList.get(1).getPrice(), 2, v2);
                    anotherShareList.add(share2);
                    Share share3 = new Share(shareList.get(2).getPrice(), 3, v3);
                    anotherShareList.add(share3);


                }

                if (check && check2 && check3 && check4 && shareList.size() == 4) {
                    Share share = new Share(shareList.get(0).getPrice(), 1, v1);
                    anotherShareList.add(share);
                    Share share2 = new Share(shareList.get(1).getPrice(), 2, v2);
                    anotherShareList.add(share2);
                    Share share3 = new Share(shareList.get(2).getPrice(), 3, v3);
                    anotherShareList.add(share3);
                    Share share4 = new Share(shareList.get(3).getPrice(), 4, v4);
                    anotherShareList.add(share4);


                }

                if (check && check2 && check3 && check4 && check5 && shareList.size() == 5) {
                    Share share = new Share(shareList.get(0).getPrice(), 1, v1);
                    anotherShareList.add(share);
                    Share share2 = new Share(shareList.get(1).getPrice(), 2, v2);
                    anotherShareList.add(share2);
                    Share share3 = new Share(shareList.get(2).getPrice(), 3, v3);
                    anotherShareList.add(share3);
                    Share share4 = new Share(shareList.get(3).getPrice(), 4, v4);
                    anotherShareList.add(share4);
                    Share share5 = new Share(shareList.get(4).getPrice(), 5, v5);
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



                    phase1.this.setVisible(false);
                    phase1.this.dispose();
                    allocationPage(anotherShareList);

                } else {
                    error(e);
                }

            }
        };


        button1.addActionListener(action);


        //create as many slider instances of the size of 'shares'
        //call the addSlider method with the correct param taken from the share object
        for (int i = 0; i < shares.size(); i++) {
            addShare(formatSlider(shares.get(i).getPrice(), shares.get(i).getSecurityNumber()), shares.get(i).getPrice());
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
        model.setRangeProperties(0,2,0,100,false);
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
            filer.write("\n" + "Round " + test.getCurrent() + "\n");
        } catch (IOException e) {
            System.out.println("new file code failed");
        }


    }



    public void writeToFile(FileWriter filer, Share share) {
        try {
            filer.write("\n" + "Security number = " + share.getSecurityNumber() + " Security price = " + share.getPrice() +
                    " Security Allocation = " + share.getAllocation());

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


    public void allocationPage(final List<Share> shareList){
        test = new testClass(curSysProp+1);
        final JFrame frame2 = new JFrame("Allocations");
        frame2.setLayout(new BorderLayout());


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame2.setBounds(0, 0, screenSize.width, screenSize.height - 45);
        frame2.setLayout(new BorderLayout());

        JButton button1 = new JButton("View data as a chart");
        button1.setLayout(new GridLayout(0, 3));
        button1.setBorder(new TitledBorder("Chart"));

        JButton button2 = new JButton("Continue");
        button2.setLayout(new GridLayout(0, 3));
        button2.setBorder(new TitledBorder("Next Round"));


        ActionListener nextRound = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(false);
                frame2.dispose();
                parameters params = new parameters();
                sliderInterface slider = new sliderInterface(params.getSecurityList(), test.getCurrent());
                slider.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                slider.setVisible(true);


            }
        };

        button2.addActionListener(nextRound);

        button2.addActionListener(nextRound);





        JPanel panelNew = new JPanel();
        panelNew.setLayout(new GridLayout(shareList.size(), 2));
        panelNew.setBorder(new TitledBorder("Data"));

        for(int i = 0; i <shareList.size(); i++){
            JTextField jText = new JTextField(Double.toString(shareList.get(i).getAllocation()));
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
                chartView(shareList);
            }
        };

        button1.addActionListener(action);


        JSplitPane splitPanel1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPanel1.setTopComponent(panelNew);
        splitPanel1.setBottomComponent(button1);
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


    public void recreate(int num, int limit){
        int t = shareList.size();
        for (int i = num+1; i < t; i++) {
            System.out.println("this is sharelist order " + shareList.get(i).getSecurityNumber());
            System.out.println("this is component " + i);
            JSlider sl = formatSlider(shareList.get(i).getPrice(), i + 1);
            BoundedRangeModel model = sl.getModel();
            model.setRangeProperties(0,limit,0,100,false);
            addShare(sl, shareList.get(i).getPrice());
        }
    }

















}