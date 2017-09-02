<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Employee</h1>
       <form:form method="post" action="/jdbcTemplate/editsave">  
      	<table >  
      	<%-- <tr>
      	<td></td>  
         <td><form:hidden  path="id" /></td>
         </tr>  --%>
         <tr>  
          <td>First Name : </td> 
          <td><form:input path="firstname"  /></td>
         </tr>
         <tr>  
          <td>Last Name : </td> 
          <td><form:input path="lastname"  /></td>
         </tr>  
         <tr>  
          <td>Salary :</td>  
          <td><form:input path="salary" /></td>
         </tr> 
         <tr>  
          <td>Designation :</td>  
          <td><form:input path="designation" /></td>
         </tr>
         <tr>  
          <td>Location :</td>  
          <td><form:input path="location" /></td>
         </tr>
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
