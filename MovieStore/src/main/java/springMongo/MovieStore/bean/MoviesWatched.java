package springMongo.MovieStore.bean;

public class MoviesWatched {

	public String movieTitle;
	
	public double rating;
	
	public MoviesWatched(String movieTitle, double rating)
	{
		this.movieTitle = movieTitle;
		this.rating = rating;
	}
	public MoviesWatched() {}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
