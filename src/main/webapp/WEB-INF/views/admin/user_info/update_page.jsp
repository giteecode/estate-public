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
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>

    <![endif]-->
                <title></title>


            </head>

            <body>
                <div id="loadingDiv"></div>

                <div id="imgModal"></div>
                <div class="page-container">


                    <div class="row cl" id="nameParentContent" style="margin-top:20px;margin-left:20px;">
                        <label class="form-label col-xs-4 col-sm-2">
                            登录名
                        </label>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input type="text" class="input-text" style="width:500px;display:inline"
                                value="${data.name}" placeholder="请输入登录名" id="name">
                        </div>
                    </div>

                    <div class="row cl" id="passWordParentContent" style="margin-top:20px;margin-left:20px;">
                        <label class="form-label col-xs-4 col-sm-2">
                            登录密码
                        </label>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input type="text" class="input-text" style="width:500px;display:inline"
                                value="${data.passWord}" placeholder="请输入登录密码" id="passWord">
                        </div>
                    </div>

                    <div class="row cl" id="realNameParentContent" style="margin-top:20px;margin-left:20px;">
                        <label class="form-label col-xs-4 col-sm-2">
                            姓名
                        </label>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input type="text" class="input-text" style="width:500px;display:inline"
                                value="${data.realName}" placeholder="请输入姓名" id="realName">
                        </div>
                    </div>

                    <div class="row cl" id="celPhoneParentContent" style="margin-top:20px;margin-left:20px;">
                        <label class="form-label col-xs-4 col-sm-2">
                            手机号
                        </label>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input type="text" class="input-text" style="width:500px;display:inline"
                                value="${data.celPhone}" placeholder="请输入手机号" id="celPhone">
                        </div>
                    </div>

                    <div class="row cl" id="wyFeeParentContent" style="margin-top:20px;margin-left:20px;">
                        <label class="form-label col-xs-4 col-sm-2">
                            每月物业费
                        </label>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input type="text" class="input-text" style="width:500px;display:inline"
                                value="${data.wyFee}" placeholder="请输入每月物业费（请输入数字）" id="wyFee">
                        </div>
                    </div>

                    <div class="row cl" id="addressParentContent" style="margin-top:20px;margin-left:20px;">
                        <label class="form-label col-xs-4 col-sm-2">
                            地址
                        </label>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input type="text" class="input-text" style="width:500px;display:inline"
                                value="${data.address}" placeholder="请输入地址" id="address">
                        </div>
                    </div>
                    <div class="row cl" id="carParentContent" style="margin-top:20px;margin-left:20px;">
                        <label class="form-label col-xs-4 col-sm-2">
                            车辆信息
                        </label>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input type="text" class="input-text" style="width:500px;display:inline" value="${data.car}"
                                placeholder="请输入车辆信息" id="car">
                        </div>
                    </div>

                </div>

                <hr>

                <div class="page-container">

                    <div class="row cl" style="margin-top:20px;">
                        <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                            <button onClick="submitData();" class="btn btn-primary radius" type="button"><i
                                    class="Hui-iconfont"></i>
                                保存并提交
                            </button>
                            <button onClick="javascript:history.back(-1);" class="btn btn-default radius"
                                type="button">返回</button>

                        </div>
                    </div>
                </div>


                <!--_footer 作为公共模版分离出去-->
                <script type="text/javascript"
                    src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>


                <script type="text/javascript"
                    src="${pageContext.request.contextPath}/static/hui/lib/layer/2.4/layer.js"></script>
                <script type="text/javascript"
                    src="${pageContext.request.contextPath}/static/hui/static/h-ui/js/H-ui.min.js"></script>
                <script type="text/javascript"
                    src="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/js/H-ui.admin.js"></script>
                <!--/_footer /作为公共模版分离出去-->
                <script type="text/javascript"
                    src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=8824"></script>


                <script type="text/javascript">


                    $(function () {


                    })


                    function submitData() {
                        var name = $('#name').val();
                        var passWord = $('#passWord').val();
                        var realName = $('#realName').val();
                        var celPhone = $('#celPhone').val();
                        var wyFee = $('#wyFee').val();
                        var address = $('#address').val();
                        var car = $('#car').val();
                        if (wyFee != '') {
                            if (isNum(wyFee) == false) {
                                alert("每月物业费必须填入数字");
                                return;
                            }
                        }
                        $.ajax({
                            type: 'post',
                            url: '${pageContext.request.contextPath}/admin/user_info/update_submit',
                            data: {
                                "id": '${data.id}',
                                "name": name,
                                "passWord": passWord,
                                "realName": realName,
                                "celPhone": celPhone,
                                "address": address,
                                "car": car,
                                "wyFee": wyFee
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