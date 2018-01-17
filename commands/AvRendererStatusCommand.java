package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* AvRendererStatus commands (version 1) */
public enum AvRendererStatusCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x01),
    REPORT(0x02);

    private static final HashMap<Integer, AvRendererStatusCommand> _map = new HashMap<Integer, AvRendererStatusCommand>(2);
    static {
        for (AvRendererStatusCommand value: AvRendererStatusCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private AvRendererStatusCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static AvRendererStatusCommand valueOf(int intValue) {
        AvRendererStatusCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AvRendererStatusCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

