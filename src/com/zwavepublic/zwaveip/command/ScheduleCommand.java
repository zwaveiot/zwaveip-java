package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Schedule commands (version 3) */
public enum ScheduleCommand implements Command {
    SUPPORTED_GET((byte)0x01),
    SUPPORTED_REPORT((byte)0x02),
    COMMAND_SCHEDULE_SET((byte)0x03),
    COMMAND_SCHEDULE_GET((byte)0x04),
    COMMAND_SCHEDULE_REPORT((byte)0x05),
    REMOVE((byte)0x06),
    STATE_SET((byte)0x07),
    STATE_GET((byte)0x08),
    STATE_REPORT((byte)0x09);

    private static final HashMap<Byte, ScheduleCommand> _map = new HashMap<Byte, ScheduleCommand>(9);
    static {
        for (ScheduleCommand value: ScheduleCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ScheduleCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ScheduleCommand valueOf(byte byteValue) {
        ScheduleCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ScheduleCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

