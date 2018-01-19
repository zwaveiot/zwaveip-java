package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SensorConfiguration commands (version 1) */
public enum SensorConfigurationCommand implements Command {
    SENSOR_TRIGGER_LEVEL_GET((byte)0x02),
    SENSOR_TRIGGER_LEVEL_REPORT((byte)0x03),
    SENSOR_TRIGGER_LEVEL_SET((byte)0x01);

    private static final HashMap<Byte, SensorConfigurationCommand> _map = new HashMap<Byte, SensorConfigurationCommand>(3);
    static {
        for (SensorConfigurationCommand value: SensorConfigurationCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SensorConfigurationCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SensorConfigurationCommand valueOf(byte byteValue) {
        SensorConfigurationCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SensorConfigurationCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

