package jp.co.siam.restapi.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.siam.restapi.common.ResponseCode;
import jp.co.siam.restapi.common.ResponseResult;
import jp.co.siam.restapi.entity.Employeeinfo;
import jp.co.siam.restapi.service.EmployerService;

@RestController
@Api(tags = "insurancecompany interface")
@RequestMapping("/employeeinfo")
public class EmployeeInfoController {

    @Autowired
    EmployerService employerService;

    @PostMapping("/list")
    @ApiOperation("list")
    public ResponseResult<Map> getEmployeeInfo() {
        List<Employeeinfo> insuranceemplyoeeinfo = employerService.getEmployeeInfos();
        List<Map> viewMaps = insuranceemplyoeeinfo.stream().sorted(Comparator.comparing(Employeeinfo::getEmployeeid))
                .map(t->{
                    HashMap viewMap = new HashMap();
                    viewMap.put("value",t.getEmployeeid());
                    viewMap.put("text",t.getEmployeename());
                    return viewMap;
                })
                .collect(Collectors.toList());
        return new ResponseResult(ResponseCode.SUCCESS, "",viewMaps);
    }
}
