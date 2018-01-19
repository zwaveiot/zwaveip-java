package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* AssociationGrpInfo commands (version 3) */
public enum AssociationGrpInfoCommand implements Command {
    ASSOCIATION_GROUP_NAME_GET((byte)0x01),
    ASSOCIATION_GROUP_NAME_REPORT((byte)0x02),
    ASSOCIATION_GROUP_INFO_GET((byte)0x03),
    ASSOCIATION_GROUP_INFO_REPORT((byte)0x04),
    ASSOCIATION_GROUP_COMMAND_LIST_GET((byte)0x05),
    ASSOCIATION_GROUP_COMMAND_LIST_REPORT((byte)0x06);

    private static final HashMap<Byte, AssociationGrpInfoCommand> _map = new HashMap<Byte, AssociationGrpInfoCommand>(6);
    static {
        for (AssociationGrpInfoCommand value: AssociationGrpInfoCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private AssociationGrpInfoCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static AssociationGrpInfoCommand valueOf(byte byteValue) {
        AssociationGrpInfoCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AssociationGrpInfoCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

