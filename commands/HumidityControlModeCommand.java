package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* HumidityControlMode commands (version 1) */
public enum HumidityControlModeCommand implements com.zwavepublic.zwaveip.commands.Command {
    SET(0x01),
    GET(0x02),
    REPORT(0x03),
    SUPPORTED_GET(0x04),
    SUPPORTED_REPORT(0x05);

    private static final HashMap<Integer, HumidityControlModeCommand> _map = new HashMap<Integer, HumidityControlModeCommand>(5);
    static {
        for (HumidityControlModeCommand value: HumidityControlModeCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private HumidityControlModeCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static HumidityControlModeCommand valueOf(int intValue) {
        HumidityControlModeCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static HumidityControlModeCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

