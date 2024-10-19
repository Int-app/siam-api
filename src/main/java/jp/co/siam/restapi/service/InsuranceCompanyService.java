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

@Service
public class InsuranceCompanyService {

    @Autowired
    InsurancecompanyMapper insurancecompanyMapper;

    public List<Insurancecompany> getList(){
        InsurancecompanyExample example = new InsurancecompanyExample();
        return insurancecompanyMapper.selectByExample(example);
    }
}
