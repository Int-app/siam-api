package jp.co.siam.restapi.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.siam.restapi.common.ResponseCode;
import jp.co.siam.restapi.common.ResponseResult;
import jp.co.siam.restapi.entity.Insurancecontractinfo;
import jp.co.siam.restapi.entity.InsurancecontractinfoFindParam;
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

   @GetMapping("/get/{insurancecontractid}")
   @ApiOperation("get")
    public ResponseResult getInsuranceContractInfos( @PathVariable("insurancecontractid") Integer insurancecontractid) {
        Insurancecontractinfo insurancecontractinfo= insuranceContractInfoService.getInsurancecontractinfo(insurancecontractid);
        return new ResponseResult(ResponseCode.SUCCESS, "",insurancecontractinfo);
    }

    @GetMapping("/get_list_bypage")
    @ApiOperation("get_list_bypage")
    public ResponseResult getInsuranceContractInfosByPage(@RequestBody InsurancecontractinfoFindParam findParam) {

        PageInfo<Insurancecontractinfo> insurancecontractinfos= insuranceContractInfoService.getInsuranceContractInfoByPage(findParam);
        return new ResponseResult(ResponseCode.SUCCESS, "",insurancecontractinfos);
    }

    @PutMapping("/update")
    @ApiOperation("update")
    public ResponseResult updateInsuranceContractInfo(@RequestBody Insurancecontractinfo insurancecontractinfo) {
          int count= insuranceContractInfoService.updateInsurancecontractinfo(insurancecontractinfo);
          return new ResponseResult(ResponseCode.SUCCESS, "",count);
    }

    @DeleteMapping("/delete/{insurancecontractid}")
    @ApiOperation("delete")
    public ResponseResult deleteInsuranceContractInfo( @PathVariable("insurancecontractid") Integer insurancecontractid) {
        int count= insuranceContractInfoService.deleteInsuranceContractInfo(insurancecontractid);
        return new ResponseResult(ResponseCode.SUCCESS, "",count);
    }

    @PostMapping("/create")
    @ApiOperation("create")
    public ResponseResult createInsuranceContractInfo(@RequestBody Insurancecontractinfo insurancecontractinfo) {
        int count= insuranceContractInfoService.createInsuranceContractInfo(insurancecontractinfo);
        return new ResponseResult(ResponseCode.SUCCESS, "",count);
    }
}
