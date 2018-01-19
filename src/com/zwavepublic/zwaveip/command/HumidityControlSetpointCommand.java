package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* HumidityControlSetpoint commands (version 1) */
public enum HumidityControlSetpointCommand implements Command {
    SET((byte)0x01),
    GET((byte)0x02),
    REPORT((byte)0x03),
    SUPPORTED_GET((byte)0x04),
    SUPPORTED_REPORT((byte)0x05),
    SCALE_SUPPORTED_GET((byte)0x06),
    SCALE_SUPPORTED_REPORT((byte)0x07),
    CAPABILITIES_GET((byte)0x08),
    CAPABILITIES_REPORT((byte)0x09);

    private static final HashMap<Byte, HumidityControlSetpointCommand> _map = new HashMap<Byte, HumidityControlSetpointCommand>(9);
    static {
        for (HumidityControlSetpointCommand value: HumidityControlSetpointCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private HumidityControlSetpointCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static HumidityControlSetpointCommand valueOf(byte byteValue) {
        HumidityControlSetpointCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static HumidityControlSetpointCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

