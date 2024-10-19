package jp.co.siam.restapi.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.siam.restapi.common.ResponseCode;
import jp.co.siam.restapi.common.ResponseResult;
import jp.co.siam.restapi.entity.Code;
import jp.co.siam.restapi.entity.Insurancecompany;
import jp.co.siam.restapi.entity.Insurancecontractinfo;
import jp.co.siam.restapi.entity.InsurancecontractinfoFindParam;
import jp.co.siam.restapi.service.CodeService;
import jp.co.siam.restapi.service.InsuranceCompanyService;
import jp.co.siam.restapi.service.InsuranceContractInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Api(tags = "insurancecompany interface")
@RequestMapping("/insurancecompany")
public class InsuranceCompanyController {

    @Autowired
    InsuranceCompanyService insuranceCompanyService;

    @PostMapping("/list")
    @ApiOperation("list")
    public ResponseResult<Map> getInsuranceContractInfos() {
        List<Insurancecompany> insurancecompanies = insuranceCompanyService.getList();
        List<Map> viewMaps = insurancecompanies.stream().sorted(Comparator.comparing(Insurancecompany::getInsuranceCompanyName))
                .map(t->{
                    HashMap viewMap = new HashMap();
                    viewMap.put("value",t.getInsuranceCompanyId());
                    viewMap.put("text",t.getInsuranceCompanyName());
                    return viewMap;
                })
                .collect(Collectors.toList());
        return new ResponseResult(ResponseCode.SUCCESS, "",viewMaps);
    }
}
