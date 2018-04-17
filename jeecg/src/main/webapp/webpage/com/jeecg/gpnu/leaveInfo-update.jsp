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
								学生姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${leaveInfoPage.name}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学生姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								学院名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="institudeName" name="institudeName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${leaveInfoPage.institudeName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学院名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								专业名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="professionName" name="professionName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${leaveInfoPage.professionName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">专业名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								年级:
							</label>
						</td>
						<td class="value">
						     	 <input id="gradeName" name="gradeName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${leaveInfoPage.gradeName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年级</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								班级:
							</label>
						</td>
						<td class="value">
						     	 <input id="className" name="className" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${leaveInfoPage.className}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">班级</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								请假天数:
							</label>
						</td>
						<td class="value">
						     	 <input id="leaveDay" name="leaveDay" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${leaveInfoPage.leaveDay}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请假天数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								请假开始时间:
							</label>
						</td>
						<td class="value">
									   <input id="startTime" name="startTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${leaveInfoPage.startTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请假开始时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								请假结束时间:
							</label>
						</td>
						<td class="value">
									   <input id="endTime" name="endTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${leaveInfoPage.endTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请假结束时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								请假课时数:
							</label>
						</td>
						<td class="value">
						     	 <input id="classNumber" name="classNumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${leaveInfoPage.classNumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请假课时数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								学号:
							</label>
						</td>
						<td class="value">
						     	 <input id="studentNumber" name="studentNumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${leaveInfoPage.studentNumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								申请时间:
							</label>
						</td>
						<td class="value">
									   <input id="applyTime" name="applyTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${leaveInfoPage.applyTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								销假时间:
							</label>
						</td>
						<td class="value">
									   <input id="cancelLeave" name="cancelLeave" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${leaveInfoPage.cancelLeave}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">销假时间</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								请假原因:
							</label>
						</td>
						<td class="value"  colspan="3" >
						  	 	<textarea id="leaveReason" style="width:600px;" class="inputxt" rows="6" name="leaveReason"  ignore="ignore" >${leaveInfoPage.leaveReason}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请假原因</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								辅导员意见:
							</label>
						</td>
						<td class="value"  colspan="3" >
						  	 	<textarea id="instructorComment" style="width:600px;" class="inputxt" rows="6" name="instructorComment"  ignore="ignore" >${leaveInfoPage.instructorComment}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">辅导员意见</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								院级领导意见:
							</label>
						</td>
						<td class="value"  colspan="3" >
						  	 	<textarea id="institudeComment" style="width:600px;" class="inputxt" rows="6" name="institudeComment"  ignore="ignore" >${leaveInfoPage.institudeComment}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">院级领导意见</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/gpnu/leaveInfo.js"></script>		
