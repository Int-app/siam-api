package jp.co.siam.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.siam.restapi.dao.LoginDao;
import jp.co.siam.restapi.entity.LoginUserInfoEntity;

@Service
public class LoginService {
	
	@Autowired
    LoginDao loginDao;

  public List<LoginUserInfoEntity> selectAll() {
    return loginDao.selectAll();
  }
  
  public LoginUserInfoEntity selectByPrimaryKey(LoginUserInfoEntity loginUserInfo) {
	  return loginDao.selectByPrimaryKey(loginUserInfo.getUsername());
  }
}
