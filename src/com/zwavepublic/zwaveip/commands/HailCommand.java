package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Hail commands (version 1) */
public enum HailCommand implements com.zwavepublic.zwaveip.commands.Command {
    HAIL(0x01);

    private static final HashMap<Integer, HailCommand> _map = new HashMap<Integer, HailCommand>(1);
    static {
        for (HailCommand value: HailCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private HailCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static HailCommand valueOf(int intValue) {
        HailCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static HailCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

