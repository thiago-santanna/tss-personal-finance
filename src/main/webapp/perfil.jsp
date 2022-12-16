<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<jsp:include page="components/head.jsp"></jsp:include>
<body>
   <div class="container-fluid position-relative d-flex p-0">
     <!-- Spinner Start -->
	 <jsp:include page="components/spinner.jsp"></jsp:include>
     <!-- Spinner End -->

     <!-- Sidebar Start -->
	 <jsp:include page="components/sidebar.jsp"></jsp:include>
     <!-- Sidebar End -->
     
        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <jsp:include page="components/navbar.jsp"></jsp:include>
            <!-- Navbar End -->
            
            <!-- Container Start -->
            <div class="container-fluid pt-4 px-4">            
		     <div class="row g-4 d-flex justify-content-center">
		       <div class="col-sm-12 col-xl-12">
		         <div class="bg-secondary rounded h-100 p-4">
			         <div class="row g-4 d-flex justify-content-center">
				         <div class="col-sm-12 col-xl-6">				         
						    <form>
						     <div class="d-flex flex-row justify-content-between align-items-center">
                                 <div class="mb-2">
	                                   <div class="col-3">				             	
							                 <label for="id" class="form-label">ID</label>
							                 <input 
								                 type="text" 
								                 class="form-control" 
								                 id="id" 
								                 name="id" 
								                 aria-describedby="idHelp"
							                 >
						             	</div>
							             <div class="mb-2 form-check">
							                 <input type="checkbox" class="form-check-input " id="exampleCheck1">
							                 <label class="form-check-label" for="exampleCheck1">Ativo</label>
							             </div>
					             </div>
					             <div class="mb-2">
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
						     </div>				             
				                                      
				             <div class="mb-2">
				                 <label for="login" class="form-label">Login</label>
				                 <input 
					                 type="text" 
					                 class="form-control" 
					                 id="login" 
					                 name="login" 
					                 aria-describedby="loginHelp"
				                 >
				             </div>           
				             <div class="mb-2">
				                 <label for="email" class="form-label">E-mail</label>
				                 <input 
					                 type="email" 
					                 class="form-control" 
					                 id="email" 
					                 name="email" 
					                 aria-describedby="emailHelp"
				                 >
				             </div>
				             <div class="mb-2 col-xl-6">
				                 <label for="password" class="form-label">Senha</label>
				                 <input 
					                 type="password" 
					                 class="form-control" 
					                 id="password" 
					                 name="password" 
					                 aria-describedby="passwordHelp"
				                 >
				             </div>              
				             <button type="submit" class="btn btn-primary">Salvar</button>
				           </form>				         
				         </div>
				     </div>
		         </div>
		       </div>
		     </div>
		     
		     <!-- Container End -->
            </div>
            
            <!-- Footer Start -->
			<jsp:include page="components/footer.jsp"></jsp:include>
            <!-- Footer End -->
        </div>
        <!-- Content End -->
   </div>                

    <!-- JavaScript Libraries -->
	<jsp:include page="components/javascript.jsp"></jsp:include>
	
<script type="text/javascript">
function visualizarImg(fotoembase64, filefoto) {   
    
    let preview = document.getElementById(fotoembase64); // campo IMG html
    let fileUser = document.getElementById(filefoto).files[0];
    let reader = new FileReader();
    
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