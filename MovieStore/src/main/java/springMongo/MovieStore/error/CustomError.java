package springMongo.MovieStore.error;

public class CustomError {

	public String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public CustomError(String error)
	{
		this.error = error;
	}
	
	public CustomError() {}
}
