package seedu.address.ui;

import java.util.Optional;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.residency.Residency;
import seedu.address.model.room.Room;

/**
 * A UI component that displays information of a {@code Room}.
 */
public class RoomCard extends UiPart<Region> {

    private static final String FXML = "RoomListCard.fxml";

    public final Room room;
    public final Optional<Residency> residency;
    private final String testRoomNumber = "TES";
    private final String testRoomVacancy = "YENO";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    @FXML
    private HBox cardPane;

    @FXML
    private Label number;

    @FXML
    private Label vacancy;

    @FXML
    private Label id;

    @FXML
    private Label guestList;

    /**
     * Creates a {@code RoomCode} with the given {@code Room} and index to display.
     */
    public RoomCard(Room room, int displayedIndex, Optional<Residency> residency) {
        super(FXML);
        this.room = room;
        this.residency = residency;
        id.setText(displayedIndex + ". ");
        number.setText(room.getRoomNumber().value);
        vacancy.setText(room.getVacancy().toString());
        if (residency.isPresent()) {
            guestList.setText(residency.get().getGuests()
                    .stream()
                    .map(guest -> guest.getName().toString())
                            .collect(Collectors.toUnmodifiableList())
                    .toString());
        } else {
            guestList.setText("None");
        }
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RoomCard)) {
            return false;
        }

        // state check
        RoomCard card = (RoomCard) other;
        return id.getText().equals(card.id.getText())
                && room.equals(card.room);
    }
}
