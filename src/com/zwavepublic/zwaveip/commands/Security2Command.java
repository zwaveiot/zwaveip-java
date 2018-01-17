package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Security2 commands (version 1) */
public enum Security2Command implements com.zwavepublic.zwaveip.commands.Command {
    NONCE_GET(0x01),
    NONCE_REPORT(0x02),
    MESSAGE_ENCAPSULATION(0x03),
    KEX_GET(0x04),
    KEX_REPORT(0x05),
    KEX_SET(0x06),
    KEX_FAIL(0x07),
    PUBLIC_KEY_REPORT(0x08),
    NETWORK_KEY_GET(0x09),
    NETWORK_KEY_REPORT(0x0a),
    NETWORK_KEY_VERIFY(0x0b),
    TRANSFER_END(0x0c),
    COMMANDS_SUPPORTED_GET(0x0d),
    COMMANDS_SUPPORTED_REPORT(0x0e),
    CAPABILITIES_GET(0x0f),
    CAPABILITIES_REPORT(0x10);

    private static final HashMap<Integer, Security2Command> _map = new HashMap<Integer, Security2Command>(16);
    static {
        for (Security2Command value: Security2Command.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private Security2Command(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static Security2Command valueOf(int intValue) {
        Security2Command result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static Security2Command valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

