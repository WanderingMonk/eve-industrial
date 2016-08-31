package com.arrggh.eve.api.xml;

import com.arrggh.eve.api.xml.parsers.ResponseParsers;
import com.arrggh.eve.api.xml.parsers.XmlExpiryTimeCalculator;
import com.arrggh.eve.api.xml.responses.account.XmlApiCharacter;
import com.arrggh.eve.api.xml.responses.character.XmlApiCharacterIndustryJob;
import com.arrggh.eve.api.xml.responses.character.XmlApiEveLocation;
import com.arrggh.eve.api.xml.responses.character.XmlApiOwnedAsset;
import com.arrggh.eve.api.xml.responses.character.XmlApiOwnedBlueprint;
import com.arrggh.eve.model.account.XmlApiKey;
import com.arrggh.eve.utilities.queries.CachedExternalQueryService;
import com.arrggh.eve.utilities.queries.QueryUriBuilder;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class EveXmlApi {
    private final CachedExternalQueryService responseCache;
    private final QueryUriBuilder queryUriBuilder;
    private final XmlExpiryTimeCalculator expiryTimeCalculator;

    public EveXmlApi(CachedExternalQueryService responseCache, QueryUriBuilder queryUriBuilder) {
        this.queryUriBuilder = queryUriBuilder;
        this.expiryTimeCalculator = new XmlExpiryTimeCalculator();
        this.responseCache = responseCache;
    }

    public List<XmlApiCharacter> getCharacterList(XmlApiKey xmlApiKey) {
        String key = "authorisations/" + xmlApiKey.getKeyId() + ".xml";
        URI uri = queryUriBuilder.buildUrl("/account/Characters.xml.aspx", "keyID", xmlApiKey.getKeyId(), "vCode", xmlApiKey.getVerificationCode());
        return returnIfPresent(responseCache.get(key, ResponseParsers::parseCharacterList, expiryTimeCalculator, uri));
    }

    public List<XmlApiCharacterIndustryJob> getIndustryJobs(XmlApiKey xmlApiKey, String characterId) {
        String key = "character/" + characterId + "/industry-jobs.xml";
        URI uri = queryUriBuilder.buildUrl("/char/IndustryJobs.xml.aspx", "keyID", xmlApiKey.getKeyId(), "vCode", xmlApiKey.getVerificationCode(), "characterID", characterId);
        return returnIfPresent(responseCache.get(key, ResponseParsers::parseIndustryJobs, expiryTimeCalculator, uri));
    }

    public List<XmlApiOwnedBlueprint> getBlueprints(XmlApiKey xmlApiKey, String characterId) {
        String key = "character/" + characterId + "/blueprints.xml";
        URI uri = queryUriBuilder.buildUrl("/char/Blueprints.xml.aspx", "keyID", xmlApiKey.getKeyId(), "vCode", xmlApiKey.getVerificationCode(), "characterID", characterId);
        return returnIfPresent(responseCache.get(key, ResponseParsers::parseBlueprints, expiryTimeCalculator, uri));
    }

    public List<XmlApiOwnedAsset> getAssets(XmlApiKey xmlApiKey, String characterId) {
        String key = "character/" + characterId + "/assets.xml";
        URI uri = queryUriBuilder.buildUrl("/char/AssetList.xml.aspx", "keyID", xmlApiKey.getKeyId(), "vCode", xmlApiKey.getVerificationCode(), "characterID", characterId, "flat", "1");
        return returnIfPresent(responseCache.get(key, ResponseParsers::parseAssets, expiryTimeCalculator, uri));
    }

    public List<XmlApiEveLocation> getLocations(XmlApiKey xmlApiKey, String characterId, String locationId) {
        String key = "character/" + characterId + "/locations/" + locationId + ".xml";
        URI uri = queryUriBuilder.buildUrl("/char/Locations.xml.aspx", "keyID", xmlApiKey.getKeyId(), "vCode", xmlApiKey.getVerificationCode(), "characterID", characterId, "ids", locationId);
        return returnIfPresent(responseCache.get(key, ResponseParsers::parseLocations, expiryTimeCalculator, uri));
    }

    private static <T> List<T> returnIfPresent(Optional<List<T>> optional) {
        if (optional.isPresent())
            return optional.get();
        return new LinkedList<T>();
    }
}