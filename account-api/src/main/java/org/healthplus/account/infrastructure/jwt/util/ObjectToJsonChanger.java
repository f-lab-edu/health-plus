package org.healthplus.account.infrastructure.jwt.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJsonChanger {

  private final static ObjectMapper obm = new ObjectMapper();

  public static String changer(Object obj) throws JsonProcessingException {
    return obm.writeValueAsString(obj);
  }

}
