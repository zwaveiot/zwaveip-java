package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* HumidityControlSetpoint commands (version 1) */
public enum HumidityControlSetpointCommand implements com.zwavepublic.zwaveip.commands.Command {
    SET(0x01),
    GET(0x02),
    REPORT(0x03),
    SUPPORTED_GET(0x04),
    SUPPORTED_REPORT(0x05),
    SCALE_SUPPORTED_GET(0x06),
    SCALE_SUPPORTED_REPORT(0x07),
    CAPABILITIES_GET(0x08),
    CAPABILITIES_REPORT(0x09);

    private static final HashMap<Integer, HumidityControlSetpointCommand> _map = new HashMap<Integer, HumidityControlSetpointCommand>(9);
    static {
        for (HumidityControlSetpointCommand value: HumidityControlSetpointCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private HumidityControlSetpointCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static HumidityControlSetpointCommand valueOf(int intValue) {
        HumidityControlSetpointCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static HumidityControlSetpointCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

