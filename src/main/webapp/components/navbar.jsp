<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<nav class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
   <a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
       <h2 class="text-primary mb-0"><i class="fa fa-user-edit"></i></h2>
   </a>
   <a href="#" class="sidebar-toggler flex-shrink-0">
       <i class="fa fa-bars"></i>
   </a>
   <div class="navbar-nav align-items-center ms-auto">
       <div class="nav-item dropdown">
           <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
               <img class="rounded-circle me-lg-2" src="assets/img/user.jpg" alt="" style="width: 40px; height: 40px;">
                <span class="d-none d-lg-inline-flex">John Doe</span>
            </a>
            <div class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
                <a href="<%= request.getContextPath() %>/perfil.jsp" class="dropdown-item">Meu Perfil</a>
                <a href="<%= request.getContextPath() %>/login?acao=logout" class="dropdown-item">Sair</a>
            </div>
        </div>
    </div>
</nav>