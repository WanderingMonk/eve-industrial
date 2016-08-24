package com.arrggh.eve.api.xml.responses.character;

import com.arrggh.eve.api.xml.responses.BasicModelObjectValidation;

public class CharacterIndustryJobTest extends BasicModelObjectValidation<CharacterIndustryJob> {

    @Override
    protected Class<CharacterIndustryJob> getClassUnderTest() {
        return CharacterIndustryJob.class;
    }

    @Override
    protected CharacterIndustryJob getObjectUnderTest() {
        return CharacterIndustryJob.builder().build();
    }
}