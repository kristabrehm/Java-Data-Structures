public class ReviewRatingComparator implements Comparator<Movie> {

	private int ratingDifference, compareNames, compareDirectors, compareReviews;
	
	//Method:
	//Passes 2 movie objects as parameters and checks hierarchy
	public int compare(Movie movie1, Movie movie2) {
			
		 ratingDifference = movie1.getStars() -  movie2.getStars();			
		 compareNames = movie1.getMovieName().compareTo(movie2.getMovieName());					
		 compareDirectors = movie1.getDirector().compareTo(movie2.getDirector());		
		 compareReviews = movie1.getReview().compareTo(movie2.getReview());	
		
		 if (ratingDifference != 0) {
			 return ratingDifference;
		 } else {
			 if(compareNames != 0) {
				return compareNames;
			 } else {
				 if (compareDirectors != 0) {
					 return compareDirectors;
				 } else {
						 return compareReviews;
				 }
			 }
		 }
	}
}
