package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ZensorNet commands (version 1) */
public enum ZensorNetCommand implements com.zwavepublic.zwaveip.commands.Command {
    BIND_ACCEPT(0x02),
    BIND_COMPLETE(0x03),
    BIND_REQUEST(0x01);

    private static final HashMap<Integer, ZensorNetCommand> _map = new HashMap<Integer, ZensorNetCommand>(3);
    static {
        for (ZensorNetCommand value: ZensorNetCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ZensorNetCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ZensorNetCommand valueOf(int intValue) {
        ZensorNetCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ZensorNetCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

