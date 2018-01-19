package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Association commands (version 2) */
public enum AssociationCommand implements Command {
    GET((byte)0x02),
    GROUPINGS_GET((byte)0x05),
    GROUPINGS_REPORT((byte)0x06),
    REMOVE((byte)0x04),
    REPORT((byte)0x03),
    SET((byte)0x01),
    SPECIFIC_GROUP_GET((byte)0x0b),
    SPECIFIC_GROUP_REPORT((byte)0x0c);

    private static final HashMap<Byte, AssociationCommand> _map = new HashMap<Byte, AssociationCommand>(8);
    static {
        for (AssociationCommand value: AssociationCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private AssociationCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static AssociationCommand valueOf(byte byteValue) {
        AssociationCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AssociationCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

