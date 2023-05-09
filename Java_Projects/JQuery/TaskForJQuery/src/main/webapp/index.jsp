<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form Submit</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

    <link rel="stylesheet" href="//cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
    <script type="text/javascript" src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <script src="ActionClass.js"></script>
    <link rel="shortcut icon" href="#">

</head>
<body>
    <form>
        <label>Enter the First Name</label><br>
        <input id="FirstName" type="text" placeholder="Enter the First name"><br><br>

        <label>Enter the last name</label><br>
        <input id="LastName" type="text" placeholder="Enter the last name"><br><br>

        <label>Enter the age</label><br>
        <input id="age" type="number" placeholder="Enter the age"><br><br>

        <button id="btn1" type="submit" class="btn btn-success">
            Submit
        </button>

        <button id="btn2">Get Details</button><br><br>
    </form>

    <p id="getDetails"></p>

    <table id="output" class="display" style="width:100%">
        <thead>
        <tr>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Age</th>
        </tr>
        </thead>
    </table>
</body>
</html>