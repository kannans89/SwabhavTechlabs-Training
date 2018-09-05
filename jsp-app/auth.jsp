<%
    String name = request.getParameter("name");
    if(!name.equals("root")){
        response.sendRedirect("login.html");
    } else{
        out.println("<div>Name: "+request.getParameter("name"));
        out.println("<div>Password: "+request.getParameter("password"));
    }
    
%>