package com.arrggh.eve.api.xml.responses.character;

import com.arrggh.eve.api.xml.responses.BasicResponseObjectValidation;

public class OwnedAssetTest extends BasicResponseObjectValidation<OwnedAsset> {

    @Override
    protected Class<OwnedAsset> getClassUnderTest() {
        return OwnedAsset.class;
    }

    @Override
    protected OwnedAsset getObjectUnderTest() {
        return OwnedAsset.builder().build();
    }
}