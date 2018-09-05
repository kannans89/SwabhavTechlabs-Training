<%
    if(session.isNew()){
        out.println("<h1>New Session, dont have any counters</h1>");
    } else{
        Object counter = session.getAttribute("counter");
        if(counter == null){
            out.println("<h1>Counter is "+0);
        }else{
        out.println("<h1>Counter is "+counter);

        }
        Object appcounter = application.getAttribute("appcounter");
        if(appcounter == null){
            out.println("<h1>Session Counter is "+0);
        }else{
        out.println("<h1>Application Counter is "+appcounter);

        }
    }
%>