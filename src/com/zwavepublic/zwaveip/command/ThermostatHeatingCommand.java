package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ThermostatHeating commands (version 1) */
public enum ThermostatHeatingCommand implements Command {
    STATUS_REPORT((byte)0x0d),
    MODE_GET((byte)0x02),
    MODE_REPORT((byte)0x03),
    MODE_SET((byte)0x01),
    RELAY_STATUS_GET((byte)0x09),
    RELAY_STATUS_REPORT((byte)0x0a),
    SETPOINT_GET((byte)0x05),
    SETPOINT_REPORT((byte)0x06),
    SETPOINT_SET((byte)0x04),
    STATUS_GET((byte)0x0c),
    STATUS_SET((byte)0x0b),
    TIMED_OFF_SET((byte)0x11);

    private static final HashMap<Byte, ThermostatHeatingCommand> _map = new HashMap<Byte, ThermostatHeatingCommand>(12);
    static {
        for (ThermostatHeatingCommand value: ThermostatHeatingCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ThermostatHeatingCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ThermostatHeatingCommand valueOf(byte byteValue) {
        ThermostatHeatingCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ThermostatHeatingCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

