package com.alkaid.dtmp.attendance.dao.model;

import java.io.Serializable;
import java.util.Date;

public class WorkOvertime implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_work_overtime.workovertime_id
     *
     * @mbg.generated
     */
    private Integer workovertimeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_work_overtime.date
     *
     * @mbg.generated
     */
    private Date date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_work_overtime.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_work_overtime.start_time
     *
     * @mbg.generated
     */
    private Date startTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_work_overtime.stop_time
     *
     * @mbg.generated
     */
    private Date stopTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_work_overtime.reason
     *
     * @mbg.generated
     */
    private String reason;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_work_overtime.workovertime_id
     *
     * @return the value of tbl_work_overtime.workovertime_id
     *
     * @mbg.generated
     */
    public Integer getWorkovertimeId() {
        return workovertimeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_work_overtime.workovertime_id
     *
     * @param workovertimeId the value for tbl_work_overtime.workovertime_id
     *
     * @mbg.generated
     */
    public void setWorkovertimeId(Integer workovertimeId) {
        this.workovertimeId = workovertimeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_work_overtime.date
     *
     * @return the value of tbl_work_overtime.date
     *
     * @mbg.generated
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_work_overtime.date
     *
     * @param date the value for tbl_work_overtime.date
     *
     * @mbg.generated
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_work_overtime.user_id
     *
     * @return the value of tbl_work_overtime.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_work_overtime.user_id
     *
     * @param userId the value for tbl_work_overtime.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_work_overtime.start_time
     *
     * @return the value of tbl_work_overtime.start_time
     *
     * @mbg.generated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_work_overtime.start_time
     *
     * @param startTime the value for tbl_work_overtime.start_time
     *
     * @mbg.generated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_work_overtime.stop_time
     *
     * @return the value of tbl_work_overtime.stop_time
     *
     * @mbg.generated
     */
    public Date getStopTime() {
        return stopTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_work_overtime.stop_time
     *
     * @param stopTime the value for tbl_work_overtime.stop_time
     *
     * @mbg.generated
     */
    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_work_overtime.reason
     *
     * @return the value of tbl_work_overtime.reason
     *
     * @mbg.generated
     */
    public String getReason() {
        return reason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_work_overtime.reason
     *
     * @param reason the value for tbl_work_overtime.reason
     *
     * @mbg.generated
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}