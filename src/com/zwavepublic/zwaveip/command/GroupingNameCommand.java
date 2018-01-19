package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* GroupingName commands (version 1) */
public enum GroupingNameCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01);

    private static final HashMap<Byte, GroupingNameCommand> _map = new HashMap<Byte, GroupingNameCommand>(3);
    static {
        for (GroupingNameCommand value: GroupingNameCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private GroupingNameCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static GroupingNameCommand valueOf(byte byteValue) {
        GroupingNameCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static GroupingNameCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

