$(function () {

    $(".red-box").fadeOut(2000);
    $(".green-box").fadeOut(2000);
    $(".red-box").fadeIn(1000);
    $(".red-box").fadeTo(1000,0.2)

    $(".red-box").fadeTo(5000,0.2);
    $(".green-box").fadeTo(3000,0.5);
    $(".blue-box").fadeTo(1000,0.8);

    $(".red-box").fadeToggle();
    $(".red-box").fadeToggle();

    $(".green-box").hide(1000);
    $(".green-box").toggle(1000);

    $(".green-box").slideUp(2000); // Show More or Read More Function
    $(".green-box").slideDown(2000);
    $("p").hide();
    $("p").slideDown(1000);

    $(".green-box").slideToggle();

    $(function () {
        $(".blue-box").animate({
                "margin-left":"300px"
            }, 1000, "swing"
        );
    })

    $(function(){
        $(".blue-box").animate({
            "margin-left":"200px",
            "opacity":"0",
            "height":"50px",
            "width":"50px"
        },1000)
    })

    $(function(){
        $(".blue-box").animate({
            marginLeft:"200px",
            opacity:"0",
            height:"50px",
            width:"50px"
        },1000)
    })

    /**
     * methods for callback function
     */

    $(function(){
        $(".blue-box").fadeTo(1000,0,function (){
            $(".green-box").fadeTo(1000,0,function ()
            {
                $(".red-box").fadeTo(1000,0);
            })
        })
    })

    /**
     * methods for traversal
     */

    $("#list").find("li").css("background-color","rgba(180,180,30,0.8)");

    $("#list").children("li").css("background-color","rgba(180,180,30,0.8)");
    $("#list").parents("div").css("background-color","rgba(180,180,30,0.8)");
    $("#list").parent().css("background-color","rgba(180,180,30,0.8)");
    $("#list").siblings(":header").css("background-color","rgba(180,180,30,0.8)");


    /**
     * Methods for filtering
     */

    $("li").filter(function (index){return index % 3===0;}).css("background-color","rgba(180,180,30,0.8)");

    $("li").first().css("background-color","rgba(180,180,30,0.8)");

    $("li").eq(1).css("background-color","rgba(180,180,30,0.8)");

    $("li").not(" :first").css("background-color","rgba(180,180,30,0.8)");

});