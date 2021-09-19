package seedu.address.commons.core.listtype;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class ListType {
    private static final String ROOMS = "rooms";
    private static final String GUESTS = "guests";
    public static final String MESSAGE_CONSTRAINTS = "List types should be 'rooms' or 'guests'.";
    private String type;

    public ListType(String type) {
        requireNonNull(type);
        checkArgument(isValidListType(type), MESSAGE_CONSTRAINTS);
        this.type = type;
    }

    /**
     * Returns true if a given string is a valid list type.
     */
    public static boolean isValidListType(String type) {
        return type.equals(ROOMS) || type.equals(GUESTS);
    }

    /**
     * Returns true if the ListType is a GUESTS type.
     */
    public boolean isGuestsType() {
        return this.type.equals("guests");
    }
}