package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Lock commands (version 1) */
public enum LockCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01);

    private static final HashMap<Byte, LockCommand> _map = new HashMap<Byte, LockCommand>(3);
    static {
        for (LockCommand value: LockCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private LockCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static LockCommand valueOf(byte byteValue) {
        LockCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static LockCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

