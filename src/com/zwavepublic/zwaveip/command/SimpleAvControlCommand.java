package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SimpleAvControl commands (version 1) */
public enum SimpleAvControlCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01),
    SUPPORTED_GET((byte)0x04),
    SUPPORTED_REPORT((byte)0x05);

    private static final HashMap<Byte, SimpleAvControlCommand> _map = new HashMap<Byte, SimpleAvControlCommand>(5);
    static {
        for (SimpleAvControlCommand value: SimpleAvControlCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SimpleAvControlCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SimpleAvControlCommand valueOf(byte byteValue) {
        SimpleAvControlCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SimpleAvControlCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

