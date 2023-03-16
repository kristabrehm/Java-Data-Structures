public class ReviewMovieGenreComparator implements Comparator<Movie>  {
	
	private int compareCollection, compareGenres, compareNames, compareDirectors, compareReviews;
	
	//Method:
	public int compare(Movie movie1, Movie movie2) {

		 compareCollection = movie1.getTotalCollection() - movie2.getTotalCollection();	
		
		 compareGenres = movie1.getMovieGenre().getGenre().compareTo(movie2.getMovieGenre().getGenre());					
		 compareNames = movie1.getMovieName().compareTo(movie2.getMovieName()); 								
		 compareDirectors = movie1.getDirector().compareTo(movie2.getDirector());					
		 compareReviews = movie1.getReview().compareTo(movie2.getReview());							
		
		if (compareGenres != 0) {
			return compareGenres;
		} else {
			if(compareCollection != 0) {
				return compareCollection;
			} else {
				if (compareNames != 0) {
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
}
