package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ClimateControlSchedule commands (version 1) */
public enum ClimateControlScheduleCommand implements Command {
    SCHEDULE_CHANGED_GET((byte)0x04),
    SCHEDULE_CHANGED_REPORT((byte)0x05),
    SCHEDULE_GET((byte)0x02),
    SCHEDULE_OVERRIDE_GET((byte)0x07),
    SCHEDULE_OVERRIDE_REPORT((byte)0x08),
    SCHEDULE_OVERRIDE_SET((byte)0x06),
    SCHEDULE_REPORT((byte)0x03),
    SCHEDULE_SET((byte)0x01);

    private static final HashMap<Byte, ClimateControlScheduleCommand> _map = new HashMap<Byte, ClimateControlScheduleCommand>(8);
    static {
        for (ClimateControlScheduleCommand value: ClimateControlScheduleCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ClimateControlScheduleCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ClimateControlScheduleCommand valueOf(byte byteValue) {
        ClimateControlScheduleCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ClimateControlScheduleCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

