package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Irrigation commands (version 1) */
public enum IrrigationCommand implements com.zwavepublic.zwaveip.commands.Command {
    SYSTEM_INFO_GET(0x01),
    SYSTEM_INFO_REPORT(0x02),
    SYSTEM_STATUS_GET(0x03),
    SYSTEM_STATUS_REPORT(0x04),
    SYSTEM_CONFIG_SET(0x05),
    SYSTEM_CONFIG_GET(0x06),
    SYSTEM_CONFIG_REPORT(0x07),
    VALVE_INFO_GET(0x08),
    VALVE_INFO_REPORT(0x09),
    VALVE_CONFIG_SET(0x0a),
    VALVE_CONFIG_GET(0x0b),
    VALVE_CONFIG_REPORT(0x0c),
    VALVE_RUN(0x0d),
    VALVE_TABLE_SET(0x0e),
    VALVE_TABLE_GET(0x0f),
    VALVE_TABLE_REPORT(0x10),
    VALVE_TABLE_RUN(0x11),
    SYSTEM_SHUTOFF(0x12);

    private static final HashMap<Integer, IrrigationCommand> _map = new HashMap<Integer, IrrigationCommand>(18);
    static {
        for (IrrigationCommand value: IrrigationCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private IrrigationCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static IrrigationCommand valueOf(int intValue) {
        IrrigationCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static IrrigationCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

