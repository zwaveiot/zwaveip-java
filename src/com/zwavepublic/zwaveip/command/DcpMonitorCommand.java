package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* DcpMonitor commands (version 1) */
public enum DcpMonitorCommand implements Command {
    DCP_EVENT_STATUS_GET((byte)0x03),
    DCP_EVENT_STATUS_REPORT((byte)0x04),
    DCP_LIST_GET((byte)0x01),
    DCP_LIST_REPORT((byte)0x02);

    private static final HashMap<Byte, DcpMonitorCommand> _map = new HashMap<Byte, DcpMonitorCommand>(4);
    static {
        for (DcpMonitorCommand value: DcpMonitorCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private DcpMonitorCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static DcpMonitorCommand valueOf(byte byteValue) {
        DcpMonitorCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static DcpMonitorCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

