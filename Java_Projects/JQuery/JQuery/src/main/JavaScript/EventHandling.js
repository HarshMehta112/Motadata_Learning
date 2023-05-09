$(function (){

    /**
     * click event handling
     */

    // $("#btn-click").click(function (event)
    // {
    //     console.log(event);
    //     alert("button was clicked by user");
    // });
    //
    // $(".red-box").click(function ()
    // {
    //    $(this).fadeTo(500,0.5);
    // });

    /**
     * mouse hover event handling
     */
    //
    // $("#btn-hover").hover(function ()
    // {
    //    alert("Hovered");                     //fires the two alert 1. hover on 2. hover out from the button
    // });
    //
    // $(".green-box").hover(function ()
    // {
    //     $(this).text("Hi all");
    // });


    // var blueBox = $(".blue-box");
    // blueBox.mouseenter(function ()
    // {
    //    $(this).stop().fadeTo(500,0.7);
    // });
    //
    // blueBox.mouseleave(function ()
    // {
    //    $(this).stop().fadeTo(500,1);
    // });
    //
    // blueBox.hover(function ()
    // {
    //    $(this).stop().fadeTo(500,0.7);
    // },
    //     function ()
    //     {
    //         $(this).stop().fadeTo(500,1);
    //     }
    // )

    // $("html").on("click keydown",function ()
    // {
    //     console.log("Hello");
    // });

    // var images = [
    //         "/home/harsh/Pictures/Screenshot from 2023-04-29 10-37-05.png",
    //         "/home/harsh/Pictures/Screenshot from 2023-04-29 20-23-54.png",
    //         "/home/harsh/Pictures/Screenshot from 2023-04-21 08-56-36.png"
    //     ];
    //
    // var i = 0;
    //
    // $(".galary").find("img").on("click",function () {
    //     i = (i + 1) % images.length;
    //     $(this).fadeOut(function () {
    //         $(this).attr("src", images[i]);
    //         $(this).fadeIn();
    //     });
    // });

    /**
     * Passing the additional data
     */

    // $("#btn-click").click(
    // {
    //     user:"Harsh"
    // },function (event)
    // {
    //     greetUser(event.data);
    // });
    //
    // function greetUser(userdata)
    // {
    //     username = userdata.user;
    //     alert("welcome back "+username+" !");
    // }

    /**
     * Focus and blur events
     */

    var inputFileds = $("input:text, input:password,textarea");
    inputFileds.focus(function ()
    {
        $(this).css("box-shadow","0 0 8px #666");
    });

    inputFileds.blur(function ()
    {
       $(this).css("box-shadow","none");
    });

});