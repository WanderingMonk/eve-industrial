package com.arrggh.eve.api.xml.responses.character;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CharacterIndustryJob {
    private final long jobID;
    private final long installerID;
    private final String installerName;
    private final long facilityID;
    private final long solarSystemID;
    private final String solarSystemName;
    private final long stationID;
    private final long activityID;
    private final long blueprintID;
    private final long blueprintTypeID;
    private final String blueprintTypeName;
    private final long blueprintLocationID;
    private final long outputLocationID;
    private final long runs;
    private final String cost;
    private final long teamID;
    private final String licensedRuns;
    private final String probability;
    private final long productTypeID;
    private final String productTypeName;
    private final String status;
    private final long timeInSeconds;
    private final String startDate;
    private final String endDate;
    private final String pauseDate;
    private final String completedDate;
    private final long completedCharacterID;
    private final String successfulRuns;
}
