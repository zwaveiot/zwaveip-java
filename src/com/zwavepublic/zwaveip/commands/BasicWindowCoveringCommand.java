package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* BasicWindowCovering commands (version 1) */
public enum BasicWindowCoveringCommand implements com.zwavepublic.zwaveip.commands.Command {
    START_LEVEL_CHANGE(0x01),
    STOP_LEVEL_CHANGE(0x02);

    private static final HashMap<Integer, BasicWindowCoveringCommand> _map = new HashMap<Integer, BasicWindowCoveringCommand>(2);
    static {
        for (BasicWindowCoveringCommand value: BasicWindowCoveringCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private BasicWindowCoveringCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static BasicWindowCoveringCommand valueOf(int intValue) {
        BasicWindowCoveringCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static BasicWindowCoveringCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

