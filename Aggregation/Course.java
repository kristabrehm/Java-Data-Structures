public class Course {

		//Instance Variables
		private int courseId;
		private String instructor;
		private String subject;
		
		//Constructor
		//The below constructor is the default constructor. It provides no arguments
		//and initializes all attributes to "?"
		public Course() {
			this.courseId = 0;
			this.instructor = "?";
			this.subject = "?";
		}
		//Constructor 
		//This is the 2nd constructor (overloading) 
		//This constructor takes arguments and uses them to initialize the attributes
		public Course(int courseId, String instructor, String subject) {
			this.courseId = courseId;
			this.instructor = instructor;
			this.subject = subject;
		}
		//Accessor Methods - getters
		//Accessor methods set the value of the private instance variable.
		
		//The below method is used to get (return) the value of the instance variable courseId
		public int getCourseId() {
			return courseId;
		}
		//The below method is used to get (return) the value of the instance variable instructor
		public String getInstructor() {
			return instructor;
		}
		//The below method is used to get (return) the value of the instance variable subject
		public String getSubject() {
			return subject;
		}
		
		//Mutator Methods - setters
		//Mutator methods take in a new parameter and use that parameter to assign it to the instance variable.
		
		//The below method is used to set the value of the instance variable courseId. 
		public void setCourseId(int someCourseId) {
			this.courseId = someCourseId;
		}
		//The below method is used to set the value of the instance variable instructor. 
		public void setInstructor(String someInstructor) {
			this.instructor = someInstructor;
		}
		//The below method is used to set the value of the instance variable subject. 
		public void setSubject(String someSubject) {
			this.subject = someSubject;
		}
		//The toString() method is used to return a string with all of the information required: id, instructor, and subject
		public String toString() { 
			String string;
			string = "\nCourse information:" + 
					  "\nCourse ID:\t" + courseId + 
					  "\nInstructor:\t" + instructor + 
					  "\nSubject:\t" + subject + "\n";
			return string;
		}
}
