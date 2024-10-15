package jp.co.siam.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.siam.restapi.entity.InsuranceContractInfoEntity;
import jp.co.siam.restapi.service.InsuranceContractInfoService;

@RestController
@RequestMapping("/insurance")
public class InsuranceContractInfoController {
  @Autowired
  InsuranceContractInfoService insuranceContractInfoService;

  @PostMapping("/create")
  public ResponseEntity<String> create(@RequestBody InsuranceContractInfoEntity insuranceContractInfo) {
	  insuranceContractInfoService.create(insuranceContractInfo);
	return ResponseEntity.ok("");
  }
}
