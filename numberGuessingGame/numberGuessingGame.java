import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Random;

public class numberGuessingGame {
private int numOfGuesses = 5;

    public static void main(String[] args) {
SwingUtilities.invokeLater(()-> new
numberGuessingGame().createAndShowGUI());
}

private void createAndShowGUI(){
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.CYAN); //setted background colour of the frame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         //adjusting dimensions
        frame.setSize(new Dimension(400, 200));
        frame.setTitle("Number Guessing Game,for exit click exit button");

        // Creating and adding label to the content pane
        JLabel label = new JLabel("Welcome to Number Guessing Game . Enter your name:");
        frame.getContentPane().add(label);


       // Creating and adding text field to the content pane
        JTextField field = new JTextField(10);
        frame.getContentPane().add(field);

        // Creating and adding submit button to the content pane
        JButton submitButton = new JButton("Submit");
        frame.getContentPane().add(submitButton);


        // Setting layout
        frame.setLayout(new FlowLayout());


        // Making the frame visible
        frame.setVisible(true);

        // Adding action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Getting the entered name
                String name = field.getText();

                // Creating a new label to prompt the user interest
                JLabel interestLabel = new JLabel(name + ", would you like to exit from the game?");
                frame.getContentPane().add(interestLabel);

                // Creating and adding exit button for the user interaction
                
                JButton exitButton = new JButton("Exit");
                exitButton.setBackground(Color.RED);
               exitButton.addActionListener(new ActionListener(){
                 @Override
                  public void actionPerformed(ActionEvent e){
                   //exit application
                       System.exit(0);
                  }
                  });
                frame.getContentPane().add(exitButton);
              

                // Creating scanner and random classes
                Scanner scanner = new Scanner(System.in);
                Random random = new Random();

                // Declaring variables and initialization
                int comGuessNum = random.nextInt(100) + 1;
                int userGuessNum = 0;
                

                // Prompting user
                System.out.println("You have a maximum of 5 attempts limit. Enter a guess number between 1 to 100:");

                while (userGuessNum != comGuessNum && numOfGuesses>0) {
                    userGuessNum = scanner.nextInt();
                       numOfGuesses--;
                    if (userGuessNum < comGuessNum) {
                        System.out.println("Your guess number is smaller.");
                    } else if (userGuessNum > comGuessNum) {
                        System.out.println("Your guess number is greater.");
                    } else {
                        System.out.println("OOhhOO! Your number is correct."+ name +    " You win the game!");
                    }
                      if(numOfGuesses == 0){
                          System.out.println("No more attempts left.Game over.");
                   break;
                }
                  System.out.println("You have,"+numOfGuesses+"attempts left." );
                  
                 }
                scanner.close();
            }
        });
        }
        }
