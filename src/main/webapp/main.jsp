<%@ page import="com.google.appengine.api.modules.ModulesServiceFactory" %>
<%@ page import="test.Main" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MemTest</title>
</head>
<body>
<%
    int added = 0;
    String addCmd = request.getParameter("add");
    if (addCmd != null) {
        int add = Integer.valueOf(addCmd);
        Main.instance().add(1000 * add);
        added = 1000 * add;
    }

    String clearCmd = request.getParameter("clear");
    if (addCmd != null && "true".equals(clearCmd)) {
        Main.instance().clear();
    }
%>

Added = <%= added%>
<br/>
Instances = <%= Main.instance().list()%>
<br/>
Free memory = <%=(Runtime.getRuntime().freeMemory() / (1024 * 1024))%>M
<br/>
Instance = <%=ModulesServiceFactory.getModulesService().getCurrentModule()%>:
<%=ModulesServiceFactory.getModulesService().getCurrentVersion()%>:
<%=ModulesServiceFactory.getModulesService().getCurrentInstanceId()%>

<form action="/main.jsp" method="get">
    <div><input type="text" name="add" value="100"/></div>
    <div><input type="submit" value="Add"/></div>
</form>


<form action="/main.jsp" method="get">
    <div><input type="text" name="clear" value="true"/></div>
    <div><input type="submit" value="Clear"/></div>
</form>

</body>
</html>
