<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div  id="main_leave_list" class="easyui-layout" fit="true">
	<div region="center" style="padding: 0px; border: 0px">
		<t:datagrid name="leaveInfoList" checkbox="true" pagination="true"
			fitColumns="true" title="请假信息表"
			actionUrl="leaveActivitController.do?myTaskList" idField="id"
			fit="true" queryMode="group">
			<t:dgCol title="主键" field="id" hidden="true" queryMode="single"
				width="120"></t:dgCol>
			<t:dgCol title="流程状态" field="bpmStatus" queryMode="single"
				dictionary="bpm_status" width="120"></t:dgCol>
			<t:dgCol title="学号" field="studentnumber" queryMode="single"
				width="120"></t:dgCol>
			<t:dgCol title="学生姓名" field="userName" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="学院名称" field="institudename" hidden="true"
				queryMode="single" width="150"></t:dgCol>
			<t:dgCol title="年级" field="gradename" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="专业名称" field="professionname" queryMode="single"
				width="150"></t:dgCol>
			<t:dgCol title="班级" field="classname" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="用户id" field="userid" hidden="true" queryMode="single"
				width="120"></t:dgCol>
			<t:dgCol title="流程id" field="processInstanceId" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="申请时间" field="applytime" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
			<t:dgDelOpt title="删除" url="" urlclass="ace_button"
				urlfont="fa-trash-o" />
			<t:dgFunOpt funname="complete(id)" title="办理" urlclass="ace_button"
				urlfont="fa-user"></t:dgFunOpt>
			<t:dgFunOpt funname="reject(id,processInstanceId)" title="驳回" urlclass="ace_button"></t:dgFunOpt>
			<t:dgFunOpt funname="audit(id,processInstanceId)" title="审核" urlclass="ace_button" urlfont="fa-user"></t:dgFunOpt>
			<t:dgToolBar title="录入" icon="icon-add"
				url="leaveInfoController.do?goAdd" funname="add"></t:dgToolBar>
			<t:dgToolBar title="编辑" icon="icon-edit"
				url="leaveInfoController.do?goUpdate" funname="update"></t:dgToolBar>
			<t:dgToolBar title="批量删除" icon="icon-remove"
				url="leaveInfoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
			<t:dgToolBar title="查看" icon="icon-search"
				url="leaveInfoController.do?goUpdate" funname="detail"></t:dgToolBar>
		    <t:dgToolBar title="请假" icon="icon-search" funname="leave"></t:dgToolBar>
			<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
			<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
			<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
		</t:datagrid>
	</div>
</div>
<div data-options="region:'east',
	title:'<t:mutiLang langKey="leave"/>',
	collapsed:true,
	split:true,
	border:false,
	onExpand : function(){
		li_east = 1;
	},
	onCollapse : function() {
	    li_east = 0;
	}"
	style="width: 100%; overflow: hidden;" id="eastPanel">
    <div class="easyui-panel" style="padding:0px;border:0px" fit="true" border="false" id="leave_table_panel"></div>
</div>
<script src="webpage/com/jeecg/gpnu/leaveInfoList.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
	});
    
	function audit(id,processInstanceId){
	
		createwindow("审核","leaveActivitController.do?operation&taskId="+id+"&processInstanceId="+processInstanceId,"300px","200px");
	}
	//?taskId="+id+"&processInstanceId="+processInstanceId
	
	function complete(id) {
		$.ajax({
			type : "POST",
			url : "leaveActivitController/complete.do?taskId=" + id,
			success : function(msg) {
				var msg = JSON.parse(msg);
				tip(msg.msg);
				
				
			}
		});
	}
    
	
	
	
	function reject(id,processInstanceId){
		alert("processInstanceId:" +processInstanceId);
		$.ajax({
			type : "POST",
			url : "leaveActivitController/reject.do?taskId="+id+"&processInstanceId="+processInstanceId,
			success : function(msg) {
				
			}
		});      
	}
	
	 $(function() {
	        var li_east = 0;
	 });
	
	function leave(){
        var title = '<t:mutiLang langKey="leave"/>';
        if(li_east == 0 || $('#main_leave_list').layout('panel','east').panel('options').title != title){
            $('#main_leave_list').layout('expand','east');
        }
        <%--$('#eastPanel').panel('setTitle','<t:mutiLang langKey="leave"/>');--%>
        $('#main_leave_list').layout('panel','east').panel('setTitle', title);
        $('#main_leave_list').layout('panel','east').panel('resize', {width: 500});
        $('#leave_table_panel').panel("refresh", "leaveActivitController.do?leave");
    }
	
	
	//导入
	function ImportXls() {
		openuploadwin('Excel导入', 'leaveInfoController.do?upload',
				"leaveInfoList");
	}

	//导出
	function ExportXls() {
		JeecgExcelExport("leaveInfoController.do?exportXls", "leaveInfoList");
	}

	//模板下载
	function ExportXlsByT() {
		JeecgExcelExport("leaveInfoController.do?exportXlsByT", "leaveInfoList");
	}
</script>
