package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* AvContentSearchMd commands (version 1) */
public enum AvContentSearchMdCommand implements Command {
    GET((byte)0x01),
    REPORT((byte)0x02);

    private static final HashMap<Byte, AvContentSearchMdCommand> _map = new HashMap<Byte, AvContentSearchMdCommand>(2);
    static {
        for (AvContentSearchMdCommand value: AvContentSearchMdCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private AvContentSearchMdCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static AvContentSearchMdCommand valueOf(byte byteValue) {
        AvContentSearchMdCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AvContentSearchMdCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

