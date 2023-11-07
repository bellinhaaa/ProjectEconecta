package panels;

import classes.User;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyGardensPanel extends JPanel{
    private JLabel messagejl;
    private Font customFont;

    public MyGardensPanel() {
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
        messagejl = new JLabel("Session for viewing the vegetable garden.");
        messagejl.setForeground(new Color(247, 243, 234));
        messagejl.setFont(customFont);

        add(messagejl);

        messagejl.setBounds(42, 250, 300, 30);
    }

    private void createEvents() {
    }
}
