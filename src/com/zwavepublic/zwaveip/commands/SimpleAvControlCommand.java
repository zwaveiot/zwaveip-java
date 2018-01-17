package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SimpleAvControl commands (version 1) */
public enum SimpleAvControlCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01),
    SUPPORTED_GET(0x04),
    SUPPORTED_REPORT(0x05);

    private static final HashMap<Integer, SimpleAvControlCommand> _map = new HashMap<Integer, SimpleAvControlCommand>(5);
    static {
        for (SimpleAvControlCommand value: SimpleAvControlCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SimpleAvControlCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SimpleAvControlCommand valueOf(int intValue) {
        SimpleAvControlCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SimpleAvControlCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

