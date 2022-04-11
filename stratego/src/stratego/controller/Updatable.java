package stratego.controller;

import stratego.model.GameState;

public interface Updatable {
    void update(GameState state);
}
