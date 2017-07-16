$(document).ready(function () {
    reloadPosts();

    $('#callAddPostBtn').click(function (el) {
        $('#createPostPopup').w2popup();
    });

    $('#createPostBtn').click(function (el) {

        title = $('#postTitle').val();
        postContent = $('#postContent').val();

        post = {
            name: title,
            content: postContent
        };

        $.ajax({
            type: 'POST',
            url: "posts/post",
            async: false,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(post),
            success: function (resultData) {
                alert(resultData + ' Post is added!');
                reloadPosts();
                w2popup.close()
            }
        });

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

    function reloadPosts() {
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
    }
});


