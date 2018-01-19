package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Version commands (version 2) */
public enum VersionCommand implements Command {
    COMMAND_CLASS_GET((byte)0x13),
    COMMAND_CLASS_REPORT((byte)0x14),
    GET((byte)0x11),
    REPORT((byte)0x12);

    private static final HashMap<Byte, VersionCommand> _map = new HashMap<Byte, VersionCommand>(4);
    static {
        for (VersionCommand value: VersionCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private VersionCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static VersionCommand valueOf(byte byteValue) {
        VersionCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static VersionCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

