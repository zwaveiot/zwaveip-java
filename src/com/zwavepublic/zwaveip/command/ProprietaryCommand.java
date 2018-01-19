package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Proprietary commands (version 1) */
public enum ProprietaryCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01);

    private static final HashMap<Byte, ProprietaryCommand> _map = new HashMap<Byte, ProprietaryCommand>(3);
    static {
        for (ProprietaryCommand value: ProprietaryCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ProprietaryCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ProprietaryCommand valueOf(byte byteValue) {
        ProprietaryCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ProprietaryCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

