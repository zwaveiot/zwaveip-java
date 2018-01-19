package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SwitchBinary commands (version 2) */
public enum SwitchBinaryCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01);

    private static final HashMap<Byte, SwitchBinaryCommand> _map = new HashMap<Byte, SwitchBinaryCommand>(3);
    static {
        for (SwitchBinaryCommand value: SwitchBinaryCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SwitchBinaryCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SwitchBinaryCommand valueOf(byte byteValue) {
        SwitchBinaryCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SwitchBinaryCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

