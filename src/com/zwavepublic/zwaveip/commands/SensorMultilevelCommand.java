package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SensorMultilevel commands (version 10) */
public enum SensorMultilevelCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x04),
    REPORT(0x05),
    SUPPORTED_GET_SENSOR(0x01),
    SUPPORTED_SENSOR_REPORT(0x02),
    SUPPORTED_GET_SCALE(0x03),
    SUPPORTED_SCALE_REPORT(0x06);

    private static final HashMap<Integer, SensorMultilevelCommand> _map = new HashMap<Integer, SensorMultilevelCommand>(6);
    static {
        for (SensorMultilevelCommand value: SensorMultilevelCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SensorMultilevelCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SensorMultilevelCommand valueOf(int intValue) {
        SensorMultilevelCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SensorMultilevelCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

