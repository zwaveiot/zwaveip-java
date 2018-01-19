package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SwitchColor commands (version 3) */
public enum SwitchColorCommand implements Command {
    SUPPORTED_GET((byte)0x01),
    SUPPORTED_REPORT((byte)0x02),
    GET((byte)0x03),
    REPORT((byte)0x04),
    SET((byte)0x05),
    START_LEVEL_CHANGE((byte)0x06),
    STOP_LEVEL_CHANGE((byte)0x07);

    private static final HashMap<Byte, SwitchColorCommand> _map = new HashMap<Byte, SwitchColorCommand>(7);
    static {
        for (SwitchColorCommand value: SwitchColorCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SwitchColorCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SwitchColorCommand valueOf(byte byteValue) {
        SwitchColorCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SwitchColorCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

