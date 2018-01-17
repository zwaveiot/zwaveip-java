package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SecurityPanelZoneSensor commands (version 1) */
public enum SecurityPanelZoneSensorCommand implements com.zwavepublic.zwaveip.commands.Command {
    COMMAND_CLASS_SECURITY_PANEL_ZONE_SENSOR_INSTALLED_REPORT(0x02),
    TYPE_GET(0x03),
    TYPE_REPORT(0x04),
    INSTALLED_GET(0x01),
    STATE_GET(0x05),
    STATE_REPORT(0x06);

    private static final HashMap<Integer, SecurityPanelZoneSensorCommand> _map = new HashMap<Integer, SecurityPanelZoneSensorCommand>(6);
    static {
        for (SecurityPanelZoneSensorCommand value: SecurityPanelZoneSensorCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SecurityPanelZoneSensorCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SecurityPanelZoneSensorCommand valueOf(int intValue) {
        SecurityPanelZoneSensorCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SecurityPanelZoneSensorCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

