package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Proprietary commands (version 1) */
public enum ProprietaryCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01);

    private static final HashMap<Integer, ProprietaryCommand> _map = new HashMap<Integer, ProprietaryCommand>(3);
    static {
        for (ProprietaryCommand value: ProprietaryCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ProprietaryCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ProprietaryCommand valueOf(int intValue) {
        ProprietaryCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ProprietaryCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

