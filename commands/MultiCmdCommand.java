package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* MultiCmd commands (version 1) */
public enum MultiCmdCommand implements com.zwavepublic.zwaveip.commands.Command {
    ENCAP(0x01);

    private static final HashMap<Integer, MultiCmdCommand> _map = new HashMap<Integer, MultiCmdCommand>(1);
    static {
        for (MultiCmdCommand value: MultiCmdCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private MultiCmdCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static MultiCmdCommand valueOf(int intValue) {
        MultiCmdCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MultiCmdCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

