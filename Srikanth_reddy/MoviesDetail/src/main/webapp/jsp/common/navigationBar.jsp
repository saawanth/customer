<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #4005;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}
</style>
</head>
<body>



      <ul class="nav navbar-nav navbar-right">
      
       <li><a href="<%=request.getContextPath() %>/getMoviesByGenre"><span class="glyphicon glyphicon-tasks"></span>Movies By Genre</a></li>
      
                         <li><a href="<%=request.getContextPath() %>/getMoviesByUser"><span class="glyphicon glyphicon-tasks"></span>Movies By UserId</a></li>
                  <li><a href="<%=request.getContextPath() %>/title"><span class="glyphicon glyphicon-tasks"></span>Search Movie By Title</a></li>
            <li><a href="<%=request.getContextPath() %>/moviesReport"><span class="glyphicon glyphicon-tasks"></span>All Movie</a></li>
      <li><a href="<%=request.getContextPath() %>/addMovie"><span class="glyphicon glyphicon-tasks"></span>Add Movie</a></li>
      <li><a href="<%=request.getContextPath() %>/addUser"><span class="glyphicon glyphicon-tasks"></span>Add User</a></li>
        <li><a href="<%=request.getContextPath() %>/home"><span class="glyphicon glyphicon-home"></span>Home</a></li> 
   
      </ul>
   
<br>