<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>请假信息表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="leaveInfoController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${leaveInfoPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								开始时间:
							</label>
						</td>
						<td class="value">
						     	 <input id="startTime" name="startTime" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${leaveInfoPage.startTime}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开始时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								结束时间:
							</label>
						</td>
						<td class="value">
						     	 <input id="endTime" name="endTime" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${leaveInfoPage.endTime}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结束时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								请假类型:
							</label>
						</td>
						<td class="value">
						     	 <input id="leaveType" name="leaveType" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${leaveInfoPage.leaveType}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请假类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								申请时间:
							</label>
						</td>
						<td class="value">
						     	 <input id="applyTime" name="applyTime" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${leaveInfoPage.applyTime}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请时间</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/gpnu/leaveInfo.js"></script>		
