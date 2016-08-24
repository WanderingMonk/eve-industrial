package com.arrggh.eve.api.xml.responses.character;

import com.arrggh.eve.api.xml.responses.BasicModelObjectValidation;

public class OwnedAssetTest extends BasicModelObjectValidation<OwnedAsset> {

    @Override
    protected Class<OwnedAsset> getClassUnderTest() {
        return OwnedAsset.class;
    }

    @Override
    protected OwnedAsset getObjectUnderTest() {
        return OwnedAsset.builder().build();
    }
}