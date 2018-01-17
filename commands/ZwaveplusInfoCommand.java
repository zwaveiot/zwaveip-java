package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ZwaveplusInfo commands (version 2) */
public enum ZwaveplusInfoCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x01),
    REPORT(0x02);

    private static final HashMap<Integer, ZwaveplusInfoCommand> _map = new HashMap<Integer, ZwaveplusInfoCommand>(2);
    static {
        for (ZwaveplusInfoCommand value: ZwaveplusInfoCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ZwaveplusInfoCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ZwaveplusInfoCommand valueOf(int intValue) {
        ZwaveplusInfoCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ZwaveplusInfoCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

