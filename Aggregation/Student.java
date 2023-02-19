
public class Student {

	//Instance Variables
	private int id;
	private String major;
	private Course course;
		
	//Constructor
	//The below constructor is the default constructor. It provides no arguments
	//and initializes all string attributes to "?"
	//It also invokes the Course class
	public Student() {
		this.id = 0;			
		this.major = "?";		
		this.course = new Course();
	}	
	/*
	//Constructor 2 
	//This is the overloading constructor.  
	//This constructor takes arguments and uses them to initialize the attribute
	*/
	public Student(int id, String major, Course course) {
		this.id = id;
		this.major = major;
		this.course = course;
	}

	//Accessor Methods - getters
	//Accessor methods set the value of the private instance variable.
	
	//The below method is used to get (return) the value of id.
	public int getId() {
		return id;
	}
	//The below method is used to get (return) the value of major.
	public String getMajor() {
		return major;
	}
	//The below method is used to get (return) the value of class.
	public Course getCourse() { 
		return course;
	}
	
	//Mutator Methods - setters
	//Mutator methods take in a new parameter and use that parameter to assign it to the instance variable.
	
	//The below method is used to set the value of the instance variable id. 
	public void setId(int someId) {
		this.id = someId;
	}
	//The below method is used to set the value of the instance variable major. 
	public void setSubject(String someMajor) {
		this.major = someMajor;
	}
	//The below method is used to set the value of the instance variable course. 
	public void setCourse(int courseId, String instructor, String subject) {
		this.course = course;
				//Course(courseId, instructor, subject);
		
	}
	public String toString() { 
		String str;
		str = "\nStudent information:" +
				"\nStudent Id:\t" + id + 
				"\nMajor:\t\t" + major +"\n";
		String str2 = str.concat(course.toString());
		return str2;
	}
}
