function getElement(id) {
    let td;

    $(".data-table > tbody > tr").each(function (index, value) {
        td = $(this);

        if(id !=="" &&$(this).find('#data_id').html() >= id ){
            return false;
        }
    });
    return td;
}

$(function ()
{
    let id = 1;
    $("form").submit(function(event)
    {
        event.preventDefault();

        var name=$("input[name='name']").val();

        var Id=$("input[name='id']").val();

        let td;
        if((td = getElement(Id))){
            td.after("<tr data-name='"+id+"'>" +
                "<td id='data_id'>"+(id++)+"</td>" +
                "<td id='data_name'>"+name+"</td><td>" +
                "<button class='btn btn-delete' type='button'>Delete</button>" +
                "<button class='btn btn-edit' type='button'>Edit</button>" +
                "</td>" +
                "</tr>")
        }else{
            $(".data-table tbody").append("<tr data-name='"+id+"'>" +
                "<td id='data_id'>"+(id++)+"</td>" +
                "<td id='data_name'>"+name+"</td><td>" +
                "<button class='btn btn-delete' type='button'>Delete</button>" +
                "<button class='btn btn-edit' type='button'>Edit</button>" +
                "</td>" +
                "</tr>");
        }
        $(this).find("input[name='name']").val("");
        $(this).find("input[name='id']").val("");

    });

    $('body').on('click','.btn-delete',function()
    {
        $(this).parents('tr').remove();
    });

    $('body').on('click','.btn-edit',function()
    {
        var name=$(this).parents('tr').find('#data_name').html();

        var Id=$(this).closest('tr').find('#data_id').html();


        $(this).parents('tr').find('td:eq(1)').html("<input name='name' value='"+name+"'>");

        $(this).parents('tr').find('td:eq(0)').html("<input name='id' value='"+Id+"'>");

        $(this).parents('tr').find('td:eq(2)').prepend("<button type='button' class='btn btn-update'>Update</button>");

        $(this).hide()
    });

    $('body').on('click','.btn-update',function()
    {
        var name = $(this).parents('tr').find("input[name='name']").val();

        var Id = $(this).parents('tr').find("input[name='id']").val();

        $(this).parents('tr').find('#data_name').text(name);

        $(this).parents('tr').find('#data_id').text(Id);

        $(this).parents('tr').attr('data_name', name);

        $(this).parents('tr').find('.btn-edit').show();

        $(this).parents('tr').find('.btn-update').remove();
    });

    });