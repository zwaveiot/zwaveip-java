package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SecurityPanelZone commands (version 1) */
public enum SecurityPanelZoneCommand implements Command {
    NUMBER_SUPPORTED_GET((byte)0x01),
    STATE_GET((byte)0x05),
    STATE_REPORT((byte)0x06),
    SUPPORTED_REPORT((byte)0x02),
    TYPE_GET((byte)0x03),
    TYPE_REPORT((byte)0x04);

    private static final HashMap<Byte, SecurityPanelZoneCommand> _map = new HashMap<Byte, SecurityPanelZoneCommand>(6);
    static {
        for (SecurityPanelZoneCommand value: SecurityPanelZoneCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SecurityPanelZoneCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SecurityPanelZoneCommand valueOf(byte byteValue) {
        SecurityPanelZoneCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SecurityPanelZoneCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

