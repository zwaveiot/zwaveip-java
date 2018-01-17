package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* SwitchColor commands (version 3) */
public enum SwitchColorCommand implements com.zwavepublic.zwaveip.commands.Command {
    SUPPORTED_GET(0x01),
    SUPPORTED_REPORT(0x02),
    GET(0x03),
    REPORT(0x04),
    SET(0x05),
    START_LEVEL_CHANGE(0x06),
    STOP_LEVEL_CHANGE(0x07);

    private static final HashMap<Integer, SwitchColorCommand> _map = new HashMap<Integer, SwitchColorCommand>(7);
    static {
        for (SwitchColorCommand value: SwitchColorCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SwitchColorCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SwitchColorCommand valueOf(int intValue) {
        SwitchColorCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SwitchColorCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

