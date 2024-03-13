<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%-- 
    Document   : EtudiantsList
    Created on : May 17, 2023, 10:08:08 PM
    Author     : KAOUTAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Trainers - Mentor Bootstrap Template</title>
  
  <script src="${pageContext.request.contextPath}/js/jquery.js" sync></script>
  <script src="${pageContext.request.contextPath}/js/main.js" ></script>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link th:href="@{/img/logo.png}"  rel="icon">
  <link th:href="@{/img/logo.png}" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

 <link href="css/animate.min.css"  rel="stylesheet">
  <link href="css/aos.css"  rel="stylesheet">
  <link href="css/bootstrap.min.css"  rel="stylesheet">
  <link href="css/bootstrap-icons.css"  rel="stylesheet">
  <link href="css/boxicons.min.css" rel="stylesheet">
  <link href="css/remixicon.css"  rel="stylesheet">
  <link href="css/swiper-bundle.min.css"  rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="css/style.css" rel="stylesheet">



</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <h1 class="logo me-auto"><a href="/mini_annuaire"><img src='css/logo.png'  width="100" height="70"></a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo me-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

       <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><a class="" href="Etudiants/Insertion">Ajouter</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->
    </div>
  </header><!-- End Header -->

  <main id="main" data-aos="fade-in">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs">
      <div class="container">
        <h2>Etudiants</h2>
        <p>List des etudiants</p>
        
      </div>
    </div><!-- End Breadcrumbs -->
  
     <c:choose>
  <c:when test="${empty success}">
   <div></div>
  </c:when>
  <c:otherwise>
<div>
          <div class="alert sucess" style="background-color:green;padding:12px;border-radius: 0;text-align: center;margin-bottom: 10px;color:white">    
    <span class="alert-icon"><i class="fas fa-check"></i>      
    </span>
    <span class="alert-content">
      <span class="alert-close"><i class="fas fa-times"></i></span>
      <span class="alert-title">${success}</span>
    </span>    
  </div>
      </div>   <c:remove var="success"/>
  </c:otherwise>
</c:choose>

    <!-- ======= Trainers Section ======= -->
    <section style='text-align:center' id="trainers" class="trainers">
    <input id="filtrer" style="border:1px solid gray;text-align:center;padding:8px;margin-bottom: 50px;border-radius: 8px" placeholder="filtrer" type="text">
    <select id="departements" style="width:200px;padding: 8px">
        <option value="">Departements</option>
        <c:forEach items="${departements}" var="departement">
            <option value="${departement.label}">${departement.label}</option>
        </c:forEach>
    </select>
    
    <select id="filieres" style="width:200px;padding: 8px">
        <option value="">Filieres</option>
    </select>
    
      <div class="container" data-aos="fade-up">

        <div id="table" class="row" data-aos="zoom-in" data-aos-delay="100">
            <c:forEach items="${etudiants}" var="etudiant">
          <div  class="item col-lg-6 col-md-6 d-flex align-items-stretch">
            <div class="member w-100">
              <div class="w-100 member-content p-4">
                <h4 >Etudiant :${etudiant.prenom} ${etudiant.nom}</h4>
                <p>CNE : ${etudiant.CNE}</p>
                <p>Filiere : ${etudiant.filiere.label}</p>
                <p>Departement : ${etudiant.departement.label}</p>
                <div class="social">
                  <a href="tel:+212${etudiant.telephone}" ><i class=""><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telephone-fill" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
</svg></i></a>
                </div>
              </div>
            </div>
          </div>
         </c:forEach>

        </div>

      </div>
    </section><!-- End Trainers Section -->

  </main><!-- End #main -->


  <!-- Vendor JS Files -->
  <script src="js/purecounter_vanilla.js" ></script>
  <script src="js/aos.js" ></script>
  <script src="js/bootstrap.bundle.min.js" ></script>
  <script src="js/swiper-bundle.min.js" ></script>

  <!-- Template Main JS File -->
  <script src="js/main1.js" ></script>
  
  
  <script>
            let input = $('#filtrer');
            let depSelect = $('#departements');
            let filSelect = $('#filieres');
            input.keyup(function(){
                getResponseByAjax(input.val(),depSelect.val(),filSelect.val());
            });
            
            depSelect.change(function(){
                if((depSelect).val()===''){
                   filSelect.html('');
                   filSelect.append("<option value=''>Filieres</option>");
                }
                else{
                $.ajax({
                    type:"GET",
                    url:"/mini_annuaire/FilieresByDepartementServlet?departement="+depSelect.val(),
                    dataType:'json'
                }).done(function(result){
                    filSelect.html('');
                   filSelect.append("<option value=''>Filieres</option>");
                    for(var i in result){
                        filSelect.append("<option value='"+result[i].label+"'>"+result[i].label+"</option>");
                    }
                });
              getResponseByAjax(input.val(),depSelect.val(),'');
            }
            });
            
            filSelect.change(function(){
                getResponseByAjax(input.val(),depSelect.val(),filSelect.val());
            });
            
            function getResponseByAjax(hint,dep,fil){
                $.ajax({
                    type:"GET",
                    url:"/mini_annuaire/EtudiantsByHint?hint="+hint+"&&filiere="+fil+"&&departement="+dep,
                    dataType:'json'
                }).done(function(result){
                    const items = document.querySelectorAll('.item');
                    items.forEach(item => {
                      item.remove();
                    });
                    

                    //item.innerHTML = '<div class="cell">CNE</div><div class="cell">Nom</div><div class="cell">Prenom</div><div class="cell">Telephone</div><div class="cell">Filiere</div><div class="cell">Departement</div>';
                    for(var i in result){
                        const item = document.createElement("div");
                        item.classList.add("item");
                        item.classList.add("col-lg-6");
                        item.classList.add("col-md-6");
                        item.classList.add("d-flex");
                        item.classList.add("align-items-stretch");
                        item.innerHTML = '<div class="member w-100"><div class="w-100 member-content p-4"><h4 >Etudiant : '+result[i].prenom+' '+result[i].nom+'</h4><p>CNE : '+result[i].CNE+'</p><p>Filiere : '+result[i].filiere.label+'</p><p>Departement : '+result[i].departement.label+'</p><div class="social"><a href="tel:+212'+result[i].telephone+'" ><i class=""><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telephone-fill" viewBox="0 0 16 16"><path fill-rule="evenodd" d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/></svg></i></a></div></div></div>';
                        document.getElementById('table').appendChild(item);
                    }
                });
            }
            
        </script>

</body>

</html>