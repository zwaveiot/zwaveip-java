package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* MtpWindowCovering commands (version 1) */
public enum MtpWindowCoveringCommand implements Command {
    MOVE_TO_POSITION_GET((byte)0x02),
    MOVE_TO_POSITION_REPORT((byte)0x03),
    MOVE_TO_POSITION_SET((byte)0x01);

    private static final HashMap<Byte, MtpWindowCoveringCommand> _map = new HashMap<Byte, MtpWindowCoveringCommand>(3);
    static {
        for (MtpWindowCoveringCommand value: MtpWindowCoveringCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private MtpWindowCoveringCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static MtpWindowCoveringCommand valueOf(byte byteValue) {
        MtpWindowCoveringCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MtpWindowCoveringCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

