import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.EventObject;


public class CoursePane extends HBox {
	//GUI components
	private ArrayList<Course> courseList;
	private VBox checkBoxContainer;
	
	
	private Label subjectLabel, courseNumLabel, instructorLabel, labelRight, labelLeft;
	private TextField textFieldOne, textFieldTwo;
	private Text success, enrollment;
	private Button buttonAdd, buttonDrop;
	private GridPane leftPane, centerPane;
	private BorderPane rightPane;
	private ComboBox <String> classOptions;
	
	private Course classTaken;
	
//constructor
public CoursePane() {
	
	//Instantiating Labels
	 subjectLabel = new Label("Subject");				
	 courseNumLabel = new Label ("Course Num");
	 instructorLabel = new Label("Instructor");  
	 labelRight = new Label("Course(s) Enrolled");
	 labelLeft = new Label("Add Course(s)");
	 
	 //Moving Labels to respective positions
	 labelLeft.setTextFill(Color.BLUE);
	 labelLeft.setFont(Font.font(null, 14));
	 labelLeft.setTranslateX(10);
	 labelLeft.setTranslateY(50);

	 labelRight.setTextFill(Color.BLUE);
	 labelRight.setFont(Font.font(null, 14));
	
	//Instantiating Array List
	 courseList = new ArrayList<Course>();

	//Instantiating Text Fields and Text
	 textFieldOne = new TextField();
	 textFieldTwo = new TextField();
	 success = new Text("No course entered");
	 enrollment = new Text("Total course enrolled: 0");
	 
	//Instantiating Buttons
	 buttonAdd = new Button("Add=>"); 
	 buttonDrop = new Button ("Drop<=");

	//Instantiating VBox
	 checkBoxContainer = new VBox();

	//Instantiating Layout
	 leftPane = new GridPane();
	 centerPane = new GridPane();
     rightPane = new BorderPane(); 

 	//Instantiating ComboBox
	 classOptions = new ComboBox<>();


	
	//step 1.3: create and set up the layout of the leftPane,leftPane contains a top label, 
	// the center sub-pane and a label show at the bottom
	 
	Border borderType = new Border((new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
		     CornerRadii.EMPTY, BorderWidths.DEFAULT)));

	//leftPane Setup
	leftPane.setPrefSize(400, 350);					//Creates size of the grid pane
	leftPane.setAlignment(Pos.TOP_LEFT);			//Positions the grid pane
	leftPane.setBorder(borderType);					//Adds border around the grid pane

	subjectLabel.setTranslateX(10);					//Moves labels, text, and text fields in grid pane to respective locations
	courseNumLabel.setTranslateX(10);
	instructorLabel.setTranslateX(10);
	
	subjectLabel.setTranslateY(150);
	courseNumLabel.setTranslateY(200);
	instructorLabel.setTranslateY(250);

	leftPane.add(labelLeft, 0, 0);	
	leftPane.add(subjectLabel, 0, 0);
	leftPane.add(courseNumLabel, 0, 0);
	leftPane.add(instructorLabel, 0, 0);

	textFieldOne.setTranslateX(80);
	textFieldOne.setTranslateY(200);

	textFieldTwo.setTranslateX(80);
	textFieldTwo.setTranslateY(250);

	success.setTranslateX(20);
	success.setTranslateY(350);

	classOptions.getItems().addAll("ACC", "AME", "BME", "CHM", "CSE", "DAT", "EEE");		//Adds specific classes to choice box
	classOptions.setValue("CSE");															//Sets default class to CSE
	classOptions.setTranslateX(80);
	classOptions.setTranslateY(150);
						

	leftPane.getChildren().addAll(classOptions, textFieldOne, textFieldTwo, success);		//Adds all components to the leftPane

	
	//step 1.4: create and set up the layout of the centerPane which holds the two buttons
	
	//centerPane Layout
	centerPane.setPrefSize(200, 400);					//Creates size of the grid pane

	buttonAdd.setTranslateX(15);						//Moves buttons to respective spots
	buttonAdd.setTranslateY(150);

	buttonDrop.setTranslateX(15);
	buttonDrop.setTranslateY(200);

	centerPane.getChildren().add(buttonAdd);			//Adds the buttons to the pane
	centerPane.getChildren().add(buttonDrop);

	buttonAdd.setOnAction(new ButtonHandler());			//Registers the buttons with their event handler
	buttonDrop.setOnAction(new ButtonHandler());

	//step 1.5: create and set up the layout of the rightPane, rightPane contains a top label,
	//checkboxContainer and a label show at the bottom
	
	//rightPane Layout
	rightPane.setPrefSize(325, 400);					//Creates size of the border pane
	rightPane.setBorder(borderType);				    //Adds border around the border pane
	
	//rightPane.setTop(labelRight);															
	
	enrollment.setTranslateY(370);					  //Moves text to respective spots

	rightPane.setCenter(checkBoxContainer);					//Initializes where the checkBoxContainer should be
	rightPane.getChildren().addAll(enrollment, labelRight);	//Adds components to the pane

	
	//CoursePane is a HBox. Add leftPane, centerPane and rightPane inside
	this.setPadding(new Insets(10, 10, 10, 10));
	this.getChildren().addAll(leftPane, centerPane, rightPane);		//Adds all panes to the stage
		
}  //end of constructor



//step 2.1: Whenever a new Course is added or one or several courses are dropped/removed, this method will
//1) clear the original checkboxContainer;
//2) create a CheckBox for each Course object inside the courseList, and also add it inside the checkboxContainer;
//3) register the CheckBox with the CheckBoxHandler.
public void updateCheckBoxContainer() {
	checkBoxContainer.getChildren().clear();								//Clears original check box

	for (int i = 0; i < courseList.size(); i++) {							//To iterate through all the courseList, we must use a for loop
		CheckBox box = new CheckBox(courseList.get(i).toString());					//Creates a new check box for each course in the courseList array
		box.setOnAction(new CheckBoxHandler(courseList.get(i)));
		checkBoxContainer.getChildren().add(box);							//We then add that check box inside the checkboxContainer	
		//box.setOnAction(new CheckBoxHandler(courseList.get(i)));			//Register the box we created with the checkBoxHandler				 
		enrollment.setText("Total course enrolled: " + courseList.size());	//We also want to keep track of the number of courses registered
	}
}

//Step 2.2: Create a ButtonHandler class
private class ButtonHandler implements EventHandler<ActionEvent> {
	
public void handle(ActionEvent e){

 try {
	 	//We need to parse all of the information using wrapper classes in order to create
	 	//a new course object. In this case, the new object created is called courseTaken. 
	 	//This course is added and dropped respectively according to what buttons are pressed.


	 		//If everything is entered correctly in all the text fields and the "Add" button is pressed
			//Then we need to check if the course exists or not and add/not add accordingly.
			if ((e.getSource() == buttonAdd) && (textFieldOne.getText().isEmpty() != true) && (textFieldTwo.getText().isEmpty() != true)){
				
		 		String classChosen = classOptions.getValue();	
		 		String number = textFieldOne.getText();
		 		String prof = textFieldTwo.getText();
			
				String subject = classChosen;
				Integer courseNum = Integer.parseInt(number);		//Parse text field input into an integer to be passed using toString()
				String instructor = prof;
				
				Boolean test = false;
				
				//For loop iterates through the array
				//The nested if statement compares the attributes instructor and courseNum
				for (int i = 0; i < courseList.size(); i++) {														
					if(courseList.get(i).getInstructor().equalsIgnoreCase(instructor) && (courseList.get(i).getCourseNum() == (courseNum))) {
						test = true;
					}
				}		
					
				//need to check whether the course already exist inside the courseList or not
				//If it's a new course, add the course object to the courseList, call the update check box method, and update the text respectively
				if (test == false) {
					classTaken = new Course(subject, courseNum, instructor);
					courseList.add(classTaken);
					updateCheckBoxContainer();
					
					success.setFill(Color.BLACK);
					success.setText("Course added successfully");
					
				}

				//If it's a duplicated course, do not add the course and update the text respectively
					else {	
						success.setFill(Color.RED);
						success.setText("Duplicated course - Not added");
			   }
			}
			
			//"Add" button is pressed, but one of the text field is empty
			//In this case we only are changing the text at the bottom of the left pane and not adding the course
			 if ((e.getSource() == buttonAdd) && (textFieldOne.getText().isEmpty() != false) || (textFieldTwo.getText().isEmpty() != false)) {
				success.setFill(Color.RED);
				success.setText("At least one field is empty. Fill all fields");
			}
			//Clear all the text fields and prepare for the next entry
			textFieldOne.setText("");
			textFieldTwo.setText(""); 
				
			 //"Drop" button is pushed and check boxes indicating which courses to drop are checked.
			//This is where the courses are removed. This only happens if the check boxes are selected
			 if (e.getSource() == buttonDrop) {		
				updateCheckBoxContainer();
				success.setFill(Color.BLACK);
				success.setText("Course added successfully");
			} 
 	} //end of try

 
 //for all other invalid actions, thrown an exception and it will be caught
 //Catches a number format exception
 catch(NumberFormatException ex)											//I would also like to note here I did have the else statement that was in
 {																			//the template here and was told to remove it by one of the TA's because its not necessary 
	 success.setText("Error! Course number must be an integer");			
 }
 //Catches any another potential error
 catch(Exception exception)
 {
	 success.setFill(Color.BLACK);
	 success.setText("Course added successfully");
 }
} //end of handle() method

} //end of ButtonHandler class


//Step 2.3: A ComboBoxHandler
private class ComboBoxHandler implements EventHandler<ActionEvent> {
	public void handle(ActionEvent e) {
		classOptions.getValue();													
	}
}//end of ComboBoxHandler


//Step 2.4: A CheckBoxHandler
private class CheckBoxHandler implements EventHandler<ActionEvent> {
	
	// Pass in a Course object so that we know which course is associated with which CheckBox
	private Course oneCourse;		
	
	//constructor
	public CheckBoxHandler(Course oneCourse) {
		
		this.oneCourse = oneCourse;				//First initialize the variable oneCourse		
	
	}
	public void handle(ActionEvent e){	
		CheckBox box2 = (CheckBox) e.getSource();	//Get the source. We need to type cast check box 
													//because a check box is an object, not an event.
		
		if(box2.isSelected() == true) {				//if the check box is selected is true, remove the course 
			courseList.remove(oneCourse);			//Removes the course from the courseList
		}
   }
  }//end of CheckBoxHandler
} 
//end of CoursePane class
