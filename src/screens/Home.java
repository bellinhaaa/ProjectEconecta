package screens;

import classes.User;
import panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private JMenu filejm, gardenjm, communityjm, settingsjm;
    private JMenuItem homejmi, exitjmi, myGardensjmi, statisticsjmi, cropsjmi, forumjmi, imagesjmi, supportjmi, profilejmi;
    private JMenuBar barjmb;
    private Container contentPane;
    static User user;

    public Home(String title , User user) throws HeadlessException {
        super(title);
        this.user = user;
        setSize(360, 640);
        getContentPane().setBackground(new Color(247, 243, 234));
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src/img/icon.png");
        setIconImage(icon.getImage());
        startComponents();
        createEvents();
    }

    private void startComponents() {
        //criando obj para os componentes
        contentPane = getContentPane(); //devolve um obj do tipo Container
        barjmb = new JMenuBar();
        filejm = new JMenu("File");
        gardenjm = new JMenu("Garden");
        myGardensjmi = new JMenuItem("My Gardens");
        communityjm = new JMenu("Community");
        statisticsjmi = new JMenuItem("Statistics");
        cropsjmi = new JMenuItem("Crops");
        settingsjm = new JMenu("Settings");
        homejmi = new JMenuItem("Home");
        exitjmi = new JMenuItem("Exit");
        forumjmi = new JMenuItem("Forum");
        imagesjmi = new JMenuItem("Images");
        supportjmi = new JMenuItem("Support");
        profilejmi = new JMenuItem("Profile");

        //barra de sustentação
        setJMenuBar(barjmb);

        //add
        barjmb.add(filejm);
        barjmb.add(gardenjm);
        gardenjm.add(myGardensjmi);
        barjmb.add(communityjm);
        gardenjm.add(statisticsjmi);
        gardenjm.add(cropsjmi);
        barjmb.add(settingsjm);
        filejm.add(homejmi);
        filejm.add(exitjmi);
        communityjm.add(forumjmi);
        communityjm.add(imagesjmi);
        settingsjm.add(supportjmi);
        settingsjm.add(profilejmi);

    }

    private void createEvents() {
        exitjmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { System.exit(0);
            }
        });

        myGardensjmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyGardensPanel garden = new MyGardensPanel();
                contentPane.removeAll();
                contentPane.add(garden);
                contentPane.validate();
            }
        });

        cropsjmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CropsPanel crops = new CropsPanel();
                contentPane.removeAll();
                contentPane.add(crops);
                contentPane.validate();
            }
        });

        statisticsjmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticsPanel statistics = new StatisticsPanel();
                contentPane.removeAll();
                contentPane.add(statistics);
                contentPane.validate();
            }
        });

        forumjmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ForumPanel forum = new ForumPanel();
                contentPane.removeAll();
                contentPane.add(forum);
                contentPane.validate();
            }
        });

        imagesjmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImagesPanel images = new ImagesPanel();
                contentPane.removeAll();
                contentPane.add(images);
                contentPane.validate();
            }
        });

        supportjmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupportPanel support = new SupportPanel();
                contentPane.removeAll();
                contentPane.add(support);
                contentPane.validate();
            }
        });

        profilejmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProfilePanel profile = new ProfilePanel();
                contentPane.removeAll();
                contentPane.add(profile);
                contentPane.validate();
            }
        });
    }
}
