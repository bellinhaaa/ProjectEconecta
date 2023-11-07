package panels;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class StatisticsPanel extends JPanel {
    private JLabel messagejl;
    private JLabel messagejl2;
    private JLabel messagejl3;
    private Font customFont;

    public StatisticsPanel() {
        setSize(360, 640);
        setLayout(null);
        setBackground(new Color(40, 115, 121));
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/font/Quicksand.ttf")).deriveFont(Font.BOLD, 13f);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            customFont = new Font("Arial", Font.PLAIN, 12);
        }

        startComponents();
        createEvents();
    }

    private void startComponents() {
        messagejl = new JLabel("It includes information on the garden's");
        messagejl2 = new JLabel("statistics, allowing you to access graphs");
        messagejl3 = new JLabel("and metrics on its performance.");
        messagejl.setForeground(new Color(247, 243, 234));
        messagejl2.setForeground(new Color(247, 243, 234));
        messagejl3.setForeground(new Color(247, 243, 234));

        messagejl.setFont(customFont);
        messagejl2.setFont(customFont);
        messagejl3.setFont(customFont);

        add(messagejl);
        add(messagejl2);
        add(messagejl3);

       messagejl.setBounds(50, 230, 900, 30);
       messagejl2.setBounds(46, 245, 900, 30);
       messagejl3.setBounds(67, 260, 900, 30);

    }

    private void createEvents() {
    }

}
