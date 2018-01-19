package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ThermostatFanState commands (version 2) */
public enum ThermostatFanStateCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03);

    private static final HashMap<Byte, ThermostatFanStateCommand> _map = new HashMap<Byte, ThermostatFanStateCommand>(2);
    static {
        for (ThermostatFanStateCommand value: ThermostatFanStateCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ThermostatFanStateCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ThermostatFanStateCommand valueOf(byte byteValue) {
        ThermostatFanStateCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ThermostatFanStateCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

