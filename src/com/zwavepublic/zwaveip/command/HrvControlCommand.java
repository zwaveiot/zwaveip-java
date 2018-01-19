package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* HrvControl commands (version 1) */
public enum HrvControlCommand implements Command {
    BYPASS_GET((byte)0x05),
    BYPASS_REPORT((byte)0x06),
    BYPASS_SET((byte)0x04),
    MODE_GET((byte)0x02),
    MODE_REPORT((byte)0x03),
    MODE_SET((byte)0x01),
    MODE_SUPPORTED_GET((byte)0x0a),
    MODE_SUPPORTED_REPORT((byte)0x0b),
    VENTILATION_RATE_GET((byte)0x08),
    VENTILATION_RATE_REPORT((byte)0x09),
    VENTILATION_RATE_SET((byte)0x07);

    private static final HashMap<Byte, HrvControlCommand> _map = new HashMap<Byte, HrvControlCommand>(11);
    static {
        for (HrvControlCommand value: HrvControlCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private HrvControlCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static HrvControlCommand valueOf(byte byteValue) {
        HrvControlCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static HrvControlCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

