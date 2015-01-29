package project;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


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

  String filename = "binarychoices-output.csv";

  String filename1 = "Stage3priceSet1FinalAllocation.csv";
  String filename2 = "Stage3priceSet2FinalAllocation.csv";
  String filename3 = "Stage3priceSet3FinalAllocation.csv";
  String filename4 = "Stage3priceSet4FinalAllocation.csv";
  String filename5 = "Stage3priceSet5FinalAllocation.csv";
  String filename6 = "Stage3priceSet6FinalAllocation.csv";
  String filename7 = "Stage3priceSet7FinalAllocation.csv";
  String filename8 = "Stage3priceSet8FinalAllocation.csv";
  String filename9 = "Stage3priceSet9FinalAllocation.csv";
  String filename10 = "Stage3priceSet10FinalAllocation.csv";

  String filename11 = "Stage4priceSet1FinalAllocation.csv";
  String filename12 = "Stage4priceSet2FinalAllocation.csv";
  String filename13 = "Stage4priceSet3FinalAllocation.csv";
  String filename14 = "Stage4priceSet4FinalAllocation.csv";
  String filename15 = "Stage4priceSet5FinalAllocation.csv";
  String filename16 = "Stage4priceSet6FinalAllocation.csv";
  String filename17 = "Stage4priceSet7FinalAllocation.csv";
  String filename18 = "Stage4priceSet8FinalAllocation.csv";
  String filename19 = "Stage4priceSet9FinalAllocation.csv";
  String filename20 = "Stage4priceSet10FinalAllocation.csv";


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

  File file11;
  File file12;
  File file13;
  File file14;
  File file15;
  File file16;
  File file17;
  File file18;
  File file19;
  File file20;

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

  FileWriter filer11;
  FileWriter filer12;
  FileWriter filer13;
  FileWriter filer14;
  FileWriter filer15;
  FileWriter filer16;
  FileWriter filer17;
  FileWriter filer18;
  FileWriter filer19;
  FileWriter filer20;











  public selectionPage(List<Double> stage3, List<Integer> stage3Choices, List<Double> stage4, List<Integer> stage4Choices,  boolean charge){

    setLayout(new BorderLayout());
    setTitle("Random Selections");
    setBounds(0, 0, 1000, 800);
    setLocationRelativeTo(null);

    directoryStore dirStore = new directoryStore();
    directory = dirStore.getDirectory();
    adminDirectory = dirStore.getAdminDirectory();

    box1 = new JTextField();
    box1.setEditable(false);
    box1.setBorder(new TitledBorder("Price Set 1" + " Security Chosen = " + (stage3Choices.get(0) + 1)));
    box1.setText(Double.toString(stage3.get(0)));
    box1.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

    box2 = new JTextField();
    box2.setEditable(false);
    box2.setBorder(new TitledBorder("Price Set 2" + " Security Chosen = " + (stage3Choices.get(1) + 1)));
    box2.setText(Double.toString(stage3.get(1)));
    box2.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

    box3 = new JTextField();
    box3.setEditable(false);
    box3.setBorder(new TitledBorder("Price Set 3" + " Security Chosen = " + (stage3Choices.get(2) + 1)));
    box3.setText(Double.toString(stage3.get(2)));
    box3.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

    box4 = new JTextField();
    box4.setEditable(false);
    box4.setBorder(new TitledBorder("Price Set 4" + " Security Chosen = " + (stage3Choices.get(3) + 1)));
    box4.setText(Double.toString(stage3.get(3)));
    box4.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

    box5 = new JTextField();
    box5.setEditable(false);
    box5.setBorder(new TitledBorder("Price Set 5" + " Security Chosen = " + (stage3Choices.get(4) + 1)));
    box5.setText(Double.toString(stage3.get(4)));
    box5.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

    box6 = new JTextField();
    box6.setEditable(false);
    box6.setBorder(new TitledBorder("Price Set 6" + " Security Chosen = " + (stage3Choices.get(5) + 1)));
    box6.setText(Double.toString(stage3.get(5)));
    box6.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

    box7 = new JTextField();
    box7.setEditable(false);
    box7.setBorder(new TitledBorder("Price Set 7" + " Security Chosen = " + (stage3Choices.get(6) + 1)));
    box7.setText(Double.toString(stage3.get(6)));
    box7.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));

    box8 = new JTextField();
    box8.setEditable(false);
    box8.setBorder(new TitledBorder("Price Set 8" + " Security Chosen = " + (stage3Choices.get(7) + 1)));
    box8.setText(Double.toString(stage3.get(7)));
    box8.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

    box9 = new JTextField();
    box9.setEditable(false);
    box9.setBorder(new TitledBorder("Price Set 9" + " Security Chosen = " + (stage3Choices.get(8) + 1)));
    box9.setText(Double.toString(stage3.get(8)));
    box9.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

    box10 = new JTextField();
    box10.setEditable(false);
    box10.setBorder(new TitledBorder("Price Set 10" + " Security Chosen = " + (stage3Choices.get(9) + 1)));
    box10.setText(Double.toString(stage3.get(9)));
    box10.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));



    box11 = new JTextField();
    box11.setEditable(false);
    box11.setBorder(new TitledBorder("Price Set 1"+ " Security Chosen = " + (stage4Choices.get(0) + 1)));
    box11.setText(Double.toString(stage4.get(0)));
    box11.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));


    box12 = new JTextField();
    box12.setEditable(false);
    box12.setBorder(new TitledBorder("Price Set 2"+ " Security Chosen = " + (stage4Choices.get(1) + 1)));
    box12.setText(Double.toString(stage4.get(1)));
    box12.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));


    box13 = new JTextField();
    box13.setEditable(false);
    box13.setBorder(new TitledBorder("Price Set 3"+ " Security Chosen = " + (stage4Choices.get(2) + 1)));
    box13.setText(Double.toString(stage4.get(2)));
    box13.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));


    box14 = new JTextField();
    box14.setEditable(false);
    box14.setBorder(new TitledBorder("Price Set 4"+ " Security Chosen = " + (stage4Choices.get(3) + 1)));
    box14.setText(Double.toString(stage4.get(3)));
    box14.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));


    box15 = new JTextField();
    box15.setEditable(false);
    box15.setBorder(new TitledBorder("Price Set 5"+ " Security Chosen = " + (stage4Choices.get(4) + 1)));
    box15.setText(Double.toString(stage4.get(4)));
    box15.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));



    box16 = new JTextField();
    box16.setEditable(false);
    box16.setBorder(new TitledBorder("Price Set 6"+ " Security Chosen = " + (stage4Choices.get(5) + 1)));
    box16.setText(Double.toString(stage4.get(5)));
    box16.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));

    box17 = new JTextField();
    box17.setEditable(false);
    box17.setBorder(new TitledBorder("Price Set 7"+ " Security Chosen = " + (stage4Choices.get(6) + 1)));
    box17.setText(Double.toString(stage4.get(6)));
    box17.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));


    box18 = new JTextField();
    box18.setEditable(false);
    box18.setBorder(new TitledBorder("Price Set 8"+ " Security Chosen = " + (stage4Choices.get(7) + 1)));
    box18.setText(Double.toString(stage4.get(7)));
    box18.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));


    box19 = new JTextField();
    box19.setEditable(false);
    box19.setBorder(new TitledBorder("Price Set 9"+ " Security Chosen = " + (stage4Choices.get(8) + 1)));
    box19.setText(Double.toString(stage4.get(8)));
    box19.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));


    box20 = new JTextField();
    box20.setEditable(false);
    box20.setBorder(new TitledBorder("Price Set 10"+ " Security Chosen = " + (stage4Choices.get(9) + 1)));
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


    String data = Double.toString(total1);
    String splitter = data.substring(data.indexOf("."));
    if(splitter.length() > 2){
      splitter = splitter.substring(0, 3);
    }
    data = data.substring(0, data.indexOf(".")) + splitter;



    String data2 = Double.toString(total2);
    String splitter2 = data2.substring(data2.indexOf("."));
    if(splitter2.length() > 2){
      splitter2 = splitter2.substring(0, 3);
    }
    data2 = data2.substring(0, data2.indexOf(".")) + splitter2;



    if(!charge) {
      totalBox.setText("Stage 3: " + data + " Stage 4: " + data2);
    }
    if(charge) {
      total1 = total1 - 1;

      String data3= Double.toString(total1);
      String splitter3 = data3.substring(data3.indexOf("."));
      if(splitter3.length() > 2){
        splitter3 = splitter3.substring(0, 3);
      }
      data3 = data3.substring(0, data3.indexOf(".")) + splitter3;


      total2 = total2 - 1;



      String data4 = Double.toString(total2);
      String splitter4 = data4.substring(data4.indexOf("."));
      if(splitter4.length() > 2){
        splitter4 = splitter4.substring(0, 3);
      }
      data4 = data4.substring(0, data4.indexOf(".")) + splitter4;

      totalBox.setText("Stage 3: " + data3 + " Stage 4: " + data4);
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



    file = new File(directory, filename);

    if (!file.exists()) {
      file = new File(directory, filename);
      fileCreator(file);
    }

      filer = createFileWriter(file);
      formatFile(filer, 3);
      for (int i = 0 ; i < stage3.size(); i++) {
        writeToFile(filer, stage3.get(i), i + 1, stage3Choices.get(i));
      }
      closeFile(filer);

    //seperate from user file and admin files

      file1 = new File(adminDirectory, filename1);
      fileCreator(file1);

        if (!file1.exists()) {
          file1 = new File(adminDirectory, filename1);
          fileCreator(file1);
        }

        filer1 = createFileWriter(file1);

       writeToFile(filer1, stage3.get(0), 1, stage3Choices.get(0));

       closeFile(filer1);

//seperate

    file2 = new File(adminDirectory, filename2);
    fileCreator(file2);

    if (!file2.exists()) {
      file2 = new File(adminDirectory, filename2);
      fileCreator(file2);
    }

    filer2 = createFileWriter(file2);

    writeToFile(filer2, stage3.get(1), 2, stage3Choices.get(1));

    closeFile(filer2);
//seperate

    file3 = new File(adminDirectory, filename3);
    fileCreator(file3);

    if (!file3.exists()) {
      file3 = new File(adminDirectory, filename3);
      fileCreator(file3);
    }

    filer3 = createFileWriter(file3);

    writeToFile(filer3, stage3.get(2), 3, stage3Choices.get(2));

    closeFile(filer3);

    //seperate


    file4 = new File(adminDirectory, filename4);
    fileCreator(file4);

    if (!file4.exists()) {
      file4 = new File(adminDirectory, filename4);
      fileCreator(file4);
    }

    filer4 = createFileWriter(file4);

    writeToFile(filer4, stage3.get(3), 4, stage3Choices.get(3));

    closeFile(filer4);

//seperate



    file5 = new File(adminDirectory, filename5);
    fileCreator(file5);

    if (!file5.exists()) {
      file5 = new File(adminDirectory, filename5);
      fileCreator(file5);
    }

    filer5 = createFileWriter(file5);

    writeToFile(filer5, stage3.get(4), 5, stage3Choices.get(4));

    closeFile(filer5);

//seperate


    file6 = new File(adminDirectory, filename6);
    fileCreator(file6);

    if (!file6.exists()) {
      file6 = new File(adminDirectory, filename6);
      fileCreator(file6);
    }

    filer6 = createFileWriter(file6);

    writeToFile(filer6, stage3.get(5), 6, stage3Choices.get(5));

    closeFile(filer6);


//seperate
    file7 = new File(adminDirectory, filename7);
    fileCreator(file7);

    if (!file7.exists()) {
      file7 = new File(adminDirectory, filename7);
      fileCreator(file7);
    }

    filer7 = createFileWriter(file7);

    writeToFile(filer7, stage3.get(6), 7, stage3Choices.get(6));

    closeFile(filer7);

//seperate


    file8 = new File(adminDirectory, filename8);
    fileCreator(file8);

    if (!file8.exists()) {
      file8 = new File(adminDirectory, filename8);
      fileCreator(file8);
    }

    filer8 = createFileWriter(file8);

    writeToFile(filer8, stage3.get(7), 8, stage3Choices.get(7));

    closeFile(filer8);

    // seperate

    file9 = new File(adminDirectory, filename9);
    fileCreator(file9);

    if (!file9.exists()) {
      file9 = new File(adminDirectory, filename9);
      fileCreator(file9);
    }

    filer9 = createFileWriter(file9);

    writeToFile(filer9, stage3.get(8), 9, stage3Choices.get(8));

    closeFile(filer9);


    //seperate


    file10 = new File(adminDirectory, filename10);
    fileCreator(file10);

    if (!file10.exists()) {
      file10 = new File(adminDirectory, filename10);
      fileCreator(file10);
    }

    filer10 = createFileWriter(file10);

    writeToFile(filer10, stage3.get(9), 10, stage3Choices.get(9));

    closeFile(filer10);


    //excel files for the second round


    if (!file.exists()) {
      file = new File(directory, filename);
      fileCreator(file);
    }

    filer = createFileWriter(file);
    formatFile(filer, 4);
    for (int i = 0 ; i < stage4.size(); i++) {
      writeToFile(filer, stage4.get(i), i + 1, stage4Choices.get(i));
    }
    closeFile(filer);

    //seperate from user file and admin files

    file11 = new File(adminDirectory, filename11);
    fileCreator(file11);

    if (!file11.exists()) {
      file11 = new File(adminDirectory, filename11);
      fileCreator(file11);
    }

    filer11 = createFileWriter(file11);

    writeToFile(filer11, stage4.get(0), 1, stage4Choices.get(0));

    closeFile(filer11);

//seperate

    file12 = new File(adminDirectory, filename12);
    fileCreator(file12);

    if (!file12.exists()) {
      file12 = new File(adminDirectory, filename12);
      fileCreator(file12);
    }

    filer12 = createFileWriter(file12);

    writeToFile(filer12, stage4.get(1), 2, stage4Choices.get(1));

    closeFile(filer12);
//seperate

    file13 = new File(adminDirectory, filename13);
    fileCreator(file13);

    if (!file13.exists()) {
      file13 = new File(adminDirectory, filename13);
      fileCreator(file13);
    }

    filer13 = createFileWriter(file13);

    writeToFile(filer13, stage4.get(2), 3, stage4Choices.get(2));

    closeFile(filer13);

    //seperate


    file14 = new File(adminDirectory, filename14);
    fileCreator(file14);

    if (!file14.exists()) {
      file14 = new File(adminDirectory, filename14);
      fileCreator(file14);
    }

    filer14 = createFileWriter(file14);

    writeToFile(filer14, stage4.get(3), 4, stage4Choices.get(3));

    closeFile(filer14);

//seperate



    file15 = new File(adminDirectory, filename15);
    fileCreator(file15);

    if (!file15.exists()) {
      file15 = new File(adminDirectory, filename15);
      fileCreator(file15);
    }

    filer15 = createFileWriter(file15);

    writeToFile(filer15, stage4.get(4), 5, stage4Choices.get(4));

    closeFile(filer15);

//seperate


    file16 = new File(adminDirectory, filename16);
    fileCreator(file16);

    if (!file16.exists()) {
      file16 = new File(adminDirectory, filename16);
      fileCreator(file16);
    }

    filer16 = createFileWriter(file16);

    writeToFile(filer16, stage4.get(5), 6, stage4Choices.get(5));

    closeFile(filer16);


//seperate
    file17 = new File(adminDirectory, filename17);
    fileCreator(file17);

    if (!file17.exists()) {
      file17 = new File(adminDirectory, filename17);
      fileCreator(file17);
    }

    filer17 = createFileWriter(file17);

    writeToFile(filer17, stage4.get(6), 7, stage4Choices.get(6));

    closeFile(filer17);

//seperate


    file18 = new File(adminDirectory, filename18);
    fileCreator(file18);

    if (!file18.exists()) {
      file18 = new File(adminDirectory, filename18);
      fileCreator(file18);
    }

    filer18 = createFileWriter(file18);

    writeToFile(filer18, stage4.get(7), 8, stage4Choices.get(7));

    closeFile(filer18);

    // seperate

    file19 = new File(adminDirectory, filename19);
    fileCreator(file19);

    if (!file19.exists()) {
      file19 = new File(adminDirectory, filename19);
      fileCreator(file19);
    }

    filer19 = createFileWriter(file19);

    writeToFile(filer19, stage4.get(8), 9, stage4Choices.get(8));

    closeFile(filer19);


    //seperate


    file20 = new File(adminDirectory, filename20);
    fileCreator(file20);

    if (!file20.exists()) {
      file20 = new File(adminDirectory, filename20);
      fileCreator(file20);
    }

    filer20 = createFileWriter(file20);

    writeToFile(filer20, stage4.get(9), 10, stage4Choices.get(9));

    closeFile(filer20);



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




  public void formatFile(FileWriter filer, int stage) {
    try {
      filer.write("\n" + "Final Allocations - " + " Stage " + stage + "\n");
    } catch (IOException e) {
      System.out.println("new file code failed");
    }


  }

  public void writeToFile(FileWriter filer, double alloc, int i, int j) {
    try {
      filer.write("\n" + "Security Randomly Chosen = " + j + " Price Set = " + i +
          " Security Allocation = " + alloc + "\n");

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
