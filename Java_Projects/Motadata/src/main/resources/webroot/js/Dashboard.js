$(function() {

    var eventBus = new EventBus('/login/eventbus');

    eventBus.onopen = function () {

        eventBus.registerHandler('updates.data', function (err, msg) {

            console.log(JSON.parse(msg))

            dashboardmain.updateData(msg)


        });
    }
})

var dashboardmain = {

    logout : function () {
        let request = {

            url: "logout",

        };
        genericAjaxCall.ajaxpost(request);
    },

    updateData : function (data)
    {
        var UpdatedData = JSON.parse(data);

        var x = document.getElementById('status')

        console.log(x)
    }

};