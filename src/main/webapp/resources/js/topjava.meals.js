const mealAjaxUrl = "ajax/profile/meals/";

function updateFilteredTable() {
    $.ajax({
        type: "GET",
        url: mealAjaxUrl + "filter",
        data: $("#filter").serialize()
    }).done(updateTableByData);
}

function clearFilter() {
    $("#filter")[0].reset();
    $.get(mealAjaxUrl, updateTableByData);
}

$(function () {
    makeEditable({
        ajaxUrl: mealAjaxUrl,
        datatableApi: $("#datatable").DataTable({
            "ajax": {
                "url": mealAjaxUrl,
                "dataSrc": ""
            },
            "paging": false,
            "info": true,
            "columns": [
                {
                    "data": "dateTime",
                    "render": function (data, type, row) {
                        return data.replace("T", " ").substr(0, 16);
                    }
                },
                {
                    "data": "description"
                },
                {
                    "data": "calories"
                },
                {
                    "orderable": false,
                    "defaultContent": "",
                    "render": renderEditBtn
                },
                {
                    "orderable": false,
                    "defaultContent": "",
                    "render": renderDeleteBtn
                }
            ],
            "order": [
                [
                    0,
                    "desc"
                ]
            ],
            "createdRow": function (row, data, dataIndex) {
                $(row).attr("data-mealExcess", data.excess);
            }
        }),
        updateTable: function () {
            $.get(mealAjaxUrl, updateFilteredTable);
        }
    });
});

$.datetimepicker.setLocale('ru');

$("#startDate").datetimepicker({
    format: 'Y-m-d',
    onShow:function( ct ) {
        this.setOptions({
            maxDate:$('#endTime').val()?$('#endDate').val():false
        })
    },
    timepicker: false
});

$("#endDate").datetimepicker({
    format: 'Y-m-d',
    onShow:function( ct ) {
        this.setOptions({
            minDate:$('#startDate').val()?$('#startDate').val():false
        })
    },
    timepicker: false
});

$("#startTime").datetimepicker({
    datepicker: false,
    format: 'H:i'
});

$("#endTime").datetimepicker({
    datepicker: false,
    format: 'H:i'
});

$("#dateTime").datetimepicker({
    format: 'Y-m-d H:i'
});