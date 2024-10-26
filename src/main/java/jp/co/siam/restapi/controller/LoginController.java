package jp.co.siam.restapi.controller;

import jp.co.siam.restapi.common.ResponseCode;
import jp.co.siam.restapi.common.ResponseResult;
import jp.co.siam.restapi.entity.Employeeinfo;
import jp.co.siam.restapi.entity.Insurancecontractinfo;
import jp.co.siam.restapi.jwt.annotation.UserLoginToken;
import jp.co.siam.restapi.jwt.service.TokenService;
import jp.co.siam.restapi.service.EmployerService;
import jp.co.siam.restapi.service.InsuranceCompanyService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jp.co.siam.restapi.entity.LoginUserInfoEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class LoginController {

	@Autowired
	EmployerService employerService;

	@Autowired
	InsuranceCompanyService insuranceCompanyService;

	@Autowired
	TokenService tokenService;


	@PostMapping("/login")
	public ResponseResult login(@RequestBody LoginUserInfoEntity loginUserInfo) {
		Employeeinfo employeeInfo = employerService.getEmployeeinfo(loginUserInfo.getUsername());
		if(employeeInfo==null){
			return new ResponseResult(ResponseCode.FAIL, String.format("login fail,user %s not exist",loginUserInfo.getUsername()),null);
		}
		if (!employeeInfo.getPassword().equals(loginUserInfo.getPassword())){
			return new ResponseResult(ResponseCode.FAIL, "login fail,passwd is wrong",null);
		}


		String token = tokenService.getToken(employeeInfo);
		Map<String,String> data = new HashMap();
		data.put("token", token);
		data.put("employeeId",employeeInfo.getEmployeeid());
		data.put("introduceremployeeid",employeeInfo.getIntroduceremployeeid());
		data.put("role",employeeInfo.getRoleid());
		data.put("employeeName",employeeInfo.getEmployeename());
		String introduceremployeeName = getIntroducerEmployeeName(employeeInfo.getIntroduceremployeeid());
		data.put("introduceremployeeName",introduceremployeeName);
		return new ResponseResult(ResponseCode.SUCCESS, "login success",data);
  }

	private String getIntroducerEmployeeName(String introduceremployeeid) {
		Employeeinfo introduceremployeeinfo = employerService.getEmployeeinfo(introduceremployeeid);
		if(!Objects.isNull(introduceremployeeinfo)){
			return introduceremployeeinfo.getEmployeename();
		}else{
			return "";
		}
	}


  @GetMapping("/info")
  public ResponseEntity<String> info() {
	  JSONObject data = new JSONObject();
	  data.put("code", 0);
	  JSONObject json = new JSONObject();
	  json.put("username", "admin");
	  json.put("roles", getRoles("1"));
	  data.put("data", json);
	  data.put("message", "ユーザ情報を取得しました。");
	return ResponseEntity.ok(data.toString());
  }

	@UserLoginToken
	@GetMapping("/get_info")
	public ResponseResult getEmployeeInfo(@RequestParam("employeeId") String employeeId) {
		Employeeinfo employeeInfo = employerService.getEmployeeinfo(employeeId);
		return new ResponseResult(ResponseCode.SUCCESS, "success",employeeInfo);
	}

  private String getRoles(String code) {
	  String rolse="";
	  switch (code) {
	  case "1":
		  rolse="admin";
		  break;
	  case "2":
		  rolse="user";
		  break;
	  default:
		  rolse="user";
		  break;
	  }

	  return rolse;

  }
}
