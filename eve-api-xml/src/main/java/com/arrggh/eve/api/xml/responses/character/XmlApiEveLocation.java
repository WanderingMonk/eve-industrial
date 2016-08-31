package com.arrggh.eve.api.xml.responses.character;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class XmlApiEveLocation {
    private long itemID;
    private String itemName;
    private double x;
    private double y;
    private double z;
}
