package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* HrvStatus commands (version 1) */
public enum HrvStatusCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x01),
    REPORT(0x02),
    SUPPORTED_GET(0x03),
    SUPPORTED_REPORT(0x04);

    private static final HashMap<Integer, HrvStatusCommand> _map = new HashMap<Integer, HrvStatusCommand>(4);
    static {
        for (HrvStatusCommand value: HrvStatusCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private HrvStatusCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static HrvStatusCommand valueOf(int intValue) {
        HrvStatusCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static HrvStatusCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

