package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SwitchMultilevel commands (version 4) */
public enum SwitchMultilevelCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01),
    START_LEVEL_CHANGE(0x04),
    STOP_LEVEL_CHANGE(0x05),
    SUPPORTED_GET(0x06),
    SUPPORTED_REPORT(0x07);

    private static final HashMap<Integer, SwitchMultilevelCommand> _map = new HashMap<Integer, SwitchMultilevelCommand>(7);
    static {
        for (SwitchMultilevelCommand value: SwitchMultilevelCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SwitchMultilevelCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SwitchMultilevelCommand valueOf(int intValue) {
        SwitchMultilevelCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SwitchMultilevelCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

