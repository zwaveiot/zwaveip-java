package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* InclusionController commands (version 1) */
public enum InclusionControllerCommand implements Command {
    INITIATE((byte)0x01),
    COMPLETE((byte)0x02);

    private static final HashMap<Byte, InclusionControllerCommand> _map = new HashMap<Byte, InclusionControllerCommand>(2);
    static {
        for (InclusionControllerCommand value: InclusionControllerCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private InclusionControllerCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static InclusionControllerCommand valueOf(byte byteValue) {
        InclusionControllerCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static InclusionControllerCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

