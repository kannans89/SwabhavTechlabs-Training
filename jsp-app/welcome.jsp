<%
    String student = request.getParameter("student");
    out.println();
    for(int i=0; i<5; i++){
        if(student!= null){
            out.println("<h1>Welcome to JSP, Hello "+student+"</h1>");
        }else{
            out.println("<h1>Welcome to JSP");
        }
       
    }
%>