package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ScreenAttributes commands (version 2) */
public enum ScreenAttributesCommand implements Command {
    GET((byte)0x01),
    REPORT((byte)0x03);

    private static final HashMap<Byte, ScreenAttributesCommand> _map = new HashMap<Byte, ScreenAttributesCommand>(2);
    static {
        for (ScreenAttributesCommand value: ScreenAttributesCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ScreenAttributesCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ScreenAttributesCommand valueOf(byte byteValue) {
        ScreenAttributesCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ScreenAttributesCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

