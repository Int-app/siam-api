package jp.co.siam.restapi.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.siam.restapi.entity.LoginUserInfoEntity;
import jp.co.siam.restapi.service.LoginService;

@RestController
@RequestMapping("/users")
public class LoginController {
  @Autowired
  LoginService loginService;

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginUserInfoEntity loginUserInfo) {
	  LoginUserInfoEntity userInfo = loginService
      .selectByPrimaryKey(loginUserInfo);
	  JSONObject data = new JSONObject();
	  data.put("code", 0);
	  JSONObject json = new JSONObject();
	  json.put("token", userInfo.getToken());
	  data.put("data", json);
	return ResponseEntity.ok(data.toString());
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
