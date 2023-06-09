<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WebSocket Chat App Trial</title>
</head>
<body>
<form>
    <input id="textMessage" type="text">
    <input onclick="sendMessage();" value="Send Message" type="button">
</form>
<br><textarea id="messagesTextArea" rows="50" cols="100"></textarea>
<script type="text/javascript">
    const webSocket = new WebSocket("ws://localhost:8080/Socket_Programming_WebSocket/endpoint");
    var messagesTextArea = document.getElementById("messagesTextArea");
    webSocket.onopen = function (message) {processOpen(message);};
    webSocket.onclose = function (message) {processClose(message);};
    webSocket.onerror = function (message) {processError(message);};
    webSocket.onmessage = function (message) {processMessage(message);};

    function processOpen(message) {
        messagesTextArea.value += "Server Connect..." + "\n";
    }

    function processClose(message) {
        webSocket.send("Client Disconnected...")
        messagesTextArea.value += "Server Disconect...." + "\n";
    }

    function processMessage(message){
        messagesTextArea.value += "Receive From Server ==> "+message.data+"\n";
    }

    function processError(message) {
        messagesTextArea.value += "Error ...\n";
    }

    function sendMessage(){

        if(textMessage.value!="close") {
            webSocket.onopen = ()=>webSocket.send(textMessage.value);
            messagesTextArea.value += "Send to Server ==> " + textMessage.value + "\n";
            textMessage.value = "";
        }
        else webSocket.close();
    }


</script>
</body>
</html>