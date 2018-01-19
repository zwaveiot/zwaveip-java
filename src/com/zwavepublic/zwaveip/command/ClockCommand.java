package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Clock commands (version 1) */
public enum ClockCommand implements Command {
    GET((byte)0x05),
    REPORT((byte)0x06),
    SET((byte)0x04);

    private static final HashMap<Byte, ClockCommand> _map = new HashMap<Byte, ClockCommand>(3);
    static {
        for (ClockCommand value: ClockCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ClockCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ClockCommand valueOf(byte byteValue) {
        ClockCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ClockCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

