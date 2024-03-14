<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Forms.css">
        <title>Inserer Etudiant</title>
        <script src="${pageContext.request.contextPath}/js/jquery.js" sync></script>
        <script src="${pageContext.request.contextPath}/js/main.js" ></script>
       
        <jsp:useBean id="departements" scope="request" type="java.util.ArrayList<Entity.Departement>"/>
    </head>
    <body style="background-color: #3ac162;margin-top: -70px">
        
        
        
         <c:choose>
  <c:when test="${empty error}">
   <div></div>
  </c:when>
  <c:otherwise>
<div>
          <div class="alert sucess" style="background-color:red;padding:12px;margin-bottom: 10px;color:white">    
    <span class="alert-icon"><i class="fas fa-check"></i>      
    </span>
    <span class="alert-content">
      <span class="alert-close"><i class="fas fa-times"></i></span>
      <span class="alert-title">${error}</span>
    </span>    
  </div>
      </div>   
      <c:remove var="error"/>
  </c:otherwise>
</c:choose>
        
        <div class="login-page">
     <h1 align="center" style="color:white;margin-bottom: 10px;text-transform: uppercase;color:white">Inserer Etudiant</h1>

  <div class="form">
    <form class="login-form" method="post" action="Insertion">
        <input type="number" minlength="4" placeholder="CNE" name="CNE" required/>
        <input type="text" minlength="8" placeholder="nom" name="nom" required/>
        <input type="text" minlength="8" placeholder="prenom" name="prenom" required/>
        <input type="tel" minlenght="10" maxlength="10" placeholder="telephone" name="telephone" required/>
      <label >
          <h4 align="left">Departement</h4>
      </label>
      <select style="padding: 8px;width:100%;margin-bottom: 35px" name="departementLabel" id="departementLabel" required>
          <c:forEach items="${departements}" var="departement">
              <option value="${departement.label}">${departement.label}</option>
          </c:forEach>
      </select>
      <label >
          <h4 align="left">Filiere</h4>
      </label>
      <select style="padding: 8px;width:100%;margin-bottom: 35px" id="filieresLabel" name="filieresLabel" required>
      </select>
      <button style="background-color: #3ac162">Inserer</button>
    </form>
  </div>
</div>
          <script>
let test= $('#departementLabel');
    callFilieresAjax(test.val());
test.change(function(){
    let departement = test.val();
    callFilieresAjax(departement);
});

function callFilieresAjax(departement){
    $.ajax({
                    type:"GET",
                    url:"/mini_annuaire/FilieresByDepartementServlet?departement="+departement,
                    dataType:'json'
                }).done(function(result){
                    $('#filieresLabel').html('');
                    for(var i in result){
                        $('#filieresLabel').append("<option value='"+result[i].label+"'>"+result[i].label+"</option>");
                    }
                });
}
        </script>      
    </body>
</html>
