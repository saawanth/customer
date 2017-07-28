package springMongo.MovieStore.bean;


public class Movieswatched {

	public Integer mid;
	
	public String genre;
	
	public String movieTitle;
	
	public double rating;
	
	public Movieswatched(Integer mid, String genre, String movieTitle, double Rating)
	{
		this.mid = mid;
		this.genre = genre;
		this.movieTitle = movieTitle;
		this.rating = Rating;
	}
	public Integer getId() {
		return mid;
	}
	public void setId(Integer id) {
		this.mid = id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
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
