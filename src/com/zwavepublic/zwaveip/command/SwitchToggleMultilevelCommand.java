package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SwitchToggleMultilevel commands (version 1) */
public enum SwitchToggleMultilevelCommand implements Command {
    SET((byte)0x01),
    GET((byte)0x02),
    REPORT((byte)0x03),
    START_LEVEL_CHANGE((byte)0x04),
    STOP_LEVEL_CHANGE((byte)0x05);

    private static final HashMap<Byte, SwitchToggleMultilevelCommand> _map = new HashMap<Byte, SwitchToggleMultilevelCommand>(5);
    static {
        for (SwitchToggleMultilevelCommand value: SwitchToggleMultilevelCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SwitchToggleMultilevelCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SwitchToggleMultilevelCommand valueOf(byte byteValue) {
        SwitchToggleMultilevelCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SwitchToggleMultilevelCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

