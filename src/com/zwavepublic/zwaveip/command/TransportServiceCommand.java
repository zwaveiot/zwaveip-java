package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* TransportService commands (version 2) */
public enum TransportServiceCommand implements Command {
    COMMAND_FIRST_SEGMENT((byte)0xc0),
    COMMAND_SEGMENT_COMPLETE((byte)0xe8),
    COMMAND_SEGMENT_REQUEST((byte)0xc8),
    COMMAND_SEGMENT_WAIT((byte)0xf0),
    COMMAND_SUBSEQUENT_SEGMENT((byte)0xe0);

    private static final HashMap<Byte, TransportServiceCommand> _map = new HashMap<Byte, TransportServiceCommand>(5);
    static {
        for (TransportServiceCommand value: TransportServiceCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private TransportServiceCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static TransportServiceCommand valueOf(byte byteValue) {
        TransportServiceCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static TransportServiceCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

