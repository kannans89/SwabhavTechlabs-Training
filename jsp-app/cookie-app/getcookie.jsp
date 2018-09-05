<%
    Cookie[] cookie=null;
    String color = null;
    String name = null;
    cookie = request.getCookies();
    if(cookie[0]!=null){
        name = cookie[0].getName();
        color = cookie[0].getValue();
    } else{
        color = "red";
        out.println("<h1>No cookie found</h1>");
    }
    //out.println(color instanceof String);
%>

<html>
<head>
<style>
<%@include file="style.css" %>
</style>
</head>
    <body>
        <div>
            <% 
                if(color.equals("red")){
                    out.println("<h1 class=red>Background with red color</h1>");
                    
                } else{
                    out.println("<h1 class=green>Background with green color</h1>");
                }
                out.println("<h2>Max age is "+cookie[0].getMaxAge()+" sec</h2>");
            %>
        </div>
    </body>
</html>