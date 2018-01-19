package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SensorMultilevel commands (version 10) */
public enum SensorMultilevelCommand implements Command {
    GET((byte)0x04),
    REPORT((byte)0x05),
    SUPPORTED_GET_SENSOR((byte)0x01),
    SUPPORTED_SENSOR_REPORT((byte)0x02),
    SUPPORTED_GET_SCALE((byte)0x03),
    SUPPORTED_SCALE_REPORT((byte)0x06);

    private static final HashMap<Byte, SensorMultilevelCommand> _map = new HashMap<Byte, SensorMultilevelCommand>(6);
    static {
        for (SensorMultilevelCommand value: SensorMultilevelCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SensorMultilevelCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SensorMultilevelCommand valueOf(byte byteValue) {
        SensorMultilevelCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SensorMultilevelCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

