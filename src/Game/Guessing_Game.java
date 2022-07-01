package Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Guessing_Game {
    private JButton guessButton;
    private JTextField mynumber;
    private JPanel mypanel;
    private JTextField message;
    private JTextField guesscount;

    public Guessing_Game() {
        Random random= new Random();

        int computerInput= random.nextInt(100)+1;

        guesscount.setText("Score:");
        guessButton.addActionListener(new ActionListener() {
            int i=1;

            @Override
            public void actionPerformed(ActionEvent e) {

                int guessCount=1;
                int guess = Integer.parseInt(mynumber.getText());

                if (guess == computerInput) {
                    message.setText("Congratulations, you guessed the correct no! ");
                    guesscount.setText("Score:"+i);
                }
                else if (guess < computerInput) {
                    message.setText("Incorrect guess, please try again...\tTip-Guess higher!");
                    i++;
                }
                else if (guess > computerInput) {
                    message.setText("Incorrect guess, please try again...\tTip-Guess lower!");
                    i++;
                }
                else if(guessCount==10){
                    message.setText("Sorry you're out of chances!");
                }
                if(guess <0 || guess>100){
                    message.setText("Sorry Guess is out of bounds.(0-100)");
                }
            }
        }
        );
    }


    public static void main(String[] args) {
        JFrame frame=new JFrame("Guessing Game");
        frame.setContentPane(new Guessing_Game().mypanel);
        frame.setSize(450,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
