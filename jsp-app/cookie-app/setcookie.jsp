<%
    Cookie cookie = new Cookie("color", "red");
    cookie.setMaxAge(60*60*24*7);
    response.addCookie(cookie);
    out.println("<h2>Max age is "+cookie.getMaxAge()+" sec</h2>");
%>

<html>
    <head></head>
    <body>
        <h1>Setting cookies</h1>
    </body>
</html>