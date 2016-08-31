package com.arrggh.eve.model.account;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class XmlApiKey {
    private String keyId;
    private String verificationCode;
}
