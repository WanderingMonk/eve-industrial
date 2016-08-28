package com.arrggh.eve.api.xml.responses.character;

import com.arrggh.eve.api.xml.responses.BasicResponseObjectValidation;

public class CharacterIndustryJobTest extends BasicResponseObjectValidation<CharacterIndustryJob> {

    @Override
    protected Class<CharacterIndustryJob> getClassUnderTest() {
        return CharacterIndustryJob.class;
    }

    @Override
    protected CharacterIndustryJob getObjectUnderTest() {
        return CharacterIndustryJob.builder().build();
    }
}