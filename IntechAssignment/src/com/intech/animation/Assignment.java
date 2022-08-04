package com.intech.animation;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * User : Tanvir Ahmed
 * Date: 08/04/2022.
 */

public class Assignment extends JComponent {

    private Animation animation;
    private JFrame frame;

    Timer timer;
    static int counter = 0 ;



    public Assignment() {
        initialize();

        animation.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                counter ++;
                if(counter%2 !=0){
                    timer.stop();
                }else{
                    timer.start();
                    animation.animate();
                }
            }
        });

        final class TimeListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                animation.animate();
            }
        }

        ActionListener listener = new TimeListener();
        timer = new Timer(10, listener);
        timer.start();

    }

    public void initialize() {
        initializeFrame();
    }

    private void initializeFrame() {
        frame = new JFrame();

        this.frame.setTitle("Intech Assignment");
        this.frame.setPreferredSize(new Dimension(600, 600));
        this.frame.setAlwaysOnTop(Boolean.TRUE);
        this.frame.setBackground(Color.BLACK);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        animation = new Animation(600, 600);
        this.frame.getContentPane().add(animation);

        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(Boolean.TRUE);
        this.frame.add(animation);
    }


    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            public void run() {
                new Assignment().setVisible(Boolean.TRUE);
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
}
