package jp.co.siam.restapi.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.siam.restapi.common.ResponseCode;
import jp.co.siam.restapi.common.ResponseResult;
import jp.co.siam.restapi.entity.InsurancecontractinfoFindParam;
import jp.co.siam.restapi.entity.InsurancecontractinfoWithBLOBs;
import jp.co.siam.restapi.service.InsuranceContractInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "insurance interface")
@RequestMapping("/insurance")
public class InsuranceContractInfoController {

  @Autowired
  InsuranceContractInfoService insuranceContractInfoService;

   @GetMapping("/get_list")
   @ApiOperation("get_list")
    public ResponseResult getInsuranceContractInfos(@RequestBody InsurancecontractinfoWithBLOBs insurancecontractinfo) {
        List<InsurancecontractinfoWithBLOBs> insurancecontractinfos= insuranceContractInfoService.getInsurancecontractinfoLists(insurancecontractinfo);
        return new ResponseResult(ResponseCode.SUCCESS, "",insurancecontractinfos);
    }

    @GetMapping("/get_list_bypage")
    @ApiOperation("get_list_bypage")
    public ResponseResult getInsuranceContractInfosByPage(@RequestBody InsurancecontractinfoFindParam findParam) {
       
        PageInfo<InsurancecontractinfoWithBLOBs> insurancecontractinfos= insuranceContractInfoService.getInsuranceContractInfoByPage(findParam);
        return new ResponseResult(ResponseCode.SUCCESS, "",insurancecontractinfos);
    }
    @GetMapping("/get")
    @ApiOperation("get")
    public ResponseResult getInsuranceContractInfo(@RequestBody InsurancecontractinfoWithBLOBs insurancecontractinfo) {
          List<InsurancecontractinfoWithBLOBs> insurancecontractinfoWithBLOBs = insuranceContractInfoService.getInsuranceContractInfo(insurancecontractinfo);
          return new ResponseResult(ResponseCode.SUCCESS, "",insurancecontractinfoWithBLOBs);
    }

    @PutMapping("/update")
    @ApiOperation("update")
    public ResponseResult updateInsuranceContractInfo(@RequestBody InsurancecontractinfoWithBLOBs insurancecontractinfo) {
          int count= insuranceContractInfoService.updateInsurancecontractinfo(insurancecontractinfo);
          return new ResponseResult(ResponseCode.SUCCESS, "",count);
    }

    @DeleteMapping("/delete")
    @ApiOperation("delete")
    public ResponseResult deleteInsuranceContractInfo(@RequestBody InsurancecontractinfoWithBLOBs insurancecontractinfo) {
        int count= insuranceContractInfoService.deleteInsuranceContractInfo(insurancecontractinfo);
        return new ResponseResult(ResponseCode.SUCCESS, "",count);
    }

    @PostMapping("/create")
    @ApiOperation("create")
    public ResponseResult createInsuranceContractInfo(@RequestBody InsurancecontractinfoWithBLOBs insurancecontractinfo) {
        int count= insuranceContractInfoService.createInsuranceContractInfo(insurancecontractinfo);
        return new ResponseResult(ResponseCode.SUCCESS, "",count);
    }
}
