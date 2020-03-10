package gui;

import algorithm.Playfair;
import element.CharElement;
import utils.CharOperation;
import utils.PhraseOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EncryptPanel extends JPanel implements ActionListener {

    private JTextArea areaKeyword, areaPlain, areaCipher;
    private JLabel lblKeyword, lblPlain, lblCipher;
    private JButton btnProcess;
    private PhraseOperation phraseOperation;
    private CharOperation charOperation;
    private Playfair playfair;

    public EncryptPanel(){
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setVgap(20);
        flowLayout.setHgap(30);
        setLayout(flowLayout);
        setPreferredSize(new Dimension(480,320));

        lblKeyword = new JLabel("Keyword :");
        areaKeyword = new JTextArea("", 3, 30);

        lblPlain = new JLabel("Plain Text :");
        areaPlain = new JTextArea("", 3, 30);

        lblCipher = new JLabel("Cipher Text : ");
        areaCipher = new JTextArea("", 3, 30);
        areaCipher.setEditable(false);

        this.add(lblKeyword);
        this.add(areaKeyword);

        this.add(lblPlain);
        this.add(areaPlain);

        this.add(lblCipher);
        this.add(areaCipher);

        flowLayout.setAlignment(FlowLayout.CENTER);
        btnProcess = new JButton("Encrypt");
        add(btnProcess);
        btnProcess.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object ob = actionEvent.getSource();
        if(ob.equals(btnProcess)){
            phraseOperation = new PhraseOperation();
            playfair = new Playfair();

            String plainText = areaPlain.getText();
            String keyword = areaKeyword.getText();

            phraseOperation.setKeyword(keyword);
            char[][] matrix = phraseOperation.getMatrix();

            for (int i=0; i<matrix.length; i++){
                for (int j=0; j<matrix[0].length; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            ArrayList<CharElement> listBigram = phraseOperation.getPhrase(plainText);
            for (CharElement ce:listBigram) {
                System.out.print(ce.getChar1() + "" + ce.getChar2() + " ");
            }

            areaCipher.setText(playfair.encrypt(matrix, listBigram));
        }
    }
}
