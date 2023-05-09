$(function ()
{
   $("#form").submit(function (event)
   {
       var textarea = $("#message")
       if(textarea.val().trim()=="")
       {
           textarea.css("box-shadow","0 0 4px #811");
           event.preventDefault();
       }
       else
       {
           //form is submitted
       }
   });
});