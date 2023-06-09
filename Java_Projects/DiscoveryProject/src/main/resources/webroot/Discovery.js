$(function () {
    load();
    initModal();
});

function create(title, url) {
    $.post("/api/articles", JSON.stringify({title: title, url: url}), function () {
        load();
    }, "json");
}

function remove(id) {
    $.ajax({
        method: "DELETE",
        url: "/api/articles/" + id
    }).done(function () {
        load();
    });
}

function update(id, title, url) {
    $.ajax({
        method: "PUT",
        url: "/api/articles/" + id,
        data:  JSON.stringify({title: title, url: url})
    }).done(function () {
        load();
    });
}

function load() {
    $("#content").children().remove();

    $.getJSON("/api/articles", function (data)
    {
        $.each(data, function (key, val) {
            $("<tr><td>" + val.id + "</td><td>" + val.title + "</td><td>" +
                "<a href='" + val.url + "'>" + val.url + "</a></td>" +
                "<td>" +
                "<button data-action='edit' class='btn btn-primary btn-sm product-edit' " +
                "data-toggle='modal' " +
                "data-target='#productModal' " +
                "data-title='" + val.title + "' " +
                "data-url='" + val.url + "' " +
                "data-id='" + val.id + "'>" +
                "<span class='glyphicon glyphicon-pencil'></span>" +
                "</button>" +
                "&nbsp;" +
                "<button class='btn btn-danger btn-sm product-delete' data-id='" + val.id + "'>" +
                "   <span class='glyphicon glyphicon-minus'></span>" +
                "</button>" +
                "</td>" +
                "</tr>").appendTo("#content");
        });
        initCallbacks();
    });
}

function initCallbacks() {
    $(".product-delete").click(function() {
        var id = $(this).data("id");

        remove(id);
    });
}

function initModal() {
    $("#productModal").on('show.bs.modal', function (event)
    {
        var button = $(event.relatedTarget);

        var action = button.data('action');

        var id = button.data('id');

        var productAction = $("#productAction");

        productAction.unbind();

        var modal = $(this);

        if (action === "add")
        {
            modal.find('.modal-title').text("Add an article");

            modal.find('#product-title').val("");

            modal.find('#product-url').val("");

            productAction.click(function ()
            {
                create($("#product-title").val(), $("#product-url").val());

                $('#productModal').modal('toggle');
            });
        }
        else
        {
            modal.find('.modal-title').text("Edit an article");

            modal.find('#product-title').val(button.data("title"));

            modal.find('#product-url').val(button.data("url"));

            productAction.click(function ()
            {
                update(id, $("#product-title").val(), $("#product-url").val());

                $('#productModal').modal('toggle');
            });
        }
    })
}