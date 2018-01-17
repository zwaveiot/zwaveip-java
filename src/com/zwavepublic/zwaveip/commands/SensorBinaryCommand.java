package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SensorBinary commands (version 2) */
public enum SensorBinaryCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SUPPORTED_GET_SENSOR(0x01),
    SUPPORTED_SENSOR_REPORT(0x04);

    private static final HashMap<Integer, SensorBinaryCommand> _map = new HashMap<Integer, SensorBinaryCommand>(4);
    static {
        for (SensorBinaryCommand value: SensorBinaryCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SensorBinaryCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SensorBinaryCommand valueOf(int intValue) {
        SensorBinaryCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SensorBinaryCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

