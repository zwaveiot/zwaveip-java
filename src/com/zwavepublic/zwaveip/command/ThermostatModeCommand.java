package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ThermostatMode commands (version 3) */
public enum ThermostatModeCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01),
    SUPPORTED_GET((byte)0x04),
    SUPPORTED_REPORT((byte)0x05);

    private static final HashMap<Byte, ThermostatModeCommand> _map = new HashMap<Byte, ThermostatModeCommand>(5);
    static {
        for (ThermostatModeCommand value: ThermostatModeCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ThermostatModeCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ThermostatModeCommand valueOf(byte byteValue) {
        ThermostatModeCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ThermostatModeCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

