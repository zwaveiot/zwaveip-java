package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Supervision commands (version 1) */
public enum SupervisionCommand implements Command {
    GET((byte)0x01),
    REPORT((byte)0x02);

    private static final HashMap<Byte, SupervisionCommand> _map = new HashMap<Byte, SupervisionCommand>(2);
    static {
        for (SupervisionCommand value: SupervisionCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SupervisionCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SupervisionCommand valueOf(byte byteValue) {
        SupervisionCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SupervisionCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

