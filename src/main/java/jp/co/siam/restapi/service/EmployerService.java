package jp.co.siam.restapi.service;

import jp.co.siam.restapi.dao.EmployeeinfoMapper;
import jp.co.siam.restapi.dao.InsurancecontractinfoMapper;
import jp.co.siam.restapi.entity.Employeeinfo;
import jp.co.siam.restapi.entity.EmployeeinfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class EmployerService {
    @Autowired
    EmployeeinfoMapper employeeinfoMapper;

    public Employeeinfo getEmployeeinfo(String employeeId){
        EmployeeinfoExample example = new EmployeeinfoExample();
        example.or().andEmployeeidEqualTo(employeeId);
        List<Employeeinfo> employeeinfos = employeeinfoMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(employeeinfos)){
            return null;
        }else{
            return employeeinfos.get(0);
        }
    }

    public List<Employeeinfo> getEmployeeInfos(){
        EmployeeinfoExample example = new EmployeeinfoExample();
        return employeeinfoMapper.selectByExample(example);
    }
}
