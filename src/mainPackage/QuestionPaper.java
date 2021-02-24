package mainPackage;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class QuestionPaper extends Frame {
    String[] options;
    String Answer;
    String questionNumber;
    Label questionLabel;
    String questionString;
    int x,y;
    Label label;
    public QuestionPaper(Label label)
    {
        this.x = x;
        this.y = y;
        this.options = options;
        this.setLayout(null);
        this.label = label;


    }
    public void addQuestion(int x,int y,String question,String[] options)
    {
        questionString = question;
        setQuestion(x,y,questionString);
        setOptions(options,x,y+10,questionString);

    }
    public void setQuestion(int x,int y,String question)
    {
        questionLabel = new Label(question);
        questionLabel.setBounds(x,y,300,20);
        questionLabel.setForeground(Color.BLACK);
        this.add(questionLabel);
    }
    public void setOptions(String[] options,int x,int y,String q)
    {
        CheckboxGroup group = new CheckboxGroup();
        int X = x;
        int Y= y;
        Checkbox optionBoxes[] = new Checkbox[options.length];
        for (int i = 0; i < optionBoxes.length; i++) {

            optionBoxes[i] = new Checkbox(options[i],group,false);
            optionBoxes[i].setBounds(X,Y+10,300,20);
            optionBoxes[i].setForeground(Color.BLUE);
            final String name = optionBoxes[i].getLabel();
            optionBoxes[i].addItemListener(
                    new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            label.setText(q+" -> "+group.getSelectedCheckbox().getLabel());
                        }
                    }
            );
            Y+=20;
            this.add(optionBoxes[i]);
        }

    }


}
    class MainClass
    {
        public static void main(String[] args) {
            Label ansLabel = new Label("Ans");
            ansLabel.setBounds(20,50,300,10);
            ansLabel.setForeground(Color.RED);
            ArrayList<String[]> options = new ArrayList<>();
            options.add(new String[]{"1a","1b","1c","1d"});
            options.add(new String[]{"2a","2b","2c","2d"});
            options.add(new String[]{"3a","3b","3c","3d"});
            ArrayList<String> questions = new ArrayList<>();
            questions.add("q1");
            questions.add("q2");
            questions.add("q3");
            QuestionPaper questionPaper = new QuestionPaper(ansLabel);
            questionPaper.setSize(1000,1000);
            questionPaper.addWindowListener(
                    new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            System.exit(0);
                        }
                    }
            );
            questionPaper.setVisible(true);
            questionPaper.add(ansLabel);
            int y = 100;
            for (int i = 0; i <questions.size(); i++) {
                questionPaper.addQuestion(50,y,questions.get(i),options.get(i));
                y+=140;

            }
        }
    }
