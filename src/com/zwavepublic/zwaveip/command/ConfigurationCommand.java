package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Configuration commands (version 4) */
public enum ConfigurationCommand implements Command {
    BULK_GET((byte)0x08),
    BULK_REPORT((byte)0x09),
    BULK_SET((byte)0x07),
    GET((byte)0x05),
    REPORT((byte)0x06),
    SET((byte)0x04),
    NAME_GET((byte)0x0a),
    NAME_REPORT((byte)0x0b),
    INFO_GET((byte)0x0c),
    INFO_REPORT((byte)0x0d),
    PROPERTIES_GET((byte)0x0e),
    PROPERTIES_REPORT((byte)0x0f),
    DEFAULT_RESET((byte)0x01);

    private static final HashMap<Byte, ConfigurationCommand> _map = new HashMap<Byte, ConfigurationCommand>(13);
    static {
        for (ConfigurationCommand value: ConfigurationCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ConfigurationCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ConfigurationCommand valueOf(byte byteValue) {
        ConfigurationCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ConfigurationCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

