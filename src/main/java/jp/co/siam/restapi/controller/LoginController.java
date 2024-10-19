package jp.co.siam.restapi.controller;

import jp.co.siam.restapi.common.ResponseCode;
import jp.co.siam.restapi.common.ResponseResult;
import jp.co.siam.restapi.entity.Employeeinfo;
import jp.co.siam.restapi.jwt.annotation.UserLoginToken;
import jp.co.siam.restapi.jwt.service.TokenService;
import jp.co.siam.restapi.service.EmployerService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jp.co.siam.restapi.entity.LoginUserInfoEntity;
import jp.co.siam.restapi.service.LoginService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class LoginController {
  @Autowired
  LoginService loginService;

	@Autowired
	EmployerService employerService;

	@Autowired
	TokenService tokenService;


//  @PostMapping("/login")
//  public ResponseEntity<String> login(@RequestBody LoginUserInfoEntity loginUserInfo) {
//	  LoginUserInfoEntity userInfo = loginService
//      .selectByPrimaryKey(loginUserInfo);
//	  JSONObject data = new JSONObject();
//	  data.put("code", 0);
//	  JSONObject json = new JSONObject();
//	  json.put("token", userInfo.getToken());
//	  data.put("data", json);
//	return ResponseEntity.ok(data.toString());
//  }

	@PostMapping("/login")
	public ResponseResult loginv2(@RequestParam("employeeId") String employeeId, @RequestParam("passwd") String passwd) {
		Employeeinfo employeeInfo = employerService.getEmployeeinfo(employeeId);
		if(employeeInfo==null){
			return new ResponseResult(ResponseCode.FAIL, String.format("login fail,user %s not exist",employeeId),null);
		}
		if (!employeeInfo.getPassword().equals(passwd)){
			return new ResponseResult(ResponseCode.FAIL, "login fail,passwd is wrong",null);
		}

		String token = tokenService.getToken(employeeInfo);
		Map data = new HashMap();
		data.put("token", token);
		return new ResponseResult(ResponseCode.SUCCESS, "login success",data);
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
