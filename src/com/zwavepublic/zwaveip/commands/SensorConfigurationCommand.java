package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SensorConfiguration commands (version 1) */
public enum SensorConfigurationCommand implements com.zwavepublic.zwaveip.commands.Command {
    SENSOR_TRIGGER_LEVEL_GET(0x02),
    SENSOR_TRIGGER_LEVEL_REPORT(0x03),
    SENSOR_TRIGGER_LEVEL_SET(0x01);

    private static final HashMap<Integer, SensorConfigurationCommand> _map = new HashMap<Integer, SensorConfigurationCommand>(3);
    static {
        for (SensorConfigurationCommand value: SensorConfigurationCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SensorConfigurationCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SensorConfigurationCommand valueOf(int intValue) {
        SensorConfigurationCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SensorConfigurationCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

