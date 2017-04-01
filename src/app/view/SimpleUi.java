package app.view;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by msrabon on 4/1/17.
 */
public class SimpleUi extends JFrame implements ActionListener {

    File dataSet;
    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MMM/yy - hh:mm:ss ");

    //main view panel
    JPanel panel_1;

    JLabel data_label;
    JButton btn_dataSelector;
    JTextArea jTextArea;

    public SimpleUi() {
        setTitle("Auto Data Experimentar With Weka");
        setSize(500, 400);
        setResizable(false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        init();
        show();
    }

    private void init() {
        panel_1 = new JPanel(new BorderLayout());
        panel_1.setBackground(Color.DARK_GRAY);
        getContentPane().add(panel_1);

        JPanel panel_2 = new JPanel(new FlowLayout());
        panel_1.add(panel_2, BorderLayout.NORTH);

        JLabel label = new JLabel("Data set: ");
        data_label = new JLabel("Sample_Student_data.arff");
        data_label.setSize(120, 30);
        data_label.setBackground(Color.white);
        btn_dataSelector = new JButton("Data Set");
        btn_dataSelector.addActionListener(this);

        panel_2.add(label);
        panel_2.add(data_label);
        panel_2.add(btn_dataSelector);


        jTextArea = new JTextArea();
        ((DefaultCaret) jTextArea.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);
        jTextArea.setWrapStyleWord(true);
        JScrollPane consoleSP = new JScrollPane(jTextArea);
        consoleSP.setBorder(BorderFactory.createTitledBorder("Result:"));
        panel_1.add(consoleSP, BorderLayout.CENTER);
    }

    public void log(String message) {
        jTextArea.append(DATE_FORMAT.format(new Date()) + " -> " + message + " \n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_dataSelector){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            dataSet = fileChooser.getSelectedFile();
            String path = dataSet.getName();
            data_label.setText(path);
            log("DataSet File Load Success!!!");
        }
    }

    public File getDataSet() {
        return dataSet;
    }

    public void setDataSet(File dataSet) {
        this.dataSet = dataSet;
    }
}
