package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* AvContentDirectoryMd commands (version 1) */
public enum AvContentDirectoryMdCommand implements com.zwavepublic.zwaveip.commands.Command {
    AV_CONTENT_BROWSE_MD_BY_LETTER_GET(0x03),
    AV_CONTENT_BROWSE_MD_BY_LETTER_REPORT(0x04),
    AV_CONTENT_BROWSE_MD_CHILD_COUNT_GET(0x05),
    AV_CONTENT_BROWSE_MD_CHILD_COUNT_REPORT(0x06),
    AV_CONTENT_BROWSE_MD_GET(0x01),
    AV_CONTENT_BROWSE_MD_REPORT(0x02),
    AV_MATCH_ITEM_TO_RENDERER_MD_GET(0x07),
    AV_MATCH_ITEM_TO_RENDERER_MD_REPORT(0x08);

    private static final HashMap<Integer, AvContentDirectoryMdCommand> _map = new HashMap<Integer, AvContentDirectoryMdCommand>(8);
    static {
        for (AvContentDirectoryMdCommand value: AvContentDirectoryMdCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private AvContentDirectoryMdCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static AvContentDirectoryMdCommand valueOf(int intValue) {
        AvContentDirectoryMdCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AvContentDirectoryMdCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

