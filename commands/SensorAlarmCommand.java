package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SensorAlarm commands (version 1) */
public enum SensorAlarmCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x01),
    REPORT(0x02),
    SUPPORTED_GET(0x03),
    SUPPORTED_REPORT(0x04);

    private static final HashMap<Integer, SensorAlarmCommand> _map = new HashMap<Integer, SensorAlarmCommand>(4);
    static {
        for (SensorAlarmCommand value: SensorAlarmCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SensorAlarmCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SensorAlarmCommand valueOf(int intValue) {
        SensorAlarmCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SensorAlarmCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

