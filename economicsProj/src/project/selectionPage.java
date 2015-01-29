package project;

import org.jfree.chart.plot.JThermometer;
import sun.reflect.annotation.ExceptionProxy;
import test.testClass;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by Imran on 2015-01-28.
 */
public class selectionPage extends JFrame{

    static JLabel stg3Title;
    static JLabel stg4Title;

    static JTextField box1;
    static JTextField box2;
    static JTextField box3;
    static JTextField box4;
    static JTextField box5;
    static JTextField box6;
    static JTextField box7;
    static JTextField box8;
    static JTextField box9;
    static JTextField box10;
    static JTextField box11;
    static JTextField box12;
    static JTextField box13;
    static JTextField box14;
    static JTextField box15;
    static JTextField box16;
    static JTextField box17;
    static JTextField box18;
    static JTextField box19;
    static JTextField box20;

    static JTextField costBox;
    static JTextField totalBox;

    static JPanel mainPan;
    static JPanel topPan;
    static JPanel bottomPan;

    String filename = "binarychoices_output.csv";
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
    String directory;
    String adminDirectory;

    //Note: everything called filename is stored in directory, everything else is stored in adminDirectory


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










    public selectionPage(List<Double> stage3, List<Double> stage4, boolean charge){

        setLayout(new BorderLayout());
        setTitle("Random Selections");
        setBounds(0, 0, 1000, 800);
        setLocationRelativeTo(null);

        directoryStore dirStore = new directoryStore();
        directory = dirStore.getDirectory();
        adminDirectory = dirStore.getAdminDirectory();

        box1 = new JTextField();
        box1.setEditable(false);
        box1.setBorder(new TitledBorder("Price Set 1"));
        box1.setText(Double.toString(stage3.get(0)));
        box1.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

        box2 = new JTextField();
        box2.setEditable(false);
        box2.setBorder(new TitledBorder("Price Set 2"));
        box2.setText(Double.toString(stage3.get(1)));
        box2.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

        box3 = new JTextField();
        box3.setEditable(false);
        box3.setBorder(new TitledBorder("Price Set 3"));
        box3.setText(Double.toString(stage3.get(2)));
        box3.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

        box4 = new JTextField();
        box4.setEditable(false);
        box4.setBorder(new TitledBorder("Price Set 4"));
        box4.setText(Double.toString(stage3.get(3)));
        box4.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

        box5 = new JTextField();
        box5.setEditable(false);
        box5.setBorder(new TitledBorder("Price Set 5"));
        box5.setText(Double.toString(stage3.get(4)));
        box5.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

        box6 = new JTextField();
        box6.setEditable(false);
        box6.setBorder(new TitledBorder("Price Set 6"));
        box6.setText(Double.toString(stage3.get(5)));
        box6.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

        box7 = new JTextField();
        box7.setEditable(false);
        box7.setBorder(new TitledBorder("Price Set 7"));
        box7.setText(Double.toString(stage3.get(6)));
        box7.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));

        box8 = new JTextField();
        box8.setEditable(false);
        box8.setBorder(new TitledBorder("Price Set 8"));
        box8.setText(Double.toString(stage3.get(7)));
        box8.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

        box9 = new JTextField();
        box9.setEditable(false);
        box9.setBorder(new TitledBorder("Price Set 9"));
        box9.setText(Double.toString(stage3.get(8)));
        box9.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

        box10 = new JTextField();
        box10.setEditable(false);
        box10.setBorder(new TitledBorder("Price Set 10"));
        box10.setText(Double.toString(stage3.get(9)));
        box10.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));



        box11 = new JTextField();
        box11.setEditable(false);
        box11.setBorder(new TitledBorder("Price Set 1"));
        box11.setText(Double.toString(stage4.get(0)));
        box11.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));


        box12 = new JTextField();
        box12.setEditable(false);
        box12.setBorder(new TitledBorder("Price Set 2"));
        box12.setText(Double.toString(stage4.get(1)));
        box12.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));


        box13 = new JTextField();
        box13.setEditable(false);
        box13.setBorder(new TitledBorder("Price Set 3"));
        box13.setText(Double.toString(stage4.get(2)));
        box13.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));


        box14 = new JTextField();
        box14.setEditable(false);
        box14.setBorder(new TitledBorder("Price Set 4"));
        box14.setText(Double.toString(stage4.get(3)));
        box14.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));


        box15 = new JTextField();
        box15.setEditable(false);
        box15.setBorder(new TitledBorder("Price Set 5"));
        box15.setText(Double.toString(stage4.get(4)));
        box15.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));



        box16 = new JTextField();
        box16.setEditable(false);
        box16.setBorder(new TitledBorder("Price Set 6"));
        box16.setText(Double.toString(stage4.get(5)));
        box16.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

        box17 = new JTextField();
        box17.setEditable(false);
        box17.setBorder(new TitledBorder("Price Set 7"));
        box17.setText(Double.toString(stage4.get(6)));
        box17.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));


        box18 = new JTextField();
        box18.setEditable(false);
        box18.setBorder(new TitledBorder("Price Set 8"));
        box18.setText(Double.toString(stage4.get(7)));
        box18.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));


        box19 = new JTextField();
        box19.setEditable(false);
        box19.setBorder(new TitledBorder("Price Set 9"));
        box19.setText(Double.toString(stage4.get(8)));
        box19.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));


        box20 = new JTextField();
        box20.setEditable(false);
        box20.setBorder(new TitledBorder("Price Set 10"));
        box20.setText(Double.toString(stage4.get(9)));
        box20.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));



        stg3Title = new JLabel();
        stg3Title.setText("Stage 3 Allocations");

        stg4Title = new JLabel();
        stg4Title.setText("Stage 4 Allocations");


        costBox = new JTextField();
        costBox.setBorder(new TitledBorder("Charges during experiment, if any"));
        if(charge){
            costBox.setText("1 Token");
        }

        totalBox = new JTextField();
        totalBox.setBorder(new TitledBorder("Your Total Payout"));
        double total1 = 0;
        double total2 = 0;
        for(int i = 0 ; i < stage3.size(); i++){
            total1 = total1 + stage3.get(i);
        }
        for(int i = 0 ; i < stage4.size(); i++){
            total2= total2 + stage4.get(i);
        }

        if(!charge) {
            totalBox.setText("Stage 3: " + Double.toString(total1) + " Stage 4: " + Double.toString(total2));
        }
        if(charge) {
            total1 = total1 - 1;
            total2 = total2 - 1;
            totalBox.setText("Stage 3: " + Double.toString(total1) + " Stage 4: " + Double.toString(total2));
        }

        mainPan = new JPanel(new GridLayout(10, 2, 5, 5));

        mainPan.add(box1);
        mainPan.add(box11);
        mainPan.add(box2);
        mainPan.add(box12);
        mainPan.add(box3);
        mainPan.add(box13);
        mainPan.add(box4);
        mainPan.add(box14);
        mainPan.add(box5);
        mainPan.add(box15);
        mainPan.add(box6);
        mainPan.add(box16);
        mainPan.add(box7);
        mainPan.add(box17);
        mainPan.add(box8);
        mainPan.add(box18);
        mainPan.add(box9);
        mainPan.add(box19);
        mainPan.add(box10);
        mainPan.add(box20);



        topPan = new JPanel(new GridLayout(1, 2, 5,5));
        bottomPan = new JPanel(new GridLayout(1, 2, 5, 5));

        topPan.add(stg3Title);
        topPan.add(stg4Title);

        bottomPan.add(costBox);
        bottomPan.add(totalBox);


        add(topPan, BorderLayout.NORTH);
        add(mainPan, BorderLayout.CENTER);
        add(bottomPan, BorderLayout.SOUTH);



        setVisible(true);


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




    public void writeToFile(FileWriter filer, Share share) {
        try {
            filer.write("\n" + "Security number = " + share.getSecurityNumber() + " Security price = " + share.getPrice() +
                    " Security Allocation = " + share.getAllocation() + "\n");

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










}
