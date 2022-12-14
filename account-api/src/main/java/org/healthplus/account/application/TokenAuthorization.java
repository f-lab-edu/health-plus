package org.healthplus.account.application;

import javax.servlet.http.HttpServletRequest;
import org.healthplus.account.application.command.AuthorizationCommand;
import org.healthplus.account.application.result.AuthorizationResult;
import org.healthplus.account.domain.Authorization;
import org.healthplus.account.domain.TokenGenerator;
import org.healthplus.account.domain.vo.TokenPayloadVo;
import org.springframework.stereotype.Component;

// @Component
public class TokenAuthorization implements Authorization {

  private final TokenGenerator tokenGenerator;

  public TokenAuthorization(TokenGenerator tokenGenerator) {
    this.tokenGenerator = tokenGenerator;
  }

  @Override
  public String login(AuthorizationCommand authorizationCommand) {
    TokenPayloadVo tokenPayloadVo = new TokenPayloadVo(
        authorizationCommand.getUserId(),
        authorizationCommand.getEmail(),
        authorizationCommand.getRole()
    );
    return tokenGenerator.generateAccessToken(tokenPayloadVo);
  }

  @Override
  public AuthorizationResult getCurrentUser(HttpServletRequest request) {
    return null;
  }

  @Override
  public void logout(HttpServletRequest request) {
    // TODO: 2022/12/20 token delete logic
  }
}
