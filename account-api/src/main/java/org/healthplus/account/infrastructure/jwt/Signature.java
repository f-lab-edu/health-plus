package org.healthplus.account.infrastructure.jwt;

import static org.healthplus.account.infrastructure.exception.ErrorCode.SIGNATURE_ENCRYPT_EXCEPTION;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.healthplus.account.infrastructure.exception.JwtException;
import org.healthplus.account.infrastructure.jwt.util.Encoder;

public class Signature {

  private final static String SECRET_KEY = "HealthPlusTokenKey";

  public String encryptedSignature(Header header, Payload payload) {
    StringBuilder sb = new StringBuilder();
    sb.append(header.headerEncodingProcess());
    sb.append(".");
    sb.append(payload.payloadEncodingProcess());

    try {
      Mac mac = Mac.getInstance(header.currentAlgorithm());
      SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8)
          , header.currentAlgorithm());
      mac.init(secretKeySpec);

      byte[] bytes = mac.doFinal(sb.toString().getBytes(StandardCharsets.UTF_8));

      return Encoder.run(bytes);
    } catch (NoSuchAlgorithmException | InvalidKeyException e) {
      throw new JwtException(SIGNATURE_ENCRYPT_EXCEPTION);
    }
  }
}
