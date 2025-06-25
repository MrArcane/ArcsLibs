package player;

import java.util.UUID;

public interface PlayerDataModule {

    void load(UUID uuid, PlayerData playerData);

    void save(UUID uuid, PlayerData playerData);
}