package test;

import project.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Imran on 2014-11-22.
 */
public class testClass {

    static parameters params;
    static incomeRequired income;
    static allocation allocation;
    static sliderInterface slider;

    public static void main (String[] args) throws Exception {
        params = new parameters();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                sliderInterface frame = new sliderInterface(params.getSecurityList());

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setVisible(true);
            }

        });
    }
}








