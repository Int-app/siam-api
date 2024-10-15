package jp.co.siam.restapi.dao;

import org.apache.ibatis.annotations.Mapper;

import jp.co.siam.restapi.entity.InsuranceContractInfoEntity;

@Mapper
public interface InsuranceContractInfoDao{
	
	/*
	 * 新規保険契約
	 */
	  public void create(InsuranceContractInfoEntity insuranceContractInfo);
	  
}
