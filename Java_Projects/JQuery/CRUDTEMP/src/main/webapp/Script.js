// When the user clicks on the button, open the modal
$('#my-button').click(function() {
    $('#my-modal').css('display', 'block');
});

// When the user clicks on <span> (x), close the modal
$('.close').click(function() {
    $('#my-modal').css('display', 'none');
});

// When the user submits the form, insert the data into the database
$('#my-form').submit(function(event) {
    event.preventDefault(); // Prevent the form from submitting normally

    // Get the form data and create an object to send to the server
    var formData = {
        'name': $('#name').val(),
        'email': $('#email').val()
    };

    // Send the data to the server using AJAX
    $.ajax({
        type: 'POST',
        url: 'insert_data.php',
        data: formData,
        dataType: 'json',
        encode: true
    })
        .done(function(data) {
            console.log(data); // Debugging purposes only
            alert('Data added successfully!');
            $('#my-form')[0].reset(); // Clear the form fields

        })
});