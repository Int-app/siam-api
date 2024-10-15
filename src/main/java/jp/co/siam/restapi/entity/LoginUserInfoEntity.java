package jp.co.siam.restapi.entity;

import lombok.Data;

@Data
public class LoginUserInfoEntity {

  private String Username;
  
  private String Password;

  private String Role;
  
  private String Token;
}