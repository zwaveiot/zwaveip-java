package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SwitchToggleBinary commands (version 1) */
public enum SwitchToggleBinaryCommand implements Command {
    SET((byte)0x01),
    GET((byte)0x02),
    REPORT((byte)0x03);

    private static final HashMap<Byte, SwitchToggleBinaryCommand> _map = new HashMap<Byte, SwitchToggleBinaryCommand>(3);
    static {
        for (SwitchToggleBinaryCommand value: SwitchToggleBinaryCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SwitchToggleBinaryCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SwitchToggleBinaryCommand valueOf(byte byteValue) {
        SwitchToggleBinaryCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SwitchToggleBinaryCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

