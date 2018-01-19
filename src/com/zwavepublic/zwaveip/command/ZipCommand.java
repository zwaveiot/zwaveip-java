package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Zip commands (version 3) */
public enum ZipCommand implements Command {
    COMMAND_ZIP_PACKET((byte)0x02);

    private static final HashMap<Byte, ZipCommand> _map = new HashMap<Byte, ZipCommand>(1);
    static {
        for (ZipCommand value: ZipCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ZipCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ZipCommand valueOf(byte byteValue) {
        ZipCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ZipCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

