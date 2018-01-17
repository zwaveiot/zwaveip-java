package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Security commands (version 1) */
public enum SecurityCommand implements com.zwavepublic.zwaveip.commands.Command {
    NETWORK_KEY_SET(0x06),
    NETWORK_KEY_VERIFY(0x07),
    COMMANDS_SUPPORTED_GET(0x02),
    COMMANDS_SUPPORTED_REPORT(0x03),
    MESSAGE_ENCAPSULATION(0x81),
    MESSAGE_ENCAPSULATION_NONCE_GET(0xc1),
    NONCE_GET(0x40),
    NONCE_REPORT(0x80),
    SCHEME_GET(0x04),
    SCHEME_INHERIT(0x08),
    SCHEME_REPORT(0x05);

    private static final HashMap<Integer, SecurityCommand> _map = new HashMap<Integer, SecurityCommand>(11);
    static {
        for (SecurityCommand value: SecurityCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SecurityCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SecurityCommand valueOf(int intValue) {
        SecurityCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SecurityCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

