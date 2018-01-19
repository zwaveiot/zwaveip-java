package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ThermostatFanMode commands (version 4) */
public enum ThermostatFanModeCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01),
    SUPPORTED_GET((byte)0x04),
    SUPPORTED_REPORT((byte)0x05);

    private static final HashMap<Byte, ThermostatFanModeCommand> _map = new HashMap<Byte, ThermostatFanModeCommand>(5);
    static {
        for (ThermostatFanModeCommand value: ThermostatFanModeCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ThermostatFanModeCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ThermostatFanModeCommand valueOf(byte byteValue) {
        ThermostatFanModeCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ThermostatFanModeCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

