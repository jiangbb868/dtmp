package com.alkaid.dtmp.attendance.web.controller;

import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alkaid.dtmp.attendance.api.WorkOvertimeService;
import com.alkaid.dtmp.attendance.dao.model.WorkOvertime;
import com.alkaid.dtmp.common.constants.DtmpConstants;
import com.alkaid.dtmp.common.pojo.DtmpResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/work/overtime")
public class WorkOvertimeController {

    @Reference(version = DtmpConstants.DTMP_ATTENDANCE_WORKOVERTIME_VERSION)
    WorkOvertimeService workOvertimeService;

    @PostMapping(value="/add")
    @ResponseBody
    public DtmpResult addWorkOvertime(@RequestBody Map<String,String> data) {
        if (data.size() == 0) {
            return new DtmpResult(400, "error", "参数不存在！");
        }
        if (!data.containsKey("userId") && !data.containsKey("startTime") &&
            !data.containsKey("stopTime") && !data.containsKey("date")) {
            return new DtmpResult(400, "error", "必要参数不完整！");
        }
        WorkOvertime workOvertime = new WorkOvertime();
        workOvertime.setUserId(Integer.valueOf(data.get("userId")));
        workOvertime.setReason(data.get("reason"));
        workOvertime.setDate(new java.util.Date());
        workOvertime.setStartTime(new java.util.Date());
        workOvertime.setStopTime(new java.util.Date());
        return workOvertimeService.setWorkOvertime(workOvertime);
    }

    @PostMapping(value="/delete")
    @ResponseBody
    public DtmpResult deleteWorkOvertime(@RequestBody Map<String,String> data) {
        if (data.size() == 0) {
            return new DtmpResult(400, "error", "参数不存在！");
        }
        int workOvertimeId = Integer.valueOf(data.get("workOvertimeId"));
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
    public DtmpResult getWorkOvertimeList(Date date, Integer userId) {
        List<WorkOvertime> list = workOvertimeService.getWorkOvertime(date, userId);
        if (list != null && list.size() > 0) {
            return new DtmpResult(200, "success", list);
        } else {
            return new DtmpResult(400, "error", "加班不存在！");
        }
    }
}
