package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* HrvControl commands (version 1) */
public enum HrvControlCommand implements com.zwavepublic.zwaveip.commands.Command {
    BYPASS_GET(0x05),
    BYPASS_REPORT(0x06),
    BYPASS_SET(0x04),
    MODE_GET(0x02),
    MODE_REPORT(0x03),
    MODE_SET(0x01),
    MODE_SUPPORTED_GET(0x0a),
    MODE_SUPPORTED_REPORT(0x0b),
    VENTILATION_RATE_GET(0x08),
    VENTILATION_RATE_REPORT(0x09),
    VENTILATION_RATE_SET(0x07);

    private static final HashMap<Integer, HrvControlCommand> _map = new HashMap<Integer, HrvControlCommand>(11);
    static {
        for (HrvControlCommand value: HrvControlCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private HrvControlCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static HrvControlCommand valueOf(int intValue) {
        HrvControlCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static HrvControlCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

