package seedu.address.ui;

import java.util.Optional;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.residency.Residency;
import seedu.address.model.room.Room;

/**
 * Panel containing the list of rooms.
 */
public class RoomListPanel extends UiPart<Region> {
    private static final String FXML = "RoomListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(RoomListPanel.class);
    private ReadOnlyAddressBook addressBook;

    @FXML
    private ListView<Room> roomListView;

    /**
     * Creates a {@code RoomListPanel} with the given {@code ObservableList}.
     */
    public RoomListPanel(ObservableList<Room> roomList, ReadOnlyAddressBook addressBook) {
        super(FXML);
        this.addressBook = addressBook;
        roomListView.setItems(roomList);
        roomListView.setCellFactory(listView -> new RoomListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Room} using a {@code RoomCard}.
     */
    class RoomListViewCell extends ListCell<Room> {
        @Override
        protected void updateItem(Room room, boolean empty) {
            super.updateItem(room, empty);

            if (empty || room == null) {
                setGraphic(null);
                setText(null);
            } else {
                Optional<Residency> roomResidency = addressBook.getResidency(room);
                setGraphic(new RoomCard(room, getIndex() + 1, roomResidency).getRoot());
            }
        }
    }

}
