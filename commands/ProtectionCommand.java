package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Protection commands (version 2) */
public enum ProtectionCommand implements com.zwavepublic.zwaveip.commands.Command {
    EC_GET(0x07),
    EC_REPORT(0x08),
    EC_SET(0x06),
    GET(0x02),
    REPORT(0x03),
    SET(0x01),
    SUPPORTED_GET(0x04),
    SUPPORTED_REPORT(0x05),
    TIMEOUT_GET(0x0a),
    TIMEOUT_REPORT(0x0b),
    TIMEOUT_SET(0x09);

    private static final HashMap<Integer, ProtectionCommand> _map = new HashMap<Integer, ProtectionCommand>(11);
    static {
        for (ProtectionCommand value: ProtectionCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ProtectionCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ProtectionCommand valueOf(int intValue) {
        ProtectionCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ProtectionCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

