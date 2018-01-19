package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Security commands (version 1) */
public enum SecurityCommand implements Command {
    NETWORK_KEY_SET((byte)0x06),
    NETWORK_KEY_VERIFY((byte)0x07),
    COMMANDS_SUPPORTED_GET((byte)0x02),
    COMMANDS_SUPPORTED_REPORT((byte)0x03),
    MESSAGE_ENCAPSULATION((byte)0x81),
    MESSAGE_ENCAPSULATION_NONCE_GET((byte)0xc1),
    NONCE_GET((byte)0x40),
    NONCE_REPORT((byte)0x80),
    SCHEME_GET((byte)0x04),
    SCHEME_INHERIT((byte)0x08),
    SCHEME_REPORT((byte)0x05);

    private static final HashMap<Byte, SecurityCommand> _map = new HashMap<Byte, SecurityCommand>(11);
    static {
        for (SecurityCommand value: SecurityCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SecurityCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SecurityCommand valueOf(byte byteValue) {
        SecurityCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SecurityCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

