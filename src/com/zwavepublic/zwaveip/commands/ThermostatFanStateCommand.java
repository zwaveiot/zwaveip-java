package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ThermostatFanState commands (version 2) */
public enum ThermostatFanStateCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03);

    private static final HashMap<Integer, ThermostatFanStateCommand> _map = new HashMap<Integer, ThermostatFanStateCommand>(2);
    static {
        for (ThermostatFanStateCommand value: ThermostatFanStateCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ThermostatFanStateCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ThermostatFanStateCommand valueOf(int intValue) {
        ThermostatFanStateCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ThermostatFanStateCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

