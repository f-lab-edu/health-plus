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
import org.healthplus.user.infrastructure.security.jwt.util.Decoder;
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
   * Encoding method
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

    // encoding(headerJson) + . + encoding(payloadJson)
    String data = Encoder.generate(headerJson) + "." + Encoder.generate(payloadJson);

    return makingSignature(data);
  }

  /*
  * Decoding method
  * */
  public TokenPayloadDto degenerate(String token) {
    try {
      String encodedPayload = Decoder.generate(token);
      return objectMapper.readValue(encodedPayload, TokenPayloadDto.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  private String makingSignature(String data) {
    try {

      // HS256 algorithm works in here
      byte[] hash = ServerSecreteKey.getBytes(StandardCharsets.UTF_8);
      Mac hmacSHA256 = Mac.getInstance("HmacSHA256");
      SecretKeySpec secretKey = new SecretKeySpec(hash, "HmacSHA256");
      hmacSHA256.init(secretKey);

      byte[] signedBytes = hmacSHA256.doFinal(
          data.getBytes(StandardCharsets.UTF_8));

      return Encoder.generate(String.valueOf(signedBytes));
    } catch (NoSuchAlgorithmException | InvalidKeyException e) {
      throw new JwtException(Encode_Exception);
    }
  }

}
