$(document).ready(getData())
$(function () {
    $("form").submit(function (event) {
        let formData = {
            firstname: $("#firstname").val(),
            lastname: $("#lastname").val(),
            age: $("#age").val(),
        };

        let ajaxData = {

            url: "submit",
            type: "POST",
            data: formData,
            dataType: 'json',
            callback: getData

        }

        ajaxCall(ajaxData);

        event.preventDefault();
    });



});

function ajaxCall (result){

    console.log("I am in ajaxCall")

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

    console.log('I am in update datatable')

    let data = $.parseJSON(result);

    $("#example").dataTable().fnDestroy(),

        $('#example').DataTable({
            data: data,
            columns: [
                { data: 'firstname' },
                { data: 'lastname' },
                { data: 'age' }
            ]
        });

}


function getData(){

    console.log('i am in getData');

    let ajaxData = {

        url: "select",
        type: "GET",
        dataType: 'json',
        callback: updateDatatable
    }

    ajaxCall(ajaxData);


}




