package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ZipPortal commands (version 1) */
public enum ZipPortalCommand implements Command {
    GATEWAY_CONFIGURATION_SET((byte)0x01),
    GATEWAY_CONFIGURATION_STATUS((byte)0x02),
    GATEWAY_CONFIGURATION_GET((byte)0x03),
    GATEWAY_CONFIGURATION_REPORT((byte)0x04);

    private static final HashMap<Byte, ZipPortalCommand> _map = new HashMap<Byte, ZipPortalCommand>(4);
    static {
        for (ZipPortalCommand value: ZipPortalCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ZipPortalCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ZipPortalCommand valueOf(byte byteValue) {
        ZipPortalCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ZipPortalCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

