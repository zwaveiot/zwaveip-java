package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Language commands (version 1) */
public enum LanguageCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01);

    private static final HashMap<Integer, LanguageCommand> _map = new HashMap<Integer, LanguageCommand>(3);
    static {
        for (LanguageCommand value: LanguageCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private LanguageCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static LanguageCommand valueOf(int intValue) {
        LanguageCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static LanguageCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

