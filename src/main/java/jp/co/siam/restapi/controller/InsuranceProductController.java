package jp.co.siam.restapi.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.siam.restapi.common.ResponseCode;
import jp.co.siam.restapi.common.ResponseResult;
import jp.co.siam.restapi.entity.Code;
import jp.co.siam.restapi.entity.Insurancecontractinfo;
import jp.co.siam.restapi.entity.InsurancecontractinfoFindParam;
import jp.co.siam.restapi.entity.Insuranceproduct;
import jp.co.siam.restapi.service.CodeService;
import jp.co.siam.restapi.service.InsuranceContractInfoService;
import jp.co.siam.restapi.service.InsuranceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Api(tags = "insuranceproduct interface")
@RequestMapping("/insuranceproduct")
public class InsuranceProductController {

    @Autowired
    InsuranceProductService insuranceProductService;

    @PostMapping("/list/{insuranceCompanyId}")
    @ApiOperation("list")
    public ResponseResult<Map> getInsuranceContractInfos(@PathVariable("insuranceCompanyId") String insuranceCompanyId) {
        List<Insuranceproduct> insuranceproducts = insuranceProductService.getList(insuranceCompanyId);
        List<Map> maps = insuranceproducts.stream().sorted(Comparator.comparing(Insuranceproduct::getProductName))
                .map(t->{
                    HashMap toMap = new HashMap();
                    toMap.put("value",t.getProductId());
                    toMap.put("text",t.getProductName());
                    return toMap;
                })
                .collect(Collectors.toList());
        return new ResponseResult(ResponseCode.SUCCESS, "",maps);
    }
}
