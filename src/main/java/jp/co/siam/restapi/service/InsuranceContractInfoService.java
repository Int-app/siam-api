package jp.co.siam.restapi.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jp.co.siam.restapi.dao.InsurancecontractinfoMapper;
import jp.co.siam.restapi.entity.*;
import jp.co.siam.restapi.validation.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@Service
public class InsuranceContractInfoService {

	@Autowired
	InsurancecontractinfoMapper insurancecontractinfoMapper;


	public int updateInsurancecontractinfo(Insurancecontractinfo insurancecontractinfo) {
		String errors = ValidationUtils.validate(insurancecontractinfo);
		if (errors != null) {
			throw new ValidationException(errors);
		}
  		InsurancecontractinfoExample example = new InsurancecontractinfoExample();
		example.or()
				.andInsurancecontractidEqualTo(insurancecontractinfo.getInsurancecontractid());
		return insurancecontractinfoMapper.updateByExampleSelective(insurancecontractinfo,example);
	}


	public PageInfo<Insurancecontractinfo> getInsuranceContractInfoByPage(InsurancecontractinfoFindParam findParam) {
		findParam.init();
		PageHelper.startPage(findParam.getPageNum(), findParam.getPageSize());
		List<Insurancecontractinfo> insurancecontractinfoWithBLOBs = insurancecontractinfoMapper.selectByFindParam(findParam);
		return new PageInfo(insurancecontractinfoWithBLOBs);
	}

	public int deleteInsuranceContractInfo(Integer insurancecontractid) {
		InsurancecontractinfoExample example = new InsurancecontractinfoExample();
		example.or()
				.andInsurancecontractidEqualTo(insurancecontractid);
		return insurancecontractinfoMapper.deleteByExample(example);
	}

	public int createInsuranceContractInfo(Insurancecontractinfo insurancecontractinfo) {
		String errors = ValidationUtils.validate(insurancecontractinfo);
		if (errors != null) {
			throw new ValidationException(errors);
		}
		return insurancecontractinfoMapper.insertSelective(insurancecontractinfo);
  }

	public Insurancecontractinfo getInsurancecontractinfo(Integer insurancecontractid) {
		InsurancecontractinfoExample example = new InsurancecontractinfoExample();
		example.or().andInsurancecontractidEqualTo(insurancecontractid);
		List<Insurancecontractinfo> insurancecontractinfos = insurancecontractinfoMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(insurancecontractinfos)){
			return null;
		}else{
			return insurancecontractinfos.get(0);
		}
	}
}
