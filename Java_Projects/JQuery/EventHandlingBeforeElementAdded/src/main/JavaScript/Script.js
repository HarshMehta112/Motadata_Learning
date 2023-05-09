$(document).ready(function ()
{
    $('ul').on('click','li',function ()
    {
        $(this).fadeOut(500);
    });

    $('#btnAdd').on('click',function ()
    {
        var newItem = '<li>new Item Inserted</li>';

        $('ul').append(newItem);
    });
});