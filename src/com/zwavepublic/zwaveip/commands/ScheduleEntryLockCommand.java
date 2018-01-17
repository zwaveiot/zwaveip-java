package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ScheduleEntryLock commands (version 3) */
public enum ScheduleEntryLockCommand implements com.zwavepublic.zwaveip.commands.Command {
    ENABLE_ALL_SET(0x02),
    ENABLE_SET(0x01),
    TIME_OFFSET_GET(0x0b),
    TIME_OFFSET_REPORT(0x0c),
    TIME_OFFSET_SET(0x0d),
    WEEK_DAY_GET(0x04),
    WEEK_DAY_REPORT(0x05),
    WEEK_DAY_SET(0x03),
    YEAR_DAY_GET(0x07),
    YEAR_DAY_REPORT(0x08),
    YEAR_DAY_SET(0x06),
    SCHEDULE_ENTRY_TYPE_SUPPORTED_GET(0x09),
    SCHEDULE_ENTRY_TYPE_SUPPORTED_REPORT(0x0a),
    DAILY_REPEATING_GET(0x0e),
    DAILY_REPEATING_REPORT(0x0f),
    DAILY_REPEATING_SET(0x10);

    private static final HashMap<Integer, ScheduleEntryLockCommand> _map = new HashMap<Integer, ScheduleEntryLockCommand>(16);
    static {
        for (ScheduleEntryLockCommand value: ScheduleEntryLockCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ScheduleEntryLockCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ScheduleEntryLockCommand valueOf(int intValue) {
        ScheduleEntryLockCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ScheduleEntryLockCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

