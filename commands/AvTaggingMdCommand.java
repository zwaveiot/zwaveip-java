package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* AvTaggingMd commands (version 1) */
public enum AvTaggingMdCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x01),
    REPORT(0x02);

    private static final HashMap<Integer, AvTaggingMdCommand> _map = new HashMap<Integer, AvTaggingMdCommand>(2);
    static {
        for (AvTaggingMdCommand value: AvTaggingMdCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private AvTaggingMdCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static AvTaggingMdCommand valueOf(int intValue) {
        AvTaggingMdCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AvTaggingMdCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

