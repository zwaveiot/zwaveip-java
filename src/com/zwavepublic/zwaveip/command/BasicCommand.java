package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Basic commands (version 2) */
public enum BasicCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01);

    private static final HashMap<Byte, BasicCommand> _map = new HashMap<Byte, BasicCommand>(3);
    static {
        for (BasicCommand value: BasicCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private BasicCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static BasicCommand valueOf(byte byteValue) {
        BasicCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static BasicCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

