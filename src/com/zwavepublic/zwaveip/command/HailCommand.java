package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Hail commands (version 1) */
public enum HailCommand implements Command {
    HAIL((byte)0x01);

    private static final HashMap<Byte, HailCommand> _map = new HashMap<Byte, HailCommand>(1);
    static {
        for (HailCommand value: HailCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private HailCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static HailCommand valueOf(byte byteValue) {
        HailCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static HailCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

