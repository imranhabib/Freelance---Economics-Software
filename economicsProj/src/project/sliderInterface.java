package project;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;




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

    private static List<JSlider> sliders;

    private static JTextField textField;
    private static JTextField textField2;
    private static JTextField textField3;
    private static JTextField textField4;
    private static JTextField textField5;

    private static JSpinner jSpinner;
    private static JSpinner jSpinner2;


    private static ChangeListener changelistener;
    private static ChangeListener changelistener2;
    private static ChangeListener changelistener3;
    private static ChangeListener changelistener4;
    private static ActionListener action;

    private final Color blue = Color.BLUE;
    private final Color red = Color.RED;

    private static boolean check;


    static int total = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave"));
    static int allocation = 0;


    //file stuffz

    String filename = "output.txt";
    String directory = System.getProperty("user.home") + "/Desktop";
    File file;
    FileWriter filer;




    //backend stuffz


    allocation alloc;
    parameters param;
    incomeRequired income;

    static Integer value;
    static Double value2;
    static int pBar;
    static int mBar;
    static Double r;
    static int nOfr;

    private static final int n = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("securityAmount"));











    public sliderInterface(final List<Share> shares) {
        setLayout(new BorderLayout());
        setTitle("Slider Interface");
        setSize(1000, 1000);

        int size = shares.size();
        panel2 = new JPanel();

        allocation = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave"));

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

        textField.setEditable(false);
        textField2.setEditable(false);
        textField3.setEditable(false);
        textField4.setEditable(false);
        textField5.setEditable(false);

      /*
      textField.setForeground(blue);
      textField2.setForeground(red);
      textField3.setForeground(blue);
      textField4.setForeground(red);
      textField5.setForeground(blue);
      */

        //backend stuffz



        param = new parameters();



        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(0, 0, 100, 0.5);
        SpinnerNumberModel spinnerNumberModel2 = new SpinnerNumberModel(0, 0, 100, 1);
        jSpinner = new JSpinner(spinnerNumberModel);
        jSpinner2 = new JSpinner(spinnerNumberModel2);

        changelistener2 = new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                JSpinner source = (JSpinner) event.getSource();
                value = (Integer) source.getValue();
                income = new incomeRequired(value);
                alloc = new allocation(param, income);
                pBar = param.getMeanPriceAmount();
                setMBar(pBar, n, income);
                remainingAlloc.setText("Money left = " + (allocation - getMBar()));
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
                System.out.println("reservation ratio = " + getR());
            }
        };

        jSpinner.addChangeListener(changelistener3);



        panel5 = new JPanel();
        panel5.setLayout(new GridLayout(0, shares.size()));
        panel5.setBorder(new TitledBorder("R Ratio"));
        panel5.add(jSpinner);

        panel6 = new JPanel();
        panel6.setLayout(new GridLayout(0, shares.size()));
        panel6.setBorder(new TitledBorder("Minimum Share"));
        panel6.add(jSpinner2);



        remainingAlloc = new JTextField();
        remainingAlloc.setEditable(false);

        button3 = new JButton("Save Ratio");


        changelistener4 = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent event) {
                setNofR(getR(), shares, param);
                float value = getNofR();
                System.out.println("this is dat valu = " + value);

            }
        };

        button3.addChangeListener(changelistener4);


        panel7 = new JPanel();
        panel7.setLayout(new GridLayout(0, shares.size()));
        panel7.setBorder(new TitledBorder("Remaining dough"));
        panel7.add(remainingAlloc);





        panel8 = new JPanel();
        panel8.setLayout(new GridLayout(0, shares.size()));
        panel8.setBorder(new TitledBorder("test"));
        panel8.add(button3);





        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(0, 2));
        panel4.setBorder(new TitledBorder("Inputs"));
        panel4.add(panel5);
        panel4.add(panel6);
        panel4.add(panel7);
        panel4.add(panel8);


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
                JSplitPane.VERTICAL_SPLIT, panel, panel4
        );


        button1 = new JButton("Submit");
        button1.setToolTipText("Click to submit input selection");
        button1.setBorder(new TitledBorder("Move on"));


        sliders = new ArrayList<JSlider>();


        //you can change the first SOUTH -> NORTH && the first CENTER -> SOUTH to get a different spacing/sizing

        panel2.add(splitPane, BorderLayout.CENTER);
        // panel2.add(panel, BorderLayout.CENTER);
        panel2.add(panel3, BorderLayout.NORTH);
        panel2.add(button1, BorderLayout.SOUTH);
        add(panel2, BorderLayout.CENTER);
        //add(panel3, BorderLayout.PAGE_START);

        check = false;

        changelistener = new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                JSlider source = (JSlider) event.getSource();

                if (!source.getValueIsAdjusting()) {
                    int value = source.getValue();

                    String name = source.getName();
                    if (name.equals("1")) {
                        textField.setText("Security #" + source.getName() + " = " + value + "%");
                        if (getSliders().contains(source)) {
                            getSliders().remove(source);
                            setSliders(source);
                        } else {
                            setSliders(source);
                        }
                        check = true;                                                                         //using getName to store the price of the security
                    }
                    if (name.equals("2")) {
                        textField2.setText("Security #" + source.getName() + " = " + value + "%");
                        if (getSliders().contains(source)) {
                            getSliders().remove(source);
                            setSliders(source);
                        } else {
                            setSliders(source);
                        }
                        check = true;
                    }
                    if (name.equals("3")) {
                        textField3.setText("Security #" + source.getName() + " = " + value + "%");
                        if (getSliders().contains(source)) {
                            getSliders().remove(source);
                            setSliders(source);
                        } else {
                            setSliders(source);
                        }
                        check = true;
                    }
                    if (name.equals("4")) {
                        textField4.setText("Security #" + source.getName() + " = " + value + "%");
                        if (getSliders().contains(source)) {
                            getSliders().remove(source);
                            setSliders(source);
                        } else {
                            setSliders(source);
                        }
                        check = true;
                    }
                    if (name.equals("5")) {
                        textField5.setText("Security #" + source.getName() + " = " + value + "%");
                        if (getSliders().contains(source)) {
                            getSliders().remove(source);
                            setSliders(source);
                        } else {
                            setSliders(source);
                        }
                        check = true;
                    }
                }

            }
        };


        //File stuffz

        file = new File(directory, filename);
        // System.out.println("current path the file is sent to : " + file.getAbsolutePath());


        action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!file.exists()) {
                    file = new File(directory, filename);
                    fileCreator(file);
                }
                if (check) {
                    filer = createFileWriter(file);
                    for (JSlider slide : sliders) {
                        //put the output of all the sliders here, when the user presses enter it will read the updated slider values
                        // call a writer function here and pass it the sliders (either as a list or as single sliders)
                        writeToFile(filer, slide);

                        //System.out.println("Slide name = " + slide.getName() + "slide name = " + slide.getValue());
                    }
                    closeFile(filer);

                    //TODO: right now the code writes to the file, but after submit it pressed and before the confirmation is completed

                    confirmation(e);
                    final JFrame frame = new JFrame();
                    JPanel panel = new JPanel();

                    JButton button1 = new JButton();

                    frame.add(panel);
                    panel.add(button1);
                    frame.setVisible(true);
                    JOptionPane.showMessageDialog(frame.getComponent(0), "This is your allocation based on your inputs");

                } else {
                    error(e);
                }

            }
        };


        button1.addActionListener(action);


        //create as many slider instances of the size of 'shares'
        //call the addSlider method with the correct param taken from the share object
        for (int i = 0; i < shares.size(); i++) {
            addShare(formatSlider(shares.get(i).getPrice(), shares.get(i).getSecurityNumber()), shares.get(i).getIncomeShare(), shares.get(i).getPrice());
        }


    }

    public void addShare(JSlider slider, float incomeShare, int price) {
        slider.addChangeListener(changelistener);
        JPanel pan = new JPanel();
        pan.add(slider);
        pan.setToolTipText(Float.toString(incomeShare));
        pan.add(new JLabel("Price of security = " + price));
        panel.add(pan);


    }

    public JSlider formatSlider(int price, int number) {
        JSlider slider = new JSlider(JSlider.VERTICAL);
        slider.setName(Integer.toString(price));
        slider.setMinimum(0);
        slider.setMaximum(100);
        slider.setValue(0);
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


    public void confirmation(ActionEvent action) {
        JOptionPane.showConfirmDialog(null,
                "Confirm Allocations?", "There's no going back!", JOptionPane.YES_NO_OPTION);

    }


    public void error(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Please complete allocations", "Error", JOptionPane.ERROR_MESSAGE);
    }


    public void setSliders(JSlider slider) {
        sliders.add(slider);

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
            FileWriter fileWrite = new FileWriter(file);
            System.out.println("here so this is good");
            return fileWrite;
        } catch (IOException e) {
            System.out.println("here so were screwed");
            return null;
        }


    }


    public void writeToFile(FileWriter filer, JSlider slide) {
        try {
            filer.write("\n" + "Slide name = " + slide.getName()  +  " slide value = " + slide.getValue());
            System.out.println("here so this is also good, this should show up 5 times");
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




//TODO: plan. Using the allocation class methods, and the inputs from the JSpinners (xbar, reservation ratio, and income shares). Make the security levels move on their own (by calling their setValue() methods)
//TODO: have; the input for xBar

    public void setMBar (int pbar, int n, incomeRequired income){
        //this is not a recursive call, getMbar is another meth in the incomeRequired class
        mBar = income.getMbar(pbar, n);

    }

    public int getMBar (){
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

    public float getNofR (){
        return nOfr;
    }



































}

