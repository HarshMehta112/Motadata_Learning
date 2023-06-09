<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Ping Result</title>
    <script>
        var ws = new WebSocket("ws://localhost:8080/myapp/pingWebSocket");
        ws.onmessage = function(event) {
            document.getElementById("result").innerHTML = event.data;
        }
    </script>
</head>
<body>
<h1>Ping Result:</h1>
<div id="result"><s:property value="pingResult"/></div>
</body>
</html>
