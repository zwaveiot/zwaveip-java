package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ThermostatSetpoint commands (version 3) */
public enum ThermostatSetpointCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01),
    SUPPORTED_GET(0x04),
    SUPPORTED_REPORT(0x05),
    CAPABILITIES_GET(0x09),
    CAPABILITIES_REPORT(0x0a);

    private static final HashMap<Integer, ThermostatSetpointCommand> _map = new HashMap<Integer, ThermostatSetpointCommand>(7);
    static {
        for (ThermostatSetpointCommand value: ThermostatSetpointCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ThermostatSetpointCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ThermostatSetpointCommand valueOf(int intValue) {
        ThermostatSetpointCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ThermostatSetpointCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

