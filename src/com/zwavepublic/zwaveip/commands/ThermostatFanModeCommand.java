package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ThermostatFanMode commands (version 4) */
public enum ThermostatFanModeCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01),
    SUPPORTED_GET(0x04),
    SUPPORTED_REPORT(0x05);

    private static final HashMap<Integer, ThermostatFanModeCommand> _map = new HashMap<Integer, ThermostatFanModeCommand>(5);
    static {
        for (ThermostatFanModeCommand value: ThermostatFanModeCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ThermostatFanModeCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ThermostatFanModeCommand valueOf(int intValue) {
        ThermostatFanModeCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ThermostatFanModeCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

