package springMongo.MovieStore.bean;

public class Movieswatched {

	public String movieTitle;
	
	public double rating;
	
	public Movieswatched(String movieTitle, double Rating)
	{
		this.movieTitle = movieTitle;
		this.rating = Rating;
	}
	public Movieswatched() {}

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
