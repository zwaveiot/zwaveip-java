package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Meter commands (version 4) */
public enum MeterCommand implements Command {
    GET((byte)0x01),
    REPORT((byte)0x02),
    RESET((byte)0x05),
    SUPPORTED_GET((byte)0x03),
    SUPPORTED_REPORT((byte)0x04);

    private static final HashMap<Byte, MeterCommand> _map = new HashMap<Byte, MeterCommand>(5);
    static {
        for (MeterCommand value: MeterCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private MeterCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static MeterCommand valueOf(byte byteValue) {
        MeterCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MeterCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

