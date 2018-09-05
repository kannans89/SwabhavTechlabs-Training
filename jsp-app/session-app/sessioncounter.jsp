<%
String counter = new String("counter");
Integer value = new Integer(0);
out.println(session.isNew());

    if(session.getAttribute(counter)== null){
        //session.invalidate();
        session.setAttribute(counter, value);   
        out.println("<h2>Old: 0"+"</h2>");
    } else{
    value = (Integer)session.getAttribute(counter); 
    out.println("<h2>Old: "+value+"</h2>");
    value = value+1;
    session.setAttribute(counter, value);
    out.println("<h2>Counter: "+value+"</h2>");
    }
    
    out.println("<h1>Session ID: "+session.getId()+"</h1>");
%>


