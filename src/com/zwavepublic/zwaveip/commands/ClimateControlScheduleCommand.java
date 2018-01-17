package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ClimateControlSchedule commands (version 1) */
public enum ClimateControlScheduleCommand implements com.zwavepublic.zwaveip.commands.Command {
    SCHEDULE_CHANGED_GET(0x04),
    SCHEDULE_CHANGED_REPORT(0x05),
    SCHEDULE_GET(0x02),
    SCHEDULE_OVERRIDE_GET(0x07),
    SCHEDULE_OVERRIDE_REPORT(0x08),
    SCHEDULE_OVERRIDE_SET(0x06),
    SCHEDULE_REPORT(0x03),
    SCHEDULE_SET(0x01);

    private static final HashMap<Integer, ClimateControlScheduleCommand> _map = new HashMap<Integer, ClimateControlScheduleCommand>(8);
    static {
        for (ClimateControlScheduleCommand value: ClimateControlScheduleCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ClimateControlScheduleCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ClimateControlScheduleCommand valueOf(int intValue) {
        ClimateControlScheduleCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ClimateControlScheduleCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

