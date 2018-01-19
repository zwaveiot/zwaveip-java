package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SensorAlarm commands (version 1) */
public enum SensorAlarmCommand implements Command {
    GET((byte)0x01),
    REPORT((byte)0x02),
    SUPPORTED_GET((byte)0x03),
    SUPPORTED_REPORT((byte)0x04);

    private static final HashMap<Byte, SensorAlarmCommand> _map = new HashMap<Byte, SensorAlarmCommand>(4);
    static {
        for (SensorAlarmCommand value: SensorAlarmCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SensorAlarmCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SensorAlarmCommand valueOf(byte byteValue) {
        SensorAlarmCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SensorAlarmCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

