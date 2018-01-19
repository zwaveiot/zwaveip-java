package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ZipNd commands (version 1) */
public enum ZipNdCommand implements Command {
    ZIP_NODE_SOLICITATION((byte)0x03),
    ZIP_INV_NODE_SOLICITATION((byte)0x04),
    ZIP_NODE_ADVERTISEMENT((byte)0x01);

    private static final HashMap<Byte, ZipNdCommand> _map = new HashMap<Byte, ZipNdCommand>(3);
    static {
        for (ZipNdCommand value: ZipNdCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ZipNdCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ZipNdCommand valueOf(byte byteValue) {
        ZipNdCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ZipNdCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

