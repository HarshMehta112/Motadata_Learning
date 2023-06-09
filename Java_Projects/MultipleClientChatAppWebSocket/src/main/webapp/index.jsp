<!DOCTYPE html>
<html>
<head>
    <title>WebSocket Chat</title>
</head>
<body>
<input type="text" id="recipient" placeholder="Recipient ID"><br>
<input type="text" id="message" placeholder="Message"><br>
<button onclick="sendMessage()">Send</button>
<br>
<div id="chat"></div>
<script>

    var socket = new WebSocket("ws://localhost:8080/chat");

    var chat = document.getElementById("chat");

    socket.onmessage = function (event) {
        chat.innerHTML += event.data + "<br>";
    }

    function sendMessage() {
        var recipient = document.getElementById("recipient").value;
        var message = document.getElementById("message").value;
        socket.send(recipient + ":" + message);
    }
</script>
</body>
</html>
