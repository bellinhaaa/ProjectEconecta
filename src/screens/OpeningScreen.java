package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URISyntaxException;

public class OpeningScreen extends JFrame {
    //elements declaration
    private JPanel paneljp;

    //constructor
    public OpeningScreen(String title) throws HeadlessException {
        super(title);
        setSize(360, 640); //size of screen
        setLayout(null); //disables automatic scaling
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close window and program
        getContentPane().setBackground(new Color(40,115,121));
        ImageIcon icon = new ImageIcon("src/img/icon.png");
        setIconImage(icon.getImage());
        startComponents();

        //centers the window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);

        //a timer to hide the screen after 3 seconds and show the LogIn screen
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                SwingUtilities.invokeLater(() -> {
                    LogIn logIn = new LogIn("Log In");
                    logIn.setVisible(true);
                });
                ((Timer) e.getSource()).stop();
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

    //method to initialize components
    private void startComponents() {
        paneljp = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                /*String path;
                try {
                    //get the path of the image file
                     path = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                ImageIcon backOp = new ImageIcon(path + "\\img\\backOp2.png");
                Image image = backOp.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };*/

        ImageIcon backOp = new ImageIcon("src/img/backOp2.png");
        Image image = backOp.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        paneljp.setLayout(null);
        setContentPane(paneljp);

        //load the logo
        ImageIcon logoii = new ImageIcon("src/img/logopngmenor3.png");
        JLabel logojl = new JLabel(logoii);
        //calculates the position of the logo in the center of the screen
        int centerX = (getWidth() - logoii.getIconWidth()) / 2;
        int centerY = (getHeight() - logoii.getIconHeight()) / 2;

        logojl.setBounds(centerX, centerY, logoii.getIconWidth(), logoii.getIconHeight());
        paneljp.add(logojl);

    }

    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        //creates and displays the screen
        OpeningScreen openingScreen = new OpeningScreen("Opening");
        openingScreen.setVisible(true);
    });
    }
}


