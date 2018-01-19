package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SilenceAlarm commands (version 1) */
public enum SilenceAlarmCommand implements Command {
    SENSOR_ALARM_SET((byte)0x01);

    private static final HashMap<Byte, SilenceAlarmCommand> _map = new HashMap<Byte, SilenceAlarmCommand>(1);
    static {
        for (SilenceAlarmCommand value: SilenceAlarmCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SilenceAlarmCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SilenceAlarmCommand valueOf(byte byteValue) {
        SilenceAlarmCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SilenceAlarmCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

