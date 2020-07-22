package com.mg.website.action; 

import com.alibaba.fastjson.JSONObject;
import com.mg.website.common.mapper.GeneralMapper;
import com.mg.website.pojo.vo.UserVo;
import com.mg.website.pojo.dto.InUserDto;
import com.mg.website.pojo.dto.InUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.website.service.repository.UserRepository;
import com.mg.website.constant.action.UserControllerConstant;
import org.springframework.web.bind.annotation.RequestBody;
import com.mg.common.pojo.ResultItem;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;

@Slf4j
@RestController
public class UserController {
   @Autowired
   UserRepository repository;
   @Autowired
   GeneralMapper mapper;

   @RequestMapping(UserControllerConstant.ACTION_GET)
   @PreAuthorize("hasAnyAuthority('admin ')")
   public ResultItem get(@RequestBody UserVo voData) throws Exception{
      OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
      String token = details.getTokenValue();//.trim();
      String key =
              "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjOHeX0BnvWd6qTILwSYhpX7E3xAvv4uDcg6iHeJmlDmJXzzKqIhbHwJsPcqlSj282qN8P/7bUp79xMu2o5FUy2ES0gzMR1aCKfBviv9zBJ5lRPcs/TogOmtdycok5krdEkrFPMTcLYvCEw9DXo0sxK/k0USvn5gS1MSBTkvTxHGEGtxkg0jXJxNJlMi6QL4ZkYeyb4P7yld2AxP5igEkow4RE+CRLFE5EI66ZZfUOZdbaCXQGQJflr63EYhHNjXLTAU/8Nylc77OKzvaI3N8E0fOWaDVCxHIuuS9RRGglfl3xqs2UHBiIZdRjnGK0gWsk4a6PENsgP8bM52LzjgibQIDAQAB"
              ;
      String key1 ="-----BEGIN PUBLIC KEY-----"+
              "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjOHeX0BnvWd6qTILwSYhpX7E3xAvv4uDcg6iHeJmlDmJXzzKqIhbHwJsPcqlSj282qN8P/7bUp79xMu2o5FUy2ES0gzMR1aCKfBviv9zBJ5lRPcs/TogOmtdycok5krdEkrFPMTcLYvCEw9DXo0sxK/k0USvn5gS1MSBTkvTxHGEGtxkg0jXJxNJlMi6QL4ZkYeyb4P7yld2AxP5igEkow4RE+CRLFE5EI66ZZfUOZdbaCXQGQJflr63EYhHNjXLTAU/8Nylc77OKzvaI3N8E0fOWaDVCxHIuuS9RRGglfl3xqs2UHBiIZdRjnGK0gWsk4a6PENsgP8bM52LzjgibQIDAQAB"
              +"-----END PUBLIC KEY-----";
      Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(key1));

      //获取Jwt原始内容
      String claims = jwt.getClaims();
      JSONObject jsonObject = JSONObject.parseObject(claims);

      log.info("...{}",claims);
      log.info("...{}",jsonObject.getString("user_name"));
//      java.security.Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
      X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(key));
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      PublicKey publicKey = keyFactory.generatePublic(pubKeySpec);
      Jws<Claims> jwts = Jwts.parser().setSigningKey(publicKey)
              .parseClaimsJws(token);
      Claims body = jwts.getBody();
      log.info("...{}",body.getId());
      log.info("...{}",body.get("user_name"));


//      JwtAuthorizationTokenFilter
//      JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

//      String key ="-----BEGIN PUBLIC KEY-----"+
//              "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjOHeX0BnvWd6qTILwSYhpX7E3xAvv4uDcg6iHeJmlDmJXzzKqIhbHwJsPcqlSj282qN8P/7bUp79xMu2o5FUy2ES0gzMR1aCKfBviv9zBJ5lRPcs/TogOmtdycok5krdEkrFPMTcLYvCEw9DXo0sxK/k0USvn5gS1MSBTkvTxHGEGtxkg0jXJxNJlMi6QL4ZkYeyb4P7yld2AxP5igEkow4RE+CRLFE5EI66ZZfUOZdbaCXQGQJflr63EYhHNjXLTAU/8Nylc77OKzvaI3N8E0fOWaDVCxHIuuS9RRGglfl3xqs2UHBiIZdRjnGK0gWsk4a6PENsgP8bM52LzjgibQIDAQAB"
//              +"-----END PUBLIC KEY-----";
//      //        converter.setVerifierKey(key);
//      converter.setVerifier(new RsaVerifier(key));



      InUserDto pojo = mapper.convert(voData,InUserDto.class);
      return repository.get(pojo);
   }

//   public static Map<String, String> dcodeToken(String token) {
//      //校验Jwt
//      Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(getPubKey()));
//
//      //获取Jwt原始内容
//      String claims = jwt.getClaims();
//      return JSON.parseObject(claims, Map.class);
//   }
   @RequestMapping(UserControllerConstant.ACTION_EDIT)
   public ResultItem edit(@RequestBody UserVo voData) throws Exception{
      InUserDto pojo = mapper.convert(voData,InUserDto.class);
      return repository.edit(pojo);
   }
   @RequestMapping(UserControllerConstant.ACTION_LIST)
   public ResultItem list(@RequestBody UserVo voData) throws Exception{
      InUserDto pojo = mapper.convert(voData,InUserDto.class);
      return repository.list(pojo);
   }
   @RequestMapping(UserControllerConstant.ACTION_DELETE)
   public ResultItem delete(@RequestBody UserVo voData) throws Exception{
      InUserDto pojo = mapper.convert(voData,InUserDto.class);
      return repository.delete(pojo);
   }

}
