package project;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

/**
 * Created by ihabib on 12/12/2014.
 */
public class instructions {

  private String newline = "\n";
  private String newtab = "\t\t\t\t";
  static JFrame instrucsWindow;
  static JScrollPane scroller;
  static JTextArea texter;
  static JEditorPane editPane;
  static JPanel rightPane;
  static JButton next;
  static Border raisedBorder;
  static Border loweredBorder;
  static JTextField legend;





  String initString_part1;



  public instructions(){

    initString_part1 = "Welcome" + newline + //bold
        "Welcome to the experiment. " //regular
            + "Please silence your cell phone and put it away for the duration of the experiment. "
            + "Additionally, please avoid any discussions with other participants. "
            + "At any time, if you have any questions please raise your hand and an experiment coordinator "
            + "will approach you." + newline + newline +

        newtab + "Please note: " +  //bold
        "If you want to review the instructions at any point during the experiment, "  //regular
            + "simply click on this window (the instructions window). To return to the experiment, "
            + "please click on the experiment icon on the taskbar." + newline + newline +


        "Study Procedures" + //bold
        newline + "This is an experiment in individual decision making. The study has two parts and the "   //regular
            + "second part will begin immediately following completion of the first part. Before Part 1, "
            + "the instructions will be read aloud by the experiment coordinator and you will be given "
            + "an opportunity to practice. The practice time will allow you to familiarize yourself with "
            + "the experimental interface and ask any questions you may have. We describe the parts of "
            + "the experiment in reverse order, beginning with Part 2 now." + newline +


        newline + "Part 2:" + newline +  //bold

        "You will be presented with 9 independent decision problems that share a common form. In each round "
            + "you will be given a choice between a pair of allocations of tokens between two accounts, labeled x "
            + "and y. Each choice will involve choosing a point on a two-dimensional graph that represents the values "
            + "in the two accounts. The x-account is represented by the x-axis and the y-account is represented by "
            + "the y-axis. " +
            newline + newline
            + newtab + "For all rounds, in Option 1 the amount allocated to the x-account and y-account will differ, "
            + "and in Option 2 the amount allocated to each account will be the same. For both options, "
            + "the values allocated to each account will be displayed beside the point corresponding to "
            + "each option on the graph, as well as, in the dialog box labeled “Options” on the right-hand "
            + "side of the screen. Figure 1 illustrates some examples of types of choices you may face." + newline + newline +

        "Figure 1" + newline +  //image	1
        " " +               //icon1

        newline + newline + newtab + "For the round that is selected for payment, your payment is determined by the number of "
            + "tokens allocated to each account. At the end of the experiment, you will toss a fair coin to "
            + "randomly select one of the two accounts, x or y. For each participant, each account is equally "
            + "likely to be chosen. That is, there is a 50% chance account x will be selected and a 50% chance "
            + "account y will be chosen. You will only receive the amount of tokens you allocated to the account "
            + "that was chosen. The round for which you will be paid will be selected randomly at the conclusion "
            + "of the experiment and each round is equally likely to be chosen. Remember that tokens are valued "
            + "at the following conversion rate: " +  "2 tokens = $1." + newline + newline +


        newtab + "Please Note: " +
        "Only one round (from both parts combined) will be selected for payment and your payment will be determined "
            + "only after completion of both parts." + newline + newline +

        newtab + "Each round begins with the computer selecting a pair of allocations. For example, as illustrated in "
            + "Figure 2, Option 1, if selected, implies a 50% chance of winning 32.0 tokens and a 50% chance of "
            + "wining 58.0 tokens, where as Option 2, if selected, implies winning 43.0 tokens for sure. " +

        newline + newline + "Figure 2" + newline +  //image	2
        " " +           //icon2

        newline + newline + newtab + "In some cases, the two options will be so close to each other that it will be difficult to distinguish "
            + "between them graphically. In this case, you may refer to the “Options” box on the right-hand side of "
            + "the screen where the values associated with each option are listed. Additionally, it may be difficult "
            + "to select your preferred option by clicking on the graph itself, so instead you may use the radio "
            + "buttons in the “Options” box to make you selection. Figure 3 provides an example of this situation." + newline + newline +

        "Figure 3" + newline +   //image	3
        " " +                //icon3

        newline + newline + newtab + "In all rounds, you may select a particular allocation in either of two ways: "
            + "1) You may use the mouse to move the pointer on the computer screen to the option that you desire, "
            + "and when you are ready to make your decision, simply left-click near that option, or "
            + "2) You may select your preferred option using the radio buttons on the right-hand side of "
            + "the screen, and when you are ready to make your decision, simply left-click on the radio "
            + "button that corresponds to your choice. In either case, a dialog box, illustrated in Figure 4, "
            + "will ask you to confirm your decision by clicking “OK”. " + newline + newline +

        "Figure 4" + newline +   //image	4
        " " +                 //icon4


        newline + newline + newtab + "If you wish to revise your choice simply click “Cancel” instead. After you click “OK”, "
            + "your choice will be highlighted in green and the screen will darken, as illustrated in Figure 5, "
            + "indicating that your choice is confirmed. You may proceed to the next round by clicking on the “>>” "
            + "button located in the lower right-hand corner of the screen in the box labeled “Controls”. "
            + "Please note that you will be given an opportunity to review and edit your choices upon completion of "
            + "Part 2 of the experiment." + newline + newline +

        "Figure 5" + newline +   //image	5
        " " +            //icon5


        newline + newline + newtab + "Next. you will be asked to make an allocation in another independent decision "
            + "problem. This process will be repeated until all 9 rounds are completed. At the end of the "
            + "last round, you must click the “Finish” button, located in the lower right-hand corner of "
            + "the screen in the box labeled “Controls”, and you will be given an opportunity to review your "
            + "choices. You may use the navigation buttons to move between choices or the “Jump to” feature in "
            + "the “Edit Panel” to navigate to a specific round. If you are content with your choices, you may "
            + "exit the review by clicking on the “Finish” button. At this stage you may no longer go back to "
            + "review and/or edit your choices. Instead, click “OK” to complete the experiment." + newline + newline +


        newline + "Part 1:" + newline +  //bold

        "In Part 1, you will be presented with 22 independent decision problems that are very similar to "
            + "those in Part 2. However, rather than selecting an allocation from among only two options, now "
            + "you will have many options to choose from. In each round your available options will be illustrated "
            + "by a straight line on the graph and you will make your choice by selecting a point on this line. "
            + "As in Part 2, your payoff in the round that is selected for payment is determined by the number of "
            + "tokens allocated to each account. Examples of different lines you may face are illustrated in Figure 6." + newline + newline +

        "Figure 6" + newline +  //image	6
        " " +

        newline + newline + newtab + "Figure 7 illustrates the differences and similarities between the problems in Part 1 "
            + "and Part 2. In Part 2, you are offered the choice between only two options, A and B. On the other "
            + "hand, if we were to draw a straight line between these options and allow one to choose any point "
            + "on this line, then this would increase the number of available choices. Notice, however, that the "
            + "two original options are still available as well as many more. Hence, the problems in Part 1 are "
            + "conceptually the same as in Part 2, but with many more possible allocations." + newline + newline +

        "Figure 7" + newline +  //image	7
        " " +               //icon7

        newline + newline + newtab + "The following two examples further illustrate the nature of the problem. If, in a particular round, "
            + "you were to select an allocation where the amount in one of the accounts is zero, for example if you "
            + "allocate all tokens to account x and $0 to account y (or vice versa), then in the event that this round "
            + "is chosen for payment there is a 50% chance you will receive nothing at all, and a 50% chance you will "
            + "receive the highest possible payment available in that round. In contrast, if you were to select "
            + "an allocation where the amount in accounts x and y are equal, then in the event that this round is chosen "
            + "for payment you will receive this amount regardless of which account is chosen by the coin toss."
            + newline + newline + newtab + "Each round begins with the computer selecting a line. As in Part 2, the lines selected "
            + "for you in different rounds are independent of each other. For example, as illustrated in Figure 8, "
            + "choice A represents an allocation in which you allocate approximately 12.8 tokens in the x-account "
            + "and 40.5 tokens in the y-account. Another possible allocation is choice B, in which you allocate "
            + "30.4 tokens in the x-account and 18.4 tokens in the y-account." + newline + newline +

        "Figure 8" + newline+  //image	8
        " "+                //icon8

        newline + newline + newtab + "To choose an allocation, use the mouse to move the pointer on the computer screen to "
            + "the allocation that you desire. On the right hand side of the program dialog window you will be able "
            + "to see the exact allocation where the pointer is located. Please note that, in each choice, you may "
            + "only choose an allocation which lies on the line provided. Additionally, if you select an allocation "
            + "that is close to the x-axis or the y-axis, you will be asked if you would like to select an "
            + "allocation on the boundary or if you intended for your choice to be as originally selected. "
            + "Similarly, if you select an allocation that is close to the middle, (roughly the same amounts "
            + "in each account), you will be asked if you would like to select an allocation where the amount "
            + "in each account are exactly equal or if you intended for your choice to be as originally selected. "
            + "The dialog boxes associated with these scenarios are illustrated in Figure 9." + newline + newline +

        "Figure 9" + newline +   //image	9
        " " +                //icon9

        newline + newline + newtab + "The controls to confirm your choices and navigate between rounds are identical to "
            + "those described above for Part 2. Once you have finished with all 22 rounds, you will be given "
            + "an opportunity to review your choices. You may conclude your review by clicking on the finish "
            + "button in the ``Edit Panel” at any time. Once complete, please click on the instructions window "
            + "in order to move on to Part 2." +

        newline + newline + newtab + "Please remember that there are no “right” or “wrong” choices. Your preferences "
            + "may be different from other participants, and as a result your choices can be different. "
            + "Please note that as in all experiments in Economics, the procedures are described fully "
            + "and all payments are real." + newline + newline +

        "Compensation" + newline +  // bold
        "After completing both parts of the experiment you will be informed of your payment via an on-screen dialog box. "
            + "Payments are determined as follows:" +
            newline + newline + newtab + "The computer will randomly select one decision round from both parts (combined) to "
            + "carry out. The round selected depends solely on chance and it is equally likely that any particular "
            + "round will be chosen. The payment dialog box will inform you of which round was randomly chosen as "
            + "well as your choice in that round. At this point please raise your hand and an experiment coordinator "
            + "will provide you with a fair coin, e.g. a quarter. To determine your final payoff, please flip the "
            + "coin. If it lands heads, you will be paid according to the amount of tokens in the x-account and if "
            + "it lands tails, you will be paid according to the amount of tokens in the y-account. For both parts "
            + "of the experiment, tokens are valued at the following conversion rate:" + newline + newline +

        newtab + newtab + newtab + newtab + newtab + newtab + newtab + newtab +
            newtab + newtab + "\t\t" + "2 tokens = $1" +

        newline + newline + newtab + "You will receive your payment, along with the $10 show-up bonus, privately before you "
            + "leave the lab. You will be asked to sign a receipt acknowledging receipt of your payment, "
            + "after which time you may leave.";



    instrucsWindow = new JFrame();
    instrucsWindow.setLayout(new BorderLayout());
    instrucsWindow.setBounds(0, 0, 1500, 800);
    instrucsWindow.setLocationRelativeTo(null);

    raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
    loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

    texter = new JTextArea(initString_part1);
    texter.setFont(new Font("Calibri", Font.BOLD, 16));
    texter.setLineWrap(true);
    texter.setWrapStyleWord(true);

    scroller = new JScrollPane(texter);
    scroller.setVerticalScrollBarPolicy(
        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


    next = new JButton("Continue");
    next.setBorder(raisedBorder);


    legend = new JTextField();
    legend.setBorder(raisedBorder);
    legend.setFont(new Font("Calibri", Font.BOLD, 16));
    legend.setEditable(false);
    legend.setText("Instructions window will remain open during the experiment");



    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int) tk.getScreenSize().getWidth());
    int ySize = ((int) tk.getScreenSize().getHeight());

    scroller.setPreferredSize(new Dimension(xSize - 890, ySize));
    scroller.setMinimumSize(new Dimension(xSize - 890, ySize));

    rightPane = new JPanel(new GridLayout(1,0));
    rightPane.add(scroller);
    rightPane.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder("Instructions"),
        BorderFactory.createEmptyBorder(5,5,5,5)));

    instrucsWindow.add(rightPane, BorderLayout.LINE_START);
    instrucsWindow.add(next, BorderLayout.SOUTH);
    instrucsWindow.add(legend, BorderLayout.LINE_END);

    instrucsWindow.setVisible(true);





































     }
















  public static void main(String[] args) throws Exception {

    instructions ins = new instructions();

  }


























































}
