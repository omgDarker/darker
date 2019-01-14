// 初始化选项卡切换
$(function () {
    // 菜单列表点击事件
    $(".meun-item").click(function () {
        // 移除上一个菜单激活样式
        $(".meun-item").removeClass("meun-item-active");
        // 新增选中菜单激活样式
        $(this).addClass("meun-item-active");
    });
    // 选项卡激活后的点击事件
    $('div[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        // 判断是哪个选项卡
        var controls = $(this).attr('aria-controls');

        if ('classify' === controls) {
            // ajax请求获取用户最大页数
            $.ajax({
                //请求URL地址,controller的名称
                url: "/classifys/page",
                //请求返回数据格式为json,还可以是text等
                dataType: "JSON",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {
                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 调用分页
                    classifyPagination(data.classifyMaxPage);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if ('column' === controls) {
            // ajax请求获取用户最大页数
            $.ajax({
                //请求URL地址,controller的名称
                url: "/columns/page",
                //请求返回数据格式为json,还可以是text等
                dataType: "JSON",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 调用分页
                    columnPagination(data.columnMaxPage);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if ('trash' === controls) {
            // ajax请求获取用户最大页数
            $.ajax({
                //请求URL地址,controller的名称
                url: "/trashs/page",
                //请求返回数据格式为json,还可以是text等
                dataType: "JSON",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 调用分页
                    trashPagination(data.trashMaxPage);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if ('user' === controls) {
            // ajax请求获取用户最大页数
            $.ajax({
                //请求URL地址,controller的名称
                url: "/users/page",
                //请求返回数据格式为json,还可以是text等
                dataType: "JSON",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 调用分页
                    userPagination(data.userMaxPage);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if ('role' === controls) {
            // ajax请求获取用户最大页数
            $.ajax({
                //请求URL地址,controller的名称
                url: "/roles/page",
                //请求返回数据格式为json,还可以是text等
                dataType: "JSON",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 调用分页
                    rolePagination(data.roleMaxPage);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if ('permission' === controls) {
            // ajax请求获取用户最大页数
            $.ajax({
                //请求URL地址,controller的名称
                url: "/permissions/page",
                //请求返回数据格式为json,还可以是text等
                dataType: "JSON",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 调用分页
                    permissionPagination(data.permissionMaxPage);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if ('article' === controls) {
            // ajax请求获取用户最大页数
            $.ajax({
                //请求URL地址,controller的名称
                url: "/articles/page",
                //请求返回数据格式为json,还可以是text等
                dataType: "JSON",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 调用分页
                    articlePagination(data.articleMaxPage);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if ('image' === controls) {
            // ajax请求获取用户最大页数
            $.ajax({
                //请求URL地址,controller的名称
                url: "/images/page",
                //请求返回数据格式为json,还可以是text等
                dataType: "JSON",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 调用分页
                    imagePagination(data.imageMaxPage);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if ('link' === controls) {
            // ajax请求获取用户最大页数
            $.ajax({
                //请求URL地址,controller的名称
                url: "/links/page",
                //请求返回数据格式为json,还可以是text等
                dataType: "JSON",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 调用分页
                    linkPagination(data.linkMaxPage);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if ('message' === controls) {
            // ajax请求获取用户最大页数
            $.ajax({
                //请求URL地址,controller的名称
                url: "/messages/page",
                //请求返回数据格式为json,还可以是text等
                dataType: "JSON",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 调用分页
                    messagePagination(data.messageMaxPage);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if ('statistics' === controls) {
            $.ajax({
                //请求URL地址,controller的名称
                url: "/operation/statistics",
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    $("#countWebPV").text(data.countWebPV);
                    $("#countWebVV").text(data.countWebVV);
                    $("#countWebUV").text(data.countWebUV);
                    $("#countLink").text(data.countLink);
                    $("#countMessage").text(data.countMessage);
                    $("#countArticle").text(data.countArticle);
                    $("#countimage").text(data.countimage);
                    $("#countLike").text(data.countLike);
                    $("#countLikeNo").text(data.countLikeNo);
                    // 统计图
                    statisticsVChart(data);
                    statisticsCChart(data);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if ('table' === controls) {
            // ajax请求获取用户最大页数
            $.ajax({
                //请求URL地址,controller的名称
                url: "/dbms/tables",
                //请求返回数据格式为json,还可以是text等
                dataType: "JSON",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    console.info(JSON.stringify(data));
                    var html = '';
                    for (var tableName in data) {
                        html += '<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">';
                        html += '<div class="info-box facebook-bg" style="width:350px;height:400px;border:0 solid;border-radius:15px;">';
                        html += '<i class="fa fa-table" ></i>';
                        html += '<i class="title">' + tableName + '</i>';
                        // 表信息
                        var column = data[tableName];
                        html += '<div style="margin-left:10px;display:inline-block;">';
                        for (var columnName in column) {
                            html += '<div class="title">' + columnName + '(' + column[columnName] + ')' + '<br></div>';
                        }
                        html += '</div></div></div>';
                    }
                    $("#dbmsTable").html(html);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        }
    });
    // 资源管理选项卡
    // 总页数
    var maxPage = parseInt($("#maxPage").val());
    // 分页操作
    $.jqPaginator('#pagination', {
        totalPages: maxPage, // 总页数
        visiblePages: 10, // 显示的页码数量
        currentPage: 1, // 当前页
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        next: '<li class=""><a href="javascript:;">下一页</a></li>',
        last: '<li class="last"><a href="javascript:;">尾页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            // num->当前页
            $.ajax({
                //请求URL地址,controller的名称
                url: "/resources",
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {'pageNum': num},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 组装HTML页面
                    parseHtmlContent(data);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        }
    });
});

/**
 * 查询分类列表
 * @param id 回显ID
 */
function queryClassifyList(id) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/classifys",
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {

        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            var html = '';

            for (var i in data) {
                html += '<option value="' + data[i].id + '" name="classifyId">' + data[i].name + '</option>';
            }
            $("#" + id).html(html);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

/**
 * 查询分类对应栏目列表
 * @param id 回显ID
 * @param classifyId 分类ID
 */
function queryColumnList(id, classifyId) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/columns/" + classifyId,
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {

        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            var html = '';

            for (var i in data) {
                html += '<option value="' + data[i].id + '" name="columnId">' + data[i].name + '</option>';
            }
            $("#" + id).html(html);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

/*************************************************** 资源列表相关操作***************************************************/

// 查询数据填充至HTML
function parseHtmlContent(data) {

    var htmlContent = "";

    for (var i in data) {
        htmlContent += '<div class="row" >';
        htmlContent += '<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += '<span>' + data[i].id + '</span>';
        htmlContent += '</div>';
        htmlContent += '<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">';
        htmlContent += '<span>' + data[i].name + '</span>';
        htmlContent += '</div>';
        htmlContent += '<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">';
        htmlContent += '<span>' + data[i].path + '</span>';
        htmlContent += '</div>';
        htmlContent += '<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += '<button class="btn btn-success" data-toggle="modal" data-target="#updateResource" onclick="javascript:queryResource(\'' + data[i].id + '\');">修改</button>&nbsp;';
        htmlContent += '<button class="btn btn-danger" data-toggle="modal" onclick="javascript:deleteResource(\'' + data[i].id + '\');">删除</button>';
        htmlContent += '</div>';
        htmlContent += '</div>';
    }
    $("#tablebody").html(htmlContent);
}

// 新增操作
function addResource() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/resources",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#resourceAddForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "POST",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#addResource").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            setTimeout(function () {
                swal(data.msg, '', "success");
            }, 100);
            //2秒后刷新页面，足够显示swal()的信息
            setTimeout(function () {
                window.location.reload();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 查询资源实体
function queryResource(id) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/resources/" + id,
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 返回实体类
            $("#id").val(data.id);
            $("#name").val(data.name);
            $("#path").val(data.path);
            $("#parentName").val(data.parentName);
            // 资源选项
            if (data.classify === 'admin') {
                $("#admin").attr("checked", "checked");
            } else if (data.classify === 'index') {
                $("#index").attr("checked", "checked");
            }
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 更新操作
function updateResource() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/resources",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#resourceUpdateForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "PUT",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#updateResource").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            setTimeout(function () {
                swal(data.msg, '', "success");
            }, 100);
            //2秒后刷新页面，足够显示swal()的信息
            setTimeout(function () {
                window.location.reload();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 删除操作
function deleteResource(id) {
    swal({
        title: '确定删除吗?',  //弹出框的title
        text: '你将无法恢复它!', //弹出框里面的提示文本
        type: 'warning', //弹出框类型
        showCancelButton: true, //是否显示取消按钮
        confirmButtonColor: '#3085d6', //确定按钮颜色
        cancelButtonColor: '#d33', //取消按钮颜色
        confirmButtonText: '确定删除', //确认按钮文本
        cancelButtonText: '取消删除', //取消按钮文本
        confirmButtonClass: 'btn btn-success', //确认按钮样式
        cancelButtonClass: 'btn btn-danger', //取消按钮样式
        buttonsStyling: false //禁止使用默认按钮样式
    }).then(function (isConfirm) {

        if (isConfirm.value === true) {
            $.ajax({
                //请求URL地址,controller的名称
                url: "/resources/" + id,
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "DELETE",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {
                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    setTimeout(function () {
                        swal(data.msg, '', "success");
                    }, 100);
                    //2秒后刷新页面，足够显示swal()的信息
                    setTimeout(function () {
                        window.location.reload();
                    }, 2000);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if (isConfirm.dismiss === 'cancel') {
            // dismiss的值可以是'cancel', 'overlay','close', 'timer'
            swal(
                '已取消',
                '',
                'error'
            );
        } else {
            swal(
                '已关闭',
                '',
                'error'
            );
        }
    });
}

/*************************************************** 分类列表相关操作***************************************************/

// 分页操作
function classifyPagination(classifyMaxPage) {
    $.jqPaginator('#classifyPagination', {
        totalPages: classifyMaxPage, // 总页数
        visiblePages: 10, // 显示的页码数量
        currentPage: 1, // 当前页
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        next: '<li class=""><a href="javascript:;">下一页</a></li>',
        last: '<li class="last"><a href="javascript:;">尾页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            // num->当前页
            $.ajax({
                //请求URL地址,controller的名称
                url: "/classifys",
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {'pageNum': num},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 组装HTML页面
                    parseClassifyHtmlContent(data);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        }
    });
}

// 查询数据填充至HTML
function parseClassifyHtmlContent(data) {

    var htmlContent = "";

    for (var i in data) {
        htmlContent += '<div class="row" >';
        htmlContent += '<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += '<span>' + data[i].id + '</span>';
        htmlContent += '</div>';
        htmlContent += '<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">';
        htmlContent += '<span>' + data[i].name + '</span>';
        htmlContent += '</div>';
        htmlContent += '<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">';
        htmlContent += '<span>' + data[i].description + '</span>';
        htmlContent += '</div>';
        htmlContent += '<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += '<button class="btn btn-success" data-toggle="modal" data-target="#updateClassify" onclick="javascript:queryClassify(\'' + data[i].id + '\');">修改</button>&nbsp;';
        htmlContent += '<button class="btn btn-danger" data-toggle="modal" onclick="javascript:deleteClassify(\'' + data[i].id + '\');">删除</button>';
        htmlContent += '</div>';
        htmlContent += '</div>';
    }
    $("#classifyTablebody").html(htmlContent);
}

// 新增操作
function addClassify() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/classifys",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#classifyAddForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "POST",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#addClassify").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='classify']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 查询资源实体
function queryClassify(id) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/classifys/" + id,
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 返回实体类
            $("#classifyId").val(data.id);
            $("#classifyName").val(data.name);
            $("#classifyDescription").val(data.description);
            // 资源选项
            if (data.isDelete === 0) {
                $("#classifyNormal").attr("checked", "checked");
            } else if (data.isDelete === 1) {
                $("#classifyForbidden").attr("checked", "checked");
            }
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 更新操作
function updateClassify() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/classifys",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#classifyUpdateForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "PUT",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#updateClassify").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='classify']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 删除操作
function deleteClassify(id) {
    swal({
        title: '确定删除吗?',  //弹出框的title
        text: '你将无法恢复它!', //弹出框里面的提示文本
        type: 'warning', //弹出框类型
        showCancelButton: true, //是否显示取消按钮
        confirmButtonColor: '#3085d6', //确定按钮颜色
        cancelButtonColor: '#d33', //取消按钮颜色
        confirmButtonText: '确定删除', //确认按钮文本
        cancelButtonText: '取消删除', //取消按钮文本
        confirmButtonClass: 'btn btn-success', //确认按钮样式
        cancelButtonClass: 'btn btn-danger', //取消按钮样式
        buttonsStyling: false //禁止使用默认按钮样式
    }).then(function (isConfirm) {

        if (isConfirm.value === true) {
            $.ajax({
                //请求URL地址,controller的名称
                url: "/classifys/" + id,
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "DELETE",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {
                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 弹窗提示信息
                    swal(data.msg, '', "success");
                    setTimeout(function () {
                        // 自动关闭弹窗
                        swal.close();
                        // 点击响应tab刷新页面
                        $("div[aria-controls='classify']").click();
                    }, 2000);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if (isConfirm.dismiss === 'cancel') {
            // dismiss的值可以是'cancel', 'overlay','close', 'timer'
            swal(
                '已取消',
                '',
                'error'
            );
        } else {
            swal(
                '已关闭',
                '',
                'error'
            );
        }
    });
}

/*************************************************** 栏目列表相关操作***************************************************/

// 分页操作
function columnPagination(columnMaxPage) {
    $.jqPaginator('#columnPagination', {
        totalPages: columnMaxPage, // 总页数
        visiblePages: 10, // 显示的页码数量
        currentPage: 1, // 当前页
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        next: '<li class=""><a href="javascript:;">下一页</a></li>',
        last: '<li class="last"><a href="javascript:;">尾页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            // num->当前页
            $.ajax({
                //请求URL地址,controller的名称
                url: "/columns",
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {'pageNum': num},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 组装HTML页面
                    parseColumnHtmlContent(data);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        }
    });
}

// 查询数据填充至HTML
function parseColumnHtmlContent(data) {

    var htmlContent = "";

    for (var i in data) {
        htmlContent += ' <div class="row" >';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + data[i].id + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">';
        htmlContent += ' <span>' + data[i].name + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">';
        htmlContent += ' <span>' + data[i].description + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <button class="btn btn-success" data-toggle="modal" data-target="#updateColumn" onclick="javascript:queryColumn(\'' + data[i].id + '\');">修改</button>';
        htmlContent += ' <button class="btn btn-danger" data-toggle="modal" onclick="javascript:deleteColumn(\'' + data[i].id + '\');">删除</button>';
        htmlContent += ' </div>';
        htmlContent += ' </div>';
    }
    $("#columnTablebody").html(htmlContent);
    // 查询所有分类
    queryAllClassify('addClassifyId');
}

// 新增操作
function addColumn() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/columns",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#columnAddForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "POST",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#addColumn").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='column']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 查询资源实体
function queryColumn(id) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/columns/" + id,
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 返回实体类
            $("#columnId").val(data.id);
            $("#columnName").val(data.name);
            $("#columnDescription").val(data.description);
            // 资源选项
            if (data.isDelete === 0) {
                $("#columnNormal").attr("checked", "checked");
            } else if (data.isDelete === 1) {
                $("#columnForbidden").attr("checked", "checked");
            }
            // 查询所有分类
            queryAllClassify("updateClassifyId");
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 更新操作
function updateColumn() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/columns",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#columnUpdateForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "PUT",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#updateColumn").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='column']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 查询所有分类
function queryAllClassify(id) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/classifys",
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {

        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            var html = '';

            for (var i in data) {
                html += '<option value="' + data[i].id + '" name="classifyId">' + data[i].name + '</option>';
            }
            $("#" + id).html(html);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 删除操作
function deleteColumn(id) {
    swal({
        title: '确定删除吗?',  //弹出框的title
        text: '你将无法恢复它!', //弹出框里面的提示文本
        type: 'warning', //弹出框类型
        showCancelButton: true, //是否显示取消按钮
        confirmButtonColor: '#3085d6', //确定按钮颜色
        cancelButtonColor: '#d33', //取消按钮颜色
        confirmButtonText: '确定删除', //确认按钮文本
        cancelButtonText: '取消删除', //取消按钮文本
        confirmButtonClass: 'btn btn-success', //确认按钮样式
        cancelButtonClass: 'btn btn-danger', //取消按钮样式
        buttonsStyling: false //禁止使用默认按钮样式
    }).then(function (isConfirm) {

        if (isConfirm.value === true) {
            $.ajax({
                //请求URL地址,controller的名称
                url: "/columns/" + id,
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "DELETE",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {
                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 弹窗提示信息
                    swal(data.msg, '', "success");
                    setTimeout(function () {
                        // 自动关闭弹窗
                        swal.close();
                        // 点击响应tab刷新页面
                        $("div[aria-controls='column']").click();
                    }, 2000);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if (isConfirm.dismiss === 'cancel') {
            // dismiss的值可以是'cancel', 'overlay','close', 'timer'
            swal(
                '已取消',
                '',
                'error'
            );
        } else {
            swal(
                '已关闭',
                '',
                'error'
            );
        }
    });
}

/*************************************************** 回收站相关操作***************************************************/
// 分页操作
function trashPagination(trashMaxPage) {
    $.jqPaginator('#trashPagination', {
        totalPages: trashMaxPage, // 总页数
        visiblePages: 10, // 显示的页码数量
        currentPage: 1, // 当前页
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        next: '<li class=""><a href="javascript:;">下一页</a></li>',
        last: '<li class="last"><a href="javascript:;">尾页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            // num->当前页
            $.ajax({
                //请求URL地址,controller的名称
                url: "/trashs",
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {'pageNum': num},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 组装HTML页面
                    parseTrashHtmlContent(data);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        }
    });
}

// 查询数据填充至HTML
function parseTrashHtmlContent(data) {

    var htmlContent = "";

    for (var i in data) {
        htmlContent += ' <div class="row" >';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + data[i].id + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">';
        htmlContent += ' <span>' + data[i].description + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">';
        htmlContent += ' <span>' + data[i].classify + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <button class="btn btn-danger" data-toggle="modal" onclick="javascript:deleteTrash(\'' + data[i].id + '\');">清楚记录</button>';
        htmlContent += ' </div>';
        htmlContent += ' </div>';
    }
    $("#trashTablebody").html(htmlContent);
}

// 删除操作
function deleteTrash(id) {
    swal({
        title: '确定删除吗?',  //弹出框的title
        text: '你将无法恢复它!', //弹出框里面的提示文本
        type: 'warning', //弹出框类型
        showCancelButton: true, //是否显示取消按钮
        confirmButtonColor: '#3085d6', //确定按钮颜色
        cancelButtonColor: '#d33', //取消按钮颜色
        confirmButtonText: '确定删除', //确认按钮文本
        cancelButtonText: '取消删除', //取消按钮文本
        confirmButtonClass: 'btn btn-success', //确认按钮样式
        cancelButtonClass: 'btn btn-danger', //取消按钮样式
        buttonsStyling: false //禁止使用默认按钮样式
    }).then(function (isConfirm) {

        if (isConfirm.value === true) {
            $.ajax({
                //请求URL地址,controller的名称
                url: "/trashs/" + id,
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "DELETE",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {
                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 弹窗提示信息
                    swal(data.msg, '', "success");
                    setTimeout(function () {
                        // 自动关闭弹窗
                        swal.close();
                        // 点击响应tab刷新页面
                        $("div[aria-controls='trash']").click();
                    }, 2000);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if (isConfirm.dismiss === 'cancel') {
            // dismiss的值可以是'cancel', 'overlay','close', 'timer'
            swal(
                '已取消',
                '',
                'error'
            );
        } else {
            swal(
                '已关闭',
                '',
                'error'
            );
        }
    });
}

// 搜索操作
function searchTrashContent() {
    // 检索词
    var key = $("#trashContent").val();
    // out
    console.info("检索词:" + key);
}

/*************************************************** 用户列表相关操作***************************************************/
// 分页操作
function userPagination(userMaxPage) {
    $.jqPaginator('#userPagination', {
        totalPages: userMaxPage, // 总页数
        visiblePages: 10, // 显示的页码数量
        currentPage: 1, // 当前页
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        next: '<li class=""><a href="javascript:;">下一页</a></li>',
        last: '<li class="last"><a href="javascript:;">尾页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            // num->当前页
            $.ajax({
                //请求URL地址,controller的名称
                url: "/users",
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {'pageNum': num},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 组装HTML页面
                    parseUserHtmlContent(data);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        }
    });
}

// 查询数据填充至HTML
function parseUserHtmlContent(data) {

    var htmlContent = "";

    for (var i in data) {
        htmlContent += ' <div class="row" >';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + data[i].id + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + data[i].name + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + typeof(data[i].roleName) === 'undefined' ? '游客' : data[i].roleName + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + data[i].email + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + data[i].area + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <button class="btn btn-success" data-toggle="modal" data-target="#updateUser" onclick="javascript:queryUser(\'' + data[i].id + '\');">修改</button>';
        htmlContent += ' <button class="btn btn-danger" data-toggle="modal" onclick="javascript:deleteUser(\'' + data[i].id + '\');">删除</button>';
        htmlContent += ' </div>';
        htmlContent += ' </div>';
    }
    $("#userTablebody").html(htmlContent);
    // 查询所有角色
    queryAllRole('addRoleId');
}

// 新增操作
function addUser() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/users",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#userAddForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "POST",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#addUser").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='user']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 查询资源实体
function queryUser(id) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/users/" + id,
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 返回实体类
            $("#userId").val(data.id);
            $("#userName").val(data.name);
            $("#email").val(data.email);
            $("#area").val(data.area);
            // 资源选项
            if (data.isDelete === 0) {
                $("#userNormal").attr("checked", "checked");
            } else if (data.isDelete === 1) {
                $("#userForbidden").attr("checked", "checked");
            }
            queryAllRole('updateRoleId');
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 查询角色的所有权限
function queryAllRole(id) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/roles",
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {

        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            var html = '';

            for (var i in data) {
                html += '<option value="' + data[i].id + '" name="roleId">' + data[i].name + '</option>';
            }
            $("#" + id).html(html);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 用户更新操作
function updateUser() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/users/" + $("#userId").val(),
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#userUpdateForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "PUT",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#updateUser").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='user']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 删除操作
function deleteUser(id) {
    swal({
        title: '确定删除吗?',  //弹出框的title
        text: '你将无法恢复它!', //弹出框里面的提示文本
        type: 'warning', //弹出框类型
        showCancelButton: true, //是否显示取消按钮
        confirmButtonColor: '#3085d6', //确定按钮颜色
        cancelButtonColor: '#d33', //取消按钮颜色
        confirmButtonText: '确定删除', //确认按钮文本
        cancelButtonText: '取消删除', //取消按钮文本
        confirmButtonClass: 'btn btn-success', //确认按钮样式
        cancelButtonClass: 'btn btn-danger', //取消按钮样式
        buttonsStyling: false //禁止使用默认按钮样式
    }).then(function (isConfirm) {

        if (isConfirm.value === true) {
            $.ajax({
                //请求URL地址,controller的名称
                url: "/users/" + id,
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "DELETE",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {
                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 弹窗提示信息
                    swal(data.msg, '', "success");
                    setTimeout(function () {
                        // 自动关闭弹窗
                        swal.close();
                        // 点击响应tab刷新页面
                        $("div[aria-controls='user']").click();
                    }, 2000);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if (isConfirm.dismiss === 'cancel') {
            // dismiss的值可以是'cancel', 'overlay','close', 'timer'
            swal(
                '已取消',
                '',
                'error'
            );
        } else {
            swal(
                '已关闭',
                '',
                'error'
            );
        }
    });
}

/*************************************************** 角色列表相关操作***************************************************/
// 分页操作
function rolePagination(roleMaxPage) {
    $.jqPaginator('#rolePagination', {
        totalPages: roleMaxPage, // 总页数
        visiblePages: 10, // 显示的页码数量
        currentPage: 1, // 当前页
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        next: '<li class=""><a href="javascript:;">下一页</a></li>',
        last: '<li class="last"><a href="javascript:;">尾页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            // num->当前页
            $.ajax({
                //请求URL地址,controller的名称
                url: "/roles",
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {'pageNum': num},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 组装HTML页面
                    parseRoleHtmlContent(data);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        }
    });
}

// 查询数据填充至HTML
function parseRoleHtmlContent(data) {

    var htmlContent = "";

    for (var i in data) {
        htmlContent += ' <div class="row" >';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + data[i].id + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">';
        htmlContent += ' <span>' + data[i].name + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">';
        htmlContent += ' <span>' + data[i].description + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <button class="btn btn-success" data-toggle="modal" data-target="#updateRole" onclick="javascript:queryRole(\'' + data[i].id + '\');">修改</button>';
        htmlContent += ' <button class="btn btn-danger" data-toggle="modal" onclick="javascript:deleteRole(\'' + data[i].id + '\');">删除</button>';
        htmlContent += ' </div>';
        htmlContent += ' </div>';
    }
    $("#roleTablebody").html(htmlContent);
    // 查询所有的权限
    queryAllPermission('addPermissionId');
}

// 新增操作
function addRole() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/roles",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#roleAddForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "POST",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#addRole").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='role']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 查询角色实体
function queryRole(id) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/roles/" + id,
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 返回实体类
            $("#roleId").val(data.id);
            $("#roleName").val(data.name);
            $("#roleDescription").val(data.description);
            // 资源选项
            if (data.isDelete === 0) {
                $("#roleNormal").attr("checked", "checked");
            } else if (data.isDelete === 1) {
                $("#roleForbidden").attr("checked", "checked");
            }
            // 查询所有的权限
            queryAllPermission('updatePermissionId');
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 查询角色的所有权限
function queryAllPermission(id) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/permissions",
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {

        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            var html = '';

            for (var i in data) {
                html += '<option value="' + data[i].id + '" name="permissionId">' + data[i].name + '</option>';
            }
            $("#" + id).html(html);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 更新操作
function updateRole() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/roles/" + $("#roleId").val(),
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#roleUpdateForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "PUT",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#updateRole").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='role']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 删除操作
function deleteRole(id) {
    swal({
        title: '确定删除吗?',  //弹出框的title
        text: '你将无法恢复它!', //弹出框里面的提示文本
        type: 'warning', //弹出框类型
        showCancelButton: true, //是否显示取消按钮
        confirmButtonColor: '#3085d6', //确定按钮颜色
        cancelButtonColor: '#d33', //取消按钮颜色
        confirmButtonText: '确定删除', //确认按钮文本
        cancelButtonText: '取消删除', //取消按钮文本
        confirmButtonClass: 'btn btn-success', //确认按钮样式
        cancelButtonClass: 'btn btn-danger', //取消按钮样式
        buttonsStyling: false //禁止使用默认按钮样式
    }).then(function (isConfirm) {

        if (isConfirm.value === true) {
            $.ajax({
                //请求URL地址,controller的名称
                url: "/roles/" + id,
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "DELETE",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {
                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 弹窗提示信息
                    swal(data.msg, '', "success");
                    setTimeout(function () {
                        // 自动关闭弹窗
                        swal.close();
                        // 点击响应tab刷新页面
                        $("div[aria-controls='role']").click();
                    }, 2000);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if (isConfirm.dismiss === 'cancel') {
            // dismiss的值可以是'cancel', 'overlay','close', 'timer'
            swal(
                '已取消',
                '',
                'error'
            );
        } else {
            swal(
                '已关闭',
                '',
                'error'
            );
        }
    });
}

/*************************************************** 权限列表相关操作***************************************************/
// 分页操作
function permissionPagination(permissionMaxPage) {
    $.jqPaginator('#permissionPagination', {
        totalPages: permissionMaxPage, // 总页数
        visiblePages: 10, // 显示的页码数量
        currentPage: 1, // 当前页
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        next: '<li class=""><a href="javascript:;">下一页</a></li>',
        last: '<li class="last"><a href="javascript:;">尾页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            // num->当前页
            $.ajax({
                //请求URL地址,controller的名称
                url: "/permissions",
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {'pageNum': num},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 组装HTML页面
                    parsePermissionHtmlContent(data);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        }
    });
}

// 查询数据填充至HTML
function parsePermissionHtmlContent(data) {

    var htmlContent = "";

    for (var i in data) {
        htmlContent += ' <div class="row" >';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + data[i].id + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">';
        htmlContent += ' <span>' + data[i].name + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">';
        htmlContent += ' <span>' + data[i].description + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <button class="btn btn-success" data-toggle="modal" data-target="#updatePermission" onclick="javascript:queryPermission(\'' + data[i].id + '\');">修改</button>';
        htmlContent += ' <button class="btn btn-danger" data-toggle="modal" onclick="javascript:deletePermission(\'' + data[i].id + '\');">删除</button>';
        htmlContent += ' </div>';
        htmlContent += ' </div>';
    }
    $("#permissionTablebody").html(htmlContent);
}

// 新增操作
function addPermission() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/permissions",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#permissionAddForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "POST",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#addPermission").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='permission']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 查询权限实体
function queryPermission(id) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/permissions/" + id,
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 返回实体类
            $("#permissionId").val(data.id);
            $("#permissionName").val(data.name);
            $("#permissionDescription").val(data.description);
            // 资源选项
            if (data.isDelete === 0) {
                $("#permissionNormal").attr("checked", "checked");
            } else if (data.isDelete === 1) {
                $("#permissionForbidden").attr("checked", "checked");
            }
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 更新操作
function updatePermission() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/permissions/" + $("#permissionId").val(),
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#permissionUpdateForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "PUT",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#updatePermission").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='permission']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 删除操作
function deletePermission(id) {
    swal({
        title: '确定删除吗?',  //弹出框的title
        text: '你将无法恢复它!', //弹出框里面的提示文本
        type: 'warning', //弹出框类型
        showCancelButton: true, //是否显示取消按钮
        confirmButtonColor: '#3085d6', //确定按钮颜色
        cancelButtonColor: '#d33', //取消按钮颜色
        confirmButtonText: '确定删除', //确认按钮文本
        cancelButtonText: '取消删除', //取消按钮文本
        confirmButtonClass: 'btn btn-success', //确认按钮样式
        cancelButtonClass: 'btn btn-danger', //取消按钮样式
        buttonsStyling: false //禁止使用默认按钮样式
    }).then(function (isConfirm) {

        if (isConfirm.value === true) {
            $.ajax({
                //请求URL地址,controller的名称
                url: "/permissions/" + id,
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "DELETE",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {
                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 弹窗提示信息
                    swal(data.msg, '', "success");
                    setTimeout(function () {
                        // 自动关闭弹窗
                        swal.close();
                        // 点击响应tab刷新页面
                        $("div[aria-controls='permission']").click();
                    }, 2000);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if (isConfirm.dismiss === 'cancel') {
            // dismiss的值可以是'cancel', 'overlay','close', 'timer'
            swal(
                '已取消',
                '',
                'error'
            );
        } else {
            swal(
                '已关闭',
                '',
                'error'
            );
        }
    });
}

/*************************************************** 文章列表相关操作***************************************************/
// 分页操作
function articlePagination(articleMaxPage) {
    $.jqPaginator('#articlePagination', {
        totalPages: articleMaxPage, // 总页数
        visiblePages: 10, // 显示的页码数量
        currentPage: 1, // 当前页
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        next: '<li class=""><a href="javascript:;">下一页</a></li>',
        last: '<li class="last"><a href="javascript:;">尾页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            // num->当前页
            $.ajax({
                //请求URL地址,controller的名称
                url: "/articles",
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {'pageNum': num},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 组装HTML页面
                    parseArticleHtmlContent(data);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        }
    });
}

// 查询数据填充至HTML
function parseArticleHtmlContent(data) {

    var htmlContent = "";

    for (var i in data) {
        htmlContent += ' <div class="row" >';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + data[i].id + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">';
        htmlContent += ' <span>' + data[i].title + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">';
        htmlContent += ' <span>' + data[i].readAmount + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">';
        htmlContent += ' <span>' + data[i].likeAmount + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + data[i].columnName + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <button class="btn btn-success" data-toggle="modal" data-target="#updateArticle" onclick="javascript:queryArticle(\'' + data[i].id + '\');">修改</button>';
        htmlContent += ' <button class="btn btn-danger" data-toggle="modal" onclick="javascript:deleteArticle(\'' + data[i].id + '\');">删除</button>';
        htmlContent += ' </div>';
        htmlContent += ' </div>';
    }
    $("#articleTablebody").html(htmlContent);
    // 下拉框回显
    queryClassifyList("addArticleClassifyId");
    queryColumnList("addArticleColumnId", "1,2");
}

// 新增操作
function addArticle() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/articles",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#articleAddForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "POST",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#addArticle").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='article']").click();
            }, 2000);
            // 清空文本框内容,防止缓存
            $("#articleAddForm").reset();
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 查询资源实体
function queryArticle(id) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/articles/" + id,
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 返回实体类
            $("#articleId").val(data.id);
            $("#articleTitle").val(data.title);
            $("#summaryUpdateContent").val(data.summary);
            // 防止只修改标题而导致内容丢失
            $("#articleUpdateContent").val(data.content);
            // 编辑器数据回填
            summaryUpdateEditor.txt.html(data.summary);
            articleUpdateEditor.txt.html(data.content);
            // 日记分类
            $("#articleClassify" + data.classify).attr("checked", "checked");
            // 下拉框回显
            queryClassifyList("updateArticleClassifyId");
            queryColumnList("updateArticleColumnId", "1,2")
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 更新操作
function updateArticle() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/articles",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#articleUpdateForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "PUT",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#updateArticle").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='article']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 删除操作
function deleteArticle(id) {
    swal({
        title: '确定删除吗?',  //弹出框的title
        text: '你将无法恢复它!', //弹出框里面的提示文本
        type: 'warning', //弹出框类型
        showCancelButton: true, //是否显示取消按钮
        confirmButtonColor: '#3085d6', //确定按钮颜色
        cancelButtonColor: '#d33', //取消按钮颜色
        confirmButtonText: '确定删除', //确认按钮文本
        cancelButtonText: '取消删除', //取消按钮文本
        confirmButtonClass: 'btn btn-success', //确认按钮样式
        cancelButtonClass: 'btn btn-danger', //取消按钮样式
        buttonsStyling: false //禁止使用默认按钮样式
    }).then(function (isConfirm) {

        if (isConfirm.value === true) {
            $.ajax({
                //请求URL地址,controller的名称
                url: "/articles/" + id,
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "DELETE",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {
                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 弹窗提示信息
                    swal(data.msg, '', "success");
                    setTimeout(function () {
                        // 自动关闭弹窗
                        swal.close();
                        // 点击响应tab刷新页面
                        $("div[aria-controls='article']").click();
                    }, 2000);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if (isConfirm.dismiss === 'cancel') {
            // dismiss的值可以是'cancel', 'overlay','close', 'timer'
            swal(
                '已取消',
                '',
                'error'
            );
        } else {
            swal(
                '已关闭',
                '',
                'error'
            );
        }
    });
}

/*************************************************** 图片列表相关操作***************************************************/
// 分页操作
function imagePagination(imageMaxPage) {
    $.jqPaginator('#imagePagination', {
        totalPages: imageMaxPage, // 总页数
        visiblePages: 10, // 显示的页码数量
        currentPage: 1, // 当前页
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        next: '<li class=""><a href="javascript:;">下一页</a></li>',
        last: '<li class="last"><a href="javascript:;">尾页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            // num->当前页
            $.ajax({
                //请求URL地址,controller的名称
                url: "/images",
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {'pageNum': num},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 组装HTML页面
                    parseimageHtmlContent(data);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        }
    });
}

// 查询数据填充至HTML
function parseimageHtmlContent(data) {

    var htmlContent = "";

    for (var i in data) {
        htmlContent += ' <div class="row" >';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + data[i].id + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + data[i].title + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">';
        htmlContent += ' <span>' + data[i].description + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">';
        htmlContent += ' <span>' + data[i].readAmount + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">';
        htmlContent += ' <span>' + data[i].likeAmount + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">';
        htmlContent += ' <span>' + data[i].columnId + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <button class="btn btn-success" data-toggle="modal" data-target="#updateimage" onclick="javascript:queryimage(\'' + data[i].id + '\');">修改</button>';
        htmlContent += ' <button class="btn btn-danger" data-toggle="modal" onclick="javascript:deleteimage(\'' + data[i].id + '\');">删除</button>';
        htmlContent += ' </div>';
        htmlContent += ' </div>';
    }
    $("#imageTablebody").html(htmlContent);
    // 下拉框回显
    queryColumnList("addimageColumnId", "3");
}

// 新增操作
function addimage() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/images",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#imageAddForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "POST",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#addimage").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='image']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 查询资源实体
function queryimage(id) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/images/" + id,
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 返回实体类
            $("#imageId").val(data.id);
            $("#imageTitle").val(data.title);
            // 防止只修改标题而导致内容丢失
            $("#imageDescription").val(data.description);
            // 日记分类
            $("#imageClassify" + data.classify).attr("checked", "checked");
            // 下拉框回显
            queryColumnList("updateimageColumnId", "3");
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 更新操作
function updateimage() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/images",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#imageUpdateForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "PUT",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#updateimage").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='image']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 删除操作
function deleteimage(id) {
    swal({
        title: '确定删除吗?',  //弹出框的title
        text: '你将无法恢复它!', //弹出框里面的提示文本
        type: 'warning', //弹出框类型
        showCancelButton: true, //是否显示取消按钮
        confirmButtonColor: '#3085d6', //确定按钮颜色
        cancelButtonColor: '#d33', //取消按钮颜色
        confirmButtonText: '确定删除', //确认按钮文本
        cancelButtonText: '取消删除', //取消按钮文本
        confirmButtonClass: 'btn btn-success', //确认按钮样式
        cancelButtonClass: 'btn btn-danger', //取消按钮样式
        buttonsStyling: false //禁止使用默认按钮样式
    }).then(function (isConfirm) {

        if (isConfirm.value === true) {
            $.ajax({
                //请求URL地址,controller的名称
                url: "/images/" + id,
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "DELETE",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {
                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 弹窗提示信息
                    swal(data.msg, '', "success");
                    setTimeout(function () {
                        // 自动关闭弹窗
                        swal.close();
                        // 点击响应tab刷新页面
                        $("div[aria-controls='image']").click();
                    }, 2000);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if (isConfirm.dismiss === 'cancel') {
            // dismiss的值可以是'cancel', 'overlay','close', 'timer'
            swal(
                '已取消',
                '',
                'error'
            );
        } else {
            swal(
                '已关闭',
                '',
                'error'
            );
        }
    });
}

/*************************************************** 友链列表相关操作***************************************************/
// 分页操作
function linkPagination(linkMaxPage) {
    $.jqPaginator('#linkPagination', {
        totalPages: linkMaxPage, // 总页数
        visiblePages: 10, // 显示的页码数量
        currentPage: 1, // 当前页
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        next: '<li class=""><a href="javascript:;">下一页</a></li>',
        last: '<li class="last"><a href="javascript:;">尾页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            // num->当前页
            $.ajax({
                //请求URL地址,controller的名称
                url: "/links",
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {'pageNum': num},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 组装HTML页面
                    parseLinkHtmlContent(data);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        }
    });
}

// 查询数据填充至HTML
function parseLinkHtmlContent(data) {

    var htmlContent = "";

    for (var i in data) {
        htmlContent += ' <div class="row" >';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + data[i].id + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <span>' + data[i].name + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">';
        htmlContent += ' <span>' + data[i].url + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">';
        htmlContent += ' <span>' + data[i].description + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">';
        htmlContent += ' <button class="btn btn-success" data-toggle="modal" data-target="#updateLink" onclick="javascript:queryLink(\'' + data[i].id + '\');">修改</button>';
        htmlContent += ' <button class="btn btn-danger" data-toggle="modal" onclick="javascript:deleteLink(\'' + data[i].id + '\');">删除</button>';
        htmlContent += ' </div>';
        htmlContent += ' </div>';
    }
    $("#linkTablebody").html(htmlContent);
}

// 新增操作
function addLink() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/links",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#linkAddForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "POST",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#addLink").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='link']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 查询资源实体
function queryLink(id) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/links/" + id,
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 返回实体类
            $("#linkId").val(data.id);
            $("#linkName").val(data.name);
            $("#pathName").val(data.url);
            $("#linkDescription").val(data.description);
            // 资源选项
            if (data.isDelete === 0) {
                $("#linkNormal").attr("checked", "checked");
            } else if (data.isDelete === 1) {
                $("#linkForbidden").attr("checked", "checked");
            }
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 更新操作
function updateLink() {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/links",
        //请求返回数据格式为json,还可以是text等
        dataType: "JSON",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: $('#linkUpdateForm').serialize(),
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "PUT",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
            // 隐藏模态窗
            $("#updateLink").modal('hide');
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            // 弹窗提示信息
            swal(data.msg, '', "success");
            setTimeout(function () {
                // 自动关闭弹窗
                swal.close();
                // 点击响应tab刷新页面
                $("div[aria-controls='link']").click();
            }, 2000);
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 删除操作
function deletelink(id) {
    swal({
        title: '确定删除吗?',  //弹出框的title
        text: '你将无法恢复它!', //弹出框里面的提示文本
        type: 'warning', //弹出框类型
        showCancelButton: true, //是否显示取消按钮
        confirmButtonColor: '#3085d6', //确定按钮颜色
        cancelButtonColor: '#d33', //取消按钮颜色
        confirmButtonText: '确定删除', //确认按钮文本
        cancelButtonText: '取消删除', //取消按钮文本
        confirmButtonClass: 'btn btn-success', //确认按钮样式
        cancelButtonClass: 'btn btn-danger', //取消按钮样式
        buttonsStyling: false //禁止使用默认按钮样式
    }).then(function (isConfirm) {

        if (isConfirm.value === true) {
            $.ajax({
                //请求URL地址,controller的名称
                url: "/links/" + id,
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "DELETE",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {
                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 弹窗提示信息
                    swal(data.msg, '', "success");
                    setTimeout(function () {
                        // 自动关闭弹窗
                        swal.close();
                        // 点击响应tab刷新页面
                        $("div[aria-controls='link']").click();
                    }, 2000);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if (isConfirm.dismiss === 'cancel') {
            // dismiss的值可以是'cancel', 'overlay','close', 'timer'
            swal(
                '已取消',
                '',
                'error'
            );
        } else {
            swal(
                '已关闭',
                '',
                'error'
            );
        }
    });
}

/*************************************************** 留言列表相关操作***************************************************/
// 分页操作
function messagePagination(messageMaxPage) {
    $.jqPaginator('#messagePagination', {
        totalPages: messageMaxPage, // 总页数
        visiblePages: 10, // 显示的页码数量
        currentPage: 1, // 当前页
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        next: '<li class=""><a href="javascript:;">下一页</a></li>',
        last: '<li class="last"><a href="javascript:;">尾页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            // num->当前页
            $.ajax({
                //请求URL地址,controller的名称
                url: "/messages",
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {'pageNum': num},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "GET",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {

                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 组装HTML页面
                    parseMessageHtmlContent(data);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        }
    });
}

// 查询数据填充至HTML
function parseMessageHtmlContent(data) {

    var htmlContent = "";

    for (var i in data) {
        htmlContent += ' <div class="row" >';
        htmlContent += ' <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">';
        htmlContent += ' <span>' + data[i].id + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">';
        htmlContent += ' <span>' + data[i].userName + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">';
        htmlContent += ' <span>' + data[i].email + '</span>';
        htmlContent += ' </div>';
        htmlContent += ' <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">';
        htmlContent += ' <button class="btn btn-success" data-toggle="modal" onclick="javascript:queryMessage(\'' + data[i].id + '\');">查看详情</button>';
        htmlContent += ' <button class="btn btn-danger" data-toggle="modal" onclick="javascript:deleteMessage(\'' + data[i].id + '\');">清楚记录</button>';
        htmlContent += ' </div>';
        htmlContent += ' </div>';
    }
    $("#messageTablebody").html(htmlContent);
}

// 查询资源实体
function queryMessage(id) {
    $.ajax({
        //请求URL地址,controller的名称
        url: "/messages/" + id,
        //请求返回数据格式为json,还可以是text等
        dataType: "json",
        //请求是否为异步,默认是true
        async: true,
        //是否从浏览器缓存中加载数据信息
        cache: false,
        //设置请求超时时间
        timeout: 1000,
        //参数值,如果URL带参数,这里就可以不用写了
        data: {},
        //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
        type: "GET",
        //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
        beforeSend: function () {
        },
        //请求成功时的处理函数,参数(返回数据,返回状态)
        success: function (data) {
            sweetAlert({
                title: '留言详情页',  //弹出框的title
                text: data.content  //弹出框里面的提示文本
            })
        },
        //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
        complete: function () {
        },
        //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
        error: function () {
        }
    });
}

// 删除操作
function deleteMessage(id) {
    swal({
        title: '确定删除吗?',  //弹出框的title
        text: '你将无法恢复它!', //弹出框里面的提示文本
        type: 'warning', //弹出框类型
        showCancelButton: true, //是否显示取消按钮
        confirmButtonColor: '#3085d6', //确定按钮颜色
        cancelButtonColor: '#d33', //取消按钮颜色
        confirmButtonText: '确定删除', //确认按钮文本
        cancelButtonText: '取消删除', //取消按钮文本
        confirmButtonClass: 'btn btn-success', //确认按钮样式
        cancelButtonClass: 'btn btn-danger', //取消按钮样式
        buttonsStyling: false //禁止使用默认按钮样式
    }).then(function (isConfirm) {

        if (isConfirm.value === true) {
            $.ajax({
                //请求URL地址,controller的名称
                url: "/messages/" + id,
                //请求返回数据格式为json,还可以是text等
                dataType: "json",
                //请求是否为异步,默认是true
                async: true,
                //是否从浏览器缓存中加载数据信息
                cache: false,
                //设置请求超时时间
                timeout: 1000,
                //参数值,如果URL带参数,这里就可以不用写了
                data: {},
                //POST安全性高,数据量大;GET安全性低,数据量小,从浏览器获取数据
                type: "DELETE",
                //请求发出前的处理函数,参数(XMLHttpRequest对象,返回状态)
                beforeSend: function () {
                },
                //请求成功时的处理函数,参数(返回数据,返回状态)
                success: function (data) {
                    // 弹窗提示信息
                    swal(data.msg, '', "success");
                    setTimeout(function () {
                        // 自动关闭弹窗
                        swal.close();
                        // 点击响应tab刷新页面
                        $("div[aria-controls='message']").click();
                    }, 2000);
                },
                //请求完成时的处理函数,参数(XMLHttpRequest对象,返回状态)//无论成与败均调用
                complete: function () {
                },
                //请求出错时的处理函数,参数(XMLHttpRequest对象,返回状态,错误对象)
                error: function () {
                }
            });
        } else if (isConfirm.dismiss === 'cancel') {
            // dismiss的值可以是'cancel', 'overlay','close', 'timer'
            swal(
                '已取消',
                '',
                'error'
            );
        } else {
            swal(
                '已关闭',
                '',
                'error'
            );
        }
    });
}

/*************************************************** 统计信息列表展示***************************************************/
// 流量统计图
function statisticsVChart(data) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('statisticsVChart'));
    // 全局调色盘。
    // color: ['#c23531','#2f4554', '#61a0a8', '#d48265', '#91c7ae','#749f83',  '#ca8622', '#bda29a','#6e7074', '#546570', '#c4ccd3']
    // 指定图表的配置项和数据
    var option = {

        title: {
            text: '流量统计图'
        },
        tooltip: {},
        legend: {
            data: []
        },
        xAxis: {
            data: ["浏览量[PV]", "访问量[VV]", "用户数[UV]"]
        },
        yAxis: {},
        series: [{
            name: '统计量',
            type: 'bar',
            data: [data.countWebPV, data.countWebVV, data.countWebUV],
            color: ['#2f4554']
        }]
    };
    // 使用刚指定的配置项和数据显示图表
    myChart.setOption(option);
}

// 内容统计图
function statisticsCChart(data) {

    var myChart = echarts.init(document.getElementById('statisticsCChart'));

    var option = {
        title: {
            text: '内容统计图'
        },
        tooltip: {},
        legend: {
            data: []
        },
        xAxis: {
            data: ["留言量", "连接量", "文章量", "图片量", "点赞量", "甩鞋量"]
        },
        yAxis: {},
        series: [{
            name: '统计量',
            type: 'bar',
            data: [data.countMessage, data.countLink, data.countArticle, data.countimage, data.countLike, data.countLikeNo],
            color: ['#61a0a8']
        }],
        label: {
            textStyle: {
                color: 'rgba(255, 255, 255, 0.3)'
            }
        }
    };
    myChart.setOption(option);
}

// 搜索操作
function searchStatisticsContent() {
    // 检索词
    var key = $("#statisticsContent").val();
    // out
    console.info("检索词:" + key);
}

// 滚动到底部
function scrollToEnd() {
    var h = $(document).height() - $(window).height();
    $(document).scrollTop(h);
}