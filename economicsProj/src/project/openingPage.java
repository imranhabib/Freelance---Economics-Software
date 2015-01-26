package project;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ihabib on 12/11/2014.
 */
public class openingPage extends JFrame {


    static JFrame mainScreen;
    static JFrame frameForFile;
    static JPanel titleBar;
    static JSplitPane innerWindow;
    static JPanel topComp;
    static JPanel bottomComp;
    static JButton submit;
    static JTextField enterStuNum;
    static JTextField enterStuFirstName;
    static JTextField enterStuLastName;
    static JTextField enterExperNum;
    static JTextField enterStuNumConfirm;
    static JTextField enterStuFirstNameConfirm;
    static JTextField enterStuLastNameConfirm;
    static JTextField enterExperNumConfirm;
    static JTextField titlePane;
    static JTextField confirmation;
    static JLabel instrucs;
    static JButton submitStuNum;
    static JButton clear;
    static JButton savebutton;
    static JPanel buttonPanel;
    static JLabel pictureHolder;
    static JLabel fileSavedAs;
    static ImageIcon logo;
    static JFileChooser jfile;
    static JTextArea text;
    static ActionListener al;
    static ActionListener cl;
    static ActionListener al3;
    static ActionListener submitButton;



    static File outputfile;
    static Border raisedBorder;
    static Border loweredBorder;


    String directory = System.getProperty("user.home") + "/Desktop/";
    String adminDirectory = System.getProperty("user.home") + "/Desktop/";


    public openingPage(){
        mainScreen = new JFrame("Economics Experiment");
        mainScreen.setLayout(new BorderLayout());
        Dimension screenSize = new Dimension(600, 800);
        mainScreen.setBounds(0,0,1000,600);
        mainScreen.setLocationRelativeTo(null);


        raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
        loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);


        titleBar = new JPanel();
        titleBar.setBorder(new TitledBorder(loweredBorder, "Introduction"));
        titleBar.setLayout(new GridLayout(0, 1, 5, 5));
        titlePane = new JTextField();
        titlePane.setBorder(loweredBorder);
        titlePane.setEditable(false);
        titlePane.setText("Welcome");
        titlePane.setBackground(Color.BLACK);
        titlePane.setForeground(Color.BLUE);
        titlePane.setFont(new Font("Calibri", Font.BOLD, 30));

        titleBar.add(titlePane);

        innerWindow = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        innerWindow.setBorder(loweredBorder);
        innerWindow.setResizeWeight(0.85);

        //Top Component

        topComp = new JPanel();
        topComp.setLayout(new GridLayout(6, 2, 5, 5));
        topComp.setBorder(new TitledBorder("Enter data"));
        enterStuNum = new JTextField();
        enterStuNum.setBorder(new TitledBorder(loweredBorder, "Enter Student Number"));
        enterStuNum.setFont(new Font("Calibri", Font.BOLD, 15));
        enterStuLastName = new JTextField();
        enterStuLastName.setBorder(new TitledBorder(loweredBorder, "Enter Last Name"));
        enterStuLastName.setFont(new Font("Calibri", Font.BOLD, 15));
        enterStuFirstName = new JTextField();
        enterStuFirstName.setBorder(new TitledBorder(loweredBorder, "Enter First Name"));
        enterStuFirstName.setFont(new Font("Calibri", Font.BOLD, 15));
        enterExperNum = new JTextField();
        enterExperNum.setBorder(new TitledBorder(loweredBorder,"Enter Experiment Number"));
        enterExperNum.setFont(new Font("Calibri", Font.BOLD, 15));

        enterStuNumConfirm = new JTextField();
        enterStuNumConfirm.setEditable(false);
        enterStuNumConfirm.setBorder(new TitledBorder(raisedBorder, "Student Number"));
        enterStuNumConfirm.setFont(new Font("Calibri", Font.BOLD, 15));
        enterStuFirstNameConfirm = new JTextField();
        enterStuFirstNameConfirm.setEditable(false);
        enterStuFirstNameConfirm.setBorder(new TitledBorder(raisedBorder, "First Name"));
        enterStuFirstNameConfirm.setFont(new Font("Calibri", Font.BOLD, 15));
        enterStuLastNameConfirm = new JTextField();
        enterStuLastNameConfirm.setEditable(false);
        enterStuLastNameConfirm.setBorder(new TitledBorder(raisedBorder, "Last Name"));
        enterStuLastNameConfirm.setFont(new Font("Calibri", Font.BOLD, 15));
        enterExperNumConfirm = new JTextField();
        enterExperNumConfirm.setEditable(false);
        enterExperNumConfirm.setBorder(new TitledBorder(raisedBorder, "Experiment Number"));
        enterExperNumConfirm.setFont(new Font("Calibri", Font.BOLD, 15));


        clear = new JButton("Clear Information");
        clear.setBorder(loweredBorder);
        clear.setBackground(Color.black);
        clear.setForeground(Color.red);



        submitStuNum = new JButton("Submit information");
        submitStuNum.setBorder(loweredBorder);
        submitStuNum.setForeground(Color.white);
        submitStuNum.setBackground(Color.black);

        confirmation = new JTextField();
        confirmation.setEditable(false);
        confirmation.setBorder(new TitledBorder(loweredBorder, "Confirmation"));




        topComp.add(enterStuFirstName);
        topComp.add(enterStuFirstNameConfirm);
        topComp.add(enterStuLastName);
        topComp.add(enterStuLastNameConfirm);
        topComp.add(enterStuNum);
        topComp.add(enterStuNumConfirm);
        topComp.add(enterExperNum);
        topComp.add(enterExperNumConfirm);
        topComp.add(submitStuNum);
        topComp.add(confirmation);
        topComp.add(clear);

        innerWindow.setTopComponent(topComp);
        innerWindow.setBackground(Color.DARK_GRAY);


        instrucs = new JLabel();
        instrucs.setText("Please name file: output.csv -->");
        instrucs.setFont(new Font("Calibri", Font.BOLD, 15));
        instrucs.setBorder(raisedBorder);




        savebutton = new JButton("Browse...");
        savebutton.setEnabled(false);
        Dimension dim2 = new Dimension(100, 50);
        savebutton.setBorder(new TitledBorder("File Location"));
        savebutton.setPreferredSize(dim2);
        buttonPanel = new JPanel(new BorderLayout());

        fileSavedAs = new JLabel();
        fileSavedAs.setBorder(new TitledBorder(raisedBorder, "File is saved here"));


        buttonPanel.add(instrucs, BorderLayout.LINE_START);
        buttonPanel.add(savebutton, BorderLayout.CENTER);
        buttonPanel.add(fileSavedAs, BorderLayout.LINE_END);

        text = new JTextArea(5,20);
        text.setMargin(new Insets(5, 5, 5, 5));
        text.setEditable(false);


        innerWindow.setBottomComponent(buttonPanel);



        frameForFile = new JFrame();
        frameForFile.setSize(820, 600);
        frameForFile.setPreferredSize(new Dimension(820, 600));
        frameForFile.setLayout(new BorderLayout());
        frameForFile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);




        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == savebutton) {
                    jfile = new JFileChooser(getDirectory());
                    System.out.println(jfile.getName());
                    jfile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    int returnVal = jfile.showSaveDialog(frameForFile);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        outputfile = jfile.getSelectedFile();

                        if (!outputfile.getName().contains(".csv")) {
                            File newN = new File(outputfile.getAbsolutePath().concat(".csv"));
                            outputfile = newN;
                        }
                        if (outputfile.exists()) {
                            JOptionPane.showMessageDialog(frameForFile,
                                    "File already exists",
                                    "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        }

                        saveFile(outputfile);
                        FileWriter fw = createFileWriter(outputfile);
                        formatFile(fw);
                        closeFile(fw);
                        fileSavedAs.setText("Selected file: " + outputfile.getName());
                        submit.setEnabled(true);

                    }
                }
            }

        };



        al3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == clear){
                    Object[] options = { "OK", "CANCEL" };
                    final int option = JOptionPane.showOptionDialog(null, "Are you sure you want to clear data?", "Warning",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                    if(option == JOptionPane.OK_OPTION){
                        enterStuNum.setText("");
                        enterStuFirstName.setText("");
                        enterStuLastName.setText("");
                        enterExperNum.setText("");
                        enterStuNumConfirm.setText("");
                        enterStuFirstNameConfirm.setText("");
                        enterStuLastNameConfirm.setText("");
                        enterExperNumConfirm.setText("");
                        confirmation.setText("");


                    }
                    else if(option == JOptionPane.CANCEL_OPTION) {
                        return;
                    }

                }


            }
        };

        clear.addActionListener(al3);

        cl = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                if(e.getSource() == submitStuNum){

                    Object[] options = { "OK", "CANCEL" };
                    final int option = JOptionPane.showOptionDialog(null, "Are you sure you want to submit data?", "Warning",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);

                    if(option == JOptionPane.CANCEL_OPTION){
                        return;
                    }

                    if(option == JOptionPane.OK_OPTION) {

                        if (enterStuFirstName.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Please enter a first name", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            enterStuFirstNameConfirm.setText(enterStuFirstName.getText());
                        }


                        if (enterStuLastName.getText().equals("")) {
                            if (!enterStuFirstName.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, enterStuFirstName.getText() + ", you must enter your last name", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            JOptionPane.showMessageDialog(null, "Please enter a last name", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            enterStuLastNameConfirm.setText(enterStuLastName.getText());
                        }


                        if (enterStuNum.getText().equals("")) {
                            if (!enterStuFirstName.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, enterStuFirstName.getText() + ", you must enter a student number", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            JOptionPane.showMessageDialog(null, "Please enter a student number", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            enterStuNumConfirm.setText(enterStuNum.getText());
                        }


                        if (enterExperNum.getText().equals("")) {
                            if (!enterStuFirstName.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, enterStuFirstName.getText() + ", you must enter the experiment number", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            JOptionPane.showMessageDialog(null, "Please enter an experiment number", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            enterExperNumConfirm.setText(enterExperNum.getText());
                        }

                    }
                    confirmation.setText("Thanks " + enterStuFirstName.getText() + ", your information has been saved");
                    savebutton.setEnabled(true);
                    setDirectory(directory + enterStuLastName.getText()+enterStuNum.getText());
                    setAdminDirectory(adminDirectory + enterStuLastName.getText()+enterStuNum.getText() + "(Admin Data)");
                    directoryStore dirStore = new directoryStore(getDirectory());
                    dirStore.setDirectory(getDirectory());
                    dirStore.setAdminDirectory(getAdminDirectory());
                    File dir = new File(getDirectory());
                    dir.mkdir();
                    File adminDir = new File(getAdminDirectory());
                    adminDir.mkdir();
                }


            }


        };


        submitButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainScreen.setVisible(false);
                mainScreen.dispose();
                instructions instruc = new instructions();
                instruc.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                instruc.setVisible(true);
            }
        };

        savebutton.addActionListener(al);
        submitStuNum.addActionListener(cl);


        submit = new JButton("Continue");
        submit.setEnabled(false);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(submitButton);


        mainScreen.add(titleBar, BorderLayout.NORTH);
        mainScreen.add(innerWindow, BorderLayout.CENTER);
        mainScreen.add(submit, BorderLayout.SOUTH);


        mainScreen.setVisible(true);




    }



    public void saveFile(File file){
        try {
            if (file.createNewFile()) {
                System.out.println("here");
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
        try {
            filer.write("\n" + "Name: " + enterStuFirstName.getText() +
                    " " + enterStuLastName.getText() + "\n" + "Student Number: " + enterStuNum.getText() + "\n" + "Experiment Number: " + enterExperNum.getText());
        } catch (IOException e) {
            System.out.println("new file code failed");
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


    public void setDirectory(String dir){
        directory = dir;
    }

    public void setAdminDirectory(String dir){
        adminDirectory = dir;
    }

    public String getDirectory (){
        return directory;
    }
    public String getAdminDirectory (){
        return adminDirectory;
    }





    public static void main (String[] args) throws Exception {
        openingPage open = new openingPage();
    }











}







































































