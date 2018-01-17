package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Version commands (version 2) */
public enum VersionCommand implements com.zwavepublic.zwaveip.commands.Command {
    COMMAND_CLASS_GET(0x13),
    COMMAND_CLASS_REPORT(0x14),
    GET(0x11),
    REPORT(0x12);

    private static final HashMap<Integer, VersionCommand> _map = new HashMap<Integer, VersionCommand>(4);
    static {
        for (VersionCommand value: VersionCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private VersionCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static VersionCommand valueOf(int intValue) {
        VersionCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static VersionCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

