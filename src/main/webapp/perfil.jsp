<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     

<%@page import="model.User"%>
    
<!DOCTYPE html>
<html>
<jsp:include page="components/head.jsp"></jsp:include>
<body>
   <div class="container-fluid pt-4 px-4">
     <div class="row g-4 d-flex justify-content-center">
       <div class="col-sm-12 col-xl-6">
         <div class="bg-secondary rounded h-100 p-4">
           <h5 class="mb-4">Perfil</h5>
           <form>
             <div class="mb-3 col-xl-2">
                 <label for="id" class="form-label">ID</label>
                 <input 
	                 type="text" 
	                 class="form-control" 
	                 id="id" 
	                 name="id" 
	                 aria-describedby="idHelp"
                 >
             </div>
             <div class="mb-3">
                  <div class="input-group-prepend">
                    <c:if test="${user.fotouser != '' && user.fotouser != null}">
                       <a href="<%= request.getContextPath()%>/UsuarioController?acao=downloadFoto&id=${user.id}">
                      <img alt="Imagem User" id="fotoembase64" src="${user.fotouser}" width="70px">
                     </a>
                    </c:if>
                    
                    <c:if test="${user.fotouser == '' || user.fotouser == null}">
                       <img alt="Imagem User" id="fotoembase64"  src="<%= request.getContextPath()%>/assets/img/user.png" width="70px">
        			</c:if>
        			
                  </div>
                  <input type="file" id="fileFoto" name="fileFoto" accept="image/*" onchange="visualizarImg('fotoembase64', 'fileFoto');" class="form-control-file" style="margin-top: 15px; margin-left: 5px;">
             </div>                         
             <div class="mb-3">
                 <label for="login" class="form-label">Login</label>
                 <input 
	                 type="text" 
	                 class="form-control" 
	                 id="login" 
	                 name="login" 
	                 aria-describedby="loginHelp"
                 >
             </div>           
             <div class="mb-3">
                 <label for="email" class="form-label">E-mail</label>
                 <input 
	                 type="email" 
	                 class="form-control" 
	                 id="email" 
	                 name="email" 
	                 aria-describedby="emailHelp"
                 >
             </div>
             <div class="mb-3  col-xl-6">
                 <label for="password" class="form-label">Senha</label>
                 <input 
	                 type="password" 
	                 class="form-control" 
	                 id="password" 
	                 name="password" 
	                 aria-describedby="passwordHelp"
                 >
             </div>              
             <div class="mb-3 form-check">
                 <input type="checkbox" class="form-check-input" id="exampleCheck1">
                 <label class="form-check-label" for="exampleCheck1">Ativo?</label>
             </div>
             <button type="submit" class="btn btn-primary">Salvar</button>
           </form>
         </div>
       </div>
     </div>
   </div>                

    <!-- JavaScript Libraries -->
	<jsp:include page="components/javascript.jsp"></jsp:include>
	
<script type="text/javascript">
function visualizarImg(fotoembase64, filefoto) {   
    
    var preview = document.getElementById(fotoembase64); // campo IMG html
    var fileUser = document.getElementById(filefoto).files[0];
    var reader = new FileReader();
    
    reader.onloadend = function (){
	    preview.src = reader.result; /*Carrega a foto na tela*/
    };
    
    if (fileUser) {
	  reader.readAsDataURL(fileUser); /*Preview da imagem*/
    }else {
	 preview.src=  '';
    }
    
}
</script>	
</body>
</html>