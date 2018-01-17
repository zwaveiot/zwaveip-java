package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ScreenAttributes commands (version 2) */
public enum ScreenAttributesCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x01),
    REPORT(0x03);

    private static final HashMap<Integer, ScreenAttributesCommand> _map = new HashMap<Integer, ScreenAttributesCommand>(2);
    static {
        for (ScreenAttributesCommand value: ScreenAttributesCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ScreenAttributesCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ScreenAttributesCommand valueOf(int intValue) {
        ScreenAttributesCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ScreenAttributesCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

