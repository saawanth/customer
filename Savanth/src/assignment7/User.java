package assignment7;

public class User implements Comparable<User> {
	
	
		public String name;  
		public int rating;
		public User(String name, String rating) {
			this.name = name;
			this.rating =Integer.parseUnsignedInt(rating) ;
		}
		
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", rating=" + rating + "]";
		}

		@Override
		public int compareTo(User usrrating) {
			if(this.getRating() > usrrating.getRating())
				return 1;
			else if(this.getRating() == usrrating.getRating())
				return -1;
			else
				return 0;
			
		}
	 
		} 

