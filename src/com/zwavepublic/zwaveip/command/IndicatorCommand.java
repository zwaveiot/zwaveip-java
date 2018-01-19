package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Indicator commands (version 2) */
public enum IndicatorCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01),
    SUPPORTED_GET((byte)0x04),
    SUPPORTED_REPORT((byte)0x05);

    private static final HashMap<Byte, IndicatorCommand> _map = new HashMap<Byte, IndicatorCommand>(5);
    static {
        for (IndicatorCommand value: IndicatorCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private IndicatorCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static IndicatorCommand valueOf(byte byteValue) {
        IndicatorCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static IndicatorCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

