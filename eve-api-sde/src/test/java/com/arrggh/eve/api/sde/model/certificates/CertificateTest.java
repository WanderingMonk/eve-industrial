package com.arrggh.eve.api.sde.model.certificates;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class CertificateTest extends BasicModelObjectValidation<Certificate> {
  protected Class<Certificate> getClassUnderTest() {
    return Certificate.class;
  }

  protected Certificate getInstanceUnderTest() {
    return new Certificate.CertificateBuilder().build();
  }
}
