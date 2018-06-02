package com.alkaid.dtmp.attendance.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alkaid.dtmp.attendance.api.WorkOvertimeService;
import com.alkaid.dtmp.attendance.dao.mapper.WorkOvertimeMapper;
import com.alkaid.dtmp.attendance.dao.model.WorkOvertime;
import com.alkaid.dtmp.attendance.dao.model.WorkOvertimeExample;
import com.alkaid.dtmp.common.base.BaseServiceImpl;
import com.alkaid.dtmp.common.constants.DtmpConstants;
import com.alkaid.dtmp.common.pojo.DtmpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service(version = DtmpConstants.DTMP_ATTENDANCE_WORKOVERTIME_VERSION)
@Transactional
public class WorkOvertimeServiceImpl extends BaseServiceImpl<WorkOvertimeMapper, WorkOvertime, WorkOvertimeExample> implements WorkOvertimeService {

    @Autowired
    private WorkOvertimeMapper workOvertimeMapper;

    @Override
    public WorkOvertime getWorkOvertime(int workOvertimeId) {
        WorkOvertime workOvertime = workOvertimeMapper.selectByPrimaryKey(workOvertimeId);
        return workOvertime;
    }

    @Override
    public DtmpResult setWorkOvertime(WorkOvertime workOvertime) {
        if (workOvertime == null) {
            return new DtmpResult(400, "error", "数据为空！");
        }
        int count = workOvertimeMapper.insert(workOvertime);
        DtmpResult result = new DtmpResult(200, "success", null);
        return result;
    }

    @Override
    public List<WorkOvertime> getWorkOvertime(Date date, int userId) {
        if (date == null) {
            return null;
            //return new DtmpResult(400, "error", "数据为空");
        }
        WorkOvertimeExample workOvertimeExample = new WorkOvertimeExample();
        WorkOvertimeExample.Criteria criteria = workOvertimeExample.createCriteria();
        criteria.andDateEqualTo(date).andUserIdEqualTo(userId);
        List<WorkOvertime> list = workOvertimeMapper.selectByExample(workOvertimeExample);
        return list;
    }

    @Override
    public DtmpResult deleteWorkOvertime(int workOvertimeId) {
        int count = workOvertimeMapper.deleteByPrimaryKey(workOvertimeId);
        if (count == 1) {
            return new DtmpResult(200, "secuess", "删除加班成功！");
        } else {
            return new DtmpResult(400, "error", "删除加班失败！");
        }
    }
}
