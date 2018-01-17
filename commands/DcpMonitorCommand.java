package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* DcpMonitor commands (version 1) */
public enum DcpMonitorCommand implements com.zwavepublic.zwaveip.commands.Command {
    DCP_EVENT_STATUS_GET(0x03),
    DCP_EVENT_STATUS_REPORT(0x04),
    DCP_LIST_GET(0x01),
    DCP_LIST_REPORT(0x02);

    private static final HashMap<Integer, DcpMonitorCommand> _map = new HashMap<Integer, DcpMonitorCommand>(4);
    static {
        for (DcpMonitorCommand value: DcpMonitorCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private DcpMonitorCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static DcpMonitorCommand valueOf(int intValue) {
        DcpMonitorCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static DcpMonitorCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

