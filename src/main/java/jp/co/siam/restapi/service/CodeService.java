package jp.co.siam.restapi.service;

import jp.co.siam.restapi.dao.CodeMapper;
import jp.co.siam.restapi.entity.Code;
import jp.co.siam.restapi.entity.CodeExample;
import jp.co.siam.restapi.entity.InsurancecontractinfoExample;
import jp.co.siam.restapi.validation.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CodeService {

    @Autowired
    CodeMapper codeMapper;

    public List<Code> getList(Code code){
        String errors = ValidationUtils.validate(code);
        if (errors != null) {
            throw new ValidationException(errors);
        }
        CodeExample example = new CodeExample();
        example.or()
                .andBusinessIdEqualTo(code.getBusinessId()).andCodeLv1EqualTo(code.getCodeLv1());
        List<Code> codes = codeMapper.selectByExample(example);
        return codes;

    }
}
