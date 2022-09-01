package duke;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task implements Serializable {
    private LocalDateTime dueDate;

    /**
     * Constructor to create a new duke.Deadline
     *
     * @param task    the task that you want to complete (String)
     * @param dueDate the dueDate for this deadline (String)
     */
    public Deadline(String task, String dueDate) throws DukeException {
        super(task);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            this.dueDate = LocalDateTime.parse(dueDate, formatter);
        } catch (DateTimeParseException e) {
            throw new DukeException("Date Format Incorrect: yyyy-MM-dd HH:mm");
        }
    }

    /**
     * To String method that returns the task in string form to the user
     *
     * @return the task in string format
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        return "[D] " + super.toString() + " (by: " + this.dueDate.format(formatter) + ")";
    }
}