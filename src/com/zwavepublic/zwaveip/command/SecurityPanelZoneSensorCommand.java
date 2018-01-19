package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SecurityPanelZoneSensor commands (version 1) */
public enum SecurityPanelZoneSensorCommand implements Command {
    COMMAND_CLASS_SECURITY_PANEL_ZONE_SENSOR_INSTALLED_REPORT((byte)0x02),
    TYPE_GET((byte)0x03),
    TYPE_REPORT((byte)0x04),
    INSTALLED_GET((byte)0x01),
    STATE_GET((byte)0x05),
    STATE_REPORT((byte)0x06);

    private static final HashMap<Byte, SecurityPanelZoneSensorCommand> _map = new HashMap<Byte, SecurityPanelZoneSensorCommand>(6);
    static {
        for (SecurityPanelZoneSensorCommand value: SecurityPanelZoneSensorCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SecurityPanelZoneSensorCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SecurityPanelZoneSensorCommand valueOf(byte byteValue) {
        SecurityPanelZoneSensorCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SecurityPanelZoneSensorCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

