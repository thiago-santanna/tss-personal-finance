<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">
  <jsp:include page="components/head.jsp"></jsp:include>

  <body>
    <div class="container-fluid position-relative d-flex p-0">
      <!-- Spinner Start -->
      <div
        id="spinner"
        class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center"
      >
        <div
          class="spinner-border text-primary"
          style="width: 3rem; height: 3rem"
          role="status"
        >
          <span class="sr-only">Loading...</span>
        </div>
      </div>
      <!-- Spinner End -->

      <!-- Sign Up Start -->
      <div class="container-fluid">
        <div
          class="row h-100 align-items-center justify-content-center"
          style="min-height: 100vh"
        >
          <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
            <form method="post" action="<%= request.getContextPath()%>/signup" class="bg-secondary rounded p-4 p-sm-5 my-4 mx-3">
              <div
                class="d-flex align-items-center justify-content-between mb-3"
              >
                <a href="index.html" class="">
                  <h3 class="text-primary">
                    <i class="fa fa-user-edit me-2"></i>TSS Finance
                  </h3>
                </a>
<!--                 <h3>Sign Up</h3> -->
              </div>
              <div class="form-floating mb-3">
                <input
                  id="login"
                  name="login"
                  type="text"
                  class="form-control"
                  id="floatingText"
                  placeholder="jhondoe"
                />
                <label for="floatingText">Login</label>
              </div>
              <div class="form-floating mb-3">
                <input
                  id="email"
                  name="email"                
                  type="email"
                  class="form-control"
                  id="floatingInput"
                  placeholder="name@example.com"
                />
                <label for="floatingInput">E-mail</label>
              </div>
              <div class="form-floating mb-4">
                <input
                  id="password"
                  name="password"                
                  type="password"
                  class="form-control"
                  id="floatingPassword"
                  placeholder="Password"
                />
                <label for="floatingPassword">Senha</label>
              </div>
              
              <button type="submit" class="btn btn-primary py-3 w-100 mb-4">
                Cadastrar
              </button>
              <p class="text-center mb-0">
                Já possui uma conta? <a href="<%=request.getContextPath()%>/index.jsp">Sign In</a>
              </p>
            </form>
          </div>
        </div>
      </div>
      <!-- Sign Up End -->
    </div>

    <!-- JavaScript Libraries -->
	<jsp:include page="components/javascript.jsp"></jsp:include>
  </body>
</html>
