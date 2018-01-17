package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ThermostatMode commands (version 3) */
public enum ThermostatModeCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01),
    SUPPORTED_GET(0x04),
    SUPPORTED_REPORT(0x05);

    private static final HashMap<Integer, ThermostatModeCommand> _map = new HashMap<Integer, ThermostatModeCommand>(5);
    static {
        for (ThermostatModeCommand value: ThermostatModeCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ThermostatModeCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ThermostatModeCommand valueOf(int intValue) {
        ThermostatModeCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ThermostatModeCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

