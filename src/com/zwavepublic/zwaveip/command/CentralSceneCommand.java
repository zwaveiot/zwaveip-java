package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* CentralScene commands (version 3) */
public enum CentralSceneCommand implements Command {
    SUPPORTED_GET((byte)0x01),
    SUPPORTED_REPORT((byte)0x02),
    NOTIFICATION((byte)0x03),
    CONFIGURATION_SET((byte)0x04),
    CONFIGURATION_GET((byte)0x05),
    CONFIGURATION_REPORT((byte)0x06);

    private static final HashMap<Byte, CentralSceneCommand> _map = new HashMap<Byte, CentralSceneCommand>(6);
    static {
        for (CentralSceneCommand value: CentralSceneCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private CentralSceneCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static CentralSceneCommand valueOf(byte byteValue) {
        CentralSceneCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static CentralSceneCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

