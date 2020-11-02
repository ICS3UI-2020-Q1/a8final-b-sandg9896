import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel countLabel;

  JButton resetButton;
  JButton countButton;
  
  JTextArea outputArea;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
    // initialize the main JPanel
    mainPanel = new JPanel();
    // turn on the manual layouts
    mainPanel.setLayout(null);
    // add the panel to the JFrame to see it
    frame.add(mainPanel);
 
   // create the Label to let the user know what to enter
   countLabel = new JLabel("Counter:");
   // set location of count label
   countLabel.setBounds(100, 70, 150, 20);
   // add label to output area
   mainPanel.add(countLabel);

   

   // initialize the JButtons
   countButton = new JButton("count");
   resetButton = new JButton("reset");
   // set the location and size of the buttons
   countButton.setBounds(80, 10, 100, 35);
   resetButton.setBounds(220, 10, 100, 35);
   // add the actionListener to the buttons
   countButton.addActionListener(this);
   resetButton.addActionListener(this);
   // give each button an actionCommand
   countButton.setActionCommand("count");
   resetButton.setActionCommand("reset");
   // add the buttons to the main panel
   mainPanel.add(countButton);
   mainPanel.add(resetButton);

   // initialize the JButtons
   outputArea = new JTextArea("0");
   // set the location and size of the buttons
   outputArea.setBounds(200, 70, 100, 20);
   // disable the textAreas so that the user can't type in them
   outputArea.setEnabled(false);
   // add the button to the main panel
   mainPanel.add(outputArea);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("count")){
    // get text from each text boxes
    String firstText = outputArea.getText();
    //change the string into an integer
    int convertedCount = Integer.parseInt(firstText);
    // increase number by one if under 10
    if(convertedCount < 10){
    int sumConvertedCount = convertedCount + 1;
    outputArea.setText("" + sumConvertedCount);
     }
    }

    if(command.equals("reset")){
     // clear the text in the box
     outputArea.setText("0");
    }
   }
  
  
  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}

