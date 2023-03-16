public class Movie implements Serializable {		
	
	//Instance Variables:
	private String movieName;
	private int stars;
	private String review;
	private int totalCollection;
	private String director;
	private MovieGenre movieGenre;
	
	private static final long serialVersionUID = 205L; 
	
	private String STARSTRING;
	private String TOTALCOLLECTIONSTRING;
	
	
	//Constructor
	public Movie(String movieName, int stars, String review, int totalCollection, String director, MovieGenre movieGenre) {
		this.movieName = movieName;
		this.stars = stars;
		this.review = review;
		this.totalCollection = totalCollection;
		this.director = director;
		
		this.movieGenre = movieGenre;	//Aggregation relationship	
	}
	
	//Getter Methods:
	//Used to access the information stored in the private variables
	public String getMovieName() {
		return movieName;
	}
	public int getStars() {
		return stars;
	}
	public int getTotalCollection() {
		return totalCollection;
	}
	public String getDirector() {
		return director;
	}
	public String getReview() {
		return review;
	}
	public MovieGenre getMovieGenre() {
		return movieGenre;
	}
	//the toString method returns a readable string of the objects
	public String toString() {											

		String string;
		
		STARSTRING = "";
		for (int i = 0; i < getStars(); i++) {
			STARSTRING += "*";
			
		}
		
		TOTALCOLLECTIONSTRING = "";
		for (int i = 0; i < getTotalCollection(); i++) {
			TOTALCOLLECTIONSTRING += "$";
		}
		
		
		string = movieName + " Movie\n" + STARSTRING + "\n" + "Total Collection earned: " + 
				TOTALCOLLECTIONSTRING + "\n" +  movieGenre.toString() + "Director: " + 
				director + "\n" + "Review:\t" + review + "\n\n";
		
		
		return string;
	}
}
