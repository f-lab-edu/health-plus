package org.healthplus.account.infrastructure.jwt;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DecoderTest {

  @Test
  public void decoderTest() throws Exception {
    Assertions.assertThat(Decoder.run("YWJj")).isEqualTo("abc");
  }

}
