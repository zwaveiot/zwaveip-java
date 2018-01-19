package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ZipNaming commands (version 1) */
public enum ZipNamingCommand implements Command {
    NAME_SET((byte)0x01),
    NAME_GET((byte)0x02),
    NAME_REPORT((byte)0x03),
    LOCATION_SET((byte)0x04),
    LOCATION_GET((byte)0x05),
    LOCATION_REPORT((byte)0x06);

    private static final HashMap<Byte, ZipNamingCommand> _map = new HashMap<Byte, ZipNamingCommand>(6);
    static {
        for (ZipNamingCommand value: ZipNamingCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ZipNamingCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ZipNamingCommand valueOf(byte byteValue) {
        ZipNamingCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ZipNamingCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

