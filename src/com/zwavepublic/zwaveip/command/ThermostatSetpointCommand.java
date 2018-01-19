package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ThermostatSetpoint commands (version 3) */
public enum ThermostatSetpointCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01),
    SUPPORTED_GET((byte)0x04),
    SUPPORTED_REPORT((byte)0x05),
    CAPABILITIES_GET((byte)0x09),
    CAPABILITIES_REPORT((byte)0x0a);

    private static final HashMap<Byte, ThermostatSetpointCommand> _map = new HashMap<Byte, ThermostatSetpointCommand>(7);
    static {
        for (ThermostatSetpointCommand value: ThermostatSetpointCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ThermostatSetpointCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ThermostatSetpointCommand valueOf(byte byteValue) {
        ThermostatSetpointCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ThermostatSetpointCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

