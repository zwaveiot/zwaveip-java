package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ThermostatSetback commands (version 1) */
public enum ThermostatSetbackCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01);

    private static final HashMap<Byte, ThermostatSetbackCommand> _map = new HashMap<Byte, ThermostatSetbackCommand>(3);
    static {
        for (ThermostatSetbackCommand value: ThermostatSetbackCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ThermostatSetbackCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ThermostatSetbackCommand valueOf(byte byteValue) {
        ThermostatSetbackCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ThermostatSetbackCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

