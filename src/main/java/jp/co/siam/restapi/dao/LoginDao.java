package jp.co.siam.restapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.siam.restapi.entity.LoginUserInfoEntity;

@Mapper
public interface LoginDao{
	
	/*
	 * すべてユーザ取得 
	 */
	  List<LoginUserInfoEntity> selectAll();
	  
	/*
	 * ログインユーザ取得 
	 */
	  LoginUserInfoEntity selectByPrimaryKey(String Username);
}
