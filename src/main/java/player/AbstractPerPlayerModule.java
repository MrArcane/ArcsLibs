package player;

import java.util.HashMap;
import java.util.UUID;

public abstract class AbstractPerPlayerModule<T> implements PerPlayerModule<T> {

    private final HashMap<UUID, T> map = new HashMap<>();

    @Override
    public T get(UUID uuid) {
        return map.get(uuid);
    }

    @Override
    public void register(UUID uuid, T instance) {
        this.map.put(uuid, instance);
    }

    @Override
    public void unregister(UUID uuid) {
        this.map.remove(uuid);
    }
}
