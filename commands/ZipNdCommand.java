package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ZipNd commands (version 1) */
public enum ZipNdCommand implements com.zwavepublic.zwaveip.commands.Command {
    ZIP_NODE_SOLICITATION(0x03),
    ZIP_INV_NODE_SOLICITATION(0x04),
    ZIP_NODE_ADVERTISEMENT(0x01);

    private static final HashMap<Integer, ZipNdCommand> _map = new HashMap<Integer, ZipNdCommand>(3);
    static {
        for (ZipNdCommand value: ZipNdCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ZipNdCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ZipNdCommand valueOf(int intValue) {
        ZipNdCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ZipNdCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

