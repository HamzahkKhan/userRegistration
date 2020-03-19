<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
    </head>
    <body>

        <div class="container my-5">
            <h3>User Registration</h3>
            <div class="card">
                <div class="card-body">
                    <div class="col-md-10">
                        <form action="adduserServ" method="post">
                            <div class="row">
                                <div class="form-group col-md-8">
                                    <label for="name" class="col-form-label">User Name</label> 
                                    <input type="text" class="form-control" name="username" placeholder="User Name" />
                                </div>
                                <div class="form-group col-md-8">
                                    <label for="name" class="col-form-label">User Password</label> 
                                    <input type="password" class="form-control" 
                                           name="userpassword" placeholder="User Password" />
                                </div>
                                <div class="form-group col-md-8">
                                    <label for="email" class="col-form-label">Email</label> 
                                    <input type="text"  class="form-control" 
                                           name="useremail" placeholder="Email" />
                                </div>

                                <div class="col-md-6">
                                    <input type="submit" class="btn btn-primary" value=" Submit ">
                                </div>

                                <p id="Hide">${msg}</p>
                                <script>
                                    function showIt() {
                                        document.getElementById("Hide").style.visibility = "hidden";
                                    }
                                    setTimeout("showIt()", 1000);
                                </script>




                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
