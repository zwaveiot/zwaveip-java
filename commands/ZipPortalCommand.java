package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ZipPortal commands (version 1) */
public enum ZipPortalCommand implements com.zwavepublic.zwaveip.commands.Command {
    GATEWAY_CONFIGURATION_SET(0x01),
    GATEWAY_CONFIGURATION_STATUS(0x02),
    GATEWAY_CONFIGURATION_GET(0x03),
    GATEWAY_CONFIGURATION_REPORT(0x04);

    private static final HashMap<Integer, ZipPortalCommand> _map = new HashMap<Integer, ZipPortalCommand>(4);
    static {
        for (ZipPortalCommand value: ZipPortalCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ZipPortalCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ZipPortalCommand valueOf(int intValue) {
        ZipPortalCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ZipPortalCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

