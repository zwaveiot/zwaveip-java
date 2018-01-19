package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ScreenMd commands (version 2) */
public enum ScreenMdCommand implements Command {
    GET((byte)0x01),
    REPORT((byte)0x03);

    private static final HashMap<Byte, ScreenMdCommand> _map = new HashMap<Byte, ScreenMdCommand>(2);
    static {
        for (ScreenMdCommand value: ScreenMdCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ScreenMdCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ScreenMdCommand valueOf(byte byteValue) {
        ScreenMdCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ScreenMdCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

