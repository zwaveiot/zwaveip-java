package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Time commands (version 2) */
public enum TimeCommand implements com.zwavepublic.zwaveip.commands.Command {
    DATE_GET(0x03),
    DATE_REPORT(0x04),
    GET(0x01),
    OFFSET_GET(0x06),
    OFFSET_REPORT(0x07),
    OFFSET_SET(0x05),
    REPORT(0x02);

    private static final HashMap<Integer, TimeCommand> _map = new HashMap<Integer, TimeCommand>(7);
    static {
        for (TimeCommand value: TimeCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private TimeCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static TimeCommand valueOf(int intValue) {
        TimeCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static TimeCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

