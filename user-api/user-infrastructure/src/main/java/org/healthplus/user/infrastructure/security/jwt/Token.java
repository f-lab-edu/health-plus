package org.healthplus.user.infrastructure.security.jwt;

import static org.healthplus.user.infrastructure.exception.ErrorCode.Encode_Exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.healthplus.user.domain.dto.TokenPayloadDto;
import org.healthplus.user.infrastructure.exception.JwtException;
import org.healthplus.user.infrastructure.security.jwt.util.Encoder;
import org.healthplus.user.infrastructure.security.jwt.wrapper.Payload;
import org.healthplus.user.infrastructure.security.jwt.wrapper.TokenHeader;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Token {

  private TokenHeader header;
  private Payload payload;
  private final String ServerSecreteKey = "HealthPlusProjectTokenKey";
  private ObjectMapper objectMapper = new ObjectMapper();

  private Token(String algo, String type, TokenPayloadDto payloadDto) {
    this.header = TokenHeader.of(algo, type);
    this.payload = Payload.from(payloadDto);
  }

  /*
   * 기존 Setting은 "HS256", "JWT" 입니다.
   * */
  public static Token of(TokenPayloadDto payloadDto) {
    return new Token("HS256", "JWT", payloadDto);
  }

  public String generate() {
    String headerJson = null;
    String payloadJson = null;
    try {
      headerJson = objectMapper.writeValueAsString(header.currentTokenHeader());
      payloadJson = objectMapper.writeValueAsString(payload.currentPayload());
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    // TODO: 2022/11/06 알고리즘에 따른 시그니처 암호화 선택해야함
    String generateHeaderJson = Encoder.generate(headerJson);
    String generatePayloadJson = Encoder.generate(payloadJson);
    String tempString = generateHeaderJson + "." + generatePayloadJson;

    return makingSignature(tempString, ServerSecreteKey);
  }

  private String makingSignature(String headerAndPayloadJsonString, String secret) {
    try {
      byte[] hash = secret.getBytes(StandardCharsets.UTF_8);
      Mac hmacSHA256 = Mac.getInstance("HmacSHA256");
      SecretKeySpec secretKey = new SecretKeySpec(hash, "HmacSHA256");
      hmacSHA256.init(secretKey);

      byte[] signedBytes = hmacSHA256.doFinal(
          headerAndPayloadJsonString.getBytes(StandardCharsets.UTF_8));

      return Encoder.generate(String.valueOf(signedBytes));
    } catch (NoSuchAlgorithmException | InvalidKeyException e) {
      throw new JwtException(Encode_Exception);
    }
  }

}
