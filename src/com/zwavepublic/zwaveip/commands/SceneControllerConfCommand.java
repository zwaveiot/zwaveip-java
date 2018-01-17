package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SceneControllerConf commands (version 1) */
public enum SceneControllerConfCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01);

    private static final HashMap<Integer, SceneControllerConfCommand> _map = new HashMap<Integer, SceneControllerConfCommand>(3);
    static {
        for (SceneControllerConfCommand value: SceneControllerConfCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SceneControllerConfCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SceneControllerConfCommand valueOf(int intValue) {
        SceneControllerConfCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SceneControllerConfCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

