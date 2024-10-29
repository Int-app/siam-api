package jp.co.siam.restapi.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jp.co.siam.restapi.dao.InsurancecontractinfoMapper;
import jp.co.siam.restapi.entity.*;
import jp.co.siam.restapi.validation.ValidationUtils;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.validation.ValidationException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InsuranceContractInfoService {

	@Autowired
	InsurancecontractinfoMapper insurancecontractinfoMapper;

	@Autowired
	InsuranceCompanyService insuranceCompanyService;

	@Autowired
	EmployerService employerService;


	public int updateInsurancecontractinfo(Insurancecontractinfo insurancecontractinfo) {
		String errors = ValidationUtils.validate(insurancecontractinfo);
		if (errors != null) {
			throw new ValidationException(errors);
		}
		insurancecontractinfo.setUpdatedby(insurancecontractinfo.getEmployeeid());
		insurancecontractinfo.setUpdateddate(new Date());
  		InsurancecontractinfoExample example = new InsurancecontractinfoExample();
		example.or()
				.andInsurancecontractidEqualTo(insurancecontractinfo.getInsurancecontractid());
		return insurancecontractinfoMapper.updateByExampleSelective(insurancecontractinfo,example);
	}


	public PageInfo<Insurancecontractinfo> getInsuranceContractInfoByPage(InsurancecontractinfoFindParam findParam) {
		findParam.init();
		Page page =PageHelper.startPage(findParam.getPageNum(), findParam.getPageSize());
		List<Insurancecontractinfo> insurancecontractinfos = insurancecontractinfoMapper.selectByFindParam(findParam);

		List<Insurancecompany> insurancecompanies = insuranceCompanyService.getList();
		Map<String,String> companyMap = insurancecompanies.stream()
				.collect(Collectors.toMap(Insurancecompany::getInsuranceCompanyId,Insurancecompany::getInsuranceCompanyName));


		List<Employeeinfo> employeeinfos = employerService.getEmployeeInfos();
		Map<String,String> employeeMap = employeeinfos.stream().collect(Collectors.toMap(Employeeinfo::getEmployeeid,Employeeinfo::getEmployeename));

		insurancecontractinfos = insurancecontractinfos.stream().peek(t->{
			t.setInsurancecompanyName(companyMap.get(t.getInsurancecompanyid()));
			t.setEmployeeName(employeeMap.get(t.getEmployeeid()));
			t.setTeamemployeeName(employeeMap.get(t.getTeamemployeeName()));
		}).collect(Collectors.toList());
		PageInfo<Insurancecontractinfo> result = new PageInfo(insurancecontractinfos);
		result.setPageNum(findParam.getPageNum());
		result.setPageSize(findParam.getPageSize());
		result.setTotal(page.getTotal());
		return result;
	}

	public int deleteInsuranceContractInfo(Integer insurancecontractid) {
		InsurancecontractinfoExample example = new InsurancecontractinfoExample();
		example.or()
				.andInsurancecontractidEqualTo(insurancecontractid);
		Insurancecontractinfo info = new Insurancecontractinfo();
		info.setDeleteflag(1);
		info.setUpdateddate(new Date());
		info.setInsurancecontractid(insurancecontractid);
		return insurancecontractinfoMapper.updateByExampleSelective(info,example);
	}

	public int createInsuranceContractInfo(Insurancecontractinfo insurancecontractinfo) {
		String errors = ValidationUtils.validate(insurancecontractinfo);
		if (errors != null) {
			throw new ValidationException(errors);
		}
		insurancecontractinfo.setDeleteflag(0);
		insurancecontractinfo.setCreatedby(insurancecontractinfo.getEmployeeid());
		insurancecontractinfo.setCreateddate(new Date());
		insurancecontractinfo.setUpdatedby(insurancecontractinfo.getEmployeeid());
		insurancecontractinfo.setUpdateddate(new Date());
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
