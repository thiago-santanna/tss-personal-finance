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
			                <div class="mb-3 col-2">
			                    <label for="id" class="form-label">ID</label>
			                    <input type="text" class="form-control" id="id" name="id" aria-describedby="IdHelp">			                    
			                </div>
			                <div class="mb-3">
			                    <label for="nome" class="form-label">Nome</label>
			                    <input type="text" class="form-control" id="nome" name="nome">
			                </div>
			                <button type="submit" class="btn btn-primary">Salvar</button>
			                <button type="submit" class="btn btn-warning">Apagar</button>		             
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
</body>
</html>