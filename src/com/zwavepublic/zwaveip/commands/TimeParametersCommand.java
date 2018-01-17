package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* TimeParameters commands (version 1) */
public enum TimeParametersCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01);

    private static final HashMap<Integer, TimeParametersCommand> _map = new HashMap<Integer, TimeParametersCommand>(3);
    static {
        for (TimeParametersCommand value: TimeParametersCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private TimeParametersCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static TimeParametersCommand valueOf(int intValue) {
        TimeParametersCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static TimeParametersCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

