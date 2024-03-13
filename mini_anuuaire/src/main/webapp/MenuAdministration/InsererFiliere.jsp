<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : InsererFiliere
    Created on : May 18, 2023, 5:34:57 PM
    Author     : KAOUTAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Forms.css">
        <title>Inserer Filiere</title>
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
     <h1 align="center" style="color:white;margin-bottom: 10px;text-transform: uppercase">Inserer Filiere</h1>

  <div class="form">
    <form class="login-form" method="post" action="Insertion">
      <input type="text" placeholder="Label" name="label"/>
      <label >
          <h4 align="left">Departement</h4>
      </label>
      <select style="padding: 8px;width:100%;margin-bottom: 35px" name="departementLabel">
          <c:forEach items="${departements}" var="departement">
              <option value="${departement.label}">${departement.label}</option>
          </c:forEach>
      </select>
      <button style="background-color: #3ac162">Inserer</button>
    </form>
  </div>
</div>
    </body>
</html>
