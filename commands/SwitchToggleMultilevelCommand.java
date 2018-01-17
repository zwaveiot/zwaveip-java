package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SwitchToggleMultilevel commands (version 1) */
public enum SwitchToggleMultilevelCommand implements com.zwavepublic.zwaveip.commands.Command {
    SET(0x01),
    GET(0x02),
    REPORT(0x03),
    START_LEVEL_CHANGE(0x04),
    STOP_LEVEL_CHANGE(0x05);

    private static final HashMap<Integer, SwitchToggleMultilevelCommand> _map = new HashMap<Integer, SwitchToggleMultilevelCommand>(5);
    static {
        for (SwitchToggleMultilevelCommand value: SwitchToggleMultilevelCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SwitchToggleMultilevelCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SwitchToggleMultilevelCommand valueOf(int intValue) {
        SwitchToggleMultilevelCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SwitchToggleMultilevelCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

