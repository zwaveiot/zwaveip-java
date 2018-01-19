package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ScheduleEntryLock commands (version 3) */
public enum ScheduleEntryLockCommand implements Command {
    ENABLE_ALL_SET((byte)0x02),
    ENABLE_SET((byte)0x01),
    TIME_OFFSET_GET((byte)0x0b),
    TIME_OFFSET_REPORT((byte)0x0c),
    TIME_OFFSET_SET((byte)0x0d),
    WEEK_DAY_GET((byte)0x04),
    WEEK_DAY_REPORT((byte)0x05),
    WEEK_DAY_SET((byte)0x03),
    YEAR_DAY_GET((byte)0x07),
    YEAR_DAY_REPORT((byte)0x08),
    YEAR_DAY_SET((byte)0x06),
    SCHEDULE_ENTRY_TYPE_SUPPORTED_GET((byte)0x09),
    SCHEDULE_ENTRY_TYPE_SUPPORTED_REPORT((byte)0x0a),
    DAILY_REPEATING_GET((byte)0x0e),
    DAILY_REPEATING_REPORT((byte)0x0f),
    DAILY_REPEATING_SET((byte)0x10);

    private static final HashMap<Byte, ScheduleEntryLockCommand> _map = new HashMap<Byte, ScheduleEntryLockCommand>(16);
    static {
        for (ScheduleEntryLockCommand value: ScheduleEntryLockCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ScheduleEntryLockCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ScheduleEntryLockCommand valueOf(byte byteValue) {
        ScheduleEntryLockCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ScheduleEntryLockCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

