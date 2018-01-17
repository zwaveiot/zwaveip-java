package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* TransportService commands (version 2) */
public enum TransportServiceCommand implements com.zwavepublic.zwaveip.commands.Command {
    COMMAND_FIRST_SEGMENT(0xc0),
    COMMAND_SEGMENT_COMPLETE(0xe8),
    COMMAND_SEGMENT_REQUEST(0xc8),
    COMMAND_SEGMENT_WAIT(0xf0),
    COMMAND_SUBSEQUENT_SEGMENT(0xe0);

    private static final HashMap<Integer, TransportServiceCommand> _map = new HashMap<Integer, TransportServiceCommand>(5);
    static {
        for (TransportServiceCommand value: TransportServiceCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private TransportServiceCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static TransportServiceCommand valueOf(int intValue) {
        TransportServiceCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static TransportServiceCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

