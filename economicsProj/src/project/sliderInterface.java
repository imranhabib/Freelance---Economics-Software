package project;

import javax.swing.*;
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
    private static JTextField textTracker;
    private static ChangeListener changelistener;


    public sliderInterface(List<Share> shares) {
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        setTitle("Slider Interface");
        setSize(1000, 500);
        textTracker = new JTextField();
        ResourceBundle bundle = ResourceBundle.getBundle("resources/systemdata");


        changelistener = new ChangeListener()
        {
            public void stateChanged(ChangeEvent event)
            {
                JSlider source = (JSlider) event.getSource();
                textTracker.setText("" + source.getValue());

            }
        };

            //create as many slider instances of the size of 'shares'
            //call the addSlider method with the correct param taken from the share object
            for(int i = 0; i < shares.size(); i++){
                addShare(formatSlider(shares.get(i).getPrice()), shares.get(i).getIncomeShare(), shares.get(i).getSecurityNumber());
            }

        add(textTracker, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }


    public void addShare (JSlider slider, float incomeShare, int securityNumber){
        slider.addChangeListener(changelistener);
        JPanel pan = new JPanel();
        pan.add(slider);
        pan.setToolTipText(Float.toString(incomeShare));
        pan.add(new JLabel("Security Number = " + Integer.toString(securityNumber)));
        panel.add(pan);

    }


    public JSlider formatSlider(int price){

        JSlider slider = new JSlider(JSlider.VERTICAL);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);


        slider.add(new JLabel(Integer.toString(price)));
        return slider;



    }

}