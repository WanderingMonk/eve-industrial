package com.arrggh.eve.shell;

import com.arrggh.eve.api.xml.EveXmlApi;
import com.arrggh.eve.api.xml.responses.account.XmlApiCharacter;
import com.arrggh.eve.api.xml.responses.character.XmlApiOwnedBlueprint;
import com.arrggh.eve.database.DatabaseConnection;
import com.arrggh.eve.database.dao.account.IAccountDao;
import com.arrggh.eve.database.dao.account.ICharacterDao;
import com.arrggh.eve.database.dao.account.IXmlApiKeyDao;
import com.arrggh.eve.database.dao.character.IBlueprintDao;
import com.arrggh.eve.model.account.EveAccount;
import com.arrggh.eve.model.account.EveCharacter;
import com.arrggh.eve.model.account.XmlApiKey;
import com.arrggh.eve.model.character.EveBlueprint;
import com.arrggh.eve.shell.commands.debug.DumpTableExecutor;

import java.util.LinkedList;
import java.util.List;

public class DataManager {
    private final DatabaseConnection database;

    private final IAccountDao accountDao;
    private final ICharacterDao characterDao;
    private final IBlueprintDao blueprintDao;
    private final IXmlApiKeyDao xmlKeyDao;

    private EveXmlApi xmlApi;

    public DataManager(DatabaseConnection database, EveXmlApi xmlApi) {
        this.database = database;

        this.accountDao = database.getDao(IAccountDao.class);
        this.characterDao = database.getDao(ICharacterDao.class);
        this.xmlKeyDao = database.getDao(IXmlApiKeyDao.class);
        this.blueprintDao = database.getDao(IBlueprintDao.class);

        this.xmlApi = xmlApi;
    }

    public List<EveAccount> getAccountList() {
        List<EveAccount> results = new LinkedList<>();
        List<EveAccount> rawAccounts = accountDao.select();
        for (EveAccount raw : rawAccounts) {
            List<EveCharacter> characters = characterDao.selectByAccountId(raw.getId());
            EveAccount account = EveAccount.builder().id(raw.getId()).name(raw.getName()).characters(characters).build();
            results.add(account);
        }
        return results;
    }

    public List<EveCharacter> getCharacterList(long accountId) {
        return characterDao.selectByAccountId(accountId);
    }

    public EveAccount createNewAccount(String name) {
        long id = accountDao.getNextAccountNumber();
        EveAccount account = EveAccount.builder().id(id).name(name).build();
        accountDao.insert(account);
        return account;
    }

    public void addXmlKey(long accountId, String id, String vCode) {
        xmlKeyDao.insertKey(accountId, id, vCode);
    }

    public EveAccount getAccount(long id) {
        return accountDao.select(id);
    }

    public EveCharacter getCharacter(long id) {
        return characterDao.selectById(id);
    }

    public void reloadCharacters(long accountId) {
        characterDao.deleteByAccountId(accountId);
        for (XmlApiKey key : xmlKeyDao.getKeys(accountId)) {
            List<XmlApiCharacter> characters = xmlApi.getCharacterList(key);
            for (XmlApiCharacter character : characters) {
                EveCharacter eveCharacter = EveCharacter.builder() //
                        .id(Long.parseLong(character.getId())) //
                        .name(character.getName()) //
                        .build();
                characterDao.insert(accountId, eveCharacter);
            }
        }
    }

    public void reloadBlueprints(long accountId, long characterId) {
        blueprintDao.deleteByCharacterId(characterId);

        for (XmlApiKey key : xmlKeyDao.getKeys(accountId)) {
            for (XmlApiOwnedBlueprint blueprint : xmlApi.getBlueprints(key, Long.toString(characterId))) {
                EveBlueprint eveBlueprint = EveBlueprint.builder() //
                        .id(blueprint.getItemId()) //
                        .name(blueprint.getTypeName()) //
                        .build();
                blueprintDao.insert(characterId, eveBlueprint);
            }
        }
    }

    public List<EveBlueprint> getBlueprintList(Long accountId, Long characterId) {
        reloadBlueprints(accountId, characterId);
        return blueprintDao.selectByCharacterId(characterId);
    }

    public void shutdown() {
        database.shutdown();
    }

    public List<List<String>> debugExecuteSql(DumpTableExecutor accounts) {
        return database.executeQuery(accounts);
    }
}
