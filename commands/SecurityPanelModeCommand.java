package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SecurityPanelMode commands (version 1) */
public enum SecurityPanelModeCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x03),
    REPORT(0x04),
    SET(0x05),
    SUPPORTED_GET(0x01),
    SUPPORTED_REPORT(0x02);

    private static final HashMap<Integer, SecurityPanelModeCommand> _map = new HashMap<Integer, SecurityPanelModeCommand>(5);
    static {
        for (SecurityPanelModeCommand value: SecurityPanelModeCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SecurityPanelModeCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SecurityPanelModeCommand valueOf(int intValue) {
        SecurityPanelModeCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SecurityPanelModeCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

