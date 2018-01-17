package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Indicator commands (version 2) */
public enum IndicatorCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01),
    SUPPORTED_GET(0x04),
    SUPPORTED_REPORT(0x05);

    private static final HashMap<Integer, IndicatorCommand> _map = new HashMap<Integer, IndicatorCommand>(5);
    static {
        for (IndicatorCommand value: IndicatorCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private IndicatorCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static IndicatorCommand valueOf(int intValue) {
        IndicatorCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static IndicatorCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

