package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SwitchToggleBinary commands (version 1) */
public enum SwitchToggleBinaryCommand implements com.zwavepublic.zwaveip.commands.Command {
    SET(0x01),
    GET(0x02),
    REPORT(0x03);

    private static final HashMap<Integer, SwitchToggleBinaryCommand> _map = new HashMap<Integer, SwitchToggleBinaryCommand>(3);
    static {
        for (SwitchToggleBinaryCommand value: SwitchToggleBinaryCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SwitchToggleBinaryCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SwitchToggleBinaryCommand valueOf(int intValue) {
        SwitchToggleBinaryCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SwitchToggleBinaryCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

