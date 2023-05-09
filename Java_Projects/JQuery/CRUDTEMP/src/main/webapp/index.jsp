<html>
<head>
    <meta charset="utf-8" />
    <title>Mini Project</title>
    <meta name="viewport" content="width=device-width">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type = "text/javascript" src="Script.js"></script>
    <link rel="stylesheet" href="style.css">
</head>

<body>
<!-- Button to trigger the modal -->
<button id="my-button">Add Data</button>

<!-- The modal itself -->
<div id="my-modal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <form id="my-form">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name"><br><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email"><br><br>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

</body>
</html>




