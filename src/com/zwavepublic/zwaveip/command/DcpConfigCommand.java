package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* DcpConfig commands (version 1) */
public enum DcpConfigCommand implements Command {
    DCP_LIST_REMOVE((byte)0x04),
    DCP_LIST_SET((byte)0x03),
    DCP_LIST_SUPPORTED_GET((byte)0x01),
    DCP_LIST_SUPPORTED_REPORT((byte)0x02);

    private static final HashMap<Byte, DcpConfigCommand> _map = new HashMap<Byte, DcpConfigCommand>(4);
    static {
        for (DcpConfigCommand value: DcpConfigCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private DcpConfigCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static DcpConfigCommand valueOf(byte byteValue) {
        DcpConfigCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static DcpConfigCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

