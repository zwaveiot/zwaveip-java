package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Configuration commands (version 4) */
public enum ConfigurationCommand implements com.zwavepublic.zwaveip.commands.Command {
    BULK_GET(0x08),
    BULK_REPORT(0x09),
    BULK_SET(0x07),
    GET(0x05),
    REPORT(0x06),
    SET(0x04),
    NAME_GET(0x0a),
    NAME_REPORT(0x0b),
    INFO_GET(0x0c),
    INFO_REPORT(0x0d),
    PROPERTIES_GET(0x0e),
    PROPERTIES_REPORT(0x0f),
    DEFAULT_RESET(0x01);

    private static final HashMap<Integer, ConfigurationCommand> _map = new HashMap<Integer, ConfigurationCommand>(13);
    static {
        for (ConfigurationCommand value: ConfigurationCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ConfigurationCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ConfigurationCommand valueOf(int intValue) {
        ConfigurationCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ConfigurationCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

