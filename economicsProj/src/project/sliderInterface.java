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
 * Created by Imran on 2014-11-29.
 */
public class sliderInterface extends JFrame {

    static JSlider slider;
    static JPanel panel;
    static JPanel panel2;
    static JLabel label;
    static JPanel panel3;
    static JPanel panel4;
    static JPanel panel5;
    static JPanel panel6;
    static JPanel panel7;
    static JPanel panel8;
    static JButton button1;
    static JTextField remainingAlloc;
    static JButton button3;

    static testClass test;

    private static List<JSlider> sliders;

    private static JTextField textField;
    private static JTextField textField2;
    private static JTextField textField3;
    private static JTextField textField4;
    private static JTextField textField5;


    static JLabel empty1;
    static JLabel empty2;

    private static JTextField textField6;
    private static JTextField textField7;
    private static JTextField textField8;

    private static JSpinner jSpinner;
    private static JSpinner jSpinner2;

    private static JTextField valueAdjust;


    private static ChangeListener changelistener;
    private static ChangeListener changelistener2;
    private static ChangeListener changelistener3;
    private static ActionListener Actionlistener4;
    private static ActionListener action;
    private static ChangeListener changelistener4;

    static List<Share> anotherShareList;

    private final Color blue = Color.BLUE;
    private final Color red = Color.RED;

    private static boolean check;
    private static boolean check2;
    private static boolean check3;
    private static boolean check4;
    private static boolean check5;
    private static boolean check6;

    static Border raisedBorder;
    static Border loweredBorder;


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



    //file stuffz

    String filename = "output.csv";
    String directory = System.getProperty("user.home") + "/Desktop/output";
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
    List<Share> tempListForRewind;


    public sliderInterface(final List<Share> shares, int cur, final boolean rewind, final boolean rewind2,final boolean rewind3,final boolean rewind4,int m, double ratio) {
        curSysProp = cur;
        test = new testClass(cur);
        setLayout(new BorderLayout());
        setTitle("Stage 2 | Choice Rule ");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height - 45);

        raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
        loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

        tempListForRewind = shares;

        total = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent()));
        n = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("securityAmount" + test.getCurrent()));

        int size = shares.size();
        panel2 = new JPanel();

        allocation = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent()));

        panel2.setLayout(new BorderLayout(5, 10));

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, shares.size()));
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setBorder(new TitledBorder("Income Share %'s"));
        // label = new JLabel("Securities");
        // panel.add(label);

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


        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(1, 1, 100, 0.1);
        SpinnerNumberModel spinnerNumberModel2 = new SpinnerNumberModel(0, 0, 100, 1);
        jSpinner = new JSpinner(spinnerNumberModel);
        if (rewind) {
            jSpinner.setValue(ratio);
        }
        jSpinner2 = new JSpinner(spinnerNumberModel2);

        if (rewind) {
            jSpinner2.setValue(m);
        }

        changelistener2 = new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                JSpinner source = (JSpinner) event.getSource();
                value = (Integer) source.getValue();
                income = new incomeRequired(value);
                setMinVal(value);
                alloc = new allocation(param, income);
                pBar = param.getMeanPriceAmount();
                setMBar(pBar, n, income);

                remainingAlloc.setText("= " + (allocation - getMBar()));
               if (allocation - getMBar() < 0) {
                    JOptionPane.showMessageDialog(null, "You cant afford this minimum share", "Error", JOptionPane.ERROR_MESSAGE);
                    textField7.setText("No!");
                    //add a warning message here
                } else {
                    textField7.setText("Yes!");
                }
                System.out.println("this is mbar = " + getMBar());
                System.out.println("this is the value of the Jspinner " + value);
            }
        };


        jSpinner2.addChangeListener(changelistener2);


        changelistener3 = new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                JSpinner source = (JSpinner) event.getSource();
                value2 = (Double) source.getValue();
                r = value2;
                setR(r);
                // textField8.setText(Double.toString(param.getArgMaxFormula(getR(), shareList)));
                System.out.println("reservation ratio = " + getR());
            }
        };

        jSpinner.addChangeListener(changelistener3);


        panel5 = new JPanel();
        panel5.setLayout(new GridLayout(0, shares.size()));
        panel5.setBorder(new TitledBorder(raisedBorder, "Reservation Ratio"));
        panel5.add(jSpinner);


        remainingAlloc = new JTextField();
        remainingAlloc.setEditable(false);
        remainingAlloc.setBorder(new TitledBorder(loweredBorder, "Remaining Money"));



        textField7 = new JTextField();
        textField7.setEditable(false);
        textField7.setBorder(new TitledBorder(loweredBorder, "Affordable?"));


        panel6 = new JPanel();
        panel6.setLayout(new GridLayout(1, 0, 5, 5));
        panel6.setBorder(new TitledBorder(raisedBorder, "Minimum Share"));
        panel6.add(jSpinner2);
        panel6.add(remainingAlloc);
        panel6.add(textField7);



        button3 = new JButton("Reset Allocations");
        button3.setBorder(new TitledBorder(raisedBorder, "Reset"));


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
                valueAdjust.setText("Value = ");
                panel.revalidate();
                panel.repaint();
            }
        };

        button3.addActionListener(Actionlistener4);

        textField7 = new JTextField();
        textField7.setEditable(false);
        textField7.setBorder(new TitledBorder(loweredBorder, "Affordable?"));

        panel7 = new JPanel();
        panel7.setLayout(new GridLayout(0, shares.size()));
        panel7.setBorder(new TitledBorder(raisedBorder));
        

        valueAdjust = new JTextField();
        valueAdjust.setBorder(raisedBorder);
        valueAdjust.setFont(new Font("Calibri", Font.BOLD, 15));
        valueAdjust.setText("Value = ");

        panel8 = new JPanel();
        panel8.setLayout(new GridLayout(0, 2, 5, 5));
        panel8.setBorder(raisedBorder);
        panel8.add(valueAdjust);
        panel8.add(button3);


        empty1 = new JLabel();
        empty2 = new JLabel();


        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(0, 2));
        panel4.setBorder(new TitledBorder("Create a choice rule"));
        panel4.add(panel8);
        panel4.add(panel6);
        panel4.add(panel7);
        panel4.add(panel5);


        if (size >= 1) {
            if(!rewind) {
                panel3.add(textField);
            } else {
                textField.setText(Double.toString(tempListForRewind.get(0).getAllocation()) + "%");
                panel3.add(textField);
            }
        }
        if (size >= 2) {
            if(!rewind) {
                panel3.add(textField2);
            } else {
                textField2.setText(Double.toString(tempListForRewind.get(1).getAllocation()) + "%");
                panel3.add(textField2);
            }
        }
        if (size >= 3) {
            if(!rewind) {
                panel3.add(textField3);
            } else {
                textField3.setText(Double.toString(tempListForRewind.get(2).getAllocation()) + "%");
                panel3.add(textField3);
            }
        }
        if (size >= 4) {
            if(!rewind) {
                panel3.add(textField4);
            } else {
                textField4.setText(Double.toString(tempListForRewind.get(3).getAllocation()) + "%");
                panel3.add(textField4);
            }
        }
        if (size >= 5) {
            if(!rewind) {
                panel3.add(textField5);
            } else {
                textField5.setText(Double.toString(tempListForRewind.get(4).getAllocation()) + "%");
                panel3.add(textField5);
            }
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

                if (!source.getValueIsAdjusting()) {
                    int value = source.getValue();
                    Double valueD = Double.parseDouble(Integer.toString(source.getValue()));
                    String name = source.getName();
                    if (name.equals("1")) {
                        setSliders(source);
                        v1 = value;
                        textField.setText("Security #" + source.getName() + " = " + value + "%");
                        Share share1 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), valueD, shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber());
                        shareList.remove(0);
                        shareList.add(0, share1);
                        int temp = shareList.get(Integer.parseInt(name)).getPrice();
                        int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
                        JSlider s = formatSlider(temp, temp2);
                        BoundedRangeModel model = s.getModel();
                        if (v1 < (100 - v1)) {
                            model.setRangeProperties(v1, 100 - v1, 0, 100, false);
                            textField2.setText("Security #" + s.getName() + " = " + v1 + "%");
                            v2 = v1;
                            s2 = source;
                            s2Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();
                            if (v1 < 25) {
                                JOptionPane.showMessageDialog(null, "The sum of income shares will not be able to add up to 100." + "\n"
                                                + "Please press the reset allocations button and reallocate your income shares.",
                                        "Error", JOptionPane.ERROR_MESSAGE
                                );
                            }
                        } else {
                            model.setRangeProperties(100 - v1, v1, 0, 100, false);
                            textField2.setText("Security #" + s.getName() + " = " + (100 - v1) + "%");
                        }
                        System.out.println((Integer.parseInt(name)));
                        panel.removeAll();
                        addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
                        addShare(s, temp);
                        recreate((Integer.parseInt(name)), 100 - v1);
                        panel.revalidate();
                        panel.repaint();
                        s1 = source;
                        s1Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();
                        check = true;
                        check6 = true;
                        //using getName to store the price of the security
                    }
                    if (name.equals("2")) {
                        v2 = value;
                        textField2.setText("Security #" + source.getName() + " = " + value + "%");
                        Share share2 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), valueD, shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber());
                        shareList.remove(1);
                        shareList.add(1, share2);
                        setSliders(source);

                        int temp = shareList.get(Integer.parseInt(name)).getPrice();
                        int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
                        JSlider s = formatSlider(temp, temp2);
                        BoundedRangeModel model = s.getModel();
                        if (v2 < (100 - v1 - v2)) {
                            model.setRangeProperties(v2, 100 - v2, 0, 100, false);
                            textField3.setText("Security #" + s.getName() + " = " + v2 + "%");
                            v3 = v2;
                            s3 = source;
                            s3Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();
                            if (((100 - v1 - v2) / 3) > v2) {
                                JOptionPane.showMessageDialog(null, "The sum of income shares will not be able to add up to 100." + "\n"
                                                + "Please press the reset allocations button and reallocate your income shares.",
                                        "Error", JOptionPane.ERROR_MESSAGE
                                );
                            }

                        } else {
                            model.setRangeProperties(100 - v1 - v2, v1 + v2, 0, 100, false);
                            textField3.setText("Security #" + s.getName() + " = " + (100 - v1 - v2) + "%");
                        }
                        System.out.println((Integer.parseInt(name)));
                        panel.removeAll();
                        addShare(s1, s1Price);
                        addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
                        addShare(s, temp);
                        recreate((Integer.parseInt(name)), 100 - v1 - v2);
                        panel.revalidate();
                        panel.repaint();
                        s2 = source;
                        s2Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

                        check2 = true;
                    }
                    if (name.equals("3")) {
                        v3 = value;
                        textField3.setText("Security #" + source.getName() + " = " + value + "%");
                        Share share3 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), valueD, shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber());
                        shareList.remove(2);
                        shareList.add(2, share3);
                        setSliders(source);

                        int temp = shareList.get(Integer.parseInt(name)).getPrice();
                        int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
                        JSlider s = formatSlider(temp, temp2);
                        BoundedRangeModel model = s.getModel();

                        if (v3 < (100 - v1 - v2 - v3)) {
                            model.setRangeProperties(v3, 100 - v3, 0, 100, false);
                            textField4.setText("Security #" + s.getName() + " = " + v3 + "%");
                            v4 = v3;
                            s4 = source;
                            s4Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();
                            if (((100 - v1 - v2 - v3) / 2) > v3) {
                                JOptionPane.showMessageDialog(null, "The sum of income shares will not be able to add up to 100." + "\n"
                                                + "Please press the reset allocations button and reallocate your income shares.",
                                        "Error", JOptionPane.ERROR_MESSAGE
                                );
                            }
                        } else {
                            model.setRangeProperties(100 - v1 - v2 - v3, v1 + v2 + v3, 0, 100, false);
                            textField4.setText("Security #" + s.getName() + " = " + (100 - v1 - v2 - v3) + "%");
                        }

                        System.out.println((Integer.parseInt(name)));
                        panel.removeAll();
                        addShare(s1, s1Price);
                        addShare(s2, s2Price);
                        addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
                        addShare(s, temp);
                        recreate((Integer.parseInt(name)), 100 - v1 - v2 - v3);
                        panel.revalidate();
                        panel.repaint();
                        s3 = source;
                        s3Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

                        check3 = true;
                    }
                    if (name.equals("4")) {
                        v4 = value;
                        textField4.setText("Security #" + source.getName() + " = " + value + "%");
                        Share share4 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), valueD, shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber());
                        shareList.remove(3);
                        shareList.add(3, share4);
                        setSliders(source);

                        int temp = shareList.get(Integer.parseInt(name)).getPrice();
                        int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
                        JSlider s = formatSlider(temp, temp2);
                        BoundedRangeModel model = s.getModel();

                        if (v4 < (100 - v1 - v2 - v3 - v4)) {
                            model.setRangeProperties(v4, 100 - v4, 0, 100, false);
                            textField5.setText("Security #" + s.getName() + " = " + v4 + "%");
                            JOptionPane.showMessageDialog(null, "The sum of income shares will not be able to add up to 100." + "\n"
                                            + "Please press the reset allocations button and reallocate your income shares.",
                                    "Error", JOptionPane.ERROR_MESSAGE
                            );
                        } else {
                            model.setRangeProperties(100 - v1 - v2 - v3 - v4, v1 + v2 + v3 + v4, 0, 100, false);
                            textField5.setText("Security #" + s.getName() + " = " + (100 - v1 - v2 - v3 - v4) + "%");
                        }


                        System.out.println((Integer.parseInt(name)));
                        panel.removeAll();
                        addShare(s1, s1Price);
                        addShare(s2, s2Price);
                        addShare(s3, s3Price);
                        addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
                        addShare(s, temp);

                        recreate((Integer.parseInt(name)), 100 - v1 - v2 - v3 - v4);
                        panel.revalidate();
                        panel.repaint();
                        s4 = source;
                        s4Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

                        check4 = true;
                    }
                    if (name.equals("5")) {
                        v5 = value;
                        textField5.setText("Security #" + source.getName() + " = " + value + "%");
                        Share share5 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), valueD, shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber());
                        shareList.remove(4);
                        shareList.add(4, share5);
                        setSliders(source);

                        if ((v1 + v2 + v3 + v4 + v5) != 100) {
                            JOptionPane.showMessageDialog(null, "The sum of income shares do not equal to 100." + "\n"
                                            + "Please press the reset allocations button and reallocate your income shares.",
                                    "Error", JOptionPane.ERROR_MESSAGE
                            );
                        }

                        check5 = true;
                    }
                }

            }
        };

        changelistener4 = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (source.getValueIsAdjusting()) {
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
                
                 if(textField7.getText().equals("No!")){
                    JOptionPane.showMessageDialog(null, "Please lower minimum share", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int result = JOptionPane.showConfirmDialog(null,
                        "Confirm Choices?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (result != 0) {
                    return;
                }


                anotherShareList = new ArrayList<Share>(shareList.size());

                if (check && shareList.size() == 1) {
                    Share share = new Share(shareList.get(0).getPrice(), Double.parseDouble(Integer.toString(v1)), 1);
                    anotherShareList.add(share);


                }


                if (check && check2 && shareList.size() == 2) {
                    Share share = new Share(shareList.get(0).getPrice(), Double.parseDouble(Integer.toString(v1)), 1);
                    anotherShareList.add(share);
                    Share share2 = new Share(shareList.get(1).getPrice(), Double.parseDouble(Integer.toString(v2)), 2);
                    anotherShareList.add(share2);


                }

                if (check && check2 && check3 && shareList.size() == 3) {
                    Share share = new Share(shareList.get(0).getPrice(), Double.parseDouble(Integer.toString(v1)), 1);
                    anotherShareList.add(share);
                    Share share2 = new Share(shareList.get(1).getPrice(), Double.parseDouble(Integer.toString(v2)), 2);
                    anotherShareList.add(share2);
                    Share share3 = new Share(shareList.get(2).getPrice(), Double.parseDouble(Integer.toString(v3)), 3);
                    anotherShareList.add(share3);


                }

                if (check && check2 && check3 && check4 && shareList.size() == 4) {
                    Share share = new Share(shareList.get(0).getPrice(), Double.parseDouble(Integer.toString(v1)), 1);
                    anotherShareList.add(share);
                    Share share2 = new Share(shareList.get(1).getPrice(), Double.parseDouble(Integer.toString(v2)), 2);
                    anotherShareList.add(share2);
                    Share share3 = new Share(shareList.get(2).getPrice(), Double.parseDouble(Integer.toString(v3)), 3);
                    anotherShareList.add(share3);
                    Share share4 = new Share(shareList.get(3).getPrice(), Double.parseDouble(Integer.toString(v4)), 4);
                    anotherShareList.add(share4);


                }

                if (check && check2 && check3 && check4 && check5 && shareList.size() == 5) {
                    Share share = new Share(shareList.get(0).getPrice(), Double.parseDouble(Integer.toString(v1)), 1);
                    anotherShareList.add(share);
                    Share share2 = new Share(shareList.get(1).getPrice(), Double.parseDouble(Integer.toString(v2)), 2);
                    anotherShareList.add(share2);
                    Share share3 = new Share(shareList.get(2).getPrice(), Double.parseDouble(Integer.toString(v3)), 3);
                    anotherShareList.add(share3);
                    Share share4 = new Share(shareList.get(3).getPrice(), Double.parseDouble(Integer.toString(v4)), 4);
                    anotherShareList.add(share4);
                    Share share5 = new Share(shareList.get(4).getPrice(), Double.parseDouble(Integer.toString(v5)), 5);
                    anotherShareList.add(share5);

                }

                for (Share shr : anotherShareList) {
                    System.out.println("share of income = " + shr.getIncomeShare() + "share price = " + shr.getPrice());
                }


                if (anotherShareList.size() == 1) {
                    for (int i = 0; i < anotherShareList.size(); i++) {
                        double allocationVal = alloc.allocationForShare(i + 1, getR(), anotherShareList, getMinVal());
                        Share share = new Share(anotherShareList.get(i).getPrice(), anotherShareList.get(i).getIncomeShare(), anotherShareList.get(i).getSecurityNumber(), allocationVal);
                        anotherShareList.remove(i);
                        anotherShareList.add(i, share);

                    }

                }


                if (anotherShareList.size() == 2) {
                    for (int i = 0; i < anotherShareList.size(); i++) {
                        double allocationVal = alloc.allocationForShare(i + 1, getR(), anotherShareList, getMinVal());
                        Share share = new Share(anotherShareList.get(i).getPrice(), anotherShareList.get(i).getIncomeShare(), anotherShareList.get(i).getSecurityNumber(), allocationVal);
                        anotherShareList.remove(i);
                        anotherShareList.add(i, share);

                    }

                }

                if (anotherShareList.size() == 3) {
                    for (int i = 0; i < anotherShareList.size(); i++) {
                        double allocationVal = alloc.allocationForShare(i + 1, getR(), anotherShareList, getMinVal());
                        Share share = new Share(anotherShareList.get(i).getPrice(), anotherShareList.get(i).getIncomeShare(), anotherShareList.get(i).getSecurityNumber(), allocationVal);
                        anotherShareList.remove(i);
                        anotherShareList.add(i, share);

                    }

                }

                if (anotherShareList.size() == 4) {
                    for (int i = 0; i < anotherShareList.size(); i++) {
                        double allocationVal = alloc.allocationForShare(i + 1, getR(), anotherShareList, getMinVal());
                        Share share = new Share(anotherShareList.get(i).getPrice(), anotherShareList.get(i).getIncomeShare(), anotherShareList.get(i).getSecurityNumber(), allocationVal);
                        anotherShareList.remove(i);
                        anotherShareList.add(i, share);

                    }

                }

                if (anotherShareList.size() == 5) {

                    for (int i = 0; i < anotherShareList.size(); i++) {
                        double allocationVal = alloc.allocationForShare(i + 1, getR(), anotherShareList, getMinVal());
                        Share share = new Share(anotherShareList.get(i).getPrice(), anotherShareList.get(i).getIncomeShare(), anotherShareList.get(i).getSecurityNumber(), allocationVal);
                        anotherShareList.remove(i);
                        anotherShareList.add(i, share);

                    }

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


                    sliderInterface.this.setVisible(false);
                    sliderInterface.this.dispose();
                    allocationPage(anotherShareList, getR(), getMinVal(), rewind, rewind2, rewind3, rewind4);

                } else {
                    error(e);
                }

            }
        };


        button1.addActionListener(action);


        //create as many slider instances of the size of 'shares'
        //call the addSlider method with the correct param taken from the share object
        if (!rewind) {
            for (int i = 0; i < shares.size(); i++) {
                addShare(formatSlider(shares.get(i).getPrice(), shares.get(i).getSecurityNumber()), shares.get(i).getPrice());
            }
        } else {
            for (int i = 0; i < tempListForRewind.size(); i++) {
                addShare(formatSlider2(tempListForRewind.get(i).getSecurityNumber(), tempListForRewind.get(i).getIncomeShare()), tempListForRewind.get(i).getPrice());
            }

        }
    }

    public void addShare(JSlider slider, int price) {
        slider.addChangeListener(changelistener);
        slider.addChangeListener(changelistener4);
        JPanel pan = new JPanel();
        pan.add(slider);
        //pan.setToolTipText(Float.toString(incomeShare));
        pan.add(new JLabel("Price of security = " + price));
        panel.add(pan);

    }

    public JSlider formatSlider(int price, int number) {
        JSlider slider = new JSlider(JSlider.VERTICAL);
        BoundedRangeModel model = slider.getModel();
        model.setRangeProperties(0,0,0,100,false);
        slider.setName(Integer.toString(number));
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPreferredSize(new Dimension(100, 400));
        slider.setBorder(new TitledBorder("Security " + Integer.toString(number)));
        slider.setPaintLabels(true);
        java.util.Hashtable<Integer, JLabel> labelTable = new java.util.Hashtable<Integer, JLabel>();
        labelTable.put(new Integer(100), new JLabel("1.0"));
        labelTable.put(new Integer(75), new JLabel("0.75"));
        labelTable.put(new Integer(50), new JLabel("0.50"));
        labelTable.put(new Integer(25), new JLabel("0.25"));
        labelTable.put(new Integer(0), new JLabel("0.0"));
        slider.setLabelTable(labelTable);

        //slider.add(new JLabel(Integer.toString(price)));
        return slider;

    }


    public JSlider formatSlider2(int number, double incomeShare) {
        JSlider slider = new JSlider(JSlider.VERTICAL);
        BoundedRangeModel model = slider.getModel();
        model.setRangeProperties(0,0,0,100,false);
        slider.setName(Integer.toString(number));
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPreferredSize(new Dimension(100, 400));
        slider.setBorder(new TitledBorder("Security " + Integer.toString(number)));
        slider.setPaintLabels(true);
        java.util.Hashtable<Integer, JLabel> labelTable = new java.util.Hashtable<Integer, JLabel>();
        labelTable.put(new Integer(100), new JLabel("1.0"));
        labelTable.put(new Integer(75), new JLabel("0.75"));
        labelTable.put(new Integer(50), new JLabel("0.50"));
        labelTable.put(new Integer(25), new JLabel("0.25"));
        labelTable.put(new Integer(0), new JLabel("0.0"));
        slider.setLabelTable(labelTable);
        String temp = Double.toString(incomeShare);
        temp = temp.substring(0,temp.indexOf("."));
        slider.setValue(Integer.parseInt(temp));

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
            filer.write("\n" + "Stage 2 | First Choice Rule Selection " + "\n\n" + "(Stage2 Test) Round " + test.getCurrent() + "\n");
        } catch (IOException e) {
            System.out.println("new file code failed");
        }


    }



    public void writeToFile(FileWriter filer, Share share) {
        try {
            filer.write("\n" + "Reservation Ratio = " + jSpinner.getValue() + " Minimum Share = " + jSpinner2.getValue() + " Security number = " + share.getSecurityNumber() + " Security price = " + share.getPrice() + " Security Income Share = " + share.getIncomeShare() +
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


    public void setMBar (Double pbar, int n, incomeRequired income){
        //this is not a recursive call, getMbar is another meth in the incomeRequired class
        mBar = income.getMbar(pbar, n);

    }

    public Double getMBar (){
        return mBar;
    }


    public void setR(Double value2){
        r = value2;
    }

    public Double getR(){
        return r;
    }

    public void setNofR(Double r, List<Share> shares, parameters param){
        nOfr = param.getArgMaxFormula(r, shares);




    }

    public Double getNofR (){
        return nOfr;
    }

    public void setMinVal(int x){
        minimumShare = x;
    }

    public int getMinVal(){
        return minimumShare;
    }


    public void allocationPage(final List<Share> shareList, final double r, final int m, final boolean rewind,final boolean rewind2, final boolean rewind3, final boolean rewind4){
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
                phase2TestRounds slider = new phase2TestRounds(shareList, test.getCurrent(), m, r, new storageClass(), rewind, rewind2, rewind3, rewind4);
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

