package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* AvTaggingMd commands (version 1) */
public enum AvTaggingMdCommand implements Command {
    GET((byte)0x01),
    REPORT((byte)0x02);

    private static final HashMap<Byte, AvTaggingMdCommand> _map = new HashMap<Byte, AvTaggingMdCommand>(2);
    static {
        for (AvTaggingMdCommand value: AvTaggingMdCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private AvTaggingMdCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static AvTaggingMdCommand valueOf(byte byteValue) {
        AvTaggingMdCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AvTaggingMdCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

