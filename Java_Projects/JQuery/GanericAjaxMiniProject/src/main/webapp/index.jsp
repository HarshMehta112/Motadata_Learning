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
<div id="wrap_project" class="container">
    <div>
        <button type="button" id="addbtn">Add</button>
    </div>
    <div id="table">
        <table class="table table-striped" style="border-collapse:collapse">
            <thead border="1" style="border-collapse:collapse">
            <tr border="1" style="border-collapse:collapse">
                <th>Name</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody></tbody>
        </table>
        <span id="msg"></span>
    </div>
</div>

<!-- Start Modal -->
<div id="myModal" class="modal fade" role="dialog" style="display: none;">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close">&times;</button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" required >
                </div>
                <input type="hidden" id="hidden">
            </div>
            <div class="modal-footer">
                <span class="modal-footer-error" style="display: none;">No data to submit..!!</span>
                <button type="button" class="btn btn-primary change-btn" id="submit">Submit</button>
                <button type="button" class="btn btn-danger" id="close">Close</button>
            </div>
        </div>

    </div>
</div>
<!-- End Modal -->
</body>
</html>