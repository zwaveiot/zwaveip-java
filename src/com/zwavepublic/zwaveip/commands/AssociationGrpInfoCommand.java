package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* AssociationGrpInfo commands (version 3) */
public enum AssociationGrpInfoCommand implements com.zwavepublic.zwaveip.commands.Command {
    ASSOCIATION_GROUP_NAME_GET(0x01),
    ASSOCIATION_GROUP_NAME_REPORT(0x02),
    ASSOCIATION_GROUP_INFO_GET(0x03),
    ASSOCIATION_GROUP_INFO_REPORT(0x04),
    ASSOCIATION_GROUP_COMMAND_LIST_GET(0x05),
    ASSOCIATION_GROUP_COMMAND_LIST_REPORT(0x06);

    private static final HashMap<Integer, AssociationGrpInfoCommand> _map = new HashMap<Integer, AssociationGrpInfoCommand>(6);
    static {
        for (AssociationGrpInfoCommand value: AssociationGrpInfoCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private AssociationGrpInfoCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static AssociationGrpInfoCommand valueOf(int intValue) {
        AssociationGrpInfoCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AssociationGrpInfoCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

