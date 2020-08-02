// 显示页码显示
function showPage(data) {
    var pageDetails = "";
    if(data.list.length == 0) { // 如果一条数据都没有，则不显示页码相关信息
        $(".thePage").hide();
    } else{ // 如果有俩页及以上数据
        $(".thePage").show();
        pageDetails += '<li id="previousPage">' +
            '<a href="###" aria-label="Previous" onclick="nextPage('+ data.prePage + ')">' +
            '<span aria-hidden="true">&laquo;</span>' +
            '</a>' +
            '</li>';
        if((data.prePage-1) > 0) {
            pageDetails += '<li><a href="###" onclick="nextPage('+ (data.prePage-1)+ ')">'+ (data.prePage-1) + '</a></li>';
        }
        if(data.prePage > 0) {
            pageDetails += '<li><a href="###" onclick="nextPage('+ data.prePage + ')">'+ data.prePage + '</a></li>';
        }
        pageDetails += '<li class="active"><a href="#">' + data.pageNum + '</a></li>';
        if(data.nextPage <= data.pages && data.nextPage > 0){
            pageDetails += '<li><a href="###" onclick="nextPage('+ data.nextPage + ')">' +data.nextPage+ '</a></li>';
            if((data.nextPage+1) <= data.pages && (data.nextPage+1) > 0){
                pageDetails += '<li><a href="###" onclick="nextPage('+ (data.nextPage+1) + ')">' + (data.nextPage+1) + '</a></li>';
            }
        }
        pageDetails += '<li id="nextPage">' +
            '<a href="###" aria-label="next" onclick="nextPage('+ data.nextPage + ')">' +
            '<span aria-hidden="true">&raquo;</span>' +
            '</a>' +
            '</li>';
    }
    $("#pageDetails").html(pageDetails);
}

// 优化页码的显示
function dealPage(data) {
    if(data.prePage == 0) {
        $("#previousPage").addClass("disabled"); // 使该控件当前不可点击
        $("#previousPage a").removeAttr("onclick");// 解除点击事件
    }
    if(data.nextPage == 0) {
        $("#nextPage").addClass("disabled");
        $("#nextPage a").removeAttr("onclick");// 解除点击事件
    }
}