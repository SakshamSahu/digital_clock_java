package digitalclockjava;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class MyWindow extends JFrame {

    private JLabel heading;
    private JLabel clockLabel;
    private Font font = new Font("Robotto", Font.BOLD, 35);

    MyWindow() {
        super.setTitle("My Clock");
        super.setSize(400, 400);
        super.setLocation(300, 50);
        this.createGUI();
        this.startClock();
        setVisible(true);
    }

    public void createGUI() {
        heading = new JLabel("My Clock");
        clockLabel = new JLabel("Clock Label");

        heading.setHorizontalAlignment(SwingConstants.CENTER);
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon originalIcon = new ImageIcon("assets/images/3d_alarm_clock.png"); // Your original image
        Image img = originalIcon.getImage(); // Get the image from the icon
        Image resizedImage = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Resize image
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        heading.setIcon(resizedIcon);
        heading.setPreferredSize(new Dimension(100, 100));
        heading.setHorizontalTextPosition(SwingConstants.CENTER);
        heading.setVerticalTextPosition(SwingConstants.BOTTOM);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        heading.setFont(font);
        clockLabel.setFont(font);

        this.setLayout(new GridLayout(2, 1));
        this.add(heading);
        this.add(clockLabel);
    }

    public void startClock() {

        Timer timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a");
                String datTime = sdf.format(d);
                clockLabel.setText(datTime);
            }

        });

        timer.start();

    }

}
