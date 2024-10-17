package jp.co.siam.restapi.entity;

import jp.co.siam.restapi.common.mybatis.PagingParameter;

public class InsurancecontractinfoFindParam extends PagingParameter {
    private Integer insurancecompanyid;

    private String insurancecontractnumber;

    public Integer getInsurancecompanyid() {
        return insurancecompanyid;
    }

    public void setInsurancecompanyid(Integer insurancecompanyid) {
        this.insurancecompanyid = insurancecompanyid;
    }

    public String getInsurancecontractnumber() {
        return insurancecontractnumber;
    }

    public void setInsurancecontractnumber(String insurancecontractnumber) {
        this.insurancecontractnumber = insurancecontractnumber;
    }
}
