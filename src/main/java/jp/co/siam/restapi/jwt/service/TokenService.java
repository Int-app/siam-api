package jp.co.siam.restapi.jwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jp.co.siam.restapi.entity.Employeeinfo;
import org.springframework.stereotype.Service;

/**
 * @author
 * @date 2020-05-26
 */

@Service
//写一个token的生成方法
public class TokenService {
    public String getToken(Employeeinfo employeeinfo) {
        String token="";
        // 存入需要保存在token的信息，这里把用户ID存入token
        token= JWT.create().withAudience(employeeinfo.getEmployeeid())
                .sign(Algorithm.HMAC256(employeeinfo.getPassword()));
        // 使用HMAC256生成token,密钥则是用户的密码
        return token;
    }
}
