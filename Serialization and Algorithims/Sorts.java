public class Sorts {

	//Method
	//Uses selection sort to sort the movies
	public static void sort(ArrayList<Movie> reviewList, Comparator<Movie> xComparator) {
		
		int minimum;
		int n = reviewList.size();
		
		//The first for loop iterates through the array list
		for (int i = 0; i < n - 1; i++) {
			minimum = i;
			for(int j = i + 1; j < n; j++) {
				if (xComparator.compare(reviewList.get(j), reviewList.get(minimum)) < 0) { 			
					minimum = j;
			
				}
			}
			//We then need to swap the objects in the array 
			Movie temporary = reviewList.get(minimum);
			reviewList.set(minimum, reviewList.get(i));
			reviewList.set(i, temporary);
		}

	}
}
