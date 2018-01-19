package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* WindowCovering commands (version 1) */
public enum WindowCoveringCommand implements Command {
    SUPPORTED_GET((byte)0x01),
    SUPPORTED_REPORT((byte)0x02),
    GET((byte)0x03),
    REPORT((byte)0x04),
    SET((byte)0x05),
    START_LEVEL_CHANGE((byte)0x06),
    STOP_LEVEL_CHANGE((byte)0x07);

    private static final HashMap<Byte, WindowCoveringCommand> _map = new HashMap<Byte, WindowCoveringCommand>(7);
    static {
        for (WindowCoveringCommand value: WindowCoveringCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private WindowCoveringCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static WindowCoveringCommand valueOf(byte byteValue) {
        WindowCoveringCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static WindowCoveringCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

