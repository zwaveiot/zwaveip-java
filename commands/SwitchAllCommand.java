package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SwitchAll commands (version 1) */
public enum SwitchAllCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    OFF(0x05),
    ON(0x04),
    REPORT(0x03),
    SET(0x01);

    private static final HashMap<Integer, SwitchAllCommand> _map = new HashMap<Integer, SwitchAllCommand>(5);
    static {
        for (SwitchAllCommand value: SwitchAllCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SwitchAllCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SwitchAllCommand valueOf(int intValue) {
        SwitchAllCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SwitchAllCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

