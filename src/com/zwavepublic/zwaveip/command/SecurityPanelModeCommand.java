package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SecurityPanelMode commands (version 1) */
public enum SecurityPanelModeCommand implements Command {
    GET((byte)0x03),
    REPORT((byte)0x04),
    SET((byte)0x05),
    SUPPORTED_GET((byte)0x01),
    SUPPORTED_REPORT((byte)0x02);

    private static final HashMap<Byte, SecurityPanelModeCommand> _map = new HashMap<Byte, SecurityPanelModeCommand>(5);
    static {
        for (SecurityPanelModeCommand value: SecurityPanelModeCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SecurityPanelModeCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SecurityPanelModeCommand valueOf(byte byteValue) {
        SecurityPanelModeCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SecurityPanelModeCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

