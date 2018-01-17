package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ThermostatSetback commands (version 1) */
public enum ThermostatSetbackCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01);

    private static final HashMap<Integer, ThermostatSetbackCommand> _map = new HashMap<Integer, ThermostatSetbackCommand>(3);
    static {
        for (ThermostatSetbackCommand value: ThermostatSetbackCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ThermostatSetbackCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ThermostatSetbackCommand valueOf(int intValue) {
        ThermostatSetbackCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ThermostatSetbackCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

