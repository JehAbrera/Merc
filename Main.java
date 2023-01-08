package com.company;
import javax.swing.*;
import java.util.Random;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.table.*;
import java.lang.Thread;

public class Main {
    // Driver Class
    public static void main(String[] args) {
        Prompt start = new Prompt();
        start.prompt();
    }
}
// Prompt Frame
// Displays introduction frame and Flight Table
class Prompt{
    public void prompt(){
        // Prompt Frame
        JFrame intro = new JFrame("Merc Airlines");
        intro.setVisible(true);
        intro.setResizable(false);
        intro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        intro.setBounds(500, 225, 300, 300);
        JLabel lblGreet = new JLabel (" Welcome to Merc Airlines!");
        lblGreet.setBounds(65,20,175,30);
        intro.getContentPane().setLayout(null);

        // Prompt Button Option
        JButton btTable, btBook, btExit;
        btTable = new JButton("Flight Table");
        btBook = new JButton("Book A Flight");
        btExit = new JButton("Exit");
        btTable.setBounds(83,70,120,30);
        btTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                intro.dispose();
                FlightTable();
            }
        });
        btBook.setBounds(83,120,120,30);
        btBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AirlineType at = new AirlineType();
                at.PlaneType();
                intro.dispose();
            }
        });
        btExit.setBounds(83,170,120,30);
        btExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                intro.dispose();
            }
        });
        intro.getContentPane().add(lblGreet);
        intro.getContentPane().add(btTable);
        intro.getContentPane().add(btBook);
        intro.getContentPane().add(btExit);
    }

    //Display Flight Table detailing flight information --- Location/ Price
    public void FlightTable(){
        JFrame tframe = new JFrame("Flight Table");
        tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tframe.setVisible(true);
        tframe.setResizable(false);
        tframe.setBounds(100 , 75 , 1100, 575);
        JPanel panel = new JPanel();
        tframe.setContentPane(panel);
        panel.setLayout(null);

        //Adds button
        JButton btBack, btBook;
        btBack = new JButton("<< Back");
        btBack.setBounds(40, 475 , 80, 30);
        btBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tframe.dispose();
                prompt();
            }
        });
        btBook = new JButton("Book Flight >>");
        btBook.setBounds(925, 475 , 120, 30);
        btBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tframe.dispose();
                AirlineType at = new AirlineType();
                at.PlaneType();
            }
        });
        panel.add(btBack);
        panel.add(btBook);
        //Add Table
        String[][] data = {
                {"  A","  Manila-Batanes","  Local Type","  Php 8,000.00","  Php 12,500.00","  Php 3,500.00"},
                {"  B","  Batanes-Manila","  Local Type","  Php 9,800.00","  Php 9,800.00","  Php 3,900.00"},
                {"  C","  Manila-Palawan","  Local Type","  Php 9,100.00","  Php 10,500.00","  Php 3,200.00"},
                {"  D","  Palawan-Manila","  Local Type","  Php 9,850.00","  Php 10,975.00","  Php 3,575.00"},
                {"  E","  Manila-South Korea","  International Type","  Php 27,450.00","  Php 37,390.00","  Php 12,055.00"},
                {"  F","  South Korea-Manila","  International Type","  Php 30,890.00","  Php 39,650.00","  Php 13,100.00"},
                {"  G","  Manila-Japan","  International Type","  Php 40,450.00","  Php 45,355.00","  Php 27,800.00"},
                {"  H","  Japan-Manila","  International Type","  Php 43,855.00","  Php 49,780.00","  Php 29,400.00"},
                {"  I","  Manila-Vietnam","  International Type","  Php 8,505.00","  Php 12,345.00","  Php 3,200.00"},
                {"  J","  Vietnam-Manila","  International Type","  Php 14,300.00","  Php 16,320.00","  Php 4,600.00"},
        };
        String[] column= {"OPTION","FROM-TO","TRAVEL TYPE","PRIVATE CLASS FARE","BUSINESS CLASS FARE", "REGULAR CLASS FARE"};
        JTable table = new JTable(data,column);
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(40 , 10 , 1000, 423);
        table.setRowHeight(40);
        scroll.setViewportView(table);
        panel.add(scroll);
    }
}
// Get user Airline type
class AirlineType{
    // Encapsulation - storing values in private variables
    public int Travtax, Bagfee, Addfee, FlightIns, Cap;
    public String Type;

    private JRadioButton C1, C2, C3;
    //Gets user's airplane type
    public void PlaneType(){
        String PlaneType;
        JFrame FrPlane = new JFrame("Select Airplane Type");
        FrPlane.setVisible(true);
        FrPlane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FrPlane.setResizable(false);
        FrPlane.setBounds(550 , 250 , 300, 300);
        JPanel PPlane = new JPanel();
        PPlane.setBounds(0,0, 280, 280);
        FrPlane.getContentPane().add(PPlane);
        PPlane.setLayout(null);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);

        JLabel top = new JLabel("  Select Your Airplane Type");
        top.setBounds(65,10,160,30);
        top.setBorder(border);
        PPlane.add(top);

        C1 = new JRadioButton("[Private Class]");
        C1.setActionCommand("Private_Class");
        C1.setBounds(80, 50, 150, 30);
        C2 = new JRadioButton("[Business Class]");
        C2.setActionCommand("Business_Class");
        C2.setBounds(80, 90 ,150, 30);
        C3 = new JRadioButton("[Regular Class]");
        C3.setActionCommand("Regular_Class");
        C3.setBounds(80, 130, 150, 30);


        PPlane.add(C1);
        PPlane.add(C2);
        PPlane.add(C3);
        ButtonGroup group = new ButtonGroup();
        group.add(C1);
        group.add(C2);
        group.add(C3);

        JButton Proc = new JButton("Proceed");
        Proc.setBounds(90, 190, 100, 40);
        PPlane.add(Proc);
        Destination des = new Destination();
        Proc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!C1.isSelected() && !C2.isSelected() && !C3.isSelected()){
                    JOptionPane.showMessageDialog(null, "Choose A Valid Option", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (C1.isSelected()){
                    FlightIns = 4500;
                    Travtax = 4260;
                    Bagfee = 1250;
                    Addfee = 550;
                    Cap = 14;
                    Type = "Private Class";
                    FrPlane.dispose();
                    des.Location(FlightIns, Travtax, Bagfee, Addfee, Cap, Type);
                }
                if (C2.isSelected()){
                    FlightIns = 6500;
                    Travtax = 5700;
                    Bagfee = 2850;
                    Addfee = 550;
                    Cap = 23;
                    Type = "Business Class";
                    FrPlane.dispose();
                    des.Location(FlightIns, Travtax, Bagfee, Addfee, Cap, Type);
                }
                if(C3.isSelected()){
                    FlightIns = 950;
                    Travtax = 2500;
                    Bagfee = 950;
                    Addfee = 255;
                    Cap = 48;
                    Type = "Regular Class";
                    FrPlane.dispose();
                    des.Location(FlightIns, Travtax, Bagfee, Addfee, Cap, Type);
                }
            }
        });
    }
}

// Get passenger count and information
class Passenger{
    public int nop, InsVal, counter = 0;
    public String Ins;
    // Gets passenger count
    public void PassNum(int FlightIns, int Travtax, int Bagfee, int Addfee, int Cap, String Type, int CFare, String Dest, String Tag, String WayT){
        JFrame FrPass = new JFrame("Passengers");
        JPanel PlPass = new JPanel();
        FrPass.setBounds(530, 260, 350, 200);
        PlPass.setBounds(0, 0, 330, 190);
        FrPass.getContentPane().add(PlPass);
        FrPass.setVisible(true);
        FrPass.setResizable(false);
        FrPass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PlPass.setLayout(null);
        JTextField cnt = new JTextField();
        cnt.setBounds(70, 70, 200, 30);
        JButton sub = new JButton("Submit");
        sub.setBounds(120, 110, 100, 40);
        JLabel Lbl = new JLabel("<html><u>Enter Number of Passengers</u></html>");
        Lbl.setBounds(60, 30, 220, 30);
        Lbl.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel Lbl2 = new JLabel();
        Lbl2.setText("Current Plane Class Capacity: " + Cap);
        Lbl2.setBounds(0, 0, 180, 20);
        Lbl2.setFont(new Font("Arial", Font.BOLD, 10));

        PlPass.add(cnt);
        PlPass.add(sub);
        PlPass.add(Lbl);
        PlPass.add(Lbl2);
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    nop = Integer.parseInt(cnt.getText());
                    System.out.println(nop);
                    if (nop > Cap){
                        JOptionPane.showMessageDialog(null, "Number of Passengers cannot exceed Plane Capacity", "Error", JOptionPane.ERROR_MESSAGE);
                        cnt.setText("");
                    }
                    else {
                        PassInfo(FlightIns, Travtax, Bagfee, Addfee, Cap, Type, CFare, Dest, Tag, WayT);
                        FrPass.dispose();
                    }
                }
                catch (Exception i){
                    JOptionPane.showMessageDialog(null, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    // Get passenger info
    public void PassInfo(int FlightIns, int Travtax, int Bagfee, int Addfee, int Cap, String Type, int CFare, String Dest, String Tag, String WayT){
        int[] Pname = new int[nop];
        int[] Page = new int[nop];
        JButton Add, Proc;

        // Frame for passenger info
        JFrame FrInf = new JFrame("Passenger's Info");
        JPanel PlInf = new JPanel();
        FrInf.setVisible(true);
        FrInf.setResizable(false);
        FrInf.getContentPane().add(PlInf);
        PlInf.setLayout(null);
        FrInf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField Name = new JTextField();
        JTextField Age = new JTextField();
        JLabel LblN = new JLabel("<html><u>Name:</u></html>");
        JLabel Lbla = new JLabel("<html><u>Age:</u></html>");
        Add = new JButton("<html><u>ADD</u></html>");
        Proc = new JButton("<html><u>Proceed</u></html>");
        JLabel PassNo = new JLabel("Passenger " + (counter + 1));

        FrInf.setBounds(500, 230, 410, 230);
        PlInf.setBounds(0, 0, 410, 230);
        LblN.setBounds(10, 40, 60, 30);
        Lbla.setBounds(10, 120, 60, 30);
        LblN.setFont(new Font("Arial", Font.BOLD, 12));
        Lbla.setFont(new Font("Arial", Font.BOLD, 12));
        Name.setBounds(10, 75, 180, 25);
        Age.setBounds(10, 155, 180, 25);
        Add.setBounds(260, 20, 110, 65);
        Proc.setBounds(260, 110, 110,65);
        PassNo.setBounds(10, 10, 100, 30);

        PlInf.add(Name);
        PlInf.add(Age);
        PlInf.add(LblN);
        PlInf.add(Lbla);
        PlInf.add(Add);
        PlInf.add(Proc);
        PlInf.add(PassNo);
        Proc.setEnabled(false);

    }
}

// Get flight Destination
class Destination{
    // Encapsulation
    private JRadioButton D1, D2, D3, D4, D5, D6, D7, D8, D9, D10;
    public int CFare;
    public String Dest, Tag;
    public String WayT;
    public JButton One, Two, Cont;

    //Choose User's Flight Location
    public void Location(int FlightIns, int Travtax, int Bagfee, int Addfee, int Cap, String Type){
        // Destination Holding Frame
        JFrame FrDes = new JFrame("Destination");
        JPanel PlDes = new JPanel();
        FrDes.setBounds(530, 110, 350, 550);
        PlDes.setBounds(0, 0, 330, 530);
        FrDes.setResizable(false);
        FrDes.setVisible(true);
        FrDes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FrDes.getContentPane().add(PlDes);
        PlDes.setLayout(null);
        JLabel top = new JLabel("  Choose Your Destination");
        top.setBounds(95, 60, 160, 30);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        top.setBorder(border);
        // Create Radio Buttons for Destination Selection
        D1 = new JRadioButton("A. Manila - Batanes");
        D1.setActionCommand("ManBat");
        D2 = new JRadioButton("B. Batanes - Manila");
        D2.setActionCommand("BatMan");
        D3 = new JRadioButton("C. Manila - Palawan");
        D3.setActionCommand("ManPal");
        D4 = new JRadioButton("D. Palawan - Manila");
        D4.setActionCommand("PalMan");
        D5 = new JRadioButton("E. Manila - South Korea");
        D5.setActionCommand("ManSok");
        D6 = new JRadioButton("F. South Korea - Manila");
        D6.setActionCommand("SokMan");
        D7 = new JRadioButton("G. Manila - Japan");
        D7.setActionCommand("ManJap");
        D8 = new JRadioButton("H. Japan - Manila");
        D8.setActionCommand("JapMan");
        D9 = new JRadioButton("I. Manila - Vietnam");
        D9.setActionCommand("ManVie");
        D10 = new JRadioButton("J. Vietnam - Manila");
        D10.setActionCommand("VieMan");

        // Group Buttons
        ButtonGroup Dgrp = new ButtonGroup();
        Dgrp.add(D1);
        Dgrp.add(D2);
        Dgrp.add(D3);
        Dgrp.add(D4);
        Dgrp.add(D5);
        Dgrp.add(D6);
        Dgrp.add(D7);
        Dgrp.add(D8);
        Dgrp.add(D9);
        Dgrp.add(D10);

        //Set Bounds for the radio buttons
        D1.setBounds(100, 90, 160, 30);
        D2.setBounds(100, 120, 160, 30);
        D3.setBounds(100, 150, 160, 30);
        D4.setBounds(100, 180, 160, 30);
        D5.setBounds(100, 210, 160, 30);
        D6.setBounds(100, 240, 160, 30);
        D7.setBounds(100, 270, 160, 30);
        D8.setBounds(100, 300, 160, 30);
        D9.setBounds(100, 330, 160, 30);
        D10.setBounds(100, 360, 160, 30);

        PlDes.add(top);
        PlDes.add(D1);
        PlDes.add(D2);
        PlDes.add(D3);
        PlDes.add(D4);
        PlDes.add(D5);
        PlDes.add(D6);
        PlDes.add(D7);
        PlDes.add(D8);
        PlDes.add(D9);
        PlDes.add(D10);

        Cont = new JButton("Proceed");
        Cont.setBounds(125, 430, 100, 50);
        PlDes.add(Cont);
        Cont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!D1.isSelected() && !D2.isSelected() && !D3.isSelected() && !D4.isSelected() && !D5.isSelected() && !D6.isSelected() && !D7.isSelected() && !D8.isSelected() && !D9.isSelected() && !D10.isSelected()){
                    JOptionPane.showMessageDialog(null, "Choose A Valid Option", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (D1.isSelected() || D2.isSelected() || D3.isSelected() || D4.isSelected()){
                    Tag = "Local Flight";
                }
                if (D5.isSelected() || D6.isSelected() || D7.isSelected() || D8.isSelected() || D9.isSelected() || D10.isSelected()){
                    Tag = "International Flight";
                }
                if (D1.isSelected()){
                    Dest = "Manila - Batanes";
                    switch (Type) {
                        case "Private Class":
                            CFare = 8000;
                            break;
                        case "Business Class":
                            CFare = 12500;
                            break;
                        case "Regular Class":
                            CFare = 3500;
                            break;
                    }
                    FrDes.dispose();
                    Trip(FlightIns, Travtax, Bagfee, Addfee, Cap, Type);
                }
                if (D2.isSelected()){
                    Dest = "Batanes - Manila";
                    switch (Type) {
                        case "Private Class":
                            CFare = 9800;
                            break;
                        case "Business Class":
                            CFare = 12950;
                            break;
                        case "Regular Class":
                            CFare = 3900;
                            break;
                    }
                    FrDes.dispose();
                    Trip(FlightIns, Travtax, Bagfee, Addfee, Cap, Type);
                }
                if (D3.isSelected()){
                    Dest = "Manila - Palawan";
                    switch (Type) {
                        case "Private Class":
                            CFare = 9100;
                            break;
                        case "Business Class":
                            CFare = 10500;
                            break;
                        case "Regular Class":
                            CFare = 3200;
                            break;
                    }
                    FrDes.dispose();
                    Trip(FlightIns, Travtax, Bagfee, Addfee, Cap, Type);
                }
                if (D4.isSelected()){
                    Dest = "Palawan - Manila";
                    switch (Type) {
                        case "Private Class":
                            CFare = 9850;
                            break;
                        case "Business Class":
                            CFare = 10975;
                            break;
                        case "Regular Class":
                            CFare = 3575;
                            break;
                    }
                    FrDes.dispose();
                    Trip(FlightIns, Travtax, Bagfee, Addfee, Cap, Type);
                }
                if (D5.isSelected()){
                    Dest = "Manila - South Korea";
                    switch (Type) {
                        case "Private Class":
                            CFare = 27450;
                            break;
                        case "Business Class":
                            CFare = 37390;
                            break;
                        case "Regular Class":
                            CFare = 12055;
                            break;
                    }
                    FrDes.dispose();
                    Trip(FlightIns, Travtax, Bagfee, Addfee, Cap, Type);
                }
                if (D6.isSelected()){
                    Dest = "South Korea - Manila";
                    switch (Type) {
                        case "Private Class":
                            CFare = 30890;
                            break;
                        case "Business Class":
                            CFare = 39650;
                            break;
                        case "Regular Class":
                            CFare = 13100;
                            break;
                    }
                    FrDes.dispose();
                    Trip(FlightIns, Travtax, Bagfee, Addfee, Cap, Type);
                }
                if (D7.isSelected()){
                    Dest = "Manila - Japan";
                    switch (Type) {
                        case "Private Class":
                            CFare = 40450;
                            break;
                        case "Business Class":
                            CFare = 45355;
                            break;
                        case "Regular Class":
                            CFare = 27800;
                            break;
                    }
                    FrDes.dispose();
                    Trip(FlightIns, Travtax, Bagfee, Addfee, Cap, Type);
                }
                if (D8.isSelected()){
                    Dest = "Japan - Manila";
                    switch (Type) {
                        case "Private Class":
                            CFare = 43855;
                            break;
                        case "Business Class":
                            CFare = 49780;
                            break;
                        case "Regular Class":
                            CFare = 29400;
                            break;
                    }
                    FrDes.dispose();
                    Trip(FlightIns, Travtax, Bagfee, Addfee, Cap, Type);
                }
                if (D9.isSelected()){
                    Dest = "Manila - Vietnam";
                    switch (Type) {
                        case "Private Class":
                            CFare = 8505;
                            break;
                        case "Business Class":
                            CFare = 12345;
                            break;
                        case "Regular Class":
                            CFare = 3200;
                            break;
                    }
                    FrDes.dispose();
                    Trip(FlightIns, Travtax, Bagfee, Addfee, Cap, Type);
                }
                if (D10.isSelected()){
                    Dest = "Vietnam - Manila";
                    switch (Type) {
                        case "Private Class":
                            CFare = 14300;
                            break;
                        case "Business Class":
                            CFare = 16320;
                            break;
                        case "Regular Class":
                            CFare = 4600;
                            break;
                    }
                    FrDes.dispose();
                    Trip(FlightIns, Travtax, Bagfee, Addfee, Cap, Type);
                }
            }
        });
    }
    // Choose whether round-trip or one-way flight
    public void Trip(int FlightIns, int Travtax, int Bagfee, int Addfee, int Cap, String Type){
        One = new JButton("One-Way");
        Two = new JButton("Round-Trip");
        JFrame FrWay = new JFrame("Trip Info");
        JPanel PlWay = new JPanel();
        FrWay.setBounds(530, 260, 350, 200);
        PlWay.setBounds(0,0, 340, 190);
        FrWay.setVisible(true);
        FrWay.setResizable(false);
        FrWay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PlWay.setLayout(null);
        FrWay.getContentPane().add(PlWay);
        JLabel lblTop = new JLabel("Is the Flight Roundtrip or One-way??");
        lblTop.setBounds(23, 25, 280, 40);
        lblTop.setFont(new Font("Arial", Font.BOLD, 16));
        One.setBounds(20, 90, 100, 60);
        Two.setBounds(215, 90, 100, 60);

        PlWay.add(One);
        PlWay.add(Two);
        PlWay.add(lblTop);
        Passenger ps = new Passenger();
        One.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WayT = "One-Way";
                ps.PassNum(FlightIns, Travtax, Bagfee, Addfee, Cap, Type, CFare, Dest, Tag, WayT);
                FrWay.dispose();
            }
        });
        Two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WayT = "RoundTrip";
                ps.PassNum(FlightIns, Travtax, Bagfee, Addfee, Cap, Type, CFare, Dest, Tag, WayT);
                FrWay.dispose();
            }
        });
    }
}
// Print Receipt
// Inheritance
class Transaction extends AirlineType{
    //Generate Transaction Number
    Random TransNo = new Random();
}

