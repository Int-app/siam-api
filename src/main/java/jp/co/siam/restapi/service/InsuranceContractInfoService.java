package jp.co.siam.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.siam.restapi.dao.InsuranceContractInfoDao;
import jp.co.siam.restapi.entity.InsuranceContractInfoEntity;

@Service
public class InsuranceContractInfoService {
	
	@Autowired
	InsuranceContractInfoDao insuranceContractInfoDao;

  public void create(InsuranceContractInfoEntity InsuranceContractInfo) {
	  insuranceContractInfoDao.create(InsuranceContractInfo);
  }
}
