<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<body>
<h1>Struts Login App Test</h1>


<s:form action="verify">
<s:textfield name="uname" label="Enter Username"/><br>
    <s:password name="password" label="Enter Password"/><br>
    <s:submit value="Login" align="center"/>
</s:form>

</body>
</html>