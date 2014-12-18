package project;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

/**
 * Created by ihabib on 12/17/2014.
 */
public class phase3 extends JFrame{

//TODO: Plan: phase 3 is going to access the data stored in excel files from stage 1, by using the code we already have.
  //TODO: cont. going to turn that code into one half of the allocation page. The other half will be passed from stage 2
  //TODO: cont. Pressing buttons on the main stage3 phase will launch an allocation page comparing the data sets against
  //TODO: cont. each other. 2 buttons on the bottom asking the user if they want to switch or stay
  //TODO: potentially, show the user what there allocations would be with new prices? (code this option)



  static JFrame frameForPrices;


  static JButton button1;
  static JButton button2;
  static JButton button3;
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

  static JButton previewButton;

  static JPanel buttonPanel;
  static JPanel mainButtonsPanel;
  static JPanel topTitlePanel;



  static JLabel empty1;
  static JLabel empty2;

  static JLabel label1;
  static JLabel label2;
  static JLabel label3;


  static JTextField jtext;




  static Border raisedBorder;
  static Border loweredBorder;




  public phase3 () {


    setLayout(new BorderLayout());
    setTitle("Stage 3");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(0, 0, screenSize.width, screenSize.height - 45);

    raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
    loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);









    button1 = new JButton();
    button2  = new JButton();
    button3 = new JButton();
    button4 = new JButton();
    button5 = new JButton();
    button6 = new JButton();
    button7 = new JButton();
    button8 = new JButton();
    button9 = new JButton();
    button10 = new JButton();
    button11 = new JButton();
    button12 = new JButton();
    button13 = new JButton();
    button14 = new JButton();

    mainButtonsPanel = new JPanel(new GridLayout(10, 1, 5, 5));










































































  }

























































































}
