package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* RateTblConfig commands (version 1) */
public enum RateTblConfigCommand implements com.zwavepublic.zwaveip.commands.Command {
    RATE_TBL_REMOVE(0x02),
    RATE_TBL_SET(0x01);

    private static final HashMap<Integer, RateTblConfigCommand> _map = new HashMap<Integer, RateTblConfigCommand>(2);
    static {
        for (RateTblConfigCommand value: RateTblConfigCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private RateTblConfigCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static RateTblConfigCommand valueOf(int intValue) {
        RateTblConfigCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static RateTblConfigCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

