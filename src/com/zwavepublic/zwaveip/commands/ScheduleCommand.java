package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Schedule commands (version 3) */
public enum ScheduleCommand implements com.zwavepublic.zwaveip.commands.Command {
    SUPPORTED_GET(0x01),
    SUPPORTED_REPORT(0x02),
    COMMAND_SCHEDULE_SET(0x03),
    COMMAND_SCHEDULE_GET(0x04),
    COMMAND_SCHEDULE_REPORT(0x05),
    REMOVE(0x06),
    STATE_SET(0x07),
    STATE_GET(0x08),
    STATE_REPORT(0x09);

    private static final HashMap<Integer, ScheduleCommand> _map = new HashMap<Integer, ScheduleCommand>(9);
    static {
        for (ScheduleCommand value: ScheduleCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ScheduleCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ScheduleCommand valueOf(int intValue) {
        ScheduleCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ScheduleCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

