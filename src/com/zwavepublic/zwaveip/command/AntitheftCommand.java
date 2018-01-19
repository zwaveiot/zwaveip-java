package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Antitheft commands (version 2) */
public enum AntitheftCommand implements Command {
    SET((byte)0x01),
    GET((byte)0x02),
    REPORT((byte)0x03);

    private static final HashMap<Byte, AntitheftCommand> _map = new HashMap<Byte, AntitheftCommand>(3);
    static {
        for (AntitheftCommand value: AntitheftCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private AntitheftCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static AntitheftCommand valueOf(byte byteValue) {
        AntitheftCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AntitheftCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

