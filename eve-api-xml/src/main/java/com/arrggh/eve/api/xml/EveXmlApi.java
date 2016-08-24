package com.arrggh.eve.api.xml;

import com.arrggh.eve.api.xml.authentication.EveAccount;
import com.arrggh.eve.api.xml.authentication.XmlApiKey;
import com.arrggh.eve.api.xml.parsers.CachedResponseStillValidChecker;
import com.arrggh.eve.api.xml.parsers.ResponseParsers;
import com.arrggh.eve.api.xml.queries.CachedExternalQueryService;
import com.arrggh.eve.api.xml.responses.account.EveCharacter;
import com.arrggh.eve.api.xml.responses.character.CharacterIndustryJob;
import com.arrggh.eve.api.xml.responses.character.EveLocation;
import com.arrggh.eve.api.xml.responses.character.OwnedAsset;
import com.arrggh.eve.api.xml.responses.character.OwnedBlueprint;
import com.arrggh.eve.api.xml.queries.QueryUriBuilder;
import com.arrggh.eve.utilities.cache.ICache;

import java.net.URI;
import java.util.List;

public class EveXmlApi {
    private final CachedExternalQueryService responseCache;
    private final QueryUriBuilder queryUriBuilder;

    public EveXmlApi(ICache cache, QueryUriBuilder queryUriBuilder) {
        this.queryUriBuilder = queryUriBuilder;
        CachedResponseStillValidChecker checker = new CachedResponseStillValidChecker();
        this.responseCache = new CachedExternalQueryService(cache, checker);
    }

    public EveAccount getAccount(XmlApiKey xmlApiKey) {
        EveAccount.EveAccountBuilder builder = EveAccount.builder();
        builder.name(xmlApiKey.getName());
        builder.characters(getCharacterList(xmlApiKey));
        return builder.build();
    }

    public List<EveCharacter> getCharacterList(XmlApiKey xmlApiKey) {
        String key = "authorisations/" + xmlApiKey.getKeyId() + ".xml";
        URI uri = queryUriBuilder.buildUrl("/account/Characters.xml.aspx", xmlApiKey);
        return responseCache.get(key, ResponseParsers::parseCharacterList, uri).get();
    }

    public List<CharacterIndustryJob> getIndustryJobs(XmlApiKey xmlApiKey, String characterId) {
        String key = "character/" + characterId + "/industry-jobs.xml";
        URI uri = queryUriBuilder.buildUrl("/char/IndustryJobs.xml.aspx", xmlApiKey, "characterID", characterId);
        return responseCache.get(key, ResponseParsers::parseIndustryJobs,  uri).get();
    }

    public List<OwnedBlueprint> getBlueprints(XmlApiKey xmlApiKey, String characterId) {
        String key = "character/" + characterId + "/blueprints.xml";
        URI uri = queryUriBuilder.buildUrl("/char/Blueprints.xml.aspx", xmlApiKey, "characterID", characterId);
        return responseCache.get(key, ResponseParsers::parseBlueprints,  uri).get();
    }

    public List<OwnedAsset> getAssets(XmlApiKey xmlApiKey, String characterId) {
        String key = "character/" + characterId + "/assets.xml";
        URI uri = queryUriBuilder.buildUrl("/char/AssetList.xml.aspx", xmlApiKey, "characterID", characterId, "flat", "1");
        return responseCache.get(key, ResponseParsers::parseAssets,  uri).get();
    }

    public List<EveLocation> getLocations(XmlApiKey xmlApiKey, String characterId, String locationId) {
        String key = "character/" + characterId + "/locations/" + locationId + ".xml";
        URI uri = queryUriBuilder.buildUrl("/char/Locations.xml.aspx", xmlApiKey, "characterID", characterId, "ids", locationId);
        return responseCache.get(key, ResponseParsers::parseLocations,  uri).get();
    }
}