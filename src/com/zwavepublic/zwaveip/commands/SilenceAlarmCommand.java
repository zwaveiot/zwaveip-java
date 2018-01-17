package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SilenceAlarm commands (version 1) */
public enum SilenceAlarmCommand implements com.zwavepublic.zwaveip.commands.Command {
    SENSOR_ALARM_SET(0x01);

    private static final HashMap<Integer, SilenceAlarmCommand> _map = new HashMap<Integer, SilenceAlarmCommand>(1);
    static {
        for (SilenceAlarmCommand value: SilenceAlarmCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SilenceAlarmCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SilenceAlarmCommand valueOf(int intValue) {
        SilenceAlarmCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SilenceAlarmCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

