package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ThermostatHeating commands (version 1) */
public enum ThermostatHeatingCommand implements com.zwavepublic.zwaveip.commands.Command {
    STATUS_REPORT(0x0d),
    MODE_GET(0x02),
    MODE_REPORT(0x03),
    MODE_SET(0x01),
    RELAY_STATUS_GET(0x09),
    RELAY_STATUS_REPORT(0x0a),
    SETPOINT_GET(0x05),
    SETPOINT_REPORT(0x06),
    SETPOINT_SET(0x04),
    STATUS_GET(0x0c),
    STATUS_SET(0x0b),
    TIMED_OFF_SET(0x11);

    private static final HashMap<Integer, ThermostatHeatingCommand> _map = new HashMap<Integer, ThermostatHeatingCommand>(12);
    static {
        for (ThermostatHeatingCommand value: ThermostatHeatingCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ThermostatHeatingCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ThermostatHeatingCommand valueOf(int intValue) {
        ThermostatHeatingCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ThermostatHeatingCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

