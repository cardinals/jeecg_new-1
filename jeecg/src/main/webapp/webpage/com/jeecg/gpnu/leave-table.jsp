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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="leaveActivitController/start.do" >
					<input id="id" name="id" type="hidden" value="${leaveInfoPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							学生姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt" value="${tsUser.getRealName()}" disabled="disabled" ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学生姓名</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							学院名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="institudeName" name="institudeName" value="${tsDeparts.get(3).getDepartname()}" disabled="disabled" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
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
					     	 <input id="professionName" name="professionName" value="${tsDeparts.get(2).getDepartname()}" disabled="disabled" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">专业名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							年级:
						</label>
					</td>
					<td class="value">
					     	 <input id="gradeName" name="gradeName" type="text" value="${tsDeparts.get(1).getDepartname()}" disabled="disabled" style="width: 150px" class="inputxt"  ignore="ignore" />
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
					     	 <input id="className" name="className" type="text" value="${tsDeparts.get(0).getDepartname()}" disabled="disabled" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">班级</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							请假天数:
						</label>
					</td>
					<td class="value">
					     	 <input id="leaveDay" name="leaveDay" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
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
							   <input id="startTime" name="startTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请假开始时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							请假结束时间:
						</label>
					</td>
					<td class="value">
							   <input id="endTime" name="endTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
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
					     	 <input id="classNumber" name="classNumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请假课时数</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							学号:
						</label>
					</td>
					<td class="value">
					     	 <input id="studentNumber" name="studentNumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
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
							   <input id="applyTime" name="applyTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请时间</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							请假原因:
						</label>
					</td>
					<td class="value"  colspan="3" >
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="leaveReason" name="leaveReason"  ignore="ignore" ></textarea>
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
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="instructorComment" name="instructorComment"  ignore="ignore" ></textarea>
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
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="institudeComment" name="institudeComment"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">院级领导意见</label>
						</td>
					</tr>
			</table>
			<div>
			   <input type="submit"  />
			</div>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/gpnu/leaveInfo.js"></script>		
