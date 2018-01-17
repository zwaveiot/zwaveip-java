package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* DcpConfig commands (version 1) */
public enum DcpConfigCommand implements com.zwavepublic.zwaveip.commands.Command {
    DCP_LIST_REMOVE(0x04),
    DCP_LIST_SET(0x03),
    DCP_LIST_SUPPORTED_GET(0x01),
    DCP_LIST_SUPPORTED_REPORT(0x02);

    private static final HashMap<Integer, DcpConfigCommand> _map = new HashMap<Integer, DcpConfigCommand>(4);
    static {
        for (DcpConfigCommand value: DcpConfigCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private DcpConfigCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static DcpConfigCommand valueOf(int intValue) {
        DcpConfigCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static DcpConfigCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

