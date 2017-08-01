<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Employee</h1>
       <form:form method="post" action="myMovies">  
      	<table >  
         <tr>  
          <td>Name : </td> 
          <td><form:input path="userName"  /></td>
         </tr>
         <tr>  
          <td>Age : </td> 
          <td><form:input path="age"  /></td>
         </tr>
   
         <tr>  
          <td>Movie Name :</td>  
          <td><form:input path="salary" /></td>
         </tr> 
         <tr>  
          <td>Rating :</td>  
          <td><form:input path="designation" /></td>
         </tr>
        </table>  
       </form:form>  
