package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* HumidityControlMode commands (version 1) */
public enum HumidityControlModeCommand implements Command {
    SET((byte)0x01),
    GET((byte)0x02),
    REPORT((byte)0x03),
    SUPPORTED_GET((byte)0x04),
    SUPPORTED_REPORT((byte)0x05);

    private static final HashMap<Byte, HumidityControlModeCommand> _map = new HashMap<Byte, HumidityControlModeCommand>(5);
    static {
        for (HumidityControlModeCommand value: HumidityControlModeCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private HumidityControlModeCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static HumidityControlModeCommand valueOf(byte byteValue) {
        HumidityControlModeCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static HumidityControlModeCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

