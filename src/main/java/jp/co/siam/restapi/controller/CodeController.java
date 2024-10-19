package jp.co.siam.restapi.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.siam.restapi.common.ResponseCode;
import jp.co.siam.restapi.common.ResponseResult;
import jp.co.siam.restapi.entity.Code;
import jp.co.siam.restapi.entity.Insurancecontractinfo;
import jp.co.siam.restapi.entity.InsurancecontractinfoFindParam;
import jp.co.siam.restapi.service.CodeService;
import jp.co.siam.restapi.service.InsuranceContractInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Api(tags = "code interface")
@RequestMapping("/code")
public class CodeController {

  @Autowired
  CodeService codeService;

   @PostMapping("/list")
   @ApiOperation("list")
    public ResponseResult<Map> getInsuranceContractInfos(@RequestBody Code code) {
       List<Code> codes = codeService.getList(code);
       List<Map> maps = codes.stream().sorted(Comparator.comparingInt(Code::getDisplayOrder))
               .map(t->{
                   HashMap toMap = new HashMap();
                   toMap.put("value",t.getValue());
                   toMap.put("text",t.getDisplayText());
                   toMap.put("displayOrder",t.getDisplayOrder());
                   return toMap;
               })
               .collect(Collectors.toList());
        return new ResponseResult(ResponseCode.SUCCESS, "",maps);
    }

}
