package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SwitchAll commands (version 1) */
public enum SwitchAllCommand implements Command {
    GET((byte)0x02),
    OFF((byte)0x05),
    ON((byte)0x04),
    REPORT((byte)0x03),
    SET((byte)0x01);

    private static final HashMap<Byte, SwitchAllCommand> _map = new HashMap<Byte, SwitchAllCommand>(5);
    static {
        for (SwitchAllCommand value: SwitchAllCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SwitchAllCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SwitchAllCommand valueOf(byte byteValue) {
        SwitchAllCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SwitchAllCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

