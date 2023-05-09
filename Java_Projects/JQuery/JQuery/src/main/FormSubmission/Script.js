$(function ()
{
    $("#form").submit(function (event)
    {
        var name = $("#name").val();

       var password = $("#password").val();

       validateName(name,event);

       validatePassword(password,event);

    });

    function validatePassword(password,event)
    {
        if(!isValidPassword(password))
        {
            $("#password-feedback").text("please enter valid password");

            event.preventDefault();
        }
        else
        {
            $("#password-feedback").text("");
        }
    }

    function isValidPassword(password)
    {
        return password.length>=6;
    }


    function validateName(name,event)
    {
        if(!isValidName(name))
        {
            $("#name-feedback").text("please enter valid name");

            event.preventDefault();
        }
        else
        {
            $("#name-feedback").text("");
        }
    }

    function isValidName(name)
    {
        return name.length>2;
    }


});