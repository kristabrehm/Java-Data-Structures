public class Playlist {
    String name;
    Song first;				//this is the head of our linked list
    public Playlist(){
        name = "library";
        first = Song.END;
    }

    public Playlist(String name) {
        this.name = name;
        first = Song.END;
    }

    //this method returns the name of the song.
    //this was given to us completed
    public String getName() {
        return name;
    }

    //adds a song to the end of the playlist
    public void add(Song song){	
    	//if list is empty:										
    	if (first == Song.END) {									              //if playlist is empty
    		first = song;											                    //first song in the playlist is song	
    	} else {													                      //if playlist is not empty
    		Song last = first;										                //create a variable to store first
    		
    		while (last.next != Song.END) {							          //traverse through until at the end of list
        		last = last.next; 									              //traverse using .next
    		}
    		last.next = song;										                  //set last.next equal to the song being added
    	}
    }

    //calculates the number of songs in a playlist					
    public int size() {											
        int count = 0;												                //create a variable to count the number of songs
        Song current = first;										              //create a variable to store first
        
        while (current != Song.END) {								          //iterate through the list while its not null
        	current = current.next;									            //traverse to the next song
        	count++;												                    //increase the variable count
        }
    	return count;												                    //return the number of songs in the playlist
    }	

    //removes the first song on the playlist. 
    public Song removeFirst() {										
    	if (first == Song.END) {									              //if list is empty:
        	return Song.END;										                //return Song.END
        } else {													                    //if list is not empty:
        	Song current = first;									              //create a variable to store first
        	
        	first = first.next;										              //traverse to next song in list
        	return current;											                //return new head
        }
    }
 
    //removes a specified song										
    //In this method we need to traverse the entire list
    public int remove(Song song) {	
    	Song current = first;										                //create variable to keep track of position
    	int position = getPosition(song);							          //create variable to keep track of position							
    	
    	while(current != Song.END && current != song) {				  //iterate through list
    		if (current.next.equals(song)) {						          //if we find the song we want to remove,
    			current.next = current.next.next;					          //essentially 'skip over' the node we want removed
    			return position;									                  //return the position
    		}
    		current = current.next;									              //traverse to the next element in the list
    	}	
    	return -1;													                    //if the  song is not found return -1
    }

    																                          //this method was given to us completed
    public Song head() {    										              //returns the first song on the playlist
        return first;												                  //sets the head equal to first
    }

    //gets the position of a song if found. else returns -1
    public int getPosition(Song song) {								
    	int position = 0;											                  //create variable to keep track of position
    	Song current = first;										                //create a variable to store first
    														
    	while(current != Song.END) {								            //traverse through the loop while list isnt empty
        	if (current.equals(song)) {								          //if the current position is the desired song
        		return position;									                //return the position at which its found
        	}
    		current = current.next;									              //traverse using .next
    		position++;												                    //Increment the count
    	 }
    	return -1;													                    //if the song is not found, return -1
   }
    
    //this method lists all songs in the playlist
    public String listSongs() {										
    	String returnString = "";									              //initialize a string variable
    	Song current = first;										                //create a variable to store first
    		
       if (size() == 0) {											                //if the list is empty
    	   System.out.print("No songs in playlsit.");				    //prints there are no songs
       } else {														                    //use while loop to iterate thru list
       while (current != Song.END) {								          //if the list is NOT empty
    	   returnString += current.toString() + "\n";				    //prints out the following lines
           current = current.next; 									          //traverse to next song  
       	}
       }
	   return returnString + "\nTotal songs: " + size() + ".";	//return the concated string & total number of songs
    }
}
