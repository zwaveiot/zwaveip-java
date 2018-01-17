package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SceneActuatorConf commands (version 1) */
public enum SceneActuatorConfCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01);

    private static final HashMap<Integer, SceneActuatorConfCommand> _map = new HashMap<Integer, SceneActuatorConfCommand>(3);
    static {
        for (SceneActuatorConfCommand value: SceneActuatorConfCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SceneActuatorConfCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SceneActuatorConfCommand valueOf(int intValue) {
        SceneActuatorConfCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SceneActuatorConfCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

