$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "posts/alex",
        contentType: "application/json",
        dataType: "json",
        success: function (resultData) {

            for (i = 0; i < resultData.length; i++) {
                resultData[i].recid = i;
            }

            createGrid(resultData)
        }
    });

    $('#callAddPostBtn').click(function (el) {
        $('#createPostPopup').w2popup();
    });

    $('#createPostBtn').click(function (el) {
        alert('Post is added!')
    });

    function createGrid(posts) {
        $('#posts').w2grid({
            name: 'grid',
            header: 'List of Names',
            columns: [
                {field: 'id', caption: 'ID', size: '30%'},
                {field: 'content', caption: 'Content', size: '30%'},
                {field: 'name', caption: 'Title', size: '40%'},
                {field: 'userName', caption: 'Author', size: '120px'},
                {field: 'pubDate', caption: 'Date', size: '120px'}
            ],
            records: posts
        });
    }
});


