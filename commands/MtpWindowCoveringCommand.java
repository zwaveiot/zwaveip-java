package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* MtpWindowCovering commands (version 1) */
public enum MtpWindowCoveringCommand implements com.zwavepublic.zwaveip.commands.Command {
    MOVE_TO_POSITION_GET(0x02),
    MOVE_TO_POSITION_REPORT(0x03),
    MOVE_TO_POSITION_SET(0x01);

    private static final HashMap<Integer, MtpWindowCoveringCommand> _map = new HashMap<Integer, MtpWindowCoveringCommand>(3);
    static {
        for (MtpWindowCoveringCommand value: MtpWindowCoveringCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private MtpWindowCoveringCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static MtpWindowCoveringCommand valueOf(int intValue) {
        MtpWindowCoveringCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MtpWindowCoveringCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

