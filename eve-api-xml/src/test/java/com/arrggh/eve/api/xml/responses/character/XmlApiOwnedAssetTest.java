package com.arrggh.eve.api.xml.responses.character;

import com.arrggh.eve.api.xml.responses.BasicResponseObjectValidation;

public class XmlApiOwnedAssetTest extends BasicResponseObjectValidation<XmlApiOwnedAsset> {

    @Override
    protected Class<XmlApiOwnedAsset> getClassUnderTest() {
        return XmlApiOwnedAsset.class;
    }

    @Override
    protected XmlApiOwnedAsset getObjectUnderTest() {
        return XmlApiOwnedAsset.builder().build();
    }
}