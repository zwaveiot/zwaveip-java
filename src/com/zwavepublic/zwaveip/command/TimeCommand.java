package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Time commands (version 2) */
public enum TimeCommand implements Command {
    DATE_GET((byte)0x03),
    DATE_REPORT((byte)0x04),
    GET((byte)0x01),
    OFFSET_GET((byte)0x06),
    OFFSET_REPORT((byte)0x07),
    OFFSET_SET((byte)0x05),
    REPORT((byte)0x02);

    private static final HashMap<Byte, TimeCommand> _map = new HashMap<Byte, TimeCommand>(7);
    static {
        for (TimeCommand value: TimeCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private TimeCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static TimeCommand valueOf(byte byteValue) {
        TimeCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static TimeCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

