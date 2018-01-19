package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Security2 commands (version 1) */
public enum Security2Command implements Command {
    NONCE_GET((byte)0x01),
    NONCE_REPORT((byte)0x02),
    MESSAGE_ENCAPSULATION((byte)0x03),
    KEX_GET((byte)0x04),
    KEX_REPORT((byte)0x05),
    KEX_SET((byte)0x06),
    KEX_FAIL((byte)0x07),
    PUBLIC_KEY_REPORT((byte)0x08),
    NETWORK_KEY_GET((byte)0x09),
    NETWORK_KEY_REPORT((byte)0x0a),
    NETWORK_KEY_VERIFY((byte)0x0b),
    TRANSFER_END((byte)0x0c),
    COMMANDS_SUPPORTED_GET((byte)0x0d),
    COMMANDS_SUPPORTED_REPORT((byte)0x0e),
    CAPABILITIES_GET((byte)0x0f),
    CAPABILITIES_REPORT((byte)0x10);

    private static final HashMap<Byte, Security2Command> _map = new HashMap<Byte, Security2Command>(16);
    static {
        for (Security2Command value: Security2Command.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private Security2Command(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static Security2Command valueOf(byte byteValue) {
        Security2Command result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static Security2Command valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

