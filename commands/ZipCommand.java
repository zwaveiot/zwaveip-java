package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Zip commands (version 3) */
public enum ZipCommand implements com.zwavepublic.zwaveip.commands.Command {
    COMMAND_ZIP_PACKET(0x02);

    private static final HashMap<Integer, ZipCommand> _map = new HashMap<Integer, ZipCommand>(1);
    static {
        for (ZipCommand value: ZipCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ZipCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ZipCommand valueOf(int intValue) {
        ZipCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ZipCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

