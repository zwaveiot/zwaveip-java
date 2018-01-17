package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SwitchBinary commands (version 2) */
public enum SwitchBinaryCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01);

    private static final HashMap<Integer, SwitchBinaryCommand> _map = new HashMap<Integer, SwitchBinaryCommand>(3);
    static {
        for (SwitchBinaryCommand value: SwitchBinaryCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SwitchBinaryCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SwitchBinaryCommand valueOf(int intValue) {
        SwitchBinaryCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SwitchBinaryCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

