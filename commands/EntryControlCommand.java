package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* EntryControl commands (version 1) */
public enum EntryControlCommand implements com.zwavepublic.zwaveip.commands.Command {
    NOTIFICATION(0x01),
    KEY_SUPPORTED_GET(0x02),
    KEY_SUPPORTED_REPORT(0x03),
    EVENT_SUPPORTED_GET(0x04),
    EVENT_SUPPORTED_REPORT(0x05),
    CONFIGURATION_SET(0x06),
    CONFIGURATION_GET(0x07),
    CONFIGURATION_REPORT(0x08);

    private static final HashMap<Integer, EntryControlCommand> _map = new HashMap<Integer, EntryControlCommand>(8);
    static {
        for (EntryControlCommand value: EntryControlCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private EntryControlCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static EntryControlCommand valueOf(int intValue) {
        EntryControlCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static EntryControlCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

