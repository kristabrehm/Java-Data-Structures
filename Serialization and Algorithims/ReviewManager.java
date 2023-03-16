import java.io.Serializable;
import java.util.ArrayList;

public class ReviewManager implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L;

    ArrayList<Movie> reviewList;

    //Constructor:
    public ReviewManager() {
        reviewList = new ArrayList<>();
    }
    
    //Search for a Movie object in the reviewList by both its name and director. 
    //Return the index of the object if it is found. Otherwise, return -1.
    public int movieExists(String movieName, String director) {
    	for (int i = 0; i < reviewList.size(); i++) {				
			if (reviewList.get(i).getMovieName().equalsIgnoreCase(movieName) && reviewList.get(i).getDirector().equalsIgnoreCase(director)) {
				return i;		
			}
		}
    	return -1;
    }

    
    //This method returns an ArrayList of integers. 
    //Search for a genre in the reviewList that has the provided movieGenre. 
    //Return the indexes of the genre if found. 
    //If the ArrayList is empty then the movie genre doesn't exist.
    public ArrayList<Integer> movieGenreExists(String existence){		
    	
    	ArrayList<Integer> array = new ArrayList<Integer>();
    	boolean answer = reviewList.isEmpty();
    	
    	if (answer == false) {
    		for (int i = 0; i < reviewList.size(); i++) {
    			//search for a genre in the reviewList that has provided movieGenre
    			if (reviewList.get(i).getMovieGenre().getGenre().equalsIgnoreCase(existence)) {
    				array.add(i);
    				return array;
    			}
    		}
    	}	
    	return array;
    }
    
    //Getter Method:
    //This method returns the movie object in the array list at the index the user passes in
    public Movie getMovie(int number) {			
    	return reviewList.get(number);							
    }
   
    /**
     * Add a Movie object to the reviewList and return true if such an object
     * is added successfully. Otherwise, return false. Two Movies are
     * considered duplicated if they have exactly the same movie name and genre.
     * 
     * @param  movieName          the name of the movie
     * @param  stars              the number of stars the movie recieved
     * @param  review             the movie review
     * @param  totalCollection    the integer total collection earned by the movie
     * @param  genre              the movie's genre
     * @param  director           the movie's director
     * @param  prodictionCompany  production comapny of the movie
     * @return                    true if the operation is successful; false otherwise
     */
    
    //Adds a movie review to the reviewList
    //2 movies are duplicate if they have exactly the same movie name and director
    public boolean addReview(String movieName, int stars, String review, String totalCollection, String genre, String director, String productionCompany) {
        if (movieExists(movieName, director) == -1) {
            int collection = totalCollection.length();
            MovieGenre newGenre = new MovieGenre(genre, productionCompany);
            Movie newMovie = new Movie(movieName, stars, review, collection, director, newGenre);
            reviewList.add(newMovie);
            return true;
        }
        return false;
    }
    
    //Remove a movie object with the given movie name and director
    public boolean removeReview(String movieNameRemove, String directorRemove) {						
    	int reviewToRemove = movieExists(movieNameRemove, directorRemove);
    	for (int i = 0; i < reviewList.size(); i++) {				
    		if (reviewToRemove != -1) {
    			reviewList.remove(reviewToRemove);
    			return true;
    		}
    	}
    	return false;
    }
    //Sort the reviewList by rating and then the movie name in alphabetical order. 
    //The method calls the sort method in the Sorts class by using an object generated 
    //from the ReviewRatingComparator class
    public void sortByRating() {																
    	ReviewRatingComparator reviewRating = new ReviewRatingComparator();
    	Sorts.sort(reviewList, reviewRating);																
    }
    
    //Sort the reviewList by movie's genre in alphabetical order of the genre of movie, then the movie name. 
    //The method calls the sort method defined in the Sorts class 
    //by using an object generated from the ReviewMovieGenreComparator class.	
    public void sortByMovieGenre() {															
    	ReviewMovieGenreComparator reviewGenre = new ReviewMovieGenreComparator();										
    	Sorts.sort(reviewList, reviewGenre);																		
    }
    
    //list all movie objects in reviewList
    public String listReviews() {									
		String list = "";	
    	for (int i = 0; i < reviewList.size(); i++) {
			list = list + reviewList.get(i).toString();
		}
		return list;																	
    }
    
  //Close the system by clearing the reviewList
    public void closeReviewManager() {								
		for (int i = 0; i < reviewList.size(); i++) {
			reviewList.clear();
		}
    }
}
