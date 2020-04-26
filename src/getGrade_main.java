import javax.swing.JFrame;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextField;
import java.util.Scanner;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class getGrade_main {
    public static void main(String[] args) {
        ArrayList<StudentInfo> info = new ArrayList<StudentInfo>();
        JFrame window = new JFrame("Get_Grade");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        try{
            ImageIcon pan = new ImageIcon(new URL("https://i.pinimg.com/originals/42/f5/fd/42f5fd10e550e5bd67935c01cf722e1a.jpg"));
            JLabel panda = new JLabel(pan);
            panda.setBounds(310, 105, 535, 500);
            panel.add(panda);
        }
        catch (MalformedURLException event) {
            JOptionPane.showMessageDialog(null, "Background is gone!, Please connect the internet and reopen program", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        JLabel label0 = new JLabel("1. Choose a TXT File by click 'Choose a file' button");
        label0.setForeground(Color.WHITE);
        label0.setBounds(5, 5, 295, 15);
        panel.add(label0);
        JButton fileChooser_button = new JButton("Choose a file");
        fileChooser_button.setLocation(5, 20);
        fileChooser_button.setSize(110, 30);
        panel.add(fileChooser_button);
        JLabel label1 = new JLabel("Show directory: Nothing's here!");
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        label1.setBounds(5, 55, 795, 15);
        fileChooser_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Text (.txt)", "txt"));
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.setDialogTitle("Choose a .txt file");
                int selectedButton = fileChooser.showDialog(null, "select");
                
                if (selectedButton == JFileChooser.APPROVE_OPTION) {
                    
                    try {
                        File currentDirectory = fileChooser.getCurrentDirectory();
                        File selectedFile = fileChooser.getSelectedFile();
                        String dirName = currentDirectory.getAbsolutePath();
                        String fileName = fileChooser.getName(selectedFile);
                        String path = "" + dirName + "\\" + fileName;
                        label1.setText("Show directory: " + path);
                        label1.setForeground(Color.WHITE);
                        Scanner sc = new Scanner(new File(path));
                        while (sc.hasNextLine()) {
                        String id = sc.next();
                        String firstName = sc.next();
                        String lastName = sc.next();
                        double score = Double.parseDouble(sc.next());
                        info.add(new StudentInfo(id, firstName+ " " +lastName, score));
                    }
                    sc.close();
                }
                
                catch (IOException event) {
                    // System.out.println(event);
                    JOptionPane.showMessageDialog(null, "Something's wrong with your file!", "IOException", JOptionPane.ERROR_MESSAGE);
                }
                
                catch (InputMismatchException event) {
                    // System.out.println(event);
                    JOptionPane.showMessageDialog(null, "Check your file!", "InputMismatchException", JOptionPane.ERROR_MESSAGE);
                }
                
                catch (NumberFormatException event) {
                    // System.out.println(event);
                    JOptionPane.showMessageDialog(null, "Check your file!", "NumberFormatException", JOptionPane.ERROR_MESSAGE);
                }
                
                    catch (NullPointerException event) {
                        // System.out.println(event);
                        JOptionPane.showMessageDialog(null, "Check your file!", "NullPointerException", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                else if (selectedButton == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null, "No Selection", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        JLabel label2 = new JLabel("2. Set the score criteria in the text field then Click 'Save' button");
        label2.setForeground(Color.WHITE);
        label2.setBounds(5, 90, 360, 15);
        panel.add(label2);
        
        JLabel aGrade = new JLabel("A grade : [");
        aGrade.setForeground(Color.WHITE);
        aGrade.setBounds(5, 115, 60, 15);
        panel.add(aGrade);
        JTextField lowA = new JTextField();
        lowA.setBounds(75, 115, 20, 15);
        lowA.setColumns(3);
        panel.add(lowA);
        JLabel aHighGrade = new JLabel(" ,  100]");
        aHighGrade.setForeground(Color.WHITE);
        aHighGrade.setBounds(100, 115, 40, 15);
        panel.add(aHighGrade);
        
        JLabel bpGrade = new JLabel("B+ grade : [");
        bpGrade.setForeground(Color.WHITE);
        bpGrade.setBounds(5, 132, 70, 15);
        panel.add(bpGrade);
        JTextField lowbp = new JTextField();
        lowbp.setBounds(75, 132, 20, 15);
        lowbp.setColumns(2);
        panel.add(lowbp);
        JLabel comma = new JLabel(" , ");
        comma.setForeground(Color.WHITE);
        comma.setBounds(100, 132, 10, 15);
        panel.add(comma);
        JTextField highbp = new JTextField();
        highbp.setBounds(115, 132, 20, 15);
        highbp.setColumns(2);
        panel.add(highbp);
        JLabel back = new JLabel(" )");
        back.setForeground(Color.WHITE);
        back.setBounds(135, 132, 10, 15);
        panel.add(back);
        
        JLabel bGrade = new JLabel("B grade : [");
        bGrade.setForeground(Color.WHITE);
        bGrade.setBounds(5, 149, 65, 15);
        panel.add(bGrade);
        JTextField lowb = new JTextField();
        lowb.setBounds(75, 149, 20, 15);
        lowb.setColumns(2);
        panel.add(lowb);
        JLabel comma1 = new JLabel(" , ");
        comma1.setForeground(Color.WHITE);
        comma1.setBounds(100, 149, 10, 15);
        panel.add(comma1);
        JTextField highb = new JTextField();
        highb.setBounds(115, 149, 20, 15);
        highb.setColumns(2);
        panel.add(highb);
        JLabel back1 = new JLabel(" )");
        back1.setForeground(Color.WHITE);
        back1.setBounds(135, 149, 10, 15);
        panel.add(back1);
        
        JLabel cpGrade = new JLabel("C+ grade : [");
        cpGrade.setForeground(Color.WHITE);
        cpGrade.setBounds(5, 166, 70, 15);
        panel.add(cpGrade);
        JTextField lowcp = new JTextField();
        lowcp.setBounds(75, 166, 20, 15);
        lowcp.setColumns(2);
        panel.add(lowcp);
        JLabel comma2 = new JLabel(" , ");
        comma2.setForeground(Color.WHITE);
        comma2.setBounds(100, 166, 10, 15);
        panel.add(comma2);
        JTextField highcp = new JTextField();
        highcp.setBounds(115, 166, 20, 15);
        highcp.setColumns(2);
        panel.add(highcp);
        JLabel back2 = new JLabel(" )");
        back2.setForeground(Color.WHITE);
        back2.setBounds(135, 166, 10, 15);
        panel.add(back2);
        
        JLabel cGrade = new JLabel("C grade : [");
        cGrade.setForeground(Color.WHITE);
        cGrade.setBounds(5, 183, 70, 15);
        panel.add(cGrade);
        JTextField lowc = new JTextField();
        lowc.setBounds(75, 183, 20, 15);
        lowc.setColumns(2);
        panel.add(lowc);
        JLabel comma3 = new JLabel(" , ");
        comma3.setForeground(Color.WHITE);
        comma3.setBounds(100, 183, 10, 15);
        panel.add(comma3);
        JTextField highc = new JTextField();
        highc.setBounds(115, 183, 20, 15);
        highc.setColumns(2);
        panel.add(highc);
        JLabel back3 = new JLabel(" )");
        back3.setForeground(Color.WHITE);
        back3.setBounds(135, 183, 10, 15);
        panel.add(back3);
        
        JLabel dpGrade = new JLabel("D+ grade : [");
        dpGrade.setForeground(Color.WHITE);
        dpGrade.setBounds(5, 200, 70, 15);
        panel.add(dpGrade);
        JTextField lowdp = new JTextField();
        lowdp.setBounds(75, 200, 20, 15);
        lowdp.setColumns(2);
        panel.add(lowdp);
        JLabel comma4 = new JLabel(" , ");
        comma4.setForeground(Color.WHITE);
        comma4.setBounds(100, 200, 10, 15);
        panel.add(comma4);
        JTextField highdp = new JTextField();
        highdp.setBounds(115, 200, 20, 15);
        highdp.setColumns(2);
        panel.add(highdp);
        JLabel back4 = new JLabel(" )");
        back4.setForeground(Color.WHITE);
        back4.setBounds(135, 200, 10, 15);
        panel.add(back4);
        
        JLabel dGrade = new JLabel("D grade : [");
        dGrade.setForeground(Color.WHITE);
        dGrade.setBounds(5, 217, 70, 15);
        panel.add(dGrade);
        JTextField lowd = new JTextField();
        lowd.setBounds(75, 217, 20, 15);
        lowd.setColumns(2);
        panel.add(lowd);
        JLabel comma5 = new JLabel(" , ");
        comma5.setForeground(Color.WHITE);
        comma5.setBounds(100, 217, 10, 15);
        panel.add(comma5);
        JTextField highd = new JTextField();
        highd.setBounds(115, 217, 20, 15);
        highd.setColumns(2);
        panel.add(highd);
        JLabel back5 = new JLabel(" )");
        back5.setForeground(Color.WHITE);
        back5.setBounds(135, 217, 10, 15);
        panel.add(back5);
        
        JButton customGrade = new JButton("Save");
        customGrade.setBounds(5, 234, 70, 30);
        panel.add(customGrade);
        customGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    for (StudentInfo index : info) {
                        index.setGrade( Integer.parseInt(lowA.getText()), Integer.parseInt(highbp.getText()), Integer.parseInt(lowbp.getText()), Integer.parseInt(highb.getText()), Integer.parseInt(lowb.getText()), Integer.parseInt(highcp.getText()), Integer.parseInt(lowcp.getText()), Integer.parseInt(highc.getText()), Integer.parseInt(lowc.getText()), Integer.parseInt(highdp.getText()), Integer.parseInt(lowdp.getText()), Integer.parseInt(highd.getText()), Integer.parseInt(lowd.getText()) );
                    }
                }
                
                catch (NumberFormatException e) {
                    // System.out.println(e);
                    JOptionPane.showMessageDialog(null, "The score criteria must be integer!", "NumberFormatException", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JLabel label3 = new JLabel("3. Set the file's name (will be exported) in the text field");
        label3.setForeground(Color.WHITE);
        label3.setBounds(5, 285, 340, 15);
        panel.add(label3);
        
        JLabel fName = new JLabel("File's name : ");
        fName.setForeground(Color.WHITE);
        fName.setBounds(5, 310, 75, 15);
        panel.add(fName);
        
        JTextField fileName = new JTextField();
        fileName.setBounds(80, 310, 75, 20);
        panel.add(fileName);
        
        JLabel dotTXT = new JLabel(" .txt");
        dotTXT.setForeground(Color.WHITE);
        dotTXT.setBounds(155, 310, 50, 15);
        panel.add(dotTXT);
        
        JLabel then = new JLabel("then Click the 'Export' button");
        then.setForeground(Color.WHITE);
        then.setBounds(5, 340, 300, 15);
        panel.add(then);
        
        JButton export = new JButton("Export");
        export.setBounds(5, 360, 120, 30);
        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Export a .txt file");
                int selectedButton = fileChooser.showDialog(null,"export");
                if (selectedButton == JFileChooser.APPROVE_OPTION) {
                    try{
                        File currentDirectory = fileChooser.getCurrentDirectory();
                        String dirName = currentDirectory.getAbsolutePath();
                        String path = "" + dirName + "\\" + fileName.getText() + ".txt";
                        File myFile = new File(path);
                        if (!myFile.exists()) {
                            myFile.createNewFile();
                        }
                        FileWriter myWriter = new FileWriter(myFile);
                        for (StudentInfo index : info) {
                            myWriter.write(index.getID()+ " " +index.getName()+ " " + index.getScore()+ " " +index.getGrade()+System.getProperty("line.separator"));
                        }
                        myWriter.close();
                    }
                    
                    catch (IOException event) {
                        // System.out.println(event);
                        JOptionPane.showMessageDialog(null, "Something's wrong with your exported file!", "IOException", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panel.add(export);
        
        window.add(panel);
        window.pack();
        window.setResizable(false);
        window.setSize(850, 550);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}