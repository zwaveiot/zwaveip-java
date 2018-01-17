package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ThermostatOperatingState commands (version 2) */
public enum ThermostatOperatingStateCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    LOGGING_SUPPORTED_GET(0x01),
    THERMOSTAT_OPERATING_LOGGING_SUPPORTED_REPORT(0x04),
    LOGGING_GET(0x05),
    LOGGING_REPORT(0x06);

    private static final HashMap<Integer, ThermostatOperatingStateCommand> _map = new HashMap<Integer, ThermostatOperatingStateCommand>(6);
    static {
        for (ThermostatOperatingStateCommand value: ThermostatOperatingStateCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ThermostatOperatingStateCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ThermostatOperatingStateCommand valueOf(int intValue) {
        ThermostatOperatingStateCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ThermostatOperatingStateCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

