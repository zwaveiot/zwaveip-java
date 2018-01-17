package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Lock commands (version 1) */
public enum LockCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01);

    private static final HashMap<Integer, LockCommand> _map = new HashMap<Integer, LockCommand>(3);
    static {
        for (LockCommand value: LockCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private LockCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static LockCommand valueOf(int intValue) {
        LockCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static LockCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

