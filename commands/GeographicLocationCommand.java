package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* GeographicLocation commands (version 1) */
public enum GeographicLocationCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01);

    private static final HashMap<Integer, GeographicLocationCommand> _map = new HashMap<Integer, GeographicLocationCommand>(3);
    static {
        for (GeographicLocationCommand value: GeographicLocationCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private GeographicLocationCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static GeographicLocationCommand valueOf(int intValue) {
        GeographicLocationCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static GeographicLocationCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

