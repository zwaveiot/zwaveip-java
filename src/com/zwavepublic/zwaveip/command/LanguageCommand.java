package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Language commands (version 1) */
public enum LanguageCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01);

    private static final HashMap<Byte, LanguageCommand> _map = new HashMap<Byte, LanguageCommand>(3);
    static {
        for (LanguageCommand value: LanguageCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private LanguageCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static LanguageCommand valueOf(byte byteValue) {
        LanguageCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static LanguageCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

