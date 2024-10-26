package jp.co.siam.restapi.service;

import jp.co.siam.restapi.dao.CodeMapper;
import jp.co.siam.restapi.dao.InsurancecompanyMapper;
import jp.co.siam.restapi.entity.Code;
import jp.co.siam.restapi.entity.CodeExample;
import jp.co.siam.restapi.entity.Insurancecompany;
import jp.co.siam.restapi.entity.InsurancecompanyExample;
import jp.co.siam.restapi.validation.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InsuranceCompanyService {

    @Autowired
    InsurancecompanyMapper insurancecompanyMapper;

    public List<Insurancecompany> getList(){
        InsurancecompanyExample example = new InsurancecompanyExample();
        return insurancecompanyMapper.selectByExample(example);
    }

    public Map<String,String> getCompanyMap(){
        InsurancecompanyExample example = new InsurancecompanyExample();
        List<Insurancecompany> insurancecompanies = insurancecompanyMapper.selectByExample(example);
        return insurancecompanies.stream().collect(Collectors.toMap(Insurancecompany::getInsuranceCompanyId,Insurancecompany::getInsuranceCompanyName));
    }
}
