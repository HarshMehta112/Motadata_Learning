var discoveryhelper = {

    showssh: function ()
    {
        if ($("#updatetype").val() === "ssh")
        {
            $("#updatesshdivision").show();

        } else if ($("#type").val() === "ssh")
        {
            $("#sshdivision").show();

        } else
        {
            $("#sshdivision").hide();

            $("#updatesshdivision").hide();
        }
    }
}
$(document).ready(function(){

    // $('#user_table').DataTable({
    //     processing: true,
    //     serverSide: true,
    //     ajax: {
    //         url: "{{ route('sample.index') }}",
    //     },
    //     columns: [
    //         {
    //             data: 'first_name',
    //             name: 'first_name'
    //         },
    //         {
    //             data: 'last_name',
    //             name: 'last_name'
    //         },
    //         {
    //             data: 'action',
    //             name: 'action',
    //             orderable: false
    //         }
    //     ]
    // });
    //
    // $('#create_record').click(function(){
    //     $('.modal-title').text('Add New Record');
    //     $('#action_button').val('Add');
    //     $('#action').val('Add');
    //     $('#form_result').html('');
    //
    //     $('#formModal').modal('show');
    // });
    //
    // $('#sample_form').on('submit', function(event){
    //     event.preventDefault();
    //     var action_url = '';
    //
    //     if($('#action').val() == 'Add')
    //     {
    //         action_url = "{{ route('sample.store') }}";
    //     }
    //
    //     if($('#action').val() == 'Edit')
    //     {
    //         action_url = "{{ route('sample.update') }}";
    //     }
    //
    //     $.ajax({
    //         url: action_url,
    //         method:"POST",
    //         data:$(this).serialize(),
    //         dataType:"json",
    //         success:function(data)
    //         {
    //             var html = '';
    //             if(data.errors)
    //             {
    //                 html = '<div class="alert alert-danger">';
    //                 for(var count = 0; count < data.errors.length; count++)
    //                 {
    //                     html += '<p>' + data.errors[count] + '</p>';
    //                 }
    //                 html += '</div>';
    //             }
    //             if(data.success)
    //             {
    //                 html = '<div class="alert alert-success">' + data.success + '</div>';
    //                 $('#sample_form')[0].reset();
    //                 $('#user_table').DataTable().ajax.reload();
    //             }
    //             $('#form_result').html(html);
    //         }
    //     });
    // });
    //
    // $(document).on('click', '.edit', function(){
    //     var id = $(this).attr('id');
    //     $('#form_result').html('');
    //     $.ajax({
    //         url :"/sample/"+id+"/edit",
    //         dataType:"json",
    //         success:function(data)
    //         {
    //             $('#first_name').val(data.result.first_name);
    //             $('#last_name').val(data.result.last_name);
    //             $('#hidden_id').val(id);
    //             $('.modal-title').text('Edit Record');
    //             $('#action_button').val('Edit');
    //             $('#action').val('Edit');
    //             $('#formModal').modal('show');
    //         }
    //     })
    // });
    //
    // var user_id;
    //
    // $(document).on('click', '.delete', function(){
    //     user_id = $(this).attr('id');
    //     $('#confirmModal').modal('show');
    // });
    //
    // $('#ok_button').click(function(){
    //     $.ajax({
    //         url:"sample/destroy/"+user_id,
    //         beforeSend:function(){
    //             $('#ok_button').text('Deleting...');
    //         },
    //         success:function(data)
    //         {
    //             setTimeout(function(){
    //                 $('#confirmModal').modal('hide');
    //                 $('#user_table').DataTable().ajax.reload();
    //                 alert('Data Deleted');
    //             }, 2000);
    //         }
    //     })
    // });

});