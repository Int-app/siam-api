package jp.co.siam.restapi.entity;

import jp.co.siam.restapi.common.mybatis.PagingParameter;

public class InsurancecontractinfoFindParam extends PagingParameter {

    private String insuranceCompanyName;

    private String insurancecontractnumber;

    private String employeeId;

    private String employeeName;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getInsurancecontractnumber() {
        return insurancecontractnumber;
    }

    public void setInsurancecontractnumber(String insurancecontractnumber) {
        this.insurancecontractnumber = insurancecontractnumber;
    }


    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }
}
