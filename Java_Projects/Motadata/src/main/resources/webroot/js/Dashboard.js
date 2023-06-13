$(function() {

    var eventBus = new EventBus('/login/eventbus');

    eventBus.onopen = function () {

        eventBus.registerHandler('updates.data', function (err, msg) {

            console.log(JSON.stringify(msg));

            // updateDatatable(JSON.stringify(msg));

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
};