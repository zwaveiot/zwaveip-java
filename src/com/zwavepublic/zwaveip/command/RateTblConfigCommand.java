package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* RateTblConfig commands (version 1) */
public enum RateTblConfigCommand implements Command {
    RATE_TBL_REMOVE((byte)0x02),
    RATE_TBL_SET((byte)0x01);

    private static final HashMap<Byte, RateTblConfigCommand> _map = new HashMap<Byte, RateTblConfigCommand>(2);
    static {
        for (RateTblConfigCommand value: RateTblConfigCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private RateTblConfigCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static RateTblConfigCommand valueOf(byte byteValue) {
        RateTblConfigCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static RateTblConfigCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

