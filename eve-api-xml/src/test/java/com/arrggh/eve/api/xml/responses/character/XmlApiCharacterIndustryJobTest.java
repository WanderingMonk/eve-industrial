package com.arrggh.eve.api.xml.responses.character;

import com.arrggh.eve.api.xml.responses.BasicResponseObjectValidation;

public class XmlApiCharacterIndustryJobTest extends BasicResponseObjectValidation<XmlApiCharacterIndustryJob> {

    @Override
    protected Class<XmlApiCharacterIndustryJob> getClassUnderTest() {
        return XmlApiCharacterIndustryJob.class;
    }

    @Override
    protected XmlApiCharacterIndustryJob getObjectUnderTest() {
        return XmlApiCharacterIndustryJob.builder().build();
    }
}