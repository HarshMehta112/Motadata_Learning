<!DOCTYPE html>
<html>
<head>
    <title>jQuery Form Example</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css"/>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js" type="text/javascript"></script>

    <script src="ActionClass.js"></script>
</head>
<body>
<div class="col-sm-6 col-sm-offset-3">
    <h1>GENERIC AJAX FORM</h1>

    <form action="" method="POST">
        <div id="name-group" class="form-group">
            <label for="firstname">Name</label>
            <input
                    type="text"
                    class="form-control"
                    id="firstname"
                    name="name"
                    placeholder="Enter First Name"
            />
        </div>

        <div id="lastname-group" class="form-group">
            <label for="lastname">last name</label>
            <input
                    type="text"
                    class="form-control"
                    id="lastname"
                    name="lastname"
                    placeholder="Enter last name"
            />
        </div>

        <div id="age-group" class="form-group">
            <label for="age">age</label>
            <input
                    type="text"
                    class="form-control"
                    id="age"
                    name="age"
                    placeholder="Enter the age "
            />
        </div>

        <button type="submit" class="btn btn-success">
            Submit
        </button>

    </form>


    <table id="example" class="display" style="width:100%">
        <thead>
        <tr>
            <th>firstName</th>
            <th>lastName</th>
            <th>age</th>
        </tr>
        </thead>
    </table>



</div>
</body>
</html>