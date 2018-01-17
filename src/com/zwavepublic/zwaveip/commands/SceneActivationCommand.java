package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SceneActivation commands (version 1) */
public enum SceneActivationCommand implements com.zwavepublic.zwaveip.commands.Command {
    SET(0x01);

    private static final HashMap<Integer, SceneActivationCommand> _map = new HashMap<Integer, SceneActivationCommand>(1);
    static {
        for (SceneActivationCommand value: SceneActivationCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SceneActivationCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SceneActivationCommand valueOf(int intValue) {
        SceneActivationCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SceneActivationCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

