User H2 Database as the in-memory DB. 
http://localhost:8080/h2-console/

url:http://localhost:8080/movies/avgRating/{movieId}
method:GET
request:movieId
response:movieDto


url:http://localhost:8080/movies/top5ByGenre/{genre}/{userId}
method:GET
request:userId
response:movieDto


url:http://localhost:8080/users/getMoviesWatched/{userId}
method:GET
request:userId
response:UserMoviesDto

