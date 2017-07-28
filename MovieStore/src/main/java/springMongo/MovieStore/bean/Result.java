package springMongo.MovieStore.bean;

public class Result {

	public float avgrating;
	
	

	public float getAvgrating() {
		return avgrating;
	}


	public void setAvgrating(float avgrating) {
		this.avgrating = avgrating;
	}

	public Result(float avgrating)
	{
		this.avgrating = avgrating;
	}
	
	public Result() {}
}
