package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* WakeUp commands (version 2) */
public enum WakeUpCommand implements Command {
    INTERVAL_CAPABILITIES_GET((byte)0x09),
    INTERVAL_CAPABILITIES_REPORT((byte)0x0a),
    INTERVAL_GET((byte)0x05),
    INTERVAL_REPORT((byte)0x06),
    INTERVAL_SET((byte)0x04),
    NO_MORE_INFORMATION((byte)0x08),
    NOTIFICATION((byte)0x07);

    private static final HashMap<Byte, WakeUpCommand> _map = new HashMap<Byte, WakeUpCommand>(7);
    static {
        for (WakeUpCommand value: WakeUpCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private WakeUpCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static WakeUpCommand valueOf(byte byteValue) {
        WakeUpCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static WakeUpCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

