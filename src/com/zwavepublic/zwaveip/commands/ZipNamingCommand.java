package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ZipNaming commands (version 1) */
public enum ZipNamingCommand implements com.zwavepublic.zwaveip.commands.Command {
    NAME_SET(0x01),
    NAME_GET(0x02),
    NAME_REPORT(0x03),
    LOCATION_SET(0x04),
    LOCATION_GET(0x05),
    LOCATION_REPORT(0x06);

    private static final HashMap<Integer, ZipNamingCommand> _map = new HashMap<Integer, ZipNamingCommand>(6);
    static {
        for (ZipNamingCommand value: ZipNamingCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ZipNamingCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ZipNamingCommand valueOf(int intValue) {
        ZipNamingCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ZipNamingCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

