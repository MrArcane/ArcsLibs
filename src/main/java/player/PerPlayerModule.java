package player;

import java.util.UUID;

public interface PerPlayerModule<T> extends PlayerDataModule {

    T get(UUID uuid);
    void register(UUID uuid, T instance);
    void unregister(UUID uuid);
}
