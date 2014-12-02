package project;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
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
  static JButton button1;

  private static JTextField textField;
  private static JTextField textField2;
  private static JTextField textField3;
  private static JTextField textField4;
  private static JTextField textField5;

  private static JTextField textFieldA;
  private static JTextField textField2B;
  private static JTextField textField3C;
  private static JTextField textField4D;
  private static JTextField textField5E;

  private static ChangeListener changelistener;

  private final Color blue = Color.BLUE;
  private final Color red = Color.RED;


  static int total = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave"));
  static int allocation = 0;


    public sliderInterface(List<Share> shares) {
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
      panel.setBorder(new TitledBorder("Securities"));
    // label = new JLabel("Securities");
     // panel.add(label);

      panel3 = new JPanel();

      panel3.setLayout(new GridLayout(0, shares.size()));
      //panel3.setPreferredSize(new Dimension(50, 100));
      panel3.setBorder(new TitledBorder("Allocation"));

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

      textFieldA = new JTextField();
      textField2B = new JTextField();
      textField3C = new JTextField();
      textField4D = new JTextField();
      textField5E = new JTextField();


      textFieldA.setEditable(false);
      textField2B.setEditable(false);
      textField3C.setEditable(false);
      textField4D.setEditable(false);
      textField5E.setEditable(false);

      panel4 = new JPanel();
      panel4.setLayout(new GridLayout(0, shares.size()));
      panel4.setBorder(new TitledBorder("Data"));

      if(size >= 1) {
        panel3.add(textField);
        panel4.add(textFieldA);

      }
      if(size >= 2) {
        panel3.add(textField2);
        panel4.add(textField2B);
      }
      if(size >= 3) {
        panel3.add(textField3);
        panel4.add(textField3C);
      }
      if(size >= 4) {
        panel3.add(textField4);
        panel4.add(textField4D);

      }
      if(size >= 5) {
        panel3.add(textField5);
        panel4.add(textField5E);
      }


      JSplitPane splitPane = new JSplitPane(
          JSplitPane.VERTICAL_SPLIT, panel, panel4
      );


      button1 = new JButton("Submit");
      button1.setToolTipText("Click to submit allocations");
      button1.setBorder(new TitledBorder("Move on"));


 //you can change the first SOUTH -> NORTH && the first CENTER -> SOUTH to get a different spacing/sizing

   panel2.add(splitPane, BorderLayout.CENTER );
     // panel2.add(panel, BorderLayout.CENTER);
      panel2.add(panel3, BorderLayout.NORTH);
      panel2.add(button1, BorderLayout.SOUTH);
      add(panel2, BorderLayout.CENTER);
      //add(panel3, BorderLayout.PAGE_START);


        changelistener = new ChangeListener()
        {
            public void stateChanged(ChangeEvent event)
            {
                JSlider source = (JSlider) event.getSource();

               if (!source.getValueIsAdjusting()) {
                 int value = source.getValue();

                 String name = source.getName();
                 if(name.equals("1")){
                   textField.setText("Units of Security # " + source.getName() + " = " + value);
                   textFieldA.setText("Remaining income " + " = " + (remainingIncome(allocation, value)));

                 }
                 if(name.equals("2")){
                   textField2.setText("Units of Security # " + source.getName() + " = " + value);
                   textFieldA.setText("Remaining income " + " = " + (remainingIncome(getTotal(), value)));

                 }
                 if(name.equals("3")){
                   textField3.setText("Units of Security # " + source.getName() + " = " + value);
                   textFieldA.setText("Remaining income " + " = " + (remainingIncome(getTotal(), value)));

                 }
                 if (name.equals("4")){
                   textField4.setText("Units of Security # " + source.getName() + " = " + value);
                   textFieldA.setText("Remaining income " + " = " + (remainingIncome(getTotal(), value)));

                 }
                 if (name.equals("5")){
                   textField5.setText("Units of Security # " + source.getName() + " = " + value);
                   textFieldA.setText("Remaining income " + " = " + (remainingIncome(getTotal(), value)));

                 }
               }

            }
        };

            //create as many slider instances of the size of 'shares'
            //call the addSlider method with the correct param taken from the share object
            for(int i = 0; i < shares.size(); i++){
                addShare(formatSlider(shares.get(i).getPrice(), shares.get(i).getSecurityNumber()), shares.get(i).getIncomeShare(), shares.get(i).getPrice());
            }


    }

    public void addShare (JSlider slider, float incomeShare, int price){
        slider.addChangeListener(changelistener);
        JPanel pan = new JPanel();
        pan.add(slider);
        pan.setToolTipText(Float.toString(incomeShare));
        pan.add(new JLabel("Price of security = " + price));
        panel.add(pan);

    }

    public JSlider formatSlider(int price, int number){
        JSlider slider = new JSlider(JSlider.VERTICAL);
        slider.setName(Integer.toString(number));
        slider.setMinimum(0);
        slider.setMaximum(10);
        slider.setValue(0);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPreferredSize(new Dimension(100, 400));
        slider.setBorder(new TitledBorder("Security " + Integer.toString(number)));
        slider.setPaintLabels(true);

        //slider.add(new JLabel(Integer.toString(price)));
        return slider;

    }

    public int remainingIncome(int allocation,  int value){

      setTotal(allocation - value);
      return allocation - value;
    }


    public void setTotal (int remains){
      total = remains;
    }

    public int getTotal(){
      return total;
    }

}
