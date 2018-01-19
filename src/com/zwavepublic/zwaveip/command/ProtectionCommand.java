package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Protection commands (version 2) */
public enum ProtectionCommand implements Command {
    EC_GET((byte)0x07),
    EC_REPORT((byte)0x08),
    EC_SET((byte)0x06),
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01),
    SUPPORTED_GET((byte)0x04),
    SUPPORTED_REPORT((byte)0x05),
    TIMEOUT_GET((byte)0x0a),
    TIMEOUT_REPORT((byte)0x0b),
    TIMEOUT_SET((byte)0x09);

    private static final HashMap<Byte, ProtectionCommand> _map = new HashMap<Byte, ProtectionCommand>(11);
    static {
        for (ProtectionCommand value: ProtectionCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ProtectionCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ProtectionCommand valueOf(byte byteValue) {
        ProtectionCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ProtectionCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

