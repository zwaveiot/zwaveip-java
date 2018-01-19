package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* AvContentDirectoryMd commands (version 1) */
public enum AvContentDirectoryMdCommand implements Command {
    AV_CONTENT_BROWSE_MD_BY_LETTER_GET((byte)0x03),
    AV_CONTENT_BROWSE_MD_BY_LETTER_REPORT((byte)0x04),
    AV_CONTENT_BROWSE_MD_CHILD_COUNT_GET((byte)0x05),
    AV_CONTENT_BROWSE_MD_CHILD_COUNT_REPORT((byte)0x06),
    AV_CONTENT_BROWSE_MD_GET((byte)0x01),
    AV_CONTENT_BROWSE_MD_REPORT((byte)0x02),
    AV_MATCH_ITEM_TO_RENDERER_MD_GET((byte)0x07),
    AV_MATCH_ITEM_TO_RENDERER_MD_REPORT((byte)0x08);

    private static final HashMap<Byte, AvContentDirectoryMdCommand> _map = new HashMap<Byte, AvContentDirectoryMdCommand>(8);
    static {
        for (AvContentDirectoryMdCommand value: AvContentDirectoryMdCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private AvContentDirectoryMdCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static AvContentDirectoryMdCommand valueOf(byte byteValue) {
        AvContentDirectoryMdCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AvContentDirectoryMdCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

