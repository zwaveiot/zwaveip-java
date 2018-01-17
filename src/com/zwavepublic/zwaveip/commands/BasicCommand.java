package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Basic commands (version 2) */
public enum BasicCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01);

    private static final HashMap<Integer, BasicCommand> _map = new HashMap<Integer, BasicCommand>(3);
    static {
        for (BasicCommand value: BasicCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private BasicCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static BasicCommand valueOf(int intValue) {
        BasicCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static BasicCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

