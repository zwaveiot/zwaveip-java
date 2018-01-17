package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Antitheft commands (version 2) */
public enum AntitheftCommand implements com.zwavepublic.zwaveip.commands.Command {
    SET(0x01),
    GET(0x02),
    REPORT(0x03);

    private static final HashMap<Integer, AntitheftCommand> _map = new HashMap<Integer, AntitheftCommand>(3);
    static {
        for (AntitheftCommand value: AntitheftCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private AntitheftCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static AntitheftCommand valueOf(int intValue) {
        AntitheftCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AntitheftCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

