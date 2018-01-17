package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* AvContentSearchMd commands (version 1) */
public enum AvContentSearchMdCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x01),
    REPORT(0x02);

    private static final HashMap<Integer, AvContentSearchMdCommand> _map = new HashMap<Integer, AvContentSearchMdCommand>(2);
    static {
        for (AvContentSearchMdCommand value: AvContentSearchMdCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private AvContentSearchMdCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static AvContentSearchMdCommand valueOf(int intValue) {
        AvContentSearchMdCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AvContentSearchMdCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

