$(function ()
{
    // $("ul ul:first").append("<li> Hello all");
    // $("<li> Good Morning All!</li>").appendTo($("ul ul:first"));
    //
    // $("ul ul").prepend("<li> Hello all </li>"); // append to all sublist
    //
    // $("<h4>Hi all I am Harsh Mehta</h4>").prependTo("#content")
    //
    // $(".red-box").after("<div class ='red-box'>Another red Box</div>") //sibling element
    //
    // $(".green-box").before("<div class='green-box'>Another greeen box</div>")
    //
    // $(".blue-box").before($(".red-box"));
    //
    // $("p").after("#list");  // it will clone the list and move it
    //
    // /**
    //  * replace the elements
    //  */
    //
    // $("li").replaceWith("<li> Replaced with Harsh </li>");
    //
    // $(".green-box,.blue-box").replaceWith("<div class='blue-box'>ANother box</div>")
    //
    // /**
    //  * Remove the elements
    //  */
    //
    // $("li").remove();
    //
    // $("form").children().not("input: br").remove();
    //
    // var detchList = $("li").detach();
    //
    // $("#content").append(detchList);
    //
    // $("p:first").empty();
    //
    // $(".red-box,.blue-box,.green-box").empty();

    /**
     * manipulating the attributes and properties
     */

    var specialLink = $("#special-link");

    console.log(specialLink.attr("href"));

    specialLink.attr("href","https://www.google.com"); // we can set the attribute too

    var textInput = $("input:text");

    textInput.val("Harsh Mehta");

    console.log(textInput)

    $("a").addClass("fancy-link");
    $("p:first").addClass("large emphasize");


})