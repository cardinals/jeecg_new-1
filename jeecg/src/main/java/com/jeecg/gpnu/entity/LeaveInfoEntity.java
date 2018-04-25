package com.jeecg.gpnu.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.activiti.engine.task.Task;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 请假信息表
 * @author onlineGenerator
 * @date 2018-04-15 16:57:27
 * @version V1.0   
 *
 */
@Entity
@Table(name = "leave_table", schema = "")
@SuppressWarnings("serial")
public class LeaveInfoEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**学生姓名*/
	@Excel(name="学生姓名",width=15)
	private java.lang.String name;
	/**学院名称*/
	@Excel(name="学院名称",width=15)
	private java.lang.String institudeName;
	/**专业名称*/
	@Excel(name="专业名称",width=15)
	private java.lang.String professionName;
	/**年级*/
	@Excel(name="年级",width=15)
	private java.lang.String gradeName;
	/**班级*/
	@Excel(name="班级",width=15)
	private java.lang.String className;
	/**用户id*/
	private java.lang.String userid;
	/**流程id*/
	private java.lang.String processInstanceId;
	/**请假天数*/
	@Excel(name="请假天数",width=15)
	private java.lang.String leaveDay;
	/**请假原因*/
	@Excel(name="请假原因",width=15)
	private java.lang.String leaveReason;
	/**请假开始时间*/
	@Excel(name="请假开始时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date startTime;
	/**请假结束时间*/
	@Excel(name="请假结束时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date endTime;
	/**请假课时数*/
	@Excel(name="请假课时数",width=15)
	private java.lang.String classNumber;
	/**学号*/
	@Excel(name="学号",width=15)
	private java.lang.String studentNumber;
	/**申请时间*/
	@Excel(name="申请时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date applyTime;
	/**辅导员意见*/
	@Excel(name="辅导员意见",width=15)
	private java.lang.String instructorComment;
	/**院级领导意见*/
	@Excel(name="院级领导意见",width=15)
	private java.lang.String institudeComment;
	/**销假时间*/
	@Excel(name="销假时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date cancelLeave;
	
    private Task task;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}
	

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */

	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */

	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */

	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */

	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学生姓名
	 */

	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学生姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学院名称
	 */

	@Column(name ="INSTITUDE_NAME",nullable=true,length=32)
	public java.lang.String getInstitudeName(){
		return this.institudeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学院名称
	 */
	public void setInstitudeName(java.lang.String institudeName){
		this.institudeName = institudeName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业名称
	 */

	@Column(name ="PROFESSION_NAME",nullable=true,length=32)
	public java.lang.String getProfessionName(){
		return this.professionName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业名称
	 */
	public void setProfessionName(java.lang.String professionName){
		this.professionName = professionName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年级
	 */

	@Column(name ="GRADE_NAME",nullable=true,length=32)
	public java.lang.String getGradeName(){
		return this.gradeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年级
	 */
	public void setGradeName(java.lang.String gradeName){
		this.gradeName = gradeName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  班级
	 */

	@Column(name ="CLASS_NAME",nullable=true,length=32)
	public java.lang.String getClassName(){
		return this.className;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  班级
	 */
	public void setClassName(java.lang.String className){
		this.className = className;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户id
	 */

	@Column(name ="USERID",nullable=true,length=32)
	public java.lang.String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserid(java.lang.String userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程id
	 */

	@Column(name ="PROCESS_INSTANCE_ID",nullable=true,length=32)
	public java.lang.String getProcessInstanceId(){
		return this.processInstanceId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程id
	 */
	public void setProcessInstanceId(java.lang.String processInstanceId){
		this.processInstanceId = processInstanceId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  请假天数
	 */

	@Column(name ="LEAVE_DAY",nullable=true,length=32)
	public java.lang.String getLeaveDay(){
		return this.leaveDay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  请假天数
	 */
	public void setLeaveDay(java.lang.String leaveDay){
		this.leaveDay = leaveDay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  请假原因
	 */

	@Column(name ="LEAVE_REASON",nullable=true,length=32)
	public java.lang.String getLeaveReason(){
		return this.leaveReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  请假原因
	 */
	public void setLeaveReason(java.lang.String leaveReason){
		this.leaveReason = leaveReason;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  请假开始时间
	 */

	@Column(name ="START_TIME",nullable=true,length=32)
	public java.util.Date getStartTime(){
		return this.startTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  请假开始时间
	 */
	public void setStartTime(java.util.Date startTime){
		this.startTime = startTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  请假结束时间
	 */

	@Column(name ="END_TIME",nullable=true,length=32)
	public java.util.Date getEndTime(){
		return this.endTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  请假结束时间
	 */
	public void setEndTime(java.util.Date endTime){
		this.endTime = endTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  请假课时数
	 */

	@Column(name ="CLASS_NUMBER",nullable=true,length=32)
	public java.lang.String getClassNumber(){
		return this.classNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  请假课时数
	 */
	public void setClassNumber(java.lang.String classNumber){
		this.classNumber = classNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学号
	 */

	@Column(name ="STUDENT_NUMBER",nullable=true,length=32)
	public java.lang.String getStudentNumber(){
		return this.studentNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学号
	 */
	public void setStudentNumber(java.lang.String studentNumber){
		this.studentNumber = studentNumber;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请时间
	 */

	@Column(name ="APPLY_TIME",nullable=true,length=32)
	public java.util.Date getApplyTime(){
		return this.applyTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请时间
	 */
	public void setApplyTime(java.util.Date applyTime){
		this.applyTime = applyTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  辅导员意见
	 */

	@Column(name ="INSTRUCTOR_COMMENT",nullable=true,length=32)
	public java.lang.String getInstructorComment(){
		return this.instructorComment;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  辅导员意见
	 */
	public void setInstructorComment(java.lang.String instructorComment){
		this.instructorComment = instructorComment;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  院级领导意见
	 */

	@Column(name ="INSTITUDE_COMMENT",nullable=true,length=32)
	public java.lang.String getInstitudeComment(){
		return this.institudeComment;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  院级领导意见
	 */
	public void setInstitudeComment(java.lang.String institudeComment){
		this.institudeComment = institudeComment;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  销假时间
	 */

	@Column(name ="CANCEL_LEAVE",nullable=true,length=32)
	public java.util.Date getCancelLeave(){
		return this.cancelLeave;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  销假时间
	 */
	public void setCancelLeave(java.util.Date cancelLeave){
		this.cancelLeave = cancelLeave;
	}




	public void setTask(Task task) {
		// TODO Auto-generated method stub
		this.task = task;
	}


	@Override
	public String toString() {
		return "LeaveInfoEntity [id=" + id + ", createName=" + createName + ", createBy=" + createBy + ", createDate="
				+ createDate + ", updateName=" + updateName + ", updateBy=" + updateBy + ", updateDate=" + updateDate
				+ ", sysOrgCode=" + sysOrgCode + ", sysCompanyCode=" + sysCompanyCode + ", bpmStatus=" + bpmStatus
				+ ", name=" + name + ", institudeName=" + institudeName + ", professionName=" + professionName
				+ ", gradeName=" + gradeName + ", className=" + className + ", userid=" + userid
				+ ", processInstanceId=" + processInstanceId + ", leaveDay=" + leaveDay + ", leaveReason=" + leaveReason
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", classNumber=" + classNumber
				+ ", studentNumber=" + studentNumber + ", applyTime=" + applyTime + ", instructorComment="
				+ instructorComment + ", institudeComment=" + institudeComment + ", cancelLeave=" + cancelLeave
				+ ", task=" + task + "]";
	}
	
	

}
