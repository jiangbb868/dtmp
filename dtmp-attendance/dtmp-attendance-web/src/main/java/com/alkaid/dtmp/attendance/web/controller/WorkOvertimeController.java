package com.alkaid.dtmp.attendance.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alkaid.dtmp.attendance.api.WorkOvertimeService;
import com.alkaid.dtmp.attendance.dao.model.WorkOvertime;
import com.alkaid.dtmp.common.constants.DtmpConstants;
import com.alkaid.dtmp.common.pojo.DtmpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/work/overtime")
public class WorkOvertimeController {

    @Reference(version = DtmpConstants.DTMP_ATTENDANCE_WORKOVERTIME_VERSION)
    WorkOvertimeService workOvertimeService;

    @PostMapping(value="/add")
    @ResponseBody
    public DtmpResult addWorkOvertime(WorkOvertime workOvertime) {
        return workOvertimeService.setWorkOvertime(workOvertime);
    }

    @PostMapping(value="/delete")
    @ResponseBody
    public DtmpResult deleteWorkOvertime(int workOvertimeId) {
        DtmpResult dtmpResult = workOvertimeService.deleteWorkOvertime(workOvertimeId);
        return dtmpResult;
    }

    @GetMapping(value = "/get")
    @ResponseBody
    public DtmpResult getWorkOvertime(int workOvertimeId) {
        WorkOvertime workOvertime = workOvertimeService.getWorkOvertime(workOvertimeId);
        if (workOvertime != null) {
            return new DtmpResult(200, "success", workOvertime);
        } else {
            return new DtmpResult(400, "error", "加班不存在！");
        }
    }

    @GetMapping(value = "/getList")
    @ResponseBody
    public DtmpResult getWorkOvertimeList(Date date, int userId) {
        List<WorkOvertime> list = workOvertimeService.getWorkOvertime(date, userId);
        if (list != null && list.size() > 0) {
            return new DtmpResult(200, "success", list);
        } else {
            return new DtmpResult(400, "error", "加班不存在！");
        }
    }
}
