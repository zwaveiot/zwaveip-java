package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* InclusionController commands (version 1) */
public enum InclusionControllerCommand implements com.zwavepublic.zwaveip.commands.Command {
    INITIATE(0x01),
    COMPLETE(0x02);

    private static final HashMap<Integer, InclusionControllerCommand> _map = new HashMap<Integer, InclusionControllerCommand>(2);
    static {
        for (InclusionControllerCommand value: InclusionControllerCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private InclusionControllerCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static InclusionControllerCommand valueOf(int intValue) {
        InclusionControllerCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static InclusionControllerCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

