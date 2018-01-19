package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* HrvStatus commands (version 1) */
public enum HrvStatusCommand implements Command {
    GET((byte)0x01),
    REPORT((byte)0x02),
    SUPPORTED_GET((byte)0x03),
    SUPPORTED_REPORT((byte)0x04);

    private static final HashMap<Byte, HrvStatusCommand> _map = new HashMap<Byte, HrvStatusCommand>(4);
    static {
        for (HrvStatusCommand value: HrvStatusCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private HrvStatusCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static HrvStatusCommand valueOf(byte byteValue) {
        HrvStatusCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static HrvStatusCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

