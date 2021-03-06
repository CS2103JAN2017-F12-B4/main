package seedu.bulletjournal.logic;

import javafx.collections.ObservableList;
import seedu.bulletjournal.logic.commands.CommandResult;
import seedu.bulletjournal.logic.commands.exceptions.CommandException;
import seedu.bulletjournal.model.Model;
import seedu.bulletjournal.model.task.ReadOnlyTask;
import seedu.bulletjournal.storage.Storage;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     *
     * @param commandText
     *            The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException
     *             If an error occurs during command execution.
     */
    CommandResult execute(String commandText) throws CommandException;

    /** Returns the filtered list of tasks */
    ObservableList<ReadOnlyTask> getFilteredTaskList();

    ObservableList<ReadOnlyTask> getUndoneTaskList();

    String getCommandText();

    void init(Model model, Storage storage);

}
