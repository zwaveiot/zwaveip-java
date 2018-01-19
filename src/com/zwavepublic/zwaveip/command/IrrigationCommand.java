package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Irrigation commands (version 1) */
public enum IrrigationCommand implements Command {
    SYSTEM_INFO_GET((byte)0x01),
    SYSTEM_INFO_REPORT((byte)0x02),
    SYSTEM_STATUS_GET((byte)0x03),
    SYSTEM_STATUS_REPORT((byte)0x04),
    SYSTEM_CONFIG_SET((byte)0x05),
    SYSTEM_CONFIG_GET((byte)0x06),
    SYSTEM_CONFIG_REPORT((byte)0x07),
    VALVE_INFO_GET((byte)0x08),
    VALVE_INFO_REPORT((byte)0x09),
    VALVE_CONFIG_SET((byte)0x0a),
    VALVE_CONFIG_GET((byte)0x0b),
    VALVE_CONFIG_REPORT((byte)0x0c),
    VALVE_RUN((byte)0x0d),
    VALVE_TABLE_SET((byte)0x0e),
    VALVE_TABLE_GET((byte)0x0f),
    VALVE_TABLE_REPORT((byte)0x10),
    VALVE_TABLE_RUN((byte)0x11),
    SYSTEM_SHUTOFF((byte)0x12);

    private static final HashMap<Byte, IrrigationCommand> _map = new HashMap<Byte, IrrigationCommand>(18);
    static {
        for (IrrigationCommand value: IrrigationCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private IrrigationCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static IrrigationCommand valueOf(byte byteValue) {
        IrrigationCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static IrrigationCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

