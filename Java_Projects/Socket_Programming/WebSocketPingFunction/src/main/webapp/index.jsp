<html>
<head>
    <title>WebSocket Example</title>
</head>
<body>
<form>
    <label for="textMessage">Input</label>
    <input id="textMessage" type="text" name="Input">
    <label for="submit">Submit</label>
    <input id="submit" onclick="sendMessageToServer();" type="button" value="Submit">
</form>
<br>
<label for="showMessages">Connection Details</label>
<textarea id="showMessages" rows="10" cols="50"></textarea>
<script type="text/javascript">

    var websocket;
    function coonect()
    {
        if(window.location.protocol=='http:')
        {
            websocket = new WebSocket('ws://localhost:8080/chat')
        }
        else
        {
            websocket = new WebSocket('wss://localhost:8443/endpoint');
        }

        messageTextArea = document.getElementById("showMessages");
        textMessage = document.getElementById("textMessage");


        websocket.onopen = function (message) {processOnOpen(message);};
        websocket.onmessage = function (message) {processOnMessage(message)}
        websocket.onclose = function (message) {processOnClose(message);};
        websocket.onerror = function (message) {(message);};

        function processOnOpen(message){
            messageTextArea.value += "Server Connect... \n";
        }

        function processOnMessage(message)
        {
            messageTextArea.value += "Receive from Server => : "+message.data+"\n";
        }


        function processOnClose(message)
        {
            console.log(message);
            websocket.send("Client Disconnected.....");
            messageTextArea.value += "Server Disconnected....\n";
            setTimeout(function (){coonect()},1000);
        }
        function processOnError(message)
        {
            messageTextArea.value += "Error......";
            websocket.close();
        }

    }
    function sendMessageToServer()
    {
        if (textMessage.value!="close")
        {
            // websocket.setInterval(function () {websocket.send('hi')},1000);
            websocket.send(textMessage.value);
            messageTextArea.value += "Send to the Server => : "+textMessage.value+"\n";
            textMessage.value = "";
        }
        else websocket.close();
    }

    coonect();


</script>
</body>
</html>