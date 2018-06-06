package graph;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFrame extends JFrame{

    public JPanel mainPanel;
    private JTextArea textAreaMatrix;
    private JTextField textFieldStart;
    private JTextField textFieldFinish;
    private JTextField textFieldWay;
    private JButton buttonFindWay;
    private JButton buttonClear;
    private Graph graph = new Graph();
    private Boolean[][] graphMatrix;
    private String[] stringsMatrix; // строки матрицы смежности
    private String[] tmpString;
    private Integer start;
    private Integer finish;

    public MyFrame() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 200, 600, 200);
        setResizable(false);
        //window.pack();
        textAreaMatrix.setName("textAreaMatrix");
        textFieldStart.setName("textFieldStart");
        textFieldFinish.setName("textFieldFinish");
        textFieldWay.setName("textFieldWay");
        buttonFindWay.setName("buttonFindWay");
        buttonClear.setName("buttonClear");
        textFieldWay.setEditable(false);
        //textFieldWay.setEnabled(false);
        setVisible(true);

        buttonFindWay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldWay.setText("");
                graph.clear();
                if (textAreaMatrix.getText().equals("") ||
                        textFieldStart.getText().equals("")||
                        textFieldFinish.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "Заполните все поля!");
                    textFieldWay.setText("Ошибка! Заполните все поля ввода");
                } else {
                    Pattern vertex = Pattern.compile("[0-9]+");
                    Matcher fieldStart = vertex.matcher(textFieldStart.getText());
                    Matcher fieldFinish = vertex.matcher(textFieldFinish.getText());
                    if (fieldStart.matches() && fieldFinish.matches()) { // если в полях ввода находятся только числа
                        stringsMatrix = new String[textAreaMatrix.getLineCount()];
                        graphMatrix = new Boolean[textAreaMatrix.getLineCount()][textAreaMatrix.getLineCount()];
                        stringsMatrix = textAreaMatrix.getText().split("\n"); // массив строк из textArea
                        for (int i = 0, size = stringsMatrix.length; i < size; i++) {
                            tmpString = stringsMatrix[i].split(" "); // массив символов i-й строки
                            for (int j = 0, size2 = tmpString.length; j < size2; j++)
                                graphMatrix[i][j] = tmpString[j].equals("1") ? true : false;
                        }
                        //System.out.println(graphMatrix[Integer.parseInt(textFieldStart.getText())][Integer.parseInt(textFieldFinish.getText())]);
                        start = Integer.parseInt(textFieldStart.getText());
                        finish = Integer.parseInt(textFieldFinish.getText());
                        textFieldWay.setText(graph.findWay(graphMatrix, start, finish));
                    }
                    else
                    {
                        textFieldWay.setText("Ошибка! Некорректные вершины");
                    }
                }
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaMatrix.setText("");
                textFieldStart.setText("");
                textFieldFinish.setText("");
                textFieldWay.setText("");
                graph.clear();
            }
        });
    }
}
