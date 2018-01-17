package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Meter commands (version 4) */
public enum MeterCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x01),
    REPORT(0x02),
    RESET(0x05),
    SUPPORTED_GET(0x03),
    SUPPORTED_REPORT(0x04);

    private static final HashMap<Integer, MeterCommand> _map = new HashMap<Integer, MeterCommand>(5);
    static {
        for (MeterCommand value: MeterCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private MeterCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static MeterCommand valueOf(int intValue) {
        MeterCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MeterCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

