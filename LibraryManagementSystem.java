package library.management.system;
import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class LibraryManagementSystem {

    public static void login()
    {
        JFrame j = new JFrame("Library Management System");
        j.setLocation(400,100);
        j.setSize(700,600);
        j.setPreferredSize(j.getSize());
        Container c= j.getContentPane();
        JPanel jp = new JPanel();
        jp.setBackground(new Color(255,255,255,75));
        ImageIcon background=new ImageIcon("images.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(700,600,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(new GridBagLayout());
        back.setBounds(0,0,500,600);
        c.add(back);
        jp.setSize(500, 500);
        jp.setPreferredSize(jp.getSize());
        jp.setLayout(new GridBagLayout());
        c.setLayout(new FlowLayout());
        GridBagConstraints gbc = new GridBagConstraints(); 
        Button b = new Button("Login");
        b.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b.setForeground(Color.blue);
        b.setBackground(new Color(255,255,255,150));
        JLabel l1 = new JLabel("Login Form");
        JLabel l2 = new JLabel("Username");
        JLabel l3 = new JLabel("Password");
        JTextField t1=new JTextField();
        l1.setForeground(Color.blue);
        l1.setBackground(new Color(255,255,255,150));
        l1.setOpaque(true);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l1.setPreferredSize(new Dimension(250, 100));
        l2.setForeground(Color.blue);
        l2.setBackground(new Color(255,255,255,150));
        l2.setOpaque(true);
        l2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        l3.setForeground(Color.blue);
        l3.setBackground(new Color(255,255,255,150));
        l3.setOpaque(true);
        l3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        JPasswordField t2 = new JPasswordField();
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2.setHorizontalAlignment(JLabel.CENTER);
        l3.setHorizontalAlignment(JLabel.CENTER);
        gbc.fill = GridBagConstraints.HORIZONTAL;     
        gbc.weighty = 2.0; 
        gbc.gridx = 0;  
        gbc.gridy = 0; 
        jp.add(l1,gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;  
        gbc.gridy = 1; 
        jp.add(l2,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 2; 
        jp.add(t1,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 3;
        jp.add(l3,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 4; 
        jp.add(t2,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 5;
        gbc.weighty = 2.0; 
        jp.add(b,gbc); 
        back.add(jp);
        b.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
                try { 
                    char[] d;
                    String a,d1;
                    a=t1.getText();
                    d=t2.getPassword();
                    d1 = new String(d);
                    FileReader fr = new FileReader("Login.csv");
                    BufferedReader br = new BufferedReader(fr);
                    String s= br.readLine();
                    String s1,s2;
                    while(s!=null)
                    {
                        String[] parts = s.split(",");
                        s1=parts[0];
                        s2=parts[1];
                        if(s1.equals(a) && s2.equals(d1))
                        {
                            JOptionPane.showMessageDialog(null,"Login Successful");
                            j.dispose();
                            menu();
                        }
                     s=br.readLine();
                    }
                    br.close();
                    fr.close();
                } catch (FileNotFoundException ex) {
                    
                } catch (IOException ex) {
                    Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });  
        j.setResizable(false);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void menu()
    {
        JFrame j = new JFrame("Library Management System");
        j.setLocation(400,100);
        j.setSize(700,600);
        j.setPreferredSize(j.getSize());
        Container c= j.getContentPane();
        JPanel jp = new JPanel();
        jp.setBackground(new Color(255,255,255,75));
        ImageIcon background=new ImageIcon("images.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(700,600,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(new GridBagLayout());
        back.setBounds(0,0,500,600);
        c.add(back);
        jp.setSize(500, 500);
        jp.setPreferredSize(jp.getSize());
        jp.setLayout(new GridBagLayout());
        c.setLayout(new FlowLayout());
        GridBagConstraints gbc = new GridBagConstraints(); 
        Button b = new Button("Logout");
        b.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b.setForeground(Color.blue);
        b.setBackground(new Color(255,255,255,150));
        Button b1 = new Button("View Books");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b1.setForeground(Color.blue);
        b1.setBackground(new Color(255,255,255,150));
        Button b2 = new Button("Search Book");
        b2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b2.setForeground(Color.blue);
        b2.setBackground(new Color(255,255,255,150));
        Button b3 = new Button("Issue Book");
        b3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b3.setForeground(Color.blue);
        b3.setBackground(new Color(255,255,255,150));
        Button b4 = new Button("View Issued Books");
        b4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b4.setForeground(Color.blue);
        b4.setBackground(new Color(255,255,255,150));
        JLabel l1 = new JLabel("Main Menu");
        l1.setForeground(Color.blue);
        l1.setBackground(new Color(255,255,255,150));
        l1.setOpaque(true);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l1.setPreferredSize(new Dimension(250, 100));
        l1.setHorizontalAlignment(JLabel.CENTER);
        gbc.fill = GridBagConstraints.HORIZONTAL;     
        gbc.weighty = 1.0; 
        gbc.gridx = 0;  
        gbc.gridy = 0; 
        jp.add(l1,gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;  
        gbc.gridy = 1; 
        jp.add(b1,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 2; 
        jp.add(b2,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 3;
        jp.add(b3,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 4; 
        jp.add(b4,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 5; 
        gbc.weighty = 1.0;
        jp.add(b,gbc); 
        gbc.gridx = 0;  
        gbc.gridy = 6; 
        back.add(jp);
        b.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
                j.dispose();
                login();
            }
        });  
        b1.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
               j.dispose();
               books();
            }
        });  
          b2.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
               j.dispose();
               search();
            }
        });
        b3.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
               j.dispose();
               issue();
            }
        }); 
        b4.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
               j.dispose();
               issue_books();
            }
        });
        j.setResizable(false);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void books()
    {
        JFrame j = new JFrame("Library Management System");
        j.setLocation(400,100);
        j.setSize(700,600);
        j.setPreferredSize(j.getSize());
        Container c= j.getContentPane();
        JPanel jp = new JPanel();
        jp.setBackground(new Color(255,255,255,75));
        ImageIcon background=new ImageIcon("images.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(700,600,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(new GridBagLayout());
        back.setBounds(0,0,500,600);
        c.add(back);
        jp.setSize(500, 500);
        jp.setPreferredSize(jp.getSize());
        jp.setLayout(new GridBagLayout());
        c.setLayout(new FlowLayout());
        GridBagConstraints gbc = new GridBagConstraints(); 
        Button b = new Button("Logout");
        b.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b.setForeground(Color.blue);
        b.setBackground(new Color(255,255,255,150));
        Button b1 = new Button("Back");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b1.setForeground(Color.blue);
        b1.setBackground(new Color(255,255,255,150));
        JLabel l1 = new JLabel("Books");
        l1.setForeground(Color.blue);
        l1.setBackground(new Color(255,255,255,150));
        l1.setOpaque(true);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l1.setPreferredSize(new Dimension(250, 100));
        l1.setHorizontalAlignment(JLabel.CENTER);
        JTextArea tx = new JTextArea(20,20);
        tx.setVisible(true);
        tx.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(tx);
        scrollPane.setVisible(true);
        gbc.fill = GridBagConstraints.HORIZONTAL;     
        gbc.weighty = 2.0; 
        gbc.gridx = 0;  
        gbc.gridy = 0; 
        jp.add(l1,gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;  
        gbc.gridy = 1; 
        jp.add(tx,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 3; 
        gbc.weighty = 1.0;
        jp.add(b1,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 4; 
        gbc.weighty = 0.0;
        jp.add(b,gbc); 
        back.add(jp);
        try { 
                    int start = 0,size=0;
                    FileReader fr = new FileReader("Books.csv");
                    FileReader fr1 = new FileReader("Books.csv");
                    BufferedReader br = new BufferedReader(fr);
                    String s= br.readLine();
                    BufferedReader br1 = new BufferedReader(fr1);
                    String s1= br1.readLine();
                    while(s1!=null)
                    {
                        s1=br1.readLine();
                        size++;
                    }
                    br1.close();
                    fr1.close();
                    String[][] data = new String[size][4];
                    while(s!=null)
                    {
                        String[] parts = s.split(",");
                        data[start][0]=parts[0]+" ";
                        data[start][1]=parts[1]+" ";
                        data[start][2]=parts[2]+" ";
                        data[start][3]=parts[3]+" ";
                     s=br.readLine();
                     start++;
                    }
                    StringBuilder builder = new StringBuilder();
                    for(int i = 0; i < data.length; i++){
                    for(int j1 = 0; j1 < data[i].length; j1++){
                    builder.append(data[i][j1]);
                    builder.append(" ");
                    }
                    builder.append("\n");
                    }
                    tx.setText(builder.toString());
                    br.close();
                    fr.close();
                } catch (FileNotFoundException ex) {
                    
                } catch (IOException ex) {
                    Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
        b.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
                j.dispose();
                login();
            }
        });  
        b1.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
                j.dispose();
                menu();
            }
        });  
        j.setResizable(false);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void search()
    {
        JFrame j = new JFrame("Library Management System");
        j.setLocation(400,100);
        j.setSize(700,600);
        j.setPreferredSize(j.getSize());
        Container c= j.getContentPane();
        JPanel jp = new JPanel();
        jp.setBackground(new Color(255,255,255,75));
        ImageIcon background=new ImageIcon("images.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(700,600,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(new GridBagLayout());
        back.setBounds(0,0,500,600);
        c.add(back);
        jp.setSize(500, 500);
        jp.setPreferredSize(jp.getSize());
        jp.setLayout(new GridBagLayout());
        c.setLayout(new FlowLayout());
        GridBagConstraints gbc = new GridBagConstraints(); 
        JTextField t1=new JTextField();
        Button b = new Button("Logout");
        b.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b.setForeground(Color.blue);
        b.setBackground(new Color(255,255,255,150));
        Button b1 = new Button("Back");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b1.setForeground(Color.blue);
        b1.setBackground(new Color(255,255,255,150));
        Button b2 = new Button("Enter");
        b2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b2.setForeground(Color.blue);
        b2.setBackground(new Color(255,255,255,150));
        JLabel l1 = new JLabel("Search");
        l1.setForeground(Color.blue);
        l1.setBackground(new Color(255,255,255,150));
        l1.setOpaque(true);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l1.setPreferredSize(new Dimension(250, 100));
        l1.setHorizontalAlignment(JLabel.CENTER);
        JLabel l2 = new JLabel("ID");
        l2.setForeground(Color.blue);
        l2.setBackground(new Color(255,255,255,150));
        l2.setOpaque(true);
        l2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        l2.setPreferredSize(new Dimension(250, 100));
        l2.setHorizontalAlignment(JLabel.CENTER);
        JTextArea tx = new JTextArea(20,20);
        tx.setVisible(false);
        tx.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(tx);
        scrollPane.setVisible(true);
        gbc.fill = GridBagConstraints.HORIZONTAL;     
        gbc.weighty = 2.0; 
        gbc.gridx = 0;  
        gbc.gridy = 0; 
        jp.add(l1,gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;  
        gbc.gridy = 1; 
        jp.add(l2,gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;  
        gbc.gridy = 2; 
        jp.add(t1,gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;  
        gbc.gridy = 3; 
        jp.add(b2,gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;  
        gbc.gridy = 4; 
        jp.add(tx,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 5; 
        gbc.weighty = 1.0;
        jp.add(b1,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 6; 
        gbc.weighty = 0.0;
        jp.add(b,gbc); 
        back.add(jp);
        b.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
                j.dispose();
                login();
            }
        });  
        b1.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
                j.dispose();
                menu();
            }
        }); 
         b2.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
               try { 
                    FileReader fr = new FileReader("Books.csv");
                    BufferedReader br = new BufferedReader(fr);
                    String s= br.readLine();
                    String s1,s2,s3,s4;
                    String[][] data = new String[2][4];
                    data[0][0]="ID===";
                    data[0][1]="=======Name=======";
                    data[0][2]="==Volume==";
                    data[0][3]="==Author==";
                    while(s!=null)
                    {
                        String[] parts = s.split(",");
                        s1=parts[0];
                        s2=parts[1];
                        s3=parts[2];
                        s4=parts[3];
                        if(s1.equals(t1.getText()))
                        {
                            data[1][0]=s1;
                            data[1][1]=s2;
                            data[1][2]=s3;
                            data[1][3]=s4;
                        }
                     s=br.readLine();
                    }
                    StringBuilder builder = new StringBuilder();
                    for(int i = 0; i < data.length; i++){
                    for(int j1 = 0; j1 < data[i].length; j1++){
                    builder.append(data[i][j1]);
                    builder.append(" ");
                    }
                    builder.append("\n");
                    }
                    tx.setText(builder.toString());
                    tx.setVisible(true);
                    br.close();
                    fr.close();
                } catch (FileNotFoundException ex) {
                    
                } catch (IOException ex) {
                    Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
            }
        }); 
        j.setResizable(false);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     public static void issue()
    {
       JFrame j = new JFrame("Library Management System");
        j.setLocation(400,100);
        j.setSize(700,600);
        j.setPreferredSize(j.getSize());
        Container c= j.getContentPane();
        JPanel jp = new JPanel();
        jp.setBackground(new Color(255,255,255,75));
        ImageIcon background=new ImageIcon("images.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(700,600,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(new GridBagLayout());
        back.setBounds(0,0,500,600);
        c.add(back);
        jp.setSize(500, 500);
        jp.setPreferredSize(jp.getSize());
        jp.setLayout(new GridBagLayout());
        c.setLayout(new FlowLayout());
        GridBagConstraints gbc = new GridBagConstraints(); 
        Button b = new Button("Logout");
        b.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b.setForeground(Color.blue);
        b.setBackground(new Color(255,255,255,150));
        Button  b1 = new Button("Add");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b1.setForeground(Color.blue);
        b1.setBackground(new Color(255,255,255,150));
        Button  b2 = new Button("Back");
        b2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b2.setForeground(Color.blue);
        b2.setBackground(new Color(255,255,255,150));
        JLabel l1 = new JLabel("Issue Form");
        JLabel l2 = new JLabel("Book ID");
        JLabel l3 = new JLabel("Student Name");
        JLabel l4 = new JLabel("Issue Date");
        JTextField t1=new JTextField();
        l1.setForeground(Color.blue);
        l1.setBackground(new Color(255,255,255,150));
        l1.setOpaque(true);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l1.setPreferredSize(new Dimension(250, 100));
        l2.setForeground(Color.blue);
        l2.setBackground(new Color(255,255,255,150));
        l2.setOpaque(true);
        l2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        l3.setForeground(Color.blue);
        l3.setBackground(new Color(255,255,255,150));
        l3.setOpaque(true);
        l3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        l4.setForeground(Color.blue);
        l4.setBackground(new Color(255,255,255,150));
        l4.setOpaque(true);
        l4.setFont(new Font("Times New Roman", Font.BOLD, 15));
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2.setHorizontalAlignment(JLabel.CENTER);
        l3.setHorizontalAlignment(JLabel.CENTER);
        l4.setHorizontalAlignment(JLabel.CENTER);
        gbc.fill = GridBagConstraints.HORIZONTAL;     
        gbc.weighty = 2.0; 
        gbc.gridx = 0;  
        gbc.gridy = 0; 
        jp.add(l1,gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;  
        gbc.gridy = 1; 
        jp.add(l2,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 2; 
        jp.add(t1,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 3;
        jp.add(l3,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 4; 
        jp.add(t2,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 5;
        jp.add(l4,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 6; 
        jp.add(t3,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 7; 
        gbc.weighty = 2.0;
        jp.add(b1,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 8;
        gbc.weighty = 0.0;
        jp.add(b2,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 9;
        gbc.weighty = 0.0; 
        jp.add(b,gbc); 
        back.add(jp);
        b.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
                j.dispose();
                login();
            }
        });  
         b1.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
                 try { 
                    FileWriter fr = new FileWriter("issue.csv",true);
                    BufferedWriter bw = new BufferedWriter(fr);
                    PrintWriter pr= new PrintWriter(bw);
                    pr.print(t1.getText());
                    pr.print(",\t");
                    pr.print(t2.getText());
                    pr.print(",\t");
                    pr.print(t3.getText());
                    pr.print("\n");
                    pr.flush();
                    pr.close();
                    bw.close();
                    fr.close();
                    JOptionPane.showMessageDialog(null,"Book Issued Successfully");
                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                    j.dispose();
                    menu();
                } catch (FileNotFoundException ex) {
                    
                } catch (IOException ex) {
                    Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
            }
        });  
        b2.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
                j.dispose();
                menu();
            }
        }); 
        j.setResizable(false);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     public static void issue_books()
    {
        JFrame j = new JFrame("Library Management System");
        j.setLocation(400,100);
        j.setSize(700,600);
        j.setPreferredSize(j.getSize());
        Container c= j.getContentPane();
        JPanel jp = new JPanel();
        jp.setBackground(new Color(255,255,255,75));
        ImageIcon background=new ImageIcon("images.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(700,600,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(new GridBagLayout());
        back.setBounds(0,0,500,600);
        c.add(back);
        jp.setSize(500, 500);
        jp.setPreferredSize(jp.getSize());
        jp.setLayout(new GridBagLayout());
        c.setLayout(new FlowLayout());
        GridBagConstraints gbc = new GridBagConstraints(); 
        Button b = new Button("Logout");
        b.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b.setForeground(Color.blue);
        b.setBackground(new Color(255,255,255,150));
        Button b1 = new Button("Back");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b1.setForeground(Color.blue);
        b1.setBackground(new Color(255,255,255,150));
        JLabel l1 = new JLabel("Issued Books");
        l1.setForeground(Color.blue);
        l1.setBackground(new Color(255,255,255,150));
        l1.setOpaque(true);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l1.setPreferredSize(new Dimension(250, 100));
        l1.setHorizontalAlignment(JLabel.CENTER);
        JTextArea tx = new JTextArea(20,20);
        tx.setVisible(true);
        tx.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(tx);
        scrollPane.setVisible(true);
        gbc.fill = GridBagConstraints.HORIZONTAL;     
        gbc.weighty = 2.0; 
        gbc.gridx = 0;  
        gbc.gridy = 0; 
        jp.add(l1,gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;  
        gbc.gridy = 1; 
        jp.add(tx,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 3; 
        gbc.weighty = 1.0;
        jp.add(b1,gbc);
        gbc.gridx = 0;  
        gbc.gridy = 4; 
        gbc.weighty = 0.0;
        jp.add(b,gbc); 
        back.add(jp);
        try { 
                    int start = 0,size=0;
                    FileReader fr = new FileReader("Issue.csv");
                    FileReader fr1 = new FileReader("Issue.csv");
                    BufferedReader br = new BufferedReader(fr);
                    String s= br.readLine();
                    BufferedReader br1 = new BufferedReader(fr1);
                    String s1= br1.readLine();
                    while(s1!=null)
                    {
                        s1=br1.readLine();
                        size++;
                    }
                    br1.close();
                    fr1.close();
                    String[][] data = new String[size][4];
                    while(s!=null)
                    {
                        String[] parts = s.split(",");
                        data[start][0]=parts[0]+" ";
                        data[start][1]=parts[1]+" ";
                        data[start][2]=parts[2]+" ";
                     s=br.readLine();
                     start++;
                    }
                    StringBuilder builder = new StringBuilder();
                    for(int i = 0; i < data.length; i++){
                    for(int j1 = 0; j1 < data[i].length-1; j1++){
                    builder.append(data[i][j1]);
                    builder.append(" ");
                    }
                    builder.append("\n");
                    }
                    tx.setText(builder.toString());
                    br.close();
                    fr.close();
                } catch (FileNotFoundException ex) {
                    
                } catch (IOException ex) {
                    Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
        b.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
                j.dispose();
                login();
            }
        });  
        b1.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae) {
                j.dispose();
                menu();
            }
        });  
        j.setResizable(false);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
       login();
    }
    
}
