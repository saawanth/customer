User H2 Database as the in-memory DB. 
http://localhost:8080/h2-console/

JDBC URL:jdbc:h2:mem:mydb
UserName:cfa_admin
Password:p@$$w0rd!

url:http://localhost:8080/movies/avgRating/{movieId}
method:GET
request:movieId
response:"user": {
    "userId": 1,
    "firstname": "sri",
    "lastname": "b",
    "dateOfBirth": "1991-06-06"
  },
  "numOfMoviesWatched": 2,
  "userRatings": [
    {
      "movie": {
        "id": 1,
        "name": "Bond",
        "genre": "ACTION"
      },
      "rating": 7
    },
    {
      "movie": {
        "id": 2,
        "name": "Bond-2",
        "genre": "ACTION"
      },
      "rating": 8
    }
]
}
url:http://localhost:8080/movies/top5ByGenre/{genre}/{userId}
method:GET
request:userId
response:{
  "id": 1,
  "name": "Bond",
  "genre": "ACTION",
  "avgRating": 8.7
}


url:http://localhost:8080/users/getMoviesWatched/{userId}
method:GET
request:userId
response:[
  {
    "id": 11,
    "name": "Bond-11",
    "genre": "ACTION",
    "avgRating": 10
  },
  {
    "id": 1,
    "name": "Bond",
    "genre": "ACTION",
    "avgRating": 8.857142857142858
  },
  {
    "id": 3,
    "name": "Bond-3",
    "genre": "ACTION",
    "avgRating": 8.428571428571429
  },
  {
    "id": 2,
    "name": "Bond-2",
    "genre": "ACTION",
    "avgRating": 8.142857142857142
  },
  {
    "id": 5,
    "name": "Bond-5",
    "genre": "ACTION",
    "avgRating": 7.857142857142857
  }
]

