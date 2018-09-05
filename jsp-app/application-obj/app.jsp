<%
    Integer value = new Integer(0);
    String appCounter = new String("appcounter");

    Integer counter = (Integer) application.getAttribute(appCounter);
    if(counter != null){
        application.setAttribute(appCounter, value);
    }
    application.setAttribute(appCounter, counter+1);

    out.println(counter);
    
%>