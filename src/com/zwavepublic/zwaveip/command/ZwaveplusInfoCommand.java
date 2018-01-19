package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ZwaveplusInfo commands (version 2) */
public enum ZwaveplusInfoCommand implements Command {
    GET((byte)0x01),
    REPORT((byte)0x02);

    private static final HashMap<Byte, ZwaveplusInfoCommand> _map = new HashMap<Byte, ZwaveplusInfoCommand>(2);
    static {
        for (ZwaveplusInfoCommand value: ZwaveplusInfoCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ZwaveplusInfoCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ZwaveplusInfoCommand valueOf(byte byteValue) {
        ZwaveplusInfoCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ZwaveplusInfoCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

