$(document).ready(function ()
{
    $("#btn1").on("click",function (event)
    {
        var formData = {
            firstname: $("#FirstName").val(),
            lastname: $("#LastName").val(),
            age: $("#Age").val(),
        };
        // let ajaxData = {
        //
        //     url: "http://localhost:8080/InsertData",
        //     type: "POST",
        //     data: formData,
        //     dataType: 'json',
        //     callback: getData
        //
        // };
        //
        // ajaxCall(ajaxData);

        $.ajax(
            {
                url:'InsertData',
                type:"POST",
                data:formData,
                dataType:"json",
            }
        )

        event.preventDefault();

    });

});

function ajaxCall (result){

    $.ajax({
        type:result.type,
        url:result.url,
        data: result.data,
        dataType: result.dataType,
        success: function (data){
            console.log(data)
            if(result.hasOwnProperty('callback')){
                console.log(result.callback)
                result.callback(data);
            }
        }
    });

}

function updateDatatable(result){

    let data = $.parseJSON(result);

    $("#getDetails").dataTable().fnDestroy(),

        $('#example').DataTable({
            data: data,
            columns: [
                { data: 'FIRST' },
                { data: 'LAST' },
                { data: 'AGE' }
            ]
        });
}

function getData(){

    let ajaxData = {

        url: "http://localhost:8080/getTable",
        type: "GET",
        dataType: 'json',
        callback: updateDatatable
    }

    ajaxCall(ajaxData);


}
