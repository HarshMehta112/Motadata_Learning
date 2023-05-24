$(document).ready(function() {
    // Retrieve session information if available
    // $.ajax({
    //     url: '/session',
    //     type: 'GET',
    //     success: function(response) {
    //         // Handle session retrieval success
    //         if (response.loggedIn) {
    //             // User is already logged in, redirect to the dashboard page
    //             window.location.href = '/dashboard';
    //         }
    //     },
    //     error: function(error) {
    //         // Handle session retrieval error
    //         console.log('Error retrieving session: ' + error.responseText);
    //     }
    // });



$('#login-form').submit(function(event) {
    event.preventDefault();
    var username = $('#login-form #username').val();
    var password = $('#login-form #password').val();

    console.log(username,password)

    // Send login request
    $.ajax({
        url: '/login',
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify({
            username: username,
            password: password
        }),
        success: function(response) {
            // Handle successful login
            // Redirect to a dashboard page or perform any other desired action

            console.log(response);
            if(response.key.toString()==="Valid user")
            {
                console.log("valid user");
                window.location.href = '/loginpage.html';
            }
            else
            {
                console.log("invalid user");
                window.location.href = "login.html";
            }
        },
        error: function(error) {

            // Handle login error
            console.log('Login failed: ' + error.responseText);
        }
    }).done((data)=> console.log("200",data)).fail((err)=>console.log("404",err));
});


// $('#signup-form').submit(function(event) {
//     event.preventDefault();
//     var username = $('#signup-form #signupusername').val();
//     var password = $('#signup-form #signuppassword').val();
//
//     // Send signup request
//     $.ajax({
//         url: '/signup',
//         type: 'POST',
//         data: {
//             username: username,
//             password: password
//         },
//         success: function(response) {
//             // Handle successful signup
//             // Redirect to a login page or perform any other desired action
//             window.location.href = '/login.html';
//         },
//         error: function(error) {
//             // Handle signup error
//             console.log('Signup failed: ' + error.responseText);
//         }
//     });
// });
});
