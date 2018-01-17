package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ScreenMd commands (version 2) */
public enum ScreenMdCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x01),
    REPORT(0x03);

    private static final HashMap<Integer, ScreenMdCommand> _map = new HashMap<Integer, ScreenMdCommand>(2);
    static {
        for (ScreenMdCommand value: ScreenMdCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ScreenMdCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ScreenMdCommand valueOf(int intValue) {
        ScreenMdCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ScreenMdCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

