package panels;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ForumPanel extends JPanel {
    private JLabel messagejl;
    private JLabel messagejl2;
    private Font customFont;

    public ForumPanel() {
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
        messagejl = new JLabel("Will contain a forum for users to ");
        messagejl.setForeground(new Color(247, 243, 234));
        messagejl.setFont(customFont);

        messagejl2 = new JLabel("share experiences and ask questions.");
        messagejl2.setForeground(new Color(247, 243, 234));
        messagejl2.setFont(customFont);

        add(messagejl);
        add(messagejl2);

        messagejl.setBounds(69, 245, 300, 30);
        messagejl2.setBounds(57, 260, 300, 30);
    }

    private void createEvents() {
    }
}
