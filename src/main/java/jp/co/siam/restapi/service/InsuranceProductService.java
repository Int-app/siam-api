package jp.co.siam.restapi.service;

import jp.co.siam.restapi.dao.InsurancecompanyMapper;
import jp.co.siam.restapi.dao.InsuranceproductMapper;
import jp.co.siam.restapi.entity.Insurancecompany;
import jp.co.siam.restapi.entity.InsurancecompanyExample;
import jp.co.siam.restapi.entity.Insuranceproduct;
import jp.co.siam.restapi.entity.InsuranceproductExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceProductService {

    @Autowired
    InsuranceproductMapper insuranceProductMapper;

    public List<Insuranceproduct> getList(String insuranceCompanyId){
        InsuranceproductExample example = new InsuranceproductExample();
        example.or().andInsuranceCompanyIdEqualTo(insuranceCompanyId);
        List<Insuranceproduct> insuranceproducts = insuranceProductMapper.selectByExample(example);
        return insuranceproducts;
    }
}
