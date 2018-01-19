package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* EntryControl commands (version 1) */
public enum EntryControlCommand implements Command {
    NOTIFICATION((byte)0x01),
    KEY_SUPPORTED_GET((byte)0x02),
    KEY_SUPPORTED_REPORT((byte)0x03),
    EVENT_SUPPORTED_GET((byte)0x04),
    EVENT_SUPPORTED_REPORT((byte)0x05),
    CONFIGURATION_SET((byte)0x06),
    CONFIGURATION_GET((byte)0x07),
    CONFIGURATION_REPORT((byte)0x08);

    private static final HashMap<Byte, EntryControlCommand> _map = new HashMap<Byte, EntryControlCommand>(8);
    static {
        for (EntryControlCommand value: EntryControlCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private EntryControlCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static EntryControlCommand valueOf(byte byteValue) {
        EntryControlCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static EntryControlCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

