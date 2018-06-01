package com.alkaid.dtmp.attendance.api;

import com.alkaid.dtmp.attendance.dao.model.WorkOvertime;
import com.alkaid.dtmp.attendance.dao.model.WorkOvertimeExample;
import com.alkaid.dtmp.common.base.BaseService;
import com.alkaid.dtmp.common.pojo.DtmpResult;

import java.sql.Date;
import java.util.List;

public interface WorkOvertimeService extends BaseService<WorkOvertime, WorkOvertimeExample> {

    public WorkOvertime getWorkOvertime(int workOvertimeId);

    public DtmpResult setWorkOvertime(WorkOvertime workOvertime);

    public List<WorkOvertime> getWorkOvertime(Date date, int userId);

    public DtmpResult deleteWorkOvertime(int workOvertimeId);
}
