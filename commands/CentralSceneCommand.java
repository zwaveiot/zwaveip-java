package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* CentralScene commands (version 3) */
public enum CentralSceneCommand implements com.zwavepublic.zwaveip.commands.Command {
    SUPPORTED_GET(0x01),
    SUPPORTED_REPORT(0x02),
    NOTIFICATION(0x03),
    CONFIGURATION_SET(0x04),
    CONFIGURATION_GET(0x05),
    CONFIGURATION_REPORT(0x06);

    private static final HashMap<Integer, CentralSceneCommand> _map = new HashMap<Integer, CentralSceneCommand>(6);
    static {
        for (CentralSceneCommand value: CentralSceneCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private CentralSceneCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static CentralSceneCommand valueOf(int intValue) {
        CentralSceneCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static CentralSceneCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

