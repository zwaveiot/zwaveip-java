package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SensorBinary commands (version 2) */
public enum SensorBinaryCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SUPPORTED_GET_SENSOR((byte)0x01),
    SUPPORTED_SENSOR_REPORT((byte)0x04);

    private static final HashMap<Byte, SensorBinaryCommand> _map = new HashMap<Byte, SensorBinaryCommand>(4);
    static {
        for (SensorBinaryCommand value: SensorBinaryCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SensorBinaryCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SensorBinaryCommand valueOf(byte byteValue) {
        SensorBinaryCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SensorBinaryCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

