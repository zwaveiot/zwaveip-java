package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SecurityPanelZone commands (version 1) */
public enum SecurityPanelZoneCommand implements com.zwavepublic.zwaveip.commands.Command {
    NUMBER_SUPPORTED_GET(0x01),
    STATE_GET(0x05),
    STATE_REPORT(0x06),
    SUPPORTED_REPORT(0x02),
    TYPE_GET(0x03),
    TYPE_REPORT(0x04);

    private static final HashMap<Integer, SecurityPanelZoneCommand> _map = new HashMap<Integer, SecurityPanelZoneCommand>(6);
    static {
        for (SecurityPanelZoneCommand value: SecurityPanelZoneCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SecurityPanelZoneCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SecurityPanelZoneCommand valueOf(int intValue) {
        SecurityPanelZoneCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SecurityPanelZoneCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

