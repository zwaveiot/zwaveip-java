package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* AvRendererStatus commands (version 1) */
public enum AvRendererStatusCommand implements Command {
    GET((byte)0x01),
    REPORT((byte)0x02);

    private static final HashMap<Byte, AvRendererStatusCommand> _map = new HashMap<Byte, AvRendererStatusCommand>(2);
    static {
        for (AvRendererStatusCommand value: AvRendererStatusCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private AvRendererStatusCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static AvRendererStatusCommand valueOf(byte byteValue) {
        AvRendererStatusCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AvRendererStatusCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

