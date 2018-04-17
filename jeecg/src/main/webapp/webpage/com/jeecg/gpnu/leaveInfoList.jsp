<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="leaveInfoList" checkbox="true" pagination="true" fitColumns="true" title="请假信息表" actionUrl="leaveInfoController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="学生姓名"  field="name"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="学院名称"  field="institudeName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="专业名称"  field="professionName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="年级"  field="gradeName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="班级"  field="className"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户id"  field="userid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程id"  field="processInstanceId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="请假天数"  field="leaveDay"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="请假原因"  field="leaveReason"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="请假开始时间"  field="startTime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="请假结束时间"  field="endTime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="请假课时数"  field="classNumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="学号"  field="studentNumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请时间"  field="applyTime"  formatter="yyyy-MM-dd hh:mm:ss"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="辅导员意见"  field="instructorComment"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="院级领导意见"  field="institudeComment"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="销假时间"  field="cancelLeave"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="leaveInfoController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="leaveInfoController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="leaveInfoController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="leaveInfoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="leaveInfoController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/gpnu/leaveInfoList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'leaveInfoController.do?upload', "leaveInfoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("leaveInfoController.do?exportXls","leaveInfoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("leaveInfoController.do?exportXlsByT","leaveInfoList");
}

 </script>