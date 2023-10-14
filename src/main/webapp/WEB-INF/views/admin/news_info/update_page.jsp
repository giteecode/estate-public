<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html>

            <head>
                <meta charset="utf-8">
                <meta name="renderer" content="webkit|ie-comp|ie-stand">
                <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
                <meta name="viewport"
                    content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
                <meta http-equiv="Cache-Control" content="no-siteapp" />
                <c:set var="uri" value="${pageContext.request.contextPath}" />
                <script type="text/javascript">
                    var uri = '${uri}';
                </script>
                <!--[if lt IE 9]>
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/html5shiv.js"></script>
            <script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/respond.min.js"></script>
                <![endif]-->
                <link rel="stylesheet" type="text/css"
                    href="${pageContext.request.contextPath}/static/hui/static/h-ui/css/H-ui.min.css" />
                <link rel="stylesheet" type="text/css"
                    href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/H-ui.admin.css" />
                <link rel="stylesheet" type="text/css"
                    href="${pageContext.request.contextPath}/static/hui/icheck/icheck.css" />
                <link rel="stylesheet" type="text/css"
                    href="${pageContext.request.contextPath}/static/hui/lib/Hui-iconfont/1.0.8/iconfont.css" />
                <link rel="stylesheet" type="text/css"
                    href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/skin/default/skin.css"
                    id="skin" />
                <link rel="stylesheet" type="text/css"
                    href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/style.css" />

                <style type="text/css">
                    .loadingModel {
                        position: absolute;
                        top: 0;
                        left: 0;
                        display: none;
                        background-color: rgba(9, 9, 9, 0.63);
                        width: 100%;
                        height: 100%;
                        z-index: 1000;
                    }

                    .loading-content {
                        width: 50%;
                        text-align: center;
                        background: #ffffff;
                        border-radius: 6px;
                        line-height: 30px;
                        z-index: 10001;
                    }
                </style>

                <!--[if IE 6]>
                                        <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
                                        <script>DD_belatedPNG.fix('*');</script>
                                        
                                        <![endif]-->
                <title></title>


            </head>

            <body>
                <div id="loadingDiv"></div>

                <div id="imgModal"></div>
                <div class="page-container">


                    <div class="row cl" id="titleParentContent" style="margin-top:20px;margin-left:20px;">
                        <label class="form-label col-xs-4 col-sm-2">
                            标题
                        </label>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input type="text" class="input-text" style="width:500px;display:inline"
                                value="${data.title}" placeholder="请输入标题" id="title">
                        </div>
                    </div>

                    <div class="row cl" id="contentParentContent" style="margin-top:20px;margin-left:20px;">
                        <label class="form-label col-xs-4 col-sm-2">
                            新闻内容
                        </label>
                        <div class="formControls col-xs-8 col-sm-9">
                            <div id="contentDiv1" data-id="content" class="toolbar" style="margin-top:3%;"></div>
                            <div id="contentDiv2" class="text" style="min-height:300px;z-index:1"></div>

                        </div>
                    </div>





                </div>

                <hr>

                <div class="page-container">

                    <div class="row cl" style="margin-top:20px;">
                        <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                            <button onClick="submitData();" class="btn btn-primary radius" type="button"><i
                                    class="Hui-iconfont"></i> 保存并提交</button>
                            <button onClick="javascript:history.back(-1);" class="btn btn-default radius"
                                type="button">返回</button>

                        </div>
                    </div>
                </div>



                <!--_footer 作为公共模版分离出去-->
                <script type="text/javascript"
                    src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>


                <script type="text/javascript"
                    src="${pageContext.request.contextPath}/static/common/wangeditor-3.0.17/wangEditor.min.js"></script>
                <script type="text/javascript"
                    src="${pageContext.request.contextPath}/static/common/wangeditor-3.0.17/wangeditor_emotion.js"></script>




                <script type="text/javascript"
                    src="${pageContext.request.contextPath}/static/hui/lib/layer/2.4/layer.js"></script>
                <script type="text/javascript"
                    src="${pageContext.request.contextPath}/static/hui/static/h-ui/js/H-ui.min.js"></script>
                <script type="text/javascript"
                    src="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/js/H-ui.admin.js"></script>
                <!--/_footer /作为公共模版分离出去-->
                <script type="text/javascript"
                    src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=1299"></script>



                <script type="text/javascript">


                    var wangList = [];

                    $(function () {

                        var contentMap = {};
                        var contentEdit = window.wangEditor;
                        editor = new contentEdit('#contentDiv1', '#contentDiv2');
                        editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/commonapi/imgUpload/imgUploadForWangEditor'
                        editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
                        editor.customConfig.uploadImgMaxLength = 5;
                        editor.customConfig.uploadImgTimeout = 30000;
                        editor.customConfig.uploadFileName = 'files'
                        editor.customConfig.emotions = [{ title: '默认', type: 'image', content: wangeditorEmotions }];
                        editor.create();
                        $('#contentDiv2').css("z-index", "1");
                        contentMap.id = 'content';
                        contentMap.edit = editor;
                        wangList.push(contentMap);
                        editor.txt.html(getData().content);


                    })



                    function getEditVal(name) {
                        for (var i = 0; i < wangList.length; i++) {
                            var dataId = wangList[i].id;
                            if (dataId == name) {
                                return wangList[i].edit.txt.html();
                            }
                        }
                        return '';
                    }
                    function getData() {
                        var data = {};
                        $.ajax({
                            async: false,
                            type: 'post',
                            url: '${pageContext.request.contextPath}/admin/news_info/queryDataDetail',
                            data: {
                                "id": '${data.id}'
                            },
                            success: function (result) {
                                data = result;
                            }
                        });
                        return data;
                    }
                    function submitData() {
                        var title = $('#title').val();
                        var content = getEditVal('content');

                        $.ajax({
                            type: 'post',
                            url: '${pageContext.request.contextPath}/admin/news_info/update_submit',
                            data: {
                                "id": '${data.id}',
                                "title": title,
                                "content": content
                            },
                            success: function (result) {
                                if (result.code == 0) {
                                    alert(result.msg);
                                } else {
                                    alert(result.msg);
                                    self.location = document.referrer;
                                }
                            }
                        });
                    }








                </script>

            </body>

            </html>