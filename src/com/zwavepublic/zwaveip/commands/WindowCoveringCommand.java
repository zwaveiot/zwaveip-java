package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* WindowCovering commands (version 1) */
public enum WindowCoveringCommand implements com.zwavepublic.zwaveip.commands.Command {
    SUPPORTED_GET(0x01),
    SUPPORTED_REPORT(0x02),
    GET(0x03),
    REPORT(0x04),
    SET(0x05),
    START_LEVEL_CHANGE(0x06),
    STOP_LEVEL_CHANGE(0x07);

    private static final HashMap<Integer, WindowCoveringCommand> _map = new HashMap<Integer, WindowCoveringCommand>(7);
    static {
        for (WindowCoveringCommand value: WindowCoveringCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private WindowCoveringCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static WindowCoveringCommand valueOf(int intValue) {
        WindowCoveringCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static WindowCoveringCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

