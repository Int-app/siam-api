package jp.co.siam.restapi.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jp.co.siam.restapi.dao.InsurancecontractinfoMapper;
import jp.co.siam.restapi.entity.*;
import jp.co.siam.restapi.validation.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@Service
public class InsuranceContractInfoService {
//
//	@Autowired
//	InsuranceContractInfoDao insuranceContractInfoDao;

	@Autowired
	InsurancecontractinfoMapper insurancecontractinfoMapper;

//  public void create(InsuranceContractInfoEntity InsuranceContractInfo) {
//	  insuranceContractInfoDao.create(InsuranceContractInfo);
//  }

  public List<InsurancecontractinfoWithBLOBs> getInsurancecontractinfoLists(InsurancecontractinfoWithBLOBs insurancecontractinfo){
	  InsurancecontractinfoExample example = new InsurancecontractinfoExample();
	  List<InsurancecontractinfoWithBLOBs> insurancecontractinfos = insurancecontractinfoMapper.selectByExampleWithBLOBs(example);
	  return insurancecontractinfos;
  }

	public int updateInsurancecontractinfo(InsurancecontractinfoWithBLOBs insurancecontractinfo) {
		String errors = ValidationUtils.validate(insurancecontractinfo);
		if (errors != null) {
			throw new ValidationException(errors);
		}
  		InsurancecontractinfoExample example = new InsurancecontractinfoExample();
		example.or()
				.andInsurancecompanyidEqualTo(insurancecontractinfo.getInsurancecompanyid())
				.andInsurancecontractnumberEqualTo(insurancecontractinfo.getInsurancecontractnumber());
		return insurancecontractinfoMapper.updateByExampleSelective(insurancecontractinfo,example);
	}

	public List<InsurancecontractinfoWithBLOBs> getInsuranceContractInfo(InsurancecontractinfoWithBLOBs insurancecontractinfo) {
		String errors = ValidationUtils.validate(insurancecontractinfo);
		if (errors != null) {
			throw new ValidationException(errors);
		}
		InsurancecontractinfoExample example = new InsurancecontractinfoExample();
		example.or()
				.andInsurancecompanyidEqualTo(insurancecontractinfo.getInsurancecompanyid())
				.andInsurancecontractnumberEqualTo(insurancecontractinfo.getInsurancecontractnumber());
		List<InsurancecontractinfoWithBLOBs> insurancecontractinfoWithBLOBs = insurancecontractinfoMapper.selectByExampleWithBLOBs(example);
		return insurancecontractinfoWithBLOBs;
	}

	public PageInfo<InsurancecontractinfoWithBLOBs> getInsuranceContractInfoByPage(InsurancecontractinfoFindParam findParam) {
		findParam.init();
		PageHelper.startPage(findParam.getPageNum(), findParam.getPageSize());
		List<InsurancecontractinfoWithBLOBs> insurancecontractinfoWithBLOBs = insurancecontractinfoMapper.selectByFindParam(findParam);
		return new PageInfo(insurancecontractinfoWithBLOBs);
	}

	public int deleteInsuranceContractInfo(InsurancecontractinfoWithBLOBs insurancecontractinfo) {
		String errors = ValidationUtils.validate(insurancecontractinfo);
		if (errors != null) {
			throw new ValidationException(errors);
		}
		InsurancecontractinfoExample example = new InsurancecontractinfoExample();
		example.or()
				.andInsurancecompanyidEqualTo(insurancecontractinfo.getInsurancecompanyid())
				.andInsurancecontractnumberEqualTo(insurancecontractinfo.getInsurancecontractnumber());
		return insurancecontractinfoMapper.deleteByExample(example);
	}

	public int createInsuranceContractInfo(InsurancecontractinfoWithBLOBs insurancecontractinfo) {
		String errors = ValidationUtils.validate(insurancecontractinfo);
		if (errors != null) {
			throw new ValidationException(errors);
		}
		return insurancecontractinfoMapper.insertSelective(insurancecontractinfo);
  }
}
