package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* UserCode commands (version 1) */
public enum UserCodeCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01),
    USERS_NUMBER_GET(0x04),
    USERS_NUMBER_REPORT(0x05);

    private static final HashMap<Integer, UserCodeCommand> _map = new HashMap<Integer, UserCodeCommand>(5);
    static {
        for (UserCodeCommand value: UserCodeCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private UserCodeCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static UserCodeCommand valueOf(int intValue) {
        UserCodeCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static UserCodeCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

