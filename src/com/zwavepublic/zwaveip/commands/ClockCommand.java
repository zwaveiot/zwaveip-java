package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Clock commands (version 1) */
public enum ClockCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x05),
    REPORT(0x06),
    SET(0x04);

    private static final HashMap<Integer, ClockCommand> _map = new HashMap<Integer, ClockCommand>(3);
    static {
        for (ClockCommand value: ClockCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ClockCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ClockCommand valueOf(int intValue) {
        ClockCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ClockCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

