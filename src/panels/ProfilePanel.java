package panels;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ProfilePanel extends JPanel {
    private JLabel messagejl;
    private Font customFont;

    public ProfilePanel() {
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
        messagejl = new JLabel("Session for user profile information.");
        messagejl.setForeground(new Color(247, 243, 234));
        messagejl.setFont(customFont);

        add(messagejl);

        messagejl.setBounds(60, 250, 300, 30);
    }

    private void createEvents() {
    }
}
