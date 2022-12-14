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
			                <div class="mb-3">
			                    <label for="exampleInputEmail1" class="form-label">Email address</label>
			                    <input type="email" class="form-control" id="exampleInputEmail1"
			                        aria-describedby="emailHelp">
			                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.
			                    </div>
			                </div>
			                <div class="mb-3">
			                    <label for="exampleInputPassword1" class="form-label">Password</label>
			                    <input type="password" class="form-control" id="exampleInputPassword1">
			                </div>
			                <div class="mb-3 form-check">
			                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
			                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
			                </div>
			                <button type="submit" class="btn btn-primary">Sign in</button>		             
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