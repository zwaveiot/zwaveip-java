package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* TimeParameters commands (version 1) */
public enum TimeParametersCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01);

    private static final HashMap<Byte, TimeParametersCommand> _map = new HashMap<Byte, TimeParametersCommand>(3);
    static {
        for (TimeParametersCommand value: TimeParametersCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private TimeParametersCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static TimeParametersCommand valueOf(byte byteValue) {
        TimeParametersCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static TimeParametersCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

