package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ZensorNet commands (version 1) */
public enum ZensorNetCommand implements Command {
    BIND_ACCEPT((byte)0x02),
    BIND_COMPLETE((byte)0x03),
    BIND_REQUEST((byte)0x01);

    private static final HashMap<Byte, ZensorNetCommand> _map = new HashMap<Byte, ZensorNetCommand>(3);
    static {
        for (ZensorNetCommand value: ZensorNetCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ZensorNetCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ZensorNetCommand valueOf(byte byteValue) {
        ZensorNetCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ZensorNetCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

