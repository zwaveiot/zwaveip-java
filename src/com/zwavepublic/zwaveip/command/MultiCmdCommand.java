package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* MultiCmd commands (version 1) */
public enum MultiCmdCommand implements Command {
    ENCAP((byte)0x01);

    private static final HashMap<Byte, MultiCmdCommand> _map = new HashMap<Byte, MultiCmdCommand>(1);
    static {
        for (MultiCmdCommand value: MultiCmdCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private MultiCmdCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static MultiCmdCommand valueOf(byte byteValue) {
        MultiCmdCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MultiCmdCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

