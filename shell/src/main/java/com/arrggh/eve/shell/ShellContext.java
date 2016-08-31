package com.arrggh.eve.shell;

import com.arrggh.eve.model.account.EveAccount;
import com.arrggh.eve.model.account.EveCharacter;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import static com.arrggh.eve.utilities.LanguageUtilities.isNotNull;

@EqualsAndHashCode
@Builder
public class ShellContext {
    @Getter
    private Long activeAccountId;

    @Getter
    @Setter
    private Long activeCharacterId;

    @Getter
    private final DataManager dataManager;


    public void setActiveAccountId(Long activeAccountId) {
        this.activeAccountId = activeAccountId;
        if (isNotNull(activeAccountId)) {
            dataManager.reloadCharacters(activeAccountId);
        }
    }

    public EveAccount getActiveAccount() {
        if (isNotNull(activeAccountId)) {
            return getDataManager().getAccount(activeAccountId);
        }
        return null;
    }

    public EveCharacter getActiveCharacter() {
        if (isNotNull(activeCharacterId)) {
            return getDataManager().getCharacter(activeCharacterId);
        }
        return null;
    }

    public void shutdown() {
        dataManager.shutdown();
    }
}
