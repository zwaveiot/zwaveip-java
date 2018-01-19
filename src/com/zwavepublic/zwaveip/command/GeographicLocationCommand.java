package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* GeographicLocation commands (version 1) */
public enum GeographicLocationCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01);

    private static final HashMap<Byte, GeographicLocationCommand> _map = new HashMap<Byte, GeographicLocationCommand>(3);
    static {
        for (GeographicLocationCommand value: GeographicLocationCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private GeographicLocationCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static GeographicLocationCommand valueOf(byte byteValue) {
        GeographicLocationCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static GeographicLocationCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

