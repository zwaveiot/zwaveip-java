package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* UserCode commands (version 1) */
public enum UserCodeCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01),
    USERS_NUMBER_GET((byte)0x04),
    USERS_NUMBER_REPORT((byte)0x05);

    private static final HashMap<Byte, UserCodeCommand> _map = new HashMap<Byte, UserCodeCommand>(5);
    static {
        for (UserCodeCommand value: UserCodeCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private UserCodeCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static UserCodeCommand valueOf(byte byteValue) {
        UserCodeCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static UserCodeCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

