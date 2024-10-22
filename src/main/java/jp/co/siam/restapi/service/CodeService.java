package jp.co.siam.restapi.service;

import jp.co.siam.restapi.dao.CodeMapper;
import jp.co.siam.restapi.entity.Code;
import jp.co.siam.restapi.entity.CodeExample;
import jp.co.siam.restapi.entity.InsurancecontractinfoExample;
import jp.co.siam.restapi.entity.ZipCodeDto;
import jp.co.siam.restapi.jwt.interceptor.ResponseHeaderInterceptor;
import jp.co.siam.restapi.validation.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.ValidationException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CodeService {

    @Autowired
    CodeMapper codeMapper;

    private final RestTemplate restTemplate;

    public CodeService(RestTemplateBuilder restTemplateBuilder,
                               ResponseHeaderInterceptor interceptor) {  // (1)
        restTemplate = restTemplateBuilder
                .rootUri("http://zipcloud.ibsnet.co.jp")
                .additionalInterceptors(interceptor)
                .build();
    }

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

    public ZipCodeDto request(String zipCode) {
        return restTemplate.getForObject("/api/search?zipcode={zipCode}",  // (2)
                ZipCodeDto.class,
                zipCode);
    }
}
