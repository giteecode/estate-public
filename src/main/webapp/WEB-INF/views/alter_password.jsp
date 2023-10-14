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
				<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
				<title>${btn.windowTitle}</title>
			</head>

			<body>
				<div><a href="javascript:void(0)" onclick="javascript:history.back(-1);"
						style="margin-left:50px;margin-top:50px;" class="btn btn-success radius">《《返回</a></div>
				<div id="imgModal"></div>
				<form id="addFrom">


					<div class="page-container">
						<div class="row cl" id="nameParentDiv" style="margin-top:20px;margin-left:20px;"> <label
								class="form-label col-xs-4 col-sm-2">旧密码
							</label>
							<div class="formControls col-xs-8 col-sm-9">
								<input type="password" class="input-text" placeholder="请输入旧密码" id="password1"
									name="password1">
							</div>
						</div>

						<div class="row cl" id="nameParentDiv" style="margin-top:20px;margin-left:20px;"> <label
								class="form-label col-xs-4 col-sm-2">新密码
							</label>
							<div class="formControls col-xs-8 col-sm-9">
								<input type="password" class="input-text" placeholder="请输入新密码" id="password2"
									name="password2">
							</div>
						</div>
						<div class="row cl" id="nameParentDiv" style="margin-top:20px;margin-left:20px;"> <label
								class="form-label col-xs-4 col-sm-2">新密码
							</label>
							<div class="formControls col-xs-8 col-sm-9">
								<input type="password" class="input-text" placeholder="请再次输入新密码" id="password3"
									name="password3">
							</div>
						</div>
					</div>




				</form>
				<hr>

				<div class="page-container">
					<div class="row cl" style="margin-top:20px;">
						<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
							<button onClick="alterPassword();" class="btn btn-primary radius" type="button"><i
									class="Hui-iconfont"></i> 保存并提交</button>
						</div>
					</div>
				</div>
				<!--_footer 作为公共模版分离出去-->
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/static/common/fileupload/jquery-form.js"></script>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/static/hui/lib/My97DatePicker/4.8/WdatePicker.js"></script>

				<script type="text/javascript"
					src="${pageContext.request.contextPath}/static/hui/icheck/jquery.icheck.min.js"></script>

				<script type="text/javascript"
					src="${pageContext.request.contextPath}/static/fileupload/fileupload.js"></script>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/static/hui/lib/layer/2.4/layer.js"></script>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/static/hui/static/h-ui/js/H-ui.min.js"></script>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/js/H-ui.admin.js"></script>
				<!--/_footer /作为公共模版分离出去-->
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=#随机码#"></script>

				<script type="text/javascript">
					function alterPassword() {
						var password1 = $("#password1").val();
						var password2 = $("#password2").val();
						var password3 = $("#password3").val();
						$.ajax({
							type: 'post',
							dataType: "json",
							url: '${pageContext.request.contextPath}/commonapi/alterPassword/submit',
							data: {
								"password1": password1,
								"password2": password2,
								"password3": password3
							},
							success: function (result) {
								if (result.code == 0) {
									alert(result.msg);
								} else {
									alert(result.msg);
								}
							}
						});
					}
				</script>
			</body>

			</html>