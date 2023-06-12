
$(function (){monitormain.onload()})

var bar;

var pie;

var monitormain = {

    onload: function ()
    {
        let request = {

            url: "LoadMonitorTable",

            data: "",

            callback: monitorcallback.onload,
        }
        genericAjaxCall.ajaxpost(request);
    },

    showstatistic: function (that)
    {
        let id = $(that).data("id");

        monitorhelper.showsshdata(id, type);
    },

    deletemonitor: function (event)
    {
        var a = $(event.target);

        var row = a.closest("tr")

        var id = row.find("td:nth-child(1)").text();

        console.log(id)

        let request = {

            url: "DeleteMonitorDevice",

            data: {id},

            success:toastr.success("discovery device deleted successfully")
        };
        genericAjaxCall.ajaxpost(request);
        monitormain.onload();
    },

};

var monitorhelper = {

    adddata: function (data)
    {
        $.each(JSON.parse(data), function (key,value)
        {
            table.row.add([value.DEVICEID,value.NAME, value.IPADDRESS, value.TYPE,value.STATUS,
                "<button onclick='monitormain.deletemonitor(event)' class='btn' style='margin-left: 5px'>Delete</button>" +
                "<button onclick='monitormain.showstatistic(this,ssh)' id='DeleteBtn'  class='btn' style='margin-left: 5px'>View</button>"]).draw();

        });
    },

    chartping: function (data)
    {
        monitorhelper.pie(data.pingStatistic.pie);

        baraData = {
            x: data.pingStatistic.barx,
            y: data.pingStatistic.bary,
            title: "Last 10 polling received packets",
            xlabel: "received packets",
            maxSize: 5,
            step: 4,
        };

        monitorhelper.bar(baraData);
    },

    chartssh: function (data)
    {
        monitorhelper.pie(data.sshStatistic.pie);

        baraData = {
            x: data.sshStatistic.barx,
            y: data.sshStatistic.bary,
            title: "Last 10 polling cpu usage",
            xlabel: "cpu",
            maxSize: 100,
            step: 10,
        };

        monitorhelper.bar(baraData);
    },

    showsshdata: function (id, type)
    {

        let sdata = {
            id: id, type: type
        };

        let request = {

            url: "PollingStatistic",

            data: sdata,

            callback: monitorcallback.showsshdata,
        }
        genericAjaxCall.ajaxpost(request);

        $("#myModalStatistic").show();
    },

    close: function ()
    {
        $("#myModalStatistic").hide();

        $("#matrix1").html("<h3>CPU Usage: Unknown</h3>");

        $("#matrix2").html("<h3>Memory Usage: Unknown</h3>");

        $("#matrix3").html("<h3>Disk Usage: Unknown</h3>");

        $("#matrix4").html("<h3>UpTime: Unknown</h3>");

    },

    pie: function (y)
    {
        let xValues = ["Up", "Down"];

        let yValues = y;

        let barColors = ["blue", "orange"];

        if (pie)
        {
            pie.destroy();
        }

        pie = new Chart("pie", {

            type: "doughnut",

            data: {
                labels: xValues, datasets: [{
                    backgroundColor: barColors, data: yValues
                }]
            },

            options: {
                title: {
                    display: true, text: "Availability"
                }
            }
        });
    },

    bar: function (data)
    {
        let xValues2 = data.x;

        let yValues2 = data.y;

        let barColors2 = ["orange", "orange", "orange", "orange", "orange", "orange", "orange", "orange", "orange", "orange"];

        if (bar)
        {
            bar.destroy();
        }

        bar = new Chart("bar", {

            type: "bar",

            data: {
                labels: xValues2, datasets: [{
                    backgroundColor: barColors2, data: yValues2
                }]
            },

            options: {

                legend: {display: false},

                title: {
                    display: true, text: data.title
                },

                scales: {
                    xAxes: [{
                        display: true, scaleLabel: {
                            display: true, labelString: 'Time'
                        },
                    }], yAxes: [{
                        display: true, scaleLabel: {
                            display: true, labelString: data.xlabel,
                        }, ticks: {
                            min: 0, max: data.maxSize, stepSize: data.step,
                        }
                    }]
                }
            }
        });
    },


};

var monitorcallback = {

    onload: function (data)
    {
        $("#monitors").dataTable().fnClearTable();
        table = $('#monitors').DataTable({lengthMenu: [10, 20, 50, 100, 200, 500],destroy:true,"bDestroy": true});

        monitorhelper.adddata(data);
    },

    deletemonitor: function (event)
    {
        var a = $(event.target);

        var row = a.closest("tr")

        var id = row.find("td:nth-child(1)").text();

        let request = {

            url: "Delete",

            data: {id},

            callback: monitorcallback.deletemonitor,

            success:toastr.success("discovery device deleted successfully")
        };
        genericAjaxCall.ajaxpost(request);
        monitormain.onload();
    },

    showsshdata: function (data)
    {
        monitorhelper.chartssh(data);

        $("#matrix1").html("<h3>CPU Usage: " + data.sshStatistic.matrix[0] + "%</h3>");

        $("#matrix2").html("<h3>Memory Usage: " + data.sshStatistic.matrix[1] + "%<br><br>Memory:" + data.sshStatistic.matrix[5] + "G</h3>");

        $("#matrix3").html("<h3>Disk Usage: " + data.sshStatistic.matrix[2] + "%<br><br>Disk:" + data.sshStatistic.matrix[4] + "</h3>");

        $("#matrix4").html("<h3>" + data.sshStatistic.matrix[3] + "</h3>");
    },
}
