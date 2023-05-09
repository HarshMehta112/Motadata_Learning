$( document ).ready(function() {
    var inc = 1;
    //add empty 'tr' when no data available
    add_null_tr();

    $("#addbtn").on("click",function ()
    {
        $("#myModal").css('display','block');
    })

    $("#close").on("click",function ()
    {
        $("#myModal").css('display','none');
    })

    //add record
    $(document).on('click','#submit',function(){

        if($('#name').val()){

            var fn = $('#name').val();
            $('input').val('');		//empty input after getting value

            if($('#null_tr').length > 0)
            {
                $('#null_tr').remove();
            }

            $('table tbody').append('<tr class="animated fadeInUp" id='+inc+'><td class="name">'+fn+'</td><td><span id="edit_action" class="eaction" data-toggle="modal" data-target="#myModal">Edit</span><span id="del_action" class="daction">Delete</span></td></tr>');

            //show msg on record added
            $('#msg').show();

            $('#msg').text('added successfully.!');

            $('#msg').css('color','green');

            setTimeout(function(){ $('#msg').hide(); }, 2000);

            inc ++;
        }
        else
        {
            $('.modal-footer-error').show();

            setTimeout(function(){ $('.modal-footer-error').hide(); }, 1000);
        }
    });

    //edit record model and data
    $(document).on('click','#edit_action',function(){

        $("#myModal").css('display','block');

        var name = $(this).parent().parent('tr').find('.name').text();
        //get name
        var id = $(this).parent().parent('tr').attr('id');
        //get id of record
        $('#name').val(name);

        $('#hidden').val(id);

        $("#myModal .modal-footer .change-btn").attr("id", "update");
        //update btn id
        $("#myModal .modal-footer .change-btn").text('Update');		//update btn label
    });

    //edit record
    $(document).on('click','#update',function(){
        if($('#name').val())
        {
            var ufn = $('#name').val();
            //get name
            var uid = $('#hidden').val();					//get id

            $("#myModal").css('display','none');

            $('#'+uid+' td.name').text(ufn);				//paste new data to update id

            //show msg on record updated
            $('#msg').show();

            $('#msg').text('updated successfully.!');

            $('#msg').css('color','green');

            setTimeout(function(){ $('#msg').hide(); }, 2000);

            //remove recently added id and lable to default
            $('input').val('');

            $("#myModal .modal-footer .change-btn").attr("id", "submit");

            $("#myModal .modal-footer .change-btn").text('Submit');
        }
        else
        {
            $('.modal-footer-error').show();

            setTimeout(function(){ $('.modal-footer-error').hide(); }, 1000);
        }
    });

    //remove record
    $(document).on('click','#del_action',function()
    {
        var elmnt = $(this).parent().parent('tr');

        elmnt.removeClass('fadeInUp');

        elmnt.addClass('animated fadeOutDown');

        setTimeout(function()
        {
            $('.animated.fadeOutDown').remove();
            //add empty 'tr' when no data available
            add_null_tr();

        }, 700);

        //show msg on record removed
        $('#msg').show();

        $('#msg').text('removed successfully.!');

        $('#msg').css('color','red');

        setTimeout(function(){ $('#msg').hide(); }, 2000);
    });
});

function add_null_tr()
{
    if(($('table tbody tr').length == 0))
    {
        $('table tbody').append('<tr id="null_tr"><td colspan="2">No data available to show..!</td></tr>');
    }
}
