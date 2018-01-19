package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ThermostatOperatingState commands (version 2) */
public enum ThermostatOperatingStateCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    LOGGING_SUPPORTED_GET((byte)0x01),
    THERMOSTAT_OPERATING_LOGGING_SUPPORTED_REPORT((byte)0x04),
    LOGGING_GET((byte)0x05),
    LOGGING_REPORT((byte)0x06);

    private static final HashMap<Byte, ThermostatOperatingStateCommand> _map = new HashMap<Byte, ThermostatOperatingStateCommand>(6);
    static {
        for (ThermostatOperatingStateCommand value: ThermostatOperatingStateCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ThermostatOperatingStateCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ThermostatOperatingStateCommand valueOf(byte byteValue) {
        ThermostatOperatingStateCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ThermostatOperatingStateCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

