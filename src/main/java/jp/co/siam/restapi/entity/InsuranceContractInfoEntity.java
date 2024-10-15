package jp.co.siam.restapi.entity;

import lombok.Data;

@Data
public class InsuranceContractInfoEntity {
	
  private String InsuranceCompanyId;
  
  private String InsurancePlanName;

  private String InsuranceContractNumber;
  
  private String CustomerNameKana;
  
  private String CustomerName;
  
  private String Relationship;
  
  private String InsuredNameKana;
  
  private String InsuredName;
  
  private String CustomerSex;
  
  private String CustomerBirthday;
  
  private String CustomerPhoneNumber;
  
  private String CustomerAddress;
  
  private String CustomerEmail;
  
  private String ContractDetail;
  
  private String ContractAmount;
  
  private String ContractDate;
  
  private String EmployeeId;

}
