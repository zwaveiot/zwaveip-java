package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* BasicWindowCovering commands (version 1) */
public enum BasicWindowCoveringCommand implements Command {
    START_LEVEL_CHANGE((byte)0x01),
    STOP_LEVEL_CHANGE((byte)0x02);

    private static final HashMap<Byte, BasicWindowCoveringCommand> _map = new HashMap<Byte, BasicWindowCoveringCommand>(2);
    static {
        for (BasicWindowCoveringCommand value: BasicWindowCoveringCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private BasicWindowCoveringCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static BasicWindowCoveringCommand valueOf(byte byteValue) {
        BasicWindowCoveringCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static BasicWindowCoveringCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

