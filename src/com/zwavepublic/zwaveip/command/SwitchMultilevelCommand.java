package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SwitchMultilevel commands (version 4) */
public enum SwitchMultilevelCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01),
    START_LEVEL_CHANGE((byte)0x04),
    STOP_LEVEL_CHANGE((byte)0x05),
    SUPPORTED_GET((byte)0x06),
    SUPPORTED_REPORT((byte)0x07);

    private static final HashMap<Byte, SwitchMultilevelCommand> _map = new HashMap<Byte, SwitchMultilevelCommand>(7);
    static {
        for (SwitchMultilevelCommand value: SwitchMultilevelCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SwitchMultilevelCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SwitchMultilevelCommand valueOf(byte byteValue) {
        SwitchMultilevelCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SwitchMultilevelCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

