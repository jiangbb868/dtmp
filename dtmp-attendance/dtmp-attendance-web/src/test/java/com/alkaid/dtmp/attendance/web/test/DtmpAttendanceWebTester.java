package com.alkaid.dtmp.attendance.web.test;

import com.alkaid.dtmp.attendance.dao.model.WorkOvertime;
import com.alkaid.dtmp.attendance.web.controller.WorkOvertimeController;
import com.sun.glass.ui.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DtmpAttendanceWebTester {

    @Test
    public void addWorkOvertime() throws Exception {
        RestTemplate testRestTemplate = new RestTemplate();
        WorkOvertime workOvertime = new WorkOvertime();
        workOvertime.setUserId(1);
        workOvertime.setDate(new Date());
        workOvertime.setStartTime(new Date());
        workOvertime.setStopTime(new Date());
        workOvertime.setReason("开发测试");
        ResponseEntity<String> result = testRestTemplate.postForEntity("http://localhost:9003/work/overtime/add", workOvertime, String.class);
        String body = result.getBody();
    }

    @Test
    public void getWorkOvertime() throws Exception {
        RestTemplate testRestTemplate = new RestTemplate();
        Map<String,String> multiValueMap = new HashMap<>();
        multiValueMap.put("workOvertimeId","1");//传值，但要在url上配置相应的参数
        ResponseEntity<String> result = testRestTemplate.getForEntity("http://localhost:9003/work/overtime/get?workOvertimeId={1}",String.class,"1");
        Assert.assertEquals(result.getStatusCode(),0);
    }

    @Test
    public void deleteWorkOvertime() throws Exception {
        RestTemplate testRestTemplate = new RestTemplate();
        WorkOvertime workOvertime = new WorkOvertime();
        workOvertime.setWorkovertimeId(1);
        ResponseEntity<String> result = testRestTemplate.postForEntity("http://localhost:9003/work/overtime/delete", workOvertime, String.class);
        String body = result.getBody();
    }


}
