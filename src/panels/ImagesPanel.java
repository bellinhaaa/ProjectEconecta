package panels;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImagesPanel extends JPanel {
    private JLabel messagejl;
    private JLabel messagejl2;
    private Font customFont;

    public ImagesPanel() {
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
        messagejl = new JLabel("Will contain images shared by users of ");
        messagejl.setForeground(new Color(247, 243, 234));
        messagejl.setFont(customFont);

        messagejl2 = new JLabel("share experiences and ask questions.");
        messagejl2.setForeground(new Color(247, 243, 234));
        messagejl2.setFont(customFont);

        add(messagejl);
        add(messagejl2);

        messagejl.setBounds(52, 245, 300, 30);
        messagejl2.setBounds(58, 260, 300, 30);
    }

    private void createEvents() {
    }
}
